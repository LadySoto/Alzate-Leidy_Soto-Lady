package com.backend.integrador.dao.impl;

import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);

    private List<Odontologo> odontologoLista;

    public OdontologoDaoMemoria(List<Odontologo> odontologoRepository) {
        this.odontologoLista = odontologoRepository;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        odontologoLista.add(odontologo);
        LOGGER.info("Odontologo registrado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        for (Odontologo odontologo : odontologoLista) {
            LOGGER.info("Este es el odontologo: " + odontologo);
        }
        return odontologoLista;
    }
}


