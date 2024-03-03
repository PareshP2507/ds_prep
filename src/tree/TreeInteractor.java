package tree;

public class TreeInteractor {
    public static void main(String[] args) {
        Tree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(7);
        bst.insert(10);
        bst.insert(11);
        bst.insert(5);
        bst.insert(100);

        System.out.print("In-order: ");
        bst.inOrderTraversal();
        System.out.println();
        System.out.print("Pre-order: ");
        bst.preOrderTraversal();
        System.out.println();
        System.out.print("Post-order: ");
        bst.postOrderTraversal();        
    }
}
