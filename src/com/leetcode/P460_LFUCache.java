package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by xiaoyuan on 09/07/2017.
 */
public class P460_LFUCache {


    Map<Integer, Integer> valMap;
    Map<Integer, Integer> freqMap;

    Map<Integer, KeyNode> key2NodeMap;
    Map<Integer, Bucket> freq2BucketMap;

    private class KeyNode {
        int key;

        public KeyNode(int key) {
            this.key = key;
        }
    }

    private class Bucket {
        int freq;
        LinkedList<KeyNode> linkedList;

        Bucket prev, next;

        public Bucket(int freq) {
            this.freq = freq;
            this.linkedList = new LinkedList<>();
        }
    }

    Bucket head;
    Bucket tail;

    int CAP;


    public P460_LFUCache(int capacity) {
        valMap = new HashMap<>();
        freqMap = new HashMap<>();

        key2NodeMap = new HashMap<>();
        freq2BucketMap = new HashMap<>();

        head = new Bucket(0);
        tail = new Bucket(0);

        head.next = tail;
        tail.prev = head;


        CAP = capacity;
    }

    public int get(int key) {
        if (CAP == 0) {return -1;}
        if (!valMap.containsKey(key)) {return -1;}
        int val = valMap.get(key);


        addFreq(key, val);

        return val;
    }

    private void addFreq(int key, int val) {
        int freq = freqMap.get(key);
        valMap.put(key, val);
        freqMap.put(key, freq + 1);

        Bucket oldBucket = freq2BucketMap.get(freq);
        Bucket prevBucket = oldBucket.prev;
        Bucket nextBucket = oldBucket.next;

        // femove from oldBucket
        KeyNode keyNode = key2NodeMap.get(key);
        oldBucket.linkedList.remove(keyNode);
        if (oldBucket.linkedList.size() == 0) {
            Bucket now = oldBucket;

            Bucket prev = now.prev;
            Bucket next = now.next;

            prev.next = next;
            next.prev = prev;
            freq2BucketMap.remove(freq);
        } else {
            prevBucket = oldBucket;
        }

        // add to newBucket

        if (nextBucket.freq == freq + 1) {
            nextBucket.linkedList.addLast(keyNode);
            return;
        }

        Bucket newBucket = new Bucket(freq + 1);
        newBucket.linkedList.addLast(keyNode);

        prevBucket.next = newBucket;

        newBucket.prev = prevBucket;
        newBucket.next = nextBucket;

        nextBucket.prev = newBucket;

        freq2BucketMap.put(freq + 1, newBucket);
    }

    public void put(int key, int value) {
        if (CAP == 0) {return;}

        if (!valMap.containsKey(key)) {
            // if full
            if (CAP == valMap.size()) {
                int delKey = head.next.linkedList.getFirst().key;

                delKey(delKey);
            }
            addKey(key, value);
        } else {
            addFreq(key, value);
        }
    }

    private void addKey(int key, int value) {
        int freq = 1;

        valMap.put(key, value);
        freqMap.put(key, freq);

        if (freq2BucketMap.containsKey(freq)) {
            Bucket now = freq2BucketMap.get(freq);

            KeyNode keyNode = new KeyNode(key);
            key2NodeMap.put(key, keyNode);

            now.linkedList.addLast(keyNode);
        } else {
            Bucket now = new Bucket(freq);

            KeyNode keyNode = new KeyNode(key);
            key2NodeMap.put(key, keyNode);

            now.linkedList.addLast(keyNode);



            Bucket prev = head;
            Bucket next = head.next;

            prev.next = now;

            now.prev = prev;
            now.next = next;

            next.prev = now;

            freq2BucketMap.put(freq, now);
        }
    }

    private void delKey(int delKey) {
        int freq = freqMap.get(delKey);

        valMap.remove(delKey);
        freqMap.remove(delKey);

        Bucket now = freq2BucketMap.get(freq);

        KeyNode keyNode = key2NodeMap.get(delKey);
        key2NodeMap.remove(delKey);

        now.linkedList.remove(keyNode);

        if (now.linkedList.size() == 0) {
            Bucket prev = now.prev;
            Bucket next = now.next;

            prev.next = next;
            next.prev = prev;
            freq2BucketMap.remove(freq);
        }
    }

    public static void main(String[] args) {

        P460_LFUCache obj = new P460_LFUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);

        System.out.println(obj.get(1));
        System.out.println(obj.get(2));

        obj.put(3, 3);
        obj.put(4, 4);

        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

    }


}
