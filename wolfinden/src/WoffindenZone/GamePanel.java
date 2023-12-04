package WoffindenZone;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable {
    //this is the main game panel class that handles all of the drawing of the different objects and the timer


    // initiates final variables that will be used throughout the program and wont change
    //also creates variables that need to be initiated here so that they can work throughout multiple methods
    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH*0.75);
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int PROTECTOR_DIAMETER = 60;
    static final int ZONE_DIAMETER = 200;
    boolean running = true;
    Image enemy = new ImageIcon("C:/Users/Dhruv/woffinden.png").getImage();
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Protector protector;
    Woffinden woffinden;
    Zone zone;
    Score score;
    double speed = 3;
    GamePanel(){
        // calls the methods that call the different classes that create the drawn objects on the panel
        //also adds the keylistener and starts the thread for animation
        newProtector();
        newWoffinden();
        newZone();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newZone(){
        //calls new zone
        zone = new Zone((GAME_WIDTH/2)-ZONE_DIAMETER/2,GAME_HEIGHT/2-ZONE_DIAMETER/2,ZONE_DIAMETER);
    }
    public void newProtector() {
        //calls new protector
        protector = new Protector((GAME_WIDTH/2)-(ZONE_DIAMETER/2)-PROTECTOR_DIAMETER/2, (GAME_HEIGHT/2)-(ZONE_DIAMETER/2)-PROTECTOR_DIAMETER/2,PROTECTOR_DIAMETER);
    }
    public void newWoffinden() {
        //calls new woffinden. the different if methods make it so that the woffinden will spawn in a random place
        //that is still far enough away from the zone to make the game fair to the player
        random = new Random();
        if (random.nextInt(2) == 1) {
            if (random.nextInt(2) == 1) {
                woffinden = new Woffinden((random.nextInt(195) + 100), random.nextInt(50) + 100, enemy.getWidth(null), enemy.getHeight(null), speed);
            } else {
                woffinden = new Woffinden((random.nextInt(195) + 900), random.nextInt(50) + 700, enemy.getWidth(null), enemy.getHeight(null), speed);
            }
        } else {
            if (random.nextInt(2) == 1) {
                woffinden = new Woffinden((random.nextInt(195) + 100), random.nextInt(50) + 700, enemy.getWidth(null), enemy.getHeight(null), speed);
            } else {
                woffinden = new Woffinden((random.nextInt(195) + 900), random.nextInt(50) + 100, enemy.getWidth(null), enemy.getHeight(null), speed);
            }
        }
    }
    public void paint(Graphics g){
        //this paints all the graphics onto the panel
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw(Graphics g){
        //draws all of the objects that are called onto the panel
        if(running == true){
            woffinden.draw(g);
            protector.draw(g);
            zone.draw(g);
            score.draw(g);
        } else {
            gameOver(g);
        }

    }
    public void move(){
        //streamlines the method calling so that the woffinden object moves much smoother
        woffinden.move();
        protector.move();
    }
    public void checkCollision(){
        //checks all fo the collisions


        //makes it so woffinden collides with protector
        if(woffinden.intersects(protector)){
            score.player1 += 100;
            speed += 0.2;
            newWoffinden();
        }
        //bounces woffinden off window edges
        if(woffinden.y <=0){
            woffinden.setYDirection(-woffinden.yVelocity);
        }
        if(woffinden.y >= GAME_HEIGHT-enemy.getHeight(null)) {
            woffinden.setYDirection(-woffinden.yVelocity);
        }
        if(woffinden.x<=0){
            woffinden.setXDirection(-woffinden.xVelocity);
        }
        if(woffinden.x >= GAME_WIDTH-enemy.getWidth(null)) {
            woffinden.setXDirection(-woffinden.xVelocity);
        }
        //ends game if woffinden touches zone
        if(woffinden.intersects(zone)){
            running = false;
        }

    }
    public void run(){
        //creates game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(running == true){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public void gameOver(Graphics g){
        //this method is called when the woffinden touches the zone to end the game. it draws the eng screen and score
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawString("Game Over", GAME_WIDTH/2-150, GAME_HEIGHT/2);
        g.drawString("Score: "+ score.player1,GAME_WIDTH/2-200, GAME_HEIGHT-50);
    }
    public class AL extends KeyAdapter{
        //creates a keylistener for when keys are pressed
        public void keyPressed(KeyEvent e){
            protector.keyPressed(e);
        }
    }
}


