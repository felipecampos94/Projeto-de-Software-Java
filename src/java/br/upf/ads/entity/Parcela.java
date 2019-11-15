/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "parcela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcela.findAll", query = "SELECT p FROM Parcela p")
    , @NamedQuery(name = "Parcela.findByParcCodigo", query = "SELECT p FROM Parcela p WHERE p.parcCodigo = :parcCodigo")
    , @NamedQuery(name = "Parcela.findByParcDatapagamento", query = "SELECT p FROM Parcela p WHERE p.parcDatapagamento = :parcDatapagamento")
    , @NamedQuery(name = "Parcela.findByParcAnoreferencia", query = "SELECT p FROM Parcela p WHERE p.parcAnoreferencia = :parcAnoreferencia")
    , @NamedQuery(name = "Parcela.findByParcValortotal", query = "SELECT p FROM Parcela p WHERE p.parcValortotal = :parcValortotal")
    , @NamedQuery(name = "Parcela.findByParcQtdparcela", query = "SELECT p FROM Parcela p WHERE p.parcQtdparcela = :parcQtdparcela")
    , @NamedQuery(name = "Parcela.findByParcDatavencimento", query = "SELECT p FROM Parcela p WHERE p.parcDatavencimento = :parcDatavencimento")
    , @NamedQuery(name = "Parcela.findByParcValorparcela", query = "SELECT p FROM Parcela p WHERE p.parcValorparcela = :parcValorparcela")
    , @NamedQuery(name = "Parcela.findByParcSituacao", query = "SELECT p FROM Parcela p WHERE p.parcSituacao = :parcSituacao")})
public class Parcela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "parc_codigo")
    private Integer parcCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parc_datapagamento")
    @Temporal(TemporalType.DATE)
    private Date parcDatapagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parc_anoreferencia")
    private int parcAnoreferencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "parc_valortotal")
    private BigDecimal parcValortotal;
    @Column(name = "parc_qtdparcela")
    private Integer parcQtdparcela;
    @Column(name = "parc_datavencimento")
    @Temporal(TemporalType.DATE)
    private Date parcDatavencimento;
    @Column(name = "parc_valorparcela")
    private BigDecimal parcValorparcela;
    @Size(max = 20)
    @Column(name = "parc_situacao")
    private String parcSituacao;
    @JoinColumn(name = "parc_formapagamento", referencedColumnName = "fpg_codigo")
    @ManyToOne(optional = false)
    private Formapagamento parcFormapagamento;
    @JoinColumn(name = "parc_lote", referencedColumnName = "lote_codigo")
    @ManyToOne
    private Lote parcLote;
    @JoinColumn(name = "parc_pessoa", referencedColumnName = "pes_codigo")
    @ManyToOne
    private Pessoa parcPessoa;

    public Parcela() {
    }

    public Parcela(Integer parcCodigo) {
        this.parcCodigo = parcCodigo;
    }

    public Parcela(Integer parcCodigo, Date parcDatapagamento, int parcAnoreferencia) {
        this.parcCodigo = parcCodigo;
        this.parcDatapagamento = parcDatapagamento;
        this.parcAnoreferencia = parcAnoreferencia;
    }

    public Integer getParcCodigo() {
        return parcCodigo;
    }

    public void setParcCodigo(Integer parcCodigo) {
        this.parcCodigo = parcCodigo;
    }

    public Date getParcDatapagamento() {
        return parcDatapagamento;
    }

    public void setParcDatapagamento(Date parcDatapagamento) {
        this.parcDatapagamento = parcDatapagamento;
    }

    public int getParcAnoreferencia() {
        return parcAnoreferencia;
    }

    public void setParcAnoreferencia(int parcAnoreferencia) {
        this.parcAnoreferencia = parcAnoreferencia;
    }

    public BigDecimal getParcValortotal() {
        return parcValortotal;
    }

    public void setParcValortotal(BigDecimal parcValortotal) {
        this.parcValortotal = parcValortotal;
    }

    public Integer getParcQtdparcela() {
        return parcQtdparcela;
    }

    public void setParcQtdparcela(Integer parcQtdparcela) {
        this.parcQtdparcela = parcQtdparcela;
    }

    public Date getParcDatavencimento() {
        return parcDatavencimento;
    }

    public void setParcDatavencimento(Date parcDatavencimento) {
        this.parcDatavencimento = parcDatavencimento;
    }

    public BigDecimal getParcValorparcela() {
        return parcValorparcela;
    }

    public void setParcValorparcela(BigDecimal parcValorparcela) {
        this.parcValorparcela = parcValorparcela;
    }

    public String getParcSituacao() {
        return parcSituacao;
    }

    public void setParcSituacao(String parcSituacao) {
        this.parcSituacao = parcSituacao;
    }

    public Formapagamento getParcFormapagamento() {
        return parcFormapagamento;
    }

    public void setParcFormapagamento(Formapagamento parcFormapagamento) {
        this.parcFormapagamento = parcFormapagamento;
    }

    public Lote getParcLote() {
        return parcLote;
    }

    public void setParcLote(Lote parcLote) {
        this.parcLote = parcLote;
    }

    public Pessoa getParcPessoa() {
        return parcPessoa;
    }

    public void setParcPessoa(Pessoa parcPessoa) {
        this.parcPessoa = parcPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parcCodigo != null ? parcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcela)) {
            return false;
        }
        Parcela other = (Parcela) object;
        if ((this.parcCodigo == null && other.parcCodigo != null) || (this.parcCodigo != null && !this.parcCodigo.equals(other.parcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.entity.Parcela[ parcCodigo=" + parcCodigo + " ]";
    }
    
}
