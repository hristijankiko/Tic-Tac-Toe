import javax.swing.JFrame;


public class Main extends JFrame {

	public static void main(String[] args) {
		
		TicTacToe game = new TicTacToe();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(306, 440);
		game.setVisible(true);
		game.setResizable(false);
		// asd
		
	}

}
