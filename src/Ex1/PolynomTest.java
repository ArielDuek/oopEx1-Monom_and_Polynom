package Ex1;

import java.util.Iterator;

public class PolynomTest {
	public static void main(String[] args) {
		test1();
		test2();
		polynomString_add_MakeOrder_deleteUnnecessaryZeros_Test();
		addPlynomableTest();
		substractTest();
		copy_equals_Test();
		isZeroTest();
		multiplyPolynomTest();
		derivative();
		fTest();
		areaTest();
		positiveAreaTest();
		rootTest();

	}

	public static void test1()
	{
		System.out.println();
		System.out.println("*****test 1*****");
		Polynom p1 = new Polynom();
		String[] monoms = {"1","x","x^2", "0.5x^2"};
		for(int i=0;i<monoms.length;i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		double aa = p1.area(0, 1, 0.00000001);
		System.out.println(aa);
		p1.substract(p1);
		System.out.println(p1);

	}
	public static void test2()
	{
		System.out.println();
		System.out.println("*****test 2*****");
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		String[] monoms1 = {"2", "-x","-3.2x^2","4","-1.5x^2"};
		String[] monoms2 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		p1.add(p2);
		System.out.println("p1+p2: "+p1);
		p1.multiply(p2);
		System.out.println("(p1+p2)*p2: "+p1);
		String s1 = p1.toString();

	}

	/*
	The test checks the constructor that gets a string,the add monom to polynom function, the makeOrder function,
	and the function deleteUnnecessaryZeros.
	Because the constructor that accepts a string use all of the above functions, all functions are tested.
	 */
	public static void polynomString_add_MakeOrder_deleteUnnecessaryZeros_Test()
	{
		System.out.println();
		System.out.println("*****polynomString add MakeOrder deleteUnnecessaryZeros Test*****");
		System.out.println();
		System.out.println("Polynomials are proper,sorted in ascending order: ");
		Polynom p=new Polynom("1+2+5+6+1+85");
		System.out.println("The result from the function:"+p+" ,The expected result is:100.0 ");
		Polynom p1=new Polynom("1-2-5-6-1+85");
		System.out.println("The result from the function:"+p1+" ,The expected result is:72.0 ");
		Polynom p2=new Polynom("2x-2x+5");
		System.out.println("The result from the function:"+p2+" ,The expected result is:5.0 ");
		Polynom p3=new Polynom("2x+4x+7x^2-3x^3+100x^100+0+3x^3+0");
		System.out.println("The result from the function:"+p3+" ,The expected result is:100.0x^100+7.0x^2+6.0x ");
		Polynom p4=new Polynom("1+2x^2+3x^3+4x^4+5x^5+6x^6+7x^7+8x^8");
		System.out.println("The result from the function:"+p4+" ,The expected result is:8.0x^8+7.0x^7+6.0x^6+5.0x^5+4.0x^4+3.0x^3+2.0x^2+1.0");
	}
	/*
	The function checks the function that adds polynom to a polynom
	 */
	public static void addPlynomableTest()
	{
		System.out.println();
		System.out.println("*****add Plynomable Test*****");
		System.out.println();
		System.out.println("adds polynomial to polynomial properly: ");
		Polynom p=new Polynom("1+2+5+6+1+85");
		Polynom p1=new Polynom("1-2-5-6-1+85");
		p.add(p1);
		System.out.println("adds result from the function:"+p+ " ,The expected result is:172.0");
		Polynom p2=new Polynom("2x");
		Polynom p3=new Polynom("98x");
		p2.add(p3);
		System.out.println("adds result from the function:"+p2+ " ,The expected result is:100.0x");
		Polynom p4=new Polynom("2x+3x^4+6x^9+11x^100");
		Polynom p5=new Polynom("98x+89x^100");
		p4.add(p5);
		System.out.println("adds result from the function:"+p4+ " ,The expected result is:100.0x^100+6.0x^9+3.0x^4+100.0x ");
		Polynom p6=new Polynom("2x-3x^4+6x^9+11x^100");
		Polynom p7=new Polynom("98x+89x^100+9x^4");
		p6.add(p7);
		System.out.println("adds result from the function:"+p6+ " ,The expected result is:100.0x^100+6.0x^9+6.0x^4+100.0x ");
		Polynom p8=new Polynom("-8-11x^2-9x^7");
		Polynom p9=new Polynom("10-89x^2");
		p8.add(p9);
		System.out.println("adds result from the function:"+p8+ " ,The expected result is:-9.0x^7-100.0x^2+2.0 ");


	}
	/*
	The function checks the function substract
	 */
	public static void substractTest()
	{
		System.out.println();
		System.out.println("*****substract Plynomable Test*****");
		System.out.println();
		System.out.println("substract polynomial to polynomial properly: ");
		Polynom p=new Polynom("1+2+5+6+1+85");
		Polynom p1=new Polynom("1-2-5-6-1+85");
		p.substract(p1);
		System.out.println("substract result from the function:"+p+ " ,The expected result is:28.0");
		Polynom p2=new Polynom("2x");
		Polynom p3=new Polynom("98x");
		p2.substract(p3);
		System.out.println("substract result from the function:"+p2+ " ,The expected result is:-96.0x");
		Polynom p4=new Polynom("2x+3x^4+6x^9+11x^100");
		Polynom p5=new Polynom("98x+89x^100");
		p4.substract(p5);
		System.out.println("substract result from the function:"+p4+ " ,The expected result is:-78.0x^100+6.0x^9+3.0x^4-96.0x ");
		Polynom p6=new Polynom("2x-3x^4+6x^9+11x^100");
		Polynom p7=new Polynom("98x+89x^100+9x^4");
		p6.substract(p7);
		System.out.println("substract result from the function:"+p6+ " ,The expected result is:-78.0x^100+6.0x^9-12.0x^4-96.0x ");
		Polynom p8=new Polynom("-8-11x^2-9x^7");
		Polynom p9=new Polynom("10-89x^2");
		p8.substract(p9);
		System.out.println("substract result from the function:"+p8+ " ,The expected result is:-9.0x^7+78.0x^2-18.0 ");
	}
	/*
    The function checks the function that multiply polynom to a polynom
    */
	public static void multiplyPolynomTest()
	{
		System.out.println();
		System.out.println("*****multiply Plynomable Test*****");
		System.out.println();
		System.out.println("multiply polynomials properly: ");
		Polynom p=new Polynom("1+2+5+6+1+85");
		Polynom p1=new Polynom("1-2-5-6-1+85");
		p.multiply(p1);
		System.out.println("multiply result from the function:"+p+ " ,The expected result is:7200.0 ");
		Polynom p2=new Polynom("2x");
		Polynom p3=new Polynom("98x");
		p2.multiply(p3);
		System.out.println("multiply result from the function:"+p2+ " ,The expected result is:196.0x^2");
		Polynom p4=new Polynom("2x+3x^4+6x^4");
		Polynom p5=new Polynom("2x^2+1");
		p4.multiply(p5);
		System.out.println("multiply result from the function:"+p4+ " ,The expected result is:18.0x^6+9.0x^4+4.0x^3+2.0x ");
		Polynom p6=new Polynom("2x-3x^4+6x^9+11x^100");
		Polynom p7=new Polynom("3x^3-2");
		p6.multiply(p7);
		System.out.println("multiply result from the function:"+p6+ " ,The expected result is:33.0x^103-22.0x^100+18.0x^12-12.0x^9-9.0x^7+12.0x^4-4.0x");
		Polynom p8=new Polynom("-8-11x^2-9x^7");
		Polynom p9=new Polynom("10-89x^2");
		p8.multiply(p9);
		System.out.println("multiply result from the function:"+p8+ " ,The expected result is:801.0x^9-90.0x^7+979.0x^4+602.0x^2-80.0");
	}
	/*
	The function checks the function copy and function equals
	 */
	public static void copy_equals_Test()
	{
		System.out.println();
		System.out.println("*****copy equals Test*****");
		System.out.println();
		System.out.println("That should be true:");
		Polynom p=new Polynom("1+2+5+6+1+85");
		Polynom pToCopy=new Polynom();
		System.out.println(p.equals(pToCopy));
		Polynom p1=new Polynom("2x");
		Polynom p1ToCopy=new Polynom();
		System.out.println(p1.equals(p1ToCopy));
		Polynom p2=new Polynom("2x+2x^2+134");
		Polynom p2ToCopy=new Polynom();
		System.out.println(p2.equals(p2ToCopy));
		Polynom p3=new Polynom("1+2x^2+3x^3+4x^4+5x^5+6x^6+7x^7+8x^8");
		Polynom p3ToCopy=new Polynom();
		System.out.println(p3.equals(p3ToCopy));
		Polynom p4=new Polynom("2x+2+2x^2+2x^3+3+3X+3x^2+3x^3+5x^97");
		Polynom p4ToCopy=new Polynom();
		System.out.println(p4.equals(p4ToCopy));
		Polynom p5=new Polynom("2x-3x^4+6x^9+11x^100");
		Polynom p5ToCopy=new Polynom();
		System.out.println(p5.equals(p5ToCopy));
		System.out.println();
		System.out.println("That should be false:");
		Polynom pComper=new Polynom("3x+9x^2+200");
		Polynom p10=new Polynom("1+2+5+6+1+85");
		System.out.println(p10.equals(pComper));
		Polynom p11=new Polynom("2x");
		System.out.println(p11.equals(pComper));
		Polynom p12=new Polynom("2x+2x^2+134");
		System.out.println(p12.equals(pComper));
		Polynom p13=new Polynom("1+2x^2+3x^3+4x^4+5x^5+6x^6+7x^7+8x^8");
		System.out.println(p13.equals(pComper));
		Polynom p14=new Polynom("2x+2+2x^2+2x^3+3+3X+3x^2+3x^3+5x^97");
		System.out.println(p14.equals(pComper));
		Polynom p15=new Polynom("2x-3x^4+6x^9+11x^100");
		System.out.println(p15.equals(pComper));
	}
	/*
	The function checks the function isZero
	 */
	public static void isZeroTest()
	{
		System.out.println();
		System.out.println("*****isZero Test*****");
		System.out.println();
		System.out.println("That should be true:");
		Polynom p=new Polynom("-85+85");
		Polynom p1=new Polynom("2x-2x");
		System.out.println(p1.isZero());
		Polynom p2=new Polynom("0");
		System.out.println(p2.isZero());
		Polynom p3=new Polynom("0x^8+0+0x^5");
		System.out.println(p3.isZero());
		Polynom p4=new Polynom("2x^6-15x-2x^6+15x");
		System.out.println(p4.isZero());
		Polynom p5=new Polynom("0x-0x^4+0x^9+0x^100");
		System.out.println(p5.isZero());
		System.out.println();
		System.out.println("That should be false:");
		Polynom p10=new Polynom("1+2+5+6+1+85");
		System.out.println(p10.isZero());
		Polynom p11=new Polynom("2x");
		System.out.println(p11.isZero());
		Polynom p12=new Polynom("2x+2x^2+134");
		System.out.println(p12.isZero());
		Polynom p13=new Polynom("1+2x^2+3x^3+4x^4+5x^5+6x^6+7x^7+8x^8");
		System.out.println(p13.isZero());
		Polynom p14=new Polynom("2x+2+2x^2+2x^3+3+3X+3x^2+3x^3+5x^97");
		System.out.println(p14.isZero());
		Polynom p15=new Polynom("2x-3x^4+6x^9+11x^100");
		System.out.println(p15.isZero());
	}
	/*
	The function checks the function derivative
	 */
	public static void derivative()
	{
		System.out.println();
		System.out.println("***** derivative Test*****");
		System.out.println();
		System.out.println("Derivatives of Functions: ");
		Polynom p=new Polynom("1+2+5+6+1+85");
		System.out.println("adds result from the function:"+p.derivative()+ " ,The expected result is:0.0");
		Polynom p1=new Polynom("1-2-5-6-1+85");
		System.out.println("adds result from the function:"+p1.derivative()+ " ,The expected result is:0.0");
		Polynom p2=new Polynom("2x");
		System.out.println("adds result from the function:"+p2.derivative()+ " ,The expected result is:2.0");
		Polynom p3=new Polynom("98x");
		System.out.println("adds result from the function:"+p3.derivative()+ " ,The expected result is:98.0");
		Polynom p4=new Polynom("2x^2");
		System.out.println("adds result from the function:"+p4.derivative()+ " ,The expected result is:4.0x");
		Polynom p5=new Polynom("98x+89x^100");
		System.out.println("adds result from the function:"+p5.derivative()+ " ,The expected result is:8900.0x^99+98.0");
		Polynom p6=new Polynom("-2x^3+5x^5+9+11+7x^2");
		System.out.println("adds result from the function:"+p6.derivative()+ " ,The expected result is:25.0x^4-6.0x^2+14.0x+0.0");
		Polynom p7=new Polynom("50x+50x");
		System.out.println("adds result from the function:"+p7.derivative()+ " ,The expected result is:100.0");
		Polynom p8=new Polynom("2x^8+2x^7+2x^6+2x^5+2x^4+2x^3+2x^2x+2");
		System.out.println("adds result from the function:"+p8.derivative()+ " ,The expected result is:16.0x^7+14.0x^6+12.0x^5+10.0x^4+8.0x^3+6.0x^2+0.0");
		Polynom p9=new Polynom("2x^2+2");
		System.out.println("adds result from the function:"+p9.derivative()+ " ,The expected result is:4.0x");

	}
	/*
	The main function obtains a starting and ending point polynomial and returns the derivative and whether in this area
	 it is positive or not and whether or not it returns the values in which it is probably negative
	 */

	public static void positiveArea(int start, int end, Polynom toDer){
		boolean isPositive = true;
		Polynom Dev = new Polynom(toDer.derivative().toString());
		System.out.print("The Original Polynom : " + toDer.toString());
		System.out.println("		The Derivative of the Polynom : " + Dev.toString());
		System.out.print("Please wait a few seconds..");
		for (int i = start; i < end; i++) {
			double fx = (toDer.f(i+1)-toDer.f(i));
			//System.out.print("f("+i+") : " + fx + "     The positive area of the dev between " + i + " and " + (i+1) +" is : ");
			double aa = Dev.area(i, i+0.5, 0.0000001);
			//System.out.println(aa);
			if (!(aa - fx < 0.01)) {
				isPositive = false;
				System.out.print(" , from: " + i + " to: " + (i + 1));
			}
		}
		if(!isPositive) System.out.println("	 the area is negative..");
		else System.out.println("					This area is positive!!");
	}

	public static void positiveAreaTest() {
		Polynom a1 = new Polynom("3x^2+4x^3+5x+6");
		Polynom a2 = new Polynom("3.4x^2-6x^3+3x+2");
		Polynom a3 = new Polynom("5X^2+7x^3+5x+6");
		Polynom a4 = new Polynom("3x^2+4x^3+5x-6");
		Polynom a5 = new Polynom("3x^2-4x^3+5x+6");
		Polynom a6 = new Polynom("3x^2+4x^3+5x-6");
		Polynom[] Polyarr = {a1, a2, a3, a4, a5, a6};
		for (int i = 0; i < Polyarr.length; i++) {
			positiveArea(-3, 3, Polyarr[i]);
		}
	}

	/*
        The function checks the function f
     */
	public static void fTest()
	{
		System.out.println();
		System.out.println("*****f Test*****");
		System.out.println();
		Polynom p=new Polynom("5678");
		System.out.println("result from the function:"+p.f(2)+ " ,The expected result is:5678.0");
		Polynom p1=new Polynom("2x^2");
		System.out.println("result from the function:"+p1.f(2)+ " ,The expected result is:8.0");
		Polynom p2=new Polynom("2x+2x^2");
		System.out.println("result from the function:"+p2.f(2)+ " ,The expected result is:12.0");
		Polynom p3=new Polynom("0");
		System.out.println("result from the function:"+p3.f(2)+ " ,The expected result is:0.0");
		Polynom p4=new Polynom("2x+3x^4+6x^2");
		System.out.println("result from the function:"+p4.f(2)+ " ,The expected result is:76.0");
		Polynom p5=new Polynom("3x-2x^3");
		System.out.println("result from the function:"+p5.f(2)+ " ,The expected result is:-10.0");

	}
	/*
        The function checks the function root
     */
	public static void rootTest(){
		System.out.println();
		System.out.println("*****root Test*****");
		String poly = "x+4";
		Polynom tooroot = new Polynom(poly);
		System.out.println(tooroot.toString());
		double x = tooroot.root(-6,1,0.00001);
		System.out.println(x);
		boolean isroot = false;
		if (tooroot.f(x)<=0.0001) isroot=true;
		System.out.println(isroot);
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
		Polynom s = new Polynom("x^2+3x-4");
		Polynom s2 = new Polynom("x^3+x^2+x-1");
		Polynom s3 = new Polynom("-x^2+1");
		double a1=0,a2=0,a3=0;

		a1=s.root(0.5, 2, 0.0001);
		a2=s2.root(-1, 1, 0.0001);
		a3 = s3.root(-2, -0.5, 0.0001);
		System.out.println(" s root : " + a1 + "s2 root : " + a2 + "s3 root : " + a3 );
	}
	/*
    The function checks the function derivative
    */
	public static void areaTest(){
		System.out.println();
		System.out.println("*****area Test*****");
		Polynom p1 = new Polynom();
		String[] monoms = {"1","x","x^2", "0.5x^2"};
		for(int i=0;i<monoms.length;i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		double aa = p1.area(0, 1, 0.00000001);
		System.out.println(aa);
	}
}
