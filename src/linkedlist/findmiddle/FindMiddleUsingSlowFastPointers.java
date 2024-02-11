package linkedlist.findmiddle;

import linkedlist.LinkedList.Node;

/**
 * The idea is to create two pointer among which one will traverse at the double speed 
 * than the other one. By the time the fast pointer will move at the end, slow pointer
 * will reach at middle.
 * 
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class FindMiddleUsingSlowFastPointers implements FindMiddle {

    @Override
    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow;
    }
    
}
