package Dao.Imp;

import Dao.IDao;
import Models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    public static Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private String url;
    private String user;
    private String password;
    private final String TABLA = "odontologo";


    @Override
        public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos

            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/odontologo;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO (ID, NUMEROMATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?,?)");
            preparedStatement.setLong(1, odontologo.getId());
            preparedStatement.setString(2, odontologo.getNumeroMatricula());
            preparedStatement.setString(3, odontologo.getNombre());
            preparedStatement.setString(4, odontologo.getApellido());

            if (preparedStatement.executeUpdate() == 1) {
                return odontologo;
            }
            logger.info("El odontologo se guardo correctamente");

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("Error de conexion" + throwables.getMessage());
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        List<Odontologo> resultado = new ArrayList<>();

        //1 Obtener y levantar el controlador
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error(ex.getMessage());
        }
        //2 Abrir la conexión a la base de datos, y usar esa conexión para crear un objeto tipo PreparedStatement
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
             Statement stmt = conn.createStatement()){

            //[2a] Ejecutar la sentencia SQL, procesar su respuesta
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA + ";");
            while (rs.next()){
                Odontologo o = new Odontologo();

                o.setId(rs.getInt(1));
                o.setNumeroMatricula(rs.getString(2));
                o.setNombre(rs.getString(3));
                o.setApellido(rs.getString(4));

                resultado.add(o);}

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        //3 Retornar la lista de registros encontrados.
        return resultado;
    }
}