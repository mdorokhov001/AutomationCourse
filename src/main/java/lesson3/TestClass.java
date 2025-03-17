package lesson3;

public class TestClass {
    static int staticVar = 0;
    public int pubVar;
    public int pubVar2;

    public TestClass(int pubVar, int pubVar2){
        this.pubVar = pubVar;
        this.pubVar2 = pubVar2;
    }

    public void useStaticVar(){
        staticVar += 1;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass(5, 10);
        System.out.println("Before: " + staticVar);
        testClass.useStaticVar();
        System.out.println("After: " + staticVar);


        System.out.println("Before: " + testClass.pubVar + " " + testClass.pubVar2);
        testClass.pubVar = 20;
        testClass.pubVar2 = 30;
        System.out.println("After: " + testClass.pubVar + " " + testClass.pubVar2);
    }
}
