import java.util.ArrayList;
import java.util.List;

public class SubrectangleQueries {
    class Update {
        int row1, col1,  row2,  col2,  newValue;

        public Update(int row1, int col1, int row2, int col2, int newValue) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.newValue = newValue;
        }
    }

    int[][] rectangle;
    List<Update> updates;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.updates = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updates.add(new Update(row1, col1, row2, col2, newValue));
    }

    public int getValue(int row, int col) {
        for (int i = updates.size() - 1; i > -1; i--) {
            Update cur = updates.get(i);
            if (cur.col1 <= col &&
                    cur.col2 >= col &&
                    cur.row1 <= row && cur.row2 >= row) {
                return cur.newValue;
            }
        }
        return rectangle[row][col];
    }
}
