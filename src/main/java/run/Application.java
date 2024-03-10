package run;

import model.dao.CreateDAO;

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


        // main 스위치문 employee == xml ==> 쿼리 , config,common
        // xml 파일
        // DTO ==> 필드에 저장해서 불어 //
        // DAO ==> DAO => 1234 /
        // 1. create   scn 8개                         //          DTO 지향
        // 2. read     emo_id  입력하세요 : 전체가읽     //
        // 3. update   emp_id , 이름 , 민증번호, 급여       //
        // 4. delete   emp_id 선택 전체 행 삭제            //


        CreateDAO app1 = new CreateDAO();
        int result = app1.DELETE(con);

    }
}
