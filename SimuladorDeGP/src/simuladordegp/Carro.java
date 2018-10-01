/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordegp;

import java.util.Random;

/**
 *
 * @author Alunos
 */
public class Carro implements Runnable, Comparable<Carro> {

    private Piloto piloto;
    private Etapa gp;
    private Long tempo;
    private Integer posicao;

    public Carro(Piloto piloto, Etapa gp) {
        this.piloto = piloto;
        this.gp = gp;
        this.tempo = 0L;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    private static String formatarTempo(Long tempo) {
        return String.format("%02d:%02d:%02d", tempo / 3600000, (tempo / 60000) % 60, (tempo / 1000) % 60);
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < gp.getnVoltas(); i++) {
            long auxilar = rand.nextInt(60000) + 71000L;
            tempo += auxilar;
            Long dorme = (long) (auxilar * 0.005);
            try {
                System.out.println(piloto.getSobrenome() + " > " + i + " - " + formatarTempo(auxilar));
                Thread.sleep(dorme / 3);
            } catch (InterruptedException ex) {
            }
        }

        this.posicao = gp.getPosicao();
        if (SimuladorDeGP.posicaoPontos.containsKey(posicao)) {
            int aux = SimuladorDeGP.posicaoPontos.get(posicao);
            piloto.addPontos(aux);
        }
    }

    @Override
    public int compareTo(Carro o) {
        return this.tempo.compareTo(o.getTempo());
    }

    @Override
    public String toString() {
        return this.posicao + " -> " + piloto.getSobrenome() + " Tempo: " + formatarTempo(tempo);
    }

}
