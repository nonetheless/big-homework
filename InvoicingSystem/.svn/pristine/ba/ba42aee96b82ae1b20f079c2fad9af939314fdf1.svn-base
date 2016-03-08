package WFI.InvoicingSystem;


import po.MemberPO;
import vo.MemberVO;
import businesslogic.memberbl.MemberControl;
import businesslogicservice.memberblservice.MemberBLService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MemberTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MemberTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MemberTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMember()
    {
        MemberBLService t1 = new MemberControl();
        //String id1,int memberLevel,String memberKind,String memberName,String memberTel,String memberAd,String memberYB,String memberE,String saler,double pay,double get,double limit
        System.out.println(t1.findmember("", "").size());
        MemberVO vo = new MemberVO("r3j","532223","13983722715","nju一栋","400000","ggg77373@163.com","ee",2);
        System.out.println(t1.addmember(vo));
    }
}
