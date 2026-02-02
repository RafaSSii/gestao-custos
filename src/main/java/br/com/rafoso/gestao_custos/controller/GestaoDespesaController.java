package br.com.rafoso.gestao_custos.controller;

import br.com.rafoso.gestao_custos.custom_messages.ErrorMessage;
import br.com.rafoso.gestao_custos.useCases.BuscaDespesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.rafoso.gestao_custos.model.Despesa;
import br.com.rafoso.gestao_custos.useCases.CadastroDespesaUseCase;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @Autowired
    BuscaDespesaUseCase buscaDespesaUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Despesa despesa){
        
        try{
            var result = cadastroDespesaUseCase.execute(despesa);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e){
            var errorMessage = new ErrorMessage(e.getMessage(),"INVALID_PARAMS");
            return ResponseEntity.status(400).body(errorMessage);
        }
    }

    @GetMapping("/{email}")
    public List<Despesa> findByEmailAndDate(@PathVariable String email, @RequestParam(required = false)LocalDate data){
        return buscaDespesaUseCase.execute(email, data);
    }
}
