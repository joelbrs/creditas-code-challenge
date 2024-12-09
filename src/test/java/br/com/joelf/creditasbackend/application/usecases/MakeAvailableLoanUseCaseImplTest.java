package br.com.joelf.creditasbackend.application.usecases;

import br.com.joelf.creditasbackend.domain.dtos.CustomerAvailableLoans;
import br.com.joelf.creditasbackend.domain.dtos.CustomerRequest;
import br.com.joelf.creditasbackend.domain.entities.Customer;
import br.com.joelf.creditasbackend.domain.entities.LoanEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class MakeAvailableLoanUseCaseImplTest {

    @InjectMocks
    private MakeAvailableLoanUseCaseImpl useCase;

    @Test
    void shouldReturnCustomerPersonalLoanOnly() {
        CustomerRequest request = CustomerRequest.builder()
                .customer(makeCustomerSut("MA", BigDecimal.ONE, 17))
                .build();

        CustomerAvailableLoans result = useCase.execute(request);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getLoans().size());
        Assertions.assertEquals(result.getLoans().getFirst().getType(), LoanEnum.PERSONAL.getType());
    }

    @Test
    void shouldReturnCustomerCollateralizedLoan() {
        CustomerRequest request = CustomerRequest.builder()
                .customer(makeCustomerSut("SP", BigDecimal.valueOf(1500), 25))
                .build();

        CustomerAvailableLoans result = useCase.execute(request);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getLoans().size());
        Assertions.assertTrue(
                result.getLoans().stream().anyMatch(loan -> loan.getType().equals(LoanEnum.COLLATERALIZED.getType()))
        );
    }

    @Test
    void shouldReturnCustomerPayrollLoan() {
        CustomerRequest request = CustomerRequest.builder()
                .customer(makeCustomerSut("SP", BigDecimal.valueOf(10000), 45))
                .build();

        CustomerAvailableLoans result = useCase.execute(request);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getLoans().size());
        Assertions.assertTrue(
                result.getLoans().stream().anyMatch(loan -> loan.getType().equals(LoanEnum.PAYROLL.getType()))
        );
    }

    @Test
    void shouldReturnCustomerAllLoans() {
        CustomerRequest request = CustomerRequest.builder()
                .customer(makeCustomerSut("SP", BigDecimal.valueOf(10000), 25))
                .build();

        CustomerAvailableLoans result = useCase.execute(request);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.getLoans().size());
        Assertions.assertTrue(
                result.getLoans().stream().anyMatch(loan -> loan.getType().equals(LoanEnum.PERSONAL.getType()))
        );
        Assertions.assertTrue(
                result.getLoans().stream().anyMatch(loan -> loan.getType().equals(LoanEnum.PAYROLL.getType()))
        );
        Assertions.assertTrue(
                result.getLoans().stream().anyMatch(loan -> loan.getType().equals(LoanEnum.COLLATERALIZED.getType()))
        );
    }

    private Customer makeCustomerSut(String location, BigDecimal income, int age) {
        return Customer.builder()
                .name("Joel")
                .cpf("111.111.111-11")
                .age(age)
                .location(location)
                .income(income)
                .build();
    }
}
