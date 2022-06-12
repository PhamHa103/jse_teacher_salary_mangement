package service;

import entity.Subject;

import java.util.Scanner;

public class ServiceSubject {

    public static Subject[] SUBJECTS = new Subject[100];

    public static void printSubject() {
        if (isEmptySubject()) {
            System.out.println("Thư viện hiện không có môn học nào!");
            return;
        } else {
            System.out.println("Danh sách môn học của thư viện: ");
            for (int i = 0; i < SUBJECTS.length; i++) {
                if (SUBJECTS[i] != null)
                    System.out.println(SUBJECTS[i]);
            }
        }
    }

    public static boolean isEmptySubject() {
        for (int i = 0; i < SUBJECTS.length; i++) {
            if (SUBJECTS[i] != null)
                return false;
        }
        return true;

    }

    public static void inputNewSubject() {
        System.out.print("Xin mời nhập số lượng môn học mới muốn thêm: ");
        int subjectNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < subjectNumber; i++) {
            System.out.println("Xin mời nhập thông tin môn học thứ " + (i + 1));
            Subject subject = new Subject();
            subject.inputInfor();
            saveSubjectInfo(subject);
        }
    }

    public static void saveSubjectInfo(Subject subject) {
        for (int j = 0; j < SUBJECTS.length; j++) {
            if (SUBJECTS[j] == null) {
                SUBJECTS[j] = subject;
                break;
            }
        }
    }

    public static boolean subjectIsExisted(int input) {
        for (int i = 0; i < SUBJECTS.length; i++) {
            if (SUBJECTS[i] != null && SUBJECTS[i].getId() == input)
                return true;
        }
        return false;

    }
}
