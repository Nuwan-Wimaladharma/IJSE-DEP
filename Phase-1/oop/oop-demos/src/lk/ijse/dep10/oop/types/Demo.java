package lk.ijse.dep10.oop.types;

public class Demo {
    public static void main(String[] args) {
        TopLevelClass instance1 = new TopLevelClass();
        AnotherTopLevelClass instance2 = new AnotherTopLevelClass();
        new TopLevelClass.StaticNestedClass();

        new TopLevelClass().new RegularInnerClass();
        instance1.new RegularInnerClass();

        int x = 10; //Local Variable
        class LocalInnerClass{

        }
        new LocalInnerClass();
    }
}
class TopLevelClass {
    class RegularInnerClass{
        int x = 10; //not a local variable
        {
            int x = 10; //local variable(this is in a block inside a class)
            class LocalInnerClass2{

            }
        }
        class RegularInnerClass2{

        }

    }
    static class StaticNestedClass{

    }
}
class AnotherTopLevelClass{

}
