package com.mars.command;

import com.mars.grid.Grid;
import com.mars.model.Position;
import com.mars.model.Robot;

public class MoveForwardCommand implements Command
{
    @Override
    public void execute(Robot robot, Grid grid)
    {
        Position nextPosition = robot.getNextPosition();

        if (!grid.isWithinBounds(nextPosition))
        {
            if (!grid.hasScent(robot.getPosition()))
            {
                grid.leaveScent(robot.getPosition());
                robot.setLost(true);
            }
        }
        else
        {
            robot.moveForward();
        }
    }
}
