// María Fernanda Hernandez Enriquez A01329383
// Diana Claudia Aranda Soriano A01328509 
public class Apk1{
	public static void main (String[] args){

		DominoSet t = new DominoSet();
		t.shuffle();
		//System.out.println(t.toString());

		PlayerSet player1;
		PlayerSet player2;

		DominoTiles tile = new DominoTiles();
		
		player1 = new PlayerSet(t.popTiles(6));
		System.out.println ("______ Player: 1 ______" );
		System.out.println (player1.toString());
		//System.out.println("---Ordena------");
		//System.out.println (player1.orderTiles());
		System.out.println("---Ficha más grande(Suma)------");
		System.out.println (player1.bigTileSet());
		//dt1 =  new DominoTiles(player1.bigTileSet());
		//tile = new DominoTiles(1,2);
		
		player2 = new PlayerSet(t.popTiles(6));
		System.out.println ("______ Player: 2 ______" );
		System.out.println (player2.toString());
		//System.out.println("---Ordena------");
		//System.out.println (player2.orderTiles());
		System.out.println("---Ficha más grande(Suma)------");
		System.out.println (player2.bigTileSet());
		System.out.println("___-Biggest tile");
		System.out.println (player1.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
	
		/**PlayerSet p;
		System.out.println ("=====Prueba 1x1=====");
		DominoTiles[] tiles = new DominoTiles[6];
		tiles[0] = new DominoTiles(1,1);
		tiles[1] = new DominoTiles(1,2);
		tiles[2] = new DominoTiles(1,3);
		tiles[3] = new DominoTiles(1,4);
		tiles[4] = new DominoTiles(1,5);
		tiles[5] = new DominoTiles(1,6); 
		p = new PlayerSet(tiles);
		System.out.println(p.toString());
		System.out.println("---Ordena------");
		System.out.println (p.orderTiles());
		System.out.println("---Ficha más grande(Suma)------");
		System.out.println (p.bigTile());*/

		//public boolean equals(Card card){
		//return this.face == card.getFace() && this.suit == card.getSuit();

		//public void orderTo (PlayerSet playerSet){
		//Arrays.sort(dtiles);
	}
}