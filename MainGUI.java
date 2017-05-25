import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CableBilling extends Application implements EventHandler<ActionEvent>{
	
	private Text nameText = new Text("Enter your name: ");
	private TextField nameField = new TextField("");
	private Text phraseText = new Text("Enter your text: ");
	private static TextField phraseField = new TextField("");
	private Button calc = new Button("Calculate Monthly Bill");
	private Button clear = new Button("Clear");
	private TextArea area = new TextArea("");
	private String windowTitle = "AI - GUI Edition - Now 20% more GUI!";

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(windowTitle);
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		calc.setOnAction(this);
		clear.setOnAction(this);
		grid.add(nameText, 0, 0);
		grid.add(nameField, 1, 0);
		grid.add(phraseText, 0, 1);
		grid.add(phraseField, 1, 1);
		grid.add(calc, 0, 6);
		grid.add(area, 0, 5,2,1);
		grid.add(clear, 1, 6);
		area.setEditable(false);
		primaryStage.setScene(new Scene(grid, 480,275));
		primaryStage.show();
		grid.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent key)
			{
				if (key.getCode().equals(KeyCode.ENTER))
				{
					area.appendText(nameField.getText());
					nameField.setEditable(false);
				}
				else if (key.getCode().equals(KeyCode.C))
				{
					nameField.setEditable(true);
					area.setText("");
				}
			}
		});
	}
	
	public void handle(ActionEvent event){
		if(event.getSource() == calc)
		{
			area.appendText(nameField.getText());
			nameField.setEditable(false);
			area.appendText("Thank you for trying AI!\n");
			area.appendText("Use one word command. Type help for help!\n");
			area.appendText("If you want to chat, type 'convo'\n");
			while (true) {
				String ans;
				ans = AI.process();
				area.appendText(ans +"\n");
			}
		}
		
		if(event.getSource() == clear)
		{
			nameField.setEditable(true);
			area.setText("");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static String process() {
		String feeling = "";
		@SuppressWarnings("resource")
		String current;
		System.out.print("> ");
		current = phraseField.getText();
		current = current.toLowerCase();
			while (true) {
				String current2;
				System.out.print(">> ");
				current2 = scan.nextLine();
				current2 = current2.toLowerCase();
				if (current2.compareTo("") != 0) {
					if (search("hello", current2) == true || search("hi", current2) == true ) {
						return("Hello There! I am Reminiscence the Artificial Changeling!");
					} else if ((search("how", current2) == true && search("are", current2) == true && search("you", current2) == true) ||(search("how", current2) == true && search("is", current2) == true) ) {
						String blank = "";
							Random rand = new Random();
							int  n = rand.nextInt(3);
							if (n == 0) {
								if (feeling.compareTo(blank) == 0) {
									feeling = "kind of sad.";
									return("I am feeling " + feeling);
								} else {
									return("I already told you I'm " + feeling);
								}
							} else if (n == 1) {
								if (feeling.compareTo(blank) == 0) {
									feeling = "very happy today!";
									return("I am feeling " + feeling);
								} else {
									return("I already told you I'm " + feeling);
								}	
							} else if (n == 2) {
								if (feeling.compareTo(blank) == 0) {
									feeling = "depressed...";
									return("I am feeling " + feeling);
								} else {
									return("I already told you I'm " + feeling);
								}
							} else {
								if (feeling.compareTo(blank) == 0) {
									feeling = "alright.";
									return"I am feeling " + feeling;
								} else {
									return("I already told you I'm " + feeling);
								}	
							}
							
					} else {
						return("I don't think I understood... perhaps you could rephrase your question?");
					}
				} 
			}
	}
	public static Boolean search(String keyword, String phrase) {
			if (phrase.indexOf(keyword) >= 0) {
				return true;
			} else {
				return false;
			}
	}

}
