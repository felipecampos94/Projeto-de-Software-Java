/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.facade;

import br.upf.ads.entity.Categoriadependente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class CategoriadependenteFacade extends AbstractFacade<Categoriadependente> {

    @PersistenceContext(unitName = "ProjetoCTGPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriadependenteFacade() {
        super(Categoriadependente.class);
    }
    
}
