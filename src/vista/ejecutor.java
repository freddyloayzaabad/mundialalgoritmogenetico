/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Freddy
 */
public class ejecutor {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new com.birosoft.liquid.LiquidLookAndFeel());
            principal bnl = new principal();
            bnl.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ejecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
