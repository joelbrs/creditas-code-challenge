package br.com.joelf.creditasbackend.infraestructure.entrypoint;

import br.com.joelf.creditasbackend.domain.dtos.CustomerAvailableLoans;
import br.com.joelf.creditasbackend.domain.dtos.CustomerRequest;
import br.com.joelf.creditasbackend.domain.usecases.MakeAvailableLoanUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/emprestimo")
public class LoanController {

    private final MakeAvailableLoanUseCase makeAvailableLoanUseCase;

    @PostMapping("/modelos-disponiveis")
    public ResponseEntity<CustomerAvailableLoans> avalilableLoans(@RequestBody CustomerRequest request) {
        return ResponseEntity.ok(makeAvailableLoanUseCase.execute(request));
    }
}
