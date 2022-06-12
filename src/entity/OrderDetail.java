package entity;

public class OrderDetail {
    private Subject subject;
    private int numberClass;

    public OrderDetail(Subject subject, int numberClass) {
        this.subject = subject;
        this.numberClass = numberClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }

    public double getSumCostOfOneSubject() {
        return (((this.subject.getTotalPeriod() - this.subject.getTheoryPeriod()) * 0.7 + this.subject.getTheoryPeriod())
                * this.subject.getCost()
                * this.getNumberClass());
    }


    @Override
    public String toString() {
        return subject +
                ", tổng số lớp dạy: " + numberClass +
                '.';
    }
}
