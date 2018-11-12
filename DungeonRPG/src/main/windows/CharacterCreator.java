package main.windows;

import java.util.ArrayList;

import characters.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CharacterCreator {
	
	private Scene preScene;
	private Scene scene;
	private Stage primaryStage;
	private BorderPane root;
	private FlowPane cent;
	private Button ret;
	private ArrayList<Button> characters;
	private Button newCharacter;
	private Button delCharacter;
	private Player player;
	
	/**
	 * create a new character creator
	 */
	public CharacterCreator(final Stage primaryStage, final double width, final double height) {
		this.preScene = primaryStage.getScene();
		this.primaryStage = primaryStage;
		root = new BorderPane();
		cent = new FlowPane(Orientation.VERTICAL);
		cent.setColumnHalignment(HPos.LEFT);
		ret = new Button("return");
		characters = new ArrayList<Button>();
		newCharacter = new Button("new");
		delCharacter = new Button("delete");
		player = new Player();
		scene = new Scene(root, width, height);
		root.setTop(ret);
		root.setCenter(cent);
		actionSetup();
	}
	
	private void actionSetup() {
		ret.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				primaryStage.setScene(preScene);
				System.out.println("returning to menu.");
			}
		});
	}
	
	

	public Player getPlayer() {
		return player;
	}
	public Scene getScene() {
		return scene;
	}
	
}
