public class AreaStringOutputter {
    SumProvider obj;

    public AreaStringOutputter(SumProvider obj) {
        this.obj = obj;
    }

    public String output() {
        return "Sum of areas: " + obj.sum();
    }
}
