public class Point3D {
    // поля класса
    double x;
    double y;
    double z;

    public Point3D(double newX, double newY, double newZ) {
        x = newX;
        y = newY;
        z = newZ;
    }

    public double distToZero() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public String getStringValue() {
        String result = "(" + x + ", " + y + ", " + z + ")";
        return result;
    }

//    public double distance(int x1, int y1, int z1, int x2, int y2, int z2) {
    public double distance(Point3D other) {
        return Math.sqrt(Math.pow(x - other.x, 2) +
                Math.pow(y - other.y, 2) + Math.pow(z - other.z, 2));
    }

    // три координаты (x, y, z) - могут быть дробные
    // расстояние до (0, 0, 0) sqrt(x*x + y*y + z*z)
    // getStringValue() -> (1.2, 2.3, 2.3)
    // расстрояние до другой точки (x1, y1, z1)
    // sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1) + (z - z1) * (z - z1))
}

class PointsTest {
    public static void main(String[] args) {
        Point3D first = new Point3D(1, 1, 1);

        System.out.println(first.getStringValue());
        System.out.println(first.distToZero());

        Point3D second = new Point3D(2, 2, 2);
        System.out.println(second.distToZero());
        System.out.println(first.distance(second));
        // альтернатива
//        System.out.println(Point3D.distance(first, second));
    }
}


