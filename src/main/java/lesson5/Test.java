package lesson5;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму вклада: ");
        float depositAmount = scanner.nextFloat();

        System.out.print("Введите срок вклада в месяцах: ");
        int months = scanner.nextInt();

        Bank bank = new Bank(depositAmount, months);
        float finalAmount = bank.getFinalAmountByFor();
        float finalAmount2 = bank.getFinalAmountByWhile();

        System.out.printf("После %d месяцев сумма вклада составит %f%n", months, finalAmount);

        System.out.printf("После %d месяцев сумма вклада составит %f%n", months, finalAmount2);
    }
}
