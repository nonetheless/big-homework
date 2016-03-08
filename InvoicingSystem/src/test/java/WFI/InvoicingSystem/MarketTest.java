package WFI.InvoicingSystem;

import vo.InformationVO;
import businesslogic.marketbl.Market;
import businesslogic.marketbl.Sale;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MarketTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MarketTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MarketTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testData()
    {
    	InformationVO info = new InformationVO("name","id","house","user","other",1,"saler");
    	Sale x = new Sale(info);
    	System.out.print(x.find("no", "no", "no","no", "no", "no").size());
        assertTrue( true );
    }
}
