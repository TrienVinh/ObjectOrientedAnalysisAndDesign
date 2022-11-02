package BUS;

import java.util.*;
import DAO.KhachhangDAO;
import DTO.KhachhangDTO;

public class KhachhangBUS 
{
    public static ArrayList<KhachhangDTO> danhsach_kh;
        
    public KhachhangBUS(){}
    
    public ArrayList<KhachhangDTO> getDSKhachhang()
    {
        if( danhsach_kh == null){
            danhsach_kh = new ArrayList<KhachhangDTO>();
        }
        try{
            KhachhangDAO nvdao = new KhachhangDAO();
            danhsach_kh = nvdao.docDSKH();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_kh;
    }
    
    public void Insert(KhachhangDTO kh_dto) throws Exception 
    {
        KhachhangDAO data=new KhachhangDAO();
	data.Insert(kh_dto);
	danhsach_kh.add(kh_dto);
    }
    public void Delete(KhachhangDTO kh_dto) throws Exception 
    {
        KhachhangDAO data=new KhachhangDAO();
        data.Delete(kh_dto);
        danhsach_kh.remove(kh_dto);
    }
    
    public void Delete2(String makh,int i) throws Exception 
    {
        KhachhangDAO data=new KhachhangDAO();
        data.Delete2(makh);
        danhsach_kh.remove(i);
    }

    public void Update(KhachhangDTO kh_dto) throws Exception 
    {
        KhachhangDAO data=new KhachhangDAO();
        data.Update(kh_dto);
        int k = 0;
        for (int i = 0; i < danhsach_kh.size(); i++) 
        {
            if ((danhsach_kh.get(i)).getId().equals(kh_dto.getId())) 
            {
                k = i;
            }
        }
        danhsach_kh.set(k, kh_dto);
    }
}
