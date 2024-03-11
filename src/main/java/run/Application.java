package run;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;

import model.dao.CreateDAO;

import model.dao.DELDAO;
import model.dto.ReadDTO;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


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

            pstmt.setString(1,empName);
            pstmt.setString(2,empNo);
            pstmt.setInt(3,sar);
            pstmt.setInt(4,empID);



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
////
//
//
//         main 스위치문 employee == xml ==> 쿼리 , config,common
//         xml 파일
//         DTO ==> 필드에 저장해서 불어 //
//         DAO ==> DAO => 1234 /
//         1. create   scn 8개                         //          DTO 지향
//         2. read     emo_id  입력하세요 : 전체가읽     //
//         3. update   emp_id , 이름 , 민증번호, 급여       //
//         4. delete   emp_id 선택 전체 행 삭제            //
//
//
//         신규 사원 등록

//        Connection con = getConnection();
//        CreateDAO registDAO = new CreateDAO();
//
//
//
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("등록할 사원번호(ID)를 입력해주세요 : ");
//        String empId = sc.nextLine();
//
//        System.out.print("등록할 사원 이름을 입력해주세요 : ");
//        String empName = sc.nextLine();
//
//        System.out.print("등록할 주민등록번호를 입력해주세요(ex. 123456-7891234) : ");
//        String empNo = sc.nextLine();
//
//        System.out.print("등록할 e-mail을 입력해주세요 : ");
//        String email = sc.nextLine();
//
//        System.out.print("등록할 전화번호를 입력해주세요 : ");
//        String phone = sc.nextLine();
//
//        System.out.print("등록할 부서코드를 입력해주세요(ex. D9 : ");
//        String deptCode = sc.nextLine();
//
//        System.out.print("등록할 직급코드를 입력해주세요(ex. J1 : ");
//        String jobCode = sc.nextLine();
//
//        System.out.print("등록할 급여등급을 입력해주세요(ex. S1 : ");
//        String salLevel = sc.nextLine();
//
//        System.out.print("등록할 급여를 입력해주세요 : ");
//        int salary = sc.nextInt();
//
//        System.out.print("등록할 보너스를 입력해주세요(ex. 0.3) : ");
//        double bonus = sc.nextDouble();
//        sc.nextLine();
//
//        System.out.print("등록할 관리자사번을 입력해주세요(ex. 200) : ");
//        String managerId = sc.nextLine();
//
//        System.out.print("등록할 입사일을 입력해주세요(ex. yyyy-MM-dd 형식으로) : ");
//        Date hireDate = Date.valueOf(sc.nextLine());
//
//
//        System.out.print("등록할 퇴사일을 입력해주세요 : ");
//        Date entDate = Date.valueOf(sc.nextLine());
//
//        System.out.print("등록할 퇴직여부를 입력해주세요('Y' 또는 'N') : ");
//        String entYN = sc.nextLine();
//
//        ReadDTO newEmployee = new ReadDTO(empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, bonus, managerId, hireDate, entDate, entYN);
//
//        registDAO.createNewEmployee(con,newEmployee);

//        CreateDAO app1 = new CreateDAO();
//
//        result = app1.DELETE(con);
//
//
//        DELDAO del = new DELDAO(con);
//        del.DELETE(con);

    }

}