public class StringCaseChanger implements StringTransformer{
    String undo;

    public void execute(StringDrink drink) {
        StringBuilder text = new StringBuilder(drink.getText());
        this.undo = drink.getText();
        for(int i = 0; i < text.length(); i++) {
            char c = drink.getText().charAt(i);
            if(Character.isUpperCase(c)) c = Character.toLowerCase(c);
            else c = Character.toUpperCase(c);
            text.setCharAt(i, c);
        }
        drink.setText(text.toString());
    }

    public void undo(StringDrink drink) {
        drink.setText(this.undo);
    }
}
