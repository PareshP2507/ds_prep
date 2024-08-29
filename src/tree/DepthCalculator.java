package tree;

public class DepthCalculator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DepthCalculator depthCalculator = new DepthCalculator();
        System.out.println("Depth: " + depthCalculator.calcualteDepthOf(root));
    }

    /**
     * Idea here is to check the height of subtree and add 1 into it.
     * @param root root node of tree
     * @return height of given tree
     */
    public int calcualteDepthOf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = calcualteDepthOf(root.left);
        int rh = calcualteDepthOf(root.right);

        return 1 + Math.max(lh, rh);
    }
}
