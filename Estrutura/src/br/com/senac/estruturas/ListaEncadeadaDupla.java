/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.estruturas;

/**
 *
 * @author Alunos
 */
public class ListaEncadeadaDupla {

    private Integer quantidade;
    private No inicio;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public boolean adicionar(Object info) {
        No novoElemento = new No(info);
        if (isEmpty()) {
            inicio = novoElemento;
        } else {
            No auxiliar = inicio;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }

        }
        return false;
    }
}
