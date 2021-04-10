package practice.designPatterns.factory;

public class Main {

    public static void main(String[] args) {
        OS os = new Android();
        os.spec();
    }
}
