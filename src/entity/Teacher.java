package entity;

import constant.Specialization;

import java.util.Comparator;
import java.util.Scanner;

public class Teacher extends Person {

    public static int AUTO_ID = 100;

    private Specialization specialization;

    public Teacher() {
        super.id = AUTO_ID++;
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Giảng viên có " +
                "id=" + id +
                ", tên là '" + name + '\'' +
                ", địa chỉ '" + adress + '\'' +
                ", SĐT '" + phone + '\'' +
                ", trình độ học vấn " + specialization +
                '.';
    }

    @Override
    public void inputInfor() {
        super.inputInfor();
        inputTeacherSpecialization();
    }

    private void inputTeacherSpecialization() {
        System.out.println("Trình độ của giảng viên mới");
        System.out.println("1. Giáo sư - Tiến sỹ");
        System.out.println("2. Phó giáo sư - Tiến sỹ");
        System.out.println("3. Giảng viên chính");
        System.out.println("4. Thạc sỹ");
        System.out.print("Xin mời chọn: ");
        int number = 0;
        do {
            number = new Scanner(System.in).nextInt();
            if (number >= 1 && number <= 4)
                break;
            System.out.print(" Bạn nhập sai rồi, xin mời nhập lại: ");
        } while (true);
        switch (number) {
            case 1:
                this.specialization = Specialization.GS_TS;
                break;
            case 2:
                this.specialization = Specialization.PGS_TS;
                break;
            case 3:
                this.specialization = Specialization.GIANG_VIEN_CHINH;
                break;
            case 4:
                this.specialization = Specialization.THAC_SY;
                break;
        }
    }
}
