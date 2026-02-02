package br.com.rafoso.gestao_custos.performance;

import br.com.rafoso.gestao_custos.model.Despesa;
import br.com.rafoso.gestao_custos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class GestaoDeDespesaSeeder implements CommandLineRunner {

    @Autowired
    DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 150000; i++){
            Despesa despesa = new Despesa();
            despesa.setDescricao("Gasto n: " + i);
            despesa.setValor(BigDecimal.valueOf(10 + (i % 50)));
            despesa.setData(LocalDate.now().minusDays((i % 30)));
        }
    }
}
