public class Apk1{
	public static void main (String[] args){
		
		Deck d = new Deck();
		System.out.println(d.toString());
		d.shuffle();
		System.out.println(d.toString());
		
		Deck e = new Deck (d.getCards());	
		e.setNoCards(d.getNoCards());
		e.shuffle();
		System.out.println(e.toString());
		if (d.compareTo(e) == 0)
			System.out.println("THE DECKS ARE EQUAL");
		
		
		try{
			Card [] tmp = new Card [2];
			tmp[0] = new Card (3, Card.SUIT_HEARTS);
			tmp[1] = new Card (12, Card.SUIT_CLUBS);
			Deck f = new Deck(tmp);
			System.out.println(f.toString());
			Card c = f.popCard();
			System.out.println("The card poped is: " + c.toString());
			System.out.println(f.toString());
			c = f.popCard();
			System.out.println("The card poped is: " + c.toString());
			System.out.println(f.toString());
			c = f.popCard();
			}
			
		catch (NullPointerException ex){
			System.out.println("That operation cannot be done COW" + ex.getMessage());
		}
		try{
			int x = 4/0;
		}
			
		catch (ArithmeticException ex2){
			System.out.println("Are you dum?? cannot be done " + ex2.getMessage());
		}
	}
}