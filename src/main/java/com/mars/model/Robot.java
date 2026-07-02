package com.mars.model;

public class Robot
{
    private Position position;
    private Direction direction;
    private boolean lost;

    public Robot(Position position, Direction direction)
    {
        this.position = position;
        this.direction = direction;
        this.lost = false;
    }

    public void turnLeft()
    {
        if (!lost)
        {
            direction = direction.turnLeft();
        }
    }

    public void turnRight()
    {
        if (!lost)
        {
            direction = direction.turnRight();
        }
    }

    public void moveForward()
    {
        if (!lost)
        {
            position = position.move(direction);
        }
    }

    public Position getNextPosition()
    {
        return position.move(direction);
    }

    public Position getPosition()
    {
        return position;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public boolean isLost()
    {
        return lost;
    }

    public void setLost(boolean lost)
    {
        this.lost = lost;
    }

    @Override
    public String toString()
    {
        return position + " " + direction + (lost ? " LOST" : "");
    }
}
