package Ex1;

public class ComplexFunction implements complex_function {
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
     * @param op     string that marks a mathematical operation
     * @param fLeft  intended to be a left function
     * @param fRight intended to be a right function
     */
    public ComplexFunction(String op, function fLeft, function fRight) {
        op = op.toLowerCase();
        switch (op) {

            case "plus": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Plus;
            }
            break;

            case "times": {
                this.left = fLeft;
                this.right = fRight;
                this.op = Operation.Times;
            }
            break;

            case "divid": {
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
        this.left=fLeft;
        this.op=Operation.None;
        this.right=null;
    }

    /**
     * Copy constructor.
     * @param original The ComplexFunction object that needs to be copied
     */
    public ComplexFunction(ComplexFunction original)
    {
        this.op=original.getOp();
        this.left=original.left();
        this.right=original.right();
    }

    @Override
    public void plus(function f1) {
        if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Plus;
        }
        else
        {
            this.left = this;
            this.right = f1;
            this.op = Operation.Plus;
        }
    }

    @Override
    public void mul(function f1) {
        if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Times;
        }
        else
        {
            this.left = this;
            this.right = f1;
            this.op = Operation.Times;
        }
    }

    @Override
    public void div(function f1) {
        if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Divid;
        }
        else
        {
            this.left = this;
            this.right = f1;
            this.op = Operation.Divid;
        }
    }

    @Override
    public void max(function f1) {
        if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Max;
        }
        else
        {
            this.left = this;
            this.right = f1;
            this.op = Operation.Max;
        }
    }

    @Override
    public void min(function f1) {
        if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Min;
        }
        else
        {
            this.left = this;
            this.right = f1;
            this.op = Operation.Min;
        }
    }

    @Override
    public void comp(function f1) {
        if(this.getOp()==Operation.None)
        {
            this.right=f1;
            this.op=Operation.Comp;
        }
        else
        {
            this.left = this;
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

    public String toString()
    {
        StringBuilder s=new StringBuilder();
        s.append(this.opToString());
        if(this.left!=null)
        {
            s.append("("+this.left().toString());
        }
        if(this.right!=null)
        {
            s.append(","+this.right().toString()+")");
        }
        return s.toString();
    }
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
            case None:
               return "none";
            default:
                return "error";

        }
    }

    @Override
    public double f(double x) {
        return 0;
    }

    @Override
    public function initFromString(String s) {
        return null;
    }

    @Override
    public function copy() {
        return null;
    }
}
