package linkedlist.occurance;

import linkedlist.LinkedList;

public class OccuranceCalculator {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(10);
        linkedList.insert(50);
        linkedList.insert(10);

        System.out.println("Linked list: " + linkedList.head);
        System.out.println("-------------");

        System.out.println("Normal calculation");
        IOccurance occurance = new OccuranceNormal();
        System.out.println("No. of 10 in list is: " + occurance.findOccurance(linkedList.head, 10));

        System.out.println("Using recursion");
        occurance = new OccuranceUsingRecursion();
        System.out.println("No. of 10 in list is: " + occurance.findOccurance(linkedList.head, 10));
    }
}
