package ajjavafx;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GridPaneHelper {
	public static void addStandardConstraints(GridPane pane, int numRows, int numCols) {
		int percent = 100/numCols;
		for (int i = 0; i < numCols; i++) {
			ColumnConstraints c = new ColumnConstraints();
			c.setPercentWidth(percent);
			pane.getColumnConstraints().add(c);
		}
		percent = 100/numRows;
		for (int i = 0; i < numRows; i++) {
			RowConstraints c = new RowConstraints();
			c.setPercentHeight(percent);
			pane.getRowConstraints().add(c);
		}
		
	}
}
