package lesson6;

public class Arrays {
    public static void main(String[] args) {
        String[] array = {"привет", "ПОКА", "гипербола"};
        System.out.println(array[0].toUpperCase());
        System.out.println(array[1].toLowerCase());

        StringBuilder newStr = new StringBuilder(array[2]);
        newStr.replace(2, 3,"О");
        newStr.insert(3, " ");
        System.out.println(newStr);
    }
}
