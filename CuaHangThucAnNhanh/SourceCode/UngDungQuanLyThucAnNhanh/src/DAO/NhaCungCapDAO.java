/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import UTIL.MyDBConnection;
import DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class NhaCungCapDAO {

    MyDBConnection myconnect = new MyDBConnection("localhost","root", "","doanjava");
    static Connection conn =null;
    Statement st = null;
    ResultSet rs = null;
    
    public NhaCungCapDAO(){
        if(myconnect==null){
            try{
              conn=myconnect.getConnection();
            }catch (Exception e) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    public ArrayList docDSNCC() throws Exception {
        ArrayList dsNCC = new ArrayList<NhaCungCapDTO>();
        try {
            String qry = "Select * from nhacungcap";
            rs = myconnect.excuteQuery(qry);
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.id = rs.getInt(1);
                ncc.ten = rs.getString(2);
                ncc.sdt = rs.getString(3);
                ncc.mail = rs.getString(4);
                ncc.dc = rs.getString(5);
                ncc.tinhtrang = rs.getInt(6);

                dsNCC.add(ncc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhà cung cấp");
        }
        return dsNCC;
    }

    public void them(NhaCungCapDTO ncc) throws  Exception{
        try {
            String qry = "insert into NhaCungCap value(";
            qry = qry + "'" + ncc.id + "'";
            qry = qry + "," + "'" + ncc.ten + "'";
            qry = qry + "," + "'" + ncc.sdt + "'";
            qry = qry + "," + "'" + ncc.mail + "'";
            qry = qry + "," + "'" + ncc.dc + "'";
            qry = qry + "," + "'" + ncc.tinhtrang + "'";
            qry = qry + ")";
            
            myconnect.executeUpdate(qry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin nhà cung cấp");
        }
    }

    public void sua(NhaCungCapDTO ncc) throws  Exception{
        try {
            String qry = "Update NhaCungCap Set ";
            qry = qry + "TEN_NCC=" + "'" + ncc.ten + "'";
            qry = qry + ",SDT_NCC=" + "'" + ncc.sdt + "'";
            qry = qry + ",MAIL_NCC=" + "'" + ncc.mail + "'";
            qry = qry + ",DIACHI_NCC=" + "'" + ncc.dc + "'";
            qry = qry + ",TINHTRANG=" + "'" + ncc.tinhtrang + "'";
            qry = qry + " " + "where ID_NCC='" + ncc.id + "'";
            myconnect.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật nhà cung cấp");
        }
    }

    public void xoa(NhaCungCapDTO ncc) throws Exception {
        try {
            String qry = "Update NhaCungCap Set ";
            qry = qry + "TINHTRANG=" + "'" + ncc.tinhtrang + "'";
            qry = qry + " " + "where ID_NCC='" + ncc.id + "'";
//            String qry = "Delete from NhaCungcap where id='" + id + "'";
            myconnect.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa nhà cung cấp");
        }
    }

}
