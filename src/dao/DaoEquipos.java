/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import copiaPeliculas.Equipos;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;


/**
 *
 * @author freddy
 */
public class DaoEquipos extends JpaDao<String, Equipos> {

    @Override
    public Equipos encontrarPorId(String id) {
        Equipos u = null;
        u = getEm().find(Equipos.class, id);
        return u;
    }

    public List<Equipos> nombre(String nombre) {
        List<Equipos> r = null;
        Query consulta = getEm().createQuery("SELECT c FROM Equipos c WHERE c.nombre= '" + nombre + "'");
        r = consulta.getResultList();

        return r;
    }

//    public List<Usuario> idd(String id) {
//        List< Usuario> r = null;
//        Query consulta = getEm().createQuery("SELECT c FROM Usuario c WHERE c.id= '" + id + "'");
//        r = consulta.getResultList();
//        return r;
//    }

//    public List<Usuario> usuario(String usuario) {
//        List< Usuario> r = null;
//        Query consulta = getEm().createQuery("SELECT c FROM Usuario c WHERE c.usuario= '" + usuario + "'");
//        r = consulta.getResultList();
//        return r;
//    }

    @Override
    public List<Equipos> encontrarTodos() {
        List<Equipos> ra = null;
        Query consulta = getEm().createQuery("SELECT ca FROM Equipos ca");
        ra = consulta.getResultList();
        return ra;
    }
//     public static void main(String[] args) {
//        DaoEquipos g = new DaoEquipos();
//        JOptionPane.showMessageDialog(null, g.idd("d34g"));
//    }
}
