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
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findByCidCodigo", query = "SELECT c FROM Cidade c WHERE c.cidCodigo = :cidCodigo")
    , @NamedQuery(name = "Cidade.findByCidNome", query = "SELECT c FROM Cidade c WHERE c.cidNome = :cidNome")
    , @NamedQuery(name = "Cidade.findByCidSiglaestado", query = "SELECT c FROM Cidade c WHERE c.cidSiglaestado = :cidSiglaestado")
    , @NamedQuery(name = "Cidade.findByCidCep", query = "SELECT c FROM Cidade c WHERE c.cidCep = :cidCep")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid_codigo")
    private Integer cidCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cid_nome")
    private String cidNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cid_siglaestado")
    private String cidSiglaestado;
    @Size(max = 9)
    @Column(name = "cid_cep")
    private String cidCep;
    @OneToMany(mappedBy = "pesCidade")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(mappedBy = "depCidade")
    private Collection<Dependente> dependenteCollection;
    @OneToMany(mappedBy = "ctgCidade")
    private Collection<Ctg> ctgCollection;

    public Cidade() {
    }

    public Cidade(Integer cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public Cidade(Integer cidCodigo, String cidNome, String cidSiglaestado) {
        this.cidCodigo = cidCodigo;
        this.cidNome = cidNome;
        this.cidSiglaestado = cidSiglaestado;
    }

    public Integer getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Integer cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    public String getCidSiglaestado() {
        return cidSiglaestado;
    }

    public void setCidSiglaestado(String cidSiglaestado) {
        this.cidSiglaestado = cidSiglaestado;
    }

    public String getCidCep() {
        return cidCep;
    }

    public void setCidCep(String cidCep) {
        this.cidCep = cidCep;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @XmlTransient
    public Collection<Dependente> getDependenteCollection() {
        return dependenteCollection;
    }

    public void setDependenteCollection(Collection<Dependente> dependenteCollection) {
        this.dependenteCollection = dependenteCollection;
    }

    @XmlTransient
    public Collection<Ctg> getCtgCollection() {
        return ctgCollection;
    }

    public void setCtgCollection(Collection<Ctg> ctgCollection) {
        this.ctgCollection = ctgCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidCodigo != null ? cidCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidCodigo == null && other.cidCodigo != null) || (this.cidCodigo != null && !this.cidCodigo.equals(other.cidCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cidNome;
    }
    
}
