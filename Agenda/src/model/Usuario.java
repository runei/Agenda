/*
 * Decompiled with CFR 0_100.
 */
package model;

public class Usuario {
    private Long id;
    private String nome;
    private String login;
    private String senha;

	public Usuario() {
		
	}
	
	public Usuario(Long _id, String _nome, String _login, String _senha) {
		id = _id;
		nome = _nome;
		login = _login;
		senha = _senha;
	}
	
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
