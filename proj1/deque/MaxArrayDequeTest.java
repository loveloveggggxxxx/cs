package deque;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
public class MaxArrayDequeTest {
    @Test
    public void maxWithoutComparatorTest(){
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<Integer>(new IntComparator());
            for(int i=0;i<5;i++){
                mad.addLast(i);
            }
            assertEquals((Integer) 4,mad.max());
    }
    @Test
    public void maxwithComparatorTest(){
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<Integer>(new IntComparator());
        for(int i=0;i<5;i++){
            mad.addLast(i);
        }
        assertEquals((Integer)4,mad.max(new IntComparator()));
    }
    private static class IntComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }

}
