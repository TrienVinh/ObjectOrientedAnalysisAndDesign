package BUS;

import java.util.*;
import DAO.SanphamDAO;
import DTO.SanphamDTO;

public class SanphamBUS 
{
    
    public static ArrayList<SanphamDTO> danhsach_sp;
    public static ArrayList<SanphamDTO> danhsachdaydu;
    
    public SanphamBUS(){}
    
    public ArrayList<SanphamDTO> getDSSanpham()
    {
        if( danhsach_sp == null){
            danhsach_sp = new ArrayList<SanphamDTO>();
        }
        try{
            SanphamDAO nvdao = new SanphamDAO();
            danhsach_sp = nvdao.filteredList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_sp;
    }
    public ArrayList<SanphamDTO> getDSSanphamdaydu()
    {
        if( danhsachdaydu == null){
            danhsachdaydu = new ArrayList<SanphamDTO>();
        }
        try{
            SanphamDAO nvdao = new SanphamDAO();
            danhsachdaydu = nvdao.docDSSP();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsachdaydu;
    }
    public ArrayList<SanphamDTO> getDSSanPham(int idSP)
    {
        if( danhsach_sp == null){
            danhsach_sp = new ArrayList<SanphamDTO>();
        }
        try{
            SanphamDAO sp_dao = new SanphamDAO();
            danhsach_sp = sp_dao.docDSSP(idSP);
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_sp;
    }
    public void Insert(SanphamDTO sp_dto) throws Exception 
    {
        SanphamDAO data=new SanphamDAO();
	data.Insert(sp_dto);
	danhsach_sp.add(sp_dto);
    }
    public void Delete(SanphamDTO sp_dto) throws Exception 
    {
        SanphamDAO data=new SanphamDAO();
        data.Delete(sp_dto);
        danhsach_sp.remove(sp_dto);
    }
    
    public void Delete2(String masp,int i) throws Exception
    {
        SanphamDAO data=new SanphamDAO();
        data.Delete2(masp);
        danhsach_sp.remove(i);
    }

    public void Update(SanphamDTO sp_dto) throws Exception
    {
        SanphamDAO data=new SanphamDAO();
        data.Update(sp_dto);
        int k = 0;
        for (int i = 0; i < danhsach_sp.size(); i++)
        {
            if ((danhsach_sp.get(i)).getId().equals(sp_dto.getId()))
            {
                k = i;
            }
        }
        danhsach_sp.set(k, sp_dto);
    }   
    public void UpdateSLSP(SanphamDTO sp_dto) throws Exception{
        SanphamDAO data = new SanphamDAO();
        data.UpdateSLSP(sp_dto);
        danhsach_sp.add(sp_dto);
    }
}