package server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher {

    public String queryStudentInCourse(String[] sicArg) {
        String teacher_id = sicArg[0];
        String course_id = sicArg[1];
        MySQL sql = new MySQL();

        ResultSet rs = null;
        String ans = "";

        rs = sql.sql_queryStudentInCourse(teacher_id, course_id);

        try {
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                ans += "," + id;
                ans += "," + name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public void OpenCourse(String[] openCouArg) {
        String teacher_id = openCouArg[0];
        String course_name = openCouArg[1];
        MySQL sql = new MySQL();

        sql.sql_openCourse(teacher_id, course_name);
        return;
    }

    public boolean deleteCourse(String[] deleCouArg) {
        String teacher_id = deleCouArg[0];
        String course_id = deleCouArg[1];
        MySQL sql = new MySQL();

        return sql.sql_deleteCourse(teacher_id, course_id);
    }

    public boolean changeTeacherPassword(String[] chanPassArg) {
        String teacher_id = chanPassArg[0];
        String oldPassword = chanPassArg[1];
        String newPassword = chanPassArg[2];
        MySQL sql = new MySQL();
        return sql.sql_changeTeacherPassword(teacher_id, oldPassword, newPassword);
    }

    public String queryTeacherCourse(String teacher_id) {
        MySQL sql = new MySQL();
        ResultSet rs = sql.sql_queryTeacherCourse(teacher_id);

        String ans = "";

        try {
            while (rs.next()) {
                String course_id = rs.getString("id");
                String name = rs.getString("name");
                ans += "," + course_id;
                ans += "," + name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String queryAllCourse(int nothing) {
        MySQL sql = new MySQL();
        ResultSet rs = sql.sql_queryAllCourse();

        String ans = "";

        try {
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String teacherName = rs.getString("tn");
                ans += "," + id;
                ans += "," + name;
                ans += "," + teacherName;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getName(String id) {
        MySQL sql = new MySQL();
        ResultSet rs = sql.sql_findTeacher(id);
        try {
            if (rs.next()) {
                String name = rs.getString("name");
                return name;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean teacherLogin(String logArg[]) {
        String id = logArg[0];
        String password = logArg[1];
        MySQL sql = new MySQL();

        ResultSet rs = sql.sql_findTeacher(id);
        try {
            if (rs.next()) {
                String pw = rs.getString("password");
                if (!password.equals(pw)) {
                    System.out.println("登录失败");
                    return false;
                }
            } else {
                System.out.println("登录失败");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("登录成功");
        return true;
    }

    public String teacherQuery() {
        MySQL sql = new MySQL();
        ResultSet rs = sql.sql_queryTeacher();
        String ans = "";

        try {
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                ans += "," + id;
                ans += "," + name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询所有老师信息" + ans);
        return ans;
    }


    public boolean teacherRegister(String regArg[]) {
        String id = regArg[0];
        String password = regArg[1];
        String name = regArg[2];

        MySQL sql = new MySQL();
        ResultSet rs = sql.sql_findTeacher(id);
        try {
            if (rs.next()) {
                System.out.println("注册失败:" + id);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.sql_registerTeacher(id, password, name);
        System.out.println("注册成功:" + id);
        return true;
    }


}
