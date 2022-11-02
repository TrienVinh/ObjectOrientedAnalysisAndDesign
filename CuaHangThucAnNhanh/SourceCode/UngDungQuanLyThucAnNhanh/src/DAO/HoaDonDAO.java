package DAO;

import DTO.*;
import Kiemtra.KT;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HoaDonDAO
{
    MyDBConnection conn=new MyDBConnection ("localhost","root","","doanjava");
    ResultSet rs;
    String qr;
    ArrayList <HoaDonDTO> dsHD=null;
    
    public ArrayList<HoaDonDTO> docHD() throws Exception 
    {      
        dsHD = new ArrayList<HoaDonDTO>();              
        try
        {
            qr="SELECT * FROM hoadon";
            rs=conn.excuteQuery(qr);
            while (rs.next())
            {
                HoaDonDTO hd_dto=new HoaDonDTO ();
                hd_dto.setIdHD(rs.getInt(1));
                hd_dto.setIdKH(rs.getInt(2));
                hd_dto.setIdNV(rs.getInt(3));
                hd_dto.setIdGG(rs.getInt(4));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(rs.getDouble(6));
                hd_dto.setTienGG(rs.getDouble(7));
                dsHD.add(hd_dto);
            }
            conn.Close();
            return dsHD;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsHD;
    }
       
    public ArrayList<HoaDonDTO> docHD_dkSo(String dieuKien, int giaTri) throws Exception 
    {      
        dsHD = new ArrayList<HoaDonDTO>();              
        try
        {
            qr="SELECT * FROM hoadon WHERE "+dieuKien+"="+giaTri+";";
            rs=conn.excuteQuery(qr);
            while (rs.next())
            {
                HoaDonDTO hd_dto=new HoaDonDTO ();
                hd_dto.setIdHD(rs.getInt(1));
                hd_dto.setIdKH(rs.getInt(2));
                hd_dto.setIdNV(rs.getInt(3));
                hd_dto.setIdGG(rs.getInt(4));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(rs.getDouble(6));
                hd_dto.setTienGG(rs.getDouble(7));
                dsHD.add(hd_dto);
            }
            conn.Close();
            return dsHD;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsHD;
    }
    
    public ArrayList<HoaDonDTO> docHD_dkChuoi(String dieuKien, String giaTri) throws Exception 
    {      
        dsHD = new ArrayList<HoaDonDTO>();              
        try
        {
            qr="SELECT * FROM hoadon WHERE";
            rs=conn.excuteQuery(qr);
            while (rs.next())
            {
                HoaDonDTO hd_dto=new HoaDonDTO ();
                hd_dto.setIdHD(rs.getInt(1));
                hd_dto.setIdKH(rs.getInt(2));
                hd_dto.setIdNV(rs.getInt(3));
                hd_dto.setIdGG(rs.getInt(4));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(rs.getDouble(6));
                hd_dto.setTienGG(rs.getDouble(7));
                dsHD.add(hd_dto);
            }
            conn.Close();
            return dsHD;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsHD;
    }
    //======================== TÌM TRONG HÓA ĐƠN ===========================//
    public ArrayList<HoaDonDTO> SearchDSHD2(String hd) throws Exception 
    {      
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where id_hd="+hd+";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto); 
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hóa đơn");
        }
        return temp;       
    }
    public ArrayList<HoaDonDTO> SearchDSHD3(String hd) throws Exception 
    {      
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where id_kh="+hd+";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto); 
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hóa đơn");
        }
        return temp;       
    }
    public ArrayList<HoaDonDTO> SearchDSHD4(String hd) throws Exception 
    {      
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where id_nv="+hd+";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto); 
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hóa đơn");
        }
        return temp;       
    }
    public ArrayList<HoaDonDTO> SearchDSHD5(String hd) throws Exception 
    {      
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where id_giamgia="+hd+";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto); 
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hóa đơn");
        }
        return temp;       
    }
    public ArrayList<HoaDonDTO> SearchDSHD6(String hd) throws Exception 
    {      
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where ngaylap_hd="+hd+";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto); 
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hóa đơn");
        }
        return temp;       
    }
    public ArrayList<HoaDonDTO> SearchDSHD7(String hd) throws Exception 
    {      
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where tongtien_hd="+hd+";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto); 
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hóa đơn");
        }
        return temp;       
    }
    public ArrayList<HoaDonDTO> SearchDSHD8(String hd) throws Exception 
    {      
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where tiengiamgia="+hd+";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto); 
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hóa đơn");
        }
        return temp;       
    }
    
    //======================== THỐNG KÊ TRONG HÓA ĐƠN ===========================//    
    // Thống kê theo ngày ====================================
    public ArrayList<HoaDonDTO> TKHDnv(String tkhd_nv) throws Exception {   //Theo NV
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try{
            String qry = "Select * from hoadon Where id_nv="+tkhd_nv+ ";";
         // where id_nv = ? and thang = ?   
         // nam = ?
         // where id_nv = ? and ngaylaphd between ? and ?
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto);
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;
    }
    public ArrayList<HoaDonDTO> TKHDnvTheongay(String tkhd_nv, String ngayfirsthd, String ngaylastthd) throws Exception { //Theo NV
        ArrayList<HoaDonDTO> temp=new ArrayList();
        try{
            String qry = "Select * from hoadon Where id_nv="+ tkhd_nv+ ";";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto);
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin hoá đơn");
        }
        return temp;
    }
    public static HoaDonDTO getChuanhoa(String ngayfirsthd, String ngaylastthd) throws Exception {
        int i;
        KT kt = new KT();
        ArrayList<HoaDonDTO> temp = new ArrayList();
        HoaDonDAO data = new HoaDonDAO();
        temp = data.docHD();
        for(i=0; i<temp.size(); i++){
            if(kt.ngaytruocngay(ngayfirsthd,temp.get(i).getNgayLapHD()) && kt.ngaytruocngay(temp.get(i).getNgayLapHD(),ngaylastthd))
                 return temp.get(i);
        }
        return null;
    }
    public ArrayList<HoaDonDTO> TKHDkh(String tkhd_kh) throws Exception // Theo KH
    {
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from hoadon Where id_kh="+tkhd_kh+ ";"; 
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();               
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto);
            }
            conn.Close();
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;
    }
    public ArrayList<HoaDonDTO> TKHDall() throws Exception // Theo tất cả
    {
        ArrayList<HoaDonDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from hoadon Where tongtien_hd ;";
            rs = conn.excuteQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();               
                hd_dto.setIdHD(Integer.parseInt(rs.getString(1)));
                hd_dto.setIdKH(Integer.parseInt(rs.getString(2)));
                hd_dto.setIdNV(Integer.parseInt(rs.getString(3)));
                hd_dto.setIdGG(Integer.parseInt(rs.getString(4)));
                hd_dto.setNgayLapHD(rs.getString(5));
                hd_dto.setTongTien(Integer.parseInt(rs.getString(6)));
                hd_dto.setTienGG(Integer.parseInt(rs.getString(7)));
                temp.add(hd_dto);
            }
            conn.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;
    }
    
    public void Update(int idhd, double tongTien, double tienGG) throws Exception 
    {
        try
        {
            String qry = "UPDATE hoadon SET tongtien_hd='"+tongTien+"',tiengiamgia='"+tienGG+"' WHERE id_hd='"+idhd+"';";
            int rs2=conn.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật thông tin hóa đơn");
        }
    }
    
        public void capnhatTongTien(HoaDonDTO hd) throws  Exception{
        try {
            String qry = "Update hoadon Set ";
            qry = qry + "TONGTIEN_HD=" + "'" + hd.getTongTien() + "'";
            qry = qry + " " + "where ID_HD='" + hd.getIdHD() + "'";
            conn.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật TỔNG TIỀN");
        }
    }
        
        public void capnhatIDGG(HoaDonDTO hd) throws  Exception{
        try {
            String qry = "Update hoadon Set ";
            qry = qry + "ID_GIAMGIA=" + "'" + hd.getIdGG() + "'";
            qry = qry + " " + "where ID_HD='" + hd.getIdHD() + "'";
            conn.executeUpdate(qry);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật ID giảm giá");
        }
    }
    public void Insert(HoaDonDTO hd_dto) throws Exception 
    {      
        try
        {
            qr="INSERT INTO hoadon VALUES (";
            qr=qr+hd_dto.getIdHD()+",";
            qr=qr+"'"+hd_dto.getIdKH()+"',";
            qr=qr+"'"+hd_dto.getIdNV()+"',";
            qr=qr+"'"+hd_dto.getIdGG()+"',";
            qr=qr+"'"+hd_dto.getNgayLapHD()+"',";
            qr=qr+"'"+hd_dto.getTongTien()+"',";
            qr=qr+"'"+hd_dto.getTienGG()+"');";
            int rs1=conn.executeUpdate(qr);
            conn.Close();
            JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin hóa đơn");
        }        
    }
       
}
