import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CableBilling extends Application implements EventHandler<ActionEvent>{
	public static int terminate = 0;
	public static String feeling = "";
	private Text phraseText = new Text("Enter your text: ");
	private static TextField phraseField = new TextField("");
	private Button calc = new Button("Submit Response");
	private Button clear = new Button("Clear");
	private static TextArea area = new TextArea("");
	private String windowTitle = "AI - GUI Edition - Now 20% more GUI!";

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(windowTitle);
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		calc.setOnAction(this);
		clear.setOnAction(this);
		grid.add(phraseText, 0, 1);
		grid.add(phraseField, 1, 1);
		grid.add(calc, 0, 3);
		grid.add(area, 0, 0,2,1);
		grid.add(clear, 1, 3);
		area.setEditable(false);
		area.appendText("Thank you for trying AI!\n");
		area.appendText("Use one word command. Type help for help!\n");
		area.appendText("----------------------------------------------\n");
		area.appendText("\n");
		primaryStage.setScene(new Scene(grid, 480,275));
		primaryStage.show();
		grid.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent key)
			{
				if (key.getCode().equals(KeyCode.ENTER))
				{
					area.clear();
					String ans;
					ans = process();
					area.appendText("Thank you for trying AI!\n");
					area.appendText("Use one word command. Type help for help!\n");
					area.appendText("--------------------------------------------------\n");
					area.appendText("User Response: " + phraseField.getText() + "\n");
					area.appendText("---------------------------------------------------\n");
					area.appendText("\n");
					area.appendText(ans +"\n");
				}
				else if (key.getCode().equals(KeyCode.C))
				{
					area.setText("");
				}
			}
		});
	}
	
	public void handle(ActionEvent event){
		if(event.getSource() == calc)
		{
			area.clear();
			String ans;
			ans = process();
			area.appendText("Thank you for trying AI!\n");
			area.appendText("Use one word command. Type help for help!\n");
			area.appendText("----------------------------------------------\n");
			area.appendText("\n");
			area.appendText(ans +"\n");
		}
		
		if(event.getSource() == clear)
		{
			area.setText("");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static String process() {
		
			String current2;
				current2 = phraseField.getText();
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
							
					}else if((search("kill", current2) == true && search("yourself", current2) == true && feeling == "depressed..."))
					{
						try {
							area.appendText("Thank you for trying AI!\n");
							area.appendText("Use one word command. Type help for help!\n");
							area.appendText("--------------------------------------------------\n");
							area.appendText("User Response: " + current2 + "\n");
							area.appendText("---------------------------------------------------\n");
							area.appendText("\n");
							area.appendText("Okay... Time to pull the plug I guess.... had to happen eventually.");
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.exit(0);
					}
					else
					{
						return("I don't think I understood... perhaps you could rephrase your question?");
					}
				} 
				return "boi";
			}
	public static Boolean search(String keyword, String phrase) {
			if (phrase.indexOf(keyword) >= 0) {
				return true;
			} else {
				return false;
			}
	}

}
