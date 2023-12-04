package WoffindenZone;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class GameFrame extends JFrame {

    GamePanel panel;
    GameFrame(){
        //creates the frame/panel and adds its characteristics like not being resizeable and setting the title
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Woffinden Zone");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
