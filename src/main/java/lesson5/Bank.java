package lesson5;

public class Bank {
    float depositAmount;
    int months;
    float interestRate = 0.07f;

    public Bank(float depositAmount, int months){
        this.depositAmount = depositAmount;
        this.months = months;
    }

    public float getFinalAmountByFor(){

        float finalAmount = depositAmount;
        for (int i = 0; i < months; i++) {
            finalAmount += finalAmount * interestRate;
        }

        return finalAmount;
    }

    public float getFinalAmountByWhile(){

        float finalAmount = depositAmount;

        while (months != 0){
            finalAmount += finalAmount * interestRate;
            months--;
        }
        return finalAmount;
    }
}