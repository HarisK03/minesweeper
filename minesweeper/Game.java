/**
 * ICS4UR Computer Science, 12 
 * Brampton, Canada
 *
 * https://github.com/HarisK03/Minesweeper
 *
 * modified     20201110
 * date         20201103
 * @filename	Game.java
 * @author     	hkamal
 * @version     1.0
 * @see         Game logic
 */

package minesweeper;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The Game class stores values of mines and flags at x and y coordinates and
 * tests for win or loss
 */
public class Game implements MouseListener {
    Main board;
    
    /**
     * Allows for use of variables in Game.java
     */
    public Game (Main in){
        board = in;
    }
    
    /**
     * Resets the game to a new state by removing all bombs and flags, placing
     * bombs with a 10% mine chance
     */
    public void newGame() {
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                board.bombs[x][y] = false;
                board.flags[x][y] = false;
                if (Math.random() < 0.1) {
                    board.bombs[x][y] = true;
                }
                board.tiles[x][y].setIcon(null);
            }
        }
        tileCount();
        board.firstClick = true;
        try {loadTime();}
        catch (Exception e) {}
    }
    
    /**
     * Created timer for time elapsed display
     * src: https://tinyurl.com/y3gvpfjb
     */
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (board.second < 10) {
                board.timer.setText("Time Elapsed: " + board.minute + ":0" + Integer.toString(board.second));
            }
            else {
                board.timer.setText("Time Elapsed: " + board.minute + ":" + Integer.toString(board.second));
            }
            if (board.second == 59) {
                board.second = -1;
                board.minute++;
            }
            board.second++;
        }
    });
    
    /**
     * Resets timer values to 0
     */
    public void resetTimer() {
        timer.stop();
        board.second = 0;
        board.minute = 0;
    }
    
    /**
     * Reads times.txt and determines if a new high score has been generated and
     * if so, overwrites the file
     * read file src: https://tinyurl.com/y2hnlhsc
     * write file src: https://tinyurl.com/y5x6xpkx
     */
    public void highScore() throws IOException {
        int time = (board.minute * 60) + board.second;
        int bestTime;
        String getTime = null;
        BufferedReader brTimes = new BufferedReader(new FileReader("./minesweeper/times.txt"));
        getTime = brTimes.readLine();
        bestTime = Integer.parseInt(getTime);
        
        if (time < bestTime) {
            BufferedWriter bwTimes = new BufferedWriter(new FileWriter("./minesweeper/times.txt"));
            bwTimes.write(Integer.toString(time));
            bwTimes.close();
        }
    }
    
    /**
     * Loads current high score from times.txt
     */
    public void loadTime() throws IOException {
        int bestTime;
        String getTime = null;
        BufferedReader brTimes = new BufferedReader(new FileReader("./minesweeper/times.txt"));
        getTime = brTimes.readLine();
        bestTime = Integer.parseInt(getTime);
        if (bestTime > 59) {
            int min = bestTime / 60;
            int sec = bestTime % 60;
            if (String.valueOf(Integer.toString(sec)).length() == 1) {
                board.highScore.setText("     Best Time: " + Integer.toString(min) + ":0" + Integer.toString(sec));
            }
            else {
                board.highScore.setText("     Best Time: " + Integer.toString(min) + ":" + Integer.toString(sec));
            }
        }
        else {
            if (bestTime < 10) { 
                board.highScore.setText("     Best Time: 0:0" + Integer.toString(bestTime));
            }
            else {
                board.highScore.setText("     Best Time: 0:" + Integer.toString(bestTime));
            }
        }
    }
    
    /**
     * Timer to delay appearance of loss screen
     */
    Timer delay = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new LoseScreen().setVisible(true);
            board.dispose();
            delay.stop();
            board.canClick = true;
        }
    });
    
    /**
     * Assigns value in tileCount array correspondent to amount of mine neighbors
     * for display
     * src: https://tinyurl.com/y4zrhsh9
     */
    public void tileCount() {
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                switch (checkTile(x, y)) {
                    case -1 -> board.tileCount[x][y] = -1;
                    case 0 -> board.tileCount[x][y] = 0;
                    case 1 -> board.tileCount[x][y] = 1;
                    case 2 -> board.tileCount[x][y] = 2;
                    case 3 -> board.tileCount[x][y] = 3;
                    case 4 -> board.tileCount[x][y] = 4;
                    case 5 -> board.tileCount[x][y] = 5;
                    case 6 -> board.tileCount[x][y] = 6;
                    case 7 -> board.tileCount[x][y] = 7;
                    case 8 -> board.tileCount[x][y] = 8;
                }
            }
        }
    }
    
    /**
     * Checks entire grid for neighboring mines 
     * @param x the x coordinate (index in rows)
     * @param y the y coordinate (index in column)
     * @return number of neighboring mines at coordinate
     */
    public int checkTile(int x, int y) {
        int count = 0;
        if (board.bombs[x][y] == false) {
            if (x == 0) {
                switch (y) {
                    case 0 -> {
                        if (board.bombs[x][y+1] == true) {
                            count++;
                        }
                            if (board.bombs[x+1][y] == true) {
                            count++;
                        }
                            if (board.bombs[x+1][y+1] == true) {
                            count++;
                        }
                    }
                    case 8 -> {
                        if (board.bombs[x][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y-1] == true) {
                            count++;
                        }
                    }
                    default -> {
                        if (board.bombs[x][y+1] == true) {
                            count++;
                        }
                        if (board.bombs[x][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y+1] == true) {
                            count++;
                        }
                    }   
                }
            }
            else if (x == 8) {
                switch (y) {
                    case 0 -> {
                        if (board.bombs[x][y+1] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y+1] == true) {
                            count++;
                        }
                    }
                    case 8 -> {
                        if (board.bombs[x][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y-1] == true) {
                            count++;
                        }
                    }
                    default -> {
                        if (board.bombs[x][y+1] == true) {
                            count++;
                        }
                        if (board.bombs[x][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y+1] == true) {
                            count++;
                        }
                    }
                }
            }
            else {   
                switch (y) {
                    case 0 -> {
                        if (board.bombs[x-1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y+1] == true) {
                            count++;
                        }
                        if (board.bombs[x][y+1] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y+1] == true) {
                            count++;
                        }
                    }
                        
                    case 8 -> {
                        if (board.bombs[x-1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y-1] == true) {
                            count++;
                        }
                    }
                        
                    default -> {
                        if (board.bombs[x-1][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x-1][y+1] == true) {
                            count++;
                        }
                        if (board.bombs[x][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x][y+1] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y-1] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y] == true) {
                            count++;
                        }
                        if (board.bombs[x+1][y+1] == true) {
                            count++;
                        }
                    }
                }
            }
            switch (count) {
                case 0 -> {return 0;}
                case 1 -> {return 1;}
                case 2 -> {return 2;}
                case 3 -> {return 3;}
                case 4 -> {return 4;}
                case 5 -> {return 5;}
                case 6 -> {return 6;}
                case 7 -> {return 7;}
                case 8 -> {return 8;}
            }
        }
        return -1;
    }
    
    /**
     * Fill adjacent and diagonal tiles with int fill value
     * @param field 2D array that holds the values to check
     * @param x the x coordinate (index in rows)
     * @param y the y coordinate (index in column)
     * @param space the value of the clicked tile
     * @param fill value to fill space value with
     * src: https://tinyurl.com/y9jsh9lp
     */
    public void findNeighbour(int field[][], int x, int y, int space, int fill) {
        if (x < 0 || x >= 9 || y < 0 || y >= 9) {
            return;
        }
        if (field[x][y] != space) {
            return;
        }

        field[x][y] = fill;
        board.tiles[x][y].setIcon(board.zero);
        
        findNeighbour(field, x-1, y, space, fill); 
        findNeighbour(field, x+1, y, space, fill); 
        findNeighbour(field, x, y+1, space, fill); 
        findNeighbour(field, x, y-1, space, fill); 
        findNeighbour(field, x-1, y+1, space, fill); 
        findNeighbour(field, x-1, y-1, space, fill); 
        findNeighbour(field, x+1, y+1, space, fill); 
        findNeighbour(field, x+1, y-1, space, fill); 
    }

    /**
     * Determines current tile and calls findNeighbour()
     * @param field 2D array that holds the values to check
     * @param x the x coordinate (index in rows)
     * @param y the y coordinate (index in column)
     * @param fill value to fill space value with
     * src: https://tinyurl.com/y9jsh9lp
     */
    public void fill(int field[][], int x, int y, int fill) {
        int space = field[x][y];
        findNeighbour(field, x, y, space, fill);
    }
    
    /**
     * Reveals the border surrounding the recently flooded tiles
     */
    public void revealBorder() {
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                if (x == 0) {
                    switch (y) {
                        case 0 -> {
                            if (board.tileCount[x][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y+1);
                            }
                            if (board.tileCount[x+1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y);
                            }
                            if (board.tileCount[x+1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y+1);
                            }
                        }
                        case 8 -> {
                            if (board.tileCount[x][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y-1);
                            }
                            if (board.tileCount[x+1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y);
                            }
                            if (board.tileCount[x+1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y-1);
                            }
                        }
                        default -> {
                            if (board.tileCount[x][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y+1);
                            }
                            if (board.tileCount[x][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y-1);
                            }
                            if (board.tileCount[x+1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y-1);
                            }
                            if (board.tileCount[x+1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y);
                            }
                            if (board.tileCount[x+1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y+1);
                            }
                        }
                    }
                }
                else if (x == 8) {
                    switch (y) {
                        case 0 -> {
                            if (board.tileCount[x][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y+1);
                            }
                            if (board.tileCount[x-1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y);
                            }
                            if (board.tileCount[x-1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y+1);
                            }
                        }
                        case 8 -> {
                            if (board.tileCount[x][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y-1);
                            }
                            if (board.tileCount[x-1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y);
                            }
                            if (board.tileCount[x-1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y-1);
                            }
                        }
                        default -> {
                            if (board.tileCount[x][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y+1);
                            }
                            if (board.tileCount[x][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y-1);
                            }
                            if (board.tileCount[x-1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y-1);
                            }
                            if (board.tileCount[x-1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y);
                            }
                            if (board.tileCount[x-1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y+1);
                            }
                        }
                        
                    }
                }
                else {
                    switch (y) {
                        case 0 -> {
                            if (board.tileCount[x-1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y);
                            }
                            if (board.tileCount[x-1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y+1);
                            }
                            if (board.tileCount[x][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y+1);
                            }
                            if (board.tileCount[x+1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y);
                            }
                            if (board.tileCount[x+1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y+1);
                            }
                        }
                        case 8 -> {
                            if (board.tileCount[x-1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y);
                            }
                            if (board.tileCount[x-1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y-1);
                            }
                            if (board.tileCount[x][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y-1);
                            }
                            if (board.tileCount[x+1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y);
                            }
                            if (board.tileCount[x+1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y-1);
                            }
                        }
                        default -> {
                            if (board.tileCount[x-1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y-1);
                            }
                            if (board.tileCount[x-1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y);
                            }
                            if (board.tileCount[x-1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x-1, y+1);
                            }
                            if (board.tileCount[x][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y-1);
                            }
                            if (board.tileCount[x][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x, y+1);
                            }
                            if (board.tileCount[x+1][y-1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y-1);
                            }
                            if (board.tileCount[x+1][y] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y);
                            }
                            if (board.tileCount[x+1][y+1] != -2 && board.tileCount[x][y] == -2) {
                                setTile(x+1, y+1);
                            }
                        }
                    }
                }
            }
        }
    }
   
    /**
     * Sets icon correspondent to the coordinate value in tileCount array
     * @param x the x coordinate (index in rows)
     * @param y the y coordinate (index in column)
     */
    public void setTile(int x, int y) {
        switch (board.tileCount[x][y]) {
            case 1 -> board.tiles[x][y].setIcon(board.one);
            case 2 -> board.tiles[x][y].setIcon(board.two);
            case 3 -> board.tiles[x][y].setIcon(board.three);
            case 4 -> board.tiles[x][y].setIcon(board.four);
            case 5 -> board.tiles[x][y].setIcon(board.five);
            case 6 -> board.tiles[x][y].setIcon(board.six);
            case 7 -> board.tiles[x][y].setIcon(board.seven);
            case 8 -> board.tiles[x][y].setIcon(board.eight);
        }
    }
    
    /**
     * Compares coordinates of placed mines to user placed flags and checks if
     * win condition is met
     */
    public void flagCheck() {
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                if (board.tiles[x][y].getIcon() == board.flag) {
                    board.flags[x][y] = true;
                }
                else {
                    board.flags[x][y] = false;
                }
            }
        }
        hasWon();
    }
    
    /**
     * Open WinScreen.java upon win, dispose current JFrame, and reset timer
     */
    public void hasWon() {
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                if (board.bombs[x][y] != board.flags[x][y]) {
                    return;
                }
            }
        }
        winSound();
        try {highScore();}
        catch(Exception e) {}
        resetTimer();
        new WinScreen().setVisible(true);
        board.dispose();
        newGame();
    }
    
    /**
     * Open LoseScreen.java upon loss, dispose current JFrame, and reset timer
     */
    public void hasLost() {
        loseSound();
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                if (board.bombs[x][y] == true) {
                    board.tiles[x][y].setIcon(board.bomb);
                }
            }
        }
        resetTimer();
        delay.start();
        board.canClick = false;
    }

    /**
     * Play sound when tile is clicked
     */
    public void clickSound() {
        try {
            File musicPath = new File("./assets/click.wav");
            
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        catch (Exception e) {}
    }
    
    /**
     * Play sound when flag is placed
     */
    public void flagSound() {
        try {
            File musicPath = new File("./assets/flag.wav");
            
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        catch (Exception e) {}
    }
    
    /**
     * Play sound when user successfully clears board of mines
     */
    public void winSound() {
        try {
            File musicPath = new File("./assets/victory.wav");
            
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        catch (Exception e) {}
    }
    
    /**
     * Play sound when user clicks on a tile that holds a mine
     */
    public void loseSound() {
        try {
            File musicPath = new File("./assets/explosion.wav");
            
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        catch (Exception e) {}
    }
    
    /**
     * Detect left and right mouse clicks to deploy actions
     * src: https://tinyurl.com/y36dkzn5
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        /**
         * Left mouse button is clicked (reveal tile)
         */
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (board.firstClick == true) {
                timer.start();
                board.firstClick = false;
            }
            for (int x = 0; x <= 8; x++) {
                for (int y = 0; y <= 8; y++) {
                    if (board.tiles[x][y] == source) {
                        if (board.tiles[x][y].getIcon() != null || board.canClick == false) {
                            return;
                        }
                        switch (checkTile(x, y)) {
                            case -1 -> hasLost();
                            case 0 -> {board.tiles[x][y].setIcon(board.zero); fill(board.tileCount, x, y, -2); revealBorder();}
                            case 1 -> board.tiles[x][y].setIcon(board.one);     
                            case 2 -> board.tiles[x][y].setIcon(board.two);
                            case 3 -> board.tiles[x][y].setIcon(board.three);    
                            case 4 -> board.tiles[x][y].setIcon(board.four);    
                            case 5 -> board.tiles[x][y].setIcon(board.five);    
                            case 6 -> board.tiles[x][y].setIcon(board.six);   
                            case 7 -> board.tiles[x][y].setIcon(board.seven);    
                            case 8 -> board.tiles[x][y].setIcon(board.eight);
                        }
                        clickSound();
                    }
                }
            }
        }        
        /**
         * Right mouse button is clicked (place flag or question mark)
         */
        else if (SwingUtilities.isRightMouseButton(e)) {
            for (int x = 0; x <= 8; x++) {
                for (int y = 0; y <= 8; y++) {
                    if (board.tiles[x][y] == source) {
                        if (board.tiles[x][y].getIcon() == null) {
                            board.tiles[x][y].setIcon(board.flag);
                            flagSound();
                        }
                        else if (board.tiles[x][y].getIcon() == board.flag) {
                            board.tiles[x][y].setIcon(board.questionMark);
                        }
                        else if (board.tiles[x][y].getIcon() == board.questionMark) {
                            board.tiles[x][y].setIcon(null);
                        }
                        flagCheck();
                    }
                }
            }
        }
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}