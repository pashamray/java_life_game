package com.life.grid.cell;

import java.awt.*;

/**
 * Created by user on 27.07.2016.
 */
public class GameGridCell extends Canvas {

    private final Color activeColor = Color.RED;
    private final Color deactiveColor = Color.BLACK;

    private boolean active;
    private Color color;

    public GameGridCell() {
        active = false;
        color = Color.BLACK;
    }

    public void active(){
        active = true;

        this.setColor(new Color((int)(Math.random() * 0x1000000)));
    }

    public void deactive()
    {
        active = false;
        this.setColor(deactiveColor);
    }

    public boolean isActive(){
        return active;
    }

    public void setColor(Color c){
        color = c;
        repaint();
    }

    public void paint(Graphics g){
        Dimension size = getSize();
        g.setColor(color);
        g.fillRect(0,0, size.width, size.height);

        //System.out.println("paint");
    }
}
