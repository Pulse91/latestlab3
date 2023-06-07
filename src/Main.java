public class Main {
    public static void main(String[] args) {
        Order order = new Order();

        order.attach(new PriceObserver());
        order.attach(new QuantityObserver());

        order.addItem(250);
        System.out.println(order);

        order.addItem(180);
        System.out.println(order);
    }
}