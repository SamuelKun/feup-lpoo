import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;

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
        screen.setCharacter(10, 10, new TextCharacter('X'));
        screen.refresh();
    }

    public void run() throws IOException {
        draw();
    }
}
