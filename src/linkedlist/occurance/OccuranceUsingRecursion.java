package linkedlist.occurance;

import linkedlist.LinkedList.Node;

/**
 * Calculates occurance of given value in LinkedList
 * Idea is to use a recursion to traverse through the list, increse counter
 * by one if the given element is found
 * 
 * Time complexity O(n)
 * Space complexity O(n)
 */
public class OccuranceUsingRecursion implements IOccurance {

    @Override
    public int findOccurance(Node head, int data) {
        Node currNode = head;
        return calculateOccurance(0, currNode, data);
    }

    private int calculateOccurance(int currFreq, Node head, int data) {
        if (head == null) {
            return currFreq;
        }
        if (head.data == data) {
            currFreq++;
        }
        return calculateOccurance(currFreq, head.nextNode, data);
    }
}
