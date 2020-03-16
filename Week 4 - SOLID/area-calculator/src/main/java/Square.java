public class Square implements Shape {
    double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double getArea() {
            return side * side;
    }

    public void draw() {
        System.out.print("Square");
    }
}
