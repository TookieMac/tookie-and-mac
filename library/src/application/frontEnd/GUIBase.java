package application.frontEnd;

import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author Tookie
 *
 */
public abstract class GUIBase {

	protected Scene scene;
	protected Stage primaryStage;
	protected Scene previousScene;
	
	protected GUIBase(Stage primaryStage, Scene previousScene) {
		this.primaryStage = primaryStage;
		this.previousScene = previousScene;
	}
	
	/**
	 * return to the previous page/screen
	 * @throws NullPointerException
	 */
	public void Return() throws NullPointerException{
		this.primaryStage.setScene(previousScene);
	}
}
