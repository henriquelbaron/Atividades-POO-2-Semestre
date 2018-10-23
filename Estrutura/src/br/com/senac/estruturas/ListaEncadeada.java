package br.com.senac.estruturas;

import br.com.senac.estruturas.Lista;
import java.util.List;

public class ListaEncadeada implements Lista {

    private Integer quantidade;
    private No inicio;

    public ListaEncadeada() {
        this.quantidade = 0;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public No getElemento() {
        return inicio;
    }

    public void setElemento(No elemento) {
        this.inicio = elemento;
    }

    @Override
    public void adicionar(Object o) {
        No novoElemento = new No();
        novoElemento.setElemento(o);
        if (null == inicio) {
            inicio = novoElemento;
        } else {
            No auxiliar = inicio;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(novoElemento);
        }
        quantidade++;
    }

    @Override
    public void adicionar(Object o, Integer id) {
        if (id > quantidade) {
            System.out.println("Erro");
            return;
        }
        if (id.equals(1)) {
            No elemento = new No();
            elemento.setElemento(o);
            No aux = inicio;
            inicio = elemento;
            inicio.setProximo(aux);
        } else {
            No novoElemento = new No();
            novoElemento.setElemento(o);
            No auxiliar = inicio;
            Integer indice = 1;
            while (!id.equals(indice + 1)) {
                auxiliar = auxiliar.getProximo();
                indice++;
            }
            No temporario = auxiliar.getProximo();
            novoElemento.setProximo(temporario);
            auxiliar.setProximo(novoElemento);
        }
        quantidade++;
    }

    @Override
    public Object buscar(Object o) {
        No auxiliar = inicio;
        while (auxiliar != null) {
            if (auxiliar.getElemento().equals(o)) {
                return auxiliar.getElemento();
            }
            auxiliar = auxiliar.getProximo();
        }
        return null;
    }

    @Override
    public Object buscar(Integer i) {
        No auxiliar = inicio;
        if (i > quantidade) {
            return null;
        }
        int aux = 1;
        while (aux < i) {
            auxiliar = auxiliar.getProximo();
            aux++;
        }
        return auxiliar.getElemento();
    }

    @Override
    public Boolean remover(Object o) {
        if (null == inicio) {
            return false;
        } else {
            No auxiliar = inicio;
            No anterior = null;
            while (auxiliar != null) {
                if (auxiliar.getElemento().equals(o)) {
                    anterior= auxiliar;
                    auxiliar = auxiliar.getProximo();
                    return true;
                }
                auxiliar = auxiliar.getProximo();
            }
        }
        return false;
    }

    @Override
    public Boolean remover(Integer i) {
        No auxiliar = inicio;
        No anterior = null;
        Integer indice = 1;
        if (i > quantidade) {
            return false;
        }

        if (i == 1) {
            inicio = auxiliar.getProximo();
            quantidade--;
            return true;
        }else{
            while(auxiliar != null){
                if(indice == i){
                    if(anterior == null){
                        inicio=auxiliar.getProximo();
                    }else{
                        anterior.setProximo(auxiliar.getProximo());
                    }
                    break;
                }else{
                    anterior = auxiliar;
                    auxiliar = auxiliar.getProximo();
                    quantidade--;
                    return true;
                }
            }
        }

    
        return null;
    }

    @Override
    public Integer tamanho() {
        return quantidade;
    }

    @Override
    public Boolean existe(Object o) {
        No auxiliar = inicio;
        while (auxiliar != null) {
            if (auxiliar.getElemento().equals(o)) {
                return true;
            }
            auxiliar = auxiliar.getProximo();
        }
        return false;
    }

    @Override
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
}
