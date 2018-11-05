/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author Alunos
 */
public class Arvore {

    private Integer informacao;
    private Arvore esquerda;
    private Arvore direita;

    public Arvore() {
        this.informacao = null;
        this.esquerda = null;
        this.direita = null;
    }

    public Arvore(Integer info) {
        this.informacao = info;
        this.esquerda = null;
        this.direita = null;

    }

    public Integer getInformacao() {
        return informacao;
    }

    public void setInformacao(Integer numero) {
        this.informacao = numero;
    }

    public Arvore getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Arvore esquerda) {
        this.esquerda = esquerda;
    }

    public Arvore getDireita() {
        return direita;
    }

    public void setDireita(Arvore direita) {
        this.direita = direita;
    }

    public boolean isEmpty() {
        return informacao == null;
    }

    public void adicionar(Integer info) {
        if (isEmpty()) {
            setInformacao(info);
        } else {
            if (info < getInformacao()) {
                if (getEsquerda() == null) {
                    Arvore novo = new Arvore(info);
                    setEsquerda(novo);
                } else {
                    Arvore arvoreEsquerda = getEsquerda();
                    arvoreEsquerda.adicionar(info);
                }
            }
            if (info > getInformacao()) {

                if (getDireita() == null) {
                    Arvore novo = new Arvore(info);
                    setDireita(novo);
                } else {
                    Arvore arvoreDireita = getDireita();
                    arvoreDireita.adicionar(info);
                }
            }

        }
    }

    public void emOrdem(Arvore info) {
        if (info != null) {
            emOrdem(info.getEsquerda());
            System.out.print(info.getInformacao() + " ");
            emOrdem(info.getDireita());
        }
    }

    public void imprimirEmOrden() {
        if (isEmpty()) {
            return;
        }

        if (this.esquerda != null) {
            this.esquerda.imprimirEmOrden();
        }

        System.out.print(getInformacao() + " ");

        if (this.direita != null) {
            this.direita.imprimirEmOrden();
        }
    }

    public void imprimePreOrdem() {
        if (isEmpty()) {
            return;
        }

        System.out.print(getInformacao() + " ");

        if (this.esquerda != null) {
            this.esquerda.imprimePreOrdem();
        }

        if (this.direita != null) {
            this.direita.imprimePreOrdem();
        }
    }

    public boolean busca(int info) {
        if (isEmpty()) {
            return false;
        } else {
            if (info == informacao) {
                return true;
            } else {
                if (info > getInformacao()) {
                    if (this.direita == null) {
                        return false;
                    }
                    return this.direita.busca(info);
                } else {
                    if (this.esquerda == null) {
                        return false;
                    }
                    return this.esquerda.busca(info);
                }
            }
        }
    }
}
