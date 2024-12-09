package br.com.joelf.creditasbackend.application.usecases.strategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class CollateralizedLoanStrategyTest {

    @InjectMocks
    private CollateralizedLoanStrategy strategy;

    @Test
    void shouldReturnTrueIfFirstCriteriaIsSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.ONE, "SP", 25);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfFirstCriteriaIsNotSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.valueOf(10000), "MG", 35);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfSecondCriteriaIsSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.valueOf(3500), "SP", null);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfSecondCriteriaIsNotSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.valueOf(10000), "MG", null);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfThirdCriteriaIsSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.valueOf(10000), null, 25);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfThirdCriteriaIsNotSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.ONE, null, 15);
        Assertions.assertFalse(result);
    }
}
