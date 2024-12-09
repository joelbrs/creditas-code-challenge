package br.com.joelf.creditasbackend.domain.dtos;

import br.com.joelf.creditasbackend.domain.entities.LoanEnum;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class CustomerAvailableLoans {
    private String customer;

    @Builder.Default
    private List<Loan> loans = new ArrayList<>();

    public void addLoan(LoanEnum loan) {
        loans.add(new Loan(loan.getType(), loan.getTaxes()));
    }
}
