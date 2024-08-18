package tree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(data);
        builder.append(" [");
        if (left != null) {
            builder.append(left.toString());
        }
        builder.append(",");
        if (right != null) {
            builder.append(right.toString());
        }
        builder.append("]");
        return builder.toString();
    }
}
