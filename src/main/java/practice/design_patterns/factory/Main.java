package practice.design_patterns.factory;

public class Main {

    public static void main(String[] args) {
        OS os = new Android();
        os.spec();
    }
}
