package model.dao;

import model.dto.ReadDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;

public class READDAO {

    private Properties prop = new Properties();

    public READDAO() {

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readEmployee(Connection con){

        PreparedStatement ptsmt = null;
        ResultSet rset = null;
        int result = 0;

        ReadDTO row = null;
        String query = prop.getProperty("readEmployee");
        List<ReadDTO> empList = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("ID 값을 입력하세요 : ");
        int id = sc.nextInt();
        try {
            ptsmt = con.prepareStatement(query);
            ptsmt.setInt(1, id);

            rset = ptsmt.executeQuery();
            empList = new ArrayList<>();
            while (rset.next()) {
                row = new ReadDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("EMAIL"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYN(rset.getString("ENT_YN"));

                empList.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(ptsmt);
        }

        for (ReadDTO emp : empList) {
            System.out.println(emp);
        }
    }


}
