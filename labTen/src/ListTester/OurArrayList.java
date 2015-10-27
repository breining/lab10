package ListTester;

/**
* An array implementation of the OurList interface.
*
* @author 
* @version 
*
*/

public class OurArrayList<E> implements OurList<E> {
    
    private static final int DEFAULTSIZE = 10;
    private E [] elements;
    private int size;
    
    /*
    * Java does not permit declaration of generic arrays. This constructor creates
    * an array of Objects and then casts the array to the generic type. This cast
    * will result in a compiler warning about unchecked types. The
    * @SuppressWarnings annotation is used to indicate that we know what
    * we are doing here; it suppresses the "unchecked" warning.
    */
    public OurArrayList(int size) {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[size];
        elements = newdata;
        size = 0;
    }

    public OurArrayList() {
        this(DEFAULTSIZE);
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public void clear() {
        E[] newdata = (E[]) new Object[size];
        elements = newdata;
        size = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public boolean contains(Object obj) {
        for(int i = 0; i < size; i++){
            if (elements[i] == obj)
                return true;
        }
        return false;
    }
    
    @Override
    public int indexOf(Object obj) {
        for(int i = 0; i < size; i++){
            if (elements[i] == obj)
                return i;
        }
        return -1;
    }
    
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return elements[index];
    }
    
    @Override
    public void add(E element) {
        //check full
        if(size == elements.length){
            extendArray();
        }
        
        
        elements[size] = element;
        size++;

    }
    
    @Override
    public void add(int index, E element) {
        //check full
        if(size == elements.length){
            extendArray();
        }
        if(index>size)throw new IndexOutOfBoundsException();
        else{
        for(int i = size; i > index + 1; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
        }
    }

    @Override
    public void remove(int index) {
        //check empty
        if(isEmpty() || index > size) throw new IndexOutOfBoundsException();
        for(int i = index; i < size - 1; i++){
            elements[i]=elements[i+1];
        }
       size--;
    }
    
    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        else{
            remove(index);
            return true;
        }
    }
    
    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        else
            elements[index] = element;
    } 
    
    // The append method of the StringBuilder class automatically calls
    // the toString method of the object being appended.
    @Override
    public String toString() {
        if (size == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<size-1; i++)
            sb.append(elements[i] + ", ");
        sb.append(elements[size-1] + "]\n");
        return sb.toString();
    }
    
    private void extendArray() {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[elements.length*2];
        for (int i=0; i<size; i++)
            newdata[i] = elements[i];
        elements = newdata;
    }
}
