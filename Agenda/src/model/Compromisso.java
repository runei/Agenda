/*
 * Decompiled with CFR 0_100.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import model.Tipo;
import model.Usuario;

public class Compromisso {
    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private Usuario autor;
    private ArrayList<Usuario> participantes;
    private Tipo tipo;
    private int importancia;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public ArrayList<Usuario> getParticipantes() {
        return this.participantes;
    }

    public void setParticipantes(ArrayList<Usuario> participantes) {
        this.participantes = participantes;
    }

    public int getImportancia() {
        return this.importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
