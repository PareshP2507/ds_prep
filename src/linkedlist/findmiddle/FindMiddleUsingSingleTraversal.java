package linkedlist.findmiddle;

import linkedlist.LinkedList.Node;

/**
 * We can track the count of nodes and middle of the node in a single traversal
 * Idea is to to shift the middle pointer to next every even count
 * 
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class FindMiddleUsingSingleTraversal implements FindMiddle {

    @Override
    public Node findMiddle(Node head) {
        Node middle = head;
        int count = 0;

        while (head.nextNode != null) {
            if (count % 2 == 0) {
                middle = middle.nextNode;
            }
            count++;
            head = head.nextNode;
        }
        return middle;
    }
}
