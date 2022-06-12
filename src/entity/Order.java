package entity;

public class Order {
    private Teacher teacher;
    private OrderDetail[] OrderDetails;

    public Order() {

    }

    public Order(Teacher teacher, OrderDetail[] orderDetails) {
        this.teacher = teacher;
        OrderDetails = orderDetails;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public OrderDetail[] getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(OrderDetail[] orderDetails) {
        OrderDetails = orderDetails;
    }

    public int getSumPeriod() {
        int sum = 0;
        for (int i = 0; i < OrderDetails.length; i++) {
            if (OrderDetails[i] != null)
                sum += (OrderDetails[i].getSubject().getTotalPeriod() * OrderDetails[i].getNumberClass());
        }
        return sum;
    }

    public double getSumCost() {
        double sumCost = 0;
        for (int i = 0; i < OrderDetails.length; i++) {
            if (OrderDetails[i] != null)
                sumCost += OrderDetails[i].getSumCostOfOneSubject();
        }
        return sumCost;
    }
}
