package com.Formulario.Formulario.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")
public class RegistroDTO {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;

    private String Descricao;
    private Double Valor;

    private String Disponivel;

    //construtor vazio

    public RegistroDTO() {

    }

    //Construtor com todos os argumentos
    public RegistroDTO(Long id, String nome, String descricao, Double valor, String disponivel) {
        this.id = id;
        Nome = nome;
        Descricao = descricao;
        Valor = valor;
        Disponivel = disponivel;
    }

    //Get e Set


    public Long getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public Double getValor() {
        return Valor;
    }

    public String getDisponivel() {
        return Disponivel;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public void setDisponivel(String disponivel) {
        Disponivel = disponivel;
    }
}
