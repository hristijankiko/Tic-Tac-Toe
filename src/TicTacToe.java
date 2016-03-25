import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TicTacToe extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton exit,clear,field0,field1,field2,field3,field4,field5,field6,field7,field8;
	private boolean playerturn = false, gameOver = false;
	private Font font;
	private JLabel label;
	private int clicks=0;
	
	public TicTacToe(){
		// test
		super("Tic-tac-toe");
		setLayout(null);
		field0 = new JButton();
		field1 = new JButton();
		field2 = new JButton();
		field3 = new JButton();
		field4 = new JButton();
		field5 = new JButton();
		field6 = new JButton();
		field7 = new JButton();
		field8 = new JButton();
		exit = new JButton("Exit");
		clear = new JButton("Clear");
		
		field0.setSize(100, 100);
		field0.setLocation(0, 0);
		add(field0);
		field1.setSize(100,100);
		field1.setLocation(100, 0);
		add(field1);
		field2.setSize(100, 100);
		field2.setLocation(200,0);
		add(field2);
		
		field3.setSize(100,100);
		field3.setLocation(0, 100);
		add(field3);
		field4.setSize(100,100);
		field4.setLocation(100, 100);
		add(field4);
		field5.setSize(100, 100);
		field5.setLocation(200, 100);
		add(field5);
		
		field6.setSize(100, 100);
		field6.setLocation(0, 200);
		add(field6);
		field7.setSize(100, 100);
		field7.setLocation(100, 200);
		add(field7);
		field8.setSize(100, 100);
		field8.setLocation(200, 200);
		add(field8);
		
		font = new Font("Bauhaus 93", Font.PLAIN, 85);
		
		field0.setFont(font);
		field1.setFont(font);
		field2.setFont(font);
		field3.setFont(font);
		field4.setFont(font);
		field5.setFont(font);
		field6.setFont(font);
		field7.setFont(font);
		field8.setFont(font);
		
		Field0Listener field0handler = new Field0Listener();
		field0.addActionListener(field0handler);
		field1.addActionListener(field0handler);
		field2.addActionListener(field0handler);
		field3.addActionListener(field0handler);
		field4.addActionListener(field0handler);
		field5.addActionListener(field0handler);
		field6.addActionListener(field0handler);
		field7.addActionListener(field0handler);
		field8.addActionListener(field0handler);
		
		
		label = new JLabel("O turn");
		label.setSize(300,30);
		label.setLocation(JLabel.CENTER, 310 );
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 35));
		add(label);
		
		exit.setSize(150,60);
		exit.setFont(new Font("Arial", Font.PLAIN, 24));
		exit.setLocation(150, 350);
		add(exit);
		ExitClass exithandler = new ExitClass();
		exit.addActionListener(exithandler);
			
		clear.setSize(150,60);
		clear.setFont(new Font("Arial", Font.PLAIN, 24));
		clear.setLocation(0, 350);
		add(clear);
		ClearClass clearhandler = new ClearClass();
		clear.addActionListener(clearhandler);
		
		
	}
	
	private class Field0Listener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			JButton pressedbtn = (JButton)(event.getSource());
			clicks += 1;
			if (clicks == 9){
				gameOver = true;
				label.setText("Game over");
				if(playerturn == true){
					pressedbtn.setText("X");
				}else{
					pressedbtn.setText("O");
				}
				pressedbtn.setEnabled(false);
				
			}
			
			if(gameOver == true){
				return;
			}else{
			if(playerturn == true){
				pressedbtn.setText("X");
				playerturn = false;
			}
			else{
				pressedbtn.setText("O");
				playerturn = true;
			}
			pressedbtn.setEnabled(false);
			if(CheckWinner()){
				if(playerturn == false)
					label.setText("Winner is X");
				else
					label.setText("Winner is O");
				gameOver = true;
			}else{
				label.setText(player());
			}
	}
	}
}
	private boolean CheckWinner(){
		if(field0.getText().equals(field1.getText()) && field1.getText().equals(field2.getText()) && (field2.getText() == "X" || field2.getText()=="O"   )){
			return true;
		}else if(field3.getText().equals(field4.getText()) && field4.getText().equals(field5.getText()) && (field5.getText() == "X" || field5.getText()=="O"   )){
			return true;
		}else if(field6.getText().equals(field7.getText()) && field7.getText().equals(field8.getText()) && (field8.getText() == "X" || field8.getText()=="O"   )){
			return true;
		}else if(field0.getText().equals(field3.getText()) && field3.getText().equals(field6.getText()) && (field6.getText() == "X" || field6.getText()=="O"   )){
			return true;
		}else if(field1.getText().equals(field4.getText()) && field4.getText().equals(field7.getText()) && (field7.getText() == "X" || field7.getText()=="O"   )){
			return true;
		}else if(field2.getText().equals(field5.getText()) && field5.getText().equals(field8.getText()) && (field8.getText() == "X" || field8.getText()=="O"   )){
			return true;
		}else if(field0.getText().equals(field4.getText()) && field4.getText().equals(field8.getText()) && (field8.getText() == "X" || field8.getText()=="O"   )){
			return true;
		}else if(field2.getText().equals(field4.getText()) && field4.getText().equals(field6.getText()) && (field6.getText() == "X" || field6.getText()=="O"   )){
			return true;
		}
		return false;
	}
	private String player(){
		if(playerturn == false){
			return("O turn");
		}else{
			return ("X turn");
		}
	}
	private class ExitClass implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	private class ClearClass implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			field0.setText("");
			field1.setText("");
			field2.setText("");
			field3.setText("");
			field4.setText("");
			field5.setText("");
			field6.setText("");
			field7.setText("");
			field8.setText("");
			field0.setEnabled(true);
			field1.setEnabled(true);
			field2.setEnabled(true);
			field3.setEnabled(true);
			field4.setEnabled(true);
			field5.setEnabled(true);
			field6.setEnabled(true);
			field7.setEnabled(true);
			field8.setEnabled(true);
			gameOver = false;
			label.setText(player());
			clicks = 0;
			
			
		}
		
	}
}

