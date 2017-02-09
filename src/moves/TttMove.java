package moves;

/**
 * Created by Mathieu on 09/02/2017.
 */
public class TttMove extends Move {

    int x;
    int y;

    public int getX() {
        return x;
    }

    public TttMove(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
