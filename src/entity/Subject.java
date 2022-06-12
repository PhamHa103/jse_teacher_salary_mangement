package entity;

import java.util.Scanner;

public class Subject implements inputable {

    public static int AUTO_ID = 100;
    private int id;
    private String name;
    private int totalPeriod;
    private int theoryPeriod;
    private int cost;

    public Subject() {
        this.id = AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(int totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public int getTheoryPeriod() {
        return theoryPeriod;
    }

    public void setTheoryPeriod(int theoryPeriod) {
        this.theoryPeriod = theoryPeriod;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Môn học " + name + " có " +
                "id =" + id +
                ", tổng số tiết =" + totalPeriod + " trong đó" +
                " số tiết lý thuyết = " + theoryPeriod +
                ", mức kinh phí =" + cost +
                '.';
    }

    @Override
    public void inputInfor() {
        System.out.println("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập tổng số tiết: ");
        this.totalPeriod = new Scanner(System.in).nextInt();
        System.out.println("Nhập số tiết lý thuyết: ");
        int temp = 0;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp <= this.totalPeriod)
                break;
            System.out.print("Số tiết lý thuyết <= tổng số tiết(" + this.totalPeriod + "). Xin mời bạn nhập lại: ");
        } while (true);
        this.theoryPeriod = temp;
        System.out.println("Nhập mức kinh phí: ");
        int temp2 = 0;
        do {
            temp2 = new Scanner(System.in).nextInt();
            if (temp2 >0)
                break;
            System.out.print("Mức kinh phí phải có giá trị lớn hơn 0. Xin mời bạn nhập lại: ");
        } while (true);
        this.cost = temp2;
    }
}
