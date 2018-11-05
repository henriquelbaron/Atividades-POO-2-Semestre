/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.atividade05;

import br.com.senac.estruturas.ListaCircular;
import br.com.senac.estruturas.No;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Implemente o sorteio de “dois ou um americano”. Crie um sistema que permita
 * adicionar quantas pessoas desejar e ao final inserir um número que
 * corresponde a posição do ganhador a partir do primeiro. Perceba que a posição
 * pode ser maior que o número de pessoas. Qual a melhor estrutura isso? Há uma
 * forma mais performática?
 *
 * @author ACER
 */
public class Atividade05 {

    private static ListaCircular lista = new ListaCircular();
    private static List<No> listaNo = new ArrayList();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String opcao = "";
        String mensagem = "1) Novo jogador\n 2)Jogar";
        do {
            opcao = JOptionPane.showInputDialog(mensagem);
            switch (opcao) {
                case "1":
                    inserirNovoJogador();
                    break;
                    case"2":
                        jogar();
                        break;
            }
        } while (!opcao.equals("0"));
    }

    private static void inserirNovoJogador() {
        No jogador = new No();
        int n = 0;
        jogador.setElemento("Jogador" + n++);
        listaNo.add(jogador);
        lista.add(jogador);
    }

    private static void jogar() {
        Random r = new Random();
        int soma = 0;
        for (int i = 0; i < listaNo.size(); i++) {
            No get = listaNo.get(i);
            soma = soma + r.nextInt(2)+1;
            System.out.println(soma);
        }
    }
    
    
}
