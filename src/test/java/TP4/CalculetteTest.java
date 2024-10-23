import org.junit.Test;
import static org.junit.Assert.*;


public class CalculetteTest {

    @Test
    public void testAddition() throws Exception {
        Calculette calc = new Calculette();
        calc.push(1.0);
        calc.push(3.0);
        calc.addition();
        assertEquals(4.0, calc.getResultat(), 0.001);
    }

    @Test
    public void testSoustraction() throws Exception {
        Calculette calc = new Calculette();
        calc.push(5.0);
        calc.push(2.0);
        calc.soustraction();
        assertEquals(3.0, calc.getResultat(), 0.001);
    }

    @Test
    public void testMultiplication() throws Exception {
        Calculette calc = new Calculette();
        calc.push(2.0);
        calc.push(4.0);
        calc.multiplication();
        assertEquals(8.0, calc.getResultat(), 0.001);
    }

    @Test
    public void testDivision() throws Exception {
        Calculette calc = new Calculette();
        calc.push(10.0);
        calc.push(2.0);
        calc.division();
        assertEquals(5.0, calc.getResultat(), 0.001);
    }

    @Test(expected = Exception.class)
    public void testDivisionParZero() throws Exception {
        Calculette calc = new Calculette();
        calc.push(10.0);
        calc.push(0.0);
        calc.division();
    }

    @Test
    public void testCalculNPI() throws Exception {
        Calculette calc = new Calculette();
        calc.calculerNPI("1.0 3 + 2 3.2 / +");
        assertEquals(4.625, calc.getResultat(), 0.001);
    }
}
