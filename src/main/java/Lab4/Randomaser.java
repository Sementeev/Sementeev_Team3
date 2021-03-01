package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Randomaser {
	public int[] array = new int[10];
	public Randomaser () {}
 public void generate() {
     
     for (int i = 0; i < array.length; i++) {
         array[i] = getIntFromRange(10, 80);

     }

     System.out.println(Arrays.toString(array));
}
 static int getIntFromRange (int min, int max) {
     Random random = new Random();
     return random.nextInt(max - min + 1) + min;
 }
}