public class StringInverter implements StringTransformer {
    String undo;

    public StringInverter() {}


    public void execute(StringDrink drink) {
        String text = drink.getText();
        this.undo = text;
        String reverse = new StringBuffer(text).reverse().toString();
        drink.setText(reverse);
    }

    public void undo(StringDrink drink) {
        drink.setText(this.undo);
    }
}
