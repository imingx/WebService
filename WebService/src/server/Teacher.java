package server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher {
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


    public boolean teacherRegister(String id, String password, String name) {
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
