/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import UTIL.MyDBConnection;
import DTO.ChiTietPhieuNhapDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author SonThai
 */
public class ChiTietPhieuNhapDAO {
    MyDBConnection myconnect = new MyDBConnection("localhost","root", "","doanjava");
    static Connection conn =null;
    Statement st = null;
    ResultSet rs = null;
    
    public ChiTietPhieuNhapDAO(){
        if(myconnect==null){
            try{
              conn=myconnect.getConnection();
            }catch (Exception e) {
                Logger.getLogger(HangNhapDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public ArrayList docDSChiTietPN() throws Exception {
        ArrayList dsChiTietPN = new ArrayList<ChiTietPhieuNhapDAO>();
        try {
            String qry = "Select * from chitiet_phieunhap";
            rs = myconnect.excuteQuery(qry);
            while (rs.next()) {
                ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
                ctpn.idPN = rs.getInt(1);
                ctpn.idSP = rs.getInt(2);
                ctpn.soluongSP = rs.getInt(3);
                ctpn.gianhap = rs.getDouble(4);

                dsChiTietPN.add(ctpn);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin phiếu nhập");
        }
        return dsChiTietPN;
    }
    
    public void them(ChiTietPhieuNhapDTO ctpn) throws  Exception{
        try {
            String qry = "insert into chitiet_phieunhap value(";
            qry = qry + "'" + ctpn.idPN + "'";
            qry = qry + "," + "'" + ctpn.idSP + "'";
            qry = qry + "," + "'" + ctpn.soluongSP + "'";
            qry = qry + "," + "'" + ctpn.gianhap + "'";
            qry = qry + ")";
            
            myconnect.executeUpdate(qry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin phiếu nhập");
        }
    }
    
    public void sua(ChiTietPhieuNhapDTO ctpn) throws  Exception{
        try {
            String qry = "Update chitiet_phieunhap Set ";
            qry = qry + "SL_CTPN=" + "'" + ctpn.soluongSP + "'";
            qry = qry + ",GIANHAP=" + "'" + ctpn.gianhap + "'";
            qry = qry + " " + "where ID_SP='" + ctpn.idSP + "'";
            qry =qry + " " + "AND ID_PN='" +ctpn.idPN +"'";
            myconnect.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật phiếu nhập");
        }
    }
    
    public void xoa(ChiTietPhieuNhapDTO ctpn) throws Exception {
        try {
            String qry = "Delete from chitiet_phieunhap where ID_SP='" + ctpn.idSP + "'";
            qry = qry + " AND ID_PN='" +ctpn.idPN +"'";
            myconnect.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa nhà cung cấp");
        }
    }
}
