/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.estruturas;

/**
 *
 * @author ACER
 */
public class ListaCircular {

    private No inicio;
    private Integer quantidade;

    public ListaCircular() {
        this.inicio = null;
        quantidade = 0;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
   
}