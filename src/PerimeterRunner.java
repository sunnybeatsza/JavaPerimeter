import java.io.IOException;
import java.util.ArrayList;

public class PerimeterRunner {

    public double calculatePerimeter(Shape shape){
        ArrayList<Point> points = shape.getPoints();
        double totalPerimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point current = points.get(i);
            Point next = points.get((i + 1) % points.size()); // Wrap around to the first point
            totalPerimeter += current.distance(next);
        }
        return totalPerimeter;
    }

    public Integer getNumPoints(Shape s){
        ArrayList<Point> points = s.getPoints();
        return points.size();
    }

    public Double getAverageLength(Shape s){
        ArrayList<Point> points = s.getPoints();
        return calculatePerimeter(s)/points.size();
    }

    public static void main(String[] args) throws IOException {
        FileResource fr = new FileResource("src//example2.txt");
        Shape shape1 = new Shape(fr.points);
        PerimeterRunner perimeter = new PerimeterRunner();
        System.out.println(perimeter.calculatePerimeter(shape1));
        System.out.println("There are " + perimeter.getNumPoints(shape1) + " points");
        System.out.println(perimeter.getAverageLength(shape1));
    }
}