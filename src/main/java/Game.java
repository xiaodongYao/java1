import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

public class Game {

    private ArrayList<GameObject> objects;
    private GOPlayer player;
    private GOBall ball;
    //private GOEnemy enemy;

    private int playerScore;
    private int enemyScore;

    public Game() {
        objects = new ArrayList<GameObject>();

        playerScore = 0;
        enemyScore = 0;

        ball = new GOBall((float) (Display.getWidth() / 2 - GOBall.SIZE / 2), (float) (Display.getHeight() / 2 - GOBall.SIZE / 2));
        player = new GOPlayer(0, (float) (Display.getHeight() / 2 - GOPlayer.SIZEY / 2), ball);
        GOEnemy enemy = new GOEnemy((float) (Display.getWidth() - GOEnemy.SIZEX), (float) (Display.getHeight() / 2 - GOPlayer.SIZEY / 2), ball);

        GOWall wall1 = new GOWall(0, 0, Display.getWidth(), GOWall.STDSIZE, ball);
        GOWall wall2 = new GOWall(0, Display.getHeight() - GOWall.STDSIZE, Display.getWidth(), GOWall.STDSIZE, ball);

        objects.add(ball);
        objects.add(player);
        objects.add(enemy);
        objects.add(wall1);
        objects.add(wall2);
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

        if (ball.getX() > Display.getWidth()) {
            playerScore++;
            ball.resetPosition();
        }

        if (ball.getX() < 0) {
            enemyScore++;
            ball.resetPosition();
        }
    }


    public void render() {
        for (GameObject go : objects)
            go.render();

        Display.setTitle("Score P" + playerScore + " E" + enemyScore);
    }
}
