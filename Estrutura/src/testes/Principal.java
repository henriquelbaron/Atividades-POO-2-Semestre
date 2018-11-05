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
public class Principal {

    public static void main(String[] args) {
        ListaCircularTEste l = new ListaCircularTEste();
        //Teste 1
        System.out.println("Teste 1 - adicionando na lista e listando");

        l.add(10);
        l.add(20);
        l.add(12);
        l.add(30);

        l.listar();

        System.out.println();

        //Teste 2
        System.out.println("Teste 2 - removendo da lista e listando");

        l.remove(10);

        l.listar();
    }
}
