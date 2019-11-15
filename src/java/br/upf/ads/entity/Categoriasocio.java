/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "categoriasocio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriasocio.findAll", query = "SELECT c FROM Categoriasocio c")
    , @NamedQuery(name = "Categoriasocio.findByCatsocCodigo", query = "SELECT c FROM Categoriasocio c WHERE c.catsocCodigo = :catsocCodigo")
    , @NamedQuery(name = "Categoriasocio.findByCatsocNome", query = "SELECT c FROM Categoriasocio c WHERE c.catsocNome = :catsocNome")
    , @NamedQuery(name = "Categoriasocio.findByCatsocDescricao", query = "SELECT c FROM Categoriasocio c WHERE c.catsocDescricao = :catsocDescricao")})
public class Categoriasocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catsoc_codigo")
    private Integer catsocCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "catsoc_nome")
    private String catsocNome;
    @Size(max = 200)
    @Column(name = "catsoc_descricao")
    private String catsocDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesCategoria")
    private Collection<Pessoa> pessoaCollection;

    public Categoriasocio() {
    }

    public Categoriasocio(Integer catsocCodigo) {
        this.catsocCodigo = catsocCodigo;
    }

    public Categoriasocio(Integer catsocCodigo, String catsocNome) {
        this.catsocCodigo = catsocCodigo;
        this.catsocNome = catsocNome;
    }

    public Integer getCatsocCodigo() {
        return catsocCodigo;
    }

    public void setCatsocCodigo(Integer catsocCodigo) {
        this.catsocCodigo = catsocCodigo;
    }

    public String getCatsocNome() {
        return catsocNome;
    }

    public void setCatsocNome(String catsocNome) {
        this.catsocNome = catsocNome;
    }

    public String getCatsocDescricao() {
        return catsocDescricao;
    }

    public void setCatsocDescricao(String catsocDescricao) {
        this.catsocDescricao = catsocDescricao;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catsocCodigo != null ? catsocCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriasocio)) {
            return false;
        }
        Categoriasocio other = (Categoriasocio) object;
        if ((this.catsocCodigo == null && other.catsocCodigo != null) || (this.catsocCodigo != null && !this.catsocCodigo.equals(other.catsocCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return catsocNome;
    }
    
}
