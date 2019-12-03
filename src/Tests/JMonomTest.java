package Tests;

import Ex1.Monom;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

//i didnt do a test get_isValidMonom
public class JMonomTest {

    static  Monom [] arrMonomsFromString =new Monom[15];
    static  Monom [] arrMonomsFromConstructorMonom =new Monom[15];


    //Here we will create all the monoms for testing the methods
    @BeforeClass
    public static void BeforeAll()
    {
        //Build the monoms with the help of the monom string constructor
        Monom m0 =new Monom ("0");
        Monom m1 =new Monom ("15");
        Monom m2 =new Monom ("15.5");
        Monom m3 =new Monom ("x");
        Monom m4 =new Monom ("-x");
        Monom m5 =new Monom ("+x");
        Monom m6 =new Monom ("4.5x");
        Monom m7 =new Monom ("2.5x");
        Monom m8 =new Monom ("-4.5x");
        Monom m9 =new Monom ("-2.5x");
        Monom m10 =new Monom ("2x^2");
        Monom m11 =new Monom ("6.7x^5");
        Monom m12 =new Monom ("-9x^7");
        Monom m13 =new Monom ("8x^7");
        Monom m14 =new Monom ("0X^90");
        arrMonomsFromString[0]=m0;
        arrMonomsFromString[1]=m1;
        arrMonomsFromString[2]=m2;
        arrMonomsFromString[3]=m3;
        arrMonomsFromString[4]=m4;
        arrMonomsFromString[5]=m5;
        arrMonomsFromString[6]=m6;
        arrMonomsFromString[7]=m7;
        arrMonomsFromString[8]=m8;
        arrMonomsFromString[9]=m9;
        arrMonomsFromString[10]=m10;
        arrMonomsFromString[11]=m11;
        arrMonomsFromString[12]=m12;
        arrMonomsFromString[13]=m13;
        arrMonomsFromString[14]=m14;

        //Build the monoms with the help of a constructor that receives parameters to build monom
        Monom m20 =new Monom (0.0,0);
        Monom m21 =new Monom (15.0,0);
        Monom m22 =new Monom (15.5,0);
        Monom m23 =new Monom (1.0,1);
        Monom m24 =new Monom (-1.0,1);
        Monom m25 =new Monom (1.0,1);
        Monom m26 =new Monom (4.5,1);
        Monom m27 =new Monom (2.5,1);
        Monom m28 =new Monom (-4.5,1);
        Monom m29 =new Monom (-2.5,1);
        Monom m30 =new Monom (2.0,2);
        Monom m31 =new Monom (6.7,5);
        Monom m32 =new Monom (-9.0,7);
        Monom m33 =new Monom (8.0,7);
        Monom m34 =new Monom (0.0,90);
        arrMonomsFromConstructorMonom[0]=m20;
        arrMonomsFromConstructorMonom[1]=m21;
        arrMonomsFromConstructorMonom[2]=m22;
        arrMonomsFromConstructorMonom[3]=m23;
        arrMonomsFromConstructorMonom[4]=m24;
        arrMonomsFromConstructorMonom[5]=m25;
        arrMonomsFromConstructorMonom[6]=m26;
        arrMonomsFromConstructorMonom[7]=m27;
        arrMonomsFromConstructorMonom[8]=m28;
        arrMonomsFromConstructorMonom[9]=m29;
        arrMonomsFromConstructorMonom[10]=m30;
        arrMonomsFromConstructorMonom[11]=m31;
        arrMonomsFromConstructorMonom[12]=m32;
        arrMonomsFromConstructorMonom[13]=m33;
        arrMonomsFromConstructorMonom[14]=m34;

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

        Monom[] expected={m50,m51,m52,m53,m54,m55,m56,m57,m58,m59,m60,m61,m62,m63,m64};

        //The comparison
        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i]);
        }

        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertNotEquals(notEqual,arrMonomsFromConstructorMonom[i]);
        }

        for (int i = 0; i < arrMonomsFromConstructorMonom.length; i++) {
            assertNotNull(null,arrMonomsFromConstructorMonom[i]);
        }

    }


    @Test
    public void getComp() {

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
            assertEquals(expected[i],arrMonomsFromString[i].get_coefficient(),0.0);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromString[i].get_coefficient(),0.0);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotNull(null,arrMonomsFromString[i].get_coefficient());
        }

        /*Checks whether the get_coefficient returns the correct coefficient from the constructor
         that accepts a parameters*/
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].get_coefficient(),0.0);
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromConstructorMonom[i].get_coefficient(),0.0);
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
            assertEquals(expected[i],arrMonomsFromString[i].get_power(),0.0);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromString[i].get_power(),0.0);
        }

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertNotNull(null,arrMonomsFromString[i].get_power());
        }


        /*Checks whether the get_power() returns the correct power from the constructor
         that accepts a parameters*/
        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertEquals(expected[i],arrMonomsFromConstructorMonom[i].get_power(),0.0);
        }

        for (int i = 0; i <arrMonomsFromConstructorMonom.length ; i++) {
            assertNotEquals(100.0,arrMonomsFromConstructorMonom[i].get_power(),0.0);
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

        double[] expectedFor1 ={0.0,15.0,15.5,1.0,-1.0,1.0,4.5,2.5,-4.5,-2.5,2,6.7,-9.0,8.0,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedFor1[i],arrMonomsFromString[i].f(1),Monom.EPSILON);
        }

        double[] expectedFor5 ={0.0,15.0,15.5,5.0,-5.0,5.0,22.5,12.5,-22.5,-12.5,50,20937.5,-703125.0,625000,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedFor5[i],arrMonomsFromString[i].f(5),Monom.EPSILON);
        }

        double[] expectedFor5_55 ={0.0,15.0,15.5,5.55,-5.55,5.55,24.975,13.875,-24.975,-13.875,61.605,35280.90512,-1459800.108,1297600.096,0.0};

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            assertEquals(expectedFor5_55[i],arrMonomsFromString[i].f(5.55),0.01);
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

    @Test
    public void add() {
        Monom addForPower0=new Monom("2");
        Monom addForPower1=new Monom("x");
        Monom addForPower2=new Monom("2x^2");
        Monom addForPower5=new Monom("2x^5");
        Monom addForPower7=new Monom("2x^7");
        Monom addForPower90=new Monom("2x^90");

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

        assertEquals("2.0",arrMonomsFromString[0].toString());
        assertEquals("17.0",arrMonomsFromString[1].toString());
        assertEquals("17.5",arrMonomsFromString[2].toString());
        assertEquals("2.0x",arrMonomsFromString[3].toString());
        assertEquals("0.0x",arrMonomsFromString[4].toString());
        assertEquals("2.0x",arrMonomsFromString[5].toString());
        assertEquals("5.5x",arrMonomsFromString[6].toString());
        assertEquals("3.5x",arrMonomsFromString[7].toString());
        assertEquals("-3.5x",arrMonomsFromString[8].toString());
        assertEquals("-1.5x",arrMonomsFromString[9].toString());
        assertEquals("4.0x^2",arrMonomsFromString[10].toString());
        assertEquals("8.7x^5",arrMonomsFromString[11].toString());
        assertEquals("-7.0x^7",arrMonomsFromString[12].toString());
        assertEquals("10.0x^7",arrMonomsFromString[13].toString());
        assertEquals("2.0x^90",arrMonomsFromString[14].toString());


    }

    @Test
    public void multipy() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void testEquals() {
    }
}