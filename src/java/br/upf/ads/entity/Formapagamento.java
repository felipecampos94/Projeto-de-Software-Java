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
@Table(name = "formapagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formapagamento.findAll", query = "SELECT f FROM Formapagamento f")
    , @NamedQuery(name = "Formapagamento.findByFpgCodigo", query = "SELECT f FROM Formapagamento f WHERE f.fpgCodigo = :fpgCodigo")
    , @NamedQuery(name = "Formapagamento.findByFpgNome", query = "SELECT f FROM Formapagamento f WHERE f.fpgNome = :fpgNome")
    , @NamedQuery(name = "Formapagamento.findByFpgQtdmaxparcela", query = "SELECT f FROM Formapagamento f WHERE f.fpgQtdmaxparcela = :fpgQtdmaxparcela")
    , @NamedQuery(name = "Formapagamento.findByFpgIntervaloparcela", query = "SELECT f FROM Formapagamento f WHERE f.fpgIntervaloparcela = :fpgIntervaloparcela")
    , @NamedQuery(name = "Formapagamento.findByFpgPrimeiraparcela", query = "SELECT f FROM Formapagamento f WHERE f.fpgPrimeiraparcela = :fpgPrimeiraparcela")})
public class Formapagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fpg_codigo")
    private Integer fpgCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fpg_nome")
    private String fpgNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fpg_qtdmaxparcela")
    private int fpgQtdmaxparcela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fpg_intervaloparcela")
    private int fpgIntervaloparcela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fpg_primeiraparcela")
    private int fpgPrimeiraparcela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parcFormapagamento")
    private Collection<Parcela> parcelaCollection;

    public Formapagamento() {
    }

    public Formapagamento(Integer fpgCodigo) {
        this.fpgCodigo = fpgCodigo;
    }

    public Formapagamento(Integer fpgCodigo, String fpgNome, int fpgQtdmaxparcela, int fpgIntervaloparcela, int fpgPrimeiraparcela) {
        this.fpgCodigo = fpgCodigo;
        this.fpgNome = fpgNome;
        this.fpgQtdmaxparcela = fpgQtdmaxparcela;
        this.fpgIntervaloparcela = fpgIntervaloparcela;
        this.fpgPrimeiraparcela = fpgPrimeiraparcela;
    }

    public Integer getFpgCodigo() {
        return fpgCodigo;
    }

    public void setFpgCodigo(Integer fpgCodigo) {
        this.fpgCodigo = fpgCodigo;
    }

    public String getFpgNome() {
        return fpgNome;
    }

    public void setFpgNome(String fpgNome) {
        this.fpgNome = fpgNome;
    }

    public int getFpgQtdmaxparcela() {
        return fpgQtdmaxparcela;
    }

    public void setFpgQtdmaxparcela(int fpgQtdmaxparcela) {
        this.fpgQtdmaxparcela = fpgQtdmaxparcela;
    }

    public int getFpgIntervaloparcela() {
        return fpgIntervaloparcela;
    }

    public void setFpgIntervaloparcela(int fpgIntervaloparcela) {
        this.fpgIntervaloparcela = fpgIntervaloparcela;
    }

    public int getFpgPrimeiraparcela() {
        return fpgPrimeiraparcela;
    }

    public void setFpgPrimeiraparcela(int fpgPrimeiraparcela) {
        this.fpgPrimeiraparcela = fpgPrimeiraparcela;
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
        hash += (fpgCodigo != null ? fpgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapagamento)) {
            return false;
        }
        Formapagamento other = (Formapagamento) object;
        if ((this.fpgCodigo == null && other.fpgCodigo != null) || (this.fpgCodigo != null && !this.fpgCodigo.equals(other.fpgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fpgNome;
    }
    
}
