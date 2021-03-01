package Lab4;

public class Kot {
	 public int [] array;
	public Kot () {
		 array= new int[7];
	}
 public void zapolnenie () {
	 Randomaser rnd = new Randomaser ();
     for(int i=0; i<array.length; i++)
     {
         array[i] = rnd.getIntFromRange (1,20);
     }
	 
 }
 public int arraydlina () {
	 return array.length;
 }
}
