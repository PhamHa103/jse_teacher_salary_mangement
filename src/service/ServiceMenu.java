package service;

import java.util.Scanner;

import static service.ServiceOrder.*;
import static service.ServiceSubject.inputNewSubject;
import static service.ServiceSubject.printSubject;
import static service.ServiceTeacher.inputNewTeacher;
import static service.ServiceTeacher.printTeacher;

public class ServiceMenu {
    public static void showMenu() {
        boolean isExit = false;
        do {
            int functionalChoice = functionalChoice();
            switch (functionalChoice) {
                case 1:
                    inputNewSubject();
                    break;
                case 2:
                    printSubject();
                    break;
                case 3:
                    inputNewTeacher();
                    break;
                case 4:
                    printTeacher();
                    break;
                case 5:
                    creatTableMangement();
                    break;
                case 6:
                    printTableMangement();
                    break;
                case 7:
                    sortByTeacherName();
                    printTableMangement();
                    break;
                case 8:
                    sortByTotalPeriod();
                    printTableMangement();
                    break;
                case 9:
                    printResultSalary();
                    break;
                case 10:
                    isExit = true;
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
            }
        } while (!isExit);

    }

    private static int functionalChoice() {
        System.out.println("------PHẦN MỀM QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN THÍNH GIẢNG--------");
        System.out.println("1. Nhập môn học mới");
        System.out.println("2. In ra danh sách môn học trong thư viện ");
        System.out.println("3. Nhập giảng viên mới");
        System.out.println("4. In ra danh sách giảng viên trong thư viện ");
        System.out.println("5. Lập bảng kê khai giảng dạy cho giảng viên ");
        System.out.println("6. In bảng kê khai giảng dạy cho giảng viên ");
        System.out.println("7. Sắp xếp danh sách mượn sách theo họ tên giảng viên ");
        System.out.println("8. Sắp xếp danh sách mượn sách theo số tiết giảng dạy mỗi môn (giảm dần) ");
        System.out.println("9. Lập bảng tính tiền công cho mỗi giảng viên");
        System.out.println("10. Kết thúc chương trình ");
        System.out.print("Xin mời chọn chức năng: ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 10)
                break;
            System.out.print("Bạn nhập sai rồi, xin mời nhập lại");
        } while (true);
        return choice;
    }
}
