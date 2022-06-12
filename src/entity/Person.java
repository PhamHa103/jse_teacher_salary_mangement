package entity;

import java.util.Scanner;

public class Person implements inputable {


    protected int id;
    protected String name;
    protected String adress;
    protected String phone;


    public Person() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void inputInfor() {
        System.out.println("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.adress = new Scanner(System.in).nextLine();
        System.out.println("Nhập điện thoại: ");
        this.phone = new Scanner(System.in).nextLine();
    }
}
