import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int width;
    private int height;

    Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;

        hero = new Hero(10, 10);
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }

    public Position moveUp() {
        return hero.moveUp();
    }

    public Position moveDown() {
        return hero.moveDown();
    }

    public Position moveLeft() {
        return hero.moveLeft();
    }

    public Position moveRight() {
        return hero.moveRight();
    }

    public void setPosition(Position position) {
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        return true;
    }

    private void moveHero(Position position) {
        setPosition(position);
    }

    public boolean processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                return false;
            case ArrowDown:
                moveHero(hero.moveDown());
                return false;
            case ArrowRight:
                moveHero(hero.moveRight());
                return false;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                return false;
            default:
                return true;
        }
    }
}
