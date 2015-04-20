/*
 * Decompiled with CFR 0_100.
 */
package dao;

import dao.GenericDao;
import exception.AgendaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDao
extends GenericDao {
    public void inserir(Usuario usuario) throws SQLException, AgendaException {
        String select = "SELECT * FROM usuarios WHERE login = ?";
        PreparedStatement statement = this.getConnection().prepareStatement(select);
        statement.setString(1, usuario.getLogin());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            throw new AgendaException("Usu\ufffdrio j\ufffd cadastrado!");
        }
        String insert = "INSERT INTO usuarios(nome, login, senha) VALUES(?,?,?)";
        this.save(insert, usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }

    public void alterar(Usuario usuario) throws SQLException {
        String update = "UPDATE usuarios SET nome = ?, login = ?, senha = ? WHERE id = ?";
        this.update(update, usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }

    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM usuarios WHERE id = ?";
        this.delete(delete, id);
    }

    public Usuario logar(Usuario usuario) throws SQLException {
        String select = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(select);
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
}
