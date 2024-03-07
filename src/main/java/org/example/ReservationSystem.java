package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystem {
    private Map<String, StudyRoom> studyRooms;
    private List<String> inquiries; // 문의

    public ReservationSystem() {
        this.studyRooms = new HashMap<>();
        this.inquiries = new ArrayList<>();
    }

    //스터디룸 추가
    public void addStudyRoom(StudyRoom room) {
        studyRooms.put(room.getName(), room);
    }

    // 예약 현황 출력
    public void printReservationStatus() {
        System.out.println("\n----- 예약 현황 -----");
        System.out.println("| A | B | C |");
        for (int i = 10; i <= 22; i++) {
            String time = i < 12 ? "오전 " + i + "시" : i == 12 ? "오후 12시" : "오후 " + (i - 12) + "시";
            System.out.print(time);
            int finalI = i;
            studyRooms.forEach((name, room) -> {
                System.out.print("| " + (room.getBookings().get(finalI) ? "O" : "X") + " ");
            });
            System.out.println("|");
        }
    }

    // 스터디룸 예약 처리
    public void reserveStudyRoom(Scanner scanner) {
        System.out.println("\n----- 스터디룸 예약 -----");
        System.out.print("예약할 스터디룸: ");
        String roomName = scanner.next();
        StudyRoom room = studyRooms.get(roomName.toUpperCase());

        if (room == null) {
            System.out.println("스터디룸 " + roomName + "는 존재하지 않습니다.");
            return;
        }

        System.out.print("사용 시작 시간: ");
        int start = scanner.nextInt();
        System.out.print("사용 종료 시간: ");
        int end = scanner.nextInt();

        if (room.book(start, end)) {
            System.out.println("예약이 완료되었습니다!");
        } else {
            System.out.println("스터디룸 " + roomName + "는 해당 시간에 이미 예약되어 있습니다.");
        }
    }

    //사용자 문의 저장
    public void leaveInquiry(Scanner scanner) {
        System.out.println("\n----- 문의 남기기 -----");
        System.out.print("문의 내용: ");
        scanner.nextLine(); // 버퍼 비우기
        String inquiry = scanner.nextLine();
        inquiries.add(inquiry);
        System.out.println("문의가 저장되었습니다!");
    }

    // 모든 문의 출력
    public void printInquiries() {
        System.out.println("\n----- 문의 리스트 보기 -----");
        inquiries.forEach(inquiry -> System.out.println("문의 내용: " + inquiry));
    }
}
