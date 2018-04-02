import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testWhenRectanglesOverlap(){
        Point rectABottomLeft = new Point(-1,-1);
        Point rectATopRight = new Point(10,10);
        Point rectBBottomLeft = new Point(-1,0);
        Point rectBTopRight = new Point(3,9);
        List<Point> points = new ArrayList<>();
        points.add(rectABottomLeft);
        points.add(rectATopRight);
        points.add(rectBBottomLeft);
        points.add(rectBTopRight);
        assertEquals(36,Main.calculateOverlappingArea(points));
    }

    @Test
    public void testWhenRectanglesDoNotOverlap() {
        Point rectABottomLeft = new Point(-12, -4);
        Point rectATopRight = new Point(-1, -2);
        Point rectBBottomLeft = new Point(0, 0);
        Point rectBTopRight = new Point(100, 3000);
        List<Point> points = new ArrayList<>();
        points.add(rectABottomLeft);
        points.add(rectATopRight);
        points.add(rectBBottomLeft);
        points.add(rectBTopRight);
        assertEquals(0, Main.calculateOverlappingArea(points));
    }

    @Test
    public void testWhenRectangleTouchesAnotherRectangle() {
        Point rectABottomLeft = new Point(1, 1);
        Point rectATopRight = new Point(3, 3);
        Point rectBBottomLeft = new Point(3, 1);
        Point rectBTopRight = new Point(6, 3);
        List<Point> points = new ArrayList<>();
        points.add(rectABottomLeft);
        points.add(rectATopRight);
        points.add(rectBBottomLeft);
        points.add(rectBTopRight);
        assertEquals(0, Main.calculateOverlappingArea(points));
    }


    @Test
    public void testWhenRectangleContainsAnotherRectangle() {
        Point rectABottomLeft = new Point(1, 1);
        Point rectATopRight = new Point(5, 5);
        Point rectBBottomLeft = new Point(2, 2);
        Point rectBTopRight = new Point(4, 4);
        List<Point> points = new ArrayList<>();
        points.add(rectABottomLeft);
        points.add(rectATopRight);
        points.add(rectBBottomLeft);
        points.add(rectBTopRight);
        assertEquals(4, Main.calculateOverlappingArea(points));
    }

    @Test
    public void testWhenRectanglesHaveNegativeValues() {
        Point rectABottomLeft = new Point(-7, -7);
        Point rectATopRight = new Point(-2, -2);
        Point rectBBottomLeft = new Point(-5, -5);
        Point rectBTopRight = new Point(-1, -1);
        List<Point> points = new ArrayList<>();
        points.add(rectABottomLeft);
        points.add(rectATopRight);
        points.add(rectBBottomLeft);
        points.add(rectBTopRight);
        assertEquals(9, Main.calculateOverlappingArea(points));
    }

    @Test
    public void testIfCalculateDistanceIsCorrect() {
        Point rectABottomLeft = new Point(-12,-4);
        Point rectATopRight = new Point(-1,-2);
        Point rectBBottomLeft = new Point(0,0);
        Point rectBTopRight = new Point(100,3000);
        int length = Main.calculateDistance(rectABottomLeft.getX(), rectBBottomLeft.getX(), rectATopRight.getX(), rectBTopRight.getX());
        int height = Main.calculateDistance(rectABottomLeft.getY(), rectBBottomLeft.getY(), rectATopRight.getY(), rectBTopRight.getY());
        assertEquals(-1,length);
        assertEquals(-2,height);
    }

}