/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciaria.dominio;

import java.util.Date;

/**
 *
 * @author Alunos
 */
public class Venda {

    private Date data;
    private Item itens;

    public Venda() {
    }

    public Venda(Date data, Item itens) {
        this.data = data;
        this.itens = itens;
    }

    
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Item getItens() {
        return itens;
    }

    public void setItens(Item itens) {
        this.itens = itens;
    }
}
