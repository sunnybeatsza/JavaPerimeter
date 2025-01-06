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

    public Double getLargestSide(Shape s){
        ArrayList<Point> points = s.getPoints();
        double largestSide = 0;
        for (int i = 0; i < points.size(); i++){
            Point current = points.get(i);
            Point next = points.get((i + 1) % points.size()); // Wrap around to the first point
            double distance = current.distance(next);
            if (distance > largestSide){
                largestSide = distance;
            }
        } return largestSide;
    }

    public Double getLargestX(Shape s){
        ArrayList<Point> points = s.getPoints();
        double largestX = points.get(0).getX();
        for (Point current : points) {
            double getCurrentX = current.getX();
            if (getCurrentX > largestX) {
                largestX = getCurrentX;
            }
        }
        return largestX;
    }

    public Double getLargestPerimeterMultipleFiles() throws IOException {
        DirectoryResource directoryResource = new DirectoryResource();
        ArrayList<String> filePaths = directoryResource.getFilePaths(directoryResource.selectMultipleFiles());
        ArrayList<Double> perimeters = new ArrayList<>();
        for (String file: filePaths){
            FileResource fr = new FileResource(file);
            Shape shape = new Shape(fr.points);
            PerimeterRunner perimeter = new PerimeterRunner();
            perimeters.add(perimeter.calculatePerimeter(shape));
        }
        double largestPerimeter = perimeters.get(0);
        for (Double perimeter : perimeters){
            if (perimeter > largestPerimeter){
                largestPerimeter = perimeter;
            }
        } return largestPerimeter;
    }

    public static void main(String[] args) throws IOException {
        FileResource fr = new FileResource("src//example2.txt");
        Shape shape1 = new Shape(fr.points);
        PerimeterRunner perimeter = new PerimeterRunner();

        System.out.println(perimeter.calculatePerimeter(shape1));
        System.out.println("There are " + perimeter.getNumPoints(shape1) + " points");
        System.out.println(perimeter.getAverageLength(shape1));
        System.out.println(perimeter.getLargestSide(shape1));
        System.out.println(perimeter.getLargestX(shape1));

        System.out.println(perimeter.getLargestPerimeterMultipleFiles());
    }
}