package src;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public enum Operation {
    ADD("+") {
        @Override
        public BigInteger calculateInt(BigInteger a, BigInteger b) {
            return a.add(b);
        }

        @Override
        public BigDecimal calculateDec(BigDecimal a, BigDecimal b) {
            return a.add(b, MathContext.DECIMAL128);
        }
    },
    SUBTRACT("-") {
        @Override
        public BigInteger calculateInt(BigInteger a, BigInteger b) {
            return a.subtract(b);
        }

        @Override
        public BigDecimal calculateDec(BigDecimal a, BigDecimal b) {
            return a.subtract(b, MathContext.DECIMAL128);
        }
    },
    MULTIPLY("*") {
        @Override
        public BigInteger calculateInt(BigInteger a, BigInteger b) {
            return a.multiply(b);
        }

        @Override
        public BigDecimal calculateDec(BigDecimal a, BigDecimal b) {
            return a.multiply(b, MathContext.DECIMAL128);
        }
    },
    DIVIDE("/") {
        @Override
        public BigInteger calculateInt(BigInteger a, BigInteger b) {
            if (b.equals(BigInteger.ZERO)) {
                throw new ArithmeticException("Division by zero");
            }
            return a.divide(b);
        }

        @Override
        public BigDecimal calculateDec(BigDecimal a, BigDecimal b) {
            if (b.compareTo(BigDecimal.ZERO) == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a.divide(b, MathContext.DECIMAL128);
        }
    };

    private final String m_symbol;

    Operation(String symbol) {
        m_symbol = symbol;
    }

    public String getSymbol() {
        return m_symbol;
    }

    public abstract BigInteger calculateInt(BigInteger a, BigInteger b);
    public abstract BigDecimal calculateDec(BigDecimal a, BigDecimal b);
}