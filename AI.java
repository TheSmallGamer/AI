//Try using this later, ArrayList <Integer> list = new ArrayList <Integer>();
//		list = ['xyz', 'abc'];
import java.util.*;

public class AI {

	public static void main(String[] args) {
		System.out.println("Thank you for trying AI!");
		System.out.println("Use one word command. Type help for help!");
		System.out.println("If you want to chat, type 'convo'");
		while (true) {
			String ans;
			ans = process();
			System.out.println(ans);
		}
		
	}
	public static String process() {
		String feeling = "";
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String current;
		System.out.print("> ");
		current = scan.next();
		current = current.toLowerCase();
		if (search("hello", current) == true) {
			return ("Hello There!");
		} else if (search("debug", current) == true) {
			return "No bugs here, officer!";
		} else if (search("convo", current) == true) {
			System.out.println("\n Please Enjoy! ^~^");
			while (true) {
				String current2;
				System.out.print(">> ");
				current2 = scan.nextLine();
				current2 = current2.toLowerCase();
				if (current2.compareTo("") != 0) {
					if (search("hello", current2) == true || search("hi", current2) == true ) {
						System.out.println("Hello There! I am Reminiscence the Artificial Changeling!");
					} else if ((search("how", current2) == true && search("are", current2) == true && search("you", current2) == true) ||(search("how", current2) == true && search("is", current2) == true) ) {
						String blank = "";
							Random rand = new Random();
							int  n = rand.nextInt(3);
							if (n == 0) {
								if (feeling.compareTo(blank) == 0) {
									feeling = "kind of sad.";
									System.out.println("I am feeling " + feeling);
								} else {
									System.out.println("I already told you I'm " + feeling);
								}
							} else if (n == 1) {
								if (feeling.compareTo(blank) == 0) {
									feeling = "very happy today!";
									System.out.println("I am feeling " + feeling);
								} else {
									System.out.println("I already told you I'm " + feeling);
								}	
							} else if (n == 2) {
								if (feeling.compareTo(blank) == 0) {
									feeling = "depressed...";
									System.out.println("I am feeling " + feeling);
								} else {
									System.out.println("I already told you I'm " + feeling);
								}
							} else {
								if (feeling.compareTo(blank) == 0) {
									feeling = "alright.";
									System.out.println("I am feeling " + feeling);
								} else {
									System.out.println("I already told you I'm " + feeling);
								}	
							}
							
					} else {
						System.out.println("I don't think I understood... perhaps you could rephrase your question?");
					}
				} 
			}
		} else if (search("help", current) == true) {
			return "WIP! Coming soon!";
		}else {
			return "I didn't understand! >~<";
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
