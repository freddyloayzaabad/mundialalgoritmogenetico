/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copiaPeliculas;

import dao.DaoEquipos;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.DefaultFitnessEvaluator;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.SwappingMutationOperator;

/**
 *
 * @author Freddy
 */
public class MundialFitness {

    final public static List<Equipos> equi16 = new ArrayList<Equipos>();
    private Configuration conf;
    private SwappingMutationOperator swapper;
    private FitnessMundial fitnessMundial = null;
    public List equipos = new ArrayList();
    public List genres = new ArrayList();
    final public static List<Equipos> a = new ArrayList<Equipos>();
    private static final int MAX_ALLOWED_EVOLUTIONS = 1000;
    private Chromosome movieChromosome = null;

    public void initialize() throws Exception {
        equipos = this.leerEquipos();
        conf = new DefaultConfiguration();
        Configuration.resetProperty(Configuration.PROPERTY_FITEVAL_INST);
        conf.setFitnessEvaluator(new DefaultFitnessEvaluator());
        conf.getGeneticOperators().clear();
        swapper = new SwappingMutationOperator(conf);
        conf.addGeneticOperator(swapper);
        conf.setPreservFittestIndividual(true);
        conf.setPopulationSize(32);
        conf.setKeepPopulationSizeConstant(false);
        fitnessMundial = new FitnessMundial(equipos, genres);
        conf.setFitnessFunction(fitnessMundial);
        Gene[] movieGenes = new Gene[4];
        movieGenes[0] = new IntegerGene(conf, 0, equipos.size() - 1);
        movieGenes[1] = new IntegerGene(conf, 0, equipos.size() - 1);
        movieGenes[2] = new IntegerGene(conf, 0, equipos.size() - 1);
        movieGenes[3] = new IntegerGene(conf, 0, equipos.size() - 1);
//        movieGenes[4] = new IntegerGene(conf, 0, equipos.size() - 1);
//        movieGenes[5] = new IntegerGene(conf, 0, equipos.size() - 1);
//        movieGenes[6] = new IntegerGene(conf, 0, equipos.size() - 1);
//        movieGenes[7] = new IntegerGene(conf, 0, equipos.size() - 1);


        movieGenes[0].setAllele(new Integer(0));
        movieGenes[1].setAllele(new Integer(1));
        movieGenes[2].setAllele(new Integer(2));
        movieGenes[3].setAllele(new Integer(3));
        movieChromosome = new Chromosome(conf, movieGenes);
//        movieGenes[4].setAllele(new Integer(4));
//        movieGenes[5].setAllele(new Integer(5));
//        movieGenes[6].setAllele(new Integer(6));
//        movieGenes[7].setAllele(new Integer(7));

        conf.setSampleChromosome(movieChromosome);

    }

