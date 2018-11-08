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

    public ListaEncadeadaDupla() {
        this.quantidade = 0;
        this.inicio = null;
    }

    public static void main(String[] args) {
        ListaEncadeadaDupla lista = new ListaEncadeadaDupla();
        lista.adicionarElemento("oiii");
    }

    public boolean isEmpity() {
        return inicio == null;
    }

    public boolean adicionarElemento(Object elemento) {
        No novoElemento = new No(elemento);
        if (isEmpity()) {
            inicio = novoElemento;
            quantidade++;
            return true;
        } else {
            No auxiliar = inicio;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(novoElemento);
            novoElemento.setAnterior(auxiliar);
            quantidade++;
            return true;
        }
    }

    public boolean adicionarElementoPosicao(Object elemento, Integer id) {
        if (quantidade < id) {
            System.out.println("Erro");
            return false;
        }
        if (id.equals(1)) {
            No novoElemento = new No(elemento);
            No aux = inicio;
            inicio = novoElemento;
            inicio.setProximo(aux);
        } else {
            No novoElemento = new No(elemento);
            No auxiliar = inicio;
            Integer indice = 1;
            while (!id.equals(indice + 1)) {
                auxiliar = auxiliar.getProximo();
                indice++;
            }
            No temporario = auxiliar.getProximo();
            novoElemento.setProximo(temporario);
            auxiliar.setProximo(novoElemento);
            novoElemento.setAnterior(auxiliar);
        }
        quantidade++;
        return true;
    }

    public boolean remover(Integer id) {
        if (quantidade < id) {
            System.out.println("Erro");
            return false;
        }
        if (id.equals(1)) {
            inicio = inicio.getProximo();
            quantidade--;
            return true;
        } else {
            No auxiliar = inicio;
            Integer indice = 1;
            while (!id.equals(indice + 1)) {
                auxiliar = auxiliar.getProximo();
                indice++;
            }
            No temporario = auxiliar.getProximo();
            No anterior = auxiliar.getAnterior();
            anterior.setProximo(temporario);
            if (temporario != null) {
                temporario.setAnterior(anterior);
            }
            quantidade--;
            return true;
        }
    }
}
