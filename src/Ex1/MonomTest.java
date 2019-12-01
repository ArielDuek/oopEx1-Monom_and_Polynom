package Ex1;

import java.util.ArrayList;
/**
 * This class represents a simple (naive) tester for the Monom class, 
 * Note: <br>
 * (i) The class is NOT a JUNIT - (i.e., educational reasons) - should be changed to a proper JUnit in Ex1. <br>
 * (ii) This tester should be extend in order to test ALL the methods and functionality of the Monom class.  <br>
 * (iii) Expected output:  <br>
 * *****  Test1:  *****  <br>
0) 2.0    	isZero: false	 f(0) = 2.0  <br>
1) -1.0x    	isZero: false	 f(1) = -1.0  <br>
2) -3.2x^2    	isZero: false	 f(2) = -12.8  <br>
3) 0    	isZero: true	 f(3) = 0.0  <br>
*****  Test2:  *****  <br>
0) 0    	isZero: true  	eq: true  <br>
1) -1.0    	isZero: false  	eq: true  <br>
2) -1.3x    	isZero: false  	eq: true  <br>
3) -2.2x^2    	isZero: false  	eq: true  <br>
 */
public class MonomTest {
	public static void main(String[] args) {


        monomToStringTest_isZeroTest_equalsTest();
        monomStringTest();
        monomMultipyTest();
        monomAddTest();


	}

	//The function checks for the constructor that gets a string and becomes a monom
	private static void monomStringTest() {
        System.out.println();
        System.out.println("*****Monom String Test*****");
		String[] monomsTrue = {"9","9087","6.7","x","-x","+x","4.5x","-9x","78x","2x^2","6.7x^5","-9x^7"};
		String[] monomsFalse={"9^8","(6+5)","6-5","6..7","8*6","9/3","-8t^9","asos","9x^-5","9x^-5.8"};
        System.out.println("That should be true:");
		for (int i = 0; i < monomsTrue.length; i++)
		{
			Monom m = new Monom(monomsTrue[i]);
			if(m.get_isValidMonom()) {
				System.out.println(i+")"+" coef: "+m.get_coefficient()+", power: "+m.get_power());
			}
		}
        System.out.println();
        System.out.println("That should be false:");
        for (int i = 0; i < monomsFalse.length; i++)
        {
            Monom m = new Monom(monomsFalse[i]);
            if(m.get_isValidMonom()) {
                System.out.println(i+")"+" coef: "+m.get_coefficient()+", power: "+m.get_power());
            }
        }
	}

	/*The function checks the function that multiplies one monom in another, as follows: It multiplies a[i] with a[i + 1]
	on condition That the index i+1 exists in the array
    */
    private static void monomMultipyTest()
    {
        System.out.println();
        System.out.println("***** monom Multipy Test*****");
        String[] monomsTrue = {"9","9087","6.7","x","-x","+x","4.5x","-9x","78x","2x^2","6.7x^5","-9x^7","0X^90","8x^7","9x^3"};
        System.out.println("That should be true:");
        for (int i = 0; i < monomsTrue.length-1; i++)
        {
            Monom m0 = new Monom(monomsTrue[i]);
            if(i+1<=monomsTrue.length)
            {
                Monom m = new Monom(monomsTrue[i+1]);
                m0.multipy(m);
                System.out.println(m0);
            }
        }

    }

