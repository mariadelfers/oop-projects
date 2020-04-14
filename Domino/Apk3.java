// María Fernanda Hernandez Enriquez A01329383
// Diana Claudia Aranda Soriano A01328509 
public class Apk3{
	public static void main (String[] args){

		DominoSet t = new DominoSet();
		t.shuffle();
		PlayerSet player1;
		PlayerSet player2;

		Rules r = new Rules();
		System.out.println(" < < < DOMINO GAME > > >");
		System.out.println(" ");
		System.out.println("************Set Players*************");
		player1 = new PlayerSet(t.popTiles(6));
		System.out.println("Player1:");
		System.out.println(player1.toString());
		player2 = new PlayerSet(t.popTiles(6));
		System.out.println("Player2:");
		System.out.println(player2.toString());
		DominoTiles d = new DominoTiles();
		System.out.println("************************************");
		System.out.println(" ");
		
		System.out.println("_____Round1____(high tile)");
		//Quien tiene la ficha más grande
		int turn = r.getTurn(player1.bigTileSet(),player2.bigTileSet());
		System.out.println("Player: " + turn);
		//Imprime la ficha más grande- Crea FICHA1
		System.out.println (r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
		//r.tilesGame(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()),1);
		//La ficha jugada se borra después de compararla en la siguiente vuelta
		if (turn == 1){
			player1.orderTiles();
			System.out.println("_____Round2_____");
			System.out.println("Player: 2");
			//Compara FICHA1 con SetPlayer2
			//System.out.println(player2.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));
			boolean add2 = player2.compare11To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			do{
				player2.addTile(t.popTiles(1));
				add2 = player2.compare11To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
				if (add2 == false){
					System.out.println (player2.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));
				}
			}while(add2 = false);
			
			//r.tilesGame(player2.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())))
			//Borrar FICHA1
			//player1.deleteTile(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			//FICHAS GAMING
			System.out.print (r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			System.out.println (player2.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));

			System.out.println("_____Round3_____");
			System.out.println("Player: 1");
			//System.out.println(player1.compare2To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()),player2.compare111To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()))));
			
			System.out.print (r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			System.out.print (player2.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));
			System.out.println(player1.compare2To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()),player2.compare111To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()))));

		}
		else if (turn == 2){
			player2.orderTiles();
			System.out.println("_____Round2_____");
			System.out.println("Player: 1");
			//Compara FICHA1 con SetPlayer1
			//System.out.println(player1.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));
			boolean add2 = player1.compare11To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			do{
				player1.addTile(t.popTiles(1));
				add2 = player1.compare11To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
				if (add2 == false){
					System.out.println (player1.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));
				}
			}while(add2 = false);
			
			//r.tilesGame(player2.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())))
			//Borrar FICHA1
			//player1.deleteTile(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			//FICHAS GAMING
			System.out.print (r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			System.out.println (player1.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));

			System.out.println("_____Round3_____");
			System.out.println("Player: 2");
			//System.out.println(player1.compare2To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()),player2.compare111To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()))));
			
			System.out.print (r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()));
			System.out.print (player1.compare1To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet())));
			System.out.println(player2.compare2To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()),player1.compare111To(r.bigTileGame(player1.bigTileSet(),player2.bigTileSet()))));


		}
		else
			System.out.println("----------"); 

	
	}
}
