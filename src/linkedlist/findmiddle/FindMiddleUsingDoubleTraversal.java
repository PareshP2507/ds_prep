package linkedlist.findmiddle;

import linkedlist.LinkedList.Node;

/**
 * Idea is to first traverse the linked list to count the number of
 * nodes and then traverse the list list again count/2 number of times
 * 
 * Time complexity = O(n)
 * Space complexity = O(n)
 */
public class FindMiddleUsingDoubleTraversal implements FindMiddle {

    @Override
    public Node findMiddle(Node head) {
        int count = 0;
        Node middle = head;

        while (head != null) {
            head = head.nextNode;
            count++;
        }

        int index = 0;
        while (index < (count/2)) {
            middle = middle.nextNode;
            index++;
        }
        return middle;
    }
}