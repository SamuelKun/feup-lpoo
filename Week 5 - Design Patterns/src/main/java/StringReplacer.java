public class StringReplacer implements StringTransformer{
    char oldChar;
    char newChar;

    String undo;

    public StringReplacer(char oldChar, char newChar) {
        this.oldChar = oldChar;
        this.newChar= newChar;
    }

    public void execute(StringDrink drink) {
        this.undo = drink.getText();
        String text = drink.getText().replace(oldChar, newChar);
        drink.setText(text);
    }

    public void undo(StringDrink drink) {
        drink.setText(this.undo);
    }
}
