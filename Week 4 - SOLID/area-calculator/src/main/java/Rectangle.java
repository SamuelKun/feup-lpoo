public class Rectangle implements Shape {

    private double width, height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public double getArea() {
        return width * height;
    }

    public void draw() {
        System.out.println(this.getClass().getName());
    }
}