package Tests;

import Ex1.*;
import org.junit.Before;
import org.junit.Test;
import java.util.function.Function;

import static org.junit.Assert.*;

public class MonomTest {

    static  Monom [] arrMonomsFromString =new Monom[15];
    static  Monom [] arrMonomsFromConstructorMonom =new Monom[15];

    //Here we will create all the monoms for testing the methods
    @Before
    public void BeforeEach() {
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
     * Tests the constructor that receives parameters for building monom and the constructor
     * that receives string for building monom
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

        String[] temp={"0.0","15.0","15.5","1.0x","-1.0x","1.0x","4.5x","2.5x","-4.5x","-2.5x","2.0x^2","6.7x^5","-9.0x^7","8.0x^7","0.0x^90"};

        Monom[] expected0={m50,m51,m52,m53,m54,m55,m56,m57,m58,m59,m60,m61,m62,m63,m64};
        Monom[] expected1=new Monom[15];

        //A loop that creates from the array of strings "temp" monomes
        for (int i = 0; i <expected1.length ; i++) {
            expected1[i]=new Monom(temp[i]);
        }

        //The comparison
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertEquals(expected0[i],arrMonomsFromConstructorMonom[i]);
            assertEquals(expected1[i],arrMonomsFromConstructorMonom[i]);
            assertEquals(temp[i],arrMonomsFromConstructorMonom[i].toString());

            assertEquals(expected0[i],arrMonomsFromString[i]);
            assertEquals(expected1[i],arrMonomsFromString[i]);
            assertEquals(temp[i],arrMonomsFromString[i].toString());
        }

        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertNotEquals(notEqual,arrMonomsFromConstructorMonom[i]);
            assertNotEquals(notEqual.toString(),arrMonomsFromConstructorMonom[i].toString());

