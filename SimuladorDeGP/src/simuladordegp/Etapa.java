/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordegp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alunos
 */
public class Etapa implements Runnable {

    private String nome;
    private Integer nVoltas;
    private List<Carro> carros;
    private Integer posicao;

    public Etapa(String nome, Integer nVoltas, List<Piloto> pilotos) {
        this.nome = nome;
        this.nVoltas = nVoltas;
        this.carros = new ArrayList();
        for (Piloto piloto : pilotos) {
            carros.add(new Carro(piloto, this));
        }
        this.posicao = 1;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getnVoltas() {
        return nVoltas;
    }

    public void setnVoltas(Integer nVoltas) {
        this.nVoltas = nVoltas;
    }

    @Override
    public void run() {
        List<Thread> th = new ArrayList<>();
        for (int m = 0; m < carros.size(); m++) {
            Carro get = carros.get(m);
            Thread t = new Thread(get);
            t.start();
            th.add(t);
        }
        for (int m = 0; m < th.size(); m++) {
            Thread get = th.get(m);
            try {
                get.join();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("\nFinal Grande Prêmio de " + nome);
        Collections.sort(carros);
        for (Carro carross : carros) {
            System.out.println(carross);
        }
    }

    public Integer getPosicao() {
        return posicao++;
    }

}
