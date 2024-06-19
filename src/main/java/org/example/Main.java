package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RawJdbcMain {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        try {
            // 데이터 삽입 예제
            userDAO.insertUser("홍길동", "hong@example.com");
            System.out.println("데이터가 삽입되었습니다.");

            // 데이터 조회 예제
            ResultSet resultSet = userDAO.getUsers();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: "+id+", 이름: "+name+", 이메일: "+email);
            }

            // 데이터 수정 예제
            userDAO.updateUserEmail("홍길동", "hong_gil_dong@example.com");
            System.out.println("데이터가 수정되었습니다.");

            // 데이터 삭제 예제
            userDAO.deleteUser("홍길동");
            System.out.println("데이터가 삭제되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}