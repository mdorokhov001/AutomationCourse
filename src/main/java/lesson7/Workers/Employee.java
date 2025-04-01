package lesson7.Workers;

public class Employee {
    String name;
    Long salary;

    public Employee(String name, Long salary){
        this.name = name;
        this.salary = salary;
    }

    public void work(){
        String builder = "My name is " +
                name +
                ". I'm Employee" +
                ". My salary is " +
                salary;

        System.out.println(builder);
    }

}
