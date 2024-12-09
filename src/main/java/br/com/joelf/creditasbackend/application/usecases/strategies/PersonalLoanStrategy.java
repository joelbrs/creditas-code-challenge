package br.com.joelf.creditasbackend.application.usecases.strategies;

import java.math.BigDecimal;

public class PersonalLoanStrategy implements EligiblityStrategy {
    @Override
    public boolean isEligible(BigDecimal income, String location, Integer age) {
        return Boolean.TRUE;
    }
}
