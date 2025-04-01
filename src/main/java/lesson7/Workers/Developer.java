package lesson7.Workers;

public class Developer extends Employee{
    public Developer(String name, Long salary) {
        super(name, salary);
    }

    public void work(){
        String builder = "My name is " +
                name +
                ". I'm Developer" +
                ". My salary is " +
                salary;

        System.out.println(builder);
    }
}
