/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;


/**
 *
 * @author Alunos
 */
public class ListaCircularTEste {

//atributos
    private No inicio;

    //methods
    /**
     * Add, adiciona um novo dado/informa��o no inicio da lista.
     *
     * @param int n
     */
    void add(int n) {
        if (inicio == null) {
            inicio = new No(n);
        } else {
            No novo = new No(n);
            novo.setProx(getInit());
            inicio.setAnt(novo);
            No aux = getInit();
            novo.setAnt(aux);
            setInit(novo);
            novo = aux;
        }
    }

    /**
     * remove, remove um dado/informa��o da lista, caso exista. Caso contr�rio,
     * nada ocorre.
     *
     * @param int n
     */
    void remove(int n) {
        No aux, p;
        p = getInit();
        aux = null;
        while (p != null && p.getDado() != n) {
            aux = p;
            p = p.getProx();
        }
        if (p != null) {
            if (aux == null) {
                setInit(p.getProx());
            } else {
                aux.setProx(p.getProx());
            }

            p = null;
        }
    }

    /**
     * Procura um certo numero na lista, retorna uma frase se encontrado.
     *
     * @param int n
     */
    String buscar(int n) {
        No aux, p;
        p = getInit();
        aux = null;

        do {
            aux = p;
            p = p.getProx();

        } while (p != null && p.getDado() != n);

        if (p.getDado() == n) {
            return "existe na lista";
        } else {
            return "não existe na lista";
        }
    }

    /**
     * listar, lista/printa no console os valores correntes na lista
     */
    void listar() {
        for (No p = getInit(); p != null; p = p.getProx()) {
            System.out.print(p.getDado() + " ");
        }
    }

    //getters and setters privates
    private No getInit() {
        return inicio;
    }

    private void setInit(No init) {
        this.inicio = init;
    }

}
