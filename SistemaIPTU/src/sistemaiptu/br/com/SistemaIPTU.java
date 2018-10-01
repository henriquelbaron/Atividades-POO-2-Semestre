/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaiptu.br.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author ACER
 */
public class SistemaIPTU {

    /**
     * @param args the command line arguments
     */
    private static DecimalFormat df = new DecimalFormat("#,###.00");
    public static void main(String[] args) throws Exception {
        lerArquivo();
        TerrenoVazio tv = new TerrenoVazio();
        Residencia r = new Residencia();
        Comercio c = new Comercio();
//        System.out.println(tv);
//        System.out.println(r);
//        System.out.println(c);
        Negocio.lista();
        gravarArquivoConcatenando(Negocio.retorna());
        
    }
    private static void gravarArquivoConcatenando(List<Imovel> lista){
        try {
            FileWriter fw = new FileWriter("dados_impostos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append("Nome;Endereço;Valor IPTU;Valor Edificação;SomaImpostos\r\n");
            for (Imovel imovel : lista) {
            String proprietario = imovel.getProprietario();
            String endereco = imovel.getEndereco();
            Double vIPTU = imovel.calculaIptu();
            Double iEdificacao = 0.0;
            Double area = imovel.getArea();
            Double areaConstruida = 0.0;
            if(imovel instanceof TerrenoEdificado){
                TerrenoEdificado te =(TerrenoEdificado) imovel;
                areaConstruida = te.calcularImpostoEdificacao();
                iEdificacao = te.getAreaEdificada();
            }
            Double soma = vIPTU+iEdificacao;
            String apresenta = imovel.getProprietario()+";"+imovel.getEndereco()+";"+df.format(vIPTU)+";"+df.format(iEdificacao)+";"+df.format(soma);
                System.out.println(apresenta);
            bw.append(apresenta + "\r\n");
            bw.flush();
            }
            bw.close();
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void lerArquivo() throws Exception {
        try {
            FileReader leitor = new FileReader("dados_prefeitura.txt");
            BufferedReader br = new BufferedReader(leitor);
            String linha = br.readLine();
            String conteudo = "";
            while (linha != null) {
                conteudo += linha + "\n";
                linha = br.readLine();
            }
            br.close();
            String[] ler = conteudo.split("\n");
            for (int i = 1; i < ler.length; i++) {
                String string = ler[i];
                String[] dados = string.split(";");
                String endereco = dados[1];
                String proprietario = dados[2];
//                Double valorMetro = Math.random() * 1000;
                Double valorMetro = 400.0;
                String str = dados[3];
                Double area = Double.valueOf(str.replace(",", "."));
                if (dados[0].equalsIgnoreCase("VAGO")) {
                    Negocio.addTerrenoVazio(endereco, proprietario, area, valorMetro);
                }
                if (dados[0].equalsIgnoreCase("RESIDENCIAL")) {
                    String str1 = dados[4];
                    Double areaEdificada = Double.valueOf(str1.replace(",", "."));
                    Integer pavimentos = Integer.valueOf(dados[5]);
                    Integer nMoradores = Integer.valueOf(dados[6]);
                    Negocio.addImovelResidencial(endereco, proprietario, area, valorMetro, areaEdificada, pavimentos, nMoradores);
                }
                if (dados[0].equalsIgnoreCase("COMERCIAL")) {
                    String str1 = dados[4];
                    Double areaEdificada = Double.valueOf(str1.replace(",", "."));
                    Integer pavimentos = Integer.valueOf(dados[5]);
                    String tipo = dados[7];
                    Negocio.addImovelComercial(endereco, proprietario, area, valorMetro, areaEdificada, pavimentos, tipo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado " + e.getMessage());
            System.exit(0);
        }
    }

}