package br.com.joelf.creditasbackend.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Loan {
    private String type;
    private Double taxes;
}
