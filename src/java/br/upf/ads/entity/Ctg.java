/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Felipe
 */
@Entity
@Table(name = "ctg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctg.findAll", query = "SELECT c FROM Ctg c")
    , @NamedQuery(name = "Ctg.findByCtgCodigo", query = "SELECT c FROM Ctg c WHERE c.ctgCodigo = :ctgCodigo")
    , @NamedQuery(name = "Ctg.findByCtgNome", query = "SELECT c FROM Ctg c WHERE c.ctgNome = :ctgNome")
    , @NamedQuery(name = "Ctg.findByCtgCnpj", query = "SELECT c FROM Ctg c WHERE c.ctgCnpj = :ctgCnpj")
    , @NamedQuery(name = "Ctg.findByCtgRua", query = "SELECT c FROM Ctg c WHERE c.ctgRua = :ctgRua")
    , @NamedQuery(name = "Ctg.findByCtgNumero", query = "SELECT c FROM Ctg c WHERE c.ctgNumero = :ctgNumero")
    , @NamedQuery(name = "Ctg.findByCtgBairro", query = "SELECT c FROM Ctg c WHERE c.ctgBairro = :ctgBairro")
    , @NamedQuery(name = "Ctg.findByCtgComplemento", query = "SELECT c FROM Ctg c WHERE c.ctgComplemento = :ctgComplemento")
    , @NamedQuery(name = "Ctg.findByCtgTelefone", query = "SELECT c FROM Ctg c WHERE c.ctgTelefone = :ctgTelefone")
    , @NamedQuery(name = "Ctg.findByCtgEmail", query = "SELECT c FROM Ctg c WHERE c.ctgEmail = :ctgEmail")})
public class Ctg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ctg_codigo")
    private Integer ctgCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ctg_nome")
    private String ctgNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ctg_cnpj")
    private String ctgCnpj;
    @Size(max = 20)
    @Column(name = "ctg_rua")
    private String ctgRua;
    @Size(max = 5)
    @Column(name = "ctg_numero")
    private String ctgNumero;
    @Size(max = 20)
    @Column(name = "ctg_bairro")
    private String ctgBairro;
    @Size(max = 50)
    @Column(name = "ctg_complemento")
    private String ctgComplemento;
    @Size(max = 15)
    @Column(name = "ctg_telefone")
    private String ctgTelefone;
    @Size(max = 30)
    @Column(name = "ctg_email")
    private String ctgEmail;
    @JoinColumn(name = "ctg_cidade", referencedColumnName = "cid_codigo")
    @ManyToOne
    private Cidade ctgCidade;
    @OneToMany(mappedBy = "ruaCtg")
    private Collection<Rua> ruaCollection;

    public Ctg() {
    }

    public Ctg(Integer ctgCodigo) {
        this.ctgCodigo = ctgCodigo;
    }

    public Ctg(Integer ctgCodigo, String ctgNome, String ctgCnpj) {
        this.ctgCodigo = ctgCodigo;
        this.ctgNome = ctgNome;
        this.ctgCnpj = ctgCnpj;
    }

    public Integer getCtgCodigo() {
        return ctgCodigo;
    }

    public void setCtgCodigo(Integer ctgCodigo) {
        this.ctgCodigo = ctgCodigo;
    }

    public String getCtgNome() {
        return ctgNome;
    }

    public void setCtgNome(String ctgNome) {
        this.ctgNome = ctgNome;
    }

    public String getCtgCnpj() {
        return ctgCnpj;
    }

    public void setCtgCnpj(String ctgCnpj) {
        this.ctgCnpj = ctgCnpj;
    }

    public String getCtgRua() {
        return ctgRua;
    }

    public void setCtgRua(String ctgRua) {
        this.ctgRua = ctgRua;
    }

    public String getCtgNumero() {
        return ctgNumero;
    }

    public void setCtgNumero(String ctgNumero) {
        this.ctgNumero = ctgNumero;
    }

    public String getCtgBairro() {
        return ctgBairro;
    }

    public void setCtgBairro(String ctgBairro) {
        this.ctgBairro = ctgBairro;
    }

    public String getCtgComplemento() {
        return ctgComplemento;
    }

    public void setCtgComplemento(String ctgComplemento) {
        this.ctgComplemento = ctgComplemento;
    }

    public String getCtgTelefone() {
        return ctgTelefone;
    }

    public void setCtgTelefone(String ctgTelefone) {
        this.ctgTelefone = ctgTelefone;
    }

    public String getCtgEmail() {
        return ctgEmail;
    }

    public void setCtgEmail(String ctgEmail) {
        this.ctgEmail = ctgEmail;
    }

    public Cidade getCtgCidade() {
        return ctgCidade;
    }

    public void setCtgCidade(Cidade ctgCidade) {
        this.ctgCidade = ctgCidade;
    }

    @XmlTransient
    public Collection<Rua> getRuaCollection() {
        return ruaCollection;
    }

    public void setRuaCollection(Collection<Rua> ruaCollection) {
        this.ruaCollection = ruaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctgCodigo != null ? ctgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctg)) {
            return false;
        }
        Ctg other = (Ctg) object;
        if ((this.ctgCodigo == null && other.ctgCodigo != null) || (this.ctgCodigo != null && !this.ctgCodigo.equals(other.ctgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.entity.Ctg[ ctgCodigo=" + ctgCodigo + " ]";
    }
    
}
