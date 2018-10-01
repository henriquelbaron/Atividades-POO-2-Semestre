/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordegp;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alunos
 */
public class Piloto implements Comparable<Piloto> {

    private String nome;
    private String sobrenome;
    private String equipe;
    private Integer nVoltas;
    private Integer pontos;
    private Long tempo;

    public Piloto(String nome, String sobrenome, String equipe) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.equipe = equipe;
        this.nVoltas = 0;
        this.tempo = 0L;
        this.pontos = 0;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getNvoltas() {
        return nVoltas;
    }

    public void setNVoltas(Integer voltas) {
        this.nVoltas = voltas;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        String nome = this.nome.substring(0, 1) + ".";
        return nome + sobrenome + " --> " + pontos;
    }

    public void addPontos(Integer ponto) {
        this.pontos = this.pontos + ponto;
    }

    @Override
    public int compareTo(Piloto o) {
        return this.pontos.compareTo(o.getPontos());
    }
}
