package com.mars.grid;

import com.mars.model.Position;

public class Grid
{
    private final int maxX;
    private final int maxY;
    private final ScentManager scentManager;

    public Grid(int maxX, int maxY)
    {
        if (maxX < 0 || maxY < 0 || maxX > 50 || maxY > 50)
        {
            throw new IllegalArgumentException("Grid coordinates must be between 0 and 50");
        }
        this.maxX = maxX;
        this.maxY = maxY;
        this.scentManager = new ScentManager();
    }

    public boolean isWithinBounds(Position position)
    {
        return position.getX() >= 0 && position.getX() <= maxX &&
                position.getY() >= 0 && position.getY() <= maxY;
    }

    public boolean hasScent(Position position)
    {
        return scentManager.hasScent(position);
    }

    public void leaveScent(Position position)
    {
        scentManager.addScent(position);
    }
}
