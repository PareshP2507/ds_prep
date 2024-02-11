package linkedlist.occurance;

import linkedlist.LinkedList.Node;

/**
 * Calculates occurance of given value in LinkedList
 * Idea is to traverse through all the linkedList and increase a count
 * when value is found.
 * 
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class OccuranceNormal implements IOccurance {

    @Override
    public int findOccurance(Node head, int data) {
        int freq = 0;

        Node currNode = head;
        while (currNode != null) {
            if (currNode.data == data) {
                freq++;
            }
            currNode = currNode.nextNode;
        }

        return freq;
    }
}