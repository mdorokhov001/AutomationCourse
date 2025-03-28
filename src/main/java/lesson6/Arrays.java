package lesson6;

public class Arrays {
    public static void main(String[] args) {
        String[] array = {"привет", "ПОКА", "гипербола"};
        System.out.println(array[0].toUpperCase());
        System.out.println(array[1].toLowerCase());

        for (String str:array) {
            char secondChar = str.charAt(1);

            if(secondChar == 'О'){
                StringBuilder newStr = new StringBuilder(str);
                newStr.insert(2, " ");
                System.out.println(newStr);
            }
        }
    }
}
