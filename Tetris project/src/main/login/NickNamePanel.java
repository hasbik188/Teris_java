package main.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.GamePanel;

public class NickNamePanel extends JFrame implements ActionListener {
    Container c;
    JLabel label, text;
    JTextField user;
    JButton btn;

    public NickNamePanel() {
        setTitle("LoginForm");
        setSize(600, 500);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.black);

        text = new JLabel("WELCOME!");
        text.setFont(new Font("Joystix", Font.PLAIN, 60));
        text.setForeground(Color.YELLOW); // Set text color to yellow
        text.setBounds(140, 30, 600, 200);
        c.add(text);

        label = new JLabel("Username");
        label.setFont(new Font("Joystix", Font.PLAIN, 30));
        label.setForeground(Color.WHITE); // Set text color to white
        label.setBounds(40, 250, 200, 40);
        c.add(label);

        user = new JTextField();
        user.setBounds(240, 250, 300, 40);
        user.setBackground(Color.black);
        user.setLayout(null);
        user.setFont(new Font("Joystix", Font.PLAIN, 25));
        user.setForeground(Color.WHITE);
        user.setMargin(new Insets(0, 7, 0, 0));
        c.add(user);

        btn = new JButton("PLAY");
        btn.setFont(new Font("Joystix", Font.PLAIN, 35));
        btn.setBackground(Color.black);
        btn.setForeground(Color.YELLOW); // Set text color to yellow
        btn.setLayout(null);
        btn.setBounds(10, 350, 560, 50);
        c.add(btn);

        btn.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame window = new JFrame("Tetris Project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Add GamePanel to the window
        GamePanel gp = new GamePanel();

        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Close the authentication window
        dispose();
    }
}
