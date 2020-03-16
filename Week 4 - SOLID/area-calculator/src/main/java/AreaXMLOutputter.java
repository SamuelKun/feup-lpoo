public class AreaXMLOutputter {
    SumProvider obj;

    public AreaXMLOutputter(SumProvider obj) {
        this.obj = obj;
    }

    public String output() {
        return "<area>" + obj.sum() + "</area>";
    }
}
