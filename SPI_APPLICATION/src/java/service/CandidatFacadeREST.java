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
import jpa.Candidat;

/**
 *
 * @author Fatima Zahra
 */
@Stateless
@Path("candidats")
public class CandidatFacadeREST extends AbstractFacade<Candidat> {

    @PersistenceContext(unitName = "SPI_APPLICATIONPU")
    private EntityManager em;

    public CandidatFacadeREST() {
        super(Candidat.class);
    }

    
    // Créer Candidat 
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Candidat entity) {
        super.create(entity);
    }
    
  
    // Modifier Candidat avec id = NoCandidat
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Candidat entity) {
        super.edit(entity);
    }
    
  
    // Supprimer Candidat
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    
    // recuperer Le Candidat avec son Id qui est le NoCandidat
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Candidat find(@PathParam("id") String id) {
        return super.find(id);
    }

    // recuperer Candidat Par son Nom
    @GET
    @Path("/nom/{nom}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Candidat> findByName(@PathParam("nom") String nom) {
      //return une fonction qui permet de trouver le candidat par son nom avec JPQL query nommée
      return super.findByName_JPQL_NamedQuerynom(nom);
    }
    
    // recuperer Candidat Par Université origine 
    @GET
    @Path("/universite/{universiteOrigine}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Candidat> findByNameUniversite(@PathParam("universiteOrigine") String universiteOrigine) {
       //return une fonction qui permet de trouver le candidat par son université avec JPQL query nommée
       return super.findByName_JPQL_NamedQueryUniversity(universiteOrigine);
    }
    
    
    // recuperer Tous Les Candidats
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Candidat> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Candidat> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    // calculer le nombre de candidats
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
