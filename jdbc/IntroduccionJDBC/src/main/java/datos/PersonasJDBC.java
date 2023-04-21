package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;

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

    public int insert(Persona persona){
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            stmt.setDouble(5,persona.getSaldo());

            System.out.println("Ejecutando Query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int update(Persona persona) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            con = Conexion.getConnection();
            System.out.println("Ejecutando Query: " + SQL_UPDATE);
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setDouble(5,persona.getSaldo());
            stmt.setInt(6,persona.getId_persona());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int delete(Persona persona){
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            con = Conexion.getConnection();
            System.out.println("Ejecutando Query: " + SQL_DELETE);

            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getId_persona());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }
}