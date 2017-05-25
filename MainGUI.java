import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class MainGUI {

    MainGUI mainGUI;
    JFrame newFrame = new JFrame("AI Chat v0.1");
    Button sendMessage;
    TextField messageBox = new TextField("");
    TextArea chatBox = new TextArea("");
    TextField usernameChooser = new TextField("");
    JFrame preFrame;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainGUI mainGUI = new MainGUI();
        mainGUI.preDisplay();
    }


    public void preDisplay() {
        newFrame.setVisible(false);
        preFrame = new JFrame("Choose your username! (AI Chat Room)");
        usernameChooser = new TextField();
        JLabel chooseUsernameLabel = new JLabel("Pick a username:");
        Button enterServer = new Button("Enter Chat Server");
        JPanel prePanel = new JPanel(new GridBagLayout());

        GridBagConstraints preRight = new GridBagConstraints();
        preRight.anchor = GridBagConstraints.EAST;
        GridBagConstraints preLeft = new GridBagConstraints();
        preLeft.anchor = GridBagConstraints.WEST;
        preRight.weightx = 5.0;
        preRight.fill = GridBagConstraints.HORIZONTAL;
        preRight.gridwidth = GridBagConstraints.REMAINDER;

        prePanel.add(chooseUsernameLabel, preLeft);
        prePanel.add(usernameChooser, preRight);
        preFrame.add(BorderLayout.CENTER, prePanel);
        preFrame.add(BorderLayout.SOUTH, enterServer);
        preFrame.setVisible(true);
        preFrame.setSize(400, 300);

        enterServer.addActionListener(new enterServerButtonListener());
    }

    public void display() {
        newFrame.setVisible(true);
        JPanel southPanel = new JPanel();
        newFrame.add(BorderLayout.SOUTH, southPanel);
        southPanel.setBackground(Color.RED);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new TextField((int) 43.5);
        Button b = new Button("Send Message");
        sendMessage = b;
        
        
        
       
        
        chatBox = new TextArea("Thank you for trying AI\nIf you want to chat, type 'convo'\nIf you need help, type 'help'\nIf you have any questions, type 'summary'\nIf you want to clear your messages, type '/clear'\n--------------------------------------------------------------------------------------\n\n");
        chatBox.setEditable(false);
        newFrame.add(new JScrollPane(chatBox), BorderLayout.CENTER);

       

        GridBagConstraints left = new GridBagConstraints();
        GridBagConstraints right = new GridBagConstraints();
        right.anchor = GridBagConstraints.EAST;
        right.weightx = 2.0;

        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);

        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        sendMessage.addActionListener(new sendMessageButtonListener());
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(470, 300);
    }

    class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (messageBox.getText().length() < 1) {
                // do nothing 
            } else if (messageBox.getText().equals("/clear")) {
                chatBox.setText("Thank you for trying AI\nIf you want to chat, type 'convo'\nIf you need help, type 'help'\nIf you have any questions, type 'summary'\nIf you want to clear your messages, type '/clear'\n--------------------------------------------------------------------------------------\n\n");
                messageBox.setText("");
            } else {
                chatBox.append("<" + username + ">:  " + messageBox.getText() + "\n");
                messageBox.setText("");
            }
        }
    }

    String username;

    class enterServerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            username = usernameChooser.getText();
            if (username.length() < 1) {System.out.println("No!"); }
            else {
            preFrame.setVisible(false);
            display();
            }
        }

    }
}