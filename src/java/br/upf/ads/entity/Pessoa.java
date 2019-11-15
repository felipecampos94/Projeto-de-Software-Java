/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
    , @NamedQuery(name = "Pessoa.findByPesCodigo", query = "SELECT p FROM Pessoa p WHERE p.pesCodigo = :pesCodigo")
    , @NamedQuery(name = "Pessoa.findByPesNome", query = "SELECT p FROM Pessoa p WHERE p.pesNome = :pesNome")
    , @NamedQuery(name = "Pessoa.findByPesDatanascimento", query = "SELECT p FROM Pessoa p WHERE p.pesDatanascimento = :pesDatanascimento")
    , @NamedQuery(name = "Pessoa.findByPesRua", query = "SELECT p FROM Pessoa p WHERE p.pesRua = :pesRua")
    , @NamedQuery(name = "Pessoa.findByPesNumero", query = "SELECT p FROM Pessoa p WHERE p.pesNumero = :pesNumero")
    , @NamedQuery(name = "Pessoa.findByPesBairro", query = "SELECT p FROM Pessoa p WHERE p.pesBairro = :pesBairro")
    , @NamedQuery(name = "Pessoa.findByPesTelefone", query = "SELECT p FROM Pessoa p WHERE p.pesTelefone = :pesTelefone")
    , @NamedQuery(name = "Pessoa.findByPesSexo", query = "SELECT p FROM Pessoa p WHERE p.pesSexo = :pesSexo")
    , @NamedQuery(name = "Pessoa.findByPesCpf", query = "SELECT p FROM Pessoa p WHERE p.pesCpf = :pesCpf")
    , @NamedQuery(name = "Pessoa.findByPesRg", query = "SELECT p FROM Pessoa p WHERE p.pesRg = :pesRg")
    , @NamedQuery(name = "Pessoa.findByPesEmail", query = "SELECT p FROM Pessoa p WHERE p.pesEmail = :pesEmail")
    , @NamedQuery(name = "Pessoa.findByPesProfissao", query = "SELECT p FROM Pessoa p WHERE p.pesProfissao = :pesProfissao")
    , @NamedQuery(name = "Pessoa.findByPesAtivo", query = "SELECT p FROM Pessoa p WHERE p.pesAtivo = :pesAtivo")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pes_codigo")
    private Integer pesCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pes_nome")
    private String pesNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pes_datanascimento")
    @Temporal(TemporalType.DATE)
    private Date pesDatanascimento;
    @Size(max = 50)
    @Column(name = "pes_rua")
    private String pesRua;
    @Size(max = 10)
    @Column(name = "pes_numero")
    private String pesNumero;
    @Size(max = 50)
    @Column(name = "pes_bairro")
    private String pesBairro;
    @Size(max = 15)
    @Column(name = "pes_telefone")
    private String pesTelefone;
    @Size(max = 10)
    @Column(name = "pes_sexo")
    private String pesSexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "pes_cpf")
    private String pesCpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pes_rg")
    private String pesRg;
    @Size(max = 40)
    @Column(name = "pes_email")
    private String pesEmail;
    @Size(max = 40)
    @Column(name = "pes_profissao")
    private String pesProfissao;
    @Column(name = "pes_ativo")
    private Boolean pesAtivo;
    @JoinColumn(name = "pes_categoria", referencedColumnName = "catsoc_codigo")
    @ManyToOne(optional = false)
    private Categoriasocio pesCategoria;
    @JoinColumn(name = "pes_cidade", referencedColumnName = "cid_codigo")
    @ManyToOne
    private Cidade pesCidade;
    @JoinColumn(name = "pes_piquete", referencedColumnName = "piq_codigo")
    @ManyToOne(optional = false)
    private Piquete pesPiquete;
    @JoinColumn(name = "pes_valor", referencedColumnName = "vlr_codigo")
    @ManyToOne(optional = false)
    private Valorpadrao pesValor;
    @OneToMany(mappedBy = "lotePessoa")
    private Collection<Lote> loteCollection;
    @OneToMany(mappedBy = "depPessoa")
    private Collection<Dependente> dependenteCollection;
    @OneToMany(mappedBy = "parcPessoa")
    private Collection<Parcela> parcelaCollection;

    public Pessoa() {
    }

    public Pessoa(Integer pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    public Pessoa(Integer pesCodigo, String pesNome, Date pesDatanascimento, String pesCpf, String pesRg) {
        this.pesCodigo = pesCodigo;
        this.pesNome = pesNome;
        this.pesDatanascimento = pesDatanascimento;
        this.pesCpf = pesCpf;
        this.pesRg = pesRg;
    }

    public Integer getPesCodigo() {
        return pesCodigo;
    }

    public void setPesCodigo(Integer pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public Date getPesDatanascimento() {
        return pesDatanascimento;
    }

    public void setPesDatanascimento(Date pesDatanascimento) {
        this.pesDatanascimento = pesDatanascimento;
    }

    public String getPesRua() {
        return pesRua;
    }

    public void setPesRua(String pesRua) {
        this.pesRua = pesRua;
    }

    public String getPesNumero() {
        return pesNumero;
    }

    public void setPesNumero(String pesNumero) {
        this.pesNumero = pesNumero;
    }

    public String getPesBairro() {
        return pesBairro;
    }

    public void setPesBairro(String pesBairro) {
        this.pesBairro = pesBairro;
    }

    public String getPesTelefone() {
        return pesTelefone;
    }

    public void setPesTelefone(String pesTelefone) {
        this.pesTelefone = pesTelefone;
    }

    public String getPesSexo() {
        return pesSexo;
    }

    public void setPesSexo(String pesSexo) {
        this.pesSexo = pesSexo;
    }

    public String getPesCpf() {
        return pesCpf;
    }

    public void setPesCpf(String pesCpf) {
        this.pesCpf = pesCpf;
    }

    public String getPesRg() {
        return pesRg;
    }

    public void setPesRg(String pesRg) {
        this.pesRg = pesRg;
    }

    public String getPesEmail() {
        return pesEmail;
    }

    public void setPesEmail(String pesEmail) {
        this.pesEmail = pesEmail;
    }

    public String getPesProfissao() {
        return pesProfissao;
    }

    public void setPesProfissao(String pesProfissao) {
        this.pesProfissao = pesProfissao;
    }

    public Boolean getPesAtivo() {
        return pesAtivo;
    }

    public void setPesAtivo(Boolean pesAtivo) {
        this.pesAtivo = pesAtivo;
    }

    public Categoriasocio getPesCategoria() {
        return pesCategoria;
    }

    public void setPesCategoria(Categoriasocio pesCategoria) {
        this.pesCategoria = pesCategoria;
    }

    public Cidade getPesCidade() {
        return pesCidade;
    }

    public void setPesCidade(Cidade pesCidade) {
        this.pesCidade = pesCidade;
    }

    public Piquete getPesPiquete() {
        return pesPiquete;
    }

    public void setPesPiquete(Piquete pesPiquete) {
        this.pesPiquete = pesPiquete;
    }

    public Valorpadrao getPesValor() {
        return pesValor;
    }

    public void setPesValor(Valorpadrao pesValor) {
        this.pesValor = pesValor;
    }

    @XmlTransient
    public Collection<Lote> getLoteCollection() {
        return loteCollection;
    }

    public void setLoteCollection(Collection<Lote> loteCollection) {
        this.loteCollection = loteCollection;
    }

    @XmlTransient
    public Collection<Dependente> getDependenteCollection() {
        return dependenteCollection;
    }

    public void setDependenteCollection(Collection<Dependente> dependenteCollection) {
        this.dependenteCollection = dependenteCollection;
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
        hash += (pesCodigo != null ? pesCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pesCodigo == null && other.pesCodigo != null) || (this.pesCodigo != null && !this.pesCodigo.equals(other.pesCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pesNome;
    }
    
}
