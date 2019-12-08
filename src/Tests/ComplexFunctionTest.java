package Tests;

import Ex1.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexFunctionTest {
    static function f0;
    static function f1;
    @Before
    public void BeforeEach() {
        Polynom p0=new Polynom("2x^2+4");
        Polynom p1=new Polynom("8x^2+6");
        f0=p0.copy();
        f1=p1.copy();
    }

    /**
     * Checks that the default constructor works properly, i.e. the right and left functions are equal to null and the operator is equal to None
     */
    @Test
    public void DefaultComplexFunction()
    {
        ComplexFunction c= new ComplexFunction();
        assertNull(c.left());
        assertNull(c.right());
        assertEquals("None",c.getOp().toString());
    }

    /**
     * Checks that the constructor that accepts 2 functions and operator works properly
     */
    @Test
    public void threeParametersComplexFunction()
    {
        ComplexFunction cPlus= new ComplexFunction("plus",f0,f1);
        assertEquals("2.0x^2+4.0",cPlus.left().toString());
        assertEquals("8.0x^2+6.0",cPlus.right().toString());
        assertEquals("Plus",cPlus.getOp().toString());

        ComplexFunction cTimes= new ComplexFunction("Times",f0,f1);
        assertEquals("2.0x^2+4.0",cTimes.left().toString());
        assertEquals("8.0x^2+6.0",cTimes.right().toString());
        assertEquals("Times",cTimes.getOp().toString());

        ComplexFunction cDivid= new ComplexFunction("Divid",f0,f1);
        assertEquals("2.0x^2+4.0",cDivid.left().toString());
        assertEquals("8.0x^2+6.0",cDivid.right().toString());
        assertEquals("Divid",cDivid.getOp().toString());

        ComplexFunction cMax= new ComplexFunction("Max",f0,f1);
        assertEquals("2.0x^2+4.0",cMax.left().toString());
        assertEquals("8.0x^2+6.0",cMax.right().toString());
        assertEquals("Max",cMax.getOp().toString());

        ComplexFunction cMins= new ComplexFunction("Min",f0,f1);
        assertEquals("2.0x^2+4.0",cMins.left().toString());
        assertEquals("8.0x^2+6.0",cMins.right().toString());
        assertEquals("Min",cMins.getOp().toString());

        ComplexFunction cComp= new ComplexFunction("Comp",f0,f1);
        assertEquals("2.0x^2+4.0",cComp.left().toString());
        assertEquals("8.0x^2+6.0",cComp.right().toString());
        assertEquals("Comp",cComp.getOp().toString());
    }

    /**
     * Checks that the constructor that accepts one function works properly,
     * i.e. the function that accepts puts as the left function, the operator will be None and the right function will be null
     */
    @Test
    public void oneParametersComplexFunction()
    {
        ComplexFunction cPlus= new ComplexFunction(f0);
        assertEquals("2.0x^2+4.0",cPlus.left().toString());
        assertNull(cPlus.right());
        assertEquals("None",cPlus.getOp().toString());

        ComplexFunction cTimes= new ComplexFunction(f1);
        assertEquals("8.0x^2+6.0",cTimes.left().toString());
        assertNull(cPlus.right());
        assertEquals("None",cTimes.getOp().toString());

    }

    /**
     * Checks that the copy constructor works properly,
     * i.e. The constructor copies what ComplexFunction the left function the right function and the operator
     */
    @Test
    public void CopyComplexFunction()
    {
        ComplexFunction c= new ComplexFunction();
        ComplexFunction cPlus= new ComplexFunction("plus",f0,f1);
        ComplexFunction cTimes= new ComplexFunction("Times",f0,f1);
        ComplexFunction cDivid= new ComplexFunction("Divid",f0,f1);
        ComplexFunction cMax= new ComplexFunction("Max",f0,f1);
        ComplexFunction cMins= new ComplexFunction("Min",f0,f1);
        ComplexFunction cComp= new ComplexFunction("Comp",f0,f1);


        ComplexFunction[] arrC={c,cPlus,cTimes,cDivid,cMax,cMins,cComp};
        for (int i = 0; i <arrC.length ; i++) {
            ComplexFunction cCopy= new ComplexFunction(arrC[i]);
            assertEquals(arrC[i].getOp(),cCopy.getOp());
            assertEquals(arrC[i].left(),cCopy.left());
            assertEquals(arrC[i].right(),cCopy.right());
        }
    }

    @Test
    public void plus() {
        ComplexFunction c0= new ComplexFunction(f0);
        assertEquals("2.0x^2+4.0",c0.left().toString());
        assertNull(c0.right());
        assertEquals("None",c0.getOp().toString());

        c0.plus(f1);
        assertEquals("Plus",c0.getOp().toString());
        assertNotNull(c0.left());
        assertNotNull(c0.right());


    }

    @Test
    public void mul() {
    }

    @Test
    public void div() {
    }

    @Test
    public void max() {
    }

    @Test
    public void min() {
    }

    @Test
    public void comp() {
    }

    @Test
    public void left() {
    }

    @Test
    public void right() {
    }

    @Test
    public void getOp() {
    }

    @Test
    public void f() {
        String toInit1 = "max(max(max(max(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.2999999999999998x+5.0),plus(div(1.0x+1.0,mul(mul(1.0x+3.0,1.0x-2.0),1.0x-4.0)),2.0)),div(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.2999999999999998x+5.0),-1.0x^4+2.4x^2+3.1)),-1.0x^4+2.4x^2+3.1),0.1x^5-1.2999999999999998x+5.0)";
        String toInit2 = "plus(div(1.0x+1.0,mul(mul(1.0x+3.0,1.0x-2.0),1.0x-4.0)),2.0)";
        function inited1 = new ComplexFunction();
        function inited2 = new ComplexFunction();
        function a = inited1.initFromString(toInit1);
        function b = inited2.initFromString(toInit2);
        double ans1 = 5.6;
        double ans2 = (4.0/-6.0)+2 ;
        double fx1 = a.f(2);
        double fx2 = b.f(3);
        assertEquals(ans1,fx1,Monom.EPSILON);
        assertEquals(ans2,fx2,Monom.EPSILON);
    }

    @Test
    public void initFromStringtest() {
        String toInit = "max(max(max(max(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.2999999999999998x+5.0),plus(div(1.0x+1.0,mul(mul(1.0x+3.0,1.0x-2.0),1.0x-4.0)),2.0)),div(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.2999999999999998x+5.0),-1.0x^4+2.4x^2+3.1)),-1.0x^4+2.4x^2+3.1),0.1x^5-1.2999999999999998x+5.0)";
        function inited = new ComplexFunction();
        function a = inited.initFromString(toInit);
        assertEquals(a.toString(),toInit);
    }

    @Test
    public void copy() {
    }


    @Test
    public void TtoString() {
        ComplexFunction cPlus= new ComplexFunction("plus",f0,f1);
        assertEquals("plus(2.0x^2+4.0,8.0x^2+6.0)",cPlus.toString());
        cPlus.plus(f0);
        assertEquals("plus(plus(2.0x^2+4.0,8.0x^2+6.0),2.0x^2+4.0)",cPlus.toString());
        System.out.println(cPlus.toString());
    }
}