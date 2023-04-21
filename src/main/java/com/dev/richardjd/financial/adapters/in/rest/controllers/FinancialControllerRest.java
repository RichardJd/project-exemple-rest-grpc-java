package com.dev.richardjd.financial.adapters.in.rest.controllers;

import com.dev.richardjd.financial.adapters.dtos.requests.FinancialRequestDto;
import com.dev.richardjd.financial.adapters.dtos.responses.FinancialResponseDto;
import com.dev.richardjd.financial.application.ports.in.services.IFinancialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/financials")
@RequiredArgsConstructor
public class FinancialControllerRest {

    private final IFinancialService financialService;

    @GetMapping
    public List<FinancialResponseDto> findAll() {
        return this.financialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialResponseDto> findById(@PathVariable Long id) {
        Optional<FinancialResponseDto> financialResponse = this.financialService.findById(id);

        return financialResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid FinancialRequestDto financialRequestDto) {
        Integer result = this.financialService.create(financialRequestDto);
        return result == 1 ? ResponseEntity.created(URI.create("")).body("") : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.financialService.deleteById(id);
    }
}
