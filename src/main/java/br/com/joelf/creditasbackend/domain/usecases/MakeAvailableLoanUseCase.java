package br.com.joelf.creditasbackend.domain.usecases;

import br.com.joelf.creditasbackend.domain.dtos.CustomerAvailableLoans;
import br.com.joelf.creditasbackend.domain.dtos.CustomerRequest;

@FunctionalInterface
public interface MakeAvailableLoanUseCase {
    CustomerAvailableLoans execute(CustomerRequest request);
}
