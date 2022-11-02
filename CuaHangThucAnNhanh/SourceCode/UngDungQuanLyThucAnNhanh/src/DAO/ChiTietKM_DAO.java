/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.KhuyenMaiDTO;
import DTO.ChiTietKM_DTO;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChiTietKM_DAO {
    ResultSet rs = null;
    MyDBConnection connect = new MyDBConnection();
    ArrayList<ChiTietKM_DTO> danhsach_ctkm= null;
     public ChiTietKM_DAO()
    {
        connect = new MyDBConnection("localhost", "root", "", "doanjava");       
    }
     
      public ArrayList<ChiTietKM_DTO> docDSCTKM(int idGG) throws Exception 
    {      
        danhsach_ctkm = new ArrayList<ChiTietKM_DTO>();              
        try
        {
            String qry = "Select * from chitiet_ctgiamgia WHERE ID_GIAMGIA="+idGG+"";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                ChiTietKM_DTO ctkm_dto = new ChiTietKM_DTO();
                ctkm_dto.setIdKM(rs.getInt(1));
                ctkm_dto.setIdSP(rs.getInt(2));
                ctkm_dto.setNoidungGG(rs.getDouble(3));
                danhsach_ctkm.add(ctkm_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_ctkm;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin chi tiêt khuyến mãi ");
        }
        return danhsach_ctkm;    
    }
      
      public ArrayList<ChiTietKM_DTO> docDSCTKM() throws Exception 
    {      
        danhsach_ctkm = new ArrayList<ChiTietKM_DTO>();              
        try
        {
            String qry = "Select * from chitiet_ctgiamgia";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                ChiTietKM_DTO ctkm_dto = new ChiTietKM_DTO();
                ctkm_dto.setIdKM(rs.getInt(1));
                ctkm_dto.setIdSP(rs.getInt(2));
                ctkm_dto.setNoidungGG(rs.getDouble(3));
                danhsach_ctkm.add(ctkm_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_ctkm;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin chi tiêt khuyến mãi ");
        }
        return danhsach_ctkm;    
    }
      
      public void Insert(ChiTietKM_DTO ctkm_dto) throws Exception 
    {      
        try
        {
            String qr="INSERT INTO chitiet_ctgiamgia VALUES (";
            qr=qr+ctkm_dto.getIdKM()+",";
            qr=qr+"'"+ctkm_dto.getIdSP()+"',";
            qr=qr+"'"+ctkm_dto.getNoidungGG()+"');";
            int rs1=connect.executeUpdate(qr);
            connect.Close();        
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin chi tiết khuyến mãi");
        }
    }
      
      
      public void DeleteOneID(ChiTietKM_DTO ctkm_dto) throws Exception //delete 1 hàng của chi tiết chương trình km của theo sp 
    {
        String qry="DELETE FROM `chitiet_ctgiamgia` WHERE `chitiet_ctgiamgia`.`ID_GIAMGIA` ="+ctkm_dto.getIdKM()+"and `chitiet_ctgiamgia`.`ID_SP`="+ctkm_dto.getIdSP() +";";
        int rs2=connect.executeUpdate(qry); 
        JOptionPane.showMessageDialog(null, "Đã xóa thành công");
    }
      
      public void Update(ChiTietKM_DTO ctkm_dto) throws Exception 
    {
        try
        {
            String qry = "Update `chitiet_ctgiamgia` set NOIDUNG_GG = "+ctkm_dto.getNoidungGG()+" where ID_GIAMGIA = "+ctkm_dto.getIdKM()+"and ID_SP = "+ctkm_dto.getIdSP()+";";

            int rs2=connect.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin chi tiết khuyến mãi");
        }
    }
      //======================================SEARCH============================================
      public ArrayList<ChiTietKM_DTO> SearchIDKM(String ctkm) throws Exception //Dùng cho nút tìm kiếm theo IDKM
    {      
        ArrayList<ChiTietKM_DTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chitiet_ctgiamgia Where ID_GIAMGIA>="+ctkm+";";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                ChiTietKM_DTO ctkm_dto = new ChiTietKM_DTO();
                ctkm_dto.setIdKM(rs.getInt(1));
                ctkm_dto.setIdSP(rs.getInt(2));
                ctkm_dto.setNoidungGG(rs.getDouble(3));
                temp.add(ctkm_dto); 
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
      
      public ArrayList<ChiTietKM_DTO> SearchIDSP(String ctkm) throws Exception //Dùng cho nút tìm kiếm theo IDSP
    {      
        ArrayList<ChiTietKM_DTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chitiet_ctgiamgia Where ID_SP>="+ctkm+";";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                ChiTietKM_DTO ctkm_dto = new ChiTietKM_DTO();
                ctkm_dto.setIdKM(rs.getInt(1));
                ctkm_dto.setIdSP(rs.getInt(2));
                ctkm_dto.setNoidungGG(rs.getDouble(3));
                temp.add(ctkm_dto); 
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
      
       public ArrayList<ChiTietKM_DTO> SearchNDGG(double duoi, double tren) throws Exception //Dùng cho nút tìm kiếm nội dung giảm giá từ khoảng tới khoảng
    {      
        ArrayList<ChiTietKM_DTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from chitiet_ctgiamgia Where NOIDUNG_GG>="+duoi+" and NOIDUNG_GG <= "+tren+";";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                ChiTietKM_DTO ctkm_dto = new ChiTietKM_DTO();
                ctkm_dto.setIdKM(rs.getInt(1));
                ctkm_dto.setIdSP(rs.getInt(2));
                ctkm_dto.setNoidungGG(rs.getDouble(3));
                temp.add(ctkm_dto); 
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
