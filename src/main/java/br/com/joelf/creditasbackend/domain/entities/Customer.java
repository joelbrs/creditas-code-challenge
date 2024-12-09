package br.com.joelf.creditasbackend.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Customer {
    private String name;
    private String cpf;
    private Integer age;
    private String location;
    private BigDecimal income;
}
