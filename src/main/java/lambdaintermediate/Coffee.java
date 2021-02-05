package lambdaintermediate;

import java.math.BigDecimal;

public class Coffee {
    BigDecimal price;
    CoffeeType coffeeType;

    public Coffee(CoffeeType coffeeType, BigDecimal price) {
        this.price = price;
        this.coffeeType = coffeeType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }
}
