import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public class Arena {
    private int width;
    private int height;

    private List<Wall> walls;

    Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;

        hero = new Hero(10, 10);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFC0CB"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
    }

    public void setPosition(Position position) {
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        if( 0 <= position.getX() && position.getX() < width && 0 <= position.getY() && position.getY() < height)
            return true;
        else
            return false;
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