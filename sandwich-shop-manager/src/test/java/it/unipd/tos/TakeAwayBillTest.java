////////////////////////////////////////////////////////////////////
// Simone Meneghin 1174926
// //////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class TakeAwayBillTest
    extends TestCase
{
    
    TakeAwayBill takeAwayBill;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TakeAwayBillTest(String testName )
    {
        super( testName );
        takeAwayBill = new Bill();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TakeAwayBillTest.class );
    }
    
    /**
     * Test c
     * @throws Exception
     */
    @org.junit.Test
    public void TestRisultatoCorretto() throws TakeAwayBillException {
    
        List<MenuItem> ordini = new ArrayList<>();
        ordini.add(new MenuItem(MenuItem.ItemType.bevande, "Coca", 2.5));
        ordini.add(new MenuItem(MenuItem.ItemType.panini, "Primavera", 3.7));
        ordini.add(new MenuItem(MenuItem.ItemType.fritti, "Olive", 3));
        ordini.add(new MenuItem(MenuItem.ItemType.panini, "Veg", 3.2));
        ordini.add(new MenuItem(MenuItem.ItemType.bevande, "Fanta", 2));
        
        double conto = takeAwayBill.getOrderPrice(ordini);
        assertEquals(14.4, conto);
    }
    
    @org.junit.Test
    public void Test5Panini() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ordini.add(new MenuItem(MenuItem.ItemType.panini, "panino", 2.0));
        }
        
        assertEquals(11, takeAwayBill.getOrderPrice(ordini));
    }
    
    @org.junit.Test
    public void TestScontoTot() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ordini.add(new MenuItem(MenuItem.ItemType.bevande, "cola", 3.0));
        }
        
        assertEquals(54.0, takeAwayBill.getOrderPrice(ordini));
    }
    
    @org.junit.Test(expected = TakeAwayBillException.class)
    public void TestGt30Elementi() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            ordini.add(new MenuItem(MenuItem.ItemType.fritti, "olive", 2.5));
        }
        
        takeAwayBill.getOrderPrice(ordini);
    }
    
    @org.junit.Test
    public void TestMinEuro10() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ordini.add(new MenuItem(MenuItem.ItemType.bevande, "Cola", 2.0));
        }
        assertEquals(8.5, takeAwayBill.getOrderPrice(ordini));
    }
    
    @org.junit.Test
    public void TestListaVuota() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        assertEquals(0, takeAwayBill.getOrderPrice(ordini));
    }
    

}
