package datos;

public class PersonasJDBC {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono, saldo " +
                                             "FROM persona";
    private static final String SQL_INSERT= "INSERT INTO persona(nombre, apellido, email, telefono, saldo)" +
                                            "VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, " +
                                                                "apellido = ?, " +
                                                                "email = ?, " +
                                                                "telefono = ?, " +
                                                                "saldo = ?";
}
