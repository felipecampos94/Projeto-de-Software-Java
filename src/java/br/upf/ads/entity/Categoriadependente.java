/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ads.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "categoriadependente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriadependente.findAll", query = "SELECT c FROM Categoriadependente c")
    , @NamedQuery(name = "Categoriadependente.findByCatdepCodigo", query = "SELECT c FROM Categoriadependente c WHERE c.catdepCodigo = :catdepCodigo")
    , @NamedQuery(name = "Categoriadependente.findByCatdepNome", query = "SELECT c FROM Categoriadependente c WHERE c.catdepNome = :catdepNome")
    , @NamedQuery(name = "Categoriadependente.findByCatdepDescricao", query = "SELECT c FROM Categoriadependente c WHERE c.catdepDescricao = :catdepDescricao")})
public class Categoriadependente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catdep_codigo")
    private Integer catdepCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "catdep_nome")
    private String catdepNome;
    @Size(max = 200)
    @Column(name = "catdep_descricao")
    private String catdepDescricao;

    public Categoriadependente() {
    }

    public Categoriadependente(Integer catdepCodigo) {
        this.catdepCodigo = catdepCodigo;
    }

    public Categoriadependente(Integer catdepCodigo, String catdepNome) {
        this.catdepCodigo = catdepCodigo;
        this.catdepNome = catdepNome;
    }

    public Integer getCatdepCodigo() {
        return catdepCodigo;
    }

    public void setCatdepCodigo(Integer catdepCodigo) {
        this.catdepCodigo = catdepCodigo;
    }

    public String getCatdepNome() {
        return catdepNome;
    }

    public void setCatdepNome(String catdepNome) {
        this.catdepNome = catdepNome;
    }

    public String getCatdepDescricao() {
        return catdepDescricao;
    }

    public void setCatdepDescricao(String catdepDescricao) {
        this.catdepDescricao = catdepDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catdepCodigo != null ? catdepCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriadependente)) {
            return false;
        }
        Categoriadependente other = (Categoriadependente) object;
        if ((this.catdepCodigo == null && other.catdepCodigo != null) || (this.catdepCodigo != null && !this.catdepCodigo.equals(other.catdepCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.entity.Categoriadependente[ catdepCodigo=" + catdepCodigo + " ]";
    }
    
}
