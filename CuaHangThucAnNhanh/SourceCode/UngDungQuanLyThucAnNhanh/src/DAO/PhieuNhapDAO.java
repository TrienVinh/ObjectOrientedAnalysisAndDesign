package DAO;

import DTO.PhieuNhapDTO;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PhieuNhapDAO 
{
    ResultSet rs = null;
    MyDBConnection connect = new MyDBConnection();
    ArrayList<PhieuNhapDTO> danhsach_pn = null;

    public PhieuNhapDAO()
    {
        connect = new MyDBConnection("localhost", "root", "", "doanjava");       
    }
    
    public ArrayList<PhieuNhapDTO> docDSPN() throws Exception 
    {      
        danhsach_pn = new ArrayList<PhieuNhapDTO>();              
        try
        {
            String qry = "Select * from phieunhap";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                PhieuNhapDTO pn_dto = new PhieuNhapDTO();
                pn_dto.setId_pn(rs.getString(1));
                pn_dto.setId_nv(rs.getString(2));
                pn_dto.setId_ncc(rs.getString(3));
                pn_dto.setNgaynhap_pn(rs.getString(4));
                pn_dto.setTongtien_pn(rs.getString(5));
                danhsach_pn.add(pn_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_pn;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin phiếu nhập");
        }
        return danhsach_pn;
        
    }    
    /*
    public void Insert(HoadonDTO nv_dto) throws Exception 
    {      
        try
        {
            String qry = "Insert into nhanvien Values (";
            qry = qry + "" + nv_dto.getId() + ",";
            qry = qry + "'" + nv_dto.getHo() + "',";
            qry = qry + "'" + nv_dto.getTen() + "',";
            qry = qry + "'" + nv_dto.getSdt() + "',";
            qry = qry + "'" + nv_dto.getMail() + "',";
            qry = qry + "'" + nv_dto.getGioitinh() + "',";
            qry = qry + "'" + nv_dto.getChucvu() + "',";
            qry = qry + "'null',";
            qry = qry + "1);";
            System.out.println(qry);
            int rs2=connect.executeUpdate(qry);            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin nhân viên");
        }
    }

    public void Update(NhanvienDTO nv_dto) throws Exception 
    {
        try
        {
            String qry = "Update nhanvien set ho_nv='"+nv_dto.getHo()+"',ten_nv = '"+nv_dto.getTen()+"',gioitinh_nv = '"+nv_dto.getGioitinh()+"',mail_nv = '"+nv_dto.getMail()+"',sdt_nv = '"+nv_dto.getSdt()+"',chucvu_nv = '"+nv_dto.getChucvu()+"' where id_nv = '"+nv_dto.getId()+"'";

            int rs2=connect.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin nhân viên");
        }
    }

    public void Delete(NhanvienDTO nv_dto) throws Exception 
    {
        String qry="update  `nhanvien` set tinhtrang=0 WHERE `nhanvien`.`ID_NV` ="+nv_dto.getId()+";";
        int rs2=connect.executeUpdate(qry);        
    }
    
    public void Delete2(String nv) throws Exception 
    {
        String qry="update  `nhanvien` set tinhtrang=0 WHERE `nhanvien`.`ID_NV` ="+nv+";";
        int rs2=connect.executeUpdate(qry);        
    } 
    */
}