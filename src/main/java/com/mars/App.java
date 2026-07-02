package com.mars;

import com.mars.grid.Grid;
import com.mars.processor.RobotProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args)
    {
        // Using sample data from problem statement
        // For other inputs, replace the string below or modify to read from stdin/file
        String input = """
            5 3
            1 1 E
            RFRFRFRF
            3 2 N
            FRRFLLFFRRFLL
            0 3 W
            LLFFFLFLFL""";

        RobotProcessor processor = new RobotProcessor();
        List<String> results = processor.processInput(input);

        System.out.println("Input:");
        System.out.println(input);
        System.out.println();
        System.out.println("Output:");
        results.forEach(System.out::println);
    }
}
