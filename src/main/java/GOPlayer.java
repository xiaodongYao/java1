public class GOPlayer extends GameObject {
    public static final int SIZEX = 16;
    public static final int SIZEY = SIZEX * 7;

    public GOPlayer(float x, float y) {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
    }

    @Override
    void update() {

    }
}
