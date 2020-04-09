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
        System.out.println(first.distance(second));
        // альтернатива
        System.out.println(Point3D.distance(first, second));
    }
}


