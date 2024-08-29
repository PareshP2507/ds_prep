package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(11);
        bst.insert(5);
        bst.insert(6);
        bst.insert(8);
        bst.insert(22);
        bst.insert(1);
        bst.insert(3);

        TreeNode root = bst.getRootNode();
        System.out.println("Root node: " +root);

        Bfs lot = new Bfs();
        System.out.println(lot.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> currLevelList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                currLevelList.add(queue.poll().data);
            }
            result.add(currLevelList);
        }

        return result;
    }
}
