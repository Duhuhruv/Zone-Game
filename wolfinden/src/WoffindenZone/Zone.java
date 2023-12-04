package WoffindenZone;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class Zone extends Rectangle {
    //this creates the zone that sits in the center of the screen that the protector protects
    Zone(int x, int y, int ZONE_DIAMETER){
        //constructs the zone
        super(x,y,ZONE_DIAMETER,ZONE_DIAMETER);
    }
    public void draw(Graphics g){
        //draws the zone on the panel
        g.setColor(Color.darkGray);
        g.fillOval(x,y,width,height);
    }
}
