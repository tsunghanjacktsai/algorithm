package pers.jack.tree;

import java.util.*;
import java.util.Map.*;

public class BuildingOutline {
    public static class Node {
        public boolean isUp;
        public int pos;
        public int h;

        public Node(boolean isUp, int pos, int h) {
            this.isUp = isUp;
            this.pos = pos;
            this.h = h;
        }
    }

    public static class NodeComarator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.pos != o2.pos) {
                return o1.pos - o2.pos;
            }
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(nodes, new NodeComarator());
        TreeMap<Integer, Integer> htMap = new TreeMap<>(); // 高度
        TreeMap<Integer, Integer> pmMap = new TreeMap<>(); // 收集每個位置的最大高度
        for (int i = 0; i < nodes.length; i++) {
            // 判斷之前是否出現這個高度
            if (nodes[i].isUp) {
                if (!htMap.containsKey(nodes[i].h)) {
                    htMap.put(nodes[i].h, 1);
                } else {
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            } else {
                if (htMap.containsKey(nodes[i].h)) {
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].pos, 0);
            } else {
                pmMap.put(nodes[i].pos, htMap.lastKey());
            }
        }
        //生成輪廓線
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPos = entry.getKey();
            int curMaxHeight = entry.getValue();
            // 重建最大高度
            if (height != curMaxHeight) {
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<Integer>();
                    newRecord.add(start);
                    newRecord.add(curPos);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPos;
                height = curMaxHeight;
            }
        }
        return res;
    }
}
