/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.atividade01;

import br.com.senac.estruturas.ListaDuplamenteEncadeada;
import br.com.senac.estruturas.No;
import br.com.senac.estruturas.Pilha;
import java.util.List;

/**
 * Imprima os elementos da lista do início ao fim. Verifique se o resultado é o
 * esperado: “Maria, Paula, Pedro, José, João, Marcelo” Imprima os elementos na
 * ordem inversa. Verifique se o resultado é o esperado: “Marcelo, João, José,
 * Pedro, Paula, Maria”
 *
 * @author ACER
 */
public class Atividade01 {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada no = new ListaDuplamenteEncadeada();
        no.adicionar("João");
        no.adicionar("Maria");
        no.adicionar("Paula");
        no.adicionar("Pedro");
        /*Remove o primeiro*/
        no.removePos(1);
        no.adicionar("José");
        /*Remove o primeiro*/
        no.removePos(1);
        no.adicionar("João");
        no.adicionar("Marcelo");
        /*Adiciona Maria na primeira posição*/
        no.adicionaInicio("Maria");
        Pilha pilha = new Pilha();
        List lista = no.listar();
        for (Object object : lista) {
        No aux = new No();
            aux.equals(object);
            pilha.add(aux);
            System.out.println(object);
        }
        System.out.println("\nOrden inversa");
        for (int i = lista.size() - 1; i >= 0; i--) {
            Object get = lista.get(i);
            System.out.println(get);
        }
        
        pilha.imprimir();
    }
}
