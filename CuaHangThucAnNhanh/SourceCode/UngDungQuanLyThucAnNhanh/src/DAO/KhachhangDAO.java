package DAO;

import DTO.KhachhangDTO;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class KhachhangDAO 
{
    ResultSet rs = null;
    MyDBConnection connect = new MyDBConnection();
    ArrayList<KhachhangDTO> danhsach_kh = null;

    public KhachhangDAO()
    {
        connect = new MyDBConnection("localhost", "root", "", "doanjava");       
    }
    
    public ArrayList<KhachhangDTO> docDSKH() throws Exception 
    {      
        danhsach_kh = new ArrayList<KhachhangDTO>();              
        try
        {
            String qry = "Select * from khachhang";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                danhsach_kh.add(kh_dto);
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_kh;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return danhsach_kh;        
    }
    public ArrayList<KhachhangDTO> SearchDSKH2(String kh) throws Exception //Dùng cho nút tìm kiếm theo id
    {      
        ArrayList<KhachhangDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from khachhang Where id_kh="+kh+";";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                temp.add(kh_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;       
    }
    public ArrayList<KhachhangDTO> SearchDSKH3(String kh) throws Exception //Dùng cho nút tìm kiếm theo họ
    {      
        ArrayList<KhachhangDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from khachhang Where ho_kh='"+kh+"';";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                temp.add(kh_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;       
    }
    public ArrayList<KhachhangDTO> SearchDSKH4(String kh) throws Exception //Dùng cho nút tìm kiếm theo tên
    {      
        ArrayList<KhachhangDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from khachhang Where ten_kh='"+kh+"';";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                temp.add(kh_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;       
    }
    public ArrayList<KhachhangDTO> SearchDSKH5(String kh) throws Exception //Dùng cho nút tìm kiếm theo Số điện thoại
    {      
        ArrayList<KhachhangDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from khachhang Where sdt_kh="+kh+";";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                temp.add(kh_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;       
    }
    public ArrayList<KhachhangDTO> SearchDSKH6(String kh) throws Exception //Dùng cho nút tìm kiếm theo mail
    {      
        ArrayList<KhachhangDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from khachhang Where mail_kh='"+kh+"';";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                temp.add(kh_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;       
    }
    public ArrayList<KhachhangDTO> SearchDSKH7(String kh) throws Exception //Dùng cho nút tìm kiếm theo giới tính
    {      
        ArrayList<KhachhangDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from khachhang Where gioitinh_kh='"+kh+"';";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                temp.add(kh_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;       
    }
    public ArrayList<KhachhangDTO> SearchDSKH8(String kh) throws Exception //Dùng cho nút tìm kiếm theo tổng chi tiêu
    {      
        ArrayList<KhachhangDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from khachhang Where tongchitieu="+kh+";";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(rs.getString(1));
                kh_dto.setHo(rs.getString(2));
                kh_dto.setTen(rs.getString(3));
                kh_dto.setSdt(rs.getString(4));
                kh_dto.setMail(rs.getString(5));
                kh_dto.setGioitinh(rs.getString(6));
                kh_dto.setTongchi(rs.getString(7));
                temp.add(kh_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin khách hàng");
        }
        return temp;       
    }
    
    public void Insert(KhachhangDTO kh_dto) throws Exception 
    {      
        try
        {
            String qry = "Insert into khachhang Values (";
            qry = qry + "" + kh_dto.getId() + ",";
            qry = qry + "'" + kh_dto.getHo() + "',";
            qry = qry + "'" + kh_dto.getTen() + "',";
            qry = qry + "'" + kh_dto.getSdt() + "',";
            qry = qry + "'" + kh_dto.getMail() + "',";
            qry = qry + "'" + kh_dto.getGioitinh() + "',";
            qry = qry + "'" + kh_dto.getTongchi() + "');";
            //qry = qry + "'null');";
            System.out.println(qry);
            int rs2=connect.executeUpdate(qry);            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin nhân viên");
        }        
    }		

    public void Update(KhachhangDTO kh_dto) throws Exception 
    {
        try
        {
            String qry = "Update khachhang set ho_kh='"+kh_dto.getHo()+"',ten_kh = '"+kh_dto.getTen()+"',gioitinh_kh = '"+kh_dto.getGioitinh()+"',mail_kh = '"+kh_dto.getMail()+"',sdt_kh = '"+kh_dto.getSdt()+"',tongchitieu= '"+kh_dto.getTongchi()+/*"',pass_nv = '"+nv_dto.getPass()+*/"' where id_kh = '"+kh_dto.getId()+"'";

            int rs2=connect.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin khách hàng");
        }
    }

    public void Delete(KhachhangDTO kh_dto) throws Exception 
    {
        String qry="DELETE FROM `khachhang` WHERE `khachhang`.`ID_KH` ="+kh_dto.getId()+";";
        int rs2=connect.executeUpdate(qry);        
    }
    
    public void Delete2(String kh) throws Exception 
    {
        String qry="DELETE FROM `khachhang` WHERE `khachhang`.`ID_KH` ="+kh+";";
        System.out.println(qry);
        int rs2=connect.executeUpdate(qry);        
    }
}
