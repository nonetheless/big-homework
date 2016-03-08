package WFI.InvoicingSystem;

import vo.BuyingsVO;
import vo.InformationVO;
import businesslogic.marketbl.Market;
import businesslogic.marketbl.Unity;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TempleTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TempleTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(  TempleTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	
        Market x= new Market();
        InformationVO info = new InformationVO("ggg","0001","","","",1,"");
        String m1 = x.inputinf(info);
       
        String m4 = x.listadd("", 0, 0);
        String m5 = x.listupd("", 0, 0);
        System.out.println(m4);
        
    }
}

