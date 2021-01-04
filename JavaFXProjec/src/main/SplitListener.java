package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;

public class SplitListener implements EventHandler<ActionEvent> {
	private GridPane gp;
	private int pos = 0;
	private Node previous;

	public SplitListener(GridPane s, int pos, Node a) {
		gp = s;
		this.pos = pos;
		previous = a;
	}

	@Override
	public void handle(ActionEvent arg0) {
		gp.getChildren().remove(previous);
		GridPane ne = Main.prepareCake();
		switch (pos) {
		case (0):
			gp.add(ne, 0, 0);
			break;
		case (1):
			gp.add(ne, 1, 0);
			break;
		case (2):
			gp.add(ne, 0, 1);
			break;
		case (3):
			gp.add(ne, 1, 1);
			break;
		}
		// TODO Auto-generated method stub

	}

}
