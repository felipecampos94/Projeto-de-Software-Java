/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.entity;

import java.io.Serializable;
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
@Table(name = "dependente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependente.findAll", query = "SELECT d FROM Dependente d")
    , @NamedQuery(name = "Dependente.findByDepCodigo", query = "SELECT d FROM Dependente d WHERE d.depCodigo = :depCodigo")
    , @NamedQuery(name = "Dependente.findByDepNome", query = "SELECT d FROM Dependente d WHERE d.depNome = :depNome")
    , @NamedQuery(name = "Dependente.findByDepDatanascimento", query = "SELECT d FROM Dependente d WHERE d.depDatanascimento = :depDatanascimento")
    , @NamedQuery(name = "Dependente.findByDepRua", query = "SELECT d FROM Dependente d WHERE d.depRua = :depRua")
    , @NamedQuery(name = "Dependente.findByDepNumero", query = "SELECT d FROM Dependente d WHERE d.depNumero = :depNumero")
    , @NamedQuery(name = "Dependente.findByDepBairro", query = "SELECT d FROM Dependente d WHERE d.depBairro = :depBairro")
    , @NamedQuery(name = "Dependente.findByDepTelefone", query = "SELECT d FROM Dependente d WHERE d.depTelefone = :depTelefone")
    , @NamedQuery(name = "Dependente.findByDepSexo", query = "SELECT d FROM Dependente d WHERE d.depSexo = :depSexo")})
public class Dependente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dep_codigo")
    private Integer depCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "dep_nome")
    private String depNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dep_datanascimento")
    @Temporal(TemporalType.DATE)
    private Date depDatanascimento;
    @Size(max = 50)
    @Column(name = "dep_rua")
    private String depRua;
    @Size(max = 10)
    @Column(name = "dep_numero")
    private String depNumero;
    @Size(max = 50)
    @Column(name = "dep_bairro")
    private String depBairro;
    @Size(max = 15)
    @Column(name = "dep_telefone")
    private String depTelefone;
    @Size(max = 10)
    @Column(name = "dep_sexo")
    private String depSexo;
    @JoinColumn(name = "dep_cidade", referencedColumnName = "cid_codigo")
    @ManyToOne
    private Cidade depCidade;
    @JoinColumn(name = "dep_pessoa", referencedColumnName = "pes_codigo")
    @ManyToOne
    private Pessoa depPessoa;

    public Dependente() {
    }

    public Dependente(Integer depCodigo) {
        this.depCodigo = depCodigo;
    }

    public Dependente(Integer depCodigo, String depNome, Date depDatanascimento) {
        this.depCodigo = depCodigo;
        this.depNome = depNome;
        this.depDatanascimento = depDatanascimento;
    }

    public Integer getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(Integer depCodigo) {
        this.depCodigo = depCodigo;
    }

    public String getDepNome() {
        return depNome;
    }

    public void setDepNome(String depNome) {
        this.depNome = depNome;
    }

    public Date getDepDatanascimento() {
        return depDatanascimento;
    }

    public void setDepDatanascimento(Date depDatanascimento) {
        this.depDatanascimento = depDatanascimento;
    }

    public String getDepRua() {
        return depRua;
    }

    public void setDepRua(String depRua) {
        this.depRua = depRua;
    }

    public String getDepNumero() {
        return depNumero;
    }

    public void setDepNumero(String depNumero) {
        this.depNumero = depNumero;
    }

    public String getDepBairro() {
        return depBairro;
    }

    public void setDepBairro(String depBairro) {
        this.depBairro = depBairro;
    }

    public String getDepTelefone() {
        return depTelefone;
    }

    public void setDepTelefone(String depTelefone) {
        this.depTelefone = depTelefone;
    }

    public String getDepSexo() {
        return depSexo;
    }

    public void setDepSexo(String depSexo) {
        this.depSexo = depSexo;
    }

    public Cidade getDepCidade() {
        return depCidade;
    }

    public void setDepCidade(Cidade depCidade) {
        this.depCidade = depCidade;
    }

    public Pessoa getDepPessoa() {
        return depPessoa;
    }

    public void setDepPessoa(Pessoa depPessoa) {
        this.depPessoa = depPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depCodigo != null ? depCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependente)) {
            return false;
        }
        Dependente other = (Dependente) object;
        if ((this.depCodigo == null && other.depCodigo != null) || (this.depCodigo != null && !this.depCodigo.equals(other.depCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.entity.Dependente[ depCodigo=" + depCodigo + " ]";
    }
    
}
