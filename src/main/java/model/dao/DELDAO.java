package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class DELDAO {



    public DELDAO(Connection con) {
    }

    public void DELETE(Connection con) {

        Properties prop = new Properties();

        PreparedStatement pstmt = null;
        int result = 0;
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));
            String query = prop.getProperty("deleteEMP");

            Scanner sc = new Scanner(System.in);
            System.out.println("삭제할 사원번호를 입력해주세요 : ");
            int EMP_ID = sc.nextInt();

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, EMP_ID);

            result = pstmt.executeUpdate();
//            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
//            String query = prop.getProperty("deleteMenu");
//            Scanner sc = new Scanner(System.in);
//            System.out.print("삭제 코드 입력 : ");
//            int categotyCode = sc.nextInt();
//
//            pstmt = con.prepareStatement(query);
//            pstmt.setInt(1,categotyCode);
//
//            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

        if (result > 0) {
            System.out.println("사원번호 삭제에 성공했습니다.");
        } else {
            System.out.println("사원번호 삭제에 실패했습니다.");
        }



    }
}
