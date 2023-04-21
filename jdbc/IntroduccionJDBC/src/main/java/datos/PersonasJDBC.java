package datos;

import domain.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonasJDBC {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono, saldo " +
                                             "FROM persona";
    private static final String SQL_INSERT= "INSERT INTO persona(nombre, apellido, email, telefono, saldo)" +
                                            "VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, " +
                                                                "apellido = ?, " +
                                                                "email = ?, " +
                                                                "telefono = ?, " +
                                                                "saldo = ? " +
                                             "WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public List<Persona> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPers = rs.getInt("id_persona");
                String nomb = rs.getString("nombre");
                String ape = rs.getString("apellido");
                String email = rs.getString("email");
                String tel = rs.getString("telefono");
                Double sal = rs.getDouble("saldo");
                persona = new Persona();
                    persona.setId_persona(idPers);
                    persona.setNombre(nomb);
                    persona.setApellido(ape);
                    persona.setEmail(email);
                    persona.setTelefono(tel);
                    persona.setSaldo(sal);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return personas;
    }
}
