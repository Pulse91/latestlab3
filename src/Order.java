import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private double totalPrice;
    private int itemCount;
    private double shippingCost;
    private double discount;

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void addItem(double price) {
        totalPrice += price;
        itemCount += 1;
        notifyObservers();
    }

    public void setShippingCost(double cost) {
        shippingCost = cost;
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice - discount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public String toString()
    {
        return "Total Price: $" + getTotalPrice() + "\n" + "Item Count: " + getItemCount() + "\n" + "Shipping Cost: $" + getShippingCost();
    }
}
