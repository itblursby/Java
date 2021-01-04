package main;

//import javax.xml.soap.Text;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) {
		
//		GridPane gridpane = new GridPane();
//		gridpane.setGridLinesVisible(true);
//		gridpane.setPrefWidth(800);
//		gridpane.setPrefHeight(800);
//		ColumnConstraints cc = new ColumnConstraints();
//		cc.setPercentWidth(50);
//		gridpane.getColumnConstraints().add(cc);
//		cc = new ColumnConstraints();
//		cc.setPercentWidth(50);
//		gridpane.getColumnConstraints().add(cc);
//		RowConstraints rc = new RowConstraints();
//		rc.setPercentHeight(50);
//		gridpane.getRowConstraints().add(rc);
//		rc = new RowConstraints();
//		rc.setPercentHeight(50);
//		gridpane.getRowConstraints().add(rc);
//		
//		
//		Button buttonA = new Button("");
//		buttonA.setPrefWidth(800);
//		buttonA.setPrefHeight(800);
//		Text testtext = new Text("yum");
//		gridpane.add(buttonA, 0, 0);
//		gridpane.add(testtext,1,0);
//		testtext.setText("minecraft steven");
		GridPane gridpane = Main.prepareCake();
		gridpane.setPrefHeight(600);
		gridpane.setPrefWidth(600);
		Scene scene = new Scene(gridpane);
		stage.setScene(scene);
		stage.setTitle("pray");
		stage.setResizable(false);
		stage.show();
		
	}
	static GridPane prepareCake() {
		GridPane gridpane = new GridPane();
		gridpane.setGridLinesVisible(true);
		//gridpane.setPrefWidth(800);
		//gridpane.setPrefHeight(800);
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(50);
		gridpane.getColumnConstraints().add(cc);
		cc = new ColumnConstraints();
		cc.setPercentWidth(50);
		gridpane.getColumnConstraints().add(cc);
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(50);
		gridpane.getRowConstraints().add(rc);
		rc = new RowConstraints();
		rc.setPercentHeight(50);
		gridpane.getRowConstraints().add(rc);
		
		Button button0 = new Button("");
		//button0.setStyle("-fx-background-color: #ff0000; ");
		button0.setMinWidth(0);
		button0.setMinHeight(0);
		button0.setOnAction(new SplitListener(gridpane,0,button0));
		button0.setPrefWidth(10000);
		button0.setPrefHeight(10000);
		gridpane.add(button0, 0, 0);
		
		Button button1 = new Button("");
		button1.setMinWidth(0);
		button1.setMinHeight(0);
		button1.setOnAction(new SplitListener(gridpane,1,button1));
		button1.setPrefWidth(10000);
		button1.setPrefHeight(10000);
		gridpane.add(button1, 1, 0);
		
		Button button2 = new Button("");
		button2.setMinWidth(0);
		button2.setMinHeight(0);
		button2.setOnAction(new SplitListener(gridpane,2,button2));
		button2.setPrefWidth(10000);
		button2.setPrefHeight(10000);
		gridpane.add(button2, 0, 1);
		
		Button button3 = new Button("");
		//button0.setStyle("-fx-background-color: #ff0000; ");
		button3.setMinWidth(0);
		button3.setMinHeight(0);
		button3.setOnAction(new SplitListener(gridpane,3,button3));
		button3.setPrefWidth(10000);
		button3.setPrefHeight(10000);
		gridpane.add(button3, 1, 1);
		return gridpane;
	}
	
}

