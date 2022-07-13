public class Item {
    String name;
    String isExpense;
    double quantity;
    double price;


    public Item(String name, String isExpense, double quantity, double price) {
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;


    }




    public String getName() {
        return name;
    }

    public boolean getIsExpense() {return Boolean.parseBoolean(isExpense);
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrise() {
        return price;
    }

    public double getSumm() {
        return price*quantity;
    }


}
