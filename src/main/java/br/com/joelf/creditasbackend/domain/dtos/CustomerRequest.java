package br.com.joelf.creditasbackend.domain.dtos;

import br.com.joelf.creditasbackend.domain.entities.Customer;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerRequest {
    Customer customer;
}
