package mvc.model.dao;

import mvc.domain.dto.RequestUserDto;
import mvc.domain.dto.ResponseUserDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MariaDao implements MvcDao{

    private static final String URL      = "jdbc:mysql://localhost:3306/mysql";
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
    private static final String ID       = "root";
    private static final String PASSWORD = "123456789";

    public MariaDao() {
        try {
            Class.forName(DRIVER) ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void joinRow() {
        System.out.println("MariaDB joinRow");
    }

    @Override
    public ResponseUserDto loginRow(RequestUserDto params) {
        System.out.println("debug >>> MariaDB loginRow()");
        System.out.println("debug >>> MariaDB id  : " + params.getId());
        System.out.println("debug >>> MariaDB pwd : " + params.getPwd());

        Connection conn 	= null ;
        PreparedStatement pstmt 	= null ;
        ResultSet rset    = null ;
        ResponseUserDto 	user    = null ;
        String SQL ="select ID, PWD, NAME from encore_user_tbl where id = ? and pwd = ?" ;
        try {
            conn = DriverManager.getConnection(URL, ID, PASSWORD) ;
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, params.getId())  ;
            pstmt.setString(2, params.getPwd()) ;
            rset = pstmt.executeQuery() ;

            while( rset.next() ) {
                user = new ResponseUserDto(rset.getString(1), rset.getString(2), rset.getString(3));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if( conn != null ) { conn.close(); }
            } catch(Exception e) {

            }
        }
        return user ;
    }

    @Override
    public void updateRow() {
        System.out.println("MariaDB updateRow");
    }

    @Override
    public void deleteRow() {
        System.out.println("MariaDB deleteRow");
    }

    @Override
    public List<ResponseUserDto> selectRow() {
        System.out.println("debug >>> MariaDB selectRow()");

        Connection conn 	= null ;
        PreparedStatement pstmt 	= null ;
        ResultSet rset    = null ;
        List<ResponseUserDto> list = new ArrayList<ResponseUserDto>();

        String SQL ="select ID, PWD, NAME from encore_user_tbl" ;
        try {
            conn = DriverManager.getConnection(URL, ID, PASSWORD) ;
            pstmt = conn.prepareStatement(SQL);
            rset = pstmt.executeQuery() ;

            while( rset.next() ) {
                ResponseUserDto user = new ResponseUserDto(rset.getString(1), rset.getString(2), rset.getString(3));
                list.add(user);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if( conn != null ) { conn.close(); }
            } catch(Exception e) {

            }
        }
        return list ;
    }
}
