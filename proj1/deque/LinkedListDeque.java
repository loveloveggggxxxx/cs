package deque;

import java.util.Iterator;

public class LinkedListDeque<T>implements Iterable<T>,Deque<T> {
    int size=0;
    Intode sential;
    private class Intode{
        T item;
        Intode next;
        Intode prve;
        public Intode(T i,Intode n,Intode p){
            item=i;
            next=n;
            prve=p;
        }
    }
    public LinkedListDeque(){

        sential=new Intode(null,sential,sential);
        sential.next=sential;
        sential.prve=sential;
        size=0;
    }

    public void addFirst(T item){
       Intode sc=new Intode(item,sential.next,sential);
       if(sential.next!=null)
       {
           sential.next.prve=sc;
       }
       sential.next=sc;
    size++;
    }
    public void addLast(T item){
        Intode sc=new Intode(item,sential,sential.prve);
        if(sential.prve!=null)
        {
            sential.prve.next=sc;
        }
        sential.prve=sc;
    size++;
    }
    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        for(int i=0;i<size;i++)
        {
            System.out.print(sential.next.item+" ");
        }
        System.out.println();
    }
    public T removeFirst()
    {
        if(sential.prve==sential)
        {
            return null;
        }
        Intode sc=sential.next;
            sential.next.next.prve=sential;
        sential.next=sential.next.next;
        size--;
        return sc.item;
    }
    public T removeLast()
    {
        if(sential.next==sential)
        {
            return null;
        }
        Intode sc=sential.prve;
            sential.prve.prve.next=sential;
        sential.prve=sential.prve.prve;
        size--;
        return sc.item;
    }
    public T get(int idex){
        Intode sc=sential.next;
        int i=0;
       while(sc!=null&&i!=idex){
           sc=sc.next;
           i++;
       }
       if(sc==null)
       {
           return null;
       }
       return sc.item;
    }
    public T getRecursive(int index){
        if(sential.next==sential)
        {
            return null;
        }
        int t=index;
       if(t!=0)
       {
           t=t-1;
           return getRecursive(t);
       }else {
           return sential.next.item;
       }
    }
    public Iterator<T> iterator(){
        return  new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<T> {

        private Intode p;
        public LinkedListIterator(){
            p=sential.next;
        }
        public boolean hasNext()
        {
            return p==sential;
        }

        public T next() {
            T returnitem=p.item;
            p=p.next;
            return returnitem;
        }

        public void remove() {
            return;
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
       if(o.getClass()!=this.getClass())
       {
           return false;
       }
       LinkedListDeque<T> im=(LinkedListDeque<T>) o;
       if(im.size()!=this.size())
       {
           return false;
       }
       for(T item:this){
           if(!im.equals(item)){
               return false;
           }
       }
       return true;
    }
}


