package src;
import java.math.BigDecimal;
import java.math.BigInteger;

public class CalcModel {
    private static final String INITIAL_VALUE = "1";

    private BigInteger m_totalInt;
    private BigDecimal m_totalDouble;
    private boolean m_isDecimalMode;

    CalcModel() {
        reset();
    }

    public void reset() {
        m_totalInt = new BigInteger(INITIAL_VALUE);
        m_totalDouble = new BigDecimal(INITIAL_VALUE);
        m_isDecimalMode = false;
    }

    public void multiplyBy(String operand) {
        operand = operand.trim();

        if (!m_isDecimalMode && !operand.contains(".") && !operand.toLowerCase().contains("e")) {
            BigInteger intOperand = new BigInteger(operand);
            m_totalInt = m_totalInt.multiply(intOperand);
            m_totalDouble = new BigDecimal(m_totalInt);
        } else {
            m_isDecimalMode = true;
            BigDecimal decOperand = new BigDecimal(operand);
            m_totalDouble = m_totalDouble.multiply(decOperand);
        }
    }

    public void setValue(String value) {
        value = value.trim();
        if (!value.contains(".") && !value.toLowerCase().contains("e")) {
            m_totalInt = new BigInteger(value);
            m_totalDouble = new BigDecimal(m_totalInt);
            m_isDecimalMode = false;
        } else {
            m_totalDouble = new BigDecimal(value);
            m_totalInt = m_totalDouble.toBigInteger();
            m_isDecimalMode = true;
        }
    }

    public String getValue() {
        if (m_isDecimalMode) {
            return m_totalDouble.stripTrailingZeros().toPlainString();
        }
        return m_totalInt.toString();
    }
}