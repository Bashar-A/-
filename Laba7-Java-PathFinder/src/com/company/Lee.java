package com.company;

import java.util.*;

public class Lee {
    private Point2D startPoint, endPoint;
    private int width, height;

    Lee(int width, int height, Point2D startPoint, Point2D endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.width = width;
        this.height = height;
    }

    public void findPath(MapCell[][] map){
        HashMap<MapCell,Integer> Map = new HashMap<MapCell,Integer>();
        LinkedList<MapCell> list = new LinkedList<>();
        map[startPoint.y][startPoint.x].setD(0);
        list.add(map[startPoint.y][startPoint.x]);
        while (!list.isEmpty()){
            MapCell current = list.poll();
            if(current == map[endPoint.y][endPoint.x])break;
            for (MapCell cell:getNeighbors(map,current.getxCoord(),current.getyCoord(),width,height)) {
                if(!cell.isPassable())continue;
                if(cell.getD() < 0){
                    cell.setD(current.getD() + 1);
                    list.add(cell);
                }
            }
        }

        MapCell current = map[endPoint.y][endPoint.x];
        if(current.getD() == -1)return;
        while (current != map[startPoint.y][startPoint.x]){
            for (MapCell cell:getNeighbors(map,current.getxCoord(),current.getyCoord(),width,height)) {
                if(cell.getD() + 1 ==  current.getD()){
                    current = cell;
                    cell.setPath(true);
                }
            }
        }


    }


    public ArrayList<MapCell> getNeighbors(MapCell[][] mapCells, int x, int y, int width, int height){
        ArrayList<MapCell> list = new ArrayList<MapCell>();
        if(!(x + 1 >= width))list.add(mapCells[y][x+1]);
        if(!(y + 1 >= height))list.add(mapCells[y+1][x]);
        if(!(x - 1 < 0))list.add(mapCells[y][x-1]);
        if(!(y - 1 < 0))list.add(mapCells[y-1][x]);
        if(!(x - 1 < 0) && !(y + 1 >= height))list.add(mapCells[y+1][x-1]);
        if(!(x + 1 >= width) && !(y - 1 < 0))list.add(mapCells[y-1][x+1]);
        if(!(x + 1 >= width) && !(y + 1 >= height))list.add(mapCells[y+1][x+1]);
        if(!(x - 1 < 0) && !(y - 1 < 0))list.add(mapCells[y-1][x-1]);
        return list;
    }

}
