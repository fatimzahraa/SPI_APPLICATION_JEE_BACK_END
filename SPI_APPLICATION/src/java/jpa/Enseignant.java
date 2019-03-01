/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fatima Zahra
 */
@Entity
@Table(name = "enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e")
    , @NamedQuery(name = "Enseignant.findByNoEnseignant", query = "SELECT e FROM Enseignant e WHERE e.noEnseignant = :noEnseignant")
    , @NamedQuery(name = "Enseignant.findByType", query = "SELECT e FROM Enseignant e WHERE e.type = :type")
    , @NamedQuery(name = "Enseignant.findBySexe", query = "SELECT e FROM Enseignant e WHERE e.sexe = :sexe")
    , @NamedQuery(name = "Enseignant.findByNom", query = "SELECT e FROM Enseignant e WHERE e.nom = :nom")
    , @NamedQuery(name = "Enseignant.findByPrenom", query = "SELECT e FROM Enseignant e WHERE e.prenom = :prenom")
    , @NamedQuery(name = "Enseignant.findByAdresse", query = "SELECT e FROM Enseignant e WHERE e.adresse = :adresse")
    , @NamedQuery(name = "Enseignant.findByCodePostal", query = "SELECT e FROM Enseignant e WHERE e.codePostal = :codePostal")
    , @NamedQuery(name = "Enseignant.findByVille", query = "SELECT e FROM Enseignant e WHERE e.ville = :ville")
    , @NamedQuery(name = "Enseignant.findByPays", query = "SELECT e FROM Enseignant e WHERE e.pays = :pays")
    , @NamedQuery(name = "Enseignant.findByMobile", query = "SELECT e FROM Enseignant e WHERE e.mobile = :mobile")
    , @NamedQuery(name = "Enseignant.findByTelephone", query = "SELECT e FROM Enseignant e WHERE e.telephone = :telephone")
    , @NamedQuery(name = "Enseignant.findByEmailUbo", query = "SELECT e FROM Enseignant e WHERE e.emailUbo = :emailUbo")
    , @NamedQuery(name = "Enseignant.findByEmailPerso", query = "SELECT e FROM Enseignant e WHERE e.emailPerso = :emailPerso")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_ENSEIGNANT")
    private Integer noEnseignant;
    @Size(max = 5)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 1)
    @Column(name = "SEXE")
    private String sexe;
    @Size(max = 50)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 255)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 10)
    @Column(name = "CODE_POSTAL")
    private String codePostal;
    @Size(max = 255)
    @Column(name = "VILLE")
    private String ville;
    @Size(max = 5)
    @Column(name = "PAYS")
    private String pays;
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    @Size(max = 20)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 255)
    @Column(name = "EMAIL_UBO")
    private String emailUbo;
    @Size(max = 255)
    @Column(name = "EMAIL_PERSO")
    private String emailPerso;
    @OneToMany(mappedBy = "noEnseignant")
    private Collection<Promotion> promotionCollection;

    public Enseignant() {
    }

    public Enseignant(Integer noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public Integer getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Integer noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailUbo() {
        return emailUbo;
    }

    public void setEmailUbo(String emailUbo) {
        this.emailUbo = emailUbo;
    }

    public String getEmailPerso() {
        return emailPerso;
    }

    public void setEmailPerso(String emailPerso) {
        this.emailPerso = emailPerso;
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
        hash += (noEnseignant != null ? noEnseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.noEnseignant == null && other.noEnseignant != null) || (this.noEnseignant != null && !this.noEnseignant.equals(other.noEnseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Enseignant[ noEnseignant=" + noEnseignant + " ]";
    }
    
}
