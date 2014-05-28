/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copiaPeliculas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Freddy
 */
public class mainC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MundialFitness t = new MundialFitness();
            t.initialize();
            t.testSelectFittestEquipos();
        } catch (Exception ex) {
            Logger.getLogger(mainC.class.getName()).log(Level.SEVERE, null, ex);
        }
        FitnessMundial fm = new FitnessMundial(null, null);
        //  fm.finles8();
//        int aa = Integer.parseInt(JOptionPane.showInputDialog("ingrese el priemr numero: "));
//        int aa1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el 2 numero: "));
//        int aa2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el 3 numero: "));
//        int aa3 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el 4 numero: "));
//        int aux = 0;
//        if (aa < aa1) {
//            aux = aa;
//            aa = aa1;
//            aa1 = aux;
//        }
//        if (aa < aa2) {
//            aux = aa;
//            aa = aa2;
//            aa2 = aux;
//        }
//        if (aa < aa3) {
//            aux = aa;
//            aa = aa3;
//            aa3 = aux;
//        }
//        if (aa1 < aa2) {
//            aux = aa1;
//            aa1 = aa2;
//            aa2 = aux;
//        }
//        if (aa1 < aa3) {
//            aux = aa1;
//            aa1 = aa3;
//            aa3 = aux;
//        }
//        if (aa2 < aa3) {
//            aux = aa2;
//            aa2 = aa3;
//            aa3 = aux;
//        }
//        
//        JOptionPane.showMessageDialog(null, aa + "  " + aa1 + "  " + aa2 + "  " + aa3 + "   ");

    }
}