package br.com.joelf.creditasbackend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoanEnum {
    PERSONAL("personal", 4.0),
    COLLATERALIZED("collateralized", 3.0),
    PAYROLL("payroll", 2.0) ;

    private final String type;
    private final Double taxes;
}
