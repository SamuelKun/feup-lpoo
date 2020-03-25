import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    StringDrink drink;
    StringRecipe recipe;

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) bar.order(drink, recipe);
        else {
            this.drink = drink;
            this.recipe = recipe;
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        wants(this.drink, this.recipe, bar);

    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
