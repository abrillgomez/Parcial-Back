package Test;

import Models.Odontologo;
import Service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OdontologoServiceTest {

    @Test
    public void guardarOdontogo() {
        OdontologoService odontologoService = new OdontologoService();
        Odontologo o = new Odontologo();
        o.setId(4);
        o.setNumeroMatricula("101JKL");
        o.setNombre("Emiliano");
        o.setApellido("Martinez");

        Boolean resultado = odontologoService.guardar(o);
        assertTrue(true);
    }

    @Test
    public void listarOdontologosTest(){
        OdontologoService prueba = new OdontologoService();
        List<Odontologo> resultado = prueba.listar();
        assertNotNull(resultado);
        for (Odontologo odontologo:resultado){
            System.out.println(odontologo.toString());
        }
    }
}