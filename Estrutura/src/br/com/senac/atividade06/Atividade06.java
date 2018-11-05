/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.atividade06;

import br.com.senac.estruturas.ListaDuplamenteEncadeada;
import br.com.senac.estruturas.ListaEncadeada;
import java.util.Random;

/**
 * Dez soldados estão isolados em uma trincheira e precisam cruzar um campo
 * minado para buscar alimento. Eles decidem sortear um soldado para executar
 * essa tarefa. Eles se juntam em um círculo e iniciam uma rodada com N
 * elementos: sorteia um número que corresponde a posição do soldado a partir do
 * primeiro elemento, esse soldado é então excluído do sorteio e uma nova rodada
 * se inicia com N-1 elementos. O soldado que deve cruzar a trincheira é o que
 * não for sorteado em nenhuma rodada e permanecer até o final.
 *
 * @author ACER
 */
public class Atividade06 {

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        Random r = new Random();

        for (int i = 1; i <= 10; i++) {
            lista.adicionar("Soldado " + i);
        }
        System.out.println(lista);
        Integer sorteado;
        Integer contador = 10;
        while (!contador.equals(0)) {
            sorteado = r.nextInt(contador);
            System.out.println(sorteado);
            lista.remover(sorteado);
            contador--;
        }
        System.out.println("O Soldado que cruzara a trincheira sera o " + lista.buscar(1));
    }
}
