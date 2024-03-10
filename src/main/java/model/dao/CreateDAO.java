package model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;

public class CreateDAO {

    private Properties prop = new Properties();

    public CreateDAO(){
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int DELETE (Connection con){

        PreparedStatement pstmt = null;
        int result = 0;
        try {


            String query = prop.getProperty("deleteEMP_ID");

            Scanner sc = new Scanner(System.in);
            System.out.println("삭제할 사원번호를 입력해주세요 : ");
            String EMP_ID = sc.nextLine();

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "EMP_ID");

            result = pstmt.executeUpdate();


        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {


            close(pstmt);
        }

        if (result > 0) {
            System.out.println("사원번호 삭제에 성공했습니다.");
        } else {
            System.out.println("사원번호 삭제에 실패했습니다.");
        }


        return result;

    }

}
