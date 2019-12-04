package Ex1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 *
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
    public LinkedList <Monom> polinomLL;
    /**
     * Zero (empty polynom)
     */
    public Polynom()
    {
        polinomLL= new LinkedList<Monom>();
    }
    /**
     * init a Polynom from a String such as:
     *  {"x", "3+1.4X^3-34x", "2+2x^2+4x^5"};
     *  A proper polynomial is the connection or subtraction of proper monomies
     *  Incorrect input:
     *  (3x^2+1),(3x^2+1)*(9x+11),-(7x+7x^5)
     * @param s: is a string represents a Polynom
     */
    public Polynom(String s)
    {
        polinomLL= new LinkedList<Monom>();
        String current = "";
        s+="+";
        for (int i = 0; i < s.length(); i++){
            if ((s.charAt(i) == '+' || s.charAt(i)== '-') && current!=""){
                Monom a = new Monom(current);
                this.add(a);
                current = "" + s.charAt(i);

            }
            else{
                current+= s.charAt(i);
            }
        }
    }

    /**
     * A tool with which to go over the collection we chose - Link List
     * @return Iterator of Linked List
     */
    @Override
    public Iterator<Monom> iteretor() {
        return polinomLL.iterator();
    }

    /**
     * @param m1 The monom that is added to a polynom
     *The add function adds a monum to an existing polynomial as follows:
     * First, the function checks whether a monom exists in a polynomial that has the same power as the givien monum,
     * If so they are connected.
     * If the function does not find an equally power, then add the monum to the polynomial using a linked list function
     * and then the linked list is sent to the makeOrder function whose function is to sort the linked list.
     * We note that the polynomial list necessarily will always be arranged from large to small and there will also be
     * no repetition of the same power.
     */
    @Override
    public void add(Monom m1) {
        Iterator<Monom> iter = this.iteretor();
        boolean flag=true;
        while (iter.hasNext()&&flag)
        {
            Monom nextMonom=iter.next();
            if(nextMonom.get_power()==m1.get_power())
            {
                nextMonom.add(m1);
                this.deleteUnnecessaryZeros();
                flag=false;
            }
        }
        if(flag) {
            polinomLL.add(m1);
            this.makeOrder();

        }
    }

    /**
     *  makeOrder The function sorts the Linken List.
     *  This is done by the sorting function of the Linken List and the comparator we have defined
     */
    public void  makeOrder( )
    {
        Comparator<Monom> c =new Monom_Comperator();
        this.polinomLL.sort(c);
        this.deleteUnnecessaryZeros();
    }

    /**
     * The function removes unnecessary zeros from the polynomial
     */
    public void deleteUnnecessaryZeros()
    {
        boolean hasValid = false;
        Iterator<Monom> iter = this.iteretor();
        while (iter.hasNext())
        {
            Monom m = iter.next();
            if (m.isZero() && (iter.hasNext() || hasValid))
                iter.remove();
            else hasValid = true;
        }
    }

    /**
     * @param p1 The polynom that is added to a polynom on which the function works
     * A function that connects one polynomial with another polynomial.as follows:
     * Go over the polynomial you want to connect and add a monom monom to the desirable polynom.
     *This is done thanks to the function that adds monom with polynom.
     */
    @Override
    public void add(Polynom_able p1) {
        Iterator<Monom> iter =p1.iteretor();
        while(iter.hasNext())
        {
            this.add (iter.next());
        }
    }
    /**
     *Deep copy of Polynom_able
     */
    @Override
    public function copy() {

        function toCopy=new Polynom();
        Iterator<Monom> x = this.iteretor();
        while(x.hasNext())
        {
            Monom temp = x.next();
            if(toCopy instanceof Polynom_able )
            {
                ((Polynom_able)toCopy).add(new Monom(temp));
            }
        }
        return toCopy;
    }

    /**
     * @return String Which symbolizes the polynom
     * Prints polynom as follows: ax^b+...+ax^b
     */
    public String toString()
    {
        String ans = "";
        Iterator<Monom> iter = this.iteretor();
        while (iter.hasNext()) {
            Monom m = iter.next();
            if (m.get_coefficient()>=0) ans+="+";
            ans+=m.toString();
        }
        if (ans.charAt(0) == '+')ans= ans.substring(1);
        return ans;
    }

    @Override
    public function initFromString(String s) {
        function init=new Polynom(s);
        return init;
    }

    /**
     * @param x The X value at the point
     * @return double Which symbolizes the Y value
     * The function calculates the Y value at a point
     */
    @Override
    public double f(double x) {
        double sum=0;
        Iterator<Monom> iter =this.iteretor();
        while (iter.hasNext())
        {
            Monom next=iter.next();
            sum+=next.f(x);
        }
        return sum;
    }

    /**
     * @param m1 Is the monom with which we multiply the polynom on which the function works
     * The function multiplies a polynomial by a monom.as follows:
     * Pass the polynomial in the form of a monom-monom and multiply every monom that belongs to the polynom in the giveing monom
     */
    @Override
    public void multiply(Monom m1) {
        Iterator<Monom> iter = this.iteretor();
        while (iter.hasNext()) {
            Monom m = iter.next();
            m.multipy(m1);
        }
    }

    /**
     * @param p1 The polynom that subtract from the polynom on which the function works
     * The function substract polynoms.as follows:
     * Multiplies the polynomial P1 by -1 and then add P1 to the polynom that needs to be subtracted from P1.
     */
    @Override
    public void substract(Polynom_able p1) {
        Polynom_able toSub = (Polynom_able) p1.copy();
        toSub.multiply(Monom.MINUS1);
        this.add(toSub);
        this.makeOrder();
    }

    /**
     * @param p1 Is the polynom with which we multiply the polynom on which the function works
     *The function multiplies a polynomial by another polynomial.as follows:
     * Pass the polynom p1 in the form of a monom-monom and  multiply every monom that belongs to the polynom p1 in the giveing polynom
     * Connecting the multiplication of monom in polynomial will be the desired result.
     */
    @Override
    public void multiply(Polynom_able p1) {
        Polynom ans = new Polynom();
        Iterator<Monom> iter = p1.iteretor();
        while (iter.hasNext()) {
            Polynom_able i = new Polynom(this.toString());
            Monom m = new Monom( iter.next().toString());
            if (!m.isZero()) {
                i.multiply(m);
                ans.add(i);
            }
        }
        ans.makeOrder();
        this.multiply(Monom.ZERO);
        this.add(ans);
    }

    /**
     * @param p1 The polynomial compare to the second polynomial
     * @return Boolean answer that says whether the polynomial is equal or not
     *The function checks whether the polynomials are equal.as follows:
     * Compare a monom in the first polynom to a monom in the second polynom if they are not equal then return false.
     * This is how all monomes are checked, if all are equal return true.
     */
    @Override
    public boolean equals(Object p1) {
        if(p1 instanceof Polynom)
        {
            Polynom p2=(Polynom)p1;
            boolean isEquals = true;
            Iterator<Monom> iter1 = this.iteretor();
            Iterator<Monom> iter2 = p2.iteretor();
            while (iter1.hasNext() && iter2.hasNext()) {
                Monom m = iter1.next();
                Monom n = iter2.next();
                if (!m.equals(n)) isEquals = false;
            }
            return isEquals;
        }

        return false;
    }

    /**
     * @return A boolean expression that represents whether the polynomial is a zero polynomial or not
     *The function checks whether the polynomial is a zero polynomial or not.as follows:
     * We will go over the polynom in a monom-monom if every monom is the zero monom then the polynom
     * is the zero polynom, because our linked list is always without repetition of power.
     */
    @Override
    public boolean isZero() {
        boolean ans = true;
        Iterator<Monom> iter = this.iteretor();
        while (iter.hasNext()) {
            Monom m = iter.next();
            if(!m.isZero()) ans=false;
        }
        return ans;
    }

    /**
     * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps
     * assuming (f(x0)*f(x1)<=0, else should throws runtimeException
     * computes f(x') such that:
     * 	(i) x0<=x'<=x1 &&
     * 	(ii) |f(x')|<eps
     * 	Set the MIDX to be the average of X0 and X1 and according to the Intermediate Value Theorem,
     * 	we can find a close point to intersect with the X axis (a small distance from the defined epsilon)
     * 	by substituting the value corresponding to the MIDX mark (positive or negative) and repeat the
     * 	partitioning and comparison process until the root is found
     * @param x0 starting point
     * @param x1 end point
     * @param eps>0 (positive) representing the epsilon range the solution should be within.
     * @return an approximated value (root) for this (cont.) function
     */
    @Override
    public double root(double x0, double x1, double eps) {
        if (eps<0) throw new RuntimeException("eps need to be positive");
        if (x0 > x1)throw new RuntimeException("x0 need to be start point and x1 end point");
        if (this.f(x0)*this.f(x1)>0) throw new RuntimeException("they are in the same side");
        double midx = (x0+x1)/2;
        while (Math.abs(this.f(midx))>=eps){
            if (this.f(x0)*this.f(midx)< 0 ) x1 = midx;
            else x0 = midx;
            midx = (x0+x1)/2;
        }
        return midx;
    }

    /**
     * @return The polynomial which is the derivative of the polynomial for which the function rise works
     *The function calculates the derivative of the polynomial.as follows:
     * We will go over the polynom in a monom-monom Then every monom is derived.
     * The interconnection of all the derived monomers will form the derived polynomial
     */
    @Override
    public Polynom_able derivative() {
        Polynom_able der = new Polynom();
        Iterator<Monom> iter = this.iteretor();
        while (iter.hasNext()) {
            Monom m = iter.next();
            der.add(m.derivative());
        }
        return der;
    }
    /**
     * @param x0 starting pooint
     * @param x1 end point
     * @param eps positive step value
     * @return the approximated area above X-axis below this function bounded in the range of [x0,x1]
     * Compute a Riman's integral from x0 to x1 in eps steps.
     *Verify that positive epsilon is considered trapezoidal areas
     *starting from X0 in Epsilon steps until we reach X1 only for
     *positive heights for these X values, the amount of these areas
     *is the area requested
     * for more info : https://en.wikipedia.org/wiki/Trapezoidal_rule
     */
    @Override
    public double area(double x0, double x1, double eps) {
        if (eps<0) throw new RuntimeException("eps need to be positive");
        double area = 0 , x0eps = x0 + eps;
        if (x0>=x1){
            return 0;
        }
        while (x0<=x1){
            if (this.f(x0)>=0 && this.f(x0eps)>=0) {
                area+= (((this.f(x0) + this.f(x0eps)) / 2) * eps);
            }
            x0+=eps;
            x0eps = x0 + eps;
        }
        return area;
    }
}
