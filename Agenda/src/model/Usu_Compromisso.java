/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author W7
 */
public class Usu_Compromisso {
    
    private Long id;
    private Long idUsuario;
    private Long idCompromisso;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the idUsuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idCompromisso
     */
    public Long getIdCompromisso() {
        return idCompromisso;
    }

    /**
     * @param idCompromisso the idCompromisso to set
     */
    public void setIdCompromisso(Long idCompromisso) {
        this.idCompromisso = idCompromisso;
    }
    
    
}
