package org.example;

import java.util.HashMap;
import java.util.Map;

class StudyRoom {
    private String name; // 스터디룸의 이름
    Map<Integer, Boolean> bookings; // 시간별 예약 상태를 저장하는 맵. <시간과 예약 상태>

    public String getName() {
        return this.name;
    }

    public Map<Integer, Boolean> getBookings() {
        return this.bookings;
    }

    public StudyRoom(String name) {
        this.name = name;
        this.bookings = new HashMap<>();
        for (int i = 10; i <= 22; i++) { // 22시까지 예약 가능하지만 운영은 10시까지
            bookings.put(i, false); // 초기는 모두 flase로 설정
        }
    }

    // 예약
    public boolean book(int start, int end) {
        for (int i = start; i < end; i++) {
            if (bookings.getOrDefault(i, false)) {
                return false;
            }
        }
        for (int i = start; i < end; i++) {
            bookings.put(i, true);
        }
        return true;
    }

    // 스터디룸 예약 정보 출력
    public void printBookingStatus() {
        System.out.println("| " + name + " |");
        for (int i = 10; i <= 22; i++) {
            String time = i < 12 ? "오전 " + i + "시" : i == 12 ? "오후 12시" : "오후 " + (i - 12) + "시";
            System.out.println(time + "| " + (bookings.get(i) ? "O" : "X") + " |");
        }
    }
}

