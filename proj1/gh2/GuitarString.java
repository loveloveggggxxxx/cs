package gh2;

 import deque.Deque;
 import deque.LinkedListDeque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
     private Deque<Double> buffer;
    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity=(int)Math.round(SR/frequency);
        buffer=new LinkedListDeque<>();
        for(int i=0;i<capacity;i++)
        {
            buffer.addFirst((double)0);
        }

    }
    public void pluck() {
        for(int i=0;i<buffer.size();i++)
        {
            double r=Math.random()-0.5;
            buffer.removeLast();
            buffer.addFirst(r);
        }
    }
    public void tic() {
        for(int i=0;i<buffer.size();i++)
        {
            double sc=buffer.removeFirst();
            double newdouble=(sc+buffer.get(0))*0.5*DECAY;
            buffer.addLast(newdouble);
        }
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}

