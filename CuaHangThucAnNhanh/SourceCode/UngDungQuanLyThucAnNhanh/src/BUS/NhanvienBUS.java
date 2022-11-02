package BUS;

import java.util.*;
import DAO.NhanvienDAO;
import DTO.NhanvienDTO;
import UTIL.General;

public class NhanvienBUS 
{
    public static ArrayList<NhanvienDTO> danhsach_nv;
    public static ArrayList<NhanvienDTO> danhsachdaydu;
        
    public NhanvienBUS(){}
    
    public ArrayList<NhanvienDTO> getDSNhanvien()
    {
        if( danhsach_nv == null){
            danhsach_nv = new ArrayList<NhanvienDTO>();
        }
        try{
            NhanvienDAO nvdao = new NhanvienDAO();
            danhsach_nv = nvdao.filteredList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_nv;
    }
    
    public ArrayList<NhanvienDTO> getDSNhanviendaydu()
    {
        if( danhsachdaydu == null){
            danhsachdaydu = new ArrayList<NhanvienDTO>();
        }
        try{
            NhanvienDAO nvdao = new NhanvienDAO();
            danhsachdaydu = nvdao.docDSNV();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsachdaydu;
    }
    
    public void Insert(NhanvienDTO nv_dto) throws Exception 
    {
        NhanvienDAO data=new NhanvienDAO();
	data.Insert(nv_dto);
	danhsach_nv.add(nv_dto);
    }
    public void Delete(NhanvienDTO nv_dto) throws Exception 
    {
        NhanvienDAO data=new NhanvienDAO();
        data.Delete(nv_dto);
        danhsach_nv.remove(nv_dto);
    }
    
    public void Delete2(String manv,int i) throws Exception
    {
        NhanvienDAO data=new NhanvienDAO();
        data.Delete2(manv);
        danhsach_nv.remove(i);
    }

    public void Update(NhanvienDTO nv_dto) throws Exception
    {
        NhanvienDAO data=new NhanvienDAO();
        data.Update(nv_dto);
        int k = 0;
        for (int i = 0; i < danhsach_nv.size(); i++)
        {
            if ((danhsach_nv.get(i)).getId().equals(nv_dto.getId()))
            {
                k = i;
            }
        }
        danhsach_nv.set(k, nv_dto);
    }   
    //=========== User nv login ============//
    public boolean Login(String username, String password) throws Exception
    {
        NhanvienDAO data=new NhanvienDAO();
        if(data.checkPassword(username, password))
        {
            NhanvienDTO nv_dto = new NhanvienDTO();
            nv_dto = data.LayThongTinNVTheoMail(username);
            
            General.CURRENT_USER = username;
            General.CURRENT_ROLE = nv_dto.getId_phanquyen();
            return true;
        }
        else {           
            return false;
        }
    }
    public NhanvienDTO LayThongTinNVTheoMail(String username) throws Exception {
        NhanvienDAO data=new NhanvienDAO();
        return data.LayThongTinNVTheoMail(username);
    }
    
    public void Update2(NhanvienDTO nv_dto) throws Exception    //Cập nhật thông tin khi mới đăng nhập vào 
    {
        NhanvienDAO data=new NhanvienDAO();
        data.Update2(nv_dto);
        int k = 0;
        for (int i = 0; i < danhsach_nv.size(); i++)
        {
            if ((danhsach_nv.get(i)).getId().equals(nv_dto.getId()))
            {
                k = i;
            }
        }
        danhsach_nv.set(k, nv_dto);
    }   
}