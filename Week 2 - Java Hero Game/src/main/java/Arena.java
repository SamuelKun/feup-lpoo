import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;

    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;

        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();

        hero = new Hero(10, 10);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    public void retrieveCoins(Position position) {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                break;
            }
        }
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public void setPosition(Position position) {
        hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    private boolean canMonsterMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    private boolean verifyMonsterCollisions(Position position) {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    private void moveMonsters() {
        Random rand = new Random();
        for (Monster monster : monsters) {
            int move = rand.nextInt(3);
            switch (move) {
                case 0:
                    if(canMonsterMove(monster.moveUp()))
                        monster.setPosition(monster.moveUp());
                    break;
                case 1:
                    if(canMonsterMove(monster.moveDown()))
                        monster.setPosition(monster.moveDown());
                    break;
                case 2:
                    if(canMonsterMove(monster.moveLeft()))
                        monster.setPosition(monster.moveLeft());
                    break;
                case 3:
                    if(canMonsterMove(monster.moveRight()))
                        monster.setPosition(monster.moveRight());
                    break;
                default:
                    System.out.print("Error: Invalid Monster Movement");
                    break;
            }

        }
    }

    private void moveHero(Position position) {
        if(canHeroMove(position)) {
            setPosition(position);
            retrieveCoins(position);
        }
        moveMonsters();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#B97A57"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);

        for (Coin coin : coins)
            coin.draw(graphics);

        for (Monster monster : monsters)
            monster.draw(graphics);
    }

    public boolean processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                moveHero(hero.moveUp());
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                return false;
            case ArrowDown:
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                moveHero(hero.moveDown());
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                return false;
            case ArrowRight:
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                moveHero(hero.moveRight());
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                return false;
            case ArrowLeft:
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                moveHero(hero.moveLeft());
                if(verifyMonsterCollisions(hero.getPosition())) return true;
                return false;
            default:
                return true;
        }
    }
}
