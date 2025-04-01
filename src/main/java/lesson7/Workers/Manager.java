package lesson7.Workers;

public class Manager extends Employee{
    public Manager(String name, Long salary) {
        super(name, salary);
    }

    public void work(){
        String builder = "My name is " +
                name +
                ". I'm Manager" +
                ". My salary is " +
                salary;

        System.out.println(builder);
    }


}
