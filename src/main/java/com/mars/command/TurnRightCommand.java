package com.mars.command;

import com.mars.grid.Grid;
import com.mars.model.Robot;

public class TurnRightCommand implements Command
{
    @Override
    public void execute(Robot robot, Grid grid)
    {
        robot.turnRight();
    }
}
