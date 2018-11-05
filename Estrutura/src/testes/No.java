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
public class No {
//atributos

    private int dado;
    private No ant;
    private No prox;

    //construct
    No() {
        setDado(0);
        setAnt(null);
        setProx(null);
    }

    No(int n) {
        setDado(n);
        setAnt(null);
        setProx(null);
    }

    //getters and setters
    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No no) {
        this.ant = no;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No no) {
        this.prox = no;
    }
}
