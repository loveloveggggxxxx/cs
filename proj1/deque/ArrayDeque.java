package deque;
import org.junit.Assert;

import java.util.Iterator;

public class ArrayDeque<T>implements Deque<T>,Iterable<T> {
    T []sc;
    int size;
    public ArrayDeque(){
        sc=(T[])new Object[8];
        size=0;
    }
    public ArrayDeque(T item){
        sc=(T[])new Object[8];
        addFirst(item);
    }
    public void addFirst(T item){
        if(size==sc.length){
            T[]sb=(T[]) new Object[sc.length*2];
            System.arraycopy(sc,0,sb,0,size);
            sc=sb;
        }
        for(int i=size-1;i>=0;i--)
        {
            sc[i+1]=sc[i];
        }
        sc[0]=item;
        size++;
    }
    public void addLast(T item){
        if(size==sc.length){
            T[]sb=(T[]) new Object[sc.length*2];
            System.arraycopy(sc,0,sb,0,size);
            sc=sb;
        }
        sc[size]=item;
        size++;
    }
    public int size(){
       return size;
    }
    public void printDeque(){
        for(int i=0;i<size-1;i++)
        {
            System.out.print(sc[i]+" ");
        }
    }
    public T removeFirst(){
        if(sc[0]==null)
        {
            return null;
        }
        T temp=sc[0];
        if(size==sc.length){
            addLast(null);
        }
        for(int i=0;i<size;i++)
        {
            sc[i]=sc[i+1];
        }
        if(sc.length>16)
        {
            if(4*size<sc.length){
               T[]sb=(T[])new Object[sc.length/2];
               System.arraycopy(sc,0,sb,0,size);
               sc=sb;
            }
        }
        size--;
        return temp;
    }
    public T removeLast(){
        T temp=sc[size-1];
        sc[size-1]=null;
        if(sc.length>16)
        {
            if(4*size<sc.length){
                T[]sb=(T[])new Object[sc.length/2];
                System.arraycopy(sc,0,sb,0,size);
                sc=sb;
            }
        }
        size--;
        return  temp;
    }
    public T get(int index){
        if(sc[index]==null){
            return  null;
        }
        return sc[index];
    }
    public Iterator<T>iterator(){
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<T>{
        private int wix;
        public boolean hasNext() {
            return wix<size;
        }

        public T next() {
            T item=sc[wix];
            wix++;
            return item;
        }
        public void remove() {
        }
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o==this){
            return true;
        }
        if(!(o instanceof Deque)){
            return false;
        }
        ArrayDeque<T>item=(ArrayDeque<T>) o;
        if(item.size()!=this.size()){
            return false;
        }
        for(T im:item){
            if(!item.equals(im)){
                return false;
            }
        }return true;
    }

}