    /*The function checks the function That adds one monum to another.
    true outputs: as follows - It adds a[i] with a[i + 1] on condition That the index i+1 exists in the array.
    error outputs: as follows - Connect 2 monomes from 2 different arrays when each hold is uniform and equal power,
    and because the power is different when trying to connect, an error appears.
    */
	private  static void monomAddTest()
    {
        System.out.println();
        System.out.println("*****monom add Test*****");
        String[] monomPower0True={"1","6","9","9","0","1","-2"};
        String[] monomPower1True={"1x","6x","9x","-9x","0x","1x","-7x"};
        String[] monomPower2True={"1x^2","6x^2","9x^2","-9x^2","0x^2","1x^2","-7x^2"};
        System.out.println("That should be true:");
        for (int i = 0; i < monomPower0True.length-1; i++)
        {
            Monom m0 = new Monom(monomPower0True[i]);
            if(i+1<=monomPower0True.length)
            {
               Monom m = new Monom(monomPower0True[i+1]);
               m0.add(m);
                System.out.println(m0);
            }
        }

        for (int i = 0; i < monomPower1True.length-1; i++)
        {
            Monom m0 = new Monom(monomPower1True[i]);
            if(i+1<=monomPower1True.length)
            {
                Monom m = new Monom(monomPower1True[i+1]);
                m0.add(m);
                System.out.println(m0);
            }
        }

        for (int i = 0; i < monomPower2True.length-1; i++)
        {
            Monom m0 = new Monom(monomPower2True[i]);
            if(i+1<=monomPower2True.length)
            {
                Monom m = new Monom(monomPower2True[i+1]);
                m0.add(m);
                System.out.println(m0);
            }
        }
        System.out.println();

        String[] monomPower0False={"1","6","9","9","0","1","-2"};
        String[] monomPower1False={"1x","6x","9x","-9x","0x","1x","-7x"};
        String[] monomPower2False={"1x^2","6x^2","9x^2","-9x^2","0x^2","1x^2","-7x^2"};
        System.out.println("Should throw an error:");
        for (int i = 0; i < monomPower0False.length-1; i++)
        {
            Monom m = new Monom(monomPower0False[i]);
            for (int j = 0; j < monomPower1False.length-1; j++)
            {
                Monom m0 = new Monom(monomPower1False[j]);
                m.add(m0);
            }
        }

        for (int i = 0; i < monomPower2False.length-1; i++)
        {
            Monom m = new Monom(monomPower2False[i]);
            for (int j = 0; j < monomPower1False.length-1; j++)
            {
                Monom m0 = new Monom(monomPower1False[j]);
                m.add(m0);
            }
        }

    }

    /*
    The function checks whether the following functions are correct: toString,isZero,equals
     */
    private static void monomToStringTest_isZeroTest_equalsTest() {
        System.out.println();
        System.out.println("*****monom toString & monom isZeroTest & monom equals Test*****");

        ArrayList<Monom> monoms = new ArrayList<Monom>();
        monoms.add(new Monom(0, 5));
        monoms.add(new Monom(0, 0));
        monoms.add(new Monom(0, 1));
        monoms.add(new Monom(0, 2));
        System.out.println("isZero and equals should be true:");
        for (int i = 0; i < monoms.size(); i++) {
            Monom m = new Monom(monoms.get(i));
            String s = m.toString();
            Monom m1 = new Monom(s);
            boolean e = m.equals(m1);
            System.out.println(i + ") " + m + "     ,  " +m1 +"\tisZero: " + m.isZero() + "\tequals: " + e);
        }

        ArrayList<Monom> monoms0 = new ArrayList<Monom>();
        monoms0.add(new Monom(0, 5));
        monoms0.add(new Monom(0, 0));
        monoms0.add(new Monom(0, 1));
        monoms0.add(new Monom(0, 2));
        System.out.println();
        System.out.println("isZero should be true and equals should be false:");
        for (int i = 0; i < monoms0.size(); i++) {
            Monom m = new Monom(monoms0.get(i));
            String s = m.toString();
            Monom m1 = new Monom(s);
            boolean e = m.equals(Monom.MINUS1);
            System.out.println(i + ") " + m + "     ,  " +m1 +"\tisZero: " + m.isZero() + "\tequals: " + e);
        }

        ArrayList<Monom> monoms1 = new ArrayList<Monom>();
        monoms1.add(new Monom(3, 5));
        monoms1.add(new Monom(7, 0));
        monoms1.add(new Monom(9, 1));
        monoms1.add(new Monom(1234, 2));
        System.out.println();
        System.out.println("isZero should be false and equals should be true:");
        for (int i = 0; i < monoms1.size(); i++) {
            Monom m = new Monom(monoms1.get(i));
            String s = m.toString();
            Monom m1 = new Monom(s);
            boolean e = m.equals(m1);
            System.out.println(i + ") " + m + "     ,  " +m1 +"    \tisZero: " + m.isZero() + "  \tequals: " + e);
        }

        ArrayList<Monom> monoms2 = new ArrayList<Monom>();
        monoms2.add(new Monom(3, 5));
        monoms2.add(new Monom(7, 0));
        monoms2.add(new Monom(9, 1));
        monoms2.add(new Monom(1234, 2));
        System.out.println();
        System.out.println("isZero and equals should be false:");
        for (int i = 0; i < monoms2.size(); i++) {
            Monom m = new Monom(monoms2.get(i));
            String s = m.toString();
            Monom m1 = new Monom(s);
            Monom comp=new Monom(Monom.ZERO);
            boolean e = m.equals(comp);
            System.out.println(i + ") " + m + "     ,  " +m1 +"    \tisZero: " + m.isZero() + "  \tequals: " + e);
        }
    }



}
