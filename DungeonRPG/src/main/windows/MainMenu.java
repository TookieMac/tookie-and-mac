package main.windows;

import characters.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainMenu extends Stage{
	private Scene scene;
	private BorderPane root;
	private Button loadProfile;
	private Button playGame;
	private Button editor;
	private HBox cent;
	private PlayGame p;
	private CharacterCreator cc;
	
	
	
	public MainMenu() {

		root = new BorderPane();
		scene = new Scene(root, 500, 300);
		loadProfile = new Button("load character");
		playGame = new Button ("play");
		editor  = new Button("dungeon creator");
		cent = new HBox(10);
		root.setCenter(cent);
		cent.getChildren().addAll(playGame, loadProfile, editor);
		setScene(scene);
		cc = new CharacterCreator(this, scene.getWidth(), scene.getHeight());
		Player pl = cc.getPlayer();
		pl.setDex(6);
		pl.setName("Tookie");
		pl.setStr(6);
		pl.setWis(6);
		p = new PlayGame(this, scene.getWidth(), scene.getHeight(), pl);
		actionSetup();
		
	}
	
	private void actionSetup() {
		playGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				setScene (p.getScene());
				setTitle("Dungeon RPG game");
				//p.t.start();
			}
		});
		loadProfile.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				setScene (cc.getScene());
				setTitle("Dungeon RPG charactor load");
			}
		});
	}
	
}
	/*TODO
	load profile
	create dungeon
	play game
	*/