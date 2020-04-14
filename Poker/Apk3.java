public class Apk3{
	public static void main (String[] args){
		Game g1 = new Game();
		g1.init(4,(float)100.0, (float)25.5);
		g1.toConsole();
	
	while(true){
		g1.nextTurn();
		g1.toConsole();
	}

	}
}