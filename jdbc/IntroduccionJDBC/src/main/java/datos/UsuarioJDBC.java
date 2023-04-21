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
    private static final String SQL_DELETE_USER = "DELETE FROM usuario WHERE id_persona = ?";

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
}
