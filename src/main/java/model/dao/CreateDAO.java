package model.dao;

import model.dto.ReadDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import common.JDBCTemplate.close;

import static common.JDBCTemplate.close;

public class CreateDAO {

    private Properties prop = new Properties();

    public CreateDAO() {

        try {
            prop.loadFromXML((new FileInputStream("src/main/java/mapper/menu-query.xml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public int createNewEmployee(Connection con, ReadDTO newEmployee) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("createEmployee");

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, newEmployee.getEmpId());
            pstmt.setString(2, newEmployee.getEmpName());
            pstmt.setString(3, newEmployee.getEmpNo());
            pstmt.setString(4, newEmployee.getEmail());
            pstmt.setString(5, newEmployee.getPhone());
            pstmt.setString(6, newEmployee.getDeptCode());
            pstmt.setString(7, newEmployee.getJobCode());
            pstmt.setString(8, newEmployee.getSalLevel());
            pstmt.setInt(9, newEmployee.getSalary());
            pstmt.setDouble(10, newEmployee.getBonus());
            pstmt.setString(11, newEmployee.getManagerId());
            pstmt.setDate(12, newEmployee.getHireDate());
            pstmt.setDate(13, newEmployee.getEntDate());
            pstmt.setString(14, newEmployee.getEntYN());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;

    }

}
