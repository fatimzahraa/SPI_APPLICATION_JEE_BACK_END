/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import jpa.Formation;
import jpa.Promotion;
import jpa.PromotionPK;

/**
 *
 * @author fatima Zahra
 */
@Stateless
@Path("promotions")
public class PromotionFacadeREST extends AbstractFacade<Promotion> {

    @PersistenceContext(unitName = "SPI_APPLICATIONPU")
    private EntityManager em;

    private PromotionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeFormation=codeFormationValue;anneeUniversitaire=anneeUniversitaireValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        jpa.PromotionPK key = new jpa.PromotionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeFormation = map.get("codeFormation");
        if (codeFormation != null && !codeFormation.isEmpty()) {
            key.setCodeFormation(codeFormation.get(0));
        }
        java.util.List<String> anneeUniversitaire = map.get("anneeUniversitaire");
        if (anneeUniversitaire != null && !anneeUniversitaire.isEmpty()) {
            key.setAnneeUniversitaire(anneeUniversitaire.get(0));
        }
        return key;
    }

    public PromotionFacadeREST() {
        super(Promotion.class);
    }

    // Créer une promotion
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Promotion entity) {
        super.create(entity);
    }

    // Modifier une promotion par son id qui est composé
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Promotion entity) {
        super.edit(entity);
    }

    // Supprimer une promotion
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        jpa.PromotionPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    // récupérer une promotion par son Id composé 
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Promotion find(@PathParam("id") PathSegment id) {
        jpa.PromotionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    // récupérer toutes les promotions
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Promotion> findAll() {
        return super.findAll();
    }

    
   // récupérer une promotion par son Lieu de Rentrée 
    @GET
    @Path("/lieuRentree/{lieuRentree}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Promotion> findByNamelieuRentree(@PathParam("lieuRentree") String lieuRentree) {
       //return une fonction qui permet de trouver une promotion par son lieu de rentrée avec JPQL query nommée
      return super.findByName_JPQL_NamedQuerynomlieuRentree(lieuRentree);
    }
     
   // récupérer une promotion par son Sigle
    @GET
    @Path("/sigle/{siglePromotion}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Promotion> findByNamesiglePromotion(@PathParam("siglePromotion") String siglePromotion) {
     //return une fonction qui permet de trouver un promotion par son sigle avec JPQL query nommée  
      return super.findByName_JPQL_NamedQuerynomsiglePromotion(siglePromotion);
    }
    
    
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Promotion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    
    // calculer le nombre de promotions
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
