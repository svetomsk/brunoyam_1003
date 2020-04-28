package robot;

public class Robot {
    public static final char ROBOT_SYMBOL = '@';
    private int x;
    private int y;
    private char trace;
    private int n; // размер площадки

    public Robot(int n, char trace) {
        this.n = n;
        this.trace = trace;
    }

    public char getTrace() {
        return trace;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0 || x >= n) {
            throw new IllegalArgumentException("X must be in range 0 " + (n - 1));
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0 || y >= n) {
            throw new IllegalArgumentException("Y must be in range 0 " + (n - 1));
        }
        this.y = y;
    }

    public void move(Directions direction) {
        switch (direction) {
            // x is horizontal
            // y is vertical
            case LEFT: {
                // -inf ------ 0 ---10---- +inf
                x = Math.max(0, x - 1);
                // if (x - 1 >= 0) {
                //   x = x - 1;
                // }
                break;
            }
            case RIGHT: {
                x = Math.min(n - 1, x + 1);
                break;
            }
            case UP: {
                y = Math.max(0, y - 1);
                break;
            }
            case DOWN: {
                y = Math.min(n - 1, y + 1);
                break;
            }
        }
    }

}

enum Directions {
    LEFT,
    RIGHT,
    UP,
    DOWN
}
