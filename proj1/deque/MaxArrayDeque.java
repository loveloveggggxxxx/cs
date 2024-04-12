package deque;

import java.util.Comparator;

public class MaxArrayDeque <T>extends ArrayDeque<T>{
    Comparator<T>comparator;
    MaxArrayDeque(Comparator c){
        comparator=c;
    }
    public T max(Comparator c){
        if(isEmpty()){
            return null;
        }
        int maxindex=0;
        for(int i=0;i<size();i++){
            if(c.compare(get(i),get(maxindex))>0){
                maxindex=i;
            }
        }
        return get(maxindex);
    }
    public T max()
    {
      return max(comparator);
    }
}
