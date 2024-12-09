package br.com.joelf.creditasbackend.application.usecases;

import br.com.joelf.creditasbackend.application.usecases.strategies.CollateralizedLoanStrategy;
import br.com.joelf.creditasbackend.application.usecases.strategies.EligiblityStrategy;
import br.com.joelf.creditasbackend.application.usecases.strategies.PayrollLoanStrategy;
import br.com.joelf.creditasbackend.application.usecases.strategies.PersonalLoanStrategy;
import br.com.joelf.creditasbackend.domain.dtos.CustomerAvailableLoans;
import br.com.joelf.creditasbackend.domain.dtos.CustomerRequest;
import br.com.joelf.creditasbackend.domain.entities.Customer;
import br.com.joelf.creditasbackend.domain.entities.LoanEnum;
import br.com.joelf.creditasbackend.domain.usecases.MakeAvailableLoanUseCase;

import java.util.HashMap;
import java.util.Map;

public class MakeAvailableLoanUseCaseImpl implements MakeAvailableLoanUseCase {

    private static final Map<LoanEnum, EligiblityStrategy> STRATEGIES = new HashMap<>();

    static {
        STRATEGIES.put(LoanEnum.PAYROLL, new PayrollLoanStrategy());
        STRATEGIES.put(LoanEnum.COLLATERALIZED, new CollateralizedLoanStrategy());
        STRATEGIES.put(LoanEnum.PERSONAL, new PersonalLoanStrategy());
    }

    @Override
    public CustomerAvailableLoans execute(CustomerRequest request) {
        Customer customer = request.getCustomer();

        CustomerAvailableLoans result = CustomerAvailableLoans.builder()
                .customer(customer.getName())
                .build();

        STRATEGIES.entrySet().stream()
                .filter(
                        strategy -> strategy.getValue()
                                .isEligible(customer.getIncome(), customer.getLocation(), customer.getAge())
                )
                .forEach(strategy -> {
                    result.addLoan(strategy.getKey());
                });

        return result;
    }
}
