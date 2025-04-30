package lesson14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SortingBoxes {
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        fillTheList(boxes, 5);

        System.out.println("Исходные коробки:");
        printBoxContent(boxes);

        List<Box> wideBoxes = filterBoxesByWidth(boxes);

        System.out.println("\nКоробки с шириной > 30:");
        printBoxContent(wideBoxes);

        System.out.println("\nОставшиеся коробки:");
        printBoxContent(boxes);
    }


    public static List<Box> filterBoxesByWidth(List<Box> boxes) {
        List<Box> wideBoxes = new ArrayList<>();
        Iterator<Box> iterator = boxes.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getWidth() > 30) {
                wideBoxes.add(box);
                iterator.remove();
            }
        }

        return wideBoxes;
    }


    public static void fillTheList(List<Box> boxes, int count){
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int width = random.nextInt(100) + 1;
            int height = random.nextInt(100) + 1;
            int depth = random.nextInt(100) + 1;

            boxes.add(new Box(width, height, depth));
        }
    }

    public static void printBoxContent(List<Box> boxes){
        for (Box box : boxes) {
            System.out.println(box);
        }
    }
}
