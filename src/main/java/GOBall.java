public class GOBall extends GameObject {
    public static final int SIZE = 16;

    public static final float MAX_SPEEDX = 4.0f;
    public static final float MAX_SPEEDY = 8.0f;
    public static final float DAMPING = 0.05f;

    public float velX;
    public float velY;

    public GOBall(float x, float y) {
        this.x = x;
        this.y = y;
        this.sx = SIZE;
        this.sy = SIZE;

        velX = -MAX_SPEEDX;
        velY = 0;
    }

    @Override
    void update() {
        x += velX;
        y += velY;
    }

    public void reverseX(float center) {
        velX *= -1;
        velY += (getCenterY() - center) * DAMPING;

        if (velY > MAX_SPEEDY) {
            velY = MAX_SPEEDY;
        }
        if (velY < -MAX_SPEEDY) {
            velY = -MAX_SPEEDY;
        }
    }
}
