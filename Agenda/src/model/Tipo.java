/*
 * Decompiled with CFR 0_100.
 */
package model;

import java.util.ArrayList;
import model.AtributosTipo;

public class Tipo {
    private Long id;
    private String descricao;
    private int cor;
    private ArrayList<AtributosTipo> atributos;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCor() {
        return this.cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public ArrayList<AtributosTipo> getAtributos() {
        return this.atributos;
    }

    public void setAtributos(ArrayList<AtributosTipo> atributos) {
        this.atributos = atributos;
    }
}
