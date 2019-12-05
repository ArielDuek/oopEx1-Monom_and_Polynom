package Tests;

import Ex1.Monom;
import Ex1.function;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.*;

public class MonomTest {

    static  Monom [] arrMonomsFromString =new Monom[15];
    static  Monom [] arrMonomsFromConstructorMonom =new Monom[15];

    //Here we will create all the monoms for testing the methods
    @BeforeClass
    public static void BeforeAll()
    {
        //Build the monoms with the help of the monom string constructor
        arrMonomsFromString[0]=new Monom ("0");
        arrMonomsFromString[1]=new Monom ("15");
        arrMonomsFromString[2]=new Monom ("15.5");
        arrMonomsFromString[3]=new Monom ("x");
        arrMonomsFromString[4]=new Monom ("-x");
        arrMonomsFromString[5]=new Monom ("+x");
        arrMonomsFromString[6]=new Monom ("4.5x");
        arrMonomsFromString[7]=new Monom ("2.5x");
        arrMonomsFromString[8]=new Monom ("-4.5x");
        arrMonomsFromString[9]=new Monom ("-2.5x");
        arrMonomsFromString[10]=new Monom ("2x^2");
        arrMonomsFromString[11]=new Monom ("6.7x^5");
        arrMonomsFromString[12]=new Monom ("-9x^7");
        arrMonomsFromString[13]=new Monom ("8x^7");
        arrMonomsFromString[14]=new Monom ("0X^90");

        //Build the monoms with the help of a constructor that receives parameters to build monom
        arrMonomsFromConstructorMonom[0]=new Monom (0.0,0);
        arrMonomsFromConstructorMonom[1]=new Monom (15.0,0);
        arrMonomsFromConstructorMonom[2]=new Monom (15.5,0);
        arrMonomsFromConstructorMonom[3]=new Monom (1.0,1);
        arrMonomsFromConstructorMonom[4]=new Monom (-1.0,1);
        arrMonomsFromConstructorMonom[5]=new Monom (1.0,1);
        arrMonomsFromConstructorMonom[6]=new Monom (4.5,1);
        arrMonomsFromConstructorMonom[7]=new Monom (2.5,1);
        arrMonomsFromConstructorMonom[8]=new Monom (-4.5,1);
        arrMonomsFromConstructorMonom[9]=new Monom (-2.5,1);
        arrMonomsFromConstructorMonom[10]=new Monom (2.0,2);
        arrMonomsFromConstructorMonom[11]=new Monom (6.7,5);
        arrMonomsFromConstructorMonom[12]=new Monom (-9.0,7);
        arrMonomsFromConstructorMonom[13]=new Monom (8.0,7);
        arrMonomsFromConstructorMonom[14]=new Monom (0.0,90);
    }

