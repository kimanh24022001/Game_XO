
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class tictoe1 implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[400];
	boolean player1_turn;

	tictoe1(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("TicToe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(20,20));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<400;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.PLAIN,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<400;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						textfield.setForeground(new Color(0,0,255));
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						textfield.setForeground(new Color(255,0,0));

						check();
					}
				}
			}			
		}
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	
	public void check() {
		//check X win conditions
		for (int i=0;i<397;i++) {
		if(
				
				(buttons[i].getText()=="X") &&
				(buttons[i+1].getText()=="X") &&
				(buttons[i+2].getText()=="X") &&
				(buttons[i+3].getText()=="X") &&
				(buttons[i+4].getText()=="X") &&
				(buttons[i-1].getText()!="O") &&
				(buttons[i+5].getText()!="O")) {
			xWins(i,i+1,i+2,i+3,i+4);
		}
		if(
				i<=319 &&
				(buttons[i].getText()=="X") &&
				(buttons[i+20].getText()=="X") &&
				(buttons[i+40].getText()=="X") &&
				(buttons[i+60].getText()=="X") &&
				(buttons[i+80].getText()=="X") 
				) {
			xWins(i,i+20,i+40,i+60,i+80);
		}
		if(
				i<=315 &&
				(buttons[i].getText()=="X") &&
				(buttons[i+21].getText()=="X") &&
				(buttons[i+42].getText()=="X") &&
				(buttons[i+63].getText()=="X") &&
				(buttons[i+84].getText()=="X") 
				) {
			xWins(i,i+21,i+42,i+63,i+84);
		}
		if(
				i<=319 && i>=4 &&
				(buttons[i].getText()=="X") &&
				(buttons[i+19].getText()=="X") &&
				(buttons[i+38].getText()=="X") &&
				(buttons[i+57].getText()=="X") &&
				(buttons[i+76].getText()=="X") 
				) {
			xWins(i,i+19,i+38,i+57,i+76);
		}
		}
		//check O win conditions
		for (int i=0;i<397;i++) {
			if(
					(buttons[i].getText()=="O") &&
					(buttons[i+1].getText()=="O") &&
					(buttons[i+2].getText()=="O") &&
					(buttons[i+3].getText()=="O") &&
					(buttons[i+4].getText()=="O") &&
					(buttons[i-1].getText()!="X") &&
					(buttons[i+5].getText()!="X") 
					) {
				oWins(i,i+1,i+2,i+3,i+4);
			}
			if(
					i<=319 &&
					(buttons[i].getText()=="O") &&
					(buttons[i+20].getText()=="O") &&
					(buttons[i+40].getText()=="O") &&
					(buttons[i+60].getText()=="O") &&
					(buttons[i+80].getText()=="O") 
					) {
				oWins(i,i+20,i+40,i+60,i+80);
			}
			if(
					i<=315 &&
					(buttons[i].getText()=="O") &&
					(buttons[i+21].getText()=="O") &&
					(buttons[i+42].getText()=="O") &&
					(buttons[i+63].getText()=="O") &&
					(buttons[i+84].getText()=="O") 
					) {
				oWins(i,i+21,i+42,i+63,i+84);
			}
			if(
					i<=319 && i>=4 &&
					(buttons[i].getText()=="O") &&
					(buttons[i+19].getText()=="O")&&
					(buttons[i+38].getText()=="O") &&
					(buttons[i+57].getText()=="O") &&
					(buttons[i+76].getText()=="O") 
					) {
				oWins(i,i+19,i+38,i+57,i+76);
			}
			}
	}
	
	public void xWins(int a,int b,int c,int d,int e) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		buttons[d].setBackground(Color.GREEN);
		buttons[e].setBackground(Color.GREEN);
		for(int i=0;i<400;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}
	public void oWins(int a,int b,int c,int d,int e) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		buttons[d].setBackground(Color.GREEN);
		buttons[e].setBackground(Color.GREEN);
		for(int i=0;i<400;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
	}
}