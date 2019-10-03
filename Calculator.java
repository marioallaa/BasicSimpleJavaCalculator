/**
 *       Copyright (c) 2019 Mario
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Calculator {
    JFrame frame = new JFrame("Makine Llogaritese");
    ArrayList<JButton> jButtons = new ArrayList<>();
    String[] inputs = new String[2];
    int j = 0, k = 0;
    JButton add = new JButton("+");
    JButton substract = new JButton("-");
    JButton multiply = new JButton("*");
    JButton division = new JButton("/");
    JButton eq = new JButton("=");
    JLabel in = new JLabel("", SwingConstants.LEFT);
    JLabel out = new JLabel("", SwingConstants.LEFT);

    private void getjButtons() {
        for (int i = 0; i < 10; i++)
            this.jButtons.add(new JButton("" + i));
        for (int i = 0; i < jButtons.size(); i++)
        {
            jButtons.get(i).setText("" + i);
            switch (i) {
                case 0: case 6: case 3: case 9:
                    frame.add(jButtons.get(i));
                    frame.add(new JLabel());
                    break;
                case 1: case 4: case 7:
                    frame.add(new JLabel());
                    frame.add(jButtons.get(i));
                    break;
                default:
                    frame.add(jButtons.get(i));
                    break;
            }
            int finalI = i;
            jButtons.get(i).addActionListener(actionEvent -> {
                        inputs[j] = inputs[j] + finalI;
                        System.out.println(inputs[j]);
                        in.setText(in.getText() + finalI);
                    }
            );
        }
    }

    public Calculator() {
        inputs[0] = "";
        inputs[1] = "";
        setView();
        add.addActionListener(actionEvent -> addPressed());
        substract.addActionListener(actionEvent -> substractPressed());
        multiply.addActionListener(actionEvent -> multiplyPressed());
        division.addActionListener(actionEvent -> divisionPressed());
        eq.addActionListener(v -> equalPressed());

        frame.show();
    }
    private void setView() {
        frame.add(new JLabel("INPUT : ", SwingConstants.RIGHT));
        frame.add(in);
        frame.add(new JLabel(""));
        GridLayout l = new GridLayout();
        l.setRows(6);
        frame.setLayout(l);
        getjButtons();
        frame.setSize(400, 500);
        frame.add(new JLabel("OUTPUT : ", SwingConstants.RIGHT));
        frame.add(out);
        frame.add(new JLabel());
        frame.add(new JLabel());
        frame.add(new JLabel());
        frame.add(add);
        frame.add(substract);
        frame.add(multiply);
        frame.add(division);
        frame.add(eq);
    }
    private void divisionPressed() {
        in.setText(in.getText() + " / ");
        k = 3;
        j = 1;
    }
    private void multiplyPressed() {
        in.setText(in.getText() + " * ");
        k = 2;
        j = 1;
    }
    private void addPressed() {
        in.setText(in.getText() + " + ");
        k = 0;
        j = 1;
    }
    private void substractPressed() {
        in.setText(in.getText() + " - ");
        k = 1;
        j = 1;
    }
    private void equalPressed() {
        int temp = 0;
        j = 0;
        try {
            switch (k) {
                case 0:
                    System.out.println("plus");
                    temp = Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]);
                    break;
                case 1:
                    System.out.println("Minus");
                    temp = Integer.parseInt(inputs[0]) - Integer.parseInt(inputs[1]);
                    break;
                case 2:
                    System.out.println("shumzim");
                    temp = Integer.parseInt(inputs[0]) * Integer.parseInt(inputs[1]);
                    break;
                case 3:
                    System.out.println("pjestim");
                    temp = Integer.parseInt(inputs[0]) / Integer.parseInt(inputs[1]);
                    break;
                default:
                    in.setText("ERROR");
            }
            out.setText(in.getText() + " = " + temp);
            in.setText("");
            inputs[0] = "";
            inputs[1] = "";
            j = 0;

        } catch (Exception e) {
            out.setText("ERROR");
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
