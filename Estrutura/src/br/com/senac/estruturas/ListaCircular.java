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
    public Boolean remover(Integer i) {
        No auxiliar = inicio;
        No anterior = null;
        Integer indice = 1;
        
        if (i == 1) {
            inicio = auxiliar.getProximo();
            quantidade--;
            inicio = null;
            return true;
        }
        while (auxiliar != null) {
            if (indice.equals(i)) {
                anterior.setProximo(auxiliar.getProximo());
                quantidade--;
                inicio = null;
                return true;
            }
            indice++;
            anterior = auxiliar;
            auxiliar = auxiliar.getProximo();
        }

        return false;
    }

    public int quantDeNo() {
        return quantidade;
    }

    public No getNo() {
        return inicio;
    }

    public void proximoNo() {
        inicio = inicio.getProximo();
    }

    public void add(No node) {
        if (this.inicio == null) {
            node.setProximo(node);
            this.inicio = node;
        } else {
            node.setProximo(this.inicio.getProximo());
            this.inicio.setProximo(node);
        }
        quantidade++;
    }

}
