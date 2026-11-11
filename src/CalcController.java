package src;

import java.awt.event.*;

public class CalcController {
    private CalcModel m_model;
    private CalcView  m_view;

    CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view  = view;

        for (Operation op : Operation.values()) {
            view.addOperationListener(op, new OperationListener(op));
        }
        view.addClearListener(new ClearListener());
    }

    class OperationListener implements ActionListener {
        private final Operation m_operation;

        OperationListener(Operation operation) {
            m_operation = operation;
        }

        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.performOperation(m_operation, userInput);
                m_view.setTotal(m_model.getValue());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            } catch (ArithmeticException aex) {
                m_view.showError("Math error: " + aex.getMessage());
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}