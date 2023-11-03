package lab.part.first;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
public class TextComparator extends JFrame{
    String text1;
    File file = new File("D://Comparator.txt");
    static JLabel l1, l2, l3;
    static JButton compare, cleanse;
    static JTextArea textAreaLeft, textAreaRight, textAreaBottom;

    public TextComparator(String str){
        super(str);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        compare = new JButton("Сравнить");
        cleanse = new JButton("Очистить");

        textAreaLeft = new JTextArea(9, 5);
        textAreaRight = new JTextArea(9, 5);
        textAreaBottom = new JTextArea(9, 5);

        l1 = new JLabel("Текст 1");
        l2 = new JLabel("Текст 2");
        l3 = new JLabel("Результат сравнения");

        setLayout(null);
        textAreaLeft.setSize(150,150);
        textAreaLeft.setLocation(50, 50);
        textAreaLeft.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        textAreaRight.setSize(150,150);
        textAreaRight.setLocation(300, 50);
        textAreaRight.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        textAreaBottom.setSize(150,150);
        textAreaBottom.setLocation(175, 250);
        textAreaBottom.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        compare.setSize(100,30);
        compare.setLocation(275, 410);

        cleanse.setSize(100, 30);
        cleanse.setLocation(125, 410);

        l1.setSize(200,25);
        l1.setLocation(50, 30);

        l2.setSize(200, 25);
        l2.setLocation(300, 30);

        l3.setSize(200, 25);
        l3.setLocation(175, 230);


        add(textAreaLeft);
        add(textAreaRight);
        add(textAreaBottom);
        add(compare);
        add(cleanse);
        add(l1);
        add(l2);
        add(l3);

        compare.addActionListener(new ButtonActionListener());
        cleanse.addActionListener(new CleanseActionListener());
    }
    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String [] area1 = textAreaLeft.getText().split("[.]");
            String [] area2 = textAreaRight.getText().split("[.]");

            ArrayList<String> leftText = new ArrayList<>();
            ArrayList<String> rightText = new ArrayList<>();
            ArrayList<String> result = new ArrayList<>();

            Collections.addAll(leftText, area1);
            Collections.addAll(rightText, area2);

            if(area1.length > area2.length){
                for(String st: leftText)
                    if(!rightText.contains(st) && leftText.indexOf(st)!=rightText.indexOf(st))
                        result.add(st);
            }
            else
                for(String st: rightText)
                    if(!leftText.contains(st) && leftText.indexOf(st)!=rightText.indexOf(st))
                        result.add(st);
            for(String res: result){
                textAreaBottom.setText(res);
            }
        }
    }

    public class CleanseActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == cleanse){
                textAreaRight.setText(null);
                textAreaLeft.setText(null);
                textAreaBottom.setText(null);
            }
        }
    }
}
