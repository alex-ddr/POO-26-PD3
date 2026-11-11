package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CalcView extends JFrame {
    private static final String INITIAL_VALUE = "1";

    private JTextField m_userInputTf = new JTextField(10);
    private JTextField m_totalTf     = new JTextField(25);

    private JButton m_addBtn      = new JButton("+");
    private JButton m_subtractBtn = new JButton("-");
    private JButton m_multiplyBtn = new JButton("*");
    private JButton m_divideBtn   = new JButton("/");
    private JButton m_clearBtn    = new JButton("Clear");

    private CalcModel m_model;

    CalcView(CalcModel model) {
        m_model = model;
        m_model.setValue(INITIAL_VALUE);

        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_addBtn);
        content.add(m_subtractBtn);
        content.add(m_multiplyBtn);
        content.add(m_divideBtn);
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Simple Calc - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {
        m_totalTf.setText(INITIAL_VALUE);
        m_userInputTf.setText("");
    }

    String getUserInput() {
        return m_userInputTf.getText();
    }

    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addOperationListener(Operation op, ActionListener listener) {
        switch (op) {
            case ADD -> m_addBtn.addActionListener(listener);
            case SUBTRACT -> m_subtractBtn.addActionListener(listener);
            case MULTIPLY -> m_multiplyBtn.addActionListener(listener);
            case DIVIDE -> m_divideBtn.addActionListener(listener);
        }
    }

    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}