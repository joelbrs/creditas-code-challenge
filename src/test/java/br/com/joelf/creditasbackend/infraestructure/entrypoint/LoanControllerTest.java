package br.com.joelf.creditasbackend.infraestructure.entrypoint;

import br.com.joelf.creditasbackend.domain.dtos.CustomerAvailableLoans;
import br.com.joelf.creditasbackend.domain.dtos.CustomerRequest;
import br.com.joelf.creditasbackend.domain.entities.Customer;
import br.com.joelf.creditasbackend.domain.usecases.MakeAvailableLoanUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoanControllerTest {

    @Mock
    private MakeAvailableLoanUseCase useCase;

    @InjectMocks
    private LoanController controller;

    @Test
    void shouldReturnCorrectAvailablesAmount() {
        CustomerAvailableLoans expectedResult =
                CustomerAvailableLoans.builder().build();

        CustomerRequest request = CustomerRequest.builder()
                .customer(Customer.builder().build())
                .build();

        when(useCase.execute(request)).thenReturn(expectedResult);

        Assertions.assertEquals(controller.avalilableLoans(request).getBody(), expectedResult);
    }
}
