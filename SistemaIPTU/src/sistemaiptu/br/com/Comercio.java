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
public class Comercio extends TerrenoEdificado {

    private String tipo;

    @Override
    public String toString() {
        return "Nome: " + proprietario + "\nEndereço: " + endereco + ""
                + "\nVAlor IPTU: " + Negocio.df.format(calculaIptu()) + "\nValor Edificaçã?: " + Negocio.df.format(calcularImpostoEdificacao()) + ""
                + "\nSoma dos impostos: " + Negocio.df.format(calculaIptu() + calcularImpostoEdificacao()) + "\nTipo: " + tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Double calculaIptu() {
        if (tipo.equalsIgnoreCase("COMERCIO")) {
            return (area * vMetroQuadrado) * 0.015;
        } else {
            return (area * vMetroQuadrado) * 0.025;
        }
    }
}
