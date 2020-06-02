package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Map2D extends JPanel {
    private int cellsWidth, cellsHeight;
    public MapCell[][] mapCells;
    private Point2D startPoint, endPoint;

    Map2D(int cellsWidth, int cellsHeight, Point2D startPoint, Point2D endPoint){
        Random random = new Random();
        GridBagLayout gbLayout = new GridBagLayout();
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.weightx = 1;
        gbConstraints.weighty = 1;
        gbConstraints.insets.set(0, 0, 1, 1);

        this.setLayout(gbLayout);
        this.cellsWidth = cellsWidth;
        this.cellsHeight = cellsHeight;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        mapCells = new MapCell[cellsHeight][cellsWidth];

        for (int i = 0; i < cellsHeight; i++){
            for (int j = 0; j < cellsWidth; j++){
                mapCells[i][j] = new MapCell(random.nextInt(20) + 1,j,i);
                if(i == startPoint.y && j == startPoint.x)mapCells[i][j].setStartPoint(true);
                if(i == endPoint.y && j == endPoint.x)mapCells[i][j].setEndPoint(true);
                gbConstraints.gridx = i;
                gbConstraints.gridy = j;
                gbLayout.setConstraints(mapCells[i][j], gbConstraints);
                this.add(mapCells[i][j]);
            }
        }
    }
    Map2D(int cellsWidth, int cellsHeight){
        this(cellsWidth, cellsHeight,new Point2D(0,0), new Point2D(cellsWidth - 1, cellsHeight - 1));
    }
    Map2D(){
        this(20,20);
    }


    public Point2D getStartPoint() {
        return startPoint;
    }

    public Point2D getEndPoint() {
        return endPoint;
    }

    public int getCellsHeight() {
        return cellsHeight;
    }

    public int getCellsWidth() {
        return cellsWidth;
    }

    public void setStartPoint(int x, int y) {
        mapCells[startPoint.y][startPoint.x].setStartPoint(false);
        mapCells[y][x].setStartPoint(true);
        startPoint.setX(x);
        startPoint.setY(y);
    }

    public void setEndPoint(int x, int y) {
        mapCells[endPoint.y][endPoint.x].setEndPoint(false);
        mapCells[y][x].setEndPoint(true);
        endPoint.setX(x);
        endPoint.setY(y);
    }

    public void setNotPath(){
        for (int i = 0; i < cellsHeight; i++){
            for (int j = 0; j < cellsWidth; j++){
                mapCells[i][j].setPath(false);
            }
        }
    }

    public void setAllD(){
        for (int i = 0; i < cellsHeight; i++){
            for (int j = 0; j < cellsWidth; j++){
                mapCells[i][j].setD(-1);
            }
        }
    }

    public void setAllStar(boolean flag){
        for (int i = 0; i < cellsHeight; i++){
            for (int j = 0; j < cellsWidth; j++){
                mapCells[i][j].setStar(flag);
                mapCells[i][j].repaint();
            }
        }
    }

}
