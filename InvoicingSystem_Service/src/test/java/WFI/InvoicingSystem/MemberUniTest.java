package WFI.InvoicingSystem;

import po.MemberPO;
import data.memberdata.MemberData;
import data.memberdata.Unity;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MemberUniTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MemberUniTest ( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MemberUniTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testRead()
    {
        Unity x = new Unity();
        String tem = x.getId();
        assertNotNull(tem);
    }
    
    public void testAddMember(){
    	MemberData x = new MemberData();
    	MemberPO y = new MemberPO("0001", 0, null, "ggg", null, null, null, null, null, 0, 0, 0);
    	String m  =x.insert(y);
    	x.endMember();
    	assertEquals(m,"false");
    	
    }
}
