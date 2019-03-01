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
import jpa.Formation;

/**
 *
 * @author Fatima Zahra
 */
@Stateless
@Path("formations")
public class FormationFacadeREST extends AbstractFacade<Formation> {

    @PersistenceContext(unitName = "SPI_APPLICATIONPU")
    private EntityManager em;

    public FormationFacadeREST() {
        super(Formation.class);
    }

    // Créer Formation
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Formation entity) {
        super.create(entity);
    }

    // Mise à jours d'une formation 
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Formation entity) {
        super.edit(entity);
    }

    // Supprimer une formation 
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    //récupérer une formation par son Id qui est Code Formation
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Formation find(@PathParam("id") String id) {
        return super.find(id);
    }

    //récupérer une formation par son nom
    @GET
    @Path("/nom/{nomFormation}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Formation> findByNameFormation(@PathParam("nomFormation") String nomFormation) {
       //return une fonction qui permet de trouver la formation par son nom avec JPQL query nommée
      return super.findByName_JPQL_NamedQuerynomFormation(nomFormation);
    }
      
    
    //récupérer toutes les formations
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Formation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Formation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
  
    // Calcule le nombre de formations
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
