package com.company;

import java.util.*;

public class AStar {
    private Point2D startPoint, endPoint;
    private int width, height;
    private HashMap<MapCell,Integer> costMap = new HashMap<MapCell,Integer>();

    AStar(int width, int height, Point2D startPoint, Point2D endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.width = width;
        this.height = height;
    }

    public void findPath(MapCell[][] map){
        Comparator<MapCell> comparator = new MyComparator();
        Queue<MapCell> front = new PriorityQueue<MapCell>(comparator);
        HashMap<MapCell,MapCell> path = new HashMap<MapCell,MapCell>();
        path.put(map[startPoint.y][startPoint.x],null);
        costMap.put(map[startPoint.y][startPoint.x],0);
        front.add(map[startPoint.y][startPoint.x]);
        while (!front.isEmpty()){
            MapCell current = front.poll();
            if(current == map[endPoint.y][endPoint.x])break;
            for (MapCell next:getNeighbors(map,current.getxCoord(),current.getyCoord(),width,height)) {
                int new_cost = costMap.get(current) + next.getCost();
                if(!next.isPassable())continue;
                if(!costMap.containsKey(next) || new_cost < costMap.get(next)){
                    costMap.put(next,new_cost);
                    front.add(next);
                    path.put(next, current);
                }
            }
        }

        MapCell current = map[endPoint.y][endPoint.x];
        while (current != map[startPoint.y][startPoint.x]){
            current = path.get(current);
            current.setPath(true);
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

    private class MyComparator implements Comparator<MapCell> {

        private double distanceToEnd(int x, int y){
            return Math.abs(x - endPoint.x) + Math.abs(y - endPoint.y);
        }

        @Override
        public int compare(MapCell o1, MapCell o2) {

            if (distanceToEnd(o1.getxCoord(),o1.getyCoord()) + costMap.get(o1) < distanceToEnd(o2.getxCoord(),o2.getyCoord()) + costMap.get(o2)) {
                return -1;
            }
            if (distanceToEnd(o1.getxCoord(),o1.getyCoord()) + costMap.get(o1) > distanceToEnd(o2.getxCoord(),o2.getyCoord()) + costMap.get(o2)) {
                return 1;
            }
            return 0;
        }
    }
}
