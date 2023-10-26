package com.ll;

import java.util.Scanner;

class Myeong {
    int num;
    String myeongeon;
    String author;


    Myeong(int num, String myeongeon, String author) {
        this.num = num;
        this.myeongeon = myeongeon;
        this.author = author;
    }

    void get() {
        System.out.println(num + " / " + author + " / " + myeongeon);
    }

    void set() {
        System.out.println("명언(기존) : " + myeongeon);
        System.out.print("명언 : ");
        Scanner scanner = new Scanner(System.in);
        String newmyeongeon = scanner.nextLine();
        this.myeongeon = newmyeongeon;

        System.out.println("작가(기존) : " + author);
        System.out.print("작가 : ");
        String newauthor = scanner.nextLine();
        this.author = newauthor;
    }
}
