class Node<T>{
    T data;
    Node next;

    //constructor
    public Node(T data){
        this.data=data;
    }

    //get data
    public T get(){
        return data;
    }

    //get next
    public Node getNext(){
        return next;
    }

    //set next
    public void setNext(Node next){
        this.next = next;
    }
}