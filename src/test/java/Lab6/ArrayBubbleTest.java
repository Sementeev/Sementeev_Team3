package Lab6;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Lab4.ArrayBubble;

public class ArrayBubbleTest {
	static ArrayBubble Ris;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 Ris = new ArrayBubble(5);
		Ris.bubbleSorter();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Ris=null;
		}
	@Test
    public void test() {
        for(int i=0; i<Ris.a.length - 1; i++)
        {
               assertTrue(Ris.a[i]<=Ris.a[i+1]);
        }
    }

}
