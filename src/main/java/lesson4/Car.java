package lesson4;

public class Car {
    String model;
    int year;

    public Car(String model, int year){
        this.model = model;
        this.year = year;
    }

    public void makeBeBe(){
        String stringBuilder = "|  " + model +
                " ".repeat(Math.max(0, 17 - model.length())) +
                " | " + year + "  |";
        System.out.println(stringBuilder);
    }
}
