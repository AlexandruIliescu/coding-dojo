package practice.clean_code;

public class OCP {
}

interface PricingStrategy {
    double calculatePrice(double price);
}

class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        // Default pricing calculation logic
        return 0;
    }
}

class DiscountPricingStrategy implements PricingStrategy {
    private double discountPercentage;

    public DiscountPricingStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(double price) {
        // Discount pricing calculation logic based on discountPercentage
        return 0;
    }
}

class SpecialOfferPricingStrategy implements PricingStrategy {
    private double specialOfferPrice;

    public SpecialOfferPricingStrategy(double specialOfferPrice) {
        this.specialOfferPrice = specialOfferPrice;
    }

    @Override
    public double calculatePrice(double price) {
        // Special offer pricing calculation logic based on specialOfferPrice
        return 0;
    }
}

class PricingService {
    private PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFinalPrice(double price) {
        return pricingStrategy.calculatePrice(price);
    }
}

// Client code example
class ExampleClientOcp {
    public static void main(String[] args) {
        PricingService pricingService = new PricingService();

        // Set different pricing strategies dynamically
        pricingService.setPricingStrategy(new DefaultPricingStrategy());
        double finalPrice1 = pricingService.calculateFinalPrice(100.0);

        pricingService.setPricingStrategy(new DiscountPricingStrategy(0.2));
        double finalPrice2 = pricingService.calculateFinalPrice(100.0);

        pricingService.setPricingStrategy(new SpecialOfferPricingStrategy(80.0));
        double finalPrice3 = pricingService.calculateFinalPrice(100.0);

        // Use the finalPrice values as needed
    }
}

