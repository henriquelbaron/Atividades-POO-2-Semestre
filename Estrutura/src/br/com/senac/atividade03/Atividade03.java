/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.atividade03;

import br.com.senac.estruturas.ListaDuplamenteEncadeada;
import br.com.senac.estruturas.ListaEncadeada;
import java.util.List;

/**
 * Imagine que você está implementando um sistema operacional e precisa
 * escalonar os processos A, B, C, D e E para a execução. Simule a execução
 * desses processos (com os tempos abaixo) supondo que o clock do processador é
 * de 10 segundos. Qual estrutura de dados você utilizaria? Considere a ordem de
 * execução inicial como a ordem alfabética. A = 72 B = 90 C = 68 D = 55 E = 47
 *
 * @author ACER
 */
public class Atividade03 {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionar(72);
        lista.adicionar(90);
        lista.adicionar(68);
        lista.adicionar(55);
        lista.adicionar(47);
        System.out.println(lista);
        List list = lista.listar();
        No aux = null;
        do {
            aux = (No) lista.buscar(1);
            System.out.println(aux);
            if (aux.getElemento() >= 10) {
                aux.setElemento(aux.getElemento() - 10);
                System.out.println(aux);
                lista.remover(1);
                lista.adicionar(aux);
            }

        } while (list == null);
    }
}
