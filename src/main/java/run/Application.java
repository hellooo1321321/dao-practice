package run;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;

        int result =0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));

            String query = prop.getProperty("updateEmployee");

            Scanner sc = new Scanner(System.in);
            System.out.print("변경할 ID 를 입력해주세요 : ");
            int empID = sc.nextInt();
            System.out.print("변경할 이름을 입력해주세요 : ");
            sc.nextLine();
            String empName = sc.nextLine();
            System.out.print("변경할 주민번호를 입력해주세요 : ");
            String empNo = sc.nextLine();
            System.out.print("변경할 급여를 입력해주세요 : ");
            int sar = sc.nextInt();

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,empID);
            pstmt.setString(2,empName);
            pstmt.setString(3,empNo);
            pstmt.setInt(4,sar);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(pstmt);
        }

        if (result > 0 ){
            System.out.println("변경이 완료 되었습니다!!");
        }else {
            System.out.println("변경에 실패하였습니다!!");
        }


        // main 스위치문 employee == xml ==> 쿼리 , config,common
        // xml 파일
        // DTO ==> 필드에 저장해서 불어 //
        // DAO ==> DAO => 1234 /
        // 1. create   scn 8개                         //          DTO 지향
        // 2. read     emo_id  입력하세요 : 전체가읽     //
        // 3. update   emp_id , 이름 , 민증번호, 급여       //
        // 4. delete   emp_id 선택 전체 행 삭제            //
    }
}
