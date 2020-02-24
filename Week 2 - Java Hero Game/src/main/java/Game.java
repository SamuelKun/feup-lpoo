import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;

    Hero hero = new Hero(10, 10);

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    Dúvida -> Ver quais situações usar um ou outro
    Important: There are several Lanterna methods that throw IOException exceptions. When developing your code, you have to decide if your class should be responsible for handling each particular exception or if it should pass it to the calling method by declaring that it throws that kind of exception. Catching an exception should only be done if your method knows how to handle it properly.

    For example, if you don’t want your draw() method to catch and handle any IOException then just throw the exception like this:

     */
    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }

    public void run() throws IOException {
        while(true) {
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.ArrowUp) {
                hero.moveUp();
            }
            if (key.getKeyType() == KeyType.ArrowDown) {
                hero.moveDown();
            }
            if (key.getKeyType() == KeyType.ArrowLeft) {
                hero.moveLeft();
            }
            if (key.getKeyType() == KeyType.ArrowRight) {
                hero.moveRight();
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            if (key.getKeyType() == KeyType.EOF) {
                return;
            }
            draw();
        }
    }
}
