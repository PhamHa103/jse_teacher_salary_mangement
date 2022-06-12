package service;

import entity.Order;
import entity.OrderDetail;
import entity.Subject;
import entity.Teacher;

import java.util.Comparator;
import java.util.Scanner;

import static service.ServiceSubject.*;
import static service.ServiceSubject.SUBJECTS;
import static service.ServiceTeacher.*;
import static service.ServiceTeacher.TEACHERS;

public class ServiceOrder {

    public static Order[] ORDERS = new Order[100];


    public static void printResultSalary() {
        System.out.println("Bảng tính tiền công cho mỗi nhân viên");
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null) {
                System.out.println("Giảng viên " + ORDERS[i].getTeacher().getName()
                        + " có tổng số tiết dạy là " + ORDERS[i].getSumPeriod());
                System.out.println("==> Tổng tiền là: " + ORDERS[i].getSumCost());
            }
        }
    }


    public static void printTableMangement() {
        System.out.println("--------------------------");
        System.out.println("Danh sách quản lý của hệ thống là: ");
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null) {
                System.out.println("Giảng viên " + ORDERS[i].getTeacher().getName() + " dạy các môn học là: ");
                for (int j = 0; j < ORDERS[i].getOrderDetails().length; j++) {
                    if (ORDERS[i].getOrderDetails()[j] != null)
                        System.out.println(ORDERS[i].getOrderDetails()[j]);
                }
            }
        }
    }

    public static void creatTableMangement() {
        if (isEmptySubject())
            System.out.println("Chưa có môn học trong thư viện. Không thể lập bảng!");
        else if (isEmptyTeacher())
            System.out.println("Chưa có giảng viên trong thư viện. KHông thể lập bảng!");
        else {
            System.out.print("Xin mời nhập số lượng giảng viên muốn nhập danh sách: ");
            int number = new Scanner(System.in).nextInt();
            for (int i = 0; i < number; i++) {
                System.out.println("Xin mời nhập thông tin muốn tạo của giảng viên thứ " + (i + 1));
                saveOneRecordToTable(creatOneRecord());
            }
        }
    }


    private static void saveOneRecordToTable(Order order) {
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] == null) {
                ORDERS[i] = order;
                break;
            }
        }

    }

    private static Order creatOneRecord() {
        Order order = null;

        // Tạo 1 giảng viên từ ID nhập vào
        // 1.1  Nhập ID giảng viên
        System.out.print("Xin mời nhập mã giảng viên: ");
        int tempTeacher = 0;
        do {
            tempTeacher = new Scanner(System.in).nextInt();
            if (teacherIsExisted(tempTeacher)) {
                break;
            }
            System.out.print("ID giảng viên không tồn tại trong hệ thống, xin mời bạn nhập lai: ");
        } while (true);
        //1.2  Lấy ra 1 giảng viên từ ID vừa nhập
        Teacher teacher = new Teacher();
        for (int i = 0; i < TEACHERS.length; i++) {
            if (TEACHERS[i] != null && TEACHERS[i].getId() == tempTeacher) {
                teacher = TEACHERS[i];
                break;
            }
        }
        // 2. Tạo ra mảng các OrderDetail
        OrderDetail[] ORDER_DETAILS = new OrderDetail[100];
        // 2.1 Nhập tổng số môn dạy
        System.out.println("Xin mời nhập tổng số môn dạy: ");
        int subjectNumber = new Scanner(System.in).nextInt();
        for (int j = 0; j < subjectNumber; j++) {
            System.out.println("Xin mời nhập thông tin của môn thứ " + (j + 1));
            // Nhập thông tin môn
            Subject subject = new Subject();
            System.out.print("Xin mời nhập ID môn học :");
            int temp = 0;
            do {
                temp = new Scanner(System.in).nextInt();
                if (subjectIsExisted(temp))
                    break;
                System.out.print("ID môn học không tồn tại trong hệ thống, xin mời bạn nhập lai: ");
            } while (true);
            // Lấy thông tin môn học từ hệ thống ra

            for (int i = 0; i < SUBJECTS.length; i++) {
                if (SUBJECTS[i] != null && SUBJECTS[i].getId() == temp) {
                    subject = SUBJECTS[i];
                    break;
                }
            }
            System.out.print("Xin mời nhập số lớp học: ");
            int numberClass = 0;
            do {
                numberClass = new Scanner(System.in).nextInt();
                if (numberClass > 0 && numberClass < 3)
                    break;
                System.out.print("Mỗi lớp có số nguyên dương vầ không lớn hơn 3, xin mời bạn nhập lai: ");
            } while (true);

            //Lưu thông tin mỗi môn vào 1 giá trị của mảng
            OrderDetail orderDetail = new OrderDetail(subject, numberClass);
            for (int k = 0; k < ORDER_DETAILS.length; k++) {
                if (ORDER_DETAILS[k] == null) {
                    ORDER_DETAILS[k] = orderDetail;
                    break;
                }
            }
        }
        //3. Set giá trị cho order
        order = new Order(teacher, ORDER_DETAILS);
        return order;
    }


    public static void sortByTotalPeriod() {
        for (int i = 0; i < ORDERS.length - 1; i++) {
            for (int j = i + 1; j < ORDERS.length; j++) {
                if (ORDERS[i] != null && ORDERS[j] != null && ORDERS[i].getSumPeriod() < ORDERS[j].getSumPeriod()) {
                    Order temp = ORDERS[i];
                    ORDERS[i] = ORDERS[j];
                    ORDERS[j] = temp;
                }
            }
        }
    }

    public static void sortByTeacherName() {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getTeacher().getName().compareTo(o2.getTeacher().getName());
            }
        };
        for (int i = 0; i < ORDERS.length - 1; i++) {
            for (int j = i + 1; j < ORDERS.length; j++) {
                if (ORDERS[i] != null && ORDERS[j] != null && comparator.compare(ORDERS[i], ORDERS[j]) > 0) {
                    Order temp = ORDERS[i];
                    ORDERS[i] = ORDERS[j];
                    ORDERS[j] = temp;
                }
            }
        }
    }

}
