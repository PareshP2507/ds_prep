package linkedlist.reverse;

import linkedlist.LinkedList.Node;

public class LinkedListReverser {

    /**
     * Reverse the linked list
     * 
     * @param head head node of the linked list
     * @return reversed linked list
     */
    public Node reverse(Node head) {
        Node prev = null;
        Node currNode = head;

        while (currNode != null) {
            Node temp = currNode.nextNode;
            currNode.nextNode = prev;
            prev = currNode;
            currNode = temp;
        }
        return prev;
    }
}
