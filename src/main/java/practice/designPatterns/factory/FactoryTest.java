package practice.designPatterns.factory;

import java.awt.Color;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FactoryTest {
    public static void main(String[] args) {
        Factory<Circle> factory = Factory.createFactory(Circle::new, Color.RED);
        Circle circle = factory.newInstance();
        System.out.println(circle);

        List<Circle> list = factory.create5();
        System.out.println(list);

        list.forEach(potato  -> {

        });
    }
}

@FunctionalInterface
interface Factory<T> extends Supplier<T> {
    default T newInstance() {
        return get();
    }
    default List<T> create5() {
        return IntStream.range(0, 5)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    }
    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        return supplier::get;
    }

    //partial application - take a function and make it a supplier
    static <T, P> Factory<T> createFactory(Function<P, T> constructor, P color) {
        return () -> constructor.apply(color);
    }
}

class Circle {

    private Color color;

    public Circle() {
        this(Color.WHITE);
    }

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + color +
                '}';
    }
}