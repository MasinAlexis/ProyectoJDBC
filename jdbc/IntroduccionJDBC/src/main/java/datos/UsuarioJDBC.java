package datos;

import domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioJDBC {
    private static final String SQL_SELECT_USER = "SELECT id_usuario, username, password FROM usuario";
    private static final String SQL_INSERT_USER = "INSERT INTO usuario(username, password) VALUES(?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE usuario SET username = ?, " +
                                                                     "password = ? " +
                                                  "WHERE id_usuario = ?";
    private static final String SQL_DELETE_USER = "DELETE FROM usuario WHERE id_usuario = ?";

    public List<Usuario> select(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_USER);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idUsuario = rs.getInt("id_usuario");
                String user = rs.getString("username");
                String pass = rs.getString("password");
                usuario = new Usuario();
                usuario.setId_usuario(idUsuario);
                usuario.setUsername(user);
                usuario.setPassword(pass);
                usuarios.add(usuario);
            }

        } catch (SQLException e){
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return usuarios;
    }

    public int insert(Usuario usuario){
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_USER);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());

            System.out.println("Ejecutando Query: " + SQL_INSERT_USER);
            rows = stmt.executeUpdate();
            System.out.println("Registros insertados: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int update(Usuario usuario){
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_USER);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId_usuario());

            System.out.println("Ejecutando Query: " + SQL_UPDATE_USER);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int delete(Usuario usuario){
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_USER);
            stmt.setInt(1, usuario.getId_usuario());

            System.out.println("Ejecutando Query: " + SQL_DELETE_USER);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }
}
