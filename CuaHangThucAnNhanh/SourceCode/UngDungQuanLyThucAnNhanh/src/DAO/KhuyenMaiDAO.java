/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuyenMaiDTO;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class KhuyenMaiDAO {
    ResultSet rs = null;
    MyDBConnection connect = new MyDBConnection();
    ArrayList<KhuyenMaiDTO> danhsach_km= null;
     public KhuyenMaiDAO()
    {
        connect = new MyDBConnection("localhost", "root", "", "doanjava");       
    }
     
      public ArrayList<KhuyenMaiDTO> docDSKMloai1() throws Exception // đọc danh sách loại km theo hd
    {      
        danhsach_km = new ArrayList<KhuyenMaiDTO>();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia WHERE LOAI_CT = 1;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                danhsach_km.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_km;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi theo hóa đơn");
        }
        return danhsach_km;
    }
      
       public ArrayList<KhuyenMaiDTO> docDSKMloai2() throws Exception // đọc danh sách loại km theo sp
    {      
        danhsach_km = new ArrayList<KhuyenMaiDTO>();              
        try
        {
            String qry = "SELECT * from chuongtrinh_giamgia WHERE LOAI_CT = 2;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                danhsach_km.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_km;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi theo sản phẩm");
        }
        return danhsach_km;
    }
       
      public void Insert(KhuyenMaiDTO km_dto) throws Exception 
    {      
        try
        {
            String qr="INSERT INTO chuongtrinh_giamgia VALUES (";
            qr=qr+km_dto.getIdKM()+",";
            qr=qr+"'"+km_dto.getTenKM()+"',";
            qr=qr+"'"+km_dto.getLoaiCT()+"',";
            qr=qr+"'"+km_dto.getNgayBD()+"',";
            qr=qr+"'"+km_dto.getNgayKT()+"',";
            qr=qr+"'"+km_dto.getNoidungGG()+"',";
            qr=qr+"'"+km_dto.getDieukienGG()+"');";
            int rs1=connect.executeUpdate(qr); 
            connect.Close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin khuyến mãi");
        }
    }
      
     public void DeleteLoai1(KhuyenMaiDTO km_dto) throws Exception 
    {
        String qry="DELETE FROM `chuongtrinh_giamgia` WHERE `chuongtrinh_giamgia`.`ID_GIAMGIA` ="+km_dto.getIdKM()+";";
        int rs2=connect.executeUpdate(qry); 
        JOptionPane.showMessageDialog(null, "Đã xóa thành công");
    }
     
     
     public void DeleteLoai2(KhuyenMaiDTO km_dto) throws Exception 
    {
        String qry="DELETE FROM `chuongtrinh_giamgia` WHERE `chuongtrinh_giamgia`.`ID_GIAMGIA` ="+km_dto.getIdKM()+";";
        int rs2=connect.executeUpdate(qry); 
        qry="DELETE FROM `chitiet_ctgiamgia` WHERE `chitiet_ctgiamgia`.`ID_GIAMGIA` ="+km_dto.getIdKM()+";";
        int rs3=connect.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Đã xóa thành công");
     }
     public void Update(KhuyenMaiDTO km_dto) throws Exception 
    {
        try
        {
            String qry = "Update chuongtrinh_giamgia set TEN_CT = '"+km_dto.getTenKM()+"',LOAI_CT = '"+km_dto.getLoaiCT()+"',TG_BD = '"+km_dto.getNgayBD()+"',TG_KT = '"+km_dto.getNgayKT()+"',NOIDUNG_GG = '"+km_dto.getNoidungGG()+"',DIEUKIEN_GG = '"+km_dto.getDieukienGG()+"' where ID_GIAMGIA = '"+km_dto.getIdKM()+"'";

            int rs2=connect.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin khuyến mãi");
        }
    }
     
     //---------------------------------------search bên khung khuyến mãi loại 1------------------------------------------------
      public ArrayList<KhuyenMaiDTO> SearchDSKMloai1ID(String km) throws Exception //Dùng cho nút tìm kiếm theo id
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from `chuongtrinh_giamgia` Where ID_GIAMGIA="+km+" and LOAI_CT = 1;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
      
      public ArrayList<KhuyenMaiDTO> SearchDSKMloai1Ten(String km) throws Exception //Dùng cho nút tìm kiếm theo tên
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from `chuongtrinh_giamgia` Where TEN_CT="+km+" and LOAI_CT = 1;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
      
      public ArrayList<KhuyenMaiDTO> SearchDSKMloai1NDGG(double duoi, double tren) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia Where NOIDUNG_GG>="+duoi+" and NOIDUNG_GG <= "+tren+" and LOAI_CT = 1;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
      
       public ArrayList<KhuyenMaiDTO> SearchDSKMloai1DKGG(String km) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia Where DIEUKIEN_GG>="+km+" and LOAI_CT = 1;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
       
       public ArrayList<KhuyenMaiDTO> SearchDSKMloai1NgayBD(String km) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia Where TG_BD="+km+" and LOAI_CT = 1;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
       
       public ArrayList<KhuyenMaiDTO> SearchDSKMloai1NgayKT(String km) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia Where TG_KT="+km+" and LOAI_CT = 1;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
       
    //---------------------------------------search bên khung khuyến mãi loại 2------------------------------------------------
       public ArrayList<KhuyenMaiDTO> SearchDSKMloai2ID(String km) throws Exception //Dùng cho nút tìm kiếm theo id
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from `chuongtrinh_giamgia` Where ID_GIAMGIA="+km+" and LOAI_CT = 2;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
      
      public ArrayList<KhuyenMaiDTO> SearchDSKMloai2Ten(String km) throws Exception //Dùng cho nút tìm kiếm theo tên
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from `chuongtrinh_giamgia` Where TEN_CT="+km+" and LOAI_CT = 2;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
      
       public ArrayList<KhuyenMaiDTO> SearchDSKMloai2DKGG(String km) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia Where DIEUKIEN_GG>="+km+"and LOAI_CT = 2;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
       
       public ArrayList<KhuyenMaiDTO> SearchDSKMloai2NgayBD(String km) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia Where TG_BD="+km+" and LOAI_CT = 2;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
       
       public ArrayList<KhuyenMaiDTO> SearchDSKMloai2NgayKT(String km) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chuongtrinh_giamgia Where TG_KT="+km+" and LOAI_CT = 2;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
       
       //=======================================Phần Thiên làm==================================
       public ArrayList<KhuyenMaiDTO> docDSKM() throws Exception // đọc danh sách loại km theo sp
    {      
        danhsach_km = new ArrayList<KhuyenMaiDTO>();              
        try
        {
            String qry = "SELECT * from chuongtrinh_giamgia;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                danhsach_km.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_km;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return danhsach_km;
    }
       //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!CHỖ MỚI THÊM NÈ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
       public ArrayList<KhuyenMaiDTO> SearchIDKM(String km) throws Exception //Dùng cho nút tìm kiếm theo id
    {      
        ArrayList<KhuyenMaiDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from `chuongtrinh_giamgia` Where ID_GIAMGIA="+km+";";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km_dto = new KhuyenMaiDTO();
                km_dto.setIdKM(rs.getInt(1));
                km_dto.setTenKM(rs.getString(2));
                km_dto.setLoaiCT(rs.getInt(3));
                km_dto.setNgayBD(rs.getString(4));
                km_dto.setNgayKT(rs.getString(5));
                km_dto.setNoidungGG(rs.getDouble(6));
                km_dto.setDieukienGG(rs.getDouble(7));
                temp.add(km_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khuyến mãi");
        }
        return temp;       
    }
}
