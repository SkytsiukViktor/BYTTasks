public class Numbers {
    private int Number1;
    private int Number2;
    private String calculationWanted;
    public Numbers(int newNumber1,int newNumber2,String calcWanted){
        Number1=newNumber1;
        Number2=newNumber2;
        calculationWanted=calcWanted;
    }

    public int getNumber1() {
        return Number1;
    }

    public int getNumber2() {
        return Number2;
    }

    public String getCalculationWanted() {
        return calculationWanted;
    }
}
