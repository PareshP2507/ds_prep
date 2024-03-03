package tree;

public interface Tree {
    /**
     * Insert data into Tree
     * 
     * @param data a data to be inserted
     */
    void insert(int data);

    /**
     * Get root node of Tree
     * 
     * @return root node
     */
    TreeNode getRootNode();

    /**
     * Prints elemments in in-order traversal
     * 
     * Order in in-order traversal is Left-Root-Right
     */
    void inOrderTraversal();

    /**
     * Prints elemments in pre-order traversal
     * 
     * Order in pre-order traversal is Root-Left-Right
     */
    void preOrderTraversal();

    /**
     * Prints elemments in post-order traversal
     * 
     * Order in post-order traversal is Left-Right-Root
     */
    void postOrderTraversal();
}
