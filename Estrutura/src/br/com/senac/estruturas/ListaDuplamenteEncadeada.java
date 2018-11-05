/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.estruturas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ListaDuplamenteEncadeada {

    private Integer quantidade;
    private No inicio;
    private No fim;

    public ListaDuplamenteEncadeada() {
        this.quantidade = 0;
        this.inicio = null;
        this.fim = null;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrimeiro(No primeiro) {
        this.inicio = primeiro;
    }

    public No getPrimeiro() {
        return inicio;
    }

    public void setUltimo(No ultimo) {
        this.fim = ultimo;
    }

    public No getUltimo() {
        return fim;
    }

    public boolean adicionaInicio(Object valor) {

        No novo = new No();
        quantidade++;
        if (inicio == null) {
            novo.setElemento(valor);
            setPrimeiro(novo);
            setUltimo(novo);
            return true;
        } else {
            inicio.setAnterior(novo);
            novo.setElemento(valor);
            novo.setProximo(inicio);
            setPrimeiro(novo);
            return true;
        }

    }

    public boolean adicionar(Object valor) {
        No novo = new No();
        quantidade++;
        if (fim == null) {
            novo.setElemento(valor);
            inicio = novo;
            fim = novo;
            return true;
        } else {
            fim.setProximo(novo);
            novo.setElemento(valor);
            fim = novo;
            return true;
        }

    }

    public List<Object> listar() {
        List<Object> lista = new ArrayList<>();
        if (inicio == null) {
            return null;
        } else {
            No aux = getPrimeiro();
            while (aux != null) {
                Object vl = aux.getElemento();
                lista.add(vl);
                aux = aux.getProximo();
            }
            return lista;
        }
    }

    public String toString() {
        String texto = "";
        if (this.quantidade > 0) {
            No auxiliar = inicio;
            while (auxiliar != null) {
                texto += auxiliar.getElemento() + ",";
                auxiliar = auxiliar.getProximo();

            }
            return texto.substring(0, texto.length() - 1);
        }
        return texto;
    }

    public boolean removePos(int pos) {
        No noAuxiliar = inicio;
        No noAnterior = null;
        Integer indice = 1;

        if (pos > quantidade) {
            return false;
        }

        if (pos == 1) {
            inicio = noAuxiliar.getProximo();
            quantidade--;
            return true;
        }

        while (noAuxiliar != null) {

            if (indice.equals(pos)) {
                noAnterior.setProximo(noAuxiliar.getProximo());
                quantidade--;
                return true;
            }
            indice++;
            noAnterior = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximo();
        }

        return false;
    }

}
