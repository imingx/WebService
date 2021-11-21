package server;

import java.sql.*;

public class MySQL {

    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://rm-2zeu3f7e1n5yt10v0co.mysql.rds.aliyuncs.com/xml" +
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    final String USER = "root";
    final String PASS = "myja&*$4X579cKr";

    public ResultSet sql_queryStudentInCourse(String teacher_id, String course_id) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM teacher_course " +
                    "WHERE teacher_id='%s' AND course_id=%s";

            sql = String.format(sql, teacher_id, course_id);
            rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                return rs;
            }

            sql = "SELECT id, name FROM student_course AS sc, student " +
                    "WHERE sc.course_id=%s AND sc.student_id=student.id";

            sql = String.format(sql, course_id);

            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return rs;
    }

    public void sql_openCourse(String teacher_id, String course_name) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "INSERT INTO course(name) VALUES('%s')";

            sql = String.format(sql, course_name);

            stmt.executeUpdate(sql);

            sql = "SELECT id FROM course WHERE name='%s'";
            sql = String.format(sql, course_name);

            rs = stmt.executeQuery(sql);

            String id = null;
            while (rs.next()) {
                id = rs.getString("id");
            }

            sql = "INSERT INTO teacher_course(teacher_id, course_id) " +
                    "VALUES ('%s', %s)";
            sql = String.format(sql, teacher_id, id);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }

    public boolean sql_deleteCourse(String teacher_id, String course_id) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM teacher_course " +
                    "WHERE teacher_id='%s' AND course_id=%s";

            sql = String.format(sql, teacher_id, course_id);
            rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                return false;
            }

            sql = "DELETE FROM course " +
                    "WHERE id=%s";

            sql = String.format(sql, course_id);
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean sql_changeTeacherPassword(String id, String oldPass, String newPass) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM teacher " +
                    "WHERE id='%s' AND password='%s'";

            sql = String.format(sql, id, oldPass);
            rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                return false;
            }

            sql = "UPDATE teacher " +
                    "SET password='%s' " +
                    "WHERE id='%s'";
            sql = String.format(sql, newPass, id);
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean sql_changeStudentPassword(String id, String oldPass, String newPass) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM student " +
                    "WHERE id='%s' AND password='%s'";

            sql = String.format(sql, id, oldPass);
            rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                return false;
            }

            sql = "UPDATE student " +
                    "SET password='%s' " +
                    "WHERE id='%s'";
            sql = String.format(sql, newPass, id);
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean sql_dropCourse(String stu_id, String course_id) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM student_course " +
                    "WHERE student_id='%s' AND course_id=%s";

            sql = String.format(sql, stu_id, course_id);
            rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                return false;
            }

            sql = "DELETE FROM student_course " +
                    "WHERE student_id='%s' AND course_id=%s";

            sql = String.format(sql, stu_id, course_id);
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean sql_selectCourse(String stu_id, String course_id) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM student_course " +
                    "WHERE student_id='%s' AND course_id=%s";

            sql = String.format(sql, stu_id, course_id);
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return false;
            }

            sql = "SELECT * FROM course WHERE id=%s";
            sql = String.format(sql, course_id);
            rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                return false;
            }

            sql = "INSERT INTO student_course(student_id, course_id) VALUES('%s', %s)";
            sql = String.format(sql, stu_id, course_id);

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ResultSet sql_queryTeacherCourse(String id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT c.id AS id, c.name AS name FROM course AS c, teacher_course AS tc " +
                    "WHERE c.id=tc.course_id AND tc.teacher_id='%s' " +
                    "ORDER BY c.id";

            sql = String.format(sql, id);
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet sql_queryStudentCourse(String id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT c.id AS id, c.name AS name FROM course AS c, student_course AS sc " +
                    "WHERE c.id=sc.course_id AND sc.student_id='%s' " +
                    "ORDER BY c.id";

            sql = String.format(sql, id);
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet sql_queryAllCourse() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT course.id AS id, course.name AS name, teacher.name AS tn FROM course, teacher, teacher_course AS tc " +
                    "WHERE course.id=tc.course_id AND tc.teacher_id=teacher.id " +
                    "ORDER BY course.id";

            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet sql_queryStudent() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM student";

            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet sql_findStudent(String id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM student WHERE id='%s'";
            sql = String.format(sql, id);
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void sql_registerStudent(String id, String password, String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "INSERT INTO student(id, password, `name`) VALUES('%s', '%s', '%s')";
            sql = String.format(sql, id, password, name);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet sql_findTeacher(String id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM teacher WHERE id='%s'";
            sql = String.format(sql, id);
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void sql_registerTeacher(String id, String password, String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "INSERT INTO teacher(id, password, `name`) VALUES('%s', '%s', '%s')";
            sql = String.format(sql, id, password, name);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet sql_queryTeacher() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT * FROM teacher";

            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
