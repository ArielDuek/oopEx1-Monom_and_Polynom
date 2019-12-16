package Ex1;

/**
 * This class represents a Complex Function, with the operators: plus, mul, div, max, min, comp.
 * see: https://en.wikipedia.org/wiki/Complex_analysis#Complex_functions
 * The class implements complex_function that extend function and represent with the shape: OP(left,right).
 * OP-> the operator that we are using,
 * left-> the first function,
 * right-> the second function.
 */
public class ComplexFunction implements complex_function {
    public static final double EPSILON = 0.0000001;
    private function left;
    private function right;
    private Operation op;

    /**
     * A definitive constructor that initializes both functions to be Null and the operator to be None
     */
    public ComplexFunction() {
        this.left = null;
        this.right = null;
        this.op = Operation.None;
    }

    /**
     * @param op     string that marks a mathematical operation (Operation)
     * @param fLeft  intended to be a left function
     * @param fRight intended to be a right function
     * will send the values to constructor of -> ComplexFunction(String op, function fleft, function fright)
     */
    public ComplexFunction(Operation op, function fLeft, function fRight)
    {
        this(op.toString(), fLeft,  fRight);
    }

    /**
     * @param op     string that marks a mathematical operation (String)
     * @param fLeft  intended to be a left function
     * @param fRight intended to be a right function
     */
    public ComplexFunction(String op, function fLeft, function fRight) {
        op = opFromString(op);
        op = op.toLowerCase();
        switch (op) {

            case "plus": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Plus;
            }
            break;

            case "mul": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Times;
            }
            break;

