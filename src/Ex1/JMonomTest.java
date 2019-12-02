package Ex1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class JMonomTest {

  static  Monom [] arrMonoms =new Monom[15];
     //Here we will create all the monoms for testing the methods
    @BeforeClass
    public static void BeforeAll()
    {
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
        arrMonoms[0]=m0;
        arrMonoms[1]=m1;
        arrMonoms[2]=m2;
        arrMonoms[3]=m3;
        arrMonoms[4]=m4;
        arrMonoms[5]=m5;
        arrMonoms[6]=m6;
        arrMonoms[7]=m7;
        arrMonoms[8]=m8;
        arrMonoms[9]=m9;
        arrMonoms[10]=m10;
        arrMonoms[11]=m11;
        arrMonoms[12]=m12;
        arrMonoms[13]=m13;
        arrMonoms[14]=m14;

    }


    @Test
    public void getComp() {

    }

    @Test
    public void get_coefficient() {
       assertEquals(arrMonoms[0].get_coefficient(),0.0,0.0);
       assertEquals(arrMonoms[1].get_coefficient(),15.0,0.0);
       assertEquals(arrMonoms[2].get_coefficient(),15.5,0.0);
       assertEquals(arrMonoms[3].get_coefficient(),1.0,0.0);
       assertEquals(arrMonoms[4].get_coefficient(),-1.0,0.0);
       assertEquals(arrMonoms[5].get_coefficient(),1.0,0.0);
       assertEquals(arrMonoms[6].get_coefficient(),4.5,0.0);
       assertEquals(arrMonoms[7].get_coefficient(),2.5,0.0);
       assertEquals(arrMonoms[8].get_coefficient(),-4.5,0.0);
       assertEquals(arrMonoms[9].get_coefficient(),-2.5,0.0);
       assertEquals(arrMonoms[10].get_coefficient(),2,0.0);
       assertEquals(arrMonoms[11].get_coefficient(),6.7,0.0);
       assertEquals(arrMonoms[12].get_coefficient(),-9.0,0.0);
       assertEquals(arrMonoms[13].get_coefficient(),8,0.0);
       assertEquals(arrMonoms[14].get_coefficient(),0.0,0.0);
    }

    @Test
    public void get_power() {
    }

    @Test
    public void get_isValidMonom() {
    }

    @Test
    public void derivative() {
    }

    @Test
    public void f() {
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