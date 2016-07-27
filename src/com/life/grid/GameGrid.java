package com.life.grid;

import com.life.grid.cell.GameGridCell;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 27.07.2016.
 */
public class GameGrid extends JPanel implements IGameGrid {

    private final int rows;
    private final int cols;

    private GameGridCell[][] cells;

    public GameGrid(int rows, int cols) {
        super(new GridLayout(rows, cols));

        this.rows = rows;
        this.cols = cols;

        init();
    }

    private void init(){

        cells = new GameGridCell[rows][cols];

        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                GameGridCell cell = new GameGridCell();
                cells[i][j] =  cell;
                add(cell);
            }
        }
    }

    public void start(){
        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++){
                if(Math.random() > 0.5) {
                    cells[i][j].active();
                } else {
                    cells[i][j].deactive();
                }
            }
        }
    }

    public void pause(){

    }

    public void stop(){

    }

    @Override
    public void reset() {

    }
}
