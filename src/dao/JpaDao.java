/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author freddy
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDao<K, E> implements Dao<K, E> {

    private EntityManager em;
    private EntityManagerFactory emf;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public JpaDao() {
        emf = Persistence.createEntityManagerFactory("ExamenMundialGeneticoPU");
        em = emf.createEntityManager();
    }

    public void persistir(E entidad) {
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    public void eliminar(E entidad) {
        em.getTransaction().begin();
        em.remove(entidad);
        em.getTransaction().commit();
    }

    public E encontrarPorId(K id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<E> encontrarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");

    }
}