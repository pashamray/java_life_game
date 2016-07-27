package com.life.grid;

import com.life.grid.cell.GameGridCell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 27.07.2016.
 */
public class GameGrid extends JPanel implements IGameGrid {

    private final int rows;
    private final int cols;

    private GameGridCell[][] curCells;
    private boolean[][] cellLife;

    public GameGrid(int rows, int cols) {
        super(new GridLayout(rows, cols));

        this.rows = rows;
        this.cols = cols;

        init();
    }

    private void init(){

        curCells = new GameGridCell[rows][cols];
        cellLife = new boolean[rows][cols];

        for (int i = 0; i < curCells.length; i++){
            for (int j = 0; j < curCells[i].length; j++){
                GameGridCell cell = new GameGridCell();
                curCells[i][j] =  cell;
                cellLife[i][j] = false;
                add(cell);
            }
        }
    }

    public void start(){
        for (int i = 0; i < curCells.length; i++) {
            for(int j = 0; j < curCells[i].length; j++){
                if(Math.random() > 0.5) {
                    cellLife[i][j] = true;
                } else {
                    cellLife[i][j] = false;
                }
            }
        }

        step();
    }

    @Override
    public void reset() {
        for (int i = 0; i < curCells.length; i++) {
            for(int j = 0; j < curCells[i].length; j++){
                curCells[i][j].deactive();
            }
        }
    }

    @Override
    public void step() {
        calc_next();

        for (int i = 0; i < curCells.length; i++) {
            for(int j = 0; j < curCells[i].length; j++){
                if(cellLife[i][j] == true) {
                    curCells[i][j].active();
                } else {
                    curCells[i][j].deactive();
                }
            }
        }
    }

    private int modr(int a) {
        return (a + rows) % rows;
    }

    private int modc(int a) {
        return (a + cols) % cols;
    }

    private void calc_next() {

        int neighbors;

        // calc next state
        for (int r = 0; r < curCells.length; r++)
        {
            for (int c = 0; c < curCells[r].length; c++)
            {
                neighbors = 0;
                // count alive neighbors
                neighbors += (curCells[modr(r + 1)][modc(c)].isActive() == true) ? 1 : 0;
                neighbors += (curCells[modr(r) ][modc(c + 1)].isActive() == true) ? 1 : 0;
                neighbors += (curCells[modr(r - 1)][modc(c) ].isActive() == true) ? 1 : 0;
                neighbors += (curCells[modr(r) ][modc(c - 1)].isActive() == true) ? 1 : 0;
                neighbors += (curCells[modr(r + 1)][modc(c + 1)].isActive() == true) ? 1 : 0;
                neighbors += (curCells[modr(r - 1)][modc(c - 1)].isActive() == true) ? 1 : 0;
                neighbors += (curCells[modr(r + 1)][modc(c - 1)].isActive() == true) ? 1 : 0;
                neighbors += (curCells[modr(r - 1)][modc(c + 1)].isActive() == true) ? 1 : 0;

                if (curCells[r][c].isActive() == true) {
                    if (neighbors < 2 || neighbors > 3) {
                        cellLife[r][c] = false;
                    } else {
                        cellLife[r][c] = true;
                    }
                } else {
                    if (neighbors == 3) {
                        cellLife[r][c] = true;
                    }
                }
            }
        }
    }
}
