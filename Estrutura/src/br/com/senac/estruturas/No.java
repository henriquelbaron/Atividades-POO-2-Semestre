package br.com.senac.estruturas;

public class No {

    private Object elemento;
    private No proximo;
    private No anterior;

    public No() {
    }

    public No(Object elemento) {
        this.elemento = elemento;
    }

    
    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return elemento.toString();
    }

    
}
