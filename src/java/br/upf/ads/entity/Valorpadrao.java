/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "valorpadrao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valorpadrao.findAll", query = "SELECT v FROM Valorpadrao v")
    , @NamedQuery(name = "Valorpadrao.findByVlrCodigo", query = "SELECT v FROM Valorpadrao v WHERE v.vlrCodigo = :vlrCodigo")
    , @NamedQuery(name = "Valorpadrao.findByVlrNome", query = "SELECT v FROM Valorpadrao v WHERE v.vlrNome = :vlrNome")
    , @NamedQuery(name = "Valorpadrao.findByVlrValor", query = "SELECT v FROM Valorpadrao v WHERE v.vlrValor = :vlrValor")
    , @NamedQuery(name = "Valorpadrao.findByVlrDescricao", query = "SELECT v FROM Valorpadrao v WHERE v.vlrDescricao = :vlrDescricao")})
public class Valorpadrao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vlr_codigo")
    private Integer vlrCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vlr_nome")
    private String vlrNome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "vlr_valor")
    private BigDecimal vlrValor;
    @Size(max = 50)
    @Column(name = "vlr_descricao")
    private String vlrDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesValor")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteValor")
    private Collection<Lote> loteCollection;

    public Valorpadrao() {
    }

    public Valorpadrao(Integer vlrCodigo) {
        this.vlrCodigo = vlrCodigo;
    }

    public Valorpadrao(Integer vlrCodigo, String vlrNome, BigDecimal vlrValor) {
        this.vlrCodigo = vlrCodigo;
        this.vlrNome = vlrNome;
        this.vlrValor = vlrValor;
    }

    public Integer getVlrCodigo() {
        return vlrCodigo;
    }

    public void setVlrCodigo(Integer vlrCodigo) {
        this.vlrCodigo = vlrCodigo;
    }

    public String getVlrNome() {
        return vlrNome;
    }

    public void setVlrNome(String vlrNome) {
        this.vlrNome = vlrNome;
    }

    public BigDecimal getVlrValor() {
        return vlrValor;
    }

    public void setVlrValor(BigDecimal vlrValor) {
        this.vlrValor = vlrValor;
    }

    public String getVlrDescricao() {
        return vlrDescricao;
    }

    public void setVlrDescricao(String vlrDescricao) {
        this.vlrDescricao = vlrDescricao;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @XmlTransient
    public Collection<Lote> getLoteCollection() {
        return loteCollection;
    }

    public void setLoteCollection(Collection<Lote> loteCollection) {
        this.loteCollection = loteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vlrCodigo != null ? vlrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valorpadrao)) {
            return false;
        }
        Valorpadrao other = (Valorpadrao) object;
        if ((this.vlrCodigo == null && other.vlrCodigo != null) || (this.vlrCodigo != null && !this.vlrCodigo.equals(other.vlrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return vlrNome;
    }
    
}
