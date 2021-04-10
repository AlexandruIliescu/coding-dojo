package practice.lambda;

import static practice.lambda.Comparator.extracted;

import java.util.Objects;
import java.util.function.Function;

public class PersonComparator {

    private String name;
    private int age;

    public PersonComparator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@FunctionalInterface
interface Comparator<T> {

    int compare(T t1, T t2);

    static <T> Comparator<T> extracted(Function<T, String> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            String s1 = keyExtractor.apply(p1);
            String s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    }
}

class Test {

    public static void main(String[] args) {
        PersonComparator alex = new PersonComparator("alex", 33);
        PersonComparator olderAlex = new PersonComparator("olderAlex", 43);
        PersonComparator inTheMiddleAlex = new PersonComparator("inTheMiddleAlex", 40);

        Function<PersonComparator, String> getName = PersonComparator::getName;

        Comparator<PersonComparator> comp = extracted(getName);

        System.out.println(comp.compare(alex, olderAlex) > 0);
        System.out.println(comp.compare(olderAlex, inTheMiddleAlex) > 0);

    }
}