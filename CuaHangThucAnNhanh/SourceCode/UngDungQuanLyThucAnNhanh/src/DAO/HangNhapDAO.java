/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import UTIL.MyDBConnection;
import DTO.HangnhapDTO;
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
public class HangNhapDAO {
    MyDBConnection myconnect = new MyDBConnection("localhost","root", "","doanjava");
    static Connection conn =null;
    Statement st = null;
    ResultSet rs = null;
    
    public HangNhapDAO(){
        if(myconnect==null){
            try{
              conn=myconnect.getConnection();
            }catch (Exception e) {
                Logger.getLogger(HangNhapDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public ArrayList docDSHN() throws Exception {
        ArrayList dsHN = new ArrayList<HangNhapDAO>();
        try {
            String qry = "Select * from PHIEUNHAP";
            rs = myconnect.excuteQuery(qry);
            while (rs.next()) {
                HangnhapDTO hn = new HangnhapDTO();
                hn.idPN = rs.getInt(1);
                hn.idNV = rs.getInt(2);
                hn.idNCC = rs.getInt(3);
                hn.ngaynhap = rs.getString(4);
                hn.tongtien = rs.getDouble(5);

                dsHN.add(hn);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin phiếu nhập");
        }
        return dsHN;
    }
    
    public void them(HangnhapDTO hn) throws  Exception{
        try {
            String qry = "insert into PHIEUNHAP value(";
            qry = qry + "'" + hn.idPN + "'";
            qry = qry + "," + "'" + hn.idNV + "'";
            qry = qry + "," + "'" + hn.idNCC + "'";
            qry = qry + "," + "'" + hn.ngaynhap + "'";
            qry = qry + "," + "'" + hn.tongtien + "'";
            qry = qry + ")";
            
            myconnect.executeUpdate(qry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin phiếu nhập");
        }
    }
    
    public void sua(HangnhapDTO hn) throws  Exception{
        try {
            String qry = "Update PHIEUNHAP Set ";
            qry = qry + "NGAYNHAP_PN=" + "'" + hn.ngaynhap + "'";
            qry = qry + " " + "where ID_PN='" + hn.idPN + "'";
            myconnect.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật phiếu nhập");
        }
    }
    
    public void capnhatTongTien(HangnhapDTO hn) throws  Exception{
        try {
            String qry = "Update PHIEUNHAP Set ";
            qry = qry + "TONGTIEN_PN=" + "'" + hn.tongtien + "'";
            qry = qry + " " + "where ID_PN='" + hn.idPN + "'";
            myconnect.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật TỔNG TIỀN");
        }
    }
    
    //======================== THỐNG KÊ TRONG TỔNG CHI ===========================//    
    // Thống kê theo ngày ====================================
    public ArrayList<HangnhapDTO> TKPNnv(String tkpn_nv) throws Exception {   //Theo NV
        ArrayList<HangnhapDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from phieunhap Where id_nv="+tkpn_nv+ ";";           
            rs = myconnect.excuteQuery(qry);
            while(rs.next())
            {
                HangnhapDTO pn_dto = new HangnhapDTO();
                pn_dto.setIDPN(Integer.parseInt(rs.getString(1)));
                pn_dto.setIDNV(Integer.parseInt(rs.getString(2)));
                pn_dto.setIDNCC(Integer.parseInt(rs.getString(3)));
                pn_dto.setNgayNhap(rs.getString(4));
                pn_dto.setTongTien(Integer.parseInt(rs.getString(5)));
                temp.add(pn_dto);
            }
            myconnect.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin phiếu nhập");
        }
        return temp;
    }
    public ArrayList<HangnhapDTO> TKPNncc(String tkpn_nv) throws Exception {   //Theo ncc
        ArrayList<HangnhapDTO> temp=new ArrayList();
        try{
            String qry = "Select * from phieunhap Where id_ncc="+tkpn_nv+ ";";
            rs = myconnect.excuteQuery(qry);
            while(rs.next())
            {
                HangnhapDTO pn_dto = new HangnhapDTO();
                pn_dto.setIDPN(Integer.parseInt(rs.getString(1)));
                pn_dto.setIDNV(Integer.parseInt(rs.getString(2)));
                pn_dto.setIDNCC(Integer.parseInt(rs.getString(3)));
                pn_dto.setNgayNhap(rs.getString(4));
                pn_dto.setTongTien(Integer.parseInt(rs.getString(5)));
                temp.add(pn_dto);
            }
            myconnect.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin phiếu nhập");
        }
        return temp;
    }
    public ArrayList<HangnhapDTO> TKPNall(String tkpn_nv) throws Exception {   //Theo all
        ArrayList<HangnhapDTO> temp=new ArrayList();
        try{
            String qry = "Select * from phieunhap Where tongtien_pn ;";
            rs = myconnect.excuteQuery(qry);
            while(rs.next())
            {
                HangnhapDTO pn_dto = new HangnhapDTO();
                pn_dto.setIDPN(Integer.parseInt(rs.getString(1)));
                pn_dto.setIDNV(Integer.parseInt(rs.getString(2)));
                pn_dto.setIDNCC(Integer.parseInt(rs.getString(3)));
                pn_dto.setNgayNhap(rs.getString(4));
                pn_dto.setTongTien(Integer.parseInt(rs.getString(5)));
                temp.add(pn_dto);
            }
            myconnect.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin phiếu nhập");
        }
        return temp;
    }
}
