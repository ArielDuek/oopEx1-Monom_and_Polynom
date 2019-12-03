package Ex1;
import java.math.BigDecimal;
import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape ax^b, where a is a real number and a is an integer (summed a none negative),
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom<STRBKJ> implements function {
	public static final Monom ZERO = new Monom(0, 0);
	public static final Monom MINUS1 = new Monom(-1, 0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public boolean isValidMonom=true; //Variable whose job is to determine whether the monom is correct or not


	public static Comparator<Monom> getComp() {
		return _Comp;
	}

	public Monom(double a, int b) {
		this.set_coefficient(a);
		this.set_power(b);
	}

	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}

	public int get_power() {
		return this._power;
	}

	public boolean get_isValidMonom() {
		return this.isValidMonom;
	}

	/**
	 * this method returns the derivative monum of this.
	 * By multiplying the coefficient by the power and subtracting 1 by the power.
	 * @return Monum after the derivation
	 */
	public Monom derivative() {
		if (this.get_power() == 0) {
			return getNewZeroMonom();
		}
		return new Monom(this.get_coefficient() * this.get_power(), this.get_power() - 1);
	}
//the old f
	public double f(double x) {
		double ans = 0;
		double p = this.get_power();
		ans = this.get_coefficient() * Math.pow(x, p);
		return ans;
	}

//	//the new f
//	public double f(double x) {
//		double ans = 0;
//		int power=this.get_power();
//		BigDecimal newX=BigDecimal.valueOf(x);
//		BigDecimal coefficient=BigDecimal.valueOf(this.get_coefficient());
//		ans=coefficient.multiply(newX.pow(power)).doubleValue();
//		return ans;
//	}

	public boolean isZero() {
		return this.get_coefficient() == 0;
	}

	// ***************** add your code below **********************

    /**
     * @param s String received by the user
     * The function gets a string and the function should check if the string is a proper monum if the string is correcr,
	 * the function creates a monum.otherwise the function throws an error.
     * A proper monum is one of the following: a,-a,ax,-ax,x,-x,ax^b,-ax^b,x^b,-x^b
     *Examples of bad monum are the following:7tl,4^2,(4+8),8*4,3/5,4..4,(6-7),(2+2)x^4,x^2*3,3t,3t^7,x^2*3,x*x
     */
	public Monom(String s)  {
		double a;
		int b;
		s = s.toLowerCase();
		try {
			if (!s.contains("x")) {
				a = Double.parseDouble(s);
				b = 0;
			} else {
				if (!s.contains("^")) {
					if (s.equals("x")||s.equals("+x")) {
						a = 1;
						b = 1;
					} else if (s.equals("-x")) {
						a = -1;
						b = 1;
					} else {
						a = Double.parseDouble((s.substring(0, s.indexOf('x'))));
						b = 1;
					}
				} else {
					if (s.charAt(0) == 'x' || ( s.charAt(0)=='+' && s.charAt(1)=='x')) {
						a = 1;
						b = Integer.parseInt((s.substring(s.indexOf('x') + 2)));
					} else if ((s.charAt(0) == '-') && (s.charAt(1) == 'x')) {
						a = -1;
						b = Integer.parseInt((s.substring(s.indexOf('x') + 2)));
					} else {
						a = Double.parseDouble((s.substring(0, s.indexOf('x'))));
						b = Integer.parseInt((s.substring(s.indexOf('x') + 2)));
					}
				}
			}

			set_coefficient(a);
			set_power(b);
		} 
		catch (Exception e)
        {
			System.out.println("ERR: the string is null or string does contain a not parsable double");
			set_isValidMonom(false);
		}
	}

    /**
     *  @param m The monum added to the monum on which the function operates
     *  The function checks whether the powers are different if it then throw an error.
     * Otherwise the function adds coefficients to each other.
     */
	public void add (Monom m){
		if (this.get_power() != m.get_power())
			throw new RuntimeException("ERR:The power are not equal");
		else {
			this.set_coefficient( this.get_coefficient() + m.get_coefficient());
		}
	}

    /**
     * @param d The monom multiplied by the monum given to the function
     * The function checks whether one of the coefficients of the monomers is 0 if it sets the zero monom.
     * Otherwise, multiply the coefficients and add the powers
     */
	public void multipy (Monom d)
	{
		if(this.isZero()||d.isZero()) {
			this.set_power(0);
			this.set_coefficient(0);
		}
		else
		{
			this.set_coefficient(this.get_coefficient() * d.get_coefficient());
			this.set_power(this.get_power() + d.get_power());
		}
	}

    //****************** Auxiliary functions *****************

    /**
     * @return  String Which symbolizes the monom
     * Prints monom as follows: ax^b
     */
    public String toString()
    {
        StringBuilder ans= new StringBuilder("");
        ans.append(Double.toString(this.get_coefficient()));
        if (this.get_power()==1) ans.append('x');
        else if (this.get_power()!=0) ans.append("x^" + Integer.toString(this.get_power()));
        return ans.toString();
    }

	/**
	 * @param m Monom for comparison
	 * @return An boolean expression that signifies whether the monomies are equal or not
	 * The function checks whether the two monomies are equal in deflection of Epsilon
	 */

    public boolean equals (Object m) {
    	if(m instanceof Monom)
    	{

			double dc = this.get_coefficient() -((Monom) m).get_coefficient();
			if (Math.abs(dc) < EPSILON && this.get_power() == ((Monom) m).get_power()) return true;
			   return false;
		}

    	return false;
    }


	//****************** Private Methods and Data *****************

	//the new set coefficient
//	private void set_coefficient ( double a){
//		BigDecimal newCo=BigDecimal.valueOf(a);
//		this._coefficient = newCo.doubleValue();
//	}
//the old set coefficient
	private void set_coefficient ( double a){
		this._coefficient = a;
	}

	private void set_isValidMonom ( boolean a){
		this.isValidMonom = a;
	}
	private void set_power ( int p){
		if (p < 0) {
			throw new RuntimeException("ERR the power of Monom should not be negative, got: " + p);
		}
		this._power = p;
	}
	private static Monom getNewZeroMonom () {
		return new Monom(ZERO);
	}
	private double _coefficient;
	private int _power;

}

