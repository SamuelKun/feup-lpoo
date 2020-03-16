public class Line implements BasicShape {
    double lenght;

    public Line(double l) {
        this.lenght = l;
    }

    public double getArea() throws NoAreaException {
        throw new NoAreaException();
    }

    public void draw() {
        System.out.print("Line");
    }
}
