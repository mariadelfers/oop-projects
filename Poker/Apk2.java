public class Apk2{
	public static void main (String[] args){
		
		Deck d = new Deck();
		System.out.println(d.toString());
		d.shuffle();
		
		Hand h;
		for (int i = 0; i < 10; i++){
			h = new Hand(d.popCards(5));
			System.out.println (h.toString());
			System.out.println (h.winnerHandToString());
			System.out.println (" ");
		}

		Card[] arr = new Card[5];
		arr[0] = new Card(2,1);
		arr[1] = new Card(3,1);
		arr[2] = new Card(4,1);
		arr[3] = new Card(5,1);
		arr[4] = new Card(6,1);
		h = new Hand(arr);
		System.out.println (h.toString());
		System.out.println (h.winnerHandToString());
		System.out.println (" ");
	}
}