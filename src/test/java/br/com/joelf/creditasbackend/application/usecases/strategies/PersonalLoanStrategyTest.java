package br.com.joelf.creditasbackend.application.usecases.strategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class PersonalLoanStrategyTest {

    @InjectMocks
    private PersonalLoanStrategy strategy;

    @Test
    void shouldReturnIsEligible() {
        boolean result = strategy.isEligible(BigDecimal.ZERO, null, null);
        Assertions.assertTrue(result);
    }
}
