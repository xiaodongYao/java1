import org.lwjgl.opengl.Display;

import java.util.ArrayList;

public class Game {

    private ArrayList<GameObject> objects;

    public Game() {
        objects = new ArrayList<GameObject>();

        GOBall ball = new GOBall((float) (Display.getWidth() / 2 - GOBall.SIZE / 2), (float) (Display.getHeight() / 2 - GOBall.SIZE / 2));
        GOPlayer player = new GOPlayer(0, (float) (Display.getHeight() / 2 - GOPlayer.SIZEY / 2));

        objects.add(ball);
        objects.add(player);
    }

    public void getInput() {


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
