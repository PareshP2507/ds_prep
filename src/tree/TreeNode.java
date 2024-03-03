package tree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(data);
        builder.append("[Left: ");
        if (left == null) {
            builder.append("NULL");
        } else {
            builder.append(left.toString());
        }
        builder.append(" Right: ");
        if (right == null) {
            builder.append("NULL");
        } else {
            builder.append(right.toString());
        }
        builder.append("]");
        return builder.toString();
    }
}
