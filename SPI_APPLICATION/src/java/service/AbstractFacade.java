/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Fatima Zahra
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

   
    
    //une fonction qui permet de trouver le candidat par son nom avec JPQL query nommée
       public List<T>findByName_JPQL_NamedQuerynom(Object nom){
        Query q=getEntityManager().createNamedQuery("Candidat.findByNom",entityClass);
        q.setParameter("nom",nom);
        return q.getResultList();}
    
     // une fonction qui permet de trouver le candidat par son université avec JPQL query nommée
       public List<T>findByName_JPQL_NamedQueryUniversity(Object universiteOrigine){
        Query q=getEntityManager().createNamedQuery("Candidat.findByUniversiteOrigine",entityClass);
        q.setParameter("universiteOrigine",universiteOrigine);
        return q.getResultList();} 
       
       
       
       // une fonction qui permet de trouver l'enseignant par son nom avec JPQL query nommée 
       public List<T>findByName_JPQL_NamedQuery_nomenseignant(Object nom){
        Query q=getEntityManager().createNamedQuery("Enseignant.findByNom",entityClass);
        q.setParameter("nom",nom);
        return q.getResultList();}
    
      //une fonction qui permet de trouver l'enseignant par son email UBO avec JPQL query nommée
       public List<T>findByName_JPQL_NamedQuery_emailUbo(Object emailUbo){
        Query q=getEntityManager().createNamedQuery("Enseignant.findByEmailUbo",entityClass);
        q.setParameter("emailUbo",emailUbo);
        return q.getResultList();} 
    
        // une fonction qui permet de trouver la formation par son nom avec JPQL query nommée
       public List<T>findByName_JPQL_NamedQuerynomFormation(Object nomFormation){
       Query q=getEntityManager().createNamedQuery("Formation.findByNomFormation",entityClass);
       q.setParameter("nomFormation",nomFormation);
       return q.getResultList();}  
    
      //une fonction qui permet de trouver une promotion par son lieu de rentrée avec JPQL query nommée 
       public List<T>findByName_JPQL_NamedQuerynomlieuRentree(Object lieuRentree){
        Query q=getEntityManager().createNamedQuery("Promotion.findByLieuRentree",entityClass);
        q.setParameter("lieuRentree",lieuRentree);
        return q.getResultList();} 
    
       // une fonction qui permet de trouver un promotion par son sigle avec JPQL query nommée 
       public List<T>findByName_JPQL_NamedQuerynomsiglePromotion(Object siglePromotion){
       Query q=getEntityManager().createNamedQuery("Promotion.findBySiglePromotion",entityClass);
       q.setParameter("siglePromotion",siglePromotion);
       return q.getResultList();} 
       
       public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    
}
