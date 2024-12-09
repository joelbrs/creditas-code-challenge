package br.com.joelf.creditasbackend.infraestructure.configuration;

import br.com.joelf.creditasbackend.application.usecases.MakeAvailableLoanUseCaseImpl;
import br.com.joelf.creditasbackend.domain.usecases.MakeAvailableLoanUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UseCaseConfigTest {

    @InjectMocks
    private UseCaseConfig useCaseConfig;

    @Test
    void shouldReturnMakeAvailableLoanUseCaseCorrectInstance() {
        MakeAvailableLoanUseCase useCase = useCaseConfig.makeAvailableLoanUseCase();

        Assertions.assertNotNull(useCase);
        Assertions.assertInstanceOf(MakeAvailableLoanUseCaseImpl.class, useCase);
    }
}
