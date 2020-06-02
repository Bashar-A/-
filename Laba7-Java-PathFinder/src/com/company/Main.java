package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static Map2D map = new Map2D();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pathfinder");
        JButton buttonStar = new JButton("A*");
        JButton buttonLee = new JButton("Lee Algo");
        JPanel panel1 = new JPanel();
        buttonStar.setBackground(Color.YELLOW);
        buttonLee.setBackground(Color.YELLOW);
        panel1.setBackground(Color.darkGray);
        map.setBackground(Color.darkGray);
        panel1.add(buttonStar);
        panel1.add(buttonLee);
        buttonStar.setActionCommand("Star");
        buttonLee.setActionCommand("Lee");
        buttonStar.addActionListener(new FindEvent());
        buttonLee.addActionListener(new FindEvent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(map);
        frame.add(panel1, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(600,600);
        frame.setVisible(true);

    }

    private static class FindEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            map.setNotPath();
            map.setAllD();
            if(button.getActionCommand().equals("Star")) {
                map.setAllStar(true);
                AStar pathFinder = new AStar(map.getCellsWidth(), map.getCellsHeight(), map.getStartPoint(), map.getEndPoint());
                long start = System.currentTimeMillis();
                pathFinder.findPath(map.mapCells);
                long end = System.currentTimeMillis();
                long elapsedTime = end - start;
                System.out.println("Elapsed time for A* = " + elapsedTime);
            }
            else {
                map.setAllStar(false);
                Lee pathFinder = new Lee(map.getCellsWidth(), map.getCellsHeight(), map.getStartPoint(), map.getEndPoint());
                long start = System.currentTimeMillis();
                pathFinder.findPath(map.mapCells);
                long end = System.currentTimeMillis();
                long elapsedTime = end - start;
                System.out.println("Elapsed time for Lee Algorithm = " + elapsedTime);
            }
        }
    }

}