            assertNotEquals(notEqual,arrMonomsFromString[i]);
            assertNotEquals(notEqual.toString(),arrMonomsFromString[i].toString());
        }

        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertNotNull(null,arrMonomsFromConstructorMonom[i]);
            assertNotNull(null,arrMonomsFromString[i]);
        }

        /*Errors must be thrown errString.length times.
        In this test, we check that representatives of all the wrong inputs actually return an error
        */
        String[] errString={"7tl","","8*9","3/5","4..4","6-7","(6-7)","(2+2)x^4","x^2*3","3t","3t^7","x*x","2x ^7","2x^ 7","   5x^7   ","4 5","(9+9)","x^-7"};
        int counter=0;
        for (int i = 0; i <errString.length ; i++) {
            try{
                Monom m=new Monom(errString[i]);
            }
            catch ( RuntimeException e)
            {
                counter++;
                continue;

            }
        }

        assertEquals(errString.length,counter);

    }

    @Test
    public void CopyMonom()
    {
        Monom [] copy=new Monom[15];
        /*Copies the regular monoms of tests from the array with the help of the copy constructor
        and put them in the the array called copy*/
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            copy[i]=new Monom(arrMonomsFromConstructorMonom[i]);
        }

        /*
        Checks whether copying has been successful by comparing the coefficients and holdings of the monomers
         */
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertEquals(arrMonomsFromConstructorMonom[i].get_coefficient(),copy[i].get_coefficient(),Monom.EPSILON);
            assertEquals(arrMonomsFromConstructorMonom[i].get_power(),copy[i].get_power());
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

    /**
     *Checks whether function f returns the correct Y value to X values
     * Note that in some cases the delta should have been larger (0.001)
     */
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
            assertEquals(expectedFor5_55[i],arrMonomsFromString[i].f(5.55),0.001);
        }

        //Checks the point value at x=-5.55
        double[] expectedForMinus5_55 ={0.0,15.0,15.5,-5.55,5.55,-5.55,-24.975,-13.875,24.975,13.875,61.605,-35280.90512,1459800.108,-1297600.096,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedForMinus5_55[i],arrMonomsFromString[i].f(-5.55),0.001);
        }

    }

    /**
     * Tests the function whether iszero working properly,
     * That is, the function can detect whether the monom is zero or not.
     */
    @Test
    public void isZero() {
        Monom zeroByParamets=new Monom(0.0,0);
        Monom zeroByString=new Monom("0");
        String s="0.0";

        assertEquals(zeroByParamets,arrMonomsFromString[0]);
        assertEquals(zeroByString,arrMonomsFromString[0]);
        assertEquals(s,arrMonomsFromString[0].toString());

        assertEquals(zeroByParamets,arrMonomsFromConstructorMonom[0]);
        assertEquals(zeroByString,arrMonomsFromConstructorMonom[0]);
        assertEquals(s,arrMonomsFromConstructorMonom[0].toString());

        assertNotEquals(100,arrMonomsFromString[0]);
        assertNotEquals(100,arrMonomsFromConstructorMonom[0]);

        assertNotNull(null,arrMonomsFromString[0]);
        assertNotNull(null,arrMonomsFromConstructorMonom[0]);
    }

    /**
     Checks whether the connection between two monoms is performed properly
     */
    @Test
    public void add() {
        Monom addForPower0=new Monom("2");
        Monom addForPower1=new Monom("x");
        Monom addForPower2=new Monom("2x^2");
        Monom addForPower5=new Monom("2x^5");
        Monom addForPower7=new Monom("2x^7");
        Monom addForPower90=new Monom("2x^90");

        //Connecting monomies with the same strong monomers
        arrMonomsFromString[0].add(addForPower0);
        arrMonomsFromString[1].add(addForPower0);
        arrMonomsFromString[2].add(addForPower0);
        arrMonomsFromString[3].add(addForPower1);
        arrMonomsFromString[4].add(addForPower1);
        arrMonomsFromString[5].add(addForPower1);
        arrMonomsFromString[6].add(addForPower1);
        arrMonomsFromString[7].add(addForPower1);
        arrMonomsFromString[8].add(addForPower1);
        arrMonomsFromString[9].add(addForPower1);
        arrMonomsFromString[10].add(addForPower2);
        arrMonomsFromString[11].add(addForPower5);
        arrMonomsFromString[12].add(addForPower7);
        arrMonomsFromString[13].add(addForPower7);
        arrMonomsFromString[14].add(addForPower90);

        String[] expected={"2.0","17.0","17.5","2.0x","0.0x","2.0x","5.5x","3.5x","-3.5x","-1.5x","4.0x^2","8.7x^5","-7.0x^7","10.0x^7","2.0x^90"};
        for (int i = 0; i <arrMonomsFromString.length; i++) {
            assertEquals(expected[i],arrMonomsFromString[i].toString());
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals("100.0",arrMonomsFromConstructorMonom[i].toString());
        }

        //Connecting monomies with the same strong monomers
        arrMonomsFromConstructorMonom[0].add(addForPower0);
        arrMonomsFromConstructorMonom[1].add(addForPower0);
        arrMonomsFromConstructorMonom[2].add(addForPower0);
        arrMonomsFromConstructorMonom[3].add(addForPower1);
        arrMonomsFromConstructorMonom[4].add(addForPower1);
        arrMonomsFromConstructorMonom[5].add(addForPower1);
        arrMonomsFromConstructorMonom[6].add(addForPower1);
        arrMonomsFromConstructorMonom[7].add(addForPower1);
        arrMonomsFromConstructorMonom[8].add(addForPower1);
        arrMonomsFromConstructorMonom[9].add(addForPower1);
        arrMonomsFromConstructorMonom[10].add(addForPower2);
        arrMonomsFromConstructorMonom[11].add(addForPower5);
        arrMonomsFromConstructorMonom[12].add(addForPower7);
        arrMonomsFromConstructorMonom[13].add(addForPower7);
        arrMonomsFromConstructorMonom[14].add(addForPower90);

        for (int i = 0; i <arrMonomsFromConstructorMonom.length; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].toString());
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals("100.0",arrMonomsFromString[i].toString());
        }


        /*
         *Connecting monomers with different power to monomers.Need to throw arrMonomsFromConstructorMonom.length errors
         */
        int counter=0;

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            try{

                arrMonomsFromConstructorMonom[0].add(addForPower1);
                arrMonomsFromConstructorMonom[1].add(addForPower1);
                arrMonomsFromConstructorMonom[2].add(addForPower1);
                arrMonomsFromConstructorMonom[3].add(addForPower7);
                arrMonomsFromConstructorMonom[4].add(addForPower7);
                arrMonomsFromConstructorMonom[5].add(addForPower7);
                arrMonomsFromConstructorMonom[6].add(addForPower7);
                arrMonomsFromConstructorMonom[7].add(addForPower7);
                arrMonomsFromConstructorMonom[8].add(addForPower7);
                arrMonomsFromConstructorMonom[9].add(addForPower7);
                arrMonomsFromConstructorMonom[10].add(addForPower7);
                arrMonomsFromConstructorMonom[11].add(addForPower7);
                arrMonomsFromConstructorMonom[12].add(addForPower5);
                arrMonomsFromConstructorMonom[13].add(addForPower5);
                arrMonomsFromConstructorMonom[14].add(addForPower5);
            }
            catch (RuntimeException e)
            {
                counter++;
                continue;
            }
        }
        assertEquals(arrMonomsFromConstructorMonom.length,counter);

        /*
         *Connecting monomers with different power to monomers.Need to throw arrMonomsFromString.length errors
         */
        counter=0;

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            try{

                arrMonomsFromString[0].add(addForPower1);
                arrMonomsFromString[1].add(addForPower1);
                arrMonomsFromString[2].add(addForPower1);
                arrMonomsFromString[3].add(addForPower7);
                arrMonomsFromString[4].add(addForPower7);
                arrMonomsFromString[5].add(addForPower7);
                arrMonomsFromString[6].add(addForPower7);
                arrMonomsFromString[7].add(addForPower7);
                arrMonomsFromString[8].add(addForPower7);
                arrMonomsFromString[9].add(addForPower7);
                arrMonomsFromString[10].add(addForPower7);
                arrMonomsFromString[11].add(addForPower7);
                arrMonomsFromString[12].add(addForPower5);
                arrMonomsFromString[13].add(addForPower5);
                arrMonomsFromString[14].add(addForPower5);
            }
            catch (RuntimeException e)
            {
                counter++;
                continue;
            }
        }
        assertEquals(arrMonomsFromString.length,counter);
    }

    /**
     Checks whether the multipy between two monomers is performed properly
     */
    @Test
    public void multipy() {
        Monom MulMonom =new Monom ("2.55x^2");

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            arrMonomsFromString[i].multipy(MulMonom);
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            arrMonomsFromConstructorMonom[i].multipy(MulMonom);
        }

        String[] expected={"0.0","38.25x^2","39.525x^2","2.55x^3","-2.55x^3","2.55x^3","11.475x^3","6.375x^3","-11.475x^3","-6.375x^3","5.1x^4","17.085x^7","-22.95x^9","20.4x^9","0.0"};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expected[i],arrMonomsFromString[i].toString());
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals(MulMonom.toString(),arrMonomsFromString[i].toString());
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].toString());
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals(MulMonom.toString(),arrMonomsFromConstructorMonom[i].toString());
        }

    }

    /**
     * Checks whether the print function is working properly
     */
    @Test
    public void testToString() {

        String[] expected={"0.0","15.0","15.5","1.0x","-1.0x","1.0x","4.5x","2.5x","-4.5x","-2.5x","2.0x^2","6.7x^5","-9.0x^7","8.0x^7","0.0x^90"};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expected[i],arrMonomsFromString[i].toString());
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length; i++) {
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
     *Checks that new function-type objects are created from the string
     */
    @Test
    public void initFromString() {
        String[] s = {"0.0", "15.0", "15.5", "1.0x", "-1.0x", "1.0x", "4.5x", "2.5x", "-4.5x", "-2.5x", "2.0x^2", "6.7x^5", "-9.0x^7", "8.0x^7", "0.0x^90"};
        /*
        Creating an function array from the array of the strings
         */
        function[] arrf = new function[15];
        for (int i = 0; i < s.length; i++) {
            arrf[i] = (arrMonomsFromString[i].initFromString(s[i]));
        }

        /*
        Checks whether each cell in the array is a function instance.
        Checks whether the coefficient of each function is equal to the coefficient of the monom,
        Because the string arry is the same as the monom values
        Checks whether the power of each function equals the power of the monom,
        Because the string arry is the same as the monom values
         */
        for (int i = 0; i < arrMonomsFromString.length; i++) {
            assertTrue(arrf[i] instanceof function);
            assertTrue(arrf[i] instanceof Monom);
            assertEquals(arrMonomsFromString[i].get_coefficient(), ((Monom) arrf[i]).get_coefficient(), Monom.EPSILON);
            assertEquals(arrMonomsFromString[i].get_power(), ((Monom) arrf[i]).get_power());
        }

        /*Errors must be thrown errString.length times.
        In this test, we check that representatives of all the wrong inputs actually return an error if we send them to the function initFromToString
        */
        String[] errString = {"7tl", "", "8*9", "3/5", "4..4", "6-7", "(6-7)", "(2+2)x^4", "x^2*3", "3t", "3t^7", "x*x", "2x ^7", "2x^ 7", "   5x^7   ", "4 5", "(9+9)"};
        function[] arrf1 = new function[15];
        int counter = 0;

        for (int j = 0; j < 17; j++) {
            try {
                for (int i = 0; i < errString.length; i++) {
                    arrf1[i] = (arrMonomsFromString[0].initFromString(errString[i]));
                }
            } catch (NumberFormatException e) {
                counter++;
                continue;
            }
        }
        assertEquals(errString.length,counter);
    }

    /**
     * Checks whether the Equals properly compares monom and function
     */
    @Test
    public void testEquals() {

        Monom notEqualForMonom=new Monom(100,0);
        Polynom notEqualForPolynom=new Polynom("100");
        function fl=new Monom("50");
        function fr=new Monom("50");
        ComplexFunction notEqualForComplexFunction=new ComplexFunction("plus",fl,fr);

        //**Compare two monomers comparison**
        //Checks whether identical and constant arrays are equal
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertTrue(arrMonomsFromConstructorMonom[i].equals(arrMonomsFromString[i]));
            assertTrue(arrMonomsFromString[i].equals(arrMonomsFromConstructorMonom[i]));
        }

        //Checks whether the cells in the arrays are equals to other monom
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertFalse(arrMonomsFromConstructorMonom[i].equals(notEqualForMonom));
            assertFalse(arrMonomsFromString[i].equals(notEqualForMonom));
        }

        //**Monom and Polynomial Comparison Checker**
        //Checks whether the cells in the arrays are equals to polynoms
        Polynom [] expected ={new Polynom("0"),new Polynom("15"),new Polynom("15.5"),new Polynom("x"),new Polynom("-x"),new Polynom("+x"),new Polynom("4.5x"),new Polynom("2.5x"),new Polynom("-4.5x"),new Polynom("-2.5x"),new Polynom("2x^2"),new Polynom("6.7x^5"),new Polynom("-9x^7"),new Polynom("8x^7"),new Polynom("0X^90")};
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertTrue(arrMonomsFromConstructorMonom[i].equals(expected[i]));
            assertTrue(arrMonomsFromString[i].equals(expected[i]));
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertFalse(arrMonomsFromConstructorMonom[i].equals(notEqualForPolynom));
            assertFalse(arrMonomsFromString[i].equals(notEqualForPolynom));
        }

        //**Monom and Complex function Comparison Checker**

        ComplexFunction c=new ComplexFunction();
        function f0=c.initFromString("0");
        function f1=c.initFromString("15");
        function f2=c.initFromString("15.5");
        function f3=c.initFromString("mul(1,x)");
        function f4=c.initFromString("-x");
        function f5=c.initFromString("+x");
        function f6=c.initFromString("mul(4.5,x)");
        function f7=c.initFromString("mul(2.5,x)");
        function f8=c.initFromString("mul(-4.5,x)");
        function f9=c.initFromString("mul(-2.5,x)");
        function f10=c.initFromString("mul(2x,x)");
        function f11=c.initFromString("mul(6.7x,x^4)");
        function f12=c.initFromString("mul(-9,x^7)");
        function f13=c.initFromString("mul(8x,x^6)");
        function f14=c.initFromString("mul(0x,x^89)");

        function[] expectedC={new ComplexFunction(f0),f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14};
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertTrue(arrMonomsFromConstructorMonom[i].equals(expectedC[i]));
            assertTrue(arrMonomsFromString[i].equals(expectedC[i]));
        }

        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertFalse(arrMonomsFromConstructorMonom[i].equals(notEqualForComplexFunction));
            assertFalse(arrMonomsFromString[i].equals(notEqualForComplexFunction));
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



}