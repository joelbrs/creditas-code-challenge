package br.com.joelf.creditasbackend.application.usecases.strategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class PayrollLoanStrategyTest {

    @InjectMocks
    private PayrollLoanStrategy strategy;

    @Test
    void shouldReturnTrueIfConditionIsSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.valueOf(10000), null, null);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfConditionIsNotSatisfied() {
        boolean result = strategy.isEligible(BigDecimal.valueOf(1000), null, null);
        Assertions.assertFalse(result);
    }
}
