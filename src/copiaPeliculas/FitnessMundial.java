/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copiaPeliculas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;
import vista.mundial;

/**
 *
 * @author Freddy
 */
public class FitnessMundial extends FitnessFunction {

    List equipo = new ArrayList();
    List genres = new ArrayList();

    public FitnessMundial(List movies, List genres) {
        this.equipo = movies;
        this.genres = genres;
    }
    final public static List<IChromosome> chromos = new ArrayList<IChromosome>();
    mundial m = null;
    String cromss = "";

    @Override
    protected double evaluate(IChromosome chromosome) {
        
        double score = 0;
        List dups = new ArrayList();
        int badSolution = 1;
        for (int i = 0; i < chromosome.size(); i++) {
            int index = (Integer) chromosome.getGene(i).getAllele();
            if (dups.contains(index)) {
                badSolution = 0;
            } else {
                dups.add(index);
            }
            Equipos equi = (Equipos) equipo.get(index);
            double genreScore = getGenreScore(equi);
            if (genreScore == 0) {
                badSolution = 0;
            }
            score = (score) + (genreScore);
        }
        FitnessMundial.chromos.add(chromosome);
        // JOptionPane.showMessageDialog(null, chromos.size());
        return (score * badSolution);
    }
    final static List<Equipos> e = new ArrayList<>();

    private double getGenreScore(Equipos equipo) {

        e.add(equipo);
        //System.out.println(e);
        double ranking = 0;
        double numCopas = 0;
        double partido = 0;
        double genreScore = 0;
        if ((Integer.parseInt(equipo.getRanking()) <= 5) && (Integer.parseInt(equipo.getRanking()) >= 0)) {
            ranking = ranking + 12;
        }
        if ((Integer.parseInt(equipo.getRanking()) > 5) && (Integer.parseInt(equipo.getRanking()) <= 10)) {
            ranking = ranking + 10;
        }
        if ((Integer.parseInt(equipo.getRanking()) > 10) && (Integer.parseInt(equipo.getRanking()) <= 10)) {
            ranking = ranking + 8;
        }
        if ((Integer.parseInt(equipo.getRanking()) > 15) && (Integer.parseInt(equipo.getRanking()) <= 20)) {
            ranking = ranking + 6;
        }
        if ((Integer.parseInt(equipo.getRanking()) > 20) && (Integer.parseInt(equipo.getRanking()) <= 25)) {
            ranking = ranking + 4;
        }
        if ((Integer.parseInt(equipo.getRanking()) > 25)) {
            ranking = ranking + 2;
        }

        if ((Integer.parseInt(equipo.getPartido1()) == 0) || (Integer.parseInt(equipo.getPartido2()) == 0) || (Integer.parseInt(equipo.getPartido3()) == 0)) {
            partido = partido + 2;
        }
        if ((Integer.parseInt(equipo.getPartido1()) == 1) || (Integer.parseInt(equipo.getPartido2()) == 1) || (Integer.parseInt(equipo.getPartido3()) == 1)) {
            partido = partido + 3;
        }
        if ((Integer.parseInt(equipo.getPartido1()) == -1) || (Integer.parseInt(equipo.getPartido2()) == -1) || (Integer.parseInt(equipo.getPartido3()) == -1)) {
            partido = partido + 1;
        }
        numCopas = Integer.parseInt(equipo.getNumCopas());
        genreScore = ranking + numCopas + partido;
        return genreScore;
    }
//    public void finles8() {
//        List<Equipos> et = new ArrayList<>();
//        List<Equipos> etfinal = new ArrayList<>();
//        int cont = 0;
//        int j = 0;
//        for (int i =0 ; i > e.size()-1; i++) {
//            et.add(e.get(i));
//            //cont = cont + 1;
//            if (et.size() == 300) {
//                break;
//            }
//        }
//        Set<Equipos> linkedHashSet = new LinkedHashSet<Equipos>();
//        linkedHashSet.addAll(et);
//        et.clear();
//        et.addAll(linkedHashSet);
//        String s = "";
//        //JOptionPane.showMessageDialog(null, et);
//        for (int i = 0; i < et.size(); i++) {
//            s = s + et.get(i)+"\n";
//        }
//        System.out.println(s);
//
//
//    }
}
