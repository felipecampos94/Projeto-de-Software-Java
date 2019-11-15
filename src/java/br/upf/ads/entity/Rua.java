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
@Table(name = "rua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rua.findAll", query = "SELECT r FROM Rua r")
    , @NamedQuery(name = "Rua.findByRuaCodigo", query = "SELECT r FROM Rua r WHERE r.ruaCodigo = :ruaCodigo")
    , @NamedQuery(name = "Rua.findByRuaNome", query = "SELECT r FROM Rua r WHERE r.ruaNome = :ruaNome")
    , @NamedQuery(name = "Rua.findByRuaDescricao", query = "SELECT r FROM Rua r WHERE r.ruaDescricao = :ruaDescricao")})
public class Rua implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rua_codigo")
    private Integer ruaCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "rua_nome")
    private String ruaNome;
    @Size(max = 200)
    @Column(name = "rua_descricao")
    private String ruaDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteRua")
    private Collection<Lote> loteCollection;
    @JoinColumn(name = "rua_ctg", referencedColumnName = "ctg_codigo")
    @ManyToOne
    private Ctg ruaCtg;

    public Rua() {
    }

    public Rua(Integer ruaCodigo) {
        this.ruaCodigo = ruaCodigo;
    }

    public Rua(Integer ruaCodigo, String ruaNome) {
        this.ruaCodigo = ruaCodigo;
        this.ruaNome = ruaNome;
    }

    public Integer getRuaCodigo() {
        return ruaCodigo;
    }

    public void setRuaCodigo(Integer ruaCodigo) {
        this.ruaCodigo = ruaCodigo;
    }

    public String getRuaNome() {
        return ruaNome;
    }

    public void setRuaNome(String ruaNome) {
        this.ruaNome = ruaNome;
    }

    public String getRuaDescricao() {
        return ruaDescricao;
    }

    public void setRuaDescricao(String ruaDescricao) {
        this.ruaDescricao = ruaDescricao;
    }

    @XmlTransient
    public Collection<Lote> getLoteCollection() {
        return loteCollection;
    }

    public void setLoteCollection(Collection<Lote> loteCollection) {
        this.loteCollection = loteCollection;
    }

    public Ctg getRuaCtg() {
        return ruaCtg;
    }

    public void setRuaCtg(Ctg ruaCtg) {
        this.ruaCtg = ruaCtg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruaCodigo != null ? ruaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rua)) {
            return false;
        }
        Rua other = (Rua) object;
        if ((this.ruaCodigo == null && other.ruaCodigo != null) || (this.ruaCodigo != null && !this.ruaCodigo.equals(other.ruaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.entity.Rua[ ruaCodigo=" + ruaCodigo + " ]";
    }
    
}
