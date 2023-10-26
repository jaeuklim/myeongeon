package com.ll;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class App {
    ArrayList<Myeong> arraylist = new ArrayList<Myeong>();
    int num = 1;
    int checkexist[] = new int[100];
    Scanner scanner = new Scanner(System.in);


    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                System.out.print("\n");
                System.out.println("프로그램 다시 시작...");
                System.out.print("\n");
                run();
            }

            if (cmd.equals("등록")) {
                actionWrite();
            }

            if (cmd.equals("목록")) {
                actionList();
            }

            if (cmd.startsWith("삭제")) {
                actionRemove(cmd);
            }

            if (cmd.equals("수정")) {
                System.out.print("?id=");
                int id = scanner.nextInt();

                arraylist.get(id - 1).set();
            }

            if (cmd.equals("빌드")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                // Java 객체를 JSON 문자열로 변환
                String json = gson.toJson(arraylist);

                try {
                    // JSON 데이터를 파일에 쓰기
                    FileWriter writer = new FileWriter("data.json");
                    writer.write(json);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("data.json 파일의 내용이 갱신되었습니다.");
            }
        }
    }

    void actionWrite() {
        System.out.print("명언 : ");
        String myeongeon = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        ;

        arraylist.add(new Myeong(num, myeongeon, author));
        checkexist[num - 1] = 1;

        System.out.println(num + "번 명언이 등록되었습니다");
        num++;
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------------");

        if(arraylist.isEmpty())
            System.out.println("등록된 명언이 없습니다.");
        for (int j = arraylist.size()-1; j>=0; j--) {
            arraylist.get(j).get();
        }
    }

    void actionRemove(String cmd) {

        System.out.print("?id=");
        int id = scanner.nextInt();

        if (checkexist[id - 1] == 0) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            arraylist.remove(id - 1);
            checkexist[id - 1] = 0;
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
    }
}



