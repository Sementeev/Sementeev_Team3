package Lab5;

import static org.junit.Assert.*;

import org.junit.Test;

import Lab4.Randomaser;

public class RandomaserTest {


	@Test
	public void testAssertEquals() {
		Randomaser randomjunior = new Randomaser ();
		randomjunior.generate();
		 for (int i = 0; i < randomjunior.array.length; i++) {
			 assertTrue ((randomjunior.array[i]) <80 & (randomjunior.array[i] > 10));
	     }
	}

	

}
