package br.com.rafoso.gestao_custos.controller;

import br.com.rafoso.gestao_custos.model.Despesa;
import br.com.rafoso.gestao_custos.useCases.CadastroDespesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @PostMapping("/create")
    public void create(@RequestBody Despesa despesa){

        cadastroDespesaUseCase.execute(despesa);
    }
}
