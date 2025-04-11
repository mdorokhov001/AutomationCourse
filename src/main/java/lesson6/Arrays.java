package lesson6;

public class Arrays {
    static String[] array = {"привет", "ПОКА", "гипербола"};
    public static void main(String[] args) {

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

        generateString();
    }

    public static void generateString(){
        System.out.println("\nРандомная строка:");
        System.out.println(array[randomNum()]);
    }

    public static int randomNum(){
        return (int) (Math.random()*3);
    }
}
