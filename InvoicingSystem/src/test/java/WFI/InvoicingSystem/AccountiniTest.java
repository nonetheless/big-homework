package WFI.InvoicingSystem;

import presentation.accountiniui.accountini_driver;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AccountiniTest extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AccountiniTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AccountiniTest.class );
    }

    /**
     * Rigourous Test :-)
     */
	public void testAccountini(){
		accountini_driver a=new accountini_driver();
		a.run();
		assertEquals(1,a.i1);
		assertEquals(1,a.i2);
		assertEquals(1,a.i3);
		assertEquals(1,a.i4);
	}

}
