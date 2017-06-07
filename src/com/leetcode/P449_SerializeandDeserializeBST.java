package com.leetcode;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P449_SerializeandDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {return "N";}
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        String[] ss = data.split(",");
        for (int i = 0; i < ss.length; i++) {
            root = insert(root, ss[i]);
        }

        return root;
    }

    private TreeNode insert(TreeNode root, String s) {
        if (s.charAt(0) == 'N') {return root;}
        if (root == null) {
            root = new TreeNode(Integer.parseInt(s));
            return root;
        }

        int val = Integer.parseInt(s);
        if (val < root.val) {
            root.left = insert(root.left, s);
        } else {
            root.right = insert(root.right, s);
        }

        return root;
    }

    public static void main(String[] args) {
        P449_SerializeandDeserializeBST obj = new P449_SerializeandDeserializeBST();

        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        System.out.println(obj.serialize(t1));
        TreeNode root = obj.deserialize(obj.serialize(t1));
        System.out.println();

    }

}
