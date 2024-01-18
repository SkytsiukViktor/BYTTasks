public class Main {
    public static void main(String[] args) {
        Chain chainCalc1=new AddNumbers();
        Chain chainCalc2=new SubNumbers();
        Chain chainCalc3=new MultNumbers();
        Chain chainCalc4=new DivNumbers();

        chainCalc1.setNextChain(chainCalc2);
        chainCalc2.setNextChain(chainCalc3);
        chainCalc3.setNextChain(chainCalc4);
        //here should be printed first number, second number,and one of the operations "add" "sub" "mult" "div"
        Numbers request=new Numbers(4,2,"mult");
        chainCalc1.calculate(request);
    }
}
