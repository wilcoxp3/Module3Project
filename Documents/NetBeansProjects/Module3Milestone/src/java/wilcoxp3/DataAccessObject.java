/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import java.util.List;

/**
 *
 * @author Paul
 * @param <E>
 */
public interface DataAccessObject<E> {

    public List<E> readAll();

    public E read(Object id);

    public void create(E entity);

    public void update(E entity);
    
    public void delete(Object id);
}
