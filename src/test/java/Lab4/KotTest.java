package Lab4;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class KotTest {
 static Kot kot;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 kot= new Kot();
	kot.zapolnenie();	
	}

    @Test
    public void kotArray() {
        assertEquals(7,kot.array.length); //проверка длины массива
        for(int i=0; i<kot.array.length; i++)
        {
            assertNotNull(kot.array[i]);//проверка элементов на Null
        }
    }
}