    private List leerEquipos() {

        List<Equipos> l = new ArrayList<Equipos>();
        List<Equipos> a = new ArrayList<Equipos>();
        List<Equipos> b = new ArrayList<Equipos>();
        List<Equipos> c = new ArrayList<Equipos>();
        List<Equipos> d = new ArrayList<Equipos>();
        List<Equipos> e = new ArrayList<Equipos>();
        List<Equipos> f = new ArrayList<Equipos>();
        List<Equipos> g = new ArrayList<Equipos>();
        List<Equipos> h = new ArrayList<Equipos>();
        List<Equipos> totala = new ArrayList<>();
        List<Equipos> totalb = new ArrayList<>();
        List<Equipos> totalc = new ArrayList<>();
        List<Equipos> totald = new ArrayList<>();
        List<Equipos> totale = new ArrayList<>();
        List<Equipos> totalf = new ArrayList<>();
        List<Equipos> totalg = new ArrayList<>();
        List<Equipos> totalh = new ArrayList<>();
        List<Equipos> totaltotal = new ArrayList<>();

        ArchivoClase ac = new ArchivoClase();
        DaoEquipos de = new DaoEquipos();
        //de.encontrarTodos();
//        JOptionPane.showMessageDialog(null, de.encontrarTodos().size());
//        System.out.println("de: " + de.encontrarTodos());
//        try {
//            ac.leerdatos();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MundialFitness.class.getName()).log(Level.SEVERE, null, ex);
//        }
        for (int i = 0; i < de.encontrarTodos().size(); i++) {
            l.add(de.encontrarTodos().get(i));
        }
        int cont = 0;
        String nom = "";
        for (int i = 0; i < l.size(); i++) {
            // return genreScore;
            if (l.get(i).getGrupo().equals("A")) {
                a.add(l.get(i));
            }
            if (l.get(i).getGrupo().equals("B")) {
                b.add(l.get(i));
                // System.out.print("b: "+b);
            }
            if (l.get(i).getGrupo().equals("C")) {
                c.add(l.get(i));
                //  System.out.print(c);
            }
            if (l.get(i).getGrupo().equals("D")) {
                d.add(l.get(i));
                //System.out.print(d);
            }
            if (l.get(i).getGrupo().equals("E")) {
                e.add(l.get(i));
                // System.out.print(e);
            }
            if (l.get(i).getGrupo().equals("F")) {
                f.add(l.get(i));
                //System.out.print("f: "+f);
            }
            if (l.get(i).getGrupo().equals("G")) {
                g.add(l.get(i));
                //System.out.print("f: "+f);
            }
            if (l.get(i).getGrupo().equals("H")) {
                h.add(l.get(i));
                //System.out.print("f: "+f);
            }
            //nom = l.get(i).getNombre();

        }
        // JOptionPane.showMessageDialog(null, nom);


        double numCopas = 0;
        double genreScore = 0;
        double numCopas1 = 0;
        double genreScore1 = 0;
        double numCopas2 = 0;
        double genreScore2 = 0;
        double numCopas3 = 0;
        double genreScore3 = 0;
        double numCopas4 = 0;
        double genreScore4 = 0;
        double numCopas5 = 0;
        double genreScore5 = 0;
        double numCopas6 = 0;
        double genreScore6 = 0;
        double numCopas7 = 0;
        double genreScore7 = 0;
        double aa = 0.0;
        double aa1 = 0.0;
        double aa2 = 0.0;
        double aa3 = 0.0;
        for (int i = 0; i < a.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(a.get(i).getRanking()) <= 5) && (Integer.parseInt(a.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(a.get(i).getRanking()) > 5) && (Integer.parseInt(a.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(a.get(i).getRanking()) > 10) && (Integer.parseInt(a.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(a.get(i).getRanking()) > 15) && (Integer.parseInt(a.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(a.get(i).getRanking()) > 20) && (Integer.parseInt(a.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(a.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(a.get(i).getPartido1()) == 0) || (Integer.parseInt(a.get(i).getPartido2()) == 0) || (Integer.parseInt(a.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(a.get(i).getPartido1()) == 1) || (Integer.parseInt(a.get(i).getPartido2()) == 1) || (Integer.parseInt(a.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(a.get(i).getPartido1()) == -1) || (Integer.parseInt(a.get(i).getPartido2()) == -1) || (Integer.parseInt(a.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(a.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(a.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(a.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(a.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        double aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totala.add(a.get(0));
        }
        if (aa == genreScore1) {
            totala.add(a.get(1));
        }
        if (totala.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totala.add(a.get(2));
            }
            if (totala.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totala.add(a.get(3));
                }
                if (totala.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totala.add(a.get(0));
                    }
                    if (totala.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totala.add(a.get(1));
                        }
                        if (totala.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totala.add(a.get(2));
                            }
                            if (totala.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totala.add(a.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }
        //JOptionPane.showMessageDialog(null, totala);
        //JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3);


        numCopas = 0;
        genreScore = 0;
        numCopas1 = 0;
        genreScore1 = 0;
        numCopas2 = 0;
        genreScore2 = 0;
        numCopas3 = 0;
        genreScore3 = 0;
        numCopas4 = 0;
        genreScore4 = 0;
        numCopas5 = 0;
        genreScore5 = 0;
        numCopas6 = 0;
        genreScore6 = 0;
        numCopas7 = 0;
        genreScore7 = 0;
        aa = 0.0;
        aa1 = 0.0;
        aa2 = 0.0;
        aa3 = 0.0;
        //JOptionPane.showMessageDialog(null, "b  " + b);
        for (int i = 0; i < b.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(b.get(i).getRanking()) <= 5) && (Integer.parseInt(b.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(b.get(i).getRanking()) > 5) && (Integer.parseInt(b.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(b.get(i).getRanking()) > 10) && (Integer.parseInt(b.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(b.get(i).getRanking()) > 15) && (Integer.parseInt(b.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(b.get(i).getRanking()) > 20) && (Integer.parseInt(b.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(b.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(b.get(i).getPartido1()) == 0) || (Integer.parseInt(b.get(i).getPartido2()) == 0) || (Integer.parseInt(b.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(b.get(i).getPartido1()) == 1) || (Integer.parseInt(b.get(i).getPartido2()) == 1) || (Integer.parseInt(b.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(b.get(i).getPartido1()) == -1) || (Integer.parseInt(b.get(i).getPartido2()) == -1) || (Integer.parseInt(b.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(b.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(b.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(b.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(b.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totalb.add(b.get(0));
        }
        if (aa == genreScore1) {
            totalb.add(b.get(1));
        }
        if (totalb.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totalb.add(b.get(2));
            }
            if (totalb.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totalb.add(b.get(3));
                }
                if (totalb.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totalb.add(b.get(0));
                    }
                    if (totalb.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totalb.add(b.get(1));
                        }
                        if (totalb.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totalb.add(b.get(2));
                            }
                            if (totalb.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totalb.add(b.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }
//        JOptionPane.showMessageDialog(null, "bbb:  " + totalb);
//        JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3);

        numCopas = 0;
        genreScore = 0;
        numCopas1 = 0;
        genreScore1 = 0;
        numCopas2 = 0;
        genreScore2 = 0;
        numCopas3 = 0;
        genreScore3 = 0;
        numCopas4 = 0;
        genreScore4 = 0;
        numCopas5 = 0;
        genreScore5 = 0;
        numCopas6 = 0;
        genreScore6 = 0;
        numCopas7 = 0;
        genreScore7 = 0;
        aa = 0.0;
        aa1 = 0.0;
        aa2 = 0.0;
        aa3 = 0.0;
        // JOptionPane.showMessageDialog(null, "b  " + b);
        for (int i = 0; i < c.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(c.get(i).getRanking()) <= 5) && (Integer.parseInt(c.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(c.get(i).getRanking()) > 5) && (Integer.parseInt(c.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(c.get(i).getRanking()) > 10) && (Integer.parseInt(c.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(c.get(i).getRanking()) > 15) && (Integer.parseInt(c.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(c.get(i).getRanking()) > 20) && (Integer.parseInt(c.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(c.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(c.get(i).getPartido1()) == 0) || (Integer.parseInt(c.get(i).getPartido2()) == 0) || (Integer.parseInt(c.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(c.get(i).getPartido1()) == 1) || (Integer.parseInt(c.get(i).getPartido2()) == 1) || (Integer.parseInt(c.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(c.get(i).getPartido1()) == -1) || (Integer.parseInt(c.get(i).getPartido2()) == -1) || (Integer.parseInt(c.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(c.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(c.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(c.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(c.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totalc.add(c.get(0));
        }
        if (aa == genreScore1) {
            totalc.add(c.get(1));
        }
        if (totalc.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totalc.add(c.get(2));
            }
            if (totalc.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totalc.add(c.get(3));
                }
                if (totalc.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totalc.add(c.get(0));
                    }
                    if (totalc.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totalc.add(c.get(1));
                        }
                        if (totalc.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totalc.add(c.get(2));
                            }
                            if (totalc.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totalc.add(c.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }
//        JOptionPane.showMessageDialog(null, "ccc:  " + totalc);
//        JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3);


        numCopas = 0;
        genreScore = 0;
        numCopas1 = 0;
        genreScore1 = 0;
        numCopas2 = 0;
        genreScore2 = 0;
        numCopas3 = 0;
        genreScore3 = 0;
        numCopas4 = 0;
        genreScore4 = 0;
        numCopas5 = 0;
        genreScore5 = 0;
        numCopas6 = 0;
        genreScore6 = 0;
        numCopas7 = 0;
        genreScore7 = 0;
        aa = 0.0;
        aa1 = 0.0;
        aa2 = 0.0;
        aa3 = 0.0;
        // JOptionPane.showMessageDialog(null, "d  " + d);
        for (int i = 0; i < d.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(d.get(i).getRanking()) <= 5) && (Integer.parseInt(d.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(d.get(i).getRanking()) > 5) && (Integer.parseInt(d.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(d.get(i).getRanking()) > 10) && (Integer.parseInt(d.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(d.get(i).getRanking()) > 15) && (Integer.parseInt(d.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(d.get(i).getRanking()) > 20) && (Integer.parseInt(d.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(d.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(d.get(i).getPartido1()) == 0) || (Integer.parseInt(d.get(i).getPartido2()) == 0) || (Integer.parseInt(d.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(d.get(i).getPartido1()) == 1) || (Integer.parseInt(d.get(i).getPartido2()) == 1) || (Integer.parseInt(d.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(d.get(i).getPartido1()) == -1) || (Integer.parseInt(d.get(i).getPartido2()) == -1) || (Integer.parseInt(d.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(d.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(d.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(d.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(d.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totald.add(d.get(0));
        }
        if (aa == genreScore1) {
            totald.add(d.get(1));
        }
        if (totald.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totald.add(d.get(2));
            }
            if (totald.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totald.add(d.get(3));
                }
                if (totald.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totald.add(d.get(0));
                    }
                    if (totald.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totald.add(d.get(1));
                        }
                        if (totald.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totald.add(d.get(2));
                            }
                            if (totald.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totald.add(d.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }
//        JOptionPane.showMessageDialog(null, "ddd:  " + totald);
//        JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3);

        numCopas = 0;
        genreScore = 0;
        numCopas1 = 0;
        genreScore1 = 0;
        numCopas2 = 0;
        genreScore2 = 0;
        numCopas3 = 0;
        genreScore3 = 0;
        numCopas4 = 0;
        genreScore4 = 0;
        numCopas5 = 0;
        genreScore5 = 0;
        numCopas6 = 0;
        genreScore6 = 0;
        numCopas7 = 0;
        genreScore7 = 0;
        aa = 0.0;
        aa1 = 0.0;
        aa2 = 0.0;
        aa3 = 0.0;
        // JOptionPane.showMessageDialog(null, "e  " + e);
        for (int i = 0; i < e.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(e.get(i).getRanking()) <= 5) && (Integer.parseInt(e.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(e.get(i).getRanking()) > 5) && (Integer.parseInt(e.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(e.get(i).getRanking()) > 10) && (Integer.parseInt(e.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(e.get(i).getRanking()) > 15) && (Integer.parseInt(e.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(e.get(i).getRanking()) > 20) && (Integer.parseInt(e.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(e.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(e.get(i).getPartido1()) == 0) || (Integer.parseInt(e.get(i).getPartido2()) == 0) || (Integer.parseInt(e.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(e.get(i).getPartido1()) == 1) || (Integer.parseInt(e.get(i).getPartido2()) == 1) || (Integer.parseInt(e.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(e.get(i).getPartido1()) == -1) || (Integer.parseInt(e.get(i).getPartido2()) == -1) || (Integer.parseInt(e.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(e.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(e.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(e.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(e.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totale.add(e.get(0));
        }
        if (aa == genreScore1) {
            totale.add(e.get(1));
        }
        if (totale.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totale.add(e.get(2));
            }
            if (totale.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totale.add(e.get(3));
                }
                if (totale.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totale.add(e.get(0));
                    }
                    if (totale.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totale.add(e.get(1));
                        }
                        if (totale.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totale.add(e.get(2));
                            }
                            if (totale.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totale.add(e.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }
//        JOptionPane.showMessageDialog(null, "e:  " + totale);
//        JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3);

        numCopas = 0;
        genreScore = 0;
        numCopas1 = 0;
        genreScore1 = 0;
        numCopas2 = 0;
        genreScore2 = 0;
        numCopas3 = 0;
        genreScore3 = 0;
        numCopas4 = 0;
        genreScore4 = 0;
        numCopas5 = 0;
        genreScore5 = 0;
        numCopas6 = 0;
        genreScore6 = 0;
        numCopas7 = 0;
        genreScore7 = 0;
        aa = 0.0;
        aa1 = 0.0;
        aa2 = 0.0;
        aa3 = 0.0;
        //  JOptionPane.showMessageDialog(null, "f " + f);
        for (int i = 0; i < f.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(f.get(i).getRanking()) <= 5) && (Integer.parseInt(f.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(f.get(i).getRanking()) > 5) && (Integer.parseInt(f.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(f.get(i).getRanking()) > 10) && (Integer.parseInt(f.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(f.get(i).getRanking()) > 15) && (Integer.parseInt(f.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(f.get(i).getRanking()) > 20) && (Integer.parseInt(f.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(f.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(f.get(i).getPartido1()) == 0) || (Integer.parseInt(f.get(i).getPartido2()) == 0) || (Integer.parseInt(f.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(f.get(i).getPartido1()) == 1) || (Integer.parseInt(f.get(i).getPartido2()) == 1) || (Integer.parseInt(f.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(f.get(i).getPartido1()) == -1) || (Integer.parseInt(f.get(i).getPartido2()) == -1) || (Integer.parseInt(f.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(f.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(f.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(f.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(f.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totalf.add(f.get(0));
        }
        if (aa == genreScore1) {
            totalf.add(f.get(1));
        }
        if (totalf.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totalf.add(f.get(2));
            }
            if (totalf.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totalf.add(f.get(3));
                }
                if (totalf.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totalf.add(f.get(0));
                    }
                    if (totalf.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totalf.add(f.get(1));
                        }
                        if (totalf.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totalf.add(f.get(2));
                            }
                            if (totalf.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totalf.add(f.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }
//        JOptionPane.showMessageDialog(null, "f:  " + totalf);
//        JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3);


        numCopas = 0;
        genreScore = 0;
        numCopas1 = 0;
        genreScore1 = 0;
        numCopas2 = 0;
        genreScore2 = 0;
        numCopas3 = 0;
        genreScore3 = 0;
        numCopas4 = 0;
        genreScore4 = 0;
        numCopas5 = 0;
        genreScore5 = 0;
        numCopas6 = 0;
        genreScore6 = 0;
        numCopas7 = 0;
        genreScore7 = 0;
        aa = 0.0;
        aa1 = 0.0;
        aa2 = 0.0;
        aa3 = 0.0;
        //  JOptionPane.showMessageDialog(null, "g " + g);
        for (int i = 0; i < g.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(g.get(i).getRanking()) <= 5) && (Integer.parseInt(g.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(g.get(i).getRanking()) > 5) && (Integer.parseInt(g.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(g.get(i).getRanking()) > 10) && (Integer.parseInt(g.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(g.get(i).getRanking()) > 15) && (Integer.parseInt(g.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(g.get(i).getRanking()) > 20) && (Integer.parseInt(g.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(g.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(g.get(i).getPartido1()) == 0) || (Integer.parseInt(g.get(i).getPartido2()) == 0) || (Integer.parseInt(g.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(g.get(i).getPartido1()) == 1) || (Integer.parseInt(g.get(i).getPartido2()) == 1) || (Integer.parseInt(g.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(g.get(i).getPartido1()) == -1) || (Integer.parseInt(g.get(i).getPartido2()) == -1) || (Integer.parseInt(g.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(g.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(g.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(g.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(g.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totalg.add(g.get(0));
        }
        if (aa == genreScore1) {
            totalg.add(g.get(1));
        }
        if (totalg.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totalg.add(g.get(2));
            }
            if (totalg.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totalg.add(g.get(3));
                }
                if (totalg.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totalg.add(g.get(0));
                    }
                    if (totalg.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totalg.add(g.get(1));
                        }
                        if (totalg.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totalg.add(g.get(2));
                            }
                            if (totalg.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totalg.add(g.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }


        numCopas = 0;
        genreScore = 0;
        numCopas1 = 0;
        genreScore1 = 0;
        numCopas2 = 0;
        genreScore2 = 0;
        numCopas3 = 0;
        genreScore3 = 0;
        numCopas4 = 0;
        genreScore4 = 0;
        numCopas5 = 0;
        genreScore5 = 0;
        numCopas6 = 0;
        genreScore6 = 0;
        numCopas7 = 0;
        genreScore7 = 0;
        aa = 0.0;
        aa1 = 0.0;
        aa2 = 0.0;
        aa3 = 0.0;
        //  JOptionPane.showMessageDialog(null, "g " + g);
        for (int i = 0; i < h.size(); i++) {
            double ranking = 0;
            double partido = 0;
            if ((Integer.parseInt(h.get(i).getRanking()) <= 5) && (Integer.parseInt(h.get(i).getRanking()) >= 0)) {
                ranking = ranking + 12;
            }
            if ((Integer.parseInt(h.get(i).getRanking()) > 5) && (Integer.parseInt(h.get(i).getRanking()) <= 10)) {
                ranking = ranking + 10;
            }
            if ((Integer.parseInt(h.get(i).getRanking()) > 10) && (Integer.parseInt(h.get(i).getRanking()) <= 10)) {
                ranking = ranking + 8;
            }
            if ((Integer.parseInt(h.get(i).getRanking()) > 15) && (Integer.parseInt(h.get(i).getRanking()) <= 20)) {
                ranking = ranking + 6;
            }
            if ((Integer.parseInt(h.get(i).getRanking()) > 20) && (Integer.parseInt(h.get(i).getRanking()) <= 25)) {
                ranking = ranking + 4;
            }
            if ((Integer.parseInt(h.get(i).getRanking()) > 25)) {
                ranking = ranking + 2;
            }

            if ((Integer.parseInt(h.get(i).getPartido1()) == 0) || (Integer.parseInt(h.get(i).getPartido2()) == 0) || (Integer.parseInt(h.get(i).getPartido3()) == 0)) {
                partido = partido + 2;
            }
            if ((Integer.parseInt(h.get(i).getPartido1()) == 1) || (Integer.parseInt(h.get(i).getPartido2()) == 1) || (Integer.parseInt(h.get(i).getPartido3()) == 1)) {
                partido = partido + 3;
            }
            if ((Integer.parseInt(h.get(i).getPartido1()) == -1) || (Integer.parseInt(h.get(i).getPartido2()) == -1) || (Integer.parseInt(h.get(i).getPartido3()) == -1)) {
                partido = partido + 1;
            }

            if (i == 0) {
                numCopas = Integer.parseInt(h.get(i).getNumCopas());
                genreScore = ranking + numCopas + partido;
                aa = genreScore;
            }
            if (i == 1) {
                numCopas1 = Integer.parseInt(h.get(i).getNumCopas());
                genreScore1 = ranking + numCopas + partido;
                aa1 = genreScore1;
            }
            if (i == 2) {
                numCopas2 = Integer.parseInt(h.get(i).getNumCopas());
                genreScore2 = ranking + numCopas + partido;
                aa2 = genreScore2;
            }
            if (i == 3) {
                numCopas3 = Integer.parseInt(h.get(i).getNumCopas());
                genreScore3 = ranking + numCopas + partido;
                aa3 = genreScore3;
            }
        }
        aux = 0;
        if (aa < aa1) {
            aux = aa;
            aa = aa1;
            aa1 = aux;
        }
        if (aa < aa2) {
            aux = aa;
            aa = aa2;
            aa2 = aux;
        }
        if (aa < aa3) {
            aux = aa;
            aa = aa3;
            aa3 = aux;
        }
        if (aa1 < aa2) {
            aux = aa1;
            aa1 = aa2;
            aa2 = aux;
        }
        if (aa1 < aa3) {
            aux = aa1;
            aa1 = aa3;
            aa3 = aux;
        }
        if (aa2 < aa3) {
            aux = aa2;
            aa2 = aa3;
            aa3 = aux;
        }
        if (aa == genreScore) {
            totalh.add(h.get(0));
        }
        if (aa == genreScore1) {
            totalh.add(h.get(1));
        }
        if (totalh.size() == 2) {
        } else {
            if (aa == genreScore2) {
                totalh.add(h.get(2));
            }
            if (totalh.size() == 2) {
            } else {
                if (aa == genreScore3) {
                    totalh.add(h.get(3));
                }
                if (totalh.size() == 2) {
                } else {
                    if (aa1 == genreScore) {
                        totalh.add(h.get(0));
                    }
                    if (totalh.size() == 2) {
                    } else {
                        if (aa1 == genreScore1) {
                            totalh.add(h.get(1));
                        }
                        if (totalh.size() == 2) {
                        } else {
                            if (aa1 == genreScore2) {
                                totalh.add(h.get(2));
                            }
                            if (totalh.size() == 2) {
                            } else {
                                if (aa1 == genreScore3) {
                                    totalh.add(h.get(3));
                                }
                            }
                        }
                    }
                }

            }
        }
        totaltotal.addAll(totala);
        totaltotal.addAll(totalb);
        totaltotal.addAll(totalc);
        totaltotal.addAll(totald);
        totaltotal.addAll(totale);
        totaltotal.addAll(totalf);
        totaltotal.addAll(totalg);
        totaltotal.addAll(totalh);
        equi16.clear();
        equi16.addAll(totaltotal);
//        JOptionPane.showMessageDialog(null, "g:  " + equi16.size());
//        JOptionPane.showMessageDialog(null, "g:  " + equi16);
        //  JOptionPane.showMessageDialog(null, "g:  " + totalg);
        // JOptionPane.showMessageDialog(null, "TTT:  " + totaltotal);
        // JOptionPane.showMessageDialog(null, totaltotal.size());
        // JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3);
        return totaltotal;
    }

    public void testSelectFittestEquipos() throws Exception {

        equipos = this.leerEquipos();

        Genotype population = Genotype.randomInitialGenotype(conf);

        IChromosome bestSolutionSoFar = movieChromosome;

        for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
            population.evolve();
            IChromosome candidateBestSolution = population.getFittestChromosome();
            if (candidateBestSolution.getFitnessValue() > bestSolutionSoFar.getFitnessValue()) {
                bestSolutionSoFar = candidateBestSolution;
            }
        }
        printSolution(bestSolutionSoFar, equipos);
    }
    public static double v = 0;

    public void printSolution(IChromosome solution, List equipos) {
        System.out.println("#################################################################################################################");
        System.out.println("Valor del Fitness: " + solution.getFitnessValue());
        MundialFitness.v = solution.getFitnessValue();
        for (int i = 0; i < solution.size(); i++) {
            int index = (Integer) solution.getGene(i).getAllele();
            Equipos equipo = (Equipos) equipos.get(index);
            a.add(equipo);
            System.out.println(equipo.toString());
        }
        System.out.println("#################################################################################################################");
    }
}
