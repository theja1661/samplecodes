import java.util.ArrayList;
import java.util.List;

class Order {
    private Integer orderId;
    private String customerName;
    private Double baseAmount;

    public Order(Integer orderId, String customerName, Double baseAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.baseAmount = baseAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Double getBaseAmount() {
        return baseAmount;
    }
    public void setBaseAmount(Double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Double calculateTotal(){
        return this.baseAmount;
    }

    public String getOrderSummary(){
        return "Order [orderId=" + orderId + ", customerName=" + customerName + ", totalAmount=" + baseAmount + "]";
    }
    
}

class DiscountedOrder extends Order{
    
    private Double discountedRate;

    public DiscountedOrder(Integer orderId, String customerName, Double baseAmount, Double discountRate) {
        super(orderId, customerName, baseAmount);
        this.discountedRate = discountRate;
    }


    @Override
    public Double calculateTotal() {
        return super.getBaseAmount() - ((super.getBaseAmount() * discountedRate) / 100);
    }

    public Double getDiscountedRate() {
        return discountedRate;
    }

    public void setDiscountedRate(Double discountedRate) {
        this.discountedRate = discountedRate;
    }

    @Override
     public String getOrderSummary(){
        return "DiscountedRate [orderId=" + super.getOrderId() + ", customerName=" + super.getCustomerName() + ", total amount=" + calculateTotal() +  "]";
    }
    
}

class MainRunner {
    public static void main(String[] args) {
        Order order1 = new Order(101, "Alice", 1000D);
        Order order2 = new DiscountedOrder(102, "Bob", 2000D, 10D);
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.stream()
      .forEach(order -> 
          System.out.println(order.getOrderSummary()));
    }
}