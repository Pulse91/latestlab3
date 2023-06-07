public class QuantityObserver implements OrderObserver
{
    public void update(Order order) {
        if (order.getItemCount() > 5) {
            order.setShippingCost(0);
        } else {
            order.setShippingCost(10);
        }
    }
}