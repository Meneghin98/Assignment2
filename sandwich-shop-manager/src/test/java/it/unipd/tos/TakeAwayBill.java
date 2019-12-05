////////////////////////////////////////////////////////////////////
// Simone Meneghin 1174926
// //////////////////////////////////////////////////////////////////

package it.unipd.tos;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TakeAwayBill
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TakeAwayBill(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TakeAwayBill.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
