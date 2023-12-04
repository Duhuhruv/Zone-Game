package WoffindenZone;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class Score extends Rectangle {
    // creates the score

    //creates variables that will be used later in the class
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        //constructs the score
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g){
        //draws the score onto the screen
        player1++;
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawString("Score: "+String.valueOf(player1), (GAME_WIDTH/4)+90, 50);

    }
}
