package lesson4;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Lada", 2000);
        Car car1 = new Car("Volkswagen", 2007);
        Car car2 = new Car("Lamborghini", 2015);

        System.out.println("---- MODEL --- YEAR ----");
        car.makeBeBe();
        car1.makeBeBe();
        car2.makeBeBe();

        car.model = "Lada Priora";
        car1.model = "Volkswagen Tiguan";
        car2.model = "Lamborghini Sian";

        System.out.println("------- CHANGING -------");
        car.makeBeBe();
        car1.makeBeBe();
        car2.makeBeBe();

        System.out.println("------------------------");
    }
}
