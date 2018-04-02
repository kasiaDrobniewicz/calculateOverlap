import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List <Point> points= new ArrayList<>();

        System.out.println("Welcome in my Application!");

        try {
            points = getInputData();
        } catch (InputMismatchException e) {
            System.out.println("Value out of range - it should be from -2 147 483 648 to 2 147 483 647");
        }

        System.out.println("Overlapping area size: " + calculateOverlappingArea(points));
    }

    public static List<Point> getInputData() throws InputMismatchException {
        List <Point> points= new ArrayList<>();
        int rectABottomLeftX = getIntInput("Enter bottom left \"X\" coordinate for the first rectangle:");
        int rectABottomLeftY = getIntInput("Enter bottom left \"Y\" coordinate for the first rectangle:");
        Point rectABottomLeft = new Point(rectABottomLeftX, rectABottomLeftY);
        points.add(rectABottomLeft);
        int rectATopRighttX = getIntInput("Enter top right \"X\" coordinate for the first rectangle:");
        int rectATopRighttY = getIntInput("Enter top right \"Y\" coordinate for the first rectangle:");
        Point rectATopRight = new Point(rectATopRighttX, rectATopRighttY);
        points.add(rectATopRight);
        int rectBBottomLeftX = getIntInput("Enter bottom left \"X\" coordinate for the second rectangle:");
        int rectBBottomLeftY = getIntInput("Enter bottom left \"Y\" coordinate for the second rectangle:");
        Point rectBBottomLeft = new Point(rectBBottomLeftX, rectBBottomLeftY);
        points.add(rectBBottomLeft);
        int rectBTopRighttX = getIntInput("Enter top right \"X\" coordinate for the second rectangle:");
        int rectBTopRighttY = getIntInput("Enter top right \"Y\" coordinate for the second rectangle:");
        Point rectBTopRight = new Point(rectBTopRighttX, rectBTopRighttY);
        points.add(rectBTopRight);

        return points;
    }

    public static int calculateDistance (int rectABottomLeftXY, int rectBBottomLeftXY, int rectATopRightXY, int rectBTopRightXY) {

        return Math.min(rectATopRightXY, rectBTopRightXY) - Math.max(rectABottomLeftXY, rectBBottomLeftXY); // if negative or zero then rectangles don't overlap

    }

    public static int calculateOverlappingArea (List<Point> points) {
        int overlappingArea = 0;
        int length = calculateDistance(points.get(0).getX(), points.get(2).getX(), points.get(1).getX(), points.get(3).getX());
        int height = calculateDistance(points.get(0).getY(), points.get(2).getY(), points.get(1).getY(), points.get(3).getY());

        if (length > 0 && height > 0) {
            overlappingArea = length * height;
        }

        return overlappingArea;
    }

    public static int getIntInput(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

}
