import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

public class Game {

    private ArrayList<GameObject> objects;
    private GOPlayer player;

    public Game() {
        objects = new ArrayList<GameObject>();

        GOBall ball = new GOBall((float) (Display.getWidth() / 2 - GOBall.SIZE / 2), (float) (Display.getHeight() / 2 - GOBall.SIZE / 2));
        player = new GOPlayer(0, (float) (Display.getHeight() / 2 - GOPlayer.SIZEY / 2), ball);

        objects.add(ball);
        objects.add(player);
    }

    public void getInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            player.move(1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            player.move(-1);
        }

    }


    public void update() {
        for (GameObject go : objects)
            go.update();
    }


    public void render() {
        for (GameObject go : objects)
            go.render();
    }
}
