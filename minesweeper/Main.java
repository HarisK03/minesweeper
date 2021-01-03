/**
 * ICS4UR Computer Science, 12 
 * Brampton, Canada
 *
 * https://github.com/HarisK03/Minesweeper 
 *
 * modified     20201110
 * date         20201103
 * @filename	Main.java
 * @author      hkamal
 * @version     1.0
 * @see         GUI components
 */

package minesweeper;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The Main class initializes all variables and generates the 9x9 board
 */
public class Main extends JFrame {
    
    Game game = new Game(this);
    
    JPanel boardPanel = new JPanel();
    JPanel timerPanel = new JPanel();
    JPanel framePanel = new JPanel();
    JLabel title;
    JLabel timer;
    JLabel highScore;
    
    static JButton[][] tiles = new JButton[9][9];
    boolean[][] bombs = new boolean[9][9];
    boolean[][] flags = new boolean[9][9];
    int[][] tileCount = new int[9][9];
    
    boolean canClick = true;
    boolean firstClick = true;
    
    int second = 0;
    int minute = 0;
    
    ImageIcon bomb;
    ImageIcon flag;
    ImageIcon questionMark;
    ImageIcon zero;
    ImageIcon one;
    ImageIcon two;
    ImageIcon three;
    ImageIcon four;
    ImageIcon five;
    ImageIcon six;
    ImageIcon seven;
    ImageIcon eight;
    
    /**
     * Main constructor generates GUI for playable board
     */
    public Main() {
        super ("Minesweeper");
        setSize (700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        boardPanel.setLayout(new GridLayout(9, 9, 0, 0));
        timerPanel.setLayout(new GridBagLayout());
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
        
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                tiles[x][y] = new JButton();
                tiles[x][y].setPreferredSize(new Dimension(60, 60));
                boardPanel.add(tiles[x][y]);
                tiles[x][y].addMouseListener(game);
            }
        }
        
        title = new JLabel("MINESWEEPER");
        title.setFont(new Font("Century Gothic", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        timer = new JLabel("Time Elapsed: 0:00");
        timer.setFont(new Font("Century Gothic", Font.BOLD, 24));
        timer.setAlignmentX(Component.CENTER_ALIGNMENT);
        timer.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        highScore = new JLabel("     Best Time: ");
        highScore.setFont(new Font("Century Gothic", Font.BOLD, 24));
        highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScore.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        timerPanel.add(timer);
        timerPanel.add(highScore);
        
        framePanel.add(title);
        framePanel.add(boardPanel);
        framePanel.add(timerPanel);
        
        add(framePanel);
        
        setVisible(false);
        
        /**
         * Set window to open in center of screen
         * src: https://tinyurl.com/y3y5d9oy
         */
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    	int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    	int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
    	this.setLocation(x, y);
        
        /**
         * Assets for the game
         * bomb src: https://tinyurl.com/y6rwqjaw
	     * flag src: https://tinyurl.com/y3nat7oo
         */
        try {
            bomb = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/bomb.png")));
            flag = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/flag.png")));
            questionMark = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/question-mark.png")));
            zero = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/0.png")));
            one = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/1.png")));
            two = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/2.png")));
            three = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/3.png")));
            four = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/4.png")));
            five = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/5.png")));
            six = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/6.png")));
            seven = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/7.png")));
            eight = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/8.png")));
        }
        catch (IOException e) {}
    
        game.newGame();
    }
    
    /**
     * main method that opens Splash.java, disposes, and then opens Main.java
     * src: https://tinyurl.com/y2w8kl8t
     */
    public static void main(String[] arguments) {
        Splash splash = new Splash();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                splash.setVisible(true);
            }
        });
        MainMenu frame = new MainMenu();
        try {
            Thread.sleep(1000);
        }
        catch(Exception e) {}
        splash.setVisible(false);
        frame.setVisible(true);
        splash.dispose();
    }
}
