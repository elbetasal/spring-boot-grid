/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.betances.grid;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pleymo
 */
@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
           
    
}
