package com.mars;

import com.mars.processor.RobotProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest
{

    @Test
    void testSampleInput()
    {
        String input = """
            5 3
            1 1 E
            RFRFRFRF
            3 2 N
            FRRFLLFFRRFLL
            0 3 W
            LLFFFLFLFL""";

        RobotProcessor processor = new RobotProcessor(); // No parameter needed
        List<String> results = processor.processInput(input);

        assertEquals(3, results.size());
        assertEquals("1 1 E", results.get(0));
        assertEquals("3 3 N LOST", results.get(1));
        assertEquals("2 3 S", results.get(2));
    }

    @Test
    void testRobotStaysOnGrid() {
        String input = """
            5 5
            0 0 N
            FFFFF""";

        RobotProcessor processor = new RobotProcessor();
        List<String> results = processor.processInput(input);

        assertEquals(1, results.size());
        assertEquals("0 5 N", results.get(0));
    }

    @Test
    void testRobotLost() {
        String input = """
            5 5
            0 0 S
            F""";

        RobotProcessor processor = new RobotProcessor();
        List<String> results = processor.processInput(input);

        assertEquals(1, results.size());
        assertEquals("0 0 S LOST", results.get(0));
    }

    @Test
    void testScentPreventsLoss() {
        String input = """
            5 5
            0 0 S
            F
            0 0 S
            F""";

        RobotProcessor processor = new RobotProcessor();
        List<String> results = processor.processInput(input);

        assertEquals(2, results.size());
        assertEquals("0 0 S LOST", results.get(0));
        assertEquals("0 0 S", results.get(1));
    }

    @Test
    void testEmptyInput() {
        String input = "5 5";

        RobotProcessor processor = new RobotProcessor();
        List<String> results = processor.processInput(input);

        assertTrue(results.isEmpty());
    }

    @Test
    void testMultipleRobotsNoLoss() {
        String input = """
            10 10
            0 0 N
            FFLFRR
            5 5 E
            FFRF""";

        RobotProcessor processor = new RobotProcessor();
        List<String> results = processor.processInput(input);

        assertEquals(2, results.size());
    }

    @Test
    void testRobotIgnoresCommandsAfterLost() {
        String input = """
            5 5
            0 0 S
            FFFFF""";

        RobotProcessor processor = new RobotProcessor();
        List<String> results = processor.processInput(input);

        assertEquals(1, results.size());
        // Should be lost at position 0 0, not 0 -1
        assertEquals("0 0 S LOST", results.get(0));
    }
}
