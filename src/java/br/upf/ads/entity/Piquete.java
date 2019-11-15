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
@Table(name = "piquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piquete.findAll", query = "SELECT p FROM Piquete p")
    , @NamedQuery(name = "Piquete.findByPiqCodigo", query = "SELECT p FROM Piquete p WHERE p.piqCodigo = :piqCodigo")
    , @NamedQuery(name = "Piquete.findByPiqNome", query = "SELECT p FROM Piquete p WHERE p.piqNome = :piqNome")
    , @NamedQuery(name = "Piquete.findByPiqDescricao", query = "SELECT p FROM Piquete p WHERE p.piqDescricao = :piqDescricao")})
public class Piquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "piq_codigo")
    private Integer piqCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "piq_nome")
    private String piqNome;
    @Size(max = 200)
    @Column(name = "piq_descricao")
    private String piqDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesPiquete")
    private Collection<Pessoa> pessoaCollection;

    public Piquete() {
    }

    public Piquete(Integer piqCodigo) {
        this.piqCodigo = piqCodigo;
    }

    public Piquete(Integer piqCodigo, String piqNome) {
        this.piqCodigo = piqCodigo;
        this.piqNome = piqNome;
    }

    public Integer getPiqCodigo() {
        return piqCodigo;
    }

    public void setPiqCodigo(Integer piqCodigo) {
        this.piqCodigo = piqCodigo;
    }

    public String getPiqNome() {
        return piqNome;
    }

    public void setPiqNome(String piqNome) {
        this.piqNome = piqNome;
    }

    public String getPiqDescricao() {
        return piqDescricao;
    }

    public void setPiqDescricao(String piqDescricao) {
        this.piqDescricao = piqDescricao;
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
        hash += (piqCodigo != null ? piqCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piquete)) {
            return false;
        }
        Piquete other = (Piquete) object;
        if ((this.piqCodigo == null && other.piqCodigo != null) || (this.piqCodigo != null && !this.piqCodigo.equals(other.piqCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return piqNome;
    }
    
}
