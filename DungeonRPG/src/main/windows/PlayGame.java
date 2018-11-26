package main.windows;



import java.io.OutputStream;
import java.io.PrintStream;

import characters.Character;
import characters.Player;
import dungeons.Dungeon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.DungeonManipulator;

public class PlayGame {
	private Scene scene;
	private Scene preScene;
	private BorderPane root;
	static TextArea results;
	private Button goBackScene;
	private Button[] movement;
	private Button[] battleAction;
	private Button[] stdAction;
	private HBox bottom;
	private HBox top;
	private HBox moveCont;
	private VBox standardCont;
	private VBox battleCont;
	private GridPane cent;
	//game stuff
	private Player player;
	private Dungeon dungeon;
	private Character enemy;
	private Stage primaryStage;
	private boolean coward = false;

	public PlayGame(final Stage primaryStage, final double width, final double height, final Player player) {
		this.preScene = primaryStage.getScene();
		this.player = player;
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Dungeon RPG play");
		compInit();
		buttonInit();
		otherInit();
		scene = new Scene(root, width, height);
		top.getChildren().addAll(goBackScene);
		moveCont.getChildren().addAll(movement);
		standardCont.getChildren().addAll(stdAction);
		battleCont.getChildren().addAll(battleAction);
		cent.addRow(0, moveCont);
		cent.addRow(1, results);

		PrintStream interceptor = new Interceptor(System.out);
		System.setOut(interceptor);// just add the interceptor tio change output to the textArea

		results.setEditable(false);
		root.setTop(top);
		root.setCenter(cent);
		root.setBottom(bottom);
		root.setLeft(standardCont);
		root.setRight(battleCont);
		actionSetup();
		battleCont.setVisible(false);
		moveCont.setVisible(true);

//		primaryStage.setOnCloseRequest( event -> {
//			System.out.println("Closing Stage");//this is for intercepting the close application method (pressing the red 'x')
//		});

	}



	//initialisers
	private void buttonInit() {
		movement = new Button[4];
		stdAction = new Button[3];
		battleAction = new Button[3];
		goBackScene = new Button("return");
		movement[0] = new Button("North");
		movement[1] = new Button("South");
		movement[2] = new Button("East");
		movement[3] = new Button("West");
		stdAction[0] = new Button("use item");
		stdAction[1] = new Button("view inventory");
		stdAction[2] = new Button("view stats");
		battleAction[0] = new Button("attack");
		battleAction[1] = new Button("use item");
		battleAction[2] = new Button("retreat");
	}
	private void compInit() {
		root = new BorderPane();
		cent = new GridPane();
		bottom = new HBox(10);
		top = new HBox(10);
		moveCont = new HBox(10);
		standardCont = new VBox(10);
		battleCont = new VBox(10);
	}
	private void otherInit() {
		results = new TextArea("use the surrounding buttons to control the game\n\n");
		dungeon = new DungeonManipulator("tookie").getDungeon();
	}

	//game stuff
	public String normalChoices() {
		String res = "";
		res += "what will you do?\n";
		return res;
	}

	private void play() {
		System.out.println(normalChoices());
		enemy = dungeon.getCurrentFloor().getCurrentRoom().getEnemy();
		if (enemy != null) {
			if (enemy.getHp() > 0 && player.getHp() >0 && !coward) {
				System.out.println("you see an enemy " + enemy.getClass().getSimpleName() + " (name: " + enemy.getName() + ")");	
				battle();
			}
			else if (coward) {
				System.out.println("you retreated from battle");
				dungeon.getCurrentFloor().setCurrentRoom(dungeon.getCurrentFloor().getPreviousRoom());
				battleCont.setVisible(false);
				moveCont.setVisible(true);
				coward = false;
			}
		}
		else if (dungeon.getCurrentFloor().getCurrentRoom().getItem() != null) {
			pickup();
		}
	}

	private void battle() {
		battleCont.setVisible(true);
		moveCont.setVisible(false);
	}

	private void attack() {
		//start with player attack
		System.out.println(player.getName() + " attacks");
		player.attack(enemy);

		if (enemy.getHp() > 0 && player.getHp() > 0) {//if the enemy survives the attack he can attack back
			System.out.println(enemy.getName() + " survives and retaliates (remaining HP: " + enemy.getHp() + ")");
			if(enemy.attack(player)) {
				System.out.println(enemy.getName() + " dodges the attack");
			}
			System.out.println("your remaining HP: " + player.getHp());
		}
		else {
			if (player.getHp() > 0 && coward == false) {
				System.out.println(player.getName() + " wins this battle\n");
				//				dungeon.getCurrentRoom().setEnemy(null);
				pickup();
				battleCont.setVisible(false);
				moveCont.setVisible(true);
			}
			else {
				System.out.println("you lose");
				battleCont.setVisible(false);
				moveCont.setVisible(true);
				//TODO delete character from saves when dead (perma death)
			}
		}
	}
	private void pickup() {
		if (dungeon.getCurrentFloor().getCurrentRoom().getItem() != null) {
			System.out.println("you found a " + dungeon.getCurrentFloor().getCurrentRoom().getItem().getName());
			player.pickup(dungeon.getCurrentFloor().getCurrentRoom().getItem());
			dungeon.getCurrentFloor().getCurrentRoom().setItem(null);
		}
	}

	public Scene getScene() {
		return scene;
	}

	private void actionSetup() {
		//return to menu
		goBackScene.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				primaryStage.setScene(preScene);
				primaryStage.setTitle("Dungeon RPG main Menu");
			}
		});
		//move north
		movement[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				dungeon.move("N");
				play();
			}
		});
		//move south
		movement[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				dungeon.move("S");
				play();

			}
		});
		//move east
		movement[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				dungeon.move("E");
				play();
			}
		});
		//move west
		movement[3].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				dungeon.move("W");
				play();
			}
		});
		//use item standard
		stdAction[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				if (player.getConsumable() != null) {
					System.out.println("you used " + player.getConsumable().getName());
					player.UseItem();
				}
				else {
					System.out.println("you have no items equipped");
				}
			}
		});
		//view inventory
		stdAction[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				System.out.println("you used opened your inventory");
			}
		});
		//view character
		stdAction[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				System.out.println("you viewed your character");
			}
		});
		//attack enemy
		battleAction[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				System.out.println("you attacked " + enemy.getName());
				attack();
			}
		});
		//use item battle
		battleAction[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				if (player.getConsumable() != null) {
					System.out.println("you used " + player.getConsumable().getName());
					player.UseItem();
				}
				else {
					System.out.println("you have no items equipped");
				}
			}
		});
		//retreat from battle
		battleAction[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				System.out.println("you retreated from the battle");
				coward = true;
				play();
			}
		});
	}

}
/**
 * changes the print destination from the console to the label in the above class
 * @author Tookie
 *
 */
class Interceptor extends PrintStream
{
	public Interceptor(OutputStream out)
	{
		super(out, true);
	}
	@Override
	public void print(String s)
	{
		PlayGame.results.appendText(s);	
	}
	@Override
	public void println(String s) {
		PlayGame.results.appendText(s + "\n");
	}
}