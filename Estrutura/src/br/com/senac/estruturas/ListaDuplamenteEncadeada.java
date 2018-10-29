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
    private No primeiro;
    private No ultimo;

    public ListaDuplamenteEncadeada() {
        this.quantidade = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void adicionar(Object o) {
        No novoElemento = new No();
        novoElemento.setElemento(o);
        if (null == primeiro) {
            primeiro = novoElemento;
        } else {
            No auxiliar = primeiro;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(novoElemento);
        }
        quantidade++;
    }

    public List<Object> listar() {
        List<Object> lista = new ArrayList<>();
        if (primeiro == null) {
            return null;
        } else {
            No aux = getPrimeiro();
            while (aux != null) {
                Object vl = aux.getValor();
                lista.add(vl);
                aux = aux.getProximo();
            }
            return lista;
        }
    }

    public boolean procura(String valor) {
        No aux = getPrimeiro();
        while (aux != null) {
            if (valor.equals(aux.getValor())) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    public boolean insereInicio(String valor) {
        boolean procura = false;
        procura = procura(valor);
        if (!procura) {
            No novo = new No();
            quantidade++;
            if (primeiro == null) {
                novo.setValor(valor);
                setPrimeiro(novo);
                setUltimo(novo);
                return true;
            } else {
                primeiro.setAnterior(novo);
                novo.setValor(valor);
                novo.setProximo(primeiro);
                setPrimeiro(novo);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean insereFim(String valor) {
        boolean procura = false;
        procura = procura(valor);
        if (!procura) {
            No novo = new No();
            quantidade++;
            if (ultimo == null) {
                novo.setValor(valor);
                primeiro = novo;
                ultimo = novo;
                return true;
            } else {
                ultimo.setProximo(novo);
                novo.setValor(valor);
                ultimo = novo;
                return true;
            }
        } else {
            return false;
        }
    }
}
