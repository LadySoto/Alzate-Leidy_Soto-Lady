package com.backend.integrador.dao.impl;

import com.backend.integrador.dao.H2Connection;
import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        String insert = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
        Odontologo odontologo1 = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, odontologo.getMatricula());
            pst.setString(2, odontologo.getNombre());
            pst.setString(3, odontologo.getApellido());
            pst.execute();

            connection.commit();
            odontologo1 = new Odontologo(odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());
            ResultSet key = pst.getGeneratedKeys();
            while (key.next()) {
                odontologo1.setId(key.getInt(1));
            }
            LOGGER.info("Odontologo registrado: " + odontologo1);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }
        return odontologo1;
    }


    @Override
    public List<Odontologo> listar() {
        Connection connection = null;
        Odontologo odontologo = null;
        List<Odontologo> odontologosLista = new ArrayList<>();
        String select = "SELECT * FROM ODONTOLOGOS";

        try {
            connection = H2Connection.getConnection();
            PreparedStatement pst = connection.prepareStatement(select);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                int id = rst.getInt(1);
                int matricula = rst.getInt(2);
                String nombre = rst.getString(3);
                String apellido = rst.getString(4);

                odontologo = new Odontologo(id, matricula, nombre, apellido);
                odontologosLista.add(odontologo);
            }
            //nos falto el log aca
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
<<<<<<< HEAD
=======

            return odontologosLista; //este return deberia estar fuera del bloque finally
>>>>>>> 7981331b12081e6e42f5b573fab80cedf86e04aa
        }
        return odontologosLista;
    }
}


