package linkedlist.circularlinkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedList.Node;

public class CircularLinkedListHelper {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);

        CircularLinkedListHelper helper = new CircularLinkedListHelper();
        System.out.println("Is the list circular?: " + helper.isCircular(linkedList.head));
        System.out.println("Making the list circular...");
        linkedList.head = helper.convertToCircularLinkedList(linkedList.head);
        System.out.println("Is the list circular?: " + helper.isCircular(linkedList.head));
        System.out.println("No. of nodes in circular list: " + helper.getNoOfNodesInCircularList(linkedList.head));
    }

    /**
     * Check if the given linkedlist is circular or not
     * 
     * Idea is to check if some node's next is head itself
     * 
     * @param head head node of linkedList
     * @return TRUE if circular else FALSE
     */
    private boolean isCircular(Node head) {
        // Treating the linked list as circular if it is empty
        if (head == null) {
            return true;
        }
        Node headNode = head; // Storing head

        // Loop untill the nextNode is not the head
        while (headNode.nextNode != null && headNode.nextNode != head) {
            headNode = headNode.nextNode;
        }
        return headNode.nextNode == head;
    }

    /**
     * Get number of nodes avaialable in circular linked list
     * 
     * @param headNode head node of list
     * @return number of nodes
     */
    private int getNoOfNodesInCircularList(Node headNode) {
        if (headNode == null) {
            return 0;
        }
        int count = 0;
        Node currNode = headNode;
        while (currNode.nextNode != null) {
            currNode = currNode.nextNode;
            count++;
            // Break the loop if the current node is head itself
            if (currNode == headNode) {
                break;
            }
        }
        return count;
    }

    /**
     * Make the single linkedlist to circular linked list
     * 
     * Idea is to traverse till last node and set the last node's next
     * to the head node
     * 
     * @param head head node of linked list
     * @return circular linked list
     */
    private Node convertToCircularLinkedList(Node head) {
        if (head == null) {
            return head;
        }

        Node startNode = head;
        // Make sure that list is not already circular, otherwise the loop will be
        // infinite `head.nextNode != startNode` will check that
        while (head.nextNode != null && head.nextNode != startNode) {
            head = head.nextNode;
        }
        head.nextNode = startNode;
        return startNode;
    }
}
