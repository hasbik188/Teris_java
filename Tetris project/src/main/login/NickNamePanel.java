package main.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.GamePanel;
import main.login.TopPanel;

public class NickNamePanel extends JFrame implements ActionListener {
    Container c;
    JLabel label, text;
    JTextField user;
    JButton btn, table;
    private String nickname;

    public NickNamePanel() {
        setTitle("LoginForm");

        setSize(600, 500);

        setLocation(450, 150);
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
        btn.setForeground(Color.GREEN); // Set text color to yellow
        btn.setLayout(null);
        btn.setBounds(10, 340, 560, 50);
        c.add(btn);

        btn.addActionListener(this);

        table = new JButton("TOP");
        table.setFont(new Font("Joystix", Font.PLAIN, 35));
        table.setBackground(Color.black);
        table.setForeground(Color.YELLOW); // Set text color to yellow
        table.setLayout(null);
        table.setBounds(10, 400, 560, 50);
        c.add(table);
        table.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPanel tp = new TopPanel();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Store the entered nickname in the variable
        nickname = user.getText();

        JFrame window = new JFrame("Tetris Project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Add GamePanel to the window
        GamePanel gp = new GamePanel();

        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.launchGame();
        // Close the authentication window
        dispose();
    }
}
