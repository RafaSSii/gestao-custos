package br.com.rafoso.gestao_custos.useCases;

import br.com.rafoso.gestao_custos.model.Despesa;
import br.com.rafoso.gestao_custos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BuscaDespesaUseCase {
    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> execute(String email, LocalDate data){
        List<Despesa> despesas;
        if (data != null){
            despesas = despesaRepository.findByEmailAndData(email, data);
        }else {
            despesas = despesaRepository.findByEmail(email);
        }
        return despesas;
    }
}
