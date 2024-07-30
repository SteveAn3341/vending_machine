public class Beverage extends Product {
    private double flOunces ;



    public Beverage(String name, double price, double flOunces) {
        super(name, price);
        if(flOunces < 0){
            throw new IllegalArgumentException("Invalid flOunces");
        };

            this.flOunces = flOunces;

    }

//    public Beverage(String name, double price) {
//        super(name, price);
//    }

    public double getFlOunces() {
        return flOunces;
    }

    public void setFlOunces(double flOunces) {
        this.flOunces = flOunces;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "flOunces=" + flOunces +
                '}';
    }
}
