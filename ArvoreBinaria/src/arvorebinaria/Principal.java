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
public class Principal {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.adicionar(6);
        arvore.adicionar(1);
        arvore.adicionar(2);
        arvore.adicionar(3);
        arvore.adicionar(4);
        arvore.adicionar(5);
        arvore.adicionar(7);
        arvore.adicionar(8);
        arvore.adicionar(9);
        arvore.adicionar(10);
        arvore.adicionar(11);
        arvore.adicionar(12);
        System.out.println("Imprimir em Ordem");
        arvore.imprimirEmOrden();
        System.out.println("\nImprime em pre Orden");
        arvore.imprimePreOrdem();
        System.out.println("\n");
        System.out.println(arvore.busca(1));
        System.out.println(arvore.busca(13));
    }
}
