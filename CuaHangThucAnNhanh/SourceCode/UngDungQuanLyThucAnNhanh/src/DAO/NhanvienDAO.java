package DAO;

import DTO.NhanvienDTO;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NhanvienDAO
{
    ResultSet rs = null;
    MyDBConnection connect = new MyDBConnection();
    ArrayList<NhanvienDTO> danhsach_nv = null;

    public NhanvienDAO()
    {
        connect = new MyDBConnection("localhost", "root", "", "doanjava");
    }
    
    public ArrayList<NhanvienDTO> docDSNV() throws Exception
    {
        danhsach_nv = new ArrayList<NhanvienDTO>();
        try
        {
            String qry = "Select * from nhanvien";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setId_phanquyen(Integer.parseInt(rs.getString(9)));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(10)));
                danhsach_nv.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_nv;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return danhsach_nv;
    }
    
    public ArrayList<NhanvienDTO> SearchDSNV2(String nv) throws Exception //Dùng cho nút tìm kiếm theo id
    {      
        ArrayList<NhanvienDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from nhanvien Where id_nv="+nv+" and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(9)));
                temp.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;       
    }
    public ArrayList<NhanvienDTO> SearchDSNV3(String nv) throws Exception //Dùng cho nút tìm kiếm theo họ
    {      
        ArrayList<NhanvienDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from nhanvien Where ho_nv='"+nv+"' and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(9)));
                temp.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;       
    }
    public ArrayList<NhanvienDTO> SearchDSNV4(String nv) throws Exception //Dùng cho nút tìm kiếm theo tên
    {      
        ArrayList<NhanvienDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from nhanvien Where ten_nv='"+nv+"' and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(9)));
                temp.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;       
    }
    public ArrayList<NhanvienDTO> SearchDSNV5(String nv) throws Exception //Dùng cho nút tìm kiếm theo số điện thoại
    {      
        ArrayList<NhanvienDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from nhanvien Where sdt_nv="+nv+" and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(9)));
                temp.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;       
    }
    public ArrayList<NhanvienDTO> SearchDSNV6(String nv) throws Exception //Dùng cho nút tìm kiếm theo mail
    {      
        ArrayList<NhanvienDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from nhanvien Where mail_nv='"+nv+"' and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(9)));
                temp.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;       
    }
    public ArrayList<NhanvienDTO> SearchDSNV7(String nv) throws Exception //Dùng cho nút tìm kiếm theo giới tính
    {      
        ArrayList<NhanvienDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from nhanvien Where gioitinh_nv='"+nv+"' and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(9)));
                temp.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;       
    }
    public ArrayList<NhanvienDTO> SearchDSNV8(String nv) throws Exception //Dùng cho nút tìm kiếm theo chức vụ
    {      
        ArrayList<NhanvienDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from nhanvien Where chucvu_nv='"+nv+"' and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(rs.getString(1));
                nv_dto.setHo(rs.getString(2));
                nv_dto.setTen(rs.getString(3));
                nv_dto.setSdt(rs.getString(4));
                nv_dto.setMail(rs.getString(5));
                nv_dto.setGioitinh(rs.getString(6));
                nv_dto.setChucvu(rs.getString(7));
                nv_dto.setTinhtrang(Integer.parseInt(rs.getString(9)));
                temp.add(nv_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên");
        }
        return temp;       
    }
    
    public void Insert(NhanvienDTO nv_dto) throws Exception 
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
            qry = qry + "MD5('null'),";
            qry = qry + "'2',";
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
    
    public ArrayList<NhanvienDTO> filteredList() // Về tình trạng NV
    {       
        try{
            danhsach_nv = docDSNV();
        }catch (Exception e){
            e.printStackTrace();
        }        
            ArrayList<NhanvienDTO> edited = new ArrayList<NhanvienDTO>();
            for (NhanvienDTO nv : danhsach_nv)
            {
                if (nv.getTinhtrang() == 1) 
                {
                    if( (nv.getId_phanquyen()==1 || nv.getId_phanquyen()==2) )
                    {
                        edited.add(nv);
                    }                    
                }
            }
        return edited;
    }
    
    //=========== User nv login ============//
    public boolean isEmailExist(String username) throws Exception   //Kiểm tra email đăng nhập
    {
        String qry="Select * from `nhanvien` WHERE `nhanvien`.`MAIL_NV` = '"+username+"';";
        rs = connect.excuteQuery(qry);
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }               
    }
    public boolean checkPassword(String username, String password) throws Exception //Kiểm tra password đăng nhập
    {
        String qry="Select * from `nhanvien` WHERE `nhanvien`.`MAIL_NV` = '"+username+"' and PASS_NV= MD5('"+password+"');";
        rs = connect.excuteQuery(qry);
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public NhanvienDTO LayThongTinNVTheoMail(String username) throws Exception  //Lấy thông tin của nhân viên khi đăng nhập vào 
    {
        String qry="Select * from `nhanvien` WHERE `nhanvien`.`MAIL_NV` = '"+username+"';";
        rs = connect.excuteQuery(qry);
        NhanvienDTO nv_dto = new NhanvienDTO();
        while(rs.next()){
            nv_dto.setId(rs.getString(1));
            nv_dto.setHo(rs.getString(2));
            nv_dto.setTen(rs.getString(3));
            nv_dto.setSdt(rs.getString(4));
            nv_dto.setMail(rs.getString(5));
            nv_dto.setGioitinh(rs.getString(6));
            nv_dto.setChucvu(rs.getString(7));
            nv_dto.setPassword(rs.getString(8));
            nv_dto.setId_phanquyen(Integer.parseInt(rs.getString(9)));
            nv_dto.setTinhtrang(Integer.parseInt(rs.getString(10)));
        }
        connect.Close();
        return nv_dto;
    }
    public void Update2(NhanvienDTO nv_dto) throws Exception //Cập nhật thông tin khi mới đăng nhập vào 
    {
        try
        {
            String qry = "Update nhanvien set pass_nv = MD5('"+nv_dto.getPassword()+"'), ho_nv='"+nv_dto.getHo()+"',ten_nv = '"+nv_dto.getTen()+"',gioitinh_nv = '"+nv_dto.getGioitinh()+"',mail_nv = '"+nv_dto.getMail()+"',sdt_nv = '"+nv_dto.getSdt()+"',chucvu_nv = '"+nv_dto.getChucvu()+"' where id_nv = '"+nv_dto.getId()+"'";
            //UPDATE `nhanvien` SET `PASS_NV` = '12345' WHERE `nhanvien`.`ID_NV` = 1;
            int rs2=connect.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin nhân viên");
        }
    }
}