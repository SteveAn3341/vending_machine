

public class Snack extends Product {
    public boolean isVegan;


    public Snack(String name, double price, boolean vegan) {
        super(name, price);
        this.isVegan = vegan;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "isVegan=" + isVegan +
                '}';
    }
}
