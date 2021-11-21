package com.webservice.client;

import com.webservice.student.Student;
import com.webservice.student.StudentService;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = studentService.getStudent();
        Scanner scanner = new Scanner(System.in);
        int ins;
        while(true) {
            System.out.println("选择登陆老师还是学生账号，或者结束：（1）老师，（2）学生，（3）退出");
            ins = scanner.nextInt();
            if (ins == 2) {
                MyStudent stu = new MyStudent();
                stu.run();
                System.out.println("您已成功退出学生界面！");
            } else if (ins == 1) {
                MyTeacher tea = new MyTeacher();
                tea.run();
                System.out.println("您已成功退出老师界面！");
            } else if(ins == 3){
                System.out.println("成功结束程序！");
                break;
            } else {
                System.out.println("error!");
            }
        }
    }
}
