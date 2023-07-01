package practice.design_patterns.builder;

public class MainBuilder {

    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        Pizza pizza = pizzaBuilder
                .withDough("Thin crust")
                .withSauce("Tomato")
                .withTopping("Cheese")
                .build();

        System.out.println(pizza);

        pizza.describePizza();
    }
}