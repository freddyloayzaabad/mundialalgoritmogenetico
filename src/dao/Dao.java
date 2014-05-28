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

public interface Dao<K, E> {

    public void persistir(E entidad);

    public void eliminar(E entidad);

    public E encontrarPorId(K id);

    public List<E> encontrarTodos();
}