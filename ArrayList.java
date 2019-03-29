
public class ArrayList<T> implements List<T>{
    T[]arr; 
    int size = 0; //number of elements added in array
    int arrsize=10; //initialized size of array

    public ArrayList() {   
        arr = (T[]) new Object[arrsize];
    }

    //grow array as needed 
    protected void grow_array() {
        //make temp that's double size
        T[] temp = (T[]) new Object[arr.length * 2];

        for( int i = 0; i < arr.length; i++){
            temp[i]=arr[i];
        }

        arr = temp;
    }

    //add to end of array
    public void add(T item){
        if(size==arr.length-1){
            grow_array();
        }
        arr[size]=item;
        this.size++;
    }

    //add item to some position in the array list
    public void add(int pos, T item){
        Assert.not_false(pos>=0 && pos<=size);
        if (size==arr.length-1){
            grow_array();
        }
        //move elements to make space for the new item
        for (int i = size; i >=pos; i-- ){
            arr[i+1]=arr[i];
        }

        //now that array has finished shifting elements we can add item to position
        arr[pos] = item;

        this.size++;

    }

    //return an element at a given position
    public T get(int pos){
        Assert.not_false(pos>=0 && pos<size);
        return this.arr[pos];
    }

    //remove an element from a given position
    public T remove(int pos){
        Assert.not_false(pos>=0 && pos<size);

        //hold removed element to be returned
        T removed = arr[pos];

        //move elements past position down to fix size
        for (int i = pos; i < size; i++){
            arr[i]=arr[i++];
        }
        arr[size]=null;
        this.size--;
        return removed;
    }

    //return size
    public int size(){
        return this.size;
    }
}