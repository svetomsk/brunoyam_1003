package robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RobotMotion {
    public static void main(String[] args) {
        int n = 10;

        Robot robot = new Robot(n, '$');
//        System.out.println(robot.getX());
//        System.out.println(robot.getY());
//
//        robot.setX(3);
//        robot.setY(4);
//
//        System.out.println(robot.getX());
//        System.out.println(robot.getY());
//
//        robot.move(Directions.DOWN);
//        System.out.println(robot.getX());
//        System.out.println(robot.getY());

        List<List<Character>> field = new ArrayList<>(); // int[][]
        // initialize field
        for (int i = 0; i < n; i++) {
            List<Character> currentRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                currentRow.add(' ');
            }
            field.add(currentRow);
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            printField(field);
            String command = sc.next();
            if (command.equalsIgnoreCase("right")) {
                replaceRobot(field, robot, Directions.RIGHT);
            } else if (command.equalsIgnoreCase("left")) {
                replaceRobot(field, robot, Directions.LEFT);
            } else if (command.equalsIgnoreCase("up")) {
                replaceRobot(field, robot, Directions.UP);
            } else if (command.equalsIgnoreCase("down")) {
                replaceRobot(field, robot, Directions.DOWN);
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Wrong command");
            }
        }

    }

    public static void replaceRobot(List<List<Character>> field, Robot robot, Directions dir) {
        int x = robot.getX();
        int y = robot.getY();
        // оставляем след
        field.get(y).set(x, robot.getTrace()); // field[y][x] = robot.trace()
        // перемещаем робота
//        robot.move(Directions.RIGHT);
        robot.move(dir);
        //
        field
                .get(robot.getY())
                .set(robot.getX(), Robot.ROBOT_SYMBOL);
    }

    public static void printField(List<List<Character>> field) {
        for(List<Character> row : field) {
            System.out.println(row);
//            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" | ")));
        }
    }
}
