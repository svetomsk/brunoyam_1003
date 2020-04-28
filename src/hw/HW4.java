package hw;

import java.util.Arrays;

public class HW4 {
    public static void main(String[] args) {
        int[][] mas = {{11, 2, 3},
                        {3, 4, 5}};
        for(int[] row : mas) {
            int sum = 0;
            for(int i : row) {
                sum += i;
            }
            System.out.println("Sum = " + sum);
        }

        int max = mas[0][0];
        for(int [] row: mas){
            for(int i : row) {
                if (i > max) {
                    max = i;
                }
            }
        }
        System.out.println("Max = " + max);


//        int[][] mas = {{11, 2, 3},
//                       {3, 4, 5}};
        for (int j = 0; j < mas[0].length; j++) {
            int maxColumn = mas[0][j];
            for (int i = 0; i < mas.length; i++) {
                if (mas[i][j] > maxColumn) {
                    maxColumn = mas[i][j];
                }
            }
            System.out.println("Column " + j + " max = " + maxColumn);
        }

        int n = 3;
        int [][] snake = new int[n][n];
        int count = 1;
        String str = "";
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) { // четная строка
                for (int j = 0; j < n; j++, count++) {
                    snake[i][j] = count;
                }
            } else { // нечетная строка
                for (int j = n - 1; j >= 0 ; j--, count++) {
                    snake[i][j] = count;
//                    System.out.print(snake[i][j]);
                }
            }
            str += Arrays.toString(snake[i]) + "\n";
        }
        System.out.println(str);

        n = 4;
        int dir = 0; // 0 - right, 1 - down, 2 - left, 3 - up
        int value = 1;
        int x = 0;
        int y = 0;
        int [][] sp = new int[n][n];
        boolean dirChanged = false;
        while(value <= n * n) {
            if(dirChanged == false) {
                sp[x][y] = value;
                value++;
            } else {
                dir = (dir + 1) % 4;
                dirChanged = false;
            }
            if(dir == 0) { // to the right
                if(y + 1 < n && sp[x][y + 1] == 0) {
                    y++;
                } else {
                    dirChanged = true;
                }
            } else if(dir == 1) { // go down
                if(x + 1 < n && sp[x + 1][y] == 0) {
                    x++;
                } else {
                    dirChanged = true;
                }
            } else if(dir == 2) { // to the left
                if(y - 1 >= 0 && sp[x][y - 1] == 0) {
                    y--;
                } else {
                    dirChanged = true;
                }
            } else if(dir == 3) {
                if(x - 1 >= 0 && sp[x - 1][y] == 0) {
                    x--;
                } else {
                    dirChanged = true;
                }
            }
        }
        for (int i = 0; i < sp.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", sp[i][j]);
            }
            System.out.println();
        }

        System.out.println(String.format("%d _ %d _ %d", 12, 13, 23));

        System.out.printf("%5d", 124);
    }
}
