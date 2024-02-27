package linkedlist;

import linkedlist.reverse.LinkedListReverser;

public class LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30); // [10, 20, 30]
        list.insertAt(1, 11); // [10, 11, 20, 30]
        list.insertAt(3, 15); // [10, 11, 20, 15, 30]
        list.insertAt(4, 40); // [10, 11, 20, 15, 40, 30]
        list.insertAt(6, 50); // [10, 11, 20, 15, 40, 30, 50]

        System.out.println("Given linked list:");
        System.out.println(list.head.toString());

        // Reversing the list
        Node headNode = list.reverse(list.head);
        System.out.println("Reversed linked list:");
        System.out.println(headNode.toString());
    }

    public Node head = null;

    /**
     * Insert at the end
     * 
     * @param data to be inserted
     */
    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node next = head;
            while (next.nextNode != null) {
                next = next.nextNode;
            }
            next.nextNode = node;
        }
    }

    /**
     * Insert at given position
     * 
     * @param position where the element should be inserted
     * @param data     to be inserted
     */
    public void insertAt(int position, int data) {
        Node node = new Node(data);
        if (position == 0) {
            node.nextNode = head;
            head = node;
        } else {
            int index = 0;
            Node currNode = head;
            Node prevNode = null;
            while (currNode != null) {
                if (index == position) {
                    prevNode.nextNode = node;
                    node.nextNode = currNode;
                    break;
                } else {
                    prevNode = currNode;
                    currNode = currNode.nextNode;
                    index++;
                }
            }
            // Node should be attached at the end
            if (currNode == null && index == position) {
                prevNode.nextNode = node;
            }
        }
    }

    /**
     * Delete the element
     * 
     * @param key element to be deleted
     * @return true if the element is deleted else false
     */
    public boolean deleteByKey(int key) {
        boolean result = false;
        // [case 1] if the key is found at the head
        if (head.data == key) {
            head = head.nextNode;
            result = true;
        } else {
            // [case 2] not the head
            // Traverse untill the key is found
            Node prevNode = null;
            Node currNode = head.nextNode;
            while (currNode.data != key) {
                prevNode = currNode;
                currNode = currNode.nextNode;
            }
            // If the key is found currNode won't be null
            // Will just set reference of prev's next to the current's next
            if (currNode != null) {
                prevNode.nextNode = currNode.nextNode;
                result = true;
            }
        }
        return result;
    }

    /**
     * Delete the element at position
     * 
     * @param position of element to be deleted
     * @return true if deleted, else false
     */
    public boolean deleteAt(int position) {
        Node currNode = head;
        Node prevNode = null;
        if (head == null) {
            return false;
        }
        if (position == 0 && head != null) {
            head = currNode.nextNode;
            return true;
        }
        int index = 0;
        while (currNode != null) {
            if (index == position) {
                prevNode.nextNode = currNode.nextNode;
            } else {
                prevNode = currNode;
                currNode = currNode.nextNode;
                index++;
            }
        }
        return false;
    }

    /**
     * Reverse the list
     * 
     * @param head headNode of LinkedList
     * @return reversed list
     */
    public Node reverse(Node head) {
       LinkedListReverser reverser = new LinkedListReverser();
       return reverser.reverse(head);
    }

    public static class Node {
        public int data;
        public Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("data: " + data);
            String nextNodeString = "";
            if (nextNode != null) {
                nextNodeString = nextNodeString.concat("[").concat(nextNode.toString()).concat("]");
            } else {
                nextNodeString = "null";
            }
            sb.append(" next: " + nextNodeString);
            return sb.toString();
        }
    }
}
