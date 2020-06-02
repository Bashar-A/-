package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapCell extends JComponent {
    private static final Dimension CELL_SIZE = new Dimension(12, 12);
    private int xCoord, yCoord;
    private int cost;
    private int d = -1;
    private boolean Star = true;
    private boolean passable;
    private boolean path = false;
    private boolean startPoint = false;
    private boolean endPoint = false;
    MapCell(int value, int xCoord, int yCoord, boolean passable){
        setPreferredSize(CELL_SIZE);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        cost = value;
        setPassable(passable);
        this.addMouseListener(new CellHandler());
    }

    MapCell(int value, int xCoord, int yCoord){
        this(value, xCoord, yCoord,true);
    }


    public void setPath(boolean path) {
        this.path = path;
        updateCell();
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
        updateCell();
    }


    public boolean isPassable()
    {
        return passable;
    }

    public void togglePassable()
    {
        setPassable(!isPassable());
    }

    public boolean isStartPoint() {
        return startPoint;
    }

    public boolean isEndPoint() {
        return endPoint;
    }

    public void setStartPoint(boolean startPoint) {
        this.startPoint = startPoint;
        updateCell();
    }

    public void setEndPoint(boolean endPoint) {
        this.endPoint = endPoint;
        updateCell();
    }

    public void setStar(boolean star) {
        Star = star;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getCost() {
        return cost;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getD() {
        return d;
    }


    private void updateCell(){
        if (passable)
        {
            setBackground(Color.decode("#333333"));
            if (startPoint || endPoint)
                setBackground(Color.CYAN);
            else if (path)
                setBackground(Color.YELLOW);
        }
        else
        {
            setBackground(Color.RED);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, getHeight() - 7));

        g.setColor(getBackground());
        g.fillRect(0,0,getWidth(),getHeight());
        if(path)g.setColor(Color.decode("#333333"));
        else g.setColor(Color.WHITE);
        if(!(startPoint || endPoint || !passable)){
            if(Star)drawCenteredString(g,String.valueOf(cost),new Rectangle(0,0,getWidth(),getHeight()));
            else if(d != -1){
                drawCenteredString(g,String.valueOf(d),new Rectangle(0,0,getWidth(),getHeight()));
            }
            else {
                drawCenteredString(g,"",new Rectangle(0,0,getWidth(),getHeight()));
            }
        }
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(text, x, y);
    }


    private class CellHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            MapCell cell = (MapCell) e.getSource();
            if(!(cell.isStartPoint() || cell.isEndPoint())){
                cell.togglePassable();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }
}
