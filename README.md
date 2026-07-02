# Martian Robots

A Java solution for the Martian Robots programming challenge. Simulates robots moving on a rectangular grid on Mars based on instructions from Earth.

## The Problem

Robots move on a rectangular grid according to instructions (L = turn left, R = turn right, F = move forward). Robots that fall off the grid are lost and leave a "scent" that prevents future robots from falling at the same position.

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## How to Run

```bash
git clone https://github.com/OlebogengK/MartianRobots.git
mvn clean package
java -jar target/martian-robots-1.0-SNAPSHOT.jar
```

## How to Test

```bash
mvn test
```

## Sample Output

```
Input:
5 3
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL

Output:
1 1 E
3 3 N LOST
2 3 S
```

## Project Structure

```
src/
├── main/java/com/mars/
│   ├── model/        # Robot, Position, Direction
│   ├── command/      # Command pattern (L, R, F)
│   ├── grid/         # Grid boundaries and scent tracking
│   ├── processor/    # Input parsing and robot processing
│   └── App.java      # Entry point with sample data
└── test/java/com/mars/
    └── AppTest.java  # Unit tests
```

## Design Decisions

- **Command Pattern** - Each instruction is its own class, making it easy to add future command types
- **Immutability** - Position objects are immutable to prevent state corruption
- **Scent Management** - Uses HashSet for O(1) scent lookups
- **Sequential Processing** - Robots are processed one at a time as specified
