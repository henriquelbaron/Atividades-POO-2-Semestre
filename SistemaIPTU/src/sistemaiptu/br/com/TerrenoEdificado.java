/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaiptu.br.com;

/**
 *
 * @author ACER
 */
public class TerrenoEdificado extends Imovel{
    protected Double areaEdificada;
    protected Integer nPavimentos;

    
    
    public Double calcularImpostoEdificacao(){
        return (areaEdificada * vMetroQuadrado)*0.02;
    }

    public Double getAreaEdificada() {
        return areaEdificada;
    }

    public void setAreaEdificada(Double areaEdificada) {
        this.areaEdificada = areaEdificada;
    }

    public Integer getnPavimentos() {
        return nPavimentos;
    }

    public void setnPavimentos(Integer nPavimentos) {
        this.nPavimentos = nPavimentos;
    }
    
}