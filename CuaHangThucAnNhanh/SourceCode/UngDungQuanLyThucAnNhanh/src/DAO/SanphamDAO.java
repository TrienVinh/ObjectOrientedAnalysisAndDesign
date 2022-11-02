package DAO;

import DTO.SanphamDTO;
import UTIL.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SanphamDAO
{   
    ResultSet rs = null;
    MyDBConnection connect = new MyDBConnection();
    ArrayList<SanphamDTO> danhsach_sp = null;

    public SanphamDAO()
    {
        connect = new MyDBConnection("localhost", "root", "", "doanjava");       
    }
    
    public ArrayList<SanphamDTO> docDSSP() throws Exception 
    {      
        danhsach_sp = new ArrayList<SanphamDTO>();              
        try
        {
            String qry = "Select * from sanpham";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(rs.getString(1));
                sp_dto.setTen(rs.getString(2));
                sp_dto.setSoluong(rs.getString(3));
                sp_dto.setDongia(rs.getString(4));
                sp_dto.setLoai(rs.getString(5));
                sp_dto.setTinhtrang(Integer.parseInt(rs.getString(6)));
                danhsach_sp.add(sp_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_sp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin sản phẩm");
        }
        return danhsach_sp;
        
    }
    public ArrayList<SanphamDTO> docDSSP(int idsp) throws Exception 
    {      
        danhsach_sp = new ArrayList<SanphamDTO>();              
        try
        {
            String qry = "Select * from sanpham WHERE ID_SP="+idsp+"";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(rs.getString(1));
                sp_dto.setTen(rs.getString(2));
                sp_dto.setSoluong(rs.getString(3));
                sp_dto.setDongia(rs.getString(4));
                sp_dto.setLoai(rs.getString(5));
                sp_dto.setTinhtrang(Integer.parseInt(rs.getString(6)));
                danhsach_sp.add(sp_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_sp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin sản phẩm");
        }
        return danhsach_sp;
    }
    public ArrayList<SanphamDTO> SearchDSSP2(String sp) throws Exception //Dùng cho nút tìm kiếm theo id
    {      
        ArrayList<SanphamDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from sanpham Where id_sp="+sp+" and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(rs.getString(1));
                sp_dto.setTen(rs.getString(2));
                sp_dto.setSoluong(rs.getString(3));
                sp_dto.setDongia(rs.getString(4));
                sp_dto.setLoai(rs.getString(5));
                sp_dto.setTinhtrang(Integer.parseInt(rs.getString(6)));
                temp.add(sp_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm thông tin sản phẩm");
        }
        return temp;       
    }
    public ArrayList<SanphamDTO> SearchDSSP3(String sp) throws Exception //Dùng cho nút tìm kiếm theo tên
    {      
        ArrayList<SanphamDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from sanpham Where ten_sp='"+sp+"' and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(rs.getString(1));
                sp_dto.setTen(rs.getString(2));
                sp_dto.setSoluong(rs.getString(3));
                sp_dto.setDongia(rs.getString(4));
                sp_dto.setLoai(rs.getString(5));
                sp_dto.setTinhtrang(Integer.parseInt(rs.getString(6)));
                temp.add(sp_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm thông tin sản phẩm");
        }
        return temp;       
    }
    public ArrayList<SanphamDTO> SearchDSSP4(String sp) throws Exception //Dùng cho nút tìm kiếm theo số lượng
    {      
        ArrayList<SanphamDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from sanpham Where sl_sp="+sp+" and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(rs.getString(1));
                sp_dto.setTen(rs.getString(2));
                sp_dto.setSoluong(rs.getString(3));
                sp_dto.setDongia(rs.getString(4));
                sp_dto.setLoai(rs.getString(5));
                sp_dto.setTinhtrang(Integer.parseInt(rs.getString(6)));
                temp.add(sp_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm thông tin sản phẩm");
        }
        return temp;       
    }
    public ArrayList<SanphamDTO> SearchDSSP5(String sp) throws Exception //Dùng cho nút tìm kiếm theo đơn giá
    {      
        ArrayList<SanphamDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from sanpham Where dongia_sp="+sp+" and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(rs.getString(1));
                sp_dto.setTen(rs.getString(2));
                sp_dto.setSoluong(rs.getString(3));
                sp_dto.setDongia(rs.getString(4));
                sp_dto.setLoai(rs.getString(5));
                sp_dto.setTinhtrang(Integer.parseInt(rs.getString(6)));
                temp.add(sp_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm thông tin sản phẩm");
        }
        return temp;       
    }
    public ArrayList<SanphamDTO> SearchDSSP6(String sp) throws Exception //Dùng cho nút tìm kiếm theo loại
    {      
        ArrayList<SanphamDTO> temp=new ArrayList();              
        try
        {
            String qry = "Select * from sanpham Where loai_sp='"+sp+"' and tinhtrang=1 ;";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(rs.getString(1));
                sp_dto.setTen(rs.getString(2));
                sp_dto.setSoluong(rs.getString(3));
                sp_dto.setDongia(rs.getString(4));
                sp_dto.setLoai(rs.getString(5));
                sp_dto.setTinhtrang(Integer.parseInt(rs.getString(6)));
                temp.add(sp_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return temp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm thông tin sản phẩm");
        }
        return temp;       
    }
    
    public void Insert(SanphamDTO sp_dto) throws Exception 
    {      
        try
        {
            String qry = "Insert into sanpham Values (";
            qry = qry + "" + sp_dto.getId() + ",";
            qry = qry + "'" + sp_dto.getTen() + "',";
            qry = qry + "'" + sp_dto.getSoluong() + "',";
            qry = qry + "'" + sp_dto.getDongia() + "',";
            qry = qry + "'" + sp_dto.getLoai() + "',";
            qry = qry + "1);";
            System.out.println(qry);
            int rs2=connect.executeUpdate(qry);            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin sản phẩm");
        }
    }

    public void Update(SanphamDTO sp_dto) throws Exception 
    {
        try
        {
            String qry = "Update sanpham set ten_sp='"+sp_dto.getTen()+"',sl_sp = '"+sp_dto.getSoluong()+"',dongia_sp = '"+sp_dto.getDongia()+"',loai_sp = '"+sp_dto.getLoai()+"' where id_sp = '"+sp_dto.getId()+"'";

            int rs2=connect.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin sản phẩm");
        }
    }

    public void Delete(SanphamDTO sp_dto) throws Exception 
    {
        String qry="update `sanpham` set tinhtrang=0 WHERE `sanpham`.`ID_SP` ="+sp_dto.getId()+";";
        int rs2=connect.executeUpdate(qry);        
    }
    
    public void Delete2(String sp) throws Exception 
    {
        String qry="update `sanpham` set tinhtrang=0 WHERE `sanpham`.`ID_SP` ="+sp+";";
        int rs2=connect.executeUpdate(qry);        
    }
    
    public ArrayList<SanphamDTO> filteredList() 
    {       
        try{
            danhsach_sp = docDSSP();
        }catch (Exception e){
            e.printStackTrace();
        }        
            ArrayList<SanphamDTO> edited = new ArrayList<SanphamDTO>();
            for (SanphamDTO sp : danhsach_sp)
            {
                if (sp.getTinhtrang() == 1) 
                {
                    edited.add(sp);
                }
            }
        return edited;
    }
    public void UpdateSLSP(SanphamDTO sp_dto) throws Exception {
        try {
            String qry = "Update sanpham set sl_sp = '" + sp_dto.getSoluong() + "' where id_sp = '" + sp_dto.getId() + "';";
            connect.executeUpdate(qry);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi !");
        }
    }
}
