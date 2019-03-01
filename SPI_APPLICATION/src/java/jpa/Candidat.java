/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatima Zahra
 */
@Entity
@Table(name = "candidat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c")
    , @NamedQuery(name = "Candidat.findByNoCandidat", query = "SELECT c FROM Candidat c WHERE c.noCandidat = :noCandidat")
    , @NamedQuery(name = "Candidat.findByCodeFormation", query = "SELECT c FROM Candidat c WHERE c.codeFormation = :codeFormation")
    , @NamedQuery(name = "Candidat.findByAnneeUniversitaire", query = "SELECT c FROM Candidat c WHERE c.anneeUniversitaire = :anneeUniversitaire")
    , @NamedQuery(name = "Candidat.findByNom", query = "SELECT c FROM Candidat c WHERE c.nom = :nom")
    , @NamedQuery(name = "Candidat.findByPrenom", query = "SELECT c FROM Candidat c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Candidat.findBySexe", query = "SELECT c FROM Candidat c WHERE c.sexe = :sexe")
    , @NamedQuery(name = "Candidat.findByDateNaissance", query = "SELECT c FROM Candidat c WHERE c.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Candidat.findByLieuNaissance", query = "SELECT c FROM Candidat c WHERE c.lieuNaissance = :lieuNaissance")
    , @NamedQuery(name = "Candidat.findByNationalite", query = "SELECT c FROM Candidat c WHERE c.nationalite = :nationalite")
    , @NamedQuery(name = "Candidat.findByTelephone", query = "SELECT c FROM Candidat c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Candidat.findByMobile", query = "SELECT c FROM Candidat c WHERE c.mobile = :mobile")
    , @NamedQuery(name = "Candidat.findByEmail", query = "SELECT c FROM Candidat c WHERE c.email = :email")
    , @NamedQuery(name = "Candidat.findByAdresse", query = "SELECT c FROM Candidat c WHERE c.adresse = :adresse")
    , @NamedQuery(name = "Candidat.findByCodePostal", query = "SELECT c FROM Candidat c WHERE c.codePostal = :codePostal")
    , @NamedQuery(name = "Candidat.findByVille", query = "SELECT c FROM Candidat c WHERE c.ville = :ville")
    , @NamedQuery(name = "Candidat.findByPaysOrigine", query = "SELECT c FROM Candidat c WHERE c.paysOrigine = :paysOrigine")
    , @NamedQuery(name = "Candidat.findByUniversiteOrigine", query = "SELECT c FROM Candidat c WHERE c.universiteOrigine = :universiteOrigine")
    , @NamedQuery(name = "Candidat.findByListeSelection", query = "SELECT c FROM Candidat c WHERE c.listeSelection = :listeSelection")
    , @NamedQuery(name = "Candidat.findBySelectionNoOrdre", query = "SELECT c FROM Candidat c WHERE c.selectionNoOrdre = :selectionNoOrdre")
    , @NamedQuery(name = "Candidat.findByConfirmationCandidat", query = "SELECT c FROM Candidat c WHERE c.confirmationCandidat = :confirmationCandidat")
    , @NamedQuery(name = "Candidat.findByDateReponseCandidat", query = "SELECT c FROM Candidat c WHERE c.dateReponseCandidat = :dateReponseCandidat")})
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NO_CANDIDAT")
    private String noCandidat;
    @Size(max = 8)
    @Column(name = "CODE_FORMATION")
    private String codeFormation;
    @Size(max = 10)
    @Column(name = "ANNEE_UNIVERSITAIRE")
    private String anneeUniversitaire;
    @Size(max = 50)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 1)
    @Column(name = "SEXE")
    private String sexe;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Size(max = 255)
    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;
    @Size(max = 50)
    @Column(name = "NATIONALITE")
    private String nationalite;
    @Size(max = 20)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
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
    @Column(name = "PAYS_ORIGINE")
    private String paysOrigine;
    @Size(max = 6)
    @Column(name = "UNIVERSITE_ORIGINE")
    private String universiteOrigine;
    @Size(max = 6)
    @Column(name = "LISTE_SELECTION")
    private String listeSelection;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SELECTION_NO_ORDRE")
    private Double selectionNoOrdre;
    @Column(name = "CONFIRMATION_CANDIDAT")
    private Character confirmationCandidat;
    @Column(name = "DATE_REPONSE_CANDIDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponseCandidat;

    public Candidat() {
    }

    
    
    public Candidat(String noCandidat, String codeFormation, String anneeUniversitaire, String nom, String prenom, String sexe, Date dateNaissance, String lieuNaissance, String nationalite, String telephone, String mobile, String email, String adresse, String codePostal, String ville, String paysOrigine, String universiteOrigine, String listeSelection, Double selectionNoOrdre, Character confirmationCandidat, Date dateReponseCandidat) {
        this.noCandidat = noCandidat;
        this.codeFormation = codeFormation;
        this.anneeUniversitaire = anneeUniversitaire;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.telephone = telephone;
        this.mobile = mobile;
        this.email = email;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.paysOrigine = paysOrigine;
        this.universiteOrigine = universiteOrigine;
        this.listeSelection = listeSelection;
        this.selectionNoOrdre = selectionNoOrdre;
        this.confirmationCandidat = confirmationCandidat;
        this.dateReponseCandidat = dateReponseCandidat;
    }
    
    

    public Candidat(String noCandidat) {
        this.noCandidat = noCandidat;
    }

    public String getNoCandidat() {
        return noCandidat;
    }

    public void setNoCandidat(String noCandidat) {
        this.noCandidat = noCandidat;
    }

    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public String getUniversiteOrigine() {
        return universiteOrigine;
    }

    public void setUniversiteOrigine(String universiteOrigine) {
        this.universiteOrigine = universiteOrigine;
    }

    public String getListeSelection() {
        return listeSelection;
    }

    public void setListeSelection(String listeSelection) {
        this.listeSelection = listeSelection;
    }

    public Double getSelectionNoOrdre() {
        return selectionNoOrdre;
    }

    public void setSelectionNoOrdre(Double selectionNoOrdre) {
        this.selectionNoOrdre = selectionNoOrdre;
    }

    public Character getConfirmationCandidat() {
        return confirmationCandidat;
    }

    public void setConfirmationCandidat(Character confirmationCandidat) {
        this.confirmationCandidat = confirmationCandidat;
    }

    public Date getDateReponseCandidat() {
        return dateReponseCandidat;
    }

    public void setDateReponseCandidat(Date dateReponseCandidat) {
        this.dateReponseCandidat = dateReponseCandidat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noCandidat != null ? noCandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.noCandidat == null && other.noCandidat != null) || (this.noCandidat != null && !this.noCandidat.equals(other.noCandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Candidat[ noCandidat=" + noCandidat + " ]";
    }
    
}
