import java.io.*;
import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JavaAssign2 implements ActionListener{

	JButton button1;
	JButton button2;
	JButton button3;	
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;	

	JPanel menu;
	JLabel label;

	String location;
	int count = 0;
	char check; 
	char state = 'X';
	int turn = 0;
	boolean clicked = false;

    public static void main ( String[] args )
    {
		GameHelper helper = new GameHelper();
		tictactoe gui = new tictactoe();
	//	tictactoeboard myboard = new tictactoeboard();
		gui.startGui();

	

		gui.printboard();
		
	/**** You need to write this ********/
		
    }

	public void actionPerformed(ActionEvent event){
		
		// Since the program is running this method, a button was pressed.
		
		if ( event.getSource() == button1){ // the A1 button was pressed
			location = "A1";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button1.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button1.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}				

		}
		if ( event.getSource() == button2){ // the A2 button was pressed
			location = "B1";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button2.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button2.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if ( event.getSource() == button3){ // the A3 button was pressed
			location = "C1";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button3.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button3.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if ( event.getSource() == button4){ // the B1 button was pressed
			location = "A2";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button4.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button4.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if ( event.getSource() == button5){ // the B2 button was pressed
			location = "B2";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button5.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button5.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if ( event.getSource() == button6){ // the B3 button was pressed
				location = "C2";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button6.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button6.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if ( event.getSource() == button7){ // the C1 button was pressed
					location = "A3";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button7.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button7.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if ( event.getSource() == button8){ // the C2 button was pressed
					location = "B3";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button8.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button8.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if ( event.getSource() == button9){ // the C3 button was pressed
					location = "C3";
				if((turn % 2 == 0)){
					if(modifyboard(location, 'X') == 0){
						button9.setText("X");
						label.setText("O's turn");
						turn++;
						clicked = true;
					}
				}
				else if(modifyboard(location, 'O') == 0){
					button9.setText("O");
					label.setText("X's turn");
					turn++;
					clicked = true;
				}		
		}
		if(clicked == true){
			printboard();
			clicked = false;
			check = checkboard();
			if(check != 'N'){
				label.setText("The winner is " + check);
				turn = 0;
			}
		}
		if(turn >= 9){
			label.setText("Cat's game!");
		}
	}
	

	void startGui(){
		/// Creates a JFrame object (the window)
		JFrame mainframe = new JFrame("Tic Tac Toe");
		/// Create a Panel to put on the frame. This allows for better button control
		menu = new JPanel(); // make a new panel called 'menu'
		
		label = new JLabel("X Starts");

		menu.setLayout(new GridLayout(3,3)); // Layout the buttons in a grid
		
		mainframe.getContentPane().add(menu, BorderLayout.CENTER); // Put this panel across the top of the window
		
		mainframe.getContentPane().add(label, BorderLayout.NORTH);// put player state at top

		button1 = new JButton("-");
		button2 = new JButton("-");
		button3 = new JButton("-");
		button4 = new JButton("-");
		button5 = new JButton("-");
		button6 = new JButton("-");
		button7 = new JButton("-");
		button8 = new JButton("-");
		button9 = new JButton("-");

		/// Add all of the buttons to the listener
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);		
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);

		/// Set the Program to exit when the window is closed		
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///Put the buttons on the menu panel
		menu.add(button1);
		menu.add(button2);
		menu.add(button3);
		menu.add(button4);
		menu.add(button5);
		menu.add(button6);
		menu.add(button7);
		menu.add(button8);
		menu.add(button9);
		
		/// Set the window to 330 by 330 pixels
		mainframe.setSize(330,330);
		
		/// Actually display the window
		mainframe.setVisible(true);
	}


	private char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
		
	char[] getboard(){
		return board;
	}
		
	void printboard(){
		System.out.println("  " + " A   B   C\n");
		System.out.println("1: " + board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("  -----------");
		System.out.println("2: " + board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("  -----------");
		System.out.println("3: " + board[6] + " | " + board[7] + " | " + board[8]);
	}
		
	int modifyboard(String move, char XorO){ // This function takes the user input trys to place the move. If the grid spot is already filled, it returns a 1, else returns 0. The grid should be updated with 'X' or 'O' as appropriate.
	
		/**** You need to write this ********/
		if((move.compareTo("A1") == 0) && (board[0] == '-')){ 
			checkset(0, XorO);	
		}
		else if((move.compareTo("A2") == 0) && (board[3] == '-')){
			checkset(3, XorO);	
		}		
		else if((move.compareTo("A3") == 0) && (board[6] == '-')){
			checkset(6, XorO);	
		}
		else if((move.compareTo("B1") == 0) && (board[1] == '-')){
			checkset(1, XorO);	
		}		
		else if((move.compareTo("B2") == 0) && (board[4] == '-')){
			checkset(4, XorO);	
		}		
		else if((move.compareTo("B3") == 0) && (board[7] == '-')){
			checkset(7, XorO);	
		}
		else if((move.compareTo("C1") == 0) && (board[2] == '-')){
			checkset(2, XorO);	
		}
		else if((move.compareTo("C2") == 0) && (board[5] == '-')){
			checkset(5, XorO);	
		}		
		else if((move.compareTo("C3") == 0) && (board[8] == '-')){
			checkset(8, XorO);
		}
		else{
			return 1;
		}

		return 0;
	}

	void checkset(int spot, char XorO){
		board[spot] = XorO;
	}
	 
	final int [][] wwcd = new int[][]{
		{0,1,2}, {0,3,6}, 
		{3,4,5}, {1,4,7}, 
		{6,7,8}, {2,5,8}, 
		{0,4,8}, {2,4,6}
	};
		

	char checkboard(){ // This function checks if there is a winner on the board. If so, it should return 'X' or 'O' based on the winner. it should return 'N' if no winner found
		for(int i = 0; i <= 7; i++){
			if( !(board[wwcd[i][0]] == '-')  &&
			 (board[wwcd[i][1]] == board[wwcd[i][0]]) &&
			 (board[wwcd[i][2]] == board[wwcd[i][1]])){

				return board[wwcd[i][0]];
			}
		}	
		return 'N';
	}

}	
