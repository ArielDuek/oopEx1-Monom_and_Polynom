package Tests;

import Ex1.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexFunctionTest {
    static ComplexFunction[] arrComFun = new ComplexFunction[18];
    static Polynom[] arrPol =new Polynom[15];
    static ComplexFunction[] Random = new ComplexFunction[30];
    static String[] Op = {"mul","min","max","comp","plus","div"};

    static function f0;
    static function f1;
    @Before
    public void BeforeEach() {
        Polynom p0=new Polynom("2x^2+4");
        Polynom p1=new Polynom("8x^2+6");
        f0=p0.copy();
        f1=p1.copy();

//Build the Polynoms with the help of the Polynom string constructor
        arrPol[0] = new Polynom("-89");
        arrPol[1] = new Polynom("4x");
        arrPol[2] = new Polynom("-5x^2+6x-17");
        arrPol[3] = new Polynom("4x^4");
        arrPol[4] = new Polynom("3x^5+5x^3+4x+23");
        arrPol[5] = new Polynom("2x^4-6X^2-7");
        arrPol[6] = new Polynom("-X^2");
        arrPol[7] = new Polynom("777");
        arrPol[8] = new Polynom("x^6-x^5-x^4-x^3-x^2-x");
        arrPol[9] = new Polynom("X^3+x^2");
        arrPol[10] = new Polynom("77x^4");
        arrPol[11] = new Polynom("3X");
        arrPol[12] = new Polynom("9X^7");
        arrPol[13] = new Polynom("15x^4-14X^5");
        arrPol[14] = new Polynom("x^2+x^4-X^3-2x^2");

        //Build the Polynoms with the help of the Polynom string constructor
        arrComFun[0] = new ComplexFunction("plus",arrPol[0],arrPol[1]);
        arrComFun[1] = new ComplexFunction("plus",arrPol[2],arrPol[3]);
        arrComFun[2] = new ComplexFunction("plus",arrPol[4],arrPol[5]);
        arrComFun[3] = new ComplexFunction("max",arrPol[6],arrPol[7]);
        arrComFun[4] = new ComplexFunction("max",arrPol[8],arrPol[9]);
        arrComFun[5] = new ComplexFunction("max",arrPol[10],arrPol[11]);
        arrComFun[6] = new ComplexFunction("min",arrPol[12],arrPol[13]);
        arrComFun[7] = new ComplexFunction("min",arrPol[14],arrPol[2]);
        arrComFun[8] = new ComplexFunction("min",arrPol[0],arrPol[1]);
        arrComFun[9] = new ComplexFunction("comp",arrPol[2],arrPol[3]);
        arrComFun[10] = new ComplexFunction("comp",arrPol[4],arrPol[5]);
        arrComFun[11] = new ComplexFunction("comp",arrPol[6],arrPol[7]);
        arrComFun[12] = new ComplexFunction("div",arrPol[8],arrPol[9]);
        arrComFun[13] = new ComplexFunction("div",arrPol[10],arrPol[11]);
        arrComFun[14] = new ComplexFunction("div",arrPol[12],arrPol[13]);
        arrComFun[15] = new ComplexFunction("mul",arrPol[14],arrPol[1]);
        arrComFun[16] = new ComplexFunction("mul",arrPol[12],arrPol[7]);
        arrComFun[17] = new ComplexFunction("mul",arrPol[5],arrPol[9]);

        for (int i = 0; i < 30; i++) {
            String op = Op[(int)Math.random()*6];
            function left = arrPol[(int)Math.random()*15];
            function right = arrPol[(int)Math.random()*15];
            Random[i]=new ComplexFunction(op,left,right);
        }
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
        arrComFun[5].plus(arrComFun[14]);
        arrComFun[2].plus(arrComFun[10]);
        arrComFun[4].plus(arrComFun[0]);
        arrComFun[17].plus(arrComFun[12]);
        arrComFun[8].plus(arrComFun[9]);
        arrComFun[3].plus(arrComFun[11]);
        arrComFun[7].plus(arrComFun[13]);
        arrComFun[1].plus(arrComFun[15]);
        arrComFun[16].plus(arrComFun[6]);
        assertEquals("plus(max(77.0x^4,3.0x),div(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[5].toString());
        assertEquals("plus(plus(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0),comp(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0))",arrComFun[2].toString());
        assertEquals("plus(max(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2),plus(-89.0,4.0x))",arrComFun[4].toString());
        assertEquals("plus(mul(2.0x^4-6.0x^2-7.0,1.0x^3+1.0x^2),div(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2))",arrComFun[17].toString());
        assertEquals("plus(min(-89.0,4.0x),comp(-5.0x^2+6.0x-17.0,4.0x^4))",arrComFun[8].toString());
        assertEquals("plus(max(-1.0x^2,777.0),comp(-1.0x^2,777.0))",arrComFun[3].toString());
        assertEquals("plus(min(1.0x^4-1.0x^3-1.0x^2,-5.0x^2+6.0x-17.0),div(77.0x^4,3.0x))",arrComFun[7].toString());
        assertEquals("plus(plus(-5.0x^2+6.0x-17.0,4.0x^4),mul(1.0x^4-1.0x^3-1.0x^2,4.0x))",arrComFun[1].toString());
        assertEquals("plus(mul(9.0x^7,777.0),min(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[16].toString());


//        ComplexFunction c0= new ComplexFunction(f0);
//        assertEquals("2.0x^2+4.0",c0.left().toString());
//        assertNull(c0.right());
//        assertEquals("None",c0.getOp().toString());
//
//        c0.plus(f1);
//        assertEquals("Plus",c0.getOp().toString());
//        assertEquals("plus(2.0x^2+4.0,8.0x^2+6.0)",c0.toString());
//        assertNotNull(c0.left());
//        assertNotNull(c0.right());


}

    @Test
    public void mul() {
        arrComFun[5].mul(arrComFun[14]);
        arrComFun[2].mul(arrComFun[10]);
        arrComFun[4].mul(arrComFun[0]);
        arrComFun[17].mul(arrComFun[12]);
        arrComFun[8].mul(arrComFun[9]);
        arrComFun[3].mul(arrComFun[11]);
        arrComFun[7].mul(arrComFun[13]);
        arrComFun[1].mul(arrComFun[15]);
        arrComFun[16].mul(arrComFun[6]);
        assertEquals("mul(max(77.0x^4,3.0x),div(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[5].toString());
        assertEquals("mul(max(77.0x^4,3.0x),div(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[5].toString());
        assertEquals("mul(plus(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0),comp(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0))",arrComFun[2].toString());
        assertEquals("mul(max(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2),plus(-89.0,4.0x))",arrComFun[4].toString());
        assertEquals("mul(mul(2.0x^4-6.0x^2-7.0,1.0x^3+1.0x^2),div(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2))",arrComFun[17].toString());
        assertEquals("mul(min(-89.0,4.0x),comp(-5.0x^2+6.0x-17.0,4.0x^4))",arrComFun[8].toString());
        assertEquals("mul(max(-1.0x^2,777.0),comp(-1.0x^2,777.0))",arrComFun[3].toString());
        assertEquals("mul(min(1.0x^4-1.0x^3-1.0x^2,-5.0x^2+6.0x-17.0),div(77.0x^4,3.0x))",arrComFun[7].toString());
        assertEquals("mul(plus(-5.0x^2+6.0x-17.0,4.0x^4),mul(1.0x^4-1.0x^3-1.0x^2,4.0x))",arrComFun[1].toString());
        assertEquals("mul(mul(9.0x^7,777.0),min(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[16].toString());

//        ComplexFunction c0= new ComplexFunction(f0);
//        c0.mul(f1);
//        assertEquals("Times",c0.getOp().toString());
//        assertEquals("mul(2.0x^2+4.0,8.0x^2+6.0)",c0.toString());
//        assertNotNull(c0.left());
//        assertNotNull(c0.right());
    }

    @Test
    public void div() {
        arrComFun[5].div(arrComFun[14]);
        arrComFun[2].div(arrComFun[10]);
        arrComFun[4].div(arrComFun[0]);
        arrComFun[17].div(arrComFun[12]);
        arrComFun[8].div(arrComFun[9]);
        arrComFun[3].div(arrComFun[11]);
        arrComFun[7].div(arrComFun[13]);
        arrComFun[1].div(arrComFun[15]);
        arrComFun[16].div(arrComFun[6]);
        assertEquals("div(max(77.0x^4,3.0x),div(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[5].toString());
        assertEquals("div(plus(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0),comp(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0))",arrComFun[2].toString());
        assertEquals("div(max(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2),plus(-89.0,4.0x))",arrComFun[4].toString());
        assertEquals("div(mul(2.0x^4-6.0x^2-7.0,1.0x^3+1.0x^2),div(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2))",arrComFun[17].toString());
        assertEquals("div(min(-89.0,4.0x),comp(-5.0x^2+6.0x-17.0,4.0x^4))",arrComFun[8].toString());
        assertEquals("div(max(-1.0x^2,777.0),comp(-1.0x^2,777.0))",arrComFun[3].toString());
        assertEquals("div(min(1.0x^4-1.0x^3-1.0x^2,-5.0x^2+6.0x-17.0),div(77.0x^4,3.0x))",arrComFun[7].toString());
        assertEquals("div(plus(-5.0x^2+6.0x-17.0,4.0x^4),mul(1.0x^4-1.0x^3-1.0x^2,4.0x))",arrComFun[1].toString());
        assertEquals("div(mul(9.0x^7,777.0),min(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[16].toString());

//        ComplexFunction c0= new ComplexFunction(f0);
//        c0.div(f1);
//        assertEquals("Divid",c0.getOp().toString());
//        assertEquals("div(2.0x^2+4.0,8.0x^2+6.0)",c0.toString());
//        assertNotNull(c0.left());
//        assertNotNull(c0.right());
    }

    @Test
    public void max() {
        arrComFun[5].max(arrComFun[14]);
        arrComFun[2].max(arrComFun[10]);
        arrComFun[4].max(arrComFun[0]);
        arrComFun[17].max(arrComFun[12]);
        arrComFun[8].max(arrComFun[9]);
        arrComFun[3].max(arrComFun[11]);
        arrComFun[7].max(arrComFun[13]);
        arrComFun[1].max(arrComFun[15]);
        arrComFun[16].max(arrComFun[6]);
        assertEquals("max(max(77.0x^4,3.0x),div(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[5].toString());
        assertEquals("max(plus(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0),comp(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0))",arrComFun[2].toString());
        assertEquals("max(max(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2),plus(-89.0,4.0x))",arrComFun[4].toString());
        assertEquals("max(mul(2.0x^4-6.0x^2-7.0,1.0x^3+1.0x^2),div(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2))",arrComFun[17].toString());
        assertEquals("max(min(-89.0,4.0x),comp(-5.0x^2+6.0x-17.0,4.0x^4))",arrComFun[8].toString());
        assertEquals("max(max(-1.0x^2,777.0),comp(-1.0x^2,777.0))",arrComFun[3].toString());
        assertEquals("max(min(1.0x^4-1.0x^3-1.0x^2,-5.0x^2+6.0x-17.0),div(77.0x^4,3.0x))",arrComFun[7].toString());
        assertEquals("max(plus(-5.0x^2+6.0x-17.0,4.0x^4),mul(1.0x^4-1.0x^3-1.0x^2,4.0x))",arrComFun[1].toString());
        assertEquals("max(mul(9.0x^7,777.0),min(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[16].toString());

//        ComplexFunction c0= new ComplexFunction(f0);
//        c0.max(f1);
//        assertEquals("Max",c0.getOp().toString());
//        assertEquals("max(2.0x^2+4.0,8.0x^2+6.0)",c0.toString());
//        assertNotNull(c0.left());
//        assertNotNull(c0.right());
    }

    @Test
    public void min() {
        arrComFun[5].min(arrComFun[14]);
        arrComFun[2].min(arrComFun[10]);
        arrComFun[4].min(arrComFun[0]);
        arrComFun[17].min(arrComFun[12]);
        arrComFun[8].min(arrComFun[9]);
        arrComFun[3].min(arrComFun[11]);
        arrComFun[7].min(arrComFun[13]);
        arrComFun[1].min(arrComFun[15]);
        arrComFun[16].min(arrComFun[6]);
        assertEquals("min(max(77.0x^4,3.0x),div(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[5].toString());
        assertEquals("min(plus(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0),comp(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0))",arrComFun[2].toString());
        assertEquals("min(max(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2),plus(-89.0,4.0x))",arrComFun[4].toString());
        assertEquals("min(mul(2.0x^4-6.0x^2-7.0,1.0x^3+1.0x^2),div(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2))",arrComFun[17].toString());
        assertEquals("min(min(-89.0,4.0x),comp(-5.0x^2+6.0x-17.0,4.0x^4))",arrComFun[8].toString());
        assertEquals("min(max(-1.0x^2,777.0),comp(-1.0x^2,777.0))",arrComFun[3].toString());
        assertEquals("min(min(1.0x^4-1.0x^3-1.0x^2,-5.0x^2+6.0x-17.0),div(77.0x^4,3.0x))",arrComFun[7].toString());
        assertEquals("min(plus(-5.0x^2+6.0x-17.0,4.0x^4),mul(1.0x^4-1.0x^3-1.0x^2,4.0x))",arrComFun[1].toString());
        assertEquals("min(mul(9.0x^7,777.0),min(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[16].toString());


//        ComplexFunction c0= new ComplexFunction(f0);
//        c0.min(f1);
//        assertEquals("Min",c0.getOp().toString());
//        assertEquals("min(2.0x^2+4.0,8.0x^2+6.0)",c0.toString());
//        assertNotNull(c0.left());
//        assertNotNull(c0.right());
    }

    @Test
    public void comp() {
            arrComFun[5].comp(arrComFun[14]);
            arrComFun[2].comp(arrComFun[10]);
            arrComFun[4].comp(arrComFun[0]);
            arrComFun[17].comp(arrComFun[12]);
            arrComFun[8].comp(arrComFun[9]);
            arrComFun[3].comp(arrComFun[11]);
            arrComFun[7].comp(arrComFun[13]);
            arrComFun[1].comp(arrComFun[15]);
            arrComFun[16].comp(arrComFun[6]);
        assertEquals("comp(max(77.0x^4,3.0x),div(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[5].toString());
        assertEquals("comp(plus(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0),comp(3.0x^5+5.0x^3+4.0x+23.0,2.0x^4-6.0x^2-7.0))",arrComFun[2].toString());
        assertEquals("comp(max(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2),plus(-89.0,4.0x))",arrComFun[4].toString());
        assertEquals("comp(mul(2.0x^4-6.0x^2-7.0,1.0x^3+1.0x^2),div(1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x,1.0x^3+1.0x^2))",arrComFun[17].toString());
        assertEquals("comp(min(-89.0,4.0x),comp(-5.0x^2+6.0x-17.0,4.0x^4))",arrComFun[8].toString());
        assertEquals("comp(max(-1.0x^2,777.0),comp(-1.0x^2,777.0))",arrComFun[3].toString());
        assertEquals("comp(min(1.0x^4-1.0x^3-1.0x^2,-5.0x^2+6.0x-17.0),div(77.0x^4,3.0x))",arrComFun[7].toString());
        assertEquals("comp(plus(-5.0x^2+6.0x-17.0,4.0x^4),mul(1.0x^4-1.0x^3-1.0x^2,4.0x))",arrComFun[1].toString());
        assertEquals("comp(mul(9.0x^7,777.0),min(9.0x^7,-14.0x^5+15.0x^4))",arrComFun[16].toString());

//        ComplexFunction c0= new ComplexFunction(f0);
//        c0.comp(f1);
//        assertEquals("Comp",c0.getOp().toString());
//        assertEquals("comp(2.0x^2+4.0,8.0x^2+6.0)",c0.toString());
//        assertNotNull(c0.left());
//        assertNotNull(c0.right());
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
        String toInit = "plus(div(9.0x^7,-14.0x^5+15.0x^4),1.0x^2)";
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

    @Test
    public void equals() {
        function f0=new Monom("2x");
        function f1=new Monom("x");
        function f2=new Monom("x");
        ComplexFunction c = new ComplexFunction(f0);
        ComplexFunction c1 = new ComplexFunction("plus",f1,f2);
        assertTrue(c.equals(c1));

    }

}