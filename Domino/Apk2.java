// María Fernanda Hernandez Enriquez A01329383
// Diana Claudia Aranda Soriano A01328509 
public class Apk2{
	public static void main (String[] args){

		DominoSet t = new DominoSet();
		t.shuffle();
		PlayerSet player1;
		PlayerSet player2;

		Rules r = new Rules();
		System.out.println("Set Round1");
		player1 = new PlayerSet(t.popTiles(6));
		System.out.println("Player1");
		System.out.println(player1.toString());
		//System.out.println(player1.bigTileSet());
		player2 = new PlayerSet(t.popTiles(6));
		System.out.println("Player2");
		System.out.println(player2.toString());
		//System.out.println(player2.bigTileSet());
		System.out.println("Game Domino: Starts with the high tile");
		int turn = r.getTurn(player1.bigTileSet(),player2.bigTileSet());//Muestra el primer turno
		System.out.println(turn);
		System.out.println (r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));//La ficha más grande
		if (turn == 1){
			player1.deleteTile(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			player1.orderTiles();
		}
		else if (turn == 2){
			player2.deleteTile(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			player2.orderTiles();
		}
		else
			System.out.println("----------"); 

		System.out.println("Set Round2");
		System.out.println("Player1");
		System.out.println(player1.toString());
		System.out.println("Player2");
		System.out.println(player2.toString());
	
	
	}
}