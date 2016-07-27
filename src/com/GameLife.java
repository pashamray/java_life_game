package com;

import com.life.grid.GameGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 27.07.2016.
 */
public class GameLife extends JFrame implements IGame {

    private final int TIMER_DELAY = 500;

    private final Timer timer;
    private final GameGrid gameGrid;

    public GameLife(String title, int width, int height) throws HeadlessException {
        super(title);

        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameGrid = new GameGrid(20, 20);
        add(gameGrid);

        gameGrid.start();

        timer = new Timer(TIMER_DELAY, new TimerListener(this));
        timer.start();
    }

    @Override
    public void tick() {
        System.out.println("tick");
    }
}

class TimerListener implements ActionListener{

    private final IGame game;

    public TimerListener(IGame game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.tick();
    }
}