    /**
     * Tests the constructor that receives parameters for building monom
     */
    @Test
    public void Monom() {
        /*
        Create new monoms in order to compare them with the monoms in the array
         */
        Monom m50 =new Monom (0.0,0);
        Monom m51 =new Monom (15.0,0);
        Monom m52 =new Monom (15.5,0);
        Monom m53 =new Monom (1.0,1);
        Monom m54 =new Monom (-1.0,1);
        Monom m55 =new Monom (1.0,1);
        Monom m56 =new Monom (4.5,1);
        Monom m57 =new Monom (2.5,1);
        Monom m58 =new Monom (-4.5,1);
        Monom m59 =new Monom (-2.5,1);
        Monom m60 =new Monom (2.0,2);
        Monom m61 =new Monom (6.7,5);
        Monom m62 =new Monom (-9.0,7);
        Monom m63 =new Monom (8.0,7);
        Monom m64 =new Monom (0.0,90);

        Monom notEqual=new Monom(100,0);

        Monom[] expected0={m50,m51,m52,m53,m54,m55,m56,m57,m58,m59,m60,m61,m62,m63,m64};
        String[] temp={"0.0","15.0","15.5","1.0x","-1.0x","1.0x","4.5x","2.5x","-4.5x","-2.5x","2.0x^2","6.7X^5","-9.0x^7","8.0x^7","0.0x^90"};
        Monom[] expected1=new Monom[15];
        for (int i = 0; i <expected1.length ; i++) {
            expected1[i]=new Monom(temp[i]);
        }
        //The comparison
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertEquals(expected0[i],arrMonomsFromConstructorMonom[i]);
            assertEquals(expected1[i],arrMonomsFromString[i]);
        }

        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertNotEquals(notEqual,arrMonomsFromConstructorMonom[i]);
            assertNotEquals(notEqual,arrMonomsFromString[i]);
        }

        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertNotNull(null,arrMonomsFromConstructorMonom[i]);
            assertNotNull(null,arrMonomsFromString[i]);
        }

    }


    /**
     * Checks whether the get_coefficient returns the correct coefficient from the monom
     */
    @Test
    public void get_coefficient() {
        double[] expected ={0.0,15.0,15.5,1.0,-1.0,1.0,4.5,2.5,-4.5,-2.5,2.0,6.7,-9,8.0,0.0};

        /*Checks whether the get_coefficient returns the correct coefficient from the constructor
         that accepts a string*/
        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expected[i],arrMonomsFromString[i].get_coefficient(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromString[i].get_coefficient(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotNull(null,arrMonomsFromString[i].get_coefficient());
        }

        /*Checks whether the get_coefficient returns the correct coefficient from the constructor
         that accepts a parameters*/
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].get_coefficient(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromConstructorMonom[i].get_coefficient(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotNull(null,arrMonomsFromConstructorMonom[i].get_coefficient());
        }

    }

    /**
     * Checks whether the get_power returns the correct power from the monom
     */
    @Test
    public void get_power() {
        int[] expected ={0,0,0,1,1,1,1,1,1,1,2,5,7,7,90};

       /*Checks whether the get_power() returns the correct power from the constructor
         that accepts a String*/
        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expected[i],arrMonomsFromString[i].get_power(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromString[i].get_power(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotNull(null,arrMonomsFromString[i].get_power());
        }

        /*Checks whether the get_power() returns the correct power from the constructor
         that accepts a parameters*/
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].get_power(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromConstructorMonom[i].get_power(),Monom.EPSILON);
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotNull(null,arrMonomsFromConstructorMonom[i].get_power());
        }

    }

    /**
     * Checks whether the derivative returns the correct derivative for the monom
     */
    @Test
    public void derivative() {
        /*
        Create new monoms in order to compare them with The result of the function derivative
         */
        Monom dm20 =new Monom (0.0,0);
        Monom dm21 =new Monom (0.0,0);
        Monom dm22 =new Monom (0.0,0);
        Monom dm23 =new Monom (1.0,0);
        Monom dm24 =new Monom (-1.0,0);
        Monom dm25 =new Monom (1.0,0);
        Monom dm26 =new Monom (4.5,0);
        Monom dm27 =new Monom (2.5,0);
        Monom dm28 =new Monom (-4.5,0);
        Monom dm29 =new Monom (-2.5,0);
        Monom dm30 =new Monom (4.0,1);
        Monom dm31 =new Monom (33.5,4);
        Monom dm32 =new Monom (-63.0,6);
        Monom dm33 =new Monom (56.0,6);
        Monom dm34 =new Monom (0.0,89);

        Monom notEquals=new Monom(100.0,0);

        Monom[] expected={dm20,dm21,dm22,dm23,dm24,dm25,dm26,dm27,dm28,dm29,dm30,dm31,dm32,dm33,dm34};

        /*Checks whether the function of derivative returns the correct derivative for the constructor
         that accepts a String*/
        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expected[i],arrMonomsFromString[i].derivative());
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals(notEquals,arrMonomsFromString[i].derivative());
        }

        /*Checks whether the function of derivative returns the correct derivative for the constructor
         that accepts a parameters*/
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].derivative());
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals(notEquals,arrMonomsFromConstructorMonom[i].derivative());
        }






    }

    @Test
    public void f() {
        //Checks the point value at x=1
        double[] expectedFor1 ={0.0,15.0,15.5,1.0,-1.0,1.0,4.5,2.5,-4.5,-2.5,2,6.7,-9.0,8.0,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedFor1[i],arrMonomsFromString[i].f(1),Monom.EPSILON);
        }

        //Checks the point value at x=5
        double[] expectedFor5 ={0.0,15.0,15.5,5.0,-5.0,5.0,22.5,12.5,-22.5,-12.5,50,20937.5,-703125.0,625000,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedFor5[i],arrMonomsFromString[i].f(5),Monom.EPSILON);
        }

        //Checks the point value at x=5.55
        double[] expectedFor5_55 ={0.0,15.0,15.5,5.55,-5.55,5.55,24.975,13.875,-24.975,-13.875,61.605,35280.90512,-1459800.108,1297600.096,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedFor5_55[i],arrMonomsFromString[i].f(5.55),0.01);
        }

        //Checks the point value at x=-5.55
        double[] expectedForMinus5_55 ={0.0,15.0,15.5,-5.55,5.55,-5.55,-24.975,-13.875,24.975,13.875,61.605,-35280.90512,1459800.108,-1297600.096,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedForMinus5_55[i],arrMonomsFromString[i].f(-5.55),0.01);
        }

    }

    /**
     * Tests the function whether zero is working properly,
     * That is, the function can detect whether the monom is zero or not.
     */
    @Test
    public void isZero() {
        Monom zeroByParamets=new Monom(0.0,0);
        Monom zeroByString=new Monom("0");

        assertEquals(zeroByParamets,arrMonomsFromString[0]);
        assertEquals(zeroByString,arrMonomsFromString[0]);
        assertEquals(zeroByParamets,arrMonomsFromConstructorMonom[0]);
        assertEquals(zeroByString,arrMonomsFromConstructorMonom[0]);

        assertNotEquals(100,arrMonomsFromString[0]);
        assertNotEquals(100,arrMonomsFromConstructorMonom[0]);

        assertNotNull(null,arrMonomsFromString[0]);
        assertNotNull(null,arrMonomsFromConstructorMonom[0]);
    }

    /**
    Checks whether the connection between two monomers is performed properly
     */
    @Test
    public void add() {
        Monom addForPower0=new Monom("2");
        Monom addForPower1=new Monom("x");
        Monom addForPower2=new Monom("2x^2");
        Monom addForPower5=new Monom("2x^5");
        Monom addForPower7=new Monom("2x^7");
        Monom addForPower90=new Monom("2x^90");

        Monom am0 =new Monom ("0");
        Monom am1 =new Monom ("15");
        Monom am2 =new Monom ("15.5");
        Monom am3 =new Monom ("x");
        Monom am4 =new Monom ("-x");
        Monom am5 =new Monom ("+x");
        Monom am6 =new Monom ("4.5x");
        Monom am7 =new Monom ("2.5x");
        Monom am8 =new Monom ("-4.5x");
        Monom am9 =new Monom ("-2.5x");
        Monom am10 =new Monom ("2x^2");
        Monom am11 =new Monom ("6.7x^5");
        Monom am12 =new Monom ("-9x^7");
        Monom am13 =new Monom ("8x^7");
        Monom am14 =new Monom ("0X^90");

        Monom[] AddArrMonomsFromString={am0,am1,am2,am3,am4,am5,am6,am7,am8,am9,am10,am11,am12,am13,am14};

        AddArrMonomsFromString[0].add(addForPower0);
        AddArrMonomsFromString[1].add(addForPower0);
        AddArrMonomsFromString[2].add(addForPower0);
        AddArrMonomsFromString[3].add(addForPower1);
        AddArrMonomsFromString[4].add(addForPower1);
        AddArrMonomsFromString[5].add(addForPower1);
        AddArrMonomsFromString[6].add(addForPower1);
        AddArrMonomsFromString[7].add(addForPower1);
        AddArrMonomsFromString[8].add(addForPower1);
        AddArrMonomsFromString[9].add(addForPower1);
        AddArrMonomsFromString[10].add(addForPower2);
        AddArrMonomsFromString[11].add(addForPower5);
        AddArrMonomsFromString[12].add(addForPower7);
        AddArrMonomsFromString[13].add(addForPower7);
        AddArrMonomsFromString[14].add(addForPower90);

        assertEquals("2.0",AddArrMonomsFromString[0].toString());
        assertEquals("17.0",AddArrMonomsFromString[1].toString());
        assertEquals("17.5",AddArrMonomsFromString[2].toString());
        assertEquals("2.0x",AddArrMonomsFromString[3].toString());
        assertEquals("0.0x",AddArrMonomsFromString[4].toString());
        assertEquals("2.0x",AddArrMonomsFromString[5].toString());
        assertEquals("5.5x",AddArrMonomsFromString[6].toString());
        assertEquals("3.5x",AddArrMonomsFromString[7].toString());
        assertEquals("-3.5x",AddArrMonomsFromString[8].toString());
        assertEquals("-1.5x",AddArrMonomsFromString[9].toString());
        assertEquals("4.0x^2",AddArrMonomsFromString[10].toString());
        assertEquals("8.7x^5",AddArrMonomsFromString[11].toString());
        assertEquals("-7.0x^7",AddArrMonomsFromString[12].toString());
        assertEquals("10.0x^7",AddArrMonomsFromString[13].toString());
        assertEquals("2.0x^90",AddArrMonomsFromString[14].toString());

        assertNotEquals("100.0",AddArrMonomsFromString[0].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[1].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[2].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[3].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[4].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[5].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[6].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[7].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[8].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[9].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[10].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[11].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[12].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[13].toString());
        assertNotEquals("100.0",AddArrMonomsFromString[14].toString());
    }

    /**
     Checks whether the multipy between two monomers is performed properly
     */
    @Test
    public void multipy() {
        Monom mm0 =new Monom ("0");
        Monom mm1 =new Monom ("15");
        Monom mm2 =new Monom ("15.5");
        Monom mm3 =new Monom ("x");
        Monom mm4 =new Monom ("-x");
        Monom mm5 =new Monom ("+x");
        Monom mm6 =new Monom ("4.5x");
        Monom mm7 =new Monom ("2.5x");
        Monom mm8 =new Monom ("-4.5x");
        Monom mm9 =new Monom ("-2.5x");
        Monom mm10 =new Monom ("2x^2");
        Monom mm11 =new Monom ("6.7x^5");
        Monom mm12 =new Monom ("-9x^7");
        Monom mm13 =new Monom ("8x^7");
        Monom mm14 =new Monom ("0X^90");

        Monom MulMonom =new Monom ("2.55x^2");

        Monom[] MulArrMonomsFromString={mm0,mm1,mm2,mm3,mm4,mm5,mm6,mm7,mm8,mm9,mm10,mm11,mm12,mm13,mm14};

        for (int i = 0; i <MulArrMonomsFromString.length ; i++) {
            MulArrMonomsFromString[i].multipy(MulMonom);
        }

        String[] expected={"0.0","38.25x^2","39.525x^2","2.55x^3","-2.55x^3","2.55x^3","11.475x^3","6.375x^3","-11.475x^3","-6.375x^3","5.1x^4","17.085x^7","-22.95x^9","20.4x^9","0.0"};

        for (int i = 0; i <MulArrMonomsFromString.length ; i++) {
            assertEquals(expected[i],MulArrMonomsFromString[i].toString());
        }

        for (int i = 0; i <MulArrMonomsFromString.length ; i++) {
            assertNotEquals(MulMonom.toString(),MulArrMonomsFromString[i].toString());
        }

    }

    /**
     * Checks whether the print function is working properly
     */
    @Test
    public void testToString() {

        String[] expected={"0.0","15.0","15.5","1.0x","-1.0x","1.0x","4.5x","2.5x","-4.5x","-2.5x","2.0x^2","6.7x^5","-9.0x^7","8.0x^7","0.0X^90"};

        for (int i = 0; i <arrMonomsFromString.length-1 ; i++) {
            assertEquals(expected[i],arrMonomsFromString[i].toString());
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length-1; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].toString());
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals("100",arrMonomsFromString[i].toString());
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals("100",arrMonomsFromConstructorMonom[i].toString());
        }

    }

    /**
     * Checks whether the Equals function properly compares two monomers
     */
    @Test
    public void testEquals() {

        Monom notEqual=new Monom(100,0);

        //Checks whether identical and constant arrays are equal
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertTrue(arrMonomsFromConstructorMonom[i].equals(arrMonomsFromString[i]));
            assertTrue(arrMonomsFromString[i].equals(arrMonomsFromConstructorMonom[i]));
        }

        //Checks whether the cells in the arrays are identical and the constants are essentially monomers equal to each other
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertFalse(arrMonomsFromConstructorMonom[i].equals(notEqual));
            assertFalse(arrMonomsFromString[i].equals(notEqual));
        }
    }

    /**
     * Checks whether the copy function properly Copying monom to function
     */
    @Test
    public void copy() {
        /*
        Creating an array how is a copy of monoms that created from a string, this array is an array of objects type function
         */
        function [] arrf=new function[15];
        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            arrf[i]=(arrMonomsFromString[i].copy());
        }

        /*
        Checks whether each cell in the array is a function instance
        Checks whether the coefficient of each function is equal to the coefficient of the monom from which it was copied.
        Checks whether the power of each function equals the power of the monom from which it was copied.
         */
        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertTrue(arrf[i] instanceof function);
            assertTrue(arrf[i] instanceof Monom);
            assertEquals(arrMonomsFromString[i].get_coefficient(),((Monom)arrf[i]).get_coefficient(),Monom.EPSILON);
            assertEquals(arrMonomsFromString[i].get_power(),((Monom)arrf[i]).get_power(),Monom.EPSILON);
        }

    }

    @Test
    public void initFromString() {
        String[] s={"0.0","15.0","15.5","1.0x","-1.0x","1.0x","4.5x","2.5x","-4.5x","-2.5x","2.0x^2","6.7x^5","-9.0x^7","8.0x^7","0.0X^90"};
        /*
        Creating an function array from the array of the strings
         */
        function [] arrf=new function[15];
        for (int i = 0; i <s.length ; i++) {
            arrf[i]=(arrMonomsFromString[i].initFromString(s[i]));
        }

        /*
        Checks whether each cell in the array is a function instance.
        Checks whether the coefficient of each function is equal to the coefficient of the monom,
        Because the string arry is the same as the monom values
        Checks whether the power of each function equals the power of the monom,
        Because the string arry is the same as the monom values
         */
        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertTrue(arrf[i] instanceof function);
            assertTrue(arrf[i] instanceof Monom);
            assertEquals(arrMonomsFromString[i].get_coefficient(),((Monom)arrf[i]).get_coefficient(),Monom.EPSILON);
            assertEquals(arrMonomsFromString[i].get_power(),((Monom)arrf[i]).get_power(),Monom.EPSILON);
        }

    }

}