/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciaria.dominio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class Caixa {
    private Date dia;
    private String funcionario;
    private Double valorFinal;
    private List<Venda> vendas;

    public Caixa(Date dia, String funcionario, Double valorFinal, List<Venda> vendas) {
        this.dia = dia;
        this.funcionario = funcionario;
        this.valorFinal = valorFinal;
        this.vendas = vendas;
    }

    public Caixa() {
    }

    
    
    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    
}
