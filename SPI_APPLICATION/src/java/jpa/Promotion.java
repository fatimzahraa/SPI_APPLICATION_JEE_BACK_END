/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatima Zahra
 */
@Entity
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
    , @NamedQuery(name = "Promotion.findByCodeFormation", query = "SELECT p FROM Promotion p WHERE p.promotionPK.codeFormation = :codeFormation")
    , @NamedQuery(name = "Promotion.findByAnneeUniversitaire", query = "SELECT p FROM Promotion p WHERE p.promotionPK.anneeUniversitaire = :anneeUniversitaire")
    , @NamedQuery(name = "Promotion.findBySiglePromotion", query = "SELECT p FROM Promotion p WHERE p.siglePromotion = :siglePromotion")
    , @NamedQuery(name = "Promotion.findByNbMaxEtudiant", query = "SELECT p FROM Promotion p WHERE p.nbMaxEtudiant = :nbMaxEtudiant")
    , @NamedQuery(name = "Promotion.findByDateReponseLp", query = "SELECT p FROM Promotion p WHERE p.dateReponseLp = :dateReponseLp")
    , @NamedQuery(name = "Promotion.findByDateReponseLalp", query = "SELECT p FROM Promotion p WHERE p.dateReponseLalp = :dateReponseLalp")
    , @NamedQuery(name = "Promotion.findByDateRentree", query = "SELECT p FROM Promotion p WHERE p.dateRentree = :dateRentree")
    , @NamedQuery(name = "Promotion.findByLieuRentree", query = "SELECT p FROM Promotion p WHERE p.lieuRentree = :lieuRentree")
    , @NamedQuery(name = "Promotion.findByProcessusStage", query = "SELECT p FROM Promotion p WHERE p.processusStage = :processusStage")
    , @NamedQuery(name = "Promotion.findByCommentaire", query = "SELECT p FROM Promotion p WHERE p.commentaire = :commentaire")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PromotionPK promotionPK;
    @Size(max = 16)
    @Column(name = "SIGLE_PROMOTION")
    private String siglePromotion;
    @Column(name = "NB_MAX_ETUDIANT")
    private Short nbMaxEtudiant;
    @Column(name = "DATE_REPONSE_LP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponseLp;
    @Column(name = "DATE_REPONSE_LALP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponseLalp;
    @Column(name = "DATE_RENTREE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRentree;
    @Size(max = 12)
    @Column(name = "LIEU_RENTREE")
    private String lieuRentree;
    @Size(max = 5)
    @Column(name = "PROCESSUS_STAGE")
    private String processusStage;
    @Size(max = 255)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    @ManyToOne
    private Enseignant noEnseignant;
    @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Formation formation;

    public Promotion() {
    }

    public Promotion(PromotionPK promotionPK) {
        this.promotionPK = promotionPK;
    }

    public Promotion(String codeFormation, String anneeUniversitaire) {
        this.promotionPK = new PromotionPK(codeFormation, anneeUniversitaire);
    }

    public PromotionPK getPromotionPK() {
        return promotionPK;
    }

    public void setPromotionPK(PromotionPK promotionPK) {
        this.promotionPK = promotionPK;
    }

    public String getSiglePromotion() {
        return siglePromotion;
    }

    public void setSiglePromotion(String siglePromotion) {
        this.siglePromotion = siglePromotion;
    }

    public Short getNbMaxEtudiant() {
        return nbMaxEtudiant;
    }

    public void setNbMaxEtudiant(Short nbMaxEtudiant) {
        this.nbMaxEtudiant = nbMaxEtudiant;
    }

    public Date getDateReponseLp() {
        return dateReponseLp;
    }

    public void setDateReponseLp(Date dateReponseLp) {
        this.dateReponseLp = dateReponseLp;
    }

    public Date getDateReponseLalp() {
        return dateReponseLalp;
    }

    public void setDateReponseLalp(Date dateReponseLalp) {
        this.dateReponseLalp = dateReponseLalp;
    }

    public Date getDateRentree() {
        return dateRentree;
    }

    public void setDateRentree(Date dateRentree) {
        this.dateRentree = dateRentree;
    }

    public String getLieuRentree() {
        return lieuRentree;
    }

    public void setLieuRentree(String lieuRentree) {
        this.lieuRentree = lieuRentree;
    }

    public String getProcessusStage() {
        return processusStage;
    }

    public void setProcessusStage(String processusStage) {
        this.processusStage = processusStage;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Enseignant getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Enseignant noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotionPK != null ? promotionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.promotionPK == null && other.promotionPK != null) || (this.promotionPK != null && !this.promotionPK.equals(other.promotionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Promotion[ promotionPK=" + promotionPK + " ]";
    }
    
}
