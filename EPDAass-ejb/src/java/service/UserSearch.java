/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vandycklai
 */
@Stateless
public class UserSearch {
    @PersistenceContext(unitName = "EPDAass-ejbPU")
    private EntityManager em;
    
    
}
