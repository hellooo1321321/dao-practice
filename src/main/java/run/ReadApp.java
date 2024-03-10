package run;

import model.dao.READDAO;

import java.sql.Connection;

import static common.JDBCTemplate.getConnection;

public class ReadApp {


    public static void main(String[] args) {

        Connection con = getConnection();
        READDAO readDAO = new READDAO();
        readDAO.readEmployee(con);



    }
}
