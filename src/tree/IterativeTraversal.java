package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Example Tree:
 * 
 *        1
 *       / \ 
 *      2   3
 *     / \
 *    4   5
 *       / \
 *      6   7
 */
public class IterativeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        System.out.println("Root node: ");
        System.out.println(root);

        IterativeTraversal iterativeTraversal = new IterativeTraversal();

        System.out.println("Iterative pre-order traversal: ");
        System.out.println(iterativeTraversal.preOrder(root));

        System.out.println("Iterative in-order traversal: ");
        System.out.println(iterativeTraversal.inOrder(root));

        System.out.println("Iterative post-order traversal: ");
        System.out.println(iterativeTraversal.postOrder(root));
    }

    /**
     * Returns a list containing pre-order traversal
     * @param root root node
     * @return list containing elements by pre-order traversal
     * 
     * Considering the example tree in the class Javadoc comment,
     * the result would be a - [1, 2, 4, 5, 6, 7, 3]
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
            result.add(currNode.data);
        }
        
        return result;
    }

    /**
     * Returns a list containing in-order traversal
     * @param root root node
     * @return list containing elements by in-order traversal
     * 
     * Considering the example tree in the class Javadoc comment,
     * the result would be a - [4, 2, 6, 5, 7, 1, 3]
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (true) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                currNode = stack.pop();
                result.add(currNode.data);
                currNode = currNode.right;
            }
        }
        
        return result;
    }

    /**
     * Returns a list containing post-order traversal
     * @param root root node
     * @return list containing elements by ppost-order traversal
     * 
     * Considering the example tree in the class Javadoc comment,
     * the result would be a - [4, 6, 7, 5, 2, 3, 1]
     */
    public List<Integer> postOrder(TreeNode root) {        
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode currNode = stack1.pop();
            stack2.push(currNode);
            if (currNode.left != null) {
                stack1.push(currNode.left);
            }
            if (currNode.right != null) {
                stack1.push(currNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().data);
        }
        
        return result;
    }
}
