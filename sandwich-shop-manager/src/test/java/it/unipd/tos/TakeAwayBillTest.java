////////////////////////////////////////////////////////////////////
// Simone Meneghin 1174926
// //////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;


public class TakeAwayBillTest {
    
    TakeAwayBill takeAwayBill;
    
    public TakeAwayBillTest()
    {
        takeAwayBill = new Bill();
    }
    
    @org.junit.Test
    public void TestRisultatoCorretto() throws TakeAwayBillException {
    
        List<MenuItem> ordini = new ArrayList<>();
        ordini.add(new MenuItem(MenuItem.ItemType.bevande, "Coca", 2.5));
        ordini.add(new MenuItem(MenuItem.ItemType.panini, "Primavera", 3.5));
        ordini.add(new MenuItem(MenuItem.ItemType.fritti, "Olive", 3));
        ordini.add(new MenuItem(MenuItem.ItemType.panini, "Veg", 3));
        ordini.add(new MenuItem(MenuItem.ItemType.bevande, "Fanta", 2));
        
        double conto = takeAwayBill.getOrderPrice(ordini);
        assertEquals(14, conto,0);
    }
    
    @org.junit.Test
    public void Test5Panini() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ordini.add(new MenuItem(MenuItem.ItemType.panini, "panino", 2.0));
        }
        
        assertEquals(11, takeAwayBill.getOrderPrice(ordini),0);
    }
    
    @org.junit.Test
    public void TestScontoTot() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ordini.add(new MenuItem(MenuItem.ItemType.bevande, "cola", 3.0));
        }
        
        assertEquals(54.0, takeAwayBill.getOrderPrice(ordini),0);
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
        assertEquals(8.5, takeAwayBill.getOrderPrice(ordini),0);
    }
    
    @org.junit.Test
    public void TestListaVuota() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        assertEquals(0, takeAwayBill.getOrderPrice(ordini),0);
    }
    

}
