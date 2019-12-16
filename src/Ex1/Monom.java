package Ex1;
import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape ax^b, where a is a real number and a is an integer (summed a none negative),
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply.
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

    /**
     * Constructor receiving 2 parameters, coefficient and power
     * @param a parameter representing the coefficient in monom
     * @param b parameter representing the power in monom
     */
    public Monom(double a, int b) {
        this.set_coefficient(a);
        this.set_power(b);
    }

    /**
     * copy constructor for monomcopy constructor for monom
     * @param ot The monum we want to copy
     */
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

    /**
     * The function checks the Y value at a point
     * @param x The X value is placed in the function to discover the Y value
     * @return  Y value at a point
     */
    public double f(double x) {
        double ans = 0;
        double p = this.get_power();
        ans = this.get_coefficient() * Math.pow(x, p);
        return ans;
    }


    public boolean isZero() {
        return this.get_coefficient() == 0;
    }

    // ***************** add your code below **********************

    /**
     * @param s String received by the user
     * The function gets a string and the function should check if the string is a proper monum if the string is correcr,
     * the function creates a monum.otherwise the function throws an error.
     * A proper monum is one of the following: a,-a,ax,-ax,x,-x,ax^b,-ax^b,x^b,-x^b,a x^b
     *Examples of bad monum are the following:7tl,4^2,(4+8),8*4,3/5,4..4,(6-7),(2+2)x^4,x^2*3,3t,3t^7,x^2*3,x*x,ax ^b,ax^ b,ax^-b,   ax^b   ;
     */
    public Monom(String s) throws NumberFormatException {
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
        catch (NumberFormatException e)
        {
            set_isValidMonom(false);
            throw new NumberFormatException("ERR: the string is null or string does contain a not parsable number\nor the string has invalid spaces");
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
     * Action done on a monom But note that the monum will not change at any point but only a new object type function will be created from the string
     * @param s String that will become a object type function
     * @return function type Monom
     */
    @Override
    public function initFromString(String s) {
        function init=new Monom(s);
        return init;
    }

    /**
     * Copies a monum to a type object function
     * @return function type Monom
     */
    @Override
    public function copy() {
        function copyMonom=new Monom(this.get_coefficient(),this.get_power());
        return copyMonom;
    }

    /**
     *The function checks whether the the monom is equal to a monom in deflection of Epsilon,if m is polynom or complex function
     * the comparison is done by their comparative function
     * @param m function for comparison
     * @return An boolean expression that signifies whether the monom is equal to a function or not
     */

    public boolean equals (Object m) {
    	/*Checks whether a monom type object,
		If so, it performs the appropriate comparison*/
        if(m instanceof Monom)
        {
            double dc = this.get_coefficient() -((Monom) m).get_coefficient();
            if (Math.abs(dc) < EPSILON && this.get_power() == ((Monom) m).get_power()) return true;
            return false;
        }
		/*
		Checks whether the object is a function type,
		That is, if it is a polynomial or a complex function then it performs the appropriate comparison
		 */
        else if (m instanceof function)
        {
            function f=(function) m;
            return f.equals(this);
        }
        else
        {
            return false;
        }
    }

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

