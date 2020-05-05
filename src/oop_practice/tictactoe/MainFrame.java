package oop_practice.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame  {
    private Field field;
    private GameProcess controller;
    public MainFrame(Field field, GameProcess controller) {
        this.field = field;
        this.controller = controller;
//        setSize(new Dimension(500, 500));
        setSize(500, 500);
//        setBounds(300, 100, 500, 500);
        setLocationRelativeTo(null);
        setTitle("Tic-tac-toe");
//        setBackground(Color.YELLOW);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new FlowLayout());
        createStatusBar();
        createField();
//        JButton buttonOk = new JButton();
//        buttonOk.setText("OK");
//
//        JButton buttonCancel = new JButton();
//        buttonCancel.setText("Cancel");
//        for (int i = 0; i < 9; i++) {
//            JButton current = new JButton((i  + 1) + "");
//            current.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println(e.getActionCommand());
//                    System.out.println("button " + current.getText() + " clicked");
//                }
//            });
////            current.addMouseListener(new MouseListener() {
////                @Override
////                public void mouseClicked(MouseEvent e) {
////                    System.out.println(e.getX());
////                    System.out.println(e.getY());
////                    System.out.println(e.getButton());
////                }
////
////                @Override
////                public void mousePressed(MouseEvent e) {
////
////                }
////
////                @Override
////                public void mouseReleased(MouseEvent e) {
////
////                }
////
////                @Override
////                public void mouseEntered(MouseEvent e) {
//////                    System.out.println("mouse entered " + current.getText());
////                }
////
////                @Override
////                public void mouseExited(MouseEvent e) {
//////                    System.out.println("mouse exited " + current.getText());
////                }
//        }
//        add(buttonCancel);
    }

    private JButton [][] buttons;

    private void createField() {
        JPanel data = new JPanel();
        data.setPreferredSize(new Dimension(400, 400));
        data.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                updateButton(i, j, button);
                int finalI = i;
                int finalJ = j;

                ActionListener buttonListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.handleClick(finalI, finalJ);
//                        System.out.println("click on " + finalI + " " + finalJ);
                    }
                };

                button.addActionListener(buttonListener);
                buttons[i][j] = button;
                data.add(button);
            }
        }
        add(data);
    }

    private void updateButton(int i, int j, JButton button) {
        String value = "";
        if (field.getValue(i, j).equals(CellValues.CROSS)) {
            value = "X";
        } else if (field.getValue(i, j).equals(CellValues.ZERO)) {
            value = "0";
        }
        button.setText(value);
    }

    public void updateField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                updateButton(i, j, buttons[i][j]);
            }
        }
    }

    private JLabel status;

    private void createStatusBar() {
        JPanel statusBar = new JPanel();
        statusBar.setPreferredSize(new Dimension(500, 50));
        statusBar.setLayout(new FlowLayout());
        status = new JLabel("Current status line");
        status.setPreferredSize(new Dimension(200, 50));
        statusBar.add(status); // добавляем элемент внутрь области
        add(statusBar); // область внутрь окна
    }

    public void setStatusText(String value) {
        status.setText(value);
    }
}
