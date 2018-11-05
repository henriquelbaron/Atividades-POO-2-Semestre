/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.atividade02;

import br.com.senac.estruturas.ListaEncadeada;
import br.com.senac.estruturas.No;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Crie um programa de gerenciamento de fila de atendimento. Crie um menu com as
 * funções: (i) gerar uma nova senha; (ii) gerar senha prioritária; (iii) chamar
 * próximo e visualizar a fila de espera. Pré requisitos: a. O sistema deve
 * gerar senhas numéricas aleatórias de até 3 dígitos; b. O sistema deve
 * gerenciar as senhas com duas filas (normal e prioritária); c. O sistema só
 * pode chamar uma senha normal se a fila prioritária estiver vazia;
 *
 * @author ACER
 */
public class Atividade02 {

    private static ListaEncadeada senha = new ListaEncadeada();
    private static ListaEncadeada senhaPrioritaria = new ListaEncadeada();

    public static void main(String[] args) {
        System.out.println(senha.isEmpty());
        System.out.println(senhaPrioritaria.isEmpty());
        menu();
    }

    public static void menu() {
        String menu = ">>>>MENU<<<<\n"
                + "1)Nova senha\n"
                + "2)Senha Prioritária\n"
                + "3)Proximo\n"
                + "4)Vizulizar fila de espera\n"
                + "0)Sair ";

        String opcao;
        do {
            opcao = JOptionPane.showInputDialog(menu);
            switch (opcao) {
                case "1":
                    senhaNormal();
                    break;
                case "2":
                    senhaPrioritaria();
                    break;
                case "3":
                    proximo();
                    break;
                case "4":
                    filaDeEspera();
                    break;

            }

        } while (!opcao.equals("0"));

    }

    private static void filaDeEspera() {

        if (!senhaPrioritaria.isEmpty()) {
            System.out.println("Senhas prioritarias:");
            List prioritaria = senhaPrioritaria.listar();
            for (int i = 0; i < prioritaria.size(); i++) {
                Object o = prioritaria.get(i);
                System.out.println(i + ": " + o);
            }
        }

        if (!senha.isEmpty()) {
            List normal = senha.listar();
            System.out.println("Senha:");
            for (int i = 0; i < normal.size(); i++) {
                Object o = normal.get(i);
                System.out.println(i + ": " + o);
            }
        }
    }

    private static void proximo() {

        if (!senhaPrioritaria.isEmpty()) {
            System.out.println("Senha prioriataria : " + senhaPrioritaria.buscar(1));
            senhaPrioritaria.remover(1);
        } else {
            if (!senha.isEmpty()) {
                System.out.println("Senha : " + senha.buscar(1));
                senha.remover(1);
            }
        }
        System.out.println("Ninguém na fila!");

    }

    private static String gerarNovaSenha() {
        Integer numero = (int) (Math.random() * 999 + 1);
        System.out.println(numero);
        return numero.toString();

    }

    private static void senhaNormal() {

        System.out.println("Senha gerada");
        senha.adicionar(gerarNovaSenha());
    }

    private static void senhaPrioritaria() {

        System.out.println("Senha prioritaria Gerada");
        senhaPrioritaria.adicionar(gerarNovaSenha());
    }
}
