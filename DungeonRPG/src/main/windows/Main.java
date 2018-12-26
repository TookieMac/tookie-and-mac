package main.windows;

import javafx.application.Application;
import javafx.stage.Stage;
//import tookieTools.objects.classes.GUIs.LoginForm;

/**
 * dungeon RPG game for use on a computer
 * @author Tookie
 * @version 0.0.1
 */
public class Main extends Application {
	//this class should not launch a new window, it should launch another class which will open its window
	@Override
	public void start(Stage primaryStage) {
		//new LoginForm(new MainMenu(), new String[0], new String[0]);//runs the login
		new MainMenu().show();// by-pass the login for now
	}

	public static void main(String[] args) {
		launch(args);
	}
}