package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


public class Game15 extends JFrame implements ActionListener {
    private ArrayList<JButton> numbers = new ArrayList<>(), fNumbers = new ArrayList<>();
    private Font font = new Font("Sherif", Font.BOLD, 20);
    private JTextField out = new JTextField();
    JButton reset = new JButton("Начать игру заново"), oneStep = new JButton("Один шаг до победы"), ok = new JButton("Ok"), cancel = new JButton("Cancel");
    JPanel panel = new JPanel(), panel2 = new JPanel(), panelReset = new JPanel();
    JButton one = new JButton("1"), two = new JButton("2"), three = new JButton("3"), four = new JButton("4"), five = new JButton("5"),
            six = new JButton("6"), seven = new JButton("7"), eight = new JButton("8"), nine = new JButton("9"), ten = new JButton("10"),
            eleven = new JButton("11"), twelve = new JButton("12"), thirteen = new JButton("13"), fourteen = new JButton("14"), fifteen = new JButton("15"),
            empty = new JButton("");

    public void init() {
        setTitle("Game 15");
        setSize(600, 750);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        panel.setLayout(new GridLayout(4, 4));
        panel.setBounds(0, 0, 600, 600);
        add(panel);

        panel2.setBounds(0, 650, 600, 50);
        add(panel2);
        panel2.setLayout(new GridLayout(1, 2));

        panelReset.setLayout(new GridLayout(1, 2));
        panelReset.setBounds(0, 650, 600, 50);
        add(panelReset);

        reset.addActionListener(this);
        reset.setFont(font);
        panel2.add(reset);

        oneStep.setFont(font);
        oneStep.addActionListener(this);
        panel2.add(oneStep);

        ok.setFont(font);
        cancel.setFont(font);
        panelReset.add(ok);
        panelReset.add(cancel);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        ten.addActionListener(this);
        eleven.addActionListener(this);
        twelve.addActionListener(this);
        thirteen.addActionListener(this);
        fourteen.addActionListener(this);
        fifteen.addActionListener(this);
        ok.addActionListener(this);
        cancel.addActionListener(this);

        out.setBounds(0, 600, 600, 50);
        out.setEditable(false);
        out.setFont(font);
        out.setHorizontalAlignment(JTextField.CENTER);
        add(out);

        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(five);
        numbers.add(six);
        numbers.add(seven);
        numbers.add(eight);
        numbers.add(nine);
        numbers.add(ten);
        numbers.add(eleven);
        numbers.add(twelve);
        numbers.add(thirteen);
        numbers.add(fourteen);
        numbers.add(fifteen);
        fNumbers.addAll(numbers);

        Collections.shuffle(numbers);
        numbers.add(empty);
        fNumbers.add(empty);
        for (JButton x : numbers) {
            x.setFont(font);
            panel.add(x);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset) {
            panel2.setVisible(false);
            panelReset.setVisible(true);
            out.setText("Вы точно хотите начать игру заново?");
            for (JButton g : numbers) {
                g.setEnabled(false);
            }
            setVisible(true);
        }

        if (e.getSource() == oneStep) {
            numbers.clear();
            numbers.addAll(fNumbers);
            numbers.set(15, numbers.get(numbers.size() - 2));
            numbers.set(numbers.size() - 2, empty);
            for (JButton x : numbers) {
                panel.add(x);
            }
            for (JButton g : numbers) {
                g.setEnabled(true);
            }
            out.setText("");
            setVisible(true);
        }

        if (e.getSource() == ok) {
            Collections.shuffle(numbers);
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i).equals(empty)) {
                    numbers.set(i, numbers.get(numbers.size() - 1));
                    numbers.set(numbers.size() - 1, empty);
                }
            }
            for (JButton x : numbers) {
                panel.add(x);
            }
            for (JButton g : numbers) {
                g.setEnabled(true);
            }
            panel2.setVisible(true);
            panelReset.setVisible(false);
            out.setText("");
            for (JButton g : numbers) {
                g.setEnabled(true);
            }
            setVisible(true);
        }

        if (e.getSource() == cancel) {
            panel2.setVisible(true);
            panelReset.setVisible(false);
            out.setText("");
            for (JButton g : numbers) {
                g.setEnabled(true);
            }
            setVisible(true);
        }

        for (JButton n : numbers) {
            if (e.getSource() == n) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i).equals(n)) {

                        if (numbers.size() > (i + 1)) {
                            if (numbers.get(i + 1).equals(empty)) {
                                numbers.set(i + 1, n);
                                numbers.set(i, empty);
                                break;
                            }

                        }

                        if (i > 0) {
                            if (numbers.get(i - 1).equals(empty)) {
                                numbers.set(i - 1, n);
                                numbers.set(i, empty);
                                break;
                            }

                        }
                        if (i > 3) {
                            if (numbers.get(i - 4).equals(empty)) {
                                numbers.set(i - 4, n);
                                numbers.set(i, empty);
                                break;
                            }
                        }
                        if (numbers.size() > i + 4) {
                            if (numbers.get(i + 4).equals(empty)) {
                                numbers.set(i + 4, n);
                                numbers.set(i, empty);
                                break;
                            }
                        }
                    }
                }
                for (JButton x : numbers) {
                    panel.add(x);
                }
                if (numbers.equals(fNumbers)) {
                    out.setText("П О Б Е Д А!");
                    for (JButton g : numbers) {
                        g.setEnabled(false);
                    }
                }
                setVisible(true);
                return;
            }
        }
    }
}