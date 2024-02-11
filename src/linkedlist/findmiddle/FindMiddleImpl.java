package linkedlist.findmiddle;

import linkedlist.LinkedList;
import linkedlist.LinkedList.Node;

public class FindMiddleImpl {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);

        System.out.println("Linked list: " + linkedList.head);
        System.out.println("-------------");

        FindMiddleImpl findMiddle = new FindMiddleImpl();
        findMiddle.findMiddle(linkedList.head);

        System.out.println("-------------");
        linkedList.insert(60);
        findMiddle.findMiddle(linkedList.head);
    }

    public void findMiddle(Node node) {
        FindMiddle middleFinder = new FindMiddleUsingDoubleTraversal();
        System.out.println("Middle using double traversal: " + middleFinder.findMiddle(node).data);

        middleFinder = new FindMiddleUsingSingleTraversal();
        System.out.println("Middle using single traversal: " + middleFinder.findMiddle(node).data);

        middleFinder = new FindMiddleUsingSlowFastPointers();
        System.out.println("Middle using slow-fast traversal: " + middleFinder.findMiddle(node).data);
    }
}
