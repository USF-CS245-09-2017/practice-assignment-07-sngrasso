
public class LinkedList<T> implements List<T>{
    Node head = null;
    int size = 0;

    //add new node at the end of linked list
    public void add(T item){
    	//if linked list is empty first element is the head
        if(head==null){
            head = new Node(item);
            head.setNext(null);
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.getNext();
            }

            //set up new node
            Node node = new Node(item);
            node.setNext(null);
            curr.setNext(node);
        }
        this.size++;
    }

    //adds node to linked list at a certain position
    public void add(int pos, T item){
        Assert.not_false(pos >=0 && pos<=size);

        Node n = new Node(item);

        if(pos == 0) {
            n.setNext(head);
            head = n;
        }
        else{
            Node prev = head;

            for(int i=0; i<pos-1; i++){
                prev = prev.getNext();
            }
            //set new node's next to prev.next vice versa
            n.setNext(prev.next);
            prev.setNext(n);
        }

        //last increment size
        this.size++;
    }

    //gets data from a node at a position
    public T get(int pos){
        Assert.not_false(pos>=0 && pos < size);

        //go through linked list until it reaches the position
        Node current = head;
        for(int i = 0 ; i < pos; i++){
            current = current.next;
        }

        //return data of the node at pos
        return (T) current.data;
    }

    //removes the node at a certain point and returns what was removed
    public T remove(int pos){
        Assert.not_false(pos>=0 && pos<size);

        Node current = head;
        //removing head of linked list
        if (pos==0){
            head = current.getNext();
            this.size--;
            return (T) current.data;
        }

        Node prev = current;

        for ( int i=0; i<pos; i++){
            prev = current;
            current = current.getNext();
        }
        //prev.next is now the removed element's next node
        prev.setNext(current.getNext());
        this.size--;
        return (T) current.data;
    }

    //return size of linked list
    public int size(){
        return this.size;
    }


}