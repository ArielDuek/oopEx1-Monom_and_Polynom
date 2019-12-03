package Ex1;

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

        //The comparison
        assertEquals(m50,arrMonomsFromConstructorMonom[0]);
        assertEquals(m51,arrMonomsFromConstructorMonom[1]);
        assertEquals(m52,arrMonomsFromConstructorMonom[2]);
        assertEquals(m53,arrMonomsFromConstructorMonom[3]);
        assertEquals(m54,arrMonomsFromConstructorMonom[4]);
        assertEquals(m55,arrMonomsFromConstructorMonom[5]);
        assertEquals(m56,arrMonomsFromConstructorMonom[6]);
        assertEquals(m57,arrMonomsFromConstructorMonom[7]);
        assertEquals(m58,arrMonomsFromConstructorMonom[8]);
        assertEquals(m59,arrMonomsFromConstructorMonom[9]);
        assertEquals(m60,arrMonomsFromConstructorMonom[10]);
        assertEquals(m61,arrMonomsFromConstructorMonom[11]);
        assertEquals(m62,arrMonomsFromConstructorMonom[12]);
        assertEquals(m63,arrMonomsFromConstructorMonom[13]);
        assertEquals(m64,arrMonomsFromConstructorMonom[14]);

        assertNotEquals(m50,arrMonomsFromConstructorMonom[1]);
        assertNotEquals(m51,arrMonomsFromConstructorMonom[13]);
        assertNotEquals(m52,arrMonomsFromConstructorMonom[12]);
        assertNotEquals(m53,arrMonomsFromConstructorMonom[11]);
        assertNotEquals(m54,arrMonomsFromConstructorMonom[10]);
        assertNotEquals(m55,arrMonomsFromConstructorMonom[9]);
        assertNotEquals(m56,arrMonomsFromConstructorMonom[8]);
        assertNotEquals(m57,arrMonomsFromConstructorMonom[0]);
        assertNotEquals(m58,arrMonomsFromConstructorMonom[6]);
        assertNotEquals(m59,arrMonomsFromConstructorMonom[5]);
        assertNotEquals(m60,arrMonomsFromConstructorMonom[4]);
        assertNotEquals(m61,arrMonomsFromConstructorMonom[3]);
        assertNotEquals(m62,arrMonomsFromConstructorMonom[2]);
        assertNotEquals(m63,arrMonomsFromConstructorMonom[0]);
        assertNotEquals(m64,arrMonomsFromConstructorMonom[1]);


    }


    @Test
    public void getComp() {

    }

    /**
     * Checks whether the get_coefficient returns the correct coefficient from the monom
     */
    @Test
    public void get_coefficient() {
        /*Checks whether the get_coefficient returns the correct coefficient from the constructor created by a
        constructor that accepts a string*/
        assertEquals(arrMonomsFromString[0].get_coefficient(),0.0,0.0);
        assertEquals(arrMonomsFromString[1].get_coefficient(),15.0,0.0);
        assertEquals(arrMonomsFromString[2].get_coefficient(),15.5,0.0);
        assertEquals(arrMonomsFromString[3].get_coefficient(),1.0,0.0);
        assertEquals(arrMonomsFromString[4].get_coefficient(),-1.0,0.0);
        assertEquals(arrMonomsFromString[5].get_coefficient(),1.0,0.0);
        assertEquals(arrMonomsFromString[6].get_coefficient(),4.5,0.0);
        assertEquals(arrMonomsFromString[7].get_coefficient(),2.5,0.0);
        assertEquals(arrMonomsFromString[8].get_coefficient(),-4.5,0.0);
        assertEquals(arrMonomsFromString[9].get_coefficient(),-2.5,0.0);
        assertEquals(arrMonomsFromString[10].get_coefficient(),2.0,0.0);
        assertEquals(arrMonomsFromString[11].get_coefficient(),6.7,0.0);
        assertEquals(arrMonomsFromString[12].get_coefficient(),-9.0,0.0);
        assertEquals(arrMonomsFromString[13].get_coefficient(),8.0,0.0);
        assertEquals(arrMonomsFromString[14].get_coefficient(),0.0,0.0);

        assertNotEquals(arrMonomsFromString[0].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[1].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[2].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[3].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[4].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[5].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[6].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[7].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[8].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[9].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[10].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[11].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[12].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[13].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[14].get_coefficient(),100.0,0.0);

        /*Checks whether the get_coefficient returns the correct coefficient from the constructor created by a
        constructor that accepts a string*/
        assertEquals(arrMonomsFromConstructorMonom[0].get_coefficient(),0.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[1].get_coefficient(),15.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[2].get_coefficient(),15.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[3].get_coefficient(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[4].get_coefficient(),-1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[5].get_coefficient(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[6].get_coefficient(),4.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[7].get_coefficient(),2.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[8].get_coefficient(),-4.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[9].get_coefficient(),-2.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[10].get_coefficient(),2.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[11].get_coefficient(),6.7,0.0);
        assertEquals(arrMonomsFromConstructorMonom[12].get_coefficient(),-9.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[13].get_coefficient(),8.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[14].get_coefficient(),0.0,0.0);

        assertNotEquals(arrMonomsFromConstructorMonom[0].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[1].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[2].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[3].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[4].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[5].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[6].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[7].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[8].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[9].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[10].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[11].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[12].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[13].get_coefficient(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[14].get_coefficient(),100.0,0.0);

    }

    /**
     * Checks whether the get_power returns the correct power from the monom
     */
    @Test
    public void get_power() {
        /*Checks whether the get_power returns the correct coefficient from the constructor created by a
        constructor that accepts a string*/
        assertEquals(arrMonomsFromString[0].get_power(),0.0,0.0);
        assertEquals(arrMonomsFromString[1].get_power(),0.0,0.0);
        assertEquals(arrMonomsFromString[2].get_power(),0.0,0.0);
        assertEquals(arrMonomsFromString[3].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromString[4].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromString[5].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromString[6].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromString[7].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromString[8].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromString[9].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromString[10].get_power(),2.0,0.0);
        assertEquals(arrMonomsFromString[11].get_power(),5.0,0.0);
        assertEquals(arrMonomsFromString[12].get_power(),7.0,0.0);
        assertEquals(arrMonomsFromString[13].get_power(),7.0,0.0);
        assertEquals(arrMonomsFromString[14].get_power(),90.0,0.0);

        assertNotEquals(arrMonomsFromString[0].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[1].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[2].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[3].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[4].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[5].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[6].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[7].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[8].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[9].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[10].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[11].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[12].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[13].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromString[14].get_power(),100.0,0.0);

        /*Checks whether the get_power returns the correct coefficient from the constructor created by a
        constructor that accepts a string*/

        assertEquals(arrMonomsFromConstructorMonom[0].get_power(),0.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[1].get_power(),0.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[2].get_power(),0.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[3].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[4].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[5].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[6].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[7].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[8].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[9].get_power(),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[10].get_power(),2.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[11].get_power(),5.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[12].get_power(),7.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[13].get_power(),7.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[14].get_power(),90.0,0.0);

        assertNotEquals(arrMonomsFromConstructorMonom[0].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[1].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[2].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[3].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[4].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[5].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[6].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[7].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[8].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[9].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[10].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[11].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[12].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[13].get_power(),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[14].get_power(),100.0,0.0);
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

        //The comparison
        assertEquals(arrMonomsFromString[0].derivative(),dm20);
        assertEquals(arrMonomsFromString[1].derivative(),dm21);
        assertEquals(arrMonomsFromString[2].derivative(),dm22);
        assertEquals(arrMonomsFromString[3].derivative(),dm23);
        assertEquals(arrMonomsFromString[4].derivative(),dm24);
        assertEquals(arrMonomsFromString[5].derivative(),dm25);
        assertEquals(arrMonomsFromString[6].derivative(),dm26);
        assertEquals(arrMonomsFromString[7].derivative(),dm27);
        assertEquals(arrMonomsFromString[8].derivative(),dm28);
        assertEquals(arrMonomsFromString[9].derivative(),dm29);
        assertEquals(arrMonomsFromString[10].derivative(),dm30);
        assertEquals(arrMonomsFromString[11].derivative(),dm31);
        assertEquals(arrMonomsFromString[12].derivative(),dm32);
        assertEquals(arrMonomsFromString[13].derivative(),dm33);
        assertEquals(arrMonomsFromString[14].derivative(),dm34);

        assertNotEquals(arrMonomsFromString[0].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[1].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[2].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[3].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[4].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[5].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[6].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[7].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[8].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[9].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[10].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[11].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[12].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[13].derivative(),notEquals);
        assertNotEquals(arrMonomsFromString[14].derivative(),notEquals);
    }

    @Test
    public void f() {
        assertEquals(arrMonomsFromConstructorMonom[0].f(1),0.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[1].f(1),15.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[2].f(1),15.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[3].f(1),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[4].f(1),-1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[5].f(1),1.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[6].f(1),4.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[7].f(1),2.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[8].f(1),-4.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[9].f(1),-2.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[10].f(1),2.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[11].f(1),6.7,0.0);
        assertEquals(arrMonomsFromConstructorMonom[12].f(1),-9.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[13].f(1),8.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[14].f(1),0.0,0.0);

        assertEquals(arrMonomsFromConstructorMonom[0].f(5),0.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[1].f(5),15.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[2].f(5),15.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[3].f(5),5.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[4].f(5),-5.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[5].f(5),5.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[6].f(5),22.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[7].f(5),12.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[8].f(5),-22.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[9].f(5),-12.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[10].f(5),50.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[11].f(5),20937.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[12].f(5),-703125,0.0);
        assertEquals(arrMonomsFromConstructorMonom[13].f(5),625000,0.0);
        assertEquals(arrMonomsFromConstructorMonom[14].f(5),0.0,0.0);

        assertEquals(arrMonomsFromConstructorMonom[0].f(5.55),0.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[1].f(5.55),15.0,0.0);
        assertEquals(arrMonomsFromConstructorMonom[2].f(5.55),15.5,0.0);
        assertEquals(arrMonomsFromConstructorMonom[3].f(5.55),5.55,0.0);
        assertEquals(arrMonomsFromConstructorMonom[4].f(5.55),-5.55,0.0);
        assertEquals(arrMonomsFromConstructorMonom[5].f(5.55),5.55,0.0);
        assertEquals(arrMonomsFromConstructorMonom[6].f(5.55),24.975,0.0);
        assertEquals(arrMonomsFromConstructorMonom[7].f(5.55),13.875,0.0);
        assertEquals(arrMonomsFromConstructorMonom[8].f(5.55),-24.975,0.0);
        assertEquals(arrMonomsFromConstructorMonom[9].f(5.55),-13.875,0.0);
        assertEquals(arrMonomsFromConstructorMonom[10].f(5.55),61.605,0.0);
        assertEquals(arrMonomsFromConstructorMonom[11].f(5.55),35280.90512,0.0);
        assertEquals(arrMonomsFromConstructorMonom[12].f(5.55),-1459800,0.0);
        assertEquals(arrMonomsFromConstructorMonom[13].f(5.55),1297600.096,0.0);
        assertEquals(arrMonomsFromConstructorMonom[14].f(5.55),0.0,0.0);

//        assertEquals(arrMonomsFromConstructorMonom[0].f(-5.55),0.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[1].f(-5.55),15.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[2].f(-5.55),15.5,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[3].f(-5.55),1.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[4].f(-5.55),-1.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[5].f(-5.55),1.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[6].f(-5.55),4.5,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[7].f(-5.55),2.5,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[8].f(-5.55),-4.5,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[9].f(-5.55),-2.5,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[10].f(-5.55),2.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[11].f(-5.55),6.7,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[12].f(-5.55),-9.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[13].f(-5.55),8.0,0.0);
//        assertEquals(arrMonomsFromConstructorMonom[14].f(-5.55),0.0,0.0);

        assertNotEquals(arrMonomsFromConstructorMonom[0].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[1].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[2].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[3].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[4].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[5].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[6].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[7].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[8].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[9].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[10].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[11].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[12].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[13].f(0.0),100.0,0.0);
        assertNotEquals(arrMonomsFromConstructorMonom[14].f(0.0),100.0,0.0);
    }

    @Test
    public void isZero() {
    }

    @Test
    public void add() {
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