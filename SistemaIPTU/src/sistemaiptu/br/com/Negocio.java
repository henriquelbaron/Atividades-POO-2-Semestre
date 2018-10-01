/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaiptu.br.com;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class Negocio {

    private static List<Imovel> imovels = new ArrayList<>();
    public static DecimalFormat df = new DecimalFormat("#,##0.00");

    public static void lista() {
        for (Imovel imovel : imovels) {
            System.out.println(imovel + "\n");
        }
    }
    public static List<Imovel> retorna(){
        return imovels;
    }
    
    public static void addImovelComercial(String endereco, String proprietario, Double area, Double vMetro,
            Double areaEdificada, Integer nPavimentos, String tipo) {
        Comercio comercio = new Comercio();
        comercio.setProprietario(proprietario);
        comercio.setArea(area);
        comercio.setEndereco(endereco);
        comercio.setvMetroQuadrado(vMetro);
        comercio.setAreaEdificada(areaEdificada);
        comercio.setnPavimentos(nPavimentos);
        comercio.setTipo(tipo);
        imovels.add(comercio);
    }

    public static void addImovelResidencial(String endereco, String proprietario, Double area, Double vMetro,
            Double areaEdificada, Integer nPavimentos, Integer nMoradores) {
        Residencia residencia = new Residencia();
        residencia.setProprietario(proprietario);
        residencia.setArea(area);
        residencia.setEndereco(endereco);
        residencia.setvMetroQuadrado(vMetro);
        residencia.setAreaEdificada(areaEdificada);
        residencia.setnPavimentos(nPavimentos);
        residencia.setnMoradores(nMoradores);
        imovels.add(residencia);
    }

    public static void addTerrenoVazio(String endereco, String proprietario, Double area, Double vMetro) {
        TerrenoVazio terreno = new TerrenoVazio();
        terreno.setProprietario(proprietario);
        terreno.setArea(area);
        terreno.setEndereco(endereco);
        terreno.setvMetroQuadrado(vMetro);
        imovels.add(terreno);

    }
}
