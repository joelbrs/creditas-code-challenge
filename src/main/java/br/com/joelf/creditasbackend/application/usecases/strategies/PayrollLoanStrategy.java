package br.com.joelf.creditasbackend.application.usecases.strategies;

import java.math.BigDecimal;

public class PayrollLoanStrategy implements EligiblityStrategy {

    private static final BigDecimal MIN_INCOME = BigDecimal.valueOf(5000);

    @Override
    public boolean isEligible(BigDecimal income, String location, Integer age) {
        return income.compareTo(MIN_INCOME) >= 0;
    }
}
