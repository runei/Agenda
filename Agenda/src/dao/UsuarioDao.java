/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.AgendaException;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author UCS
 */
public class UsuarioDao extends GenericDao {

    public void inserir(Usuario usuario) throws SQLException, AgendaException {
    	String select = "SELECT * FROM usuarios WHERE login = ?";
    	PreparedStatement statement = getConnection().prepareStatement(select);
    	statement.setString(1, usuario.getLogin());
    	ResultSet resultSet = statement.executeQuery();
    	if (resultSet.next()) {
    		throw new AgendaException("Usuario ja cadastrado!");
    	}
        String insert = "INSERT INTO usuarios(nome, login, senha) VALUES(?,?,?)";
        save(insert, usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }
 
    public void alterar(Usuario usuario) throws SQLException {
        String update = "UPDATE usuarios " +
                        "SET nome = ?, login = ?, senha = ? " +
                        "WHERE id = ?";
        update(update, usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }
 
    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM usuarios WHERE id = ?";
        delete(delete, id);
    }
 
    public Usuario logar(Usuario usuario) throws SQLException {
        String select = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getSenha());
        Usuario usuarioLogado = null;
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            usuarioLogado = new Usuario();
            usuarioLogado.setId(rs.getLong("id"));
            usuarioLogado.setNome(rs.getString("nome"));
            usuarioLogado.setSenha(rs.getString("senha"));
            usuarioLogado.setLogin(rs.getString("login"));
        }
        rs.close();
        stmt.close();
        return usuarioLogado;
    }    
    
    public ArrayList<Usuario> listar() throws SQLException {
        String select = "SELECT id, nome FROM usuarios";
        PreparedStatement stmt = getConnection().prepareStatement(select);
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs = stmt.executeQuery();
        Usuario usuario = null;
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setNome(rs.getString("nome"));
            usuarios.add(usuario);
        }
        rs.close();
        stmt.close();
        return usuarios;
    }
    
}
