/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordegp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Alunos
 */
public class SimuladorDeGP {

    /**
     * @param args the command line arguments
     */
    public static Map<Integer, Integer> posicaoPontos = new HashMap<>();

    static {
        posicaoPontos.put(1, 25);
        posicaoPontos.put(2, 18);
        posicaoPontos.put(3, 15);
        posicaoPontos.put(4, 12);
        posicaoPontos.put(5, 10);
        posicaoPontos.put(6, 8);
        posicaoPontos.put(7, 6);
        posicaoPontos.put(8, 4);
        posicaoPontos.put(9, 2);
        posicaoPontos.put(10, 1);
    }

    public static void main(String[] args) throws InterruptedException {
        List<Piloto> pilotos = new ArrayList();
        pilotos.add(new Piloto("Stoffel", "Vandoorne", "McLaren"));
        pilotos.add(new Piloto("Daniel", "Ricciardo", "RBR"));
        pilotos.add(new Piloto("Sebastian", "Vettel", "Ferrari"));
        pilotos.add(new Piloto("Kimi", "Raikkonen", "Ferrari"));
        pilotos.add(new Piloto("Kevin", "Magnussen", "Haas"));
        pilotos.add(new Piloto("Sergio", "Pérez", "Racing Point Force India"));
        pilotos.add(new Piloto("Esteban", "Ocon", "Racing Point Force India"));
        pilotos.add(new Piloto("Lewis", "Hamilton", "Mercedes"));
        pilotos.add(new Piloto("Valtteri", "Bottas", "Mercedes"));
        pilotos.add(new Piloto("Max", "Verstappen", "RBR"));
        pilotos.add(new Piloto("Nico", "Hulkenberg", "Renault"));
        pilotos.add(new Piloto("Fernando", "Alonso", "McLaren"));
        List<Etapa> gp = new ArrayList<>();
        gp.add(new Etapa("Australia", 58, pilotos));
        gp.add(new Etapa("Barein", 57, pilotos));
        gp.add(new Etapa("China", 56, pilotos));
        gp.add(new Etapa("Azerbaijão", 51, pilotos));
        gp.add(new Etapa("Espanha", 66, pilotos));
        gp.add(new Etapa("Mônaco", 78, pilotos));
        gp.add(new Etapa("Canadá", 70, pilotos));
        gp.add(new Etapa("França", 53, pilotos));
        gp.add(new Etapa("Áustria", 71, pilotos));
        List<Thread> th = new ArrayList<>();
        for (int m = 0; m < gp.size(); m++) {
            Etapa get = gp.get(m);
            Thread t = new Thread(get);
            t.start();
            th.add(t);
        }
        for (int m = 0; m < th.size(); m++) {
            Thread get = th.get(m);
            get.join();
        }
        Collections.sort(pilotos);
        Collections.reverse(pilotos);
        for (Piloto piloto : pilotos) {
            System.out.println(piloto);

        }
//       
    }
}
