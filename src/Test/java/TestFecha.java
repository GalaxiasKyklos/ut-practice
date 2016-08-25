package src.test.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import src.main.java.mx.iteso.ut_practice.Fecha;

public class TestFecha {

    @Before
    public void setup() {
        Fecha testFecha =  new Fecha();
    }

    @Test
    public void fechaValida() {
        Fecha testFecha =  new Fecha();
        Assert.assertEquals(
                testFecha.edad("25/07/1998"),/*"20 años, 4 meses y 17 días"*/"18 años, 1 meses y 0 días"
        );
    }

    @Test
    public void stringDifForm() {
        Fecha testFecha =  new Fecha();
        Assert.assertEquals(
                testFecha.edad("Hola Mundo"),"Formato Inválido"
        );
    }

    @Test
    public void diaInv() {
        Fecha testFecha =  new Fecha();
        Assert.assertEquals(
                testFecha.edad("40/08/1996"),"Día Inválido"
        );
    }

    @Test
    public void mesInv() {
        Fecha testFecha =  new Fecha();
        Assert.assertEquals(
                testFecha.edad("08/15/1996"),"Mes Inválido"
        );
    }

    @Test
    public void anyoInv() {
        Fecha testFecha =  new Fecha();
        Assert.assertEquals(
                testFecha.edad("08/04/ABCD"),"Año Inválido"
        );
    }

    @Test
    public void fechaFutura() {
        Fecha testFecha =  new Fecha();
        Assert.assertEquals(
                testFecha.edad("25/08/2017"),"Esa es una Fecha Futura"
        );
    }
}