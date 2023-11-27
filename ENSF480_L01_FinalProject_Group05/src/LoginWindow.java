
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class LoginWindow extends JFrame implements ActionListener {

    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton loginButton;

    public LoginWindow(){
        super("Login");
        setupGUI();
        setSize(300,150);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 -getWidth()/2, size.height/2 -getHeight()/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setupGUI(){

        usernameInput = new JTextField("oop", 15);
        passwordInput = new JPasswordField("password", 15);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameInput);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordInput);
        submitPanel.add(loginButton);

        this.add(loginPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }

    public void actionPerformed(ActionEvent event){
        String username = usernameInput.getText();
        String password = new String (passwordInput.getPassword());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new LoginWindow().setVisible(true);
        });
    }

}