package WoffindenZone;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Woffinden extends Rectangle{
    //this class creates the woffinden object that is the enemy in the game that spawns randomly and is trying to get in
    //the zone.

    //these variables are created here to be used later throughout the method
    Random random;
    double xVelocity;
    double yVelocity;
    Image enemy;
    Woffinden(int x, int y, int width, int height, double speed){
        //constructs the object
        super(x,y,width,height);
        random = new Random();

        //this makes it a random chance that the object will go diagonally in all 4 directions
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0){
            randomXDirection--;
        }
        setXDirection(randomXDirection*speed);

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0){
            randomYDirection--;
        }
        setYDirection(randomYDirection*speed);
    }

    public void setXDirection(double randomXDirection){
        //this method is to organize the class and to be put into the move method
        xVelocity = randomXDirection;
    }
    public void setYDirection(double randomYDirection){
        //this method is to organize the class and to be put into the move method
        yVelocity = randomYDirection;
    }
    public void move(){
        //this method changes the values of x to the new values. this also makes the animation smoother by calling it this way
        x += Math.round(xVelocity);
        y += Math.round(yVelocity);
    }
    public void draw(Graphics g){
        //draws the object onto the screen
        enemy = new ImageIcon("C:/Users/Dhruv/woffinden.png").getImage();
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(enemy,x,y,null);
    }
}
