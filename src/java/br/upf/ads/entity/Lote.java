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
@Table(name = "lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l")
    , @NamedQuery(name = "Lote.findByLoteCodigo", query = "SELECT l FROM Lote l WHERE l.loteCodigo = :loteCodigo")
    , @NamedQuery(name = "Lote.findByLoteNome", query = "SELECT l FROM Lote l WHERE l.loteNome = :loteNome")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lote_codigo")
    private Integer loteCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "lote_nome")
    private String loteNome;
    @JoinColumn(name = "lote_pessoa", referencedColumnName = "pes_codigo")
    @ManyToOne
    private Pessoa lotePessoa;
    @JoinColumn(name = "lote_rua", referencedColumnName = "rua_codigo")
    @ManyToOne(optional = false)
    private Rua loteRua;
    @JoinColumn(name = "lote_valor", referencedColumnName = "vlr_codigo")
    @ManyToOne(optional = false)
    private Valorpadrao loteValor;
    @OneToMany(mappedBy = "parcLote")
    private Collection<Parcela> parcelaCollection;

    public Lote() {
    }

    public Lote(Integer loteCodigo) {
        this.loteCodigo = loteCodigo;
    }

    public Lote(Integer loteCodigo, String loteNome) {
        this.loteCodigo = loteCodigo;
        this.loteNome = loteNome;
    }

    public Integer getLoteCodigo() {
        return loteCodigo;
    }

    public void setLoteCodigo(Integer loteCodigo) {
        this.loteCodigo = loteCodigo;
    }

    public String getLoteNome() {
        return loteNome;
    }

    public void setLoteNome(String loteNome) {
        this.loteNome = loteNome;
    }

    public Pessoa getLotePessoa() {
        return lotePessoa;
    }

    public void setLotePessoa(Pessoa lotePessoa) {
        this.lotePessoa = lotePessoa;
    }

    public Rua getLoteRua() {
        return loteRua;
    }

    public void setLoteRua(Rua loteRua) {
        this.loteRua = loteRua;
    }

    public Valorpadrao getLoteValor() {
        return loteValor;
    }

    public void setLoteValor(Valorpadrao loteValor) {
        this.loteValor = loteValor;
    }

    @XmlTransient
    public Collection<Parcela> getParcelaCollection() {
        return parcelaCollection;
    }

    public void setParcelaCollection(Collection<Parcela> parcelaCollection) {
        this.parcelaCollection = parcelaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loteCodigo != null ? loteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.loteCodigo == null && other.loteCodigo != null) || (this.loteCodigo != null && !this.loteCodigo.equals(other.loteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.entity.Lote[ loteCodigo=" + loteCodigo + " ]";
    }
    
}
