package tree;

/**
 * Binary Seach Tree or commonly known as BST is a special type
 * of tree in which smaller element will be at the left side of
 * the root node and bigger elements will be at the right side
 * of root node.
 * 
 * The following class explains how the BST is constructed along
 * with traversal methods.
 */
public class BinarySearchTree implements Tree {

    private TreeNode root;

    private TreeNode insertNode(TreeNode rootNode, int data) {
        if (rootNode == null) {
            rootNode = new TreeNode(data);
        } else if (data < rootNode.data) {
            rootNode.left = insertNode(rootNode.left, data);
        } else if (data > rootNode.data) {
            rootNode.right = insertNode(rootNode.right, data);
        }
        return rootNode;
    }

    @Override
    public void insert(int data) {
        root = insertNode(root, data);
    }

    @Override
    public TreeNode getRootNode() {
        return root;
    }

    @Override
    public void inOrderTraversal() {
        inOrderInternal(root);
    }

    @Override
    public void preOrderTraversal() {
        preOrderInternal(root);
    }

    @Override
    public void postOrderTraversal() {
        postOrderInternal(root);
    }

    private void inOrderInternal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderInternal(root.left);
        System.out.print(root.data + " ");
        inOrderInternal(root.right);
    }

    private void preOrderInternal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderInternal(root.left);
        preOrderInternal(root.right);
    }

    private void postOrderInternal(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderInternal(root.left);
        postOrderInternal(root.right);
        System.out.print(root.data + " ");
    }
}
