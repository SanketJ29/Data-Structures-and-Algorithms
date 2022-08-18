import java.util.*;

class loopc {
    Node head;

    class Node {
        int data;
        Node next;
        int flag;

        Node(int d) {
            data = d;
            next = null;
            flag = 0;
        }
    }

    // using a visited node O(n), O(1)
    public boolean findLoop(Node head) {
        Node tnode = head;
        while (tnode != null) {
            if (tnode.flag == 1)
                return true;
            tnode.flag = 1;
            tnode = tnode.next;
        }
        return false;
    }

    public void insertAtEnd(int new_data) {
        Node new_node = new Node(new_data);
        new_node.flag = 0;

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        loopc llist = new loopc();
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            llist.insertAtEnd(s);
        }

        System.out.println("Linked List: ");
        llist.printList();
        System.out.println();

        llist.head.next.next.next.next = llist.head;

        boolean l = llist.findLoop(llist.head);
        if (l == true)
            System.out.println("Loop found");
        else
            System.out.println("No loop found");

    }
}