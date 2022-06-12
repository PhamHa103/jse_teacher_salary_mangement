package service;

import entity.Teacher;

import java.util.Scanner;

public class ServiceTeacher {

    public static Teacher[] TEACHERS = new Teacher[100];

    public static void printTeacher() {
        if (isEmptyTeacher()) {
            System.out.println("Thư viện hiện không có giáo viên nào!");
            return;
        } else {
            System.out.println("Danh sách giáo viên của thư viện: ");
            for (int i = 0; i < TEACHERS.length; i++) {
                if (TEACHERS[i] != null)
                    System.out.println(TEACHERS[i]);
            }
        }
    }

    public static boolean isEmptyTeacher() {
        for (int i = 0; i < TEACHERS.length; i++) {
            if (TEACHERS[i] != null)
                return false;
        }
        return true;
    }

    public static void inputNewTeacher() {
        System.out.print("Xin mời nhập số lượng giảng viên mới muốn thêm: ");
        int teacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNumber; i++) {
            System.out.println("Xin mời nhập thông tin giảng viên thứ " + (i + 1));
            Teacher teacher = new Teacher();
            teacher.inputInfor();
            saveTeacherInfo(teacher);
        }
    }

    public static void saveTeacherInfo(Teacher teacher) {
        for (int j = 0; j < TEACHERS.length; j++) {
            if (TEACHERS[j] == null) {
                TEACHERS[j] = teacher;
                break;
            }
        }
    }

    public static boolean teacherIsExisted(int input) {
        for (int i = 0; i < TEACHERS.length; i++) {
            if (TEACHERS[i] != null && TEACHERS[i].getId() == input)
                return true;
        }
        return false;
    }
}
