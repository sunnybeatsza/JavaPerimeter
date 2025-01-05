import java.util.ArrayList;

public class Shape {
    ArrayList<Point> finalShape;

    public Shape(ArrayList<String> points){
        ArrayList<Integer> pointAsNumbers = convertPoints(points);
        finalShape = createShape(pointAsNumbers);
    }

    public ArrayList<Integer> convertPoints(ArrayList<String> points){
        ArrayList<Integer> pointsAsNumbers = new ArrayList<>();
        for (String point : points) {
            String[] coordinates = point.split("[,\\s]+");
            for (String coordinate : coordinates) {
                pointsAsNumbers.add(Integer.parseInt(coordinate.trim()));
            }
        }
        return pointsAsNumbers;
    }


    public ArrayList<Point> createShape(ArrayList<Integer> pointAsNumbers) {
        ArrayList<Point> shape = new ArrayList<>();
        for (int i = 0; i < pointAsNumbers.size(); i += 2) {
            int x = pointAsNumbers.get(i);
            int y = pointAsNumbers.get(i + 1);
            shape.add(new Point(x, y));
        }
        return shape;
    }

    public ArrayList<Point> getPoints(){
        return finalShape;
    }

}