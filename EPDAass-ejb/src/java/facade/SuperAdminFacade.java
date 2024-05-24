/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.SuperAdmin;

/**
 *
 * @author vandycklai
 */
@Stateless
public class SuperAdminFacade extends AbstractFacade<SuperAdmin> {

    @PersistenceContext(unitName = "EPDAass-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuperAdminFacade() {
        super(SuperAdmin.class);
    }
    
}
