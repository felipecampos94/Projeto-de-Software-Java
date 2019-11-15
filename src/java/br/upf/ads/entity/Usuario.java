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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUserCodigo", query = "SELECT u FROM Usuario u WHERE u.userCodigo = :userCodigo")
    , @NamedQuery(name = "Usuario.findByUserUsuario", query = "SELECT u FROM Usuario u WHERE u.userUsuario = :userUsuario")
    , @NamedQuery(name = "Usuario.findByUserSenha", query = "SELECT u FROM Usuario u WHERE u.userSenha = :userSenha")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_codigo")
    private Integer userCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_usuario")
    private String userUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_senha")
    private String userSenha;

    public Usuario() {
    }

    public Usuario(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public Usuario(Integer userCodigo, String userUsuario, String userSenha) {
        this.userCodigo = userCodigo;
        this.userUsuario = userUsuario;
        this.userSenha = userSenha;
    }

    public Integer getUserCodigo() {
        return userCodigo;
    }

    public void setUserCodigo(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCodigo != null ? userCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.userCodigo == null && other.userCodigo != null) || (this.userCodigo != null && !this.userCodigo.equals(other.userCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.upf.ads.entity.Usuario[ userCodigo=" + userCodigo + " ]";
    }
    
}
