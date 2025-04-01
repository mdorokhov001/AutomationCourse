package lesson7;

import lesson7.Shapes.Circle;
import lesson7.Shapes.Rectangle;
import lesson7.Shapes.Shape;
import lesson7.Workers.Developer;
import lesson7.Workers.Employee;
import lesson7.Workers.Manager;

public class Test {
    public static void main(String[] args) {
        Employee dev = new Developer("Sergey", 50000L);
        Employee manager = new Manager("Alexey", 100000L);

        System.out.println("Workers:");
        dev.work();
        manager.work();

        System.out.println("\nShapes:");
        Shape sh = new Circle();
        Shape rec = new Rectangle();
        sh.draw();
        rec.draw();
    }
}