            case "div": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Divid;
            }
            break;

            case "max": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Max;
            }
            break;

            case "min": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Min;
            }
            break;

            case "comp": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Comp;
            }
            break;

            default:
                System.out.println("ERR:The operation is invalid");
                break;

        }

    }

    /**
     *constructor that accepts one function and puts it as the left function, the operator will be None and the right function will be null
     * @param fLeft intended to be a left function
     */
    public ComplexFunction(function fLeft)
    {
        this.left = fLeft;
        this.op = Operation.None;
        this.right = null;
    }

    /**
     * (Shallow) Copy constructor.
     * @param original The ComplexFunction object that needs to be copied
     */
    public ComplexFunction(ComplexFunction original)
    {
        this.op=original.getOp();
        this.left=original.left();
        this.right=original.right();
    }


    /**
     * this method will add selected function f to this function
     * @param f the function that will be added to this function
     */
    @Override
    public void plus(function f) {
        function f1 = f.copy();
        if(f1==null)
        {
            throw new RuntimeException("the functiom cant be null");
        }
        else if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Plus;
        }
        else
        {
            this.left = new ComplexFunction(this);
            this.right = f1;
            this.op = Operation.Plus;
        }
    }

    /**
     * this method will multiply selected function f with this function
     * @param f the function that will be multiplied with this function
     */
    @Override
    public void mul(function f) {
        function f1 = f.copy();
        if(f1==null)
        {
            throw new RuntimeException("the functiom cant be null");
        }
        else if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Times;
        }
        else
        {
            this.left = new ComplexFunction(this);
            this.right = f1;
            this.op = Operation.Times;
        }
    }

    /**
     * this method will divid selected function f with this function
     * @param f the function that will be divided with this function
     */
    @Override
    public void div(function f) {
        function f1 = f.copy();
        if(f1==null)
        {
            throw new RuntimeException("the functiom cant be null");
        }
        else if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Divid;
        }
        else
        {
            this.left = new ComplexFunction(this);
            this.right = f1;
            this.op = Operation.Divid;
        }
    }

    /**
     * this method will return to this function the maximum of the selected function f and this function
     * @param f the function that will be compared with this function - to compute the maximum.
     */
    @Override
    public void max(function f) {
        function f1 = f.copy();
        if(f1==null)
        {
            throw new RuntimeException("the functiom cant be null");
        }
        else if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Max;
        }
        else
        {
            this.left = new ComplexFunction(this);
            this.right = f1;
            this.op = Operation.Max;
        }
    }

    /**
     * this method will return to this function the minimum of the selected function f and this function
     * @param f the function that will be compared with this function - to compute the minimum.
     */
    @Override
    public void min(function f) {
        function f1 = f.copy();
        if(f1==null)
        {
            throw new RuntimeException("the functiom cant be null");
        }
        else if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Min;
        }
        else
        {
            this.left = new ComplexFunction(this);
            this.right = f1;
            this.op = Operation.Min;
        }
    }

    /**
     * This method wrap the function f with this function: this.f(f1(x)) and return to this function
     * @param f the function that will be wraped on this function.
     */
    @Override
    public void comp(function f) {
        function f1 = f.copy();
        if(f1==null)
        {
            throw new RuntimeException("the functiom cant be null");
        }
        else if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Comp;
        }
        else
        {
            this.left = new ComplexFunction(this);
            this.right = f1;
            this.op = Operation.Comp;
        }
    }

    /**
     * get left.
     * @return The left function from ComplexFunction
     */
    @Override
    public function left() { return this.left;}

    /**
     * get right.
     * @return The right function from ComplexFunction
     */
    @Override
    public function right() { return this.right; }

    /**
     * get op.
     * @return The Operation from ComplexFunction
     */
    @Override
    public Operation getOp() {
        return this.op;
    }

    /**
     * @return String Which symbolizes the ComplexFunction
     * Prints ComplexFunction as follows: op(function,function).
     */
    public String toString()
    {
        if(this.op==Operation.None)
        {
            return this.left().toString();
        }
        else
        {
            StringBuilder s = new StringBuilder();
            s.append(this.opToString() + "(" + this.left().toString() + "," + this.right().toString() + ")");
            return s.toString();
        }
    }

    /**
     * @return String Which symbolizes the operator of this ComplexFunction
     * Prints operator (max, min, plus, div, mul, comp, error)
     */
    public String opToString()
    {
        switch (this.op)
        {
            case Max:
                return "max";
            case Min:
                return "min";
            case Comp:
                return "comp";
            case Plus:
                return "plus";
            case Divid:
                return "div";
            case Times:
                return "mul";
            default:
                return "error";

        }
    }

    /**
     * @return String Which symbolizes the operator of this ComplexFunction
     * this helper method return String Op with given String that represent one of the operators.
     * Prints operator (max, min, plus, div, mul, comp, error)
     */
    public String opFromString(String s)
    {
        switch (s)
        {
            case "Max":
                return "max";
            case "Min":
                return "min";
            case "Comp":
                return "comp";
            case "Plus":
                return "plus";
            case "Divid" :
                return "div";
            case "Times":
                return "mul";
            case "None":
                return "";
            case "plus":
                return "plus";
            case "mul":
                return "mul";
            case "div":
                return "div";
            case "max":
                return "max";
            case "min":
                return "min";
            case "comp":
                return "comp";
            default:
                return "error";

        }
    }

    /**
     * @param x The X value at the point
     * @return double Which symbolizes the Y value
     * The function calculates the Y value at a point in this ComplexFunction.
     */
    @Override
    public double f(double x) {
        switch (this.op)
        {
            case Max:
                return Math.max(this.left.f(x),this.right.f(x));
            case Min:
                return Math.min(this.left.f(x),this.right.f(x));
            case Comp:
                return this.left.f(this.right.f(x));
            case Plus:
                return (this.left.f(x))+(this.right.f(x));
            case Divid: {
                if (this.right.f(x) == 0)
                    throw new ArithmeticException("It is not allowed to divide by 0");
                else {
                    return (this.left.f(x)) / (this.right.f(x));
                }
            }
            case Times:
                return (this.left.f(x))*(this.right.f(x));
            case None:
                return this.left.f(x);
            default:
                return 0;
        }
    }

    /**
     * @param s String that will become a object type function
     * @return function type ComplexFunction
     * Action done on a ComplexFunction But note that the ComplexFunction will not change at any point but only a new object type ComplexFunction will be created from the string
     */
    @Override
    public function initFromString(String s) {
        deleteSpaces(s);
        function ans = null;
        s = s.toLowerCase();
        String st = s.substring(0,s.indexOf("(")+1);
        int start = s.indexOf(st);
        if(start>=0 && s.endsWith(")")) {
            int commaInd = mainComma(s.substring(start+st.length(),s.length()-1));
            function left = initFromString(s.substring(start+st.length(),start+st.length()+commaInd));
            function right = initFromString(s.substring(start+st.length()+commaInd+1,s.length()-1));
            String op = st.substring(0,st.length()-1);
            ans = new ComplexFunction(op,left,right);
        }
        else {
            function a=new Polynom();
            ans = a.initFromString(s);
        }
        return ans;
    }

    /**
     * This static function returns the index of main comma (","),
     * in case of an invalid from returns -1;
     * @param s: represents a form
     * @return the index of the main comma (-1 if none).
     */
    private static int mainComma(String s) {
        int ans = -1;
        int c =0;
        boolean found = false;
        for(int i=0;i<s.length() && !found;i++) {
            char ch = s.charAt(i);
            if(ch=='(') {c++;}
            if(ch==')') {c--;}
            if(ch==',' && c==0) {
                ans = i;
                found=true;
            }
        }
        return ans;
    }

    /**
     * this helper method remove from a given String the spaces -" " that show before or after the symbol '+'/'-'
     * @param s the given String to romove the spaces from.
     */
    public  void  deleteSpaces (String s){
        StringBuffer spDel = new StringBuffer();
        for (int i = 0; i < s.length() ; i++) {
            if ((s.charAt(i)!=' ') || (s.charAt(i)==' ' && (i==0 || i==s.length()-1)) || (s.charAt(i)==' ' && !(s.charAt(i+1)=='+' || s.charAt(i+1)=='-' || s.charAt(i-1)=='+' || s.charAt(i-1)=='-'))) spDel.append(s.charAt(i));
        }
        s=spDel.toString();
    }

    /**
     * (deep) Copy constructor.
     * this method return a copy of The ComplexFunction object that needs to be copied
     */
    @Override
    public function copy() {
        if(this instanceof ComplexFunction)
        {
            function f=new ComplexFunction(this);
            return f;
        }
        else
        {
            function f=this.copy();
            return f;
        }
    }

    /**
     * this method check if given Object c ios equals to this ComplexFunction
     * @param c the given Object that need to be compered with this ComplexFunction
     * @return boolean value- True if equals and False if not equals.
     */
    public boolean equals(Object c)
    {
        try {
            function cFunction = (function) c;
            boolean ans = true;
            double left = 0;
            double right = 0;
            for (int i = -80; i <= 80 && ans; i++) {
                try {
                    left = this.f(i);
                    right = cFunction.f(i);
                    if (Math.abs(left - right) > EPSILON)
                        ans = false;
                    if (!ans) {
                        left = (double) Math.round((this.f(i) * 10000000000000000d) / 10000000000000000d);
                        right = (double) Math.round((cFunction.f(i) * 10000000000000000d) / 10000000000000000d);
                        if (Math.abs(left - right) > EPSILON)
                            ans = false;
                        else
                            ans = true;
                    }
                }
                catch (Exception e){
                    continue;
                }
            }
            return ans;
        }
        catch (Exception e){
            return false;
        }
    }
}