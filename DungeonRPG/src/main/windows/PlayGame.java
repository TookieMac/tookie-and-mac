package main.windows;



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
	private TextArea results;
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
	private boolean playing = true;
	private Stage primaryStage;
	private boolean coward = false;
	public Thread t;

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


		results.setEditable(false);
		root.setTop(top);
		root.setCenter(cent);
		root.setBottom(bottom);
		root.setLeft(standardCont);
		root.setRight(battleCont);
		actionSetup();

		primaryStage.setOnCloseRequest( event -> {
			System.out.println("Closing Stage");
		});

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
		results.appendText(normalChoices() +"\n");
		enemy = dungeon.getCurrentRoom().getEnemy();
		if (enemy != null) {
			if (enemy.getHp() > 0 && player.getHp() >0 && !coward) {
				results.appendText("you see an enemy " + enemy.getClass().getSimpleName() + " (name: " + enemy.getName() + ")\n");	
				battle();
			}
			else if (coward) {
				results.appendText("you retreated from battle\n");
				dungeon.setCurrentRoom(dungeon.getPreviousRoom());
				battleCont.setVisible(false);
				moveCont.setVisible(true);
				coward = false;
			}
		}
	}

	private void battle() {
		battleCont.setVisible(true);
		moveCont.setVisible(false);
	}

	private void attack() {
		//start with player attack
		results.appendText(player.getName() + " attacks\n");
		player.attack(enemy);

		if (enemy.getHp() > 0 && player.getHp() > 0) {//if the enemy survives the attack he can attack back
			results.appendText(enemy.getName() + " survives and retaliates (remaining HP: " + enemy.getHp() + ")\n");
			if(enemy.attack(player)) {
				results.appendText(enemy.getName() + " dodges the attack\n");
			}
			results.appendText("your remaining HP: " + player.getHp() + "\n");
		}
		else {
			if (player.getHp() > 0 && coward == false) {
				results.appendText(player.getName() + " wins this battle\n");
//				dungeon.getCurrentRoom().setEnemy(null);
				pickup();
				battleCont.setVisible(false);
				moveCont.setVisible(true);
			}
			else {
				results.appendText("you lose\n");
				playing = false;
				battleCont.setVisible(false);
				moveCont.setVisible(true);
				//TODO delete character from saves when dead (perma death)
			}
		}
	}
	private void pickup() {
		if (dungeon.getCurrentRoom().getItem() != null) {
			results.appendText("you found a " + dungeon.getCurrentRoom().getItem().getName() + "\n");
			player.pickup(dungeon.getCurrentRoom().getItem());
			dungeon.getCurrentRoom().setItem(null);
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
				results.appendText("returning to menu.\n");
			}
		});
		//move north
		movement[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you moved north\n");
				dungeon.move("N");
				play();
			}
		});
		//move south
		movement[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you moved south\n");
				dungeon.move("S");
				play();

			}
		});
		//move east
		movement[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you moved east\n");
				dungeon.move("E");
				play();
			}
		});
		//move west
		movement[3].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you moved west\n");
				dungeon.move("W");
				play();
			}
		});
		//use item standard
		stdAction[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				if (player.getConsumable() != null) {
					results.appendText("you used " + player.getConsumable().getName() + "\n");
					player.UseItem();
					}
					else {
						results.appendText("you have no items equipped\n");
					}
			}
		});
		//view inventory
		stdAction[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you used opened your inventory\n");
			}
		});
		//view character
		stdAction[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you viewed your character\n");
			}
		});
		//attack enemy
		battleAction[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you attacked " + enemy.getName() + "\n");
				attack();
			}
		});
		//use item battle
		battleAction[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				if (player.getConsumable() != null) {
				results.appendText("you used " + player.getConsumable().getName() + "\n");
				player.UseItem();
				}
				else {
					results.appendText("you have no items equipped\n");
				}
			}
		});
		//retreat from battle
		battleAction[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				results.appendText("you retreated from the battle\n");
				coward = true;
				play();
			}
		});
	}

}
