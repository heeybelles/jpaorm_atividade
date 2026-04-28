package br.edu.fatecpg.fatec.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_receita")
public class ReceitasEmPromocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_receita")
    private String nome;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "preco")
    private Double preco;
    @Column(name= "emPromocao")
    private boolean emPromocao;

    public ReceitasEmPromocao(){}
    public ReceitasEmPromocao(String nome, String categoria, Double preco, boolean emPromocao) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.emPromocao = emPromocao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public void setEmPromocao(boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    @Override
    public String toString() {
        return "ReceitasEmPromocao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                ", emPromocao=" + emPromocao +
                '}';
    }
}