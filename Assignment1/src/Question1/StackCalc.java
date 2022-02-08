package Question1;

import edu.princeton.cs.algs4.Stack;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;


public class StackCalc {
    public void StackCalculator(String numbers) {
        String[] expression = numbers.split(" ");

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        for(String token : expression){
            // Read token. push if operator.
            System.out.println(token);
            String s = token;
            if (s.equals ("(")) { /* do nothing */ }
            else if (s.equals ("+")) { ops.push(s); }
            else if (s.equals ("-")) { ops.push(s); }
            else if (s.equals ("*")) { ops.push(s); }
            else if (s.equals ("/")) { ops.push(s); }
            else if (s.equals ("sqrt")) { ops.push(s); }
            else if (s.equals ("log")){ ops.push(s);}
            else if (s.equals ("exp")){ ops.push(s);}
            else if (s.equals (")")) {
                // pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) { v = vals.pop() + v; }
                else if (op.equals("-")) { v = vals.pop() - v; }
                else if (op.equals("*")) { v = vals.pop() * v; }
                else if (op.equals("/")) { v = vals.pop() / v; }
                else if (op.equals("sqrt")) { v = Math.sqrt(v); }
                else if (op.equals("log")) { v = Math.log(v); }
                else if (op.equals("exp")) { v= Math.exp(v); }
                vals.push(v);
            } else {
                // Token no operator or paren; must be double value to push
                vals.push(Double.parseDouble(s));
            }
        }

        System.out.println(vals.pop());

        // set a breakpoint on this line and you can observe the state
        // of the ops stack and vals stack. You will need this for your
        // answer.
    }
}
