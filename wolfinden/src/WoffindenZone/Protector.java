
package WoffindenZone;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.lang.Math;
public class Protector extends Rectangle{
    //this class creates the protector object that is controlled by the player
    //that rotates around.

    //these variables are initiated here because they need to be used throughout different methods
    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH*0.75);
    static final int ZONE_DIAMETER = 200;
    int pos = 1;
    int x1 = x;
    int y1 = y;
    Protector(int x, int y, int PROTECTOR_DIAMETER){
        //constructs the protector
        super(x,y,PROTECTOR_DIAMETER,PROTECTOR_DIAMETER);
    }

    public void keyPressed(KeyEvent e){
        //checks if certain keys are pressed and then passes values to the movement class to move the protector frame by frame
        if(e.getKeyCode()==KeyEvent.VK_D) {
            if(pos == 16){
                movement(1);
                move();
            } else {
                movement(pos+1);
                move();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_A) {
            if(pos == 1){
                movement(16);
                move();
            } else {
                movement(pos-1);
                move();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            if(pos+8 <=16){
                movement(pos+8);
                move();
            }
            else{
                movement((pos+8)%16);
                move();
            }
        }
    }
    public void movement(int seq){
        //sets up a switch that has different cases for each of the different positions for the protector
        // each case has the coordinates to set the protector and sends them to the setLocation method
        pos = seq;
        switch (pos) {
            case 1:
                setLocation((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width / 2, (GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height / 2);
                break;
            case 2:
                setLocation(((((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width / 2) + ((GAME_WIDTH / 2) - width / 2)) / 2) - 6, ((((GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height / 2) + ((GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height)) / 2) - 6);
                break;
            case 3:
                setLocation((GAME_WIDTH / 2) - width / 2, (GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height);
                break;
            case 4:
                setLocation(((((GAME_WIDTH / 2) - width / 2) + ((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2) - width / 2)) / 2) + 6, ((((GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height) + ((GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height / 2)) / 2) - 6);
                break;
            case 5:
                setLocation((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2) - width / 2, (GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height / 2);
                break;
            case 6:
                setLocation(((((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2) - width / 2) + ((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2))) / 2) + 6, ((((GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height / 2) + ((GAME_HEIGHT / 2) - height / 2)) / 2));
                break;
            case 7:
                setLocation((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2), (GAME_HEIGHT / 2) - height / 2);
                break;
            case 8:
                setLocation(((((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2)) + ((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2) - width / 2)) / 2) + 6, ((((GAME_HEIGHT / 2) - height / 2) + ((GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2) - height / 2)) / 2));
                break;
            case 9:
                setLocation((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2) - width / 2, (GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2) - height / 2);
                break;
            case 10:
                setLocation(((((GAME_WIDTH / 2) + (ZONE_DIAMETER / 2) - width / 2) + ((GAME_WIDTH / 2) - width / 2)) / 2) + 6, ((((GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2) - height / 2) + ((GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2))) / 2) + 6);
                break;
            case 11:
                setLocation((GAME_WIDTH / 2) - width / 2, (GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2));
                break;
            case 12:
                setLocation(((((GAME_WIDTH / 2) - width / 2) + ((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width / 2)) / 2) - 6, ((((GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2)) + ((GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2) - height / 2)) / 2) + 6);
                break;
            case 13:
                setLocation((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width / 2, (GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2) - height / 2);
                break;
            case 14:
                setLocation(((((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width / 2) + ((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width)) / 2) - 6, ((((GAME_HEIGHT / 2) + (ZONE_DIAMETER / 2) - height / 2) + ((GAME_HEIGHT / 2) - height / 2)) / 2));
                break;
            case 15:
                setLocation((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width, (GAME_HEIGHT / 2) - height / 2);
                break;
            case 16:
                setLocation(((((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width) + ((GAME_WIDTH / 2) - (ZONE_DIAMETER / 2) - width / 2)) / 2) - 6, ((((GAME_HEIGHT / 2) - height / 2) + ((GAME_HEIGHT / 2) - (ZONE_DIAMETER / 2) - height / 2)) / 2));
                break;
        }
    }
    public void setLocation(int x0, int y0){
        //this method is here to better organize how the move method is called and make it so that doubles can be passed
        // so that the position of the protector looks good
        x1 = x0;
        y1 = y0;
    }
    public void move(){
        //this sets x and y to the new position for he next time the loop comes through
        x = x1;
        y = y1;
    }
    public void draw(Graphics g){
        //this method draws out the protector onto the panel
        g.setColor(Color.GREEN);
        g.fillOval(x,y,width,height);
    }
}
