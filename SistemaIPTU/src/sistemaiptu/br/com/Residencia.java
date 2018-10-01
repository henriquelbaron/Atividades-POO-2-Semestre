/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaiptu.br.com;

/**
 *
 * @author Alunos
 */
public class Residencia extends TerrenoEdificado {
    private Integer nMoradores;
    

  @Override
    public String toString() {
        return "Nome: " + proprietario + "\nEndereço: " + endereco +""
                + "\nVAlor IPTU: " +Negocio.df.format(calculaIptu()) + "\nValor Edificaçã?: "+Negocio.df.format(calcularImpostoEdificacao())+""
                + "\nSoma dos impostos: "+ Negocio.df.format(calculaIptu()+calcularImpostoEdificacao());
    }

    public Integer getnMoradores() {
        return nMoradores;
    }

    public void setnMoradores(Integer nMoradores) {
        this.nMoradores = nMoradores;
    }

    
}