package Question1;

public class Question1 {
    public static void main(String[]args){
        StackCalc calc= new StackCalc();

        calc.StackCalculator("( 4 + ( 4 * 8 ) )");
        calc.StackCalculator("( 4 + 4 * 8 )"); //doesn't work -- answer should be 36, gives 32
        calc.StackCalculator("( ( 4 / 2 ) / 2 )");
        calc.StackCalculator("( ( ( 4 + 10 ) / 7 ) - 6 )");

        calc.StackCalculator("( ( exp 5 ) + 5 )");
        calc.StackCalculator("( ( log 5 ) - 2 )");
    }
}
