/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.atividade07;

import br.com.senac.estruturas.No;
import br.com.senac.estruturas.Pilha;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Implementar o jogo da forca lendo as palavras de um arquivo txt criado por
 * você (uma palavra simples por linha - não composta), armazenando-as em uma
 * lista circular. Sorteie uma palavra e inicie o jogo para que o usuário faça a
 * adivinhação. Dê cinco possibilidades de erro para o usuário. Para cada letra,
 * armazene-a em uma estrutura de dados adequada de forma que ao final do jogo
 * (acertando ou não) apresente todas as tentativas na sequência opostas a que
 * foi inserida.
 *
 * @author ACER
 */
public class Atividade07 {

    public static void main(String[] args) throws Exception {
        Pilha empilha = new Pilha();
        List palavras = carregar();
        for (Object palavra : palavras) {
            System.out.println(palavra);
        }
        jogar();
    }

    private static void jogar() {
        String palavraSorteada = "pacote";

        int i = 0;
        String palavra = "Java";
        int qtd = palavra.length();
        for (i = 0; i < qtd; i++) {
            System.out.print(palavra.charAt(i) + " ");
            System.out.println("\nPossue " + qtd + " letras.");
        }
    }

    private static List carregar() throws Exception {
        List palavras = new ArrayList();
        try {
            FileReader leitor = new FileReader("palavras.txt");
            BufferedReader bf = new BufferedReader(leitor);
            String linha = bf.readLine();
            String conteudo = "";
            while (linha != null) {
                palavras.add(linha);
                conteudo += linha + "\n";
                linha = bf.readLine();
            }
            bf.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
            System.exit(0);
        }
        return palavras;
    }
}
