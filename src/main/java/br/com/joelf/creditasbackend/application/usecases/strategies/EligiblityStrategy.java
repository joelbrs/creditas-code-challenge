package br.com.joelf.creditasbackend.application.usecases.strategies;

import java.math.BigDecimal;

@FunctionalInterface
public interface EligiblityStrategy {
    boolean isEligible(BigDecimal income, String location, Integer age);
}
