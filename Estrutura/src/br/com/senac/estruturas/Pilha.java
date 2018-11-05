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
public class Pilha {

    private Integer quantidade;
    private No topo;

    public Pilha() {
        quantidade = 0;
    }

    public void add(No e) {
        e.setProximo(topo);
        quantidade++;
        topo = e;
    }

    public No desempilhar() {
        
        return null;
    }

    public No get() {
        No retorno = topo;
        if (topo != null) {
            quantidade--;
            topo = topo.getProximo();
        }
        return retorno;
    }

    public void imprimir() {
        System.out.println("<< PILHA >>");
        No auxiliar = topo;
        while (auxiliar != null) {
            System.out.println("- " + auxiliar.getElemento());
            auxiliar = auxiliar.getProximo();
        }
        System.out.println("<< TOTAL DE ELEMENTOS = " + quantidade + " >>\n\n");
    }

}
