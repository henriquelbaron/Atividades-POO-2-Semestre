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
public class Imovel {

    protected String endereco;
    protected Double vMetroQuadrado;
    protected String proprietario;
    protected Double area;

   @Override
    public String toString() {
        return "Nome: " + proprietario + "\nEndereço: " + endereco +""
                + "\nValor IPTU: " +Negocio.df.format(calculaIptu()) + "\nValor Edificação: Terreno Vazio"
                + "\nSoma dos impostos: "+ Negocio.df.format(calculaIptu());
    }
    public void status(){
        
    }
    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String edereco) {
        this.endereco = edereco;
    }

    public Double getvMetroQuadrado() {
        return vMetroQuadrado;
    }

    public void setvMetroQuadrado(Double vMetroQuadrado) {
        this.vMetroQuadrado = vMetroQuadrado;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double calculaIptu() {
        return (area * vMetroQuadrado)*0.01;
    }
}
