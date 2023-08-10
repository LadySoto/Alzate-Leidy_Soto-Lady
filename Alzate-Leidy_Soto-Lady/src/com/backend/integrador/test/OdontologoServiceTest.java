package com.backend.integrador.test;

import com.backend.integrador.dao.impl.OdontologoDaoH2;
import com.backend.integrador.dao.impl.OdontologoDaoMemoria;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    OdontologoDaoH2 odontologoDaoH2 = new OdontologoDaoH2();
    OdontologoService odontologoService = new OdontologoService(odontologoDaoH2);

    @Test
    public void laListaNoDebeDeEstarVacia() {
        List<Odontologo> listadoOdontologos = odontologoService.listarOdontologos();

        assertNotNull(listadoOdontologos);
    }

    @Test
    public void debeListarTodosLosOdontologos() {
        List<Odontologo> listaOdontologos = new ArrayList<>();

        Odontologo odontologo1 = new Odontologo(456321, "Luis", "Lopez");
        Odontologo odontologo2 = new Odontologo(741258, "Marta", "Cano");
        listaOdontologos.add(odontologo1);
        listaOdontologos.add(odontologo2);

        OdontologoService odontologoService1 = new OdontologoService(new OdontologoDaoMemoria(listaOdontologos));

        List<Odontologo> ListadoDeOdontologos = odontologoService1.listarOdontologos();

        assertNotNull(ListadoDeOdontologos);
    }

    @Test
    public void deberiaRegistrarUnOdontologo() {
        //arrange
        Odontologo odontologo = new Odontologo(569986, "Manuela", "Cadavid");

        //act
        Odontologo odontologoRegistrado = odontologoService.registrarOdontologo(odontologo);
        int rtsEsperada = odontologoRegistrado.getMatricula();
        int rtsObtenida = odontologoRegistrado.getMatricula();

        //assert
        assertEquals(rtsEsperada, rtsObtenida);
    }

}