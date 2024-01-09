package LinkedList;

public class Linked_list {
    Node head;

    public void printList(Node head){
      Node p = head;
        while(p!=null){
            System.out.println(p.data);
            p=p.next;
        }
    }
    public void printList_Reverse(Node head){
        Node p = head;
        while(p!=null){
            printList_Reverse(p);
            System.out.println(p.data);
        }

    }

    public void insertL(int item) {
        Node p = new Node(item);
        if (head == null) {
            head = p;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = p;
        }
    }

    public int deleteL(){
        Node current = head;
        if(head==null){
            System.out.println("List is EMPTY");
            return -1;
        }
        while(current.next!=null){
            current = current.next;
        }
        int x = current.next.data;
        current.next=null;
        return x;
    }

    public static Node concat (Node head , Node head1){
        if(head == null){
            return head1;
        } else {
            if (head1 != null) {
                Node current;
                for(current = head ; current.next !=null; current=current.next);
                current.next=head1;
            }
            return head;
        }
    }

    public Node reverse(Node head){
        if(head.next!=null)return head;
        Node p=null , q=head , t=head.next;

        while(t!=null){
            q.next=p;
            p=q;
            q=t;
            t=t.next;
        }
        q.next=p;
        return q;
    }




    public static void main(String[] args) {
        Linked_list list = new Linked_list();

        list.insertL(14);
        list.insertL(12);
        list.insertL(11);
        list.insertL(15);
        list.insertL(18);

        Linked_list list1 = new Linked_list();

        list1.insertL(14);
        list1.insertL(12);
        list1.insertL(11);
        list1.insertL(15);
        list1.insertL(18);

//        Linked_list concatedList = new Linked_list();
//        concatedList.head = concat(list.head , list1.head);
//        concatedList.printList(concatedList.head);
//        list1.printList(list1.head);
//        list.printList(list.head);
//        list.printList_Reverse(list.head);



    }

}
