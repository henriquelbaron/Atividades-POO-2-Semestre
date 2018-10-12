/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.negocio;

import br.com.agenda.dominio.Contato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class Negocio {

    public static void main(String[] args) {
//        adicionar(new Contato( "Henrique"));
//        adicionar(new Contato( "João"));
//        adicionar(new Contato( "Maria"));
//        adicionar(new Contato("aaaaa"));
//        List<Contato> lista = pesquisar("a");
//        for (Contato contato : lista) {
//            System.out.println(contato);
//        }
    }
    
    public static List<Contato> CONTATOS = new ArrayList();

    public static void adicionar(Contato contato) {
        CONTATOS.add(contato);
    }

    public static List<Contato> pesquisar(String termo) {
        List<Contato> retorno = new ArrayList<>();

        for (Contato contato : CONTATOS) {
            if (contato.getNome().toLowerCase().contains(termo.toLowerCase())) {
                retorno.add(contato);
                
            }
        }
        return retorno;
    }

    public static boolean exluir(Integer ID) {
        for (Contato contato : CONTATOS) {
            if(contato.getId().equals(ID)){
                CONTATOS.remove(contato);
                return true;
            }
        }
                return false;
    }
}
