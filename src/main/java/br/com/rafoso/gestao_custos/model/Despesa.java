package br.com.rafoso.gestao_custos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Despesa {

    private UUID id;
    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    private String categoria;
    private LocalDate data_criacao;
    private String email;
}
