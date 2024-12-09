package br.com.joelf.creditasbackend.infraestructure.configuration;

import br.com.joelf.creditasbackend.application.usecases.MakeAvailableLoanUseCaseImpl;
import br.com.joelf.creditasbackend.domain.usecases.MakeAvailableLoanUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public MakeAvailableLoanUseCase makeAvailableLoanUseCase() {
        return new MakeAvailableLoanUseCaseImpl();
    }
}
