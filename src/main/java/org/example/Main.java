package org.example;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.addStudyRoom(new StudyRoom("A"));
        reservationSystem.addStudyRoom(new StudyRoom("B"));
        reservationSystem.addStudyRoom(new StudyRoom("C"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n스터디룸 예약 프로그램입니다.\n");
            System.out.println("1. 스터디룸 예약");
            System.out.println("2. 예약 현황 조회");
            System.out.println("3. 문의 남기기");
            System.out.println("4. 문의 리스트 보기");
            System.out.println("5. 프로그램 종료\n");
            System.out.print("작업을 선택하세요: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationSystem.reserveStudyRoom(scanner);
                    break;
                case 2:
                    reservationSystem.printReservationStatus();
                    break;
                case 3:
                    reservationSystem.leaveInquiry(scanner);
                    break;
                case 4:
                    reservationSystem.printInquiries();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다...");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }
}
