import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Game heroGame = new Game();
        heroGame.run();
    }
}
