package test.pers.jack.tree;

import static pers.jack.tree.SerializeAndReconstructTree.*;

import org.junit.Test;

public class TestSerializeAndReconstructTree {
    @Test
    public void testSerializeAndReconstrucTree() {
        		Node head = null;
		printTree(head);

		String pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		String level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");

		head = new Node(1);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");

		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");

		head = new Node(100);
		head.left = new Node(21);
		head.left.left = new Node(37);
		head.right = new Node(-42);
		head.right.left = new Node(0);
		head.right.right = new Node(666);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");
    }
}
