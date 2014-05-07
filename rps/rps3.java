import java.util.Scanner;
import java.io.*;          // Access System.out

class Rps{

	public void newgame(){
	
	/*Extra Challenge 5
		Make this program a 3 player game*/
	
	BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
	String inputLine = null;	
		
	/*	try{
			inputLine = is.readLine();
			} catch (IOException e){
				System.out.println("IOException: " + e);
				}	
*/
	Player playerarray[];
	playerarray = new Player[4];
	
	for (int k = 1; k < 4; k++){
	    System.out.print("Enter player " + k + "'s name:> ");
		try{
			inputLine = is.readLine();
			} catch (IOException e){
				System.out.println("IOException: " + e);
				}
		playerarray[k-1] = new Player(k, inputLine);
	}
	
//	Player player1 = new Player(1,"Don");
//	Player player2 = new Player(2);
	
	String player1guess = null;
	String player2guess = null;
	
	/*Extra Challenge 3
		Make this program Rock, Paper, Scissors, Lizard, Spock*/
		
	/*Extra Challenge 4
		Make this program best 2 out of 3*/
	
	System.out.println("Welcome to RPS (Rock, Paper, Scissors) v2.0");
	
	//player1.setNameUserIn();
	//player2.setNameUserIn();
	
	System.out.println("Preparing to run the guess() method on both player objects");
	
	/*In Class Challenge
		Make this program require the wunderboard to be shaken repeatedly to start the game*/
	
//	player1guess = player1.userguess();
//	player2guess = player2.userguess();
	
	playerarray[0].startSerial();
	
	player1guess = playerarray[0].guessSerial();
	player2guess = playerarray[1].userguess();
	
	//System.out.println("Player 1 was " + player1guess + " and Player 2 was " + player2guess);
	
	while (player1guess.compareTo(player2guess) == 0){
		player1guess = playerarray[0].guessSerial();
		player2guess = playerarray[1].userguess();
		
	//	System.out.println("Player 1 was " + player1guess + " Player 2 was " + player2guess);
		}
	
	if ((player1guess.compareTo("Rock") == 0)  && (player2guess.compareTo("Scissors") == 0) )
		System.out.println(playerarray[0].getName() + " smashes the heck out of " + playerarray[1].getName() + " with a rock! Die scissors die!");
	if ((player1guess.compareTo("Scissors") == 0)  && (player2guess.compareTo("Rock") == 0) )
		System.out.println(playerarray[1].getName() + " smashes the heck out of " + playerarray[0].getName() + " with a rock! Die scissors die!");
	if ((player1guess.compareTo("Paper") == 0)  && (player2guess.compareTo("Rock") == 0) )
		System.out.println(playerarray[0].getName() + " smothers " + playerarray[1].getName() + " with paper! Die rock die!");
	if ((player1guess.compareTo("Rock") == 0)  && (player2guess.compareTo("Paper") == 0) )
		System.out.println(playerarray[1].getName() + " smothers " + playerarray[0].getName() + " with paper! Die rock die!");
	if ((player1guess.compareTo("Scissors") == 0)  && (player2guess.compareTo("Paper") == 0) )
		System.out.println(playerarray[0].getName() + " slices and dices " + playerarray[1].getName() + " with scissors! Die paper die!");
	if ((player1guess.compareTo("Paper") == 0)  && (player2guess.compareTo("Scissors") == 0) )
		System.out.println(playerarray[1].getName() + " slices and dices " + playerarray[0].getName() + " with scissors! Die paper die!");
	
	/*Extra Challenge 6
		Actually declare a winner*/
	
	System.exit(0);
	
	}
}

class Player{
	private String name;
	private int playernumber;
	
	private lab5 serialport = new lab5();
	
	public Player(){
	}
	
	public Player(int newplayernumber){
		playernumber = newplayernumber;
	}
	
	public Player(int newplayernumber, String newname){
		playernumber = newplayernumber;
		name = newname;
	}
	
	public Player(String newname){
		name = newname;
	}
	
	public boolean setName(String newname){
		name = newname;
		return true;
		}
	
	public boolean setNameUserIn(){
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = null;
		
		System.out.print("Enter player " + playernumber + "'s name:> ");
		try{
			inputLine = is.readLine();
			} catch (IOException e){
				System.out.println("IOException: " + e);
				}
		
		name = inputLine;
		return true;
		}
		
	public String getName(){
		return name;
		}
//New	
	public void startSerial(){
		serialport.initialize();
	}
//New	
	public String guessSerial(){
		char guess, old_guess;
		int times_shaken = 0;
		
		System.out.println(name + ", set your selection and shake 3 times!");
		while (true){
			guess = serialport.readUART();
			if ((guess == 'A') || (guess == 'B') || (guess == 'C'))
				times_shaken++;
			if (times_shaken == 2)
				break;
		}
		if (guess == 'A'){
			return "Rock";
			}
		else if (guess == 'B'){
			return "Scissors";
			}
		else if (guess == 'C'){
			return "Paper";
			}
		else
			return "Dynamite";
	}
	
	public String guess(){
		/* Extra Challenge 7
		Make a place for the player name and make it private. 
		Create the functions needed to 'set' and 'get' the name.*/
		
		int number;
		
		/*Extra Challenge 1
		Make this method accept user input*/
		
		number = ((int)(Math.random() * 10))%3;
		if (number == 0){
			return "Rock";
			}
		else if (number == 1){
			return "Paper";
			}
		else if (number == 2){
			return "Scissors";
			}
		else {
			return "Dynamite";
			}
	}
	
	public String userguess(){
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = null;
		
		while(true){
		System.out.print("Enter your selection! (Rock, Paper, or Scissors)> ");
		try{
			inputLine = is.readLine();
			} catch (IOException e){
				System.out.println("IOException: " + e);
				}
		if ((inputLine.compareTo("Rock") == 0) || (inputLine.compareTo("Paper") == 0) || (inputLine.compareTo("Scissors") == 0))
			return inputLine;
		}
	
	}
}

class StartGame{
    public static void main ( String[] args )
    {
		
	Rps game = new Rps();
	game.newgame();

	}
}	