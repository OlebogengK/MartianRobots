package com.mars.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory
{
    private static final Map<Character, Command> COMMANDS = new HashMap<>();

    static
    {
        COMMANDS.put('L', new TurnLeftCommand());
        COMMANDS.put('R', new TurnRightCommand());
        COMMANDS.put('F', new MoveForwardCommand());
    }

    public static Command getCommand(char instruction)
    {
        Command command = COMMANDS.get(Character.toUpperCase(instruction));
        if (command == null)
        {
            throw new IllegalArgumentException("Unknown instruction: " + instruction);
        }
        return command;
    }

    public static void registerCommand(char instruction, Command command)
    {
        COMMANDS.put(instruction, command);
    }
}
