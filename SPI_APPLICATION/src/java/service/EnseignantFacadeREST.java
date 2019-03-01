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
import jpa.Enseignant;

/**
 *
 * @author Fatima Zahra
 */
@Stateless
@Path("enseignants")
public class EnseignantFacadeREST extends AbstractFacade<Enseignant> {

    @PersistenceContext(unitName = "SPI_APPLICATIONPU")
    private EntityManager em;

    public EnseignantFacadeREST() {
        super(Enseignant.class);
    }

    // créer Enseignant
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Enseignant entity) {
        super.create(entity);
    }

    // Modifier les informations d'un enseignant 
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Enseignant entity) {
        super.edit(entity);
    }

    // Supprimer un enseignant avec son Id qui est noEnseignanat
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    // récupérer l'enseignant par son Id 
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Enseignant find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    
    // récupérer Enseignant par son nom
     @GET
    @Path("/nom/{nom}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Enseignant> findByNameEnseignant(@PathParam("nom") String nom) {
       //return une fonction qui permet de trouver l'enseignant par son nom avec JPQL query nommée
      return super.findByName_JPQL_NamedQuery_nomenseignant(nom);
    }
    
     // récupérer Enseignant par son email de UBO
    @GET
    @Path("/emailUbo/{emailUbo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Enseignant> findByNameEmailUbo(@PathParam("emailUbo") String emailUbo) {
        //return une fonction qui permet de trouver l'enseignant par son email UBO avec JPQL query nommée
       return super.findByName_JPQL_NamedQuery_emailUbo(emailUbo);
    }

     // récupérer Tous les Enseignants
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Enseignant> findAll() {
        return super.findAll();
    }

    
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Enseignant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    // Calcule le nombre d'enseignants
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
