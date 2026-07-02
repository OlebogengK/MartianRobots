package com.mars.processor;

import com.mars.command.CommandFactory;
import com.mars.grid.Grid;
import com.mars.model.Direction;
import com.mars.model.Position;
import com.mars.model.Robot;

import java.util.ArrayList;
import java.util.List;

public class RobotProcessor
{
    public List<String> processInput(String input)
    {
        List<String> results = new ArrayList<>();
        String[] lines = input.trim().split("\\n");

        if (lines.length < 1)
        {
            return results;
        }

        String[] gridDimensions = lines[0].trim().split("\\s+");
        if (gridDimensions.length != 2)
        {
            throw new IllegalArgumentException("Invalid grid dimensions");
        }

        int maxX = Integer.parseInt(gridDimensions[0]);
        int maxY = Integer.parseInt(gridDimensions[1]);
        Grid robotGrid = new Grid(maxX, maxY);

        for (int i = 1; i < lines.length; i += 2)
        {
            if (i + 1 >= lines.length)
            {
                break;
            }

            String positionLine = lines[i].trim();
            String instructionLine = lines[i + 1].trim();

            if (positionLine.isEmpty() || instructionLine.isEmpty())
            {
                continue;
            }

            String result = processRobot(robotGrid, positionLine, instructionLine);
            results.add(result);
        }
        return results;
    }

    private String processRobot(Grid grid, String positionLine, String instructionLine)
    {
        String[] parts = positionLine.split("\\s+");
        if (parts.length != 3)
        {
            throw new IllegalArgumentException("Invalid robot position: " + positionLine);
        }

        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Direction direction = Direction.valueOf(parts[2].toUpperCase());

        Robot robot = new Robot(new Position(x, y), direction);

        for (char instruction : instructionLine.toCharArray())
        {
            if (robot.isLost())
            {
                break;
            }
            try
            {
                CommandFactory.getCommand(instruction).execute(robot, grid);
            }
            catch (IllegalArgumentException e)
            {
                System.err.println("Warning: " + e.getMessage());
            }
        }

        return robot.toString();
    }
}
