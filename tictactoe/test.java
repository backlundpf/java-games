import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class test implements ActionListener	{

//Setting up ALL the variables
	JFrame window = new JFrame("Tic-Tac-Toe");
	
	JButton btnEmpty[] = new JButton[10];

	JLabel label = new JLabel("X starts");
	
	JPanel 	pnlPlayer = new JPanel(),
		pnlPlayingField = new JPanel();

	JTextArea txtMessage = new JTextArea();
	
	final int wwcd[][] = new int[][]	{
		{1, 2, 3}, 			{1, 4, 7}, 		{1, 5, 9},
		{4, 5, 6}, 			{2, 5, 8}, 		{3, 5, 7},
		{7, 8, 9}, 			{3, 6, 9}
		/*Horizontal Wins*/		/*Vertical Wins*/ 	/*Diagonal Wins*/
	};

	final int X = 412, Y = 268, color = 190;
	boolean inGame = false;
	boolean win = false;
	boolean btnEmptyClicked = false;
	String message;
	int turn = 1;
	int wonNumber1 = 1, wonNumber2 = 1, wonNumber3 = 1;
	

	public test()	{	//Setting game properties and layout and sytle...
	//Setting window properties:
		window.setSize(X, Y);
		window.setLocation(450, 260);
		window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//Setting Panel layouts and properties

		window.getContentPane().add(label, BorderLayout.NORTH);
		window.getContentPane().add(pnlPlayingField, BorderLayout.CENTER);
	
	//Setting up the playing field
		pnlPlayingField.setLayout(new GridLayout(3, 3));
		pnlPlayingField.setBackground(Color.black);
		for(int i=1; i<=9; i++)	{
			btnEmpty[i] = new JButton();
			btnEmpty[i].setBackground(new Color(220, 220, 220));
			btnEmpty[i].addActionListener(this);
			pnlPlayingField.add(btnEmpty[i]);
		}

		window.setVisible(true);
	}


//-------------------START OF ACTION PERFORMED CLASS-------------------------//	
	public void actionPerformed(ActionEvent event)	{
		if ( event.getSource() == button1 && turn < 10){ // the A1 button was pressed
			location = "A1";
				if(!(turn % 2 == 0)){
					if(modifyboard(location, 'X')){
						btnEmpty[i].setEnabled(false);
						turn++;
					}
				}
				else if(modifyboard(location, 'O')){
					btnEmpty[i].setEnabled(false);
					turn++;
				}				

		}
		if ( event.getSource() == button2){ // the A2 button was pressed
		}
		if ( event.getSource() == button3){ // the A3 button was pressed
		}
		if ( event.getSource() == button4){ // the B1 button was pressed
		}
		if ( event.getSource() == button5){ // the B2 button was pressed
		}
		if ( event.getSource() == button6){ // the B3 button was pressed
		}
		if ( event.getSource() == button7){ // the C1 button was pressed
		}
		if ( event.getSource() == button8){ // the C2 button was pressed
		}
		if ( event.getSource() == button9){ // the C3 button was pressed
		}
/*		Object source = click.getSource();
		for(int i=1; i<=9; i++)	{
			if(source == btnEmpty[i] && turn <	10)	{
				btnEmptyClicked = true;
				if(!(turn % 2 == 0))
					btnEmpty[i].setText("X");
				else
					btnEmpty[i].setText("O");
				btnEmpty[i].setEnabled(false);
				turn++;
			}
		}
*/		if(btnEmptyClicked)	{
			checkboard();
			btnEmptyClicked = false;
		}


	}
//-------------------END OF ACTION PERFORMED CLASS-------------------------//


/*
		----------------------------------
		Start of all the other methods.	|
		----------------------------------
*/
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
	

	public static void main(String[] args)	{
		new test();//	Calling the class construtor.
	}
}

/*
	Changes:
		1.0- changes below: Stable
			0.9- added back button, added comments.
			0.8- added dynamic win message.
			0.7- added game function- game playable.
			0.6- changed menu layout.
			0.5- basic functions with menu and nice GUI.
*/
