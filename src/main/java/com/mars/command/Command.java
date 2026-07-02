package com.mars.command;

import com.mars.grid.Grid;
import com.mars.model.Robot;

public interface Command
{
    void execute(Robot robot, Grid grid);
}
