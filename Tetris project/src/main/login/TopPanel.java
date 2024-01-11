package main.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JFrame implements ActionListener {
    Container c;
    JButton export;
    public TopPanel(){
        setTitle("TOP");

        setSize(600, 800);
        setLocation(450, 10);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.black);

        export = new JButton("EXPORT");
        export.setFont(new Font("Joystix", Font.PLAIN, 20));
        export.setBackground(Color.black);
        export.setForeground(Color.WHITE);
        export.setLayout(null);
        export.setBounds(230, 700, 150, 50);
        c.add(export);

        export.addActionListener(this);


        // Здесь надо будет добавить вывод таблицы упорядоченный уже (NICK_NAME (PRIMARY_KEY, UNIQUE, NOT NULL) SCORE (по умолчанию = 0))


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Здесь пишешь вывод для кнопки вывода
        // НАДО будет привязать вывод таблицы из mysql


    }
}
