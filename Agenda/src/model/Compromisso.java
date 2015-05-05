/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author UCS
 */
public class Compromisso {

    private Long id;
	private Long idUsuario;
    private Calendar dataInicio;
    private Calendar dataFim;
    //private Usuario autor;
    private ArrayList<Usuario> participantes;
    private Tipo tipo;
    private int importancia;
    private String descricao;
    private String titulo;

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
     * @return the dataInicio
     */
    public Calendar getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Calendar getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the autor
     */
/*
	public Usuario getAutor() {
        return autor;
    }
*/
    /**
     * @param autor the autor to set
     */
/*
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
*/
    /**
     * @return the participantes
     */
    public ArrayList<Usuario> getParticipantes() {
        return participantes;
    }

    /**
     * @param participantes the participantes to set
     */
    public void setParticipantes(ArrayList<Usuario> participantes) {
        this.participantes = participantes;
    }

    /**
     * @return the importancia
     */
    public int getImportancia() {
        return importancia;
    }

    /**
     * @param importancia the importancia to set
     */
    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    
	@Override
	public String toString() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return this.getDescricao() + " " + sdFormat.format(this.getDataInicio().getTime()) + " - " + sdFormat.format(this.getDataFim().getTime());
	}
	
}
