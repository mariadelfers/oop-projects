import java.util.*;

public class Game{

	private Deck d;	//Deck of the game
	private Player[] p; //Set of player playing
	private int t; //Current turn in the game
	private float b; //Fixed bet
	private float m; //Money betted already

	private Scanner x;

	public Game(){
		this.d = new Deck ();
		this.p = new Player [0];
		this.t = -1;
		this.x = new Scanner(System.in);
		this.b = (float)0.0;
		this.m = (float)0.0;
	}

	//Accesors
	//Mutators
	
	public boolean init(int noPlayers, float startingMoney, float fixBet){
		if(noPlayers <= 1 || noPlayers > 4)
			return false;
		else{
			this.b = fixBet;
			this.p = new Player[noPlayers];
			this.d.shuffle();
			
			for (int i = 0;i < this.p.length; i++){
				System.out.print("Introduce the alias of player #" + (i+1) + " : ");
				String alias = "";
				alias = x.nextLine();
				this.p[i] = new Player ("","", alias, startingMoney);
				this.p[i].setHand(new Hand(d.popCards(5)));
			}
			return true;
		}
	} 

	public void toConsole(){
		for (int i = 0; i<this.p.length;i++){
			System.out.println("#" + (i+1) + " "+ this.p[i].toString());
		}
	}

	public void nextTurn(){
		this.t++;
		int c = this.t % this.p.length; //Current player
		System.out.println("TURN OF PLAYER " + this.p[c].toString());
		String option = "";
		while (option != "Y" || option != "N" || option != "y" || option != "n"){
			System.out.print("Do you want to play? (Y/N): ");
			option = x.nextLine();
		}
		if (option == "Y" || option == "y"){
			float money = this.p[c].getMoney();
			if (money > this.b){
				money = this.b;
			}
			this.m+= money;
			this.p[c].setMoney(this.p[c].getMoney() - money);

			int pos = -1;
			while (pos < 0 || pos > this.p[c].getHand().length()){
				System.out.println("Select a card position to swap or 0 to finish your turn");
				pos = x.nextInt();
				if (pos == 0){
					break;
				}
				else if (pos >= 1 && pos <= this.p[c].getHand().length()){
					Card aux = d.popCard();
					this.p[c].getHand().swapCard(pos-1,aux);
					pos = -1;	
				}
			}
		}
	}
}