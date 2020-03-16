public class Ellipse implements Shape {
    double xRadius;
    double yRadius;

    public Ellipse(double x, double y) {
        this.xRadius = x;
        this.yRadius = y;
    }

    public double getArea() {
        return Math.PI * xRadius * yRadius;
    }

    public void draw() {
        System.out.print("Ellipse");
    }
}
