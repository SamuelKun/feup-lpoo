public class Triangle implements Shape {
    double height;
    double base;

    public Triangle(double h, double b) {
        this.base = b;
        this.height = h;
    }

    public double getArea() {
        return height * base / 2;
    }

    public void draw() {
        System.out.print("Triangle");
    }
}
