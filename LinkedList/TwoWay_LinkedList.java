package LinkedList;

public class TwoWay_LinkedList {
    TwoWayNode head , tail ;

    public TwoWay_LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void traversForward(){
        TwoWayNode current = head;
        while(current!=null){
            System.out.println(current.data + "\t");
            current = current.next;
        }
        System.out.println();
    }

    public void traversBackward(){
        TwoWayNode current = tail;
        while(current!=null){
            System.out.print(current.data + "\t");
            current = current.prev;
        }
        System.out.println();
    }

    public void insertAtBeginning (int data){
        TwoWayNode new_node = new TwoWayNode(data);
        if(head == null){
            head = new_node;
            tail=new_node;
        }
        else {
            new_node.next=null;
            head.prev = new_node;
            head = new_node;
        }
    }

    public void insertAtPosition(int data , int position){
        TwoWayNode new_node = new TwoWayNode(data);
        if(position==0){
            insertAtBeginning(data);
        }
        else {
            TwoWayNode current = head;
            int currPosition = 0;
            while(current!=null && currPosition < position){
                current=current.next;
                currPosition++;
            }
            if(current==null){
                insertAtEnd(data);
            }
            else {
                new_node.next = current;
                new_node.prev = current.prev;
                current.prev.next=new_node;
                current.prev = new_node;
            }
        }
    }

    public void insertAtEnd(int data){
        TwoWayNode new_node = new TwoWayNode(data);
        if(tail==null){
            head=tail=new_node;
        }
        else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }
    }

    public int deleteAtFirst(){
        if(head ==null){
            System.out.println("List is Empty");
            return -1;
        }
        if(head ==tail){
            head=null;
            tail=null;
            System.out.println("List is Empty");
            return -1;
        }
        TwoWayNode x = head;
        head=head.next;
        head.prev=null;
        x.next=null;
        return x.data;
    }

    public int deleteAtPosition(int position){
        if(head==null){
            System.out.println("List Is Empty");
        }
        if(position==0){
            deleteAtFirst();
        }
        TwoWayNode current = head;
        int currPosition=0;
        while(current!=null && currPosition<position){
            current = current.next;
            currPosition++;
        }
        if(current==null){
            System.out.println("Position is Wrong");
            return -1;
        }
        if(current==tail){
            deleteAtEnd();
        }

        current.prev.next=current.next;
        current.next.prev=current.prev;
        current.next=null;
        current.prev = null;
        return current.data;
    }

    public int deleteAtEnd(){
        if(tail == null) {
            System.out.println("List is Empty");
            return -1;
        }
        if(head == tail){
            head = null;
            tail = null;
            return -1;
        }
        TwoWayNode x = tail;
        tail = tail.prev;
        tail.next=null;
        x.prev = null;
        return x.data;
    }
    

}
