// María Fernanda Hernandez Enriquez A01329383
// Diana Claudia Aranda Soriano A01328509 
public class Prueba {
	public static void main (String[] args){

		DominoSet t = new DominoSet();
		System.out.println (t.toString());
		//System.out.println ("////////////////////");
		t.shuffle();
		System.out.println(t.toString());
		//System.out.println ("////////////////////");	

		PlayerSet p;

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
		System.out.println ("-------ADD TILE------");
		//DominoTiles tile123 = new DominoTiles(t.popTiles(1))
		p.addTile(t.popTiles(1));
		System.out.println (p.toString());
		System.out.println ("---------------");
		DominoTiles tilex = new DominoTiles(2,1);
		DominoTiles tilex1 = new DominoTiles(2,2);
		DominoTiles tilex2 = new DominoTiles(2,3);
		DominoTiles tilex3 = new DominoTiles(2,4);
		DominoTiles tilex4 = new DominoTiles(2,5);
		DominoTiles tilex5 = new DominoTiles(2,6);

		System.out.println(p.compare1To(tilex));
		System.out.println(p.compare1To(tilex1));
		System.out.println(p.compare1To(tilex2));
		System.out.println(p.compare1To(tilex3));
		System.out.println(p.compare1To(tilex4));
		System.out.println(p.compare1To(tilex5));

		System.out.println ("=====Players game=====");

		for(int i = 1; i<5; i++){
			p = new PlayerSet(t.popTiles(6));
			System.out.println ("______ Player: " + i +"______" );
			System.out.println (p.toString());
		}
		
	

	}
}