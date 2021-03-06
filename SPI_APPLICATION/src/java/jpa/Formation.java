/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fatima Zahra
 */
@Entity
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f")
    , @NamedQuery(name = "Formation.findByCodeFormation", query = "SELECT f FROM Formation f WHERE f.codeFormation = :codeFormation")
    , @NamedQuery(name = "Formation.findByDiplome", query = "SELECT f FROM Formation f WHERE f.diplome = :diplome")
    , @NamedQuery(name = "Formation.findByN0Annee", query = "SELECT f FROM Formation f WHERE f.n0Annee = :n0Annee")
    , @NamedQuery(name = "Formation.findByNomFormation", query = "SELECT f FROM Formation f WHERE f.nomFormation = :nomFormation")
    , @NamedQuery(name = "Formation.findByDoubleDiplome", query = "SELECT f FROM Formation f WHERE f.doubleDiplome = :doubleDiplome")
    , @NamedQuery(name = "Formation.findByDebutAccreditation", query = "SELECT f FROM Formation f WHERE f.debutAccreditation = :debutAccreditation")
    , @NamedQuery(name = "Formation.findByFinAccreditation", query = "SELECT f FROM Formation f WHERE f.finAccreditation = :finAccreditation")})
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODE_FORMATION")
    private String codeFormation;
    @Size(max = 3)
    @Column(name = "DIPLOME")
    private String diplome;
    @Column(name = "N0_ANNEE")
    private Short n0Annee;
    @Size(max = 64)
    @Column(name = "NOM_FORMATION")
    private String nomFormation;
    @Column(name = "DOUBLE_DIPLOME")
    private Character doubleDiplome;
    @Column(name = "DEBUT_ACCREDITATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debutAccreditation;
    @Column(name = "FIN_ACCREDITATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finAccreditation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formation")
    private Collection<Promotion> promotionCollection;

    public Formation() {
    }

    public Formation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Short getN0Annee() {
        return n0Annee;
    }

    public void setN0Annee(Short n0Annee) {
        this.n0Annee = n0Annee;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public Character getDoubleDiplome() {
        return doubleDiplome;
    }

    public void setDoubleDiplome(Character doubleDiplome) {
        this.doubleDiplome = doubleDiplome;
    }

    public Date getDebutAccreditation() {
        return debutAccreditation;
    }

    public void setDebutAccreditation(Date debutAccreditation) {
        this.debutAccreditation = debutAccreditation;
    }

    public Date getFinAccreditation() {
        return finAccreditation;
    }

    public void setFinAccreditation(Date finAccreditation) {
        this.finAccreditation = finAccreditation;
    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeFormation != null ? codeFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.codeFormation == null && other.codeFormation != null) || (this.codeFormation != null && !this.codeFormation.equals(other.codeFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Formation[ codeFormation=" + codeFormation + " ]";
    }
    
}
