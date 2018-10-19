/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciaria.dominio;

/**
 *
 * @author Alunos
 */
public class Item {
    private Integer quantidade;
    private Produto produto;
    private Double subTotal;

    public Item() {
    }

    public Item(Integer quantidade, Produto produto, Double subTotal) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.subTotal = subTotal;
    }

    
    
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal() {
        this.subTotal = subTotal * produto.getValor();
    }
    
}
