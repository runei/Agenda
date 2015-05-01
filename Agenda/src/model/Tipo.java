/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author UCS
 */
public class Tipo {
    
    private Long id;
    private String descricao;
    private int cor;
    private ArrayList<AtributosTipo> atributos;

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the cor
     */
    public int getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(int cor) {
        this.cor = cor;
    }

    /**
     * @return the atributos
     */
    public ArrayList<AtributosTipo> getAtributos() {
        return atributos;
    }

    /**
     * @param atributos the atributos to set
     */
    public void setAtributos(ArrayList<AtributosTipo> atributos) {
        this.atributos = atributos;
    }
    
}
