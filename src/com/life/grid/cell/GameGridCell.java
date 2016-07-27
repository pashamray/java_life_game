package com.life.grid.cell;

import java.awt.*;

/**
 * Created by user on 27.07.2016.
 */
public class GameGridCell extends Canvas {

    private final Color activeColor = Color.RED;
    private final Color deactiveColor = Color.BLACK;
    private Color color;

    public GameGridCell() {
        color = Color.GRAY;
    }

    public void active(){
        color = activeColor;
    }

    public void deactive(){
        color = deactiveColor;
    }

    public void paint(Graphics g){
        Dimension size = getSize();
        g.setColor(color);
        g.fillRect(0,0, size.width, size.height);

        //System.out.println("paint");
    }
}
