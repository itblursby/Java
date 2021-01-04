package ajjavafx;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class JavaFx2 extends Application {

@Override
    public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("My Second JavaFX App");
		MyButtonListener thing = new MyButtonListener();
		View2.setupViewFor(primaryStage, thing);
		primaryStage.show();

	}

    public static void main(String[] args) {
        launch(args);
    }

}
class MyButtonListener implements EventHandler<ActionEvent> {
	int clickCount = 0;
	private Stage stage;
	@Override
	public void handle(ActionEvent event) {
        System.out.println("click" + clickCount++);
        if (clickCount % 2 == 0) {
        	View1.setupViewFor(stage, this);
        } else {
        	View2.setupViewFor(stage, this);        	
        }

    }
}
class View1{
	public static void setupViewFor(Stage stage, MyButtonListener listener) {
		
		GridPane pane = new GridPane();
		pane.setStyle("-fx-background-color:red");
		Button b = new Button("Button A");
		b.setOnAction(listener);
		b.setMaxSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
		Button b2 = new Button("Button B");
		b2.setMaxSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
		b2.setPrefHeight(100);
		pane.add(b, 0, 1);
		pane.add(b2, 1, 0);
		GridPaneHelper.addStandardConstraints(pane,3,3);
		Scene s = new Scene(pane);
		stage.setScene(s);
	}
}
class View2 {
	public static void setupViewFor(Stage stage, MyButtonListener listener) {
		Button singleButton = new Button("View 2");
		singleButton.setOnAction(listener);
		Scene s = new Scene(singleButton);
        stage.setScene(s);
	}
}
