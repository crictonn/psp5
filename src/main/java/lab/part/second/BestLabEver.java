package lab.part.second;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class BestLabEver extends JFrame {
    int k;
    File file = new File("C://Users/devic/Desktop/Info.txt");

    static JLabel labelGender, labelCountry, labelFIO, labelPurpose, labelDays;
    static JList<String> list;
    static JButton booking, cleanse;
    static JTextField textField;
    static JTextArea textArea;
    static JComboBox<String> box;
    static JCheckBox checkBox;
    static JRadioButton flag1, flag2;
    ButtonGroup buttonGroup;

    public BestLabEver(String str){
        super(str);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String [] cities = {"Таити", "Не Таити", "Дубай", "Нью-Йорк"};
        String [] amountOfDays = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
                "19","20","21","22","23","24","25","26","27","28","29","30"};

        booking = new JButton("Забронировать");
        cleanse = new JButton("Очистить");

        textArea = new JTextArea(4, 5);
        textField = new JTextField();

        labelGender = new JLabel("Выберите гендер:");
        labelCountry = new JLabel("Выберите город:");
        labelFIO = new JLabel("Ваше ФИО:");
        labelPurpose = new JLabel("Цель визита:");
        labelDays = new JLabel("Количество дней:");

        list = new JList<>(cities);
        box = new JComboBox<>(amountOfDays);

        checkBox = new JCheckBox("наличие визы");

        flag1 = new JRadioButton("Мужской");
        flag2 = new JRadioButton("Второй");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(flag1);
        buttonGroup.add(flag2);


        setLayout(null);
        labelFIO.setSize(400, 10);
        labelFIO.setLocation(20,5);

        textField.setSize(400, 20);
        textField.setLocation(20, 20);

        labelGender.setSize(400, 20);
        labelGender.setLocation(20, 50);

        flag1.setSize(100,20);
        flag1.setLocation(200, 50);
        flag2.setSize(100,20);
        flag2.setLocation(300, 50);

        labelCountry.setSize(100, 20);
        labelCountry.setLocation(20, 80);

        list.setSize(100, 70);
        list.setLocation(200, 80);

        labelDays.setSize(200, 20);
        labelDays.setLocation(20, 160);

        box.setSize(60, 20);
        box.setLocation(140, 160);

        checkBox.setSize(150,25);
        checkBox.setLocation(20, 190);

        labelPurpose.setSize(100, 20);
        labelPurpose.setLocation(20, 230);

        textArea.setSize(400, 80);
        textArea.setLocation(20, 250);

        booking.setSize(150, 40);
        booking.setLocation(75, 350);

        cleanse.setSize(150, 40);
        cleanse.setLocation(250, 350);

        add(booking);//done
        add(cleanse);//done
        add(textArea);//done
        add(textField);//Готово
        add(labelGender);//Готово
        add(labelFIO);// done
        add(labelCountry);//done
        add(labelDays);//done
        add(labelPurpose);//done
        add(list);// done
        add(box);//done
        add(checkBox);//done
        add(flag1);//Готово
        add(flag2);//Готово

        booking.addActionListener(new BookingActionListener());
        cleanse.addActionListener(new CleanseActionListener());
        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());
    }

    public class BookingActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try{
                if(file.exists()){
                    file.createNewFile();
                    FileWriter out = new FileWriter(file, true);
                    try (out){
                        String fio = textField.getText();
                        String purpose = textArea.getText();
                        out.write("ФИО: " + fio + ", ");
                        if(k == 1)
                            out.write("Мужчина\n");
                        else if (k == -1) {
                            out.write("Второй\n");
                        }
                        out.write(list.getSelectedValue() + ", на ");
                        out.write(box.getSelectedItem() + " дней, ");
                        if(checkBox.isSelected())
                            out.write("виза в наличии\n");
                        else
                            out.write("виза отсуствует\n");
                        out.write("Цель визита: " + purpose + "\n\n");
                    }
                }
            } catch (IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            k = 0;
            if(e.getSource() == flag1){
                k++;
            }
            else if(e.getSource() == flag2){
                k--;
            }
        }
    }

    public class CleanseActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == cleanse){
                textArea.setText(null);
                textField.setText(null);
                box.setSelectedIndex(0);
                checkBox.setSelected(false);
            }
        }
    }
}
