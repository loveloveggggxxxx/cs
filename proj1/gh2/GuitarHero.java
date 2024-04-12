package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static double gainNumber(int pw){
        final double nexxtt = 440.0;
        for(int i=0;i<pw;i++){
            final double nextt=nexxtt * Math.pow(2, (i-24) / 12.0);
        }
        return nexxtt;
    }
    public static void main(String[]args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] sc = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            sc[i] = new GuitarString(gainNumber(i));
        }

        while (true) {

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int number = keyboard.indexOf(key);
                if (number >= 0) {
                    sc[number].pluck();
                }
            }
                double sample=0.0;
            for(GuitarString s:sc){
                sample+=s.sample();
            }
            StdAudio.play(sample);
            for(GuitarString s:sc){
                s.tic();
            }
        }
    }
}
