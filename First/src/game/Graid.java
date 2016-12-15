package game;

public class Graid {
    public int[][] canvas = new int[8][8];

    public void GenField() {
        canvas = new int[8][8];
        for (int i = 1; i < 8; i++) {
            canvas[0][i] = i;
        }
        for (int i = 1; i < 8; i++) {
            canvas[i][0] = i;
        }
        for (int row = 1; row < 8; row++) {
            for (int column = 1; column < 8; column++) {
                canvas[row][column] = (int) (Math.random() * 3);
            }
        }
    }

    public int lookForMatches(int row, int column) {
        //поиск совпадений по горизонтали
        int result = 0;
        for (int i = 1; i < 6; i++) {
            if (canvas[row][i] == canvas[row][i + 1] && canvas[row][i] == canvas[row][i + 2]) result = 1;
            if ((canvas[row][i] == canvas[row][i - 1] && canvas[row][i] == canvas[row][i - 2])&((i-2)>1)) result = 2;

        //поиск совпадений по вертикали

            if (canvas[i][column] == canvas[i + 1][column] && canvas[i][column] == canvas[i + 2][column]) result = 3;
          if ((canvas[i][column] == canvas[i - 1][column] && canvas[i][column] == canvas[i-2][column])&((i-2)>1)) result = 4;
        }
        return result;
    }

    public void Move(int row1, int column1, int row2, int column2) {
        // Результат изначально false
        int r;
        r = canvas[row1][column1];
        canvas[row1][column1] = canvas[row2][column2];
        canvas[row2][column2] = r;

    }

    public int Del(int row, int column, int match) {
        int res = 0;
        if (match == 1) {
            for (int i = row; i > 1; i--) {
                canvas[i][column] = canvas[i - 1][column];
                canvas[i][column + 1] = canvas[i - 1][column + 1];
                canvas[i][column + 2] = canvas[i - 1][column + 2];
            }
            canvas[1][column] = (int) (Math.random() * 3);
            canvas[1][column + 1] = (int) (Math.random() * 3);
            canvas[1][column + 2] = (int) (Math.random() * 3);

            res = 3 * 100;
        }
        if (match == 2) {
            for (int i = row; i > 1; i--) {
                canvas[i][column] = canvas[i - 1][column];
                canvas[i][column - 1] = canvas[i - 1][column + 1];
                canvas[i][column - 2] = canvas[i - 1][column + 2];
            }
            canvas[1][column] = (int) (Math.random() * 3);
            canvas[1][column - 1] = (int) (Math.random() * 3);
            canvas[1][column - 2] = (int) (Math.random() * 3);

            res = 3 * 100;
        }
        if (match==3) {
            for (int i = row + 2; i > 1; i--) {
                    if ((i - 3) > 1) {
                        canvas[i][column] = canvas[i - 3][column];
                    } else {
                        i = 0;
                    }
                }
                canvas[1][column] = (int) (Math.random() * 3);
                canvas[2][column] = (int) (Math.random() * 3);
                canvas[3][column] = (int) (Math.random() * 3);
                res = 3 * 100;
            }
        return res;
    }
}
