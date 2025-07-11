public class GOEnemy extends GameObject {

    public static final int SIZEX = 16;
    public static final int SIZEY = SIZEX * 7;
    public static final float MAX_SPEEDY = 4.0f;
    public static final float DAMPING = 0.05f;

    private GOBall ball;

    public GOEnemy(float x, float y, GOBall ball) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.ball = ball;
    }

    @Override
    void update() {
        if (Physics.CheckCollisions(this, ball)) {
            ball.reverseX(getCenterY());
        }

        float speed = (ball.getCenterY() - getCenterY()) * DAMPING;

        if (speed > MAX_SPEEDY) {
            speed = MAX_SPEEDY;
        }

        if (speed < -MAX_SPEEDY) {
            speed = -MAX_SPEEDY;
        }

        y += speed;
    }
}
