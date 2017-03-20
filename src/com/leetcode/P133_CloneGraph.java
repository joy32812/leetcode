package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 18/03/2017.
 */

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class P133_CloneGraph {

    private Map<Integer, UndirectedGraphNode> visit;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        visit = new HashMap<Integer, UndirectedGraphNode>();

        return clone(node);
    }


    public UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {return null;}
        if (visit.containsKey(node.label)) {return visit.get(node.label);}

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        visit.put(root.label, root);

        List<UndirectedGraphNode> neighbors = node.neighbors;
        if (neighbors != null) {
            for (UndirectedGraphNode now : neighbors) {
                UndirectedGraphNode nn = clone(now);
                root.neighbors.add(nn);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        UndirectedGraphNode root = new UndirectedGraphNode(0);
        root.neighbors.add(root);
        root.neighbors.add(root);

        System.out.println(new P133_CloneGraph().cloneGraph(root));
    }
}
