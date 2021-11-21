package com.webservice.client;

import com.webservice.student.*;

import java.util.Scanner;

public class MyStudent {

    public String id;
    public String name;

    public void login() {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        Student student = studentService.getStudent();
        int ins;
        while (true) {
            System.out.println(this.id + " " + this.name + " 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码");
            ins = sc.nextInt();
            if (ins == 1) {
                break;
            } else if (ins == 2) {
                if (student.queryStudentCourse(this.id).equals("")) {
                    System.out.println("目前没选课程");
                } else {
                    String arg[] = student.queryStudentCourse(this.id).substring(1).split(",");
                    for (int i = 0; i < arg.length; i += 2) {
                        System.out.println("课程id:" + "" + arg[i] + "，课程名：" + arg[i + 1]);
                    }
                }
            } else if (ins == 3) {
                String arg[] = student.queryAllCourse(0x3f).substring(1).split(",");
                for (int i = 0; i < arg.length; i += 3) {
                    System.out.println("课程id:" + "" + arg[i] + "，课程名：" + arg[i + 1] + "，开课老师：" + arg[i + 2]);
                }
            } else if (ins == 4) {
                System.out.println("请输入选择的课程编号：");
                int course_id = sc.nextInt();

                SelcetArg selcetArg = new SelcetArg();
                selcetArg.getItem().add(this.id);
                selcetArg.getItem().add(course_id + "");
                if (student.selectCourse(selcetArg)) {
                    System.out.println("选课成功！");
                } else {
                    System.out.println("已经选了这门课或者这门课不存在，选课失败！");
                }
            } else if (ins == 5) {
                System.out.println("请输入需要退选课程的编号：");
                int course_id = sc.nextInt();

                DropArg dropArg = new DropArg();
                dropArg.getItem().add(this.id);
                dropArg.getItem().add(course_id + "");

                if (student.dropCourse(dropArg)) {
                    System.out.println("退课成功！");
                } else {
                    System.out.println("退课失败，该课程不存在或没有选择该课程！");
                }

            } else if (ins == 6) {
                System.out.println("请输入原密码和新密码：");
                String oldPassword = sc.next();
                String newPassword = sc.next();

                ChanPassArg chanPassArg = new ChanPassArg();
                chanPassArg.getItem().add(this.id);
                chanPassArg.getItem().add(oldPassword);
                chanPassArg.getItem().add(newPassword);

                if (student.changeStudentPassword(chanPassArg)) {
                    System.out.println("修改密码成功！");
                } else {
                    System.out.println("初始密码错误，修改失败！");
                }
            } else {
                System.out.println("wrong");
            }
        }
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        Student student = studentService.getStudent();
        this.id = null;
        this.name = null;
        int ins;
        while (true) {
            System.out.println("选择登录、注册账号或退出：（1）登录账号，（2）查询所有学生账户信息，（3）注册账号，（4）退出，");
            ins = sc.nextInt();
            if (ins == 4) {
                break;
            } else if (ins == 2) {
                String arg[] = student.studentQuery().substring(1).split(",");
                for (int i = 0; i < arg.length; i += 2) {
                    System.out.println("学生id:" + "" + arg[i] + "，学生姓名：" + arg[i + 1]);
                }
            } else if (ins == 3) {
                System.out.println("请输入学号，密码和姓名：");
                String id = sc.next();
                String password = sc.next();
                String name = sc.next();
                RegArg arg = new RegArg();
                arg.getItem().add(id);
                arg.getItem().add(password);
                arg.getItem().add(name);
                if (student.studentRegister(arg)) {
                    System.out.println("注册成功！");
                } else {
                    System.out.println("账号id重复，注册失败！");
                }
            } else if (ins == 1) {
                System.out.println("请输入账号，密码：");
                String id = sc.next();
                String password = sc.next();

                LogArg arg = new LogArg();
                arg.getItem().add(id);
                arg.getItem().add(password);
                if (!student.studentLogin(arg)) {
                    System.out.println("密码错误或不存在账号，登录失败！");
                } else {
                    this.id = id;
                    this.name = student.getName(id);
                    System.out.println("恭喜 " + id + " " + name + " 登录成功!");
                    login();
                    System.out.println("您已退出账号！");
                }
            } else {
                System.out.println("error");
            }
        }
    }
}
