package DAO;

import DTO.ChiTietHD_DTO;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChiTietHD_DAO 
{
    MyDBConnection conn=new MyDBConnection ("localhost","root","","doanjava");
    ResultSet rs;
    String qr=null;
    ArrayList <ChiTietHD_DTO> dsCTHD=null;
    int rs1;
    
    public ArrayList<ChiTietHD_DTO> docCTHD(int idhd) throws Exception 
    {      
        dsCTHD = new ArrayList<ChiTietHD_DTO>();              
        try
        {
            qr="SELECT * FROM chitiet_hoadon WHERE ID_HD="+idhd+"";
            rs=conn.excuteQuery(qr);
            while (rs.next())
            {
                ChiTietHD_DTO cthd_dto=new ChiTietHD_DTO ();
                cthd_dto.setIdHD(rs.getInt(1));
                cthd_dto.setIdSP(rs.getInt(2));
                cthd_dto.setSoLuong(rs.getInt(3));
                cthd_dto.setDonGia(rs.getDouble(4));
                cthd_dto.setThanhTien(rs.getDouble(5));
                cthd_dto.setTienGG(rs.getDouble(6));
                dsCTHD.add(cthd_dto);
            }
            conn.Close();
            return dsCTHD;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin chi tiet hd");
        }
        return dsCTHD;
    }   
    public ArrayList<ChiTietHD_DTO> docCTHD() throws Exception 
    {      
        dsCTHD = new ArrayList<ChiTietHD_DTO>();              
        try
        {
            qr="SELECT * FROM chitiet_hoadon";
            rs=conn.excuteQuery(qr);
            while (rs.next())
            {
                ChiTietHD_DTO cthd_dto=new ChiTietHD_DTO ();
                cthd_dto.setIdHD(rs.getInt(1));
                cthd_dto.setIdSP(rs.getInt(2));
                cthd_dto.setSoLuong(rs.getInt(3));
                cthd_dto.setDonGia(rs.getDouble(4));
                cthd_dto.setThanhTien(rs.getDouble(5));
                cthd_dto.setTienGG(rs.getDouble(6));
                dsCTHD.add(cthd_dto);
            }
            conn.Close();
            return dsCTHD;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin chi tiet hd");
        }
        return dsCTHD;
    }   
    public void Insert(ChiTietHD_DTO cthd_dto) throws Exception 
    {      
        try
        {
            qr="INSERT INTO chitiet_hoadon VALUES (";
            qr=qr+cthd_dto.getIdHD()+",";
            qr=qr+"'"+cthd_dto.getIdSP()+"',";
            qr=qr+"'"+cthd_dto.getSoLuong()+"',";
            qr=qr+"'"+cthd_dto.getDonGia()+"',";
            qr=qr+"'"+cthd_dto.getThanhTien()+"',";
            qr=qr+"'"+cthd_dto.getTienGG()+"');";
            rs1=conn.executeUpdate(qr);
            conn.Close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin");
        }        
    }		
}
