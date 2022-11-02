/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietKM_DAO;
import DTO.ChiTietKM_DTO;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class ChiTietKM_BUS {
    
    public static ArrayList<ChiTietKM_DTO> danhsach_ctkm;
    //public static ArrayList<ChiTietKM_DTO> danhsachdaydu;
        
    public ChiTietKM_BUS(){}
    
    public ArrayList<ChiTietKM_DTO> getDSCTKM(int idGG)
    {
        if( danhsach_ctkm == null){
            danhsach_ctkm = new ArrayList<ChiTietKM_DTO>();
        }
        try{
            ChiTietKM_DAO ctkm_dao = new ChiTietKM_DAO();
            danhsach_ctkm = ctkm_dao.docDSCTKM(idGG);
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_ctkm;
    }
    
    public ArrayList<ChiTietKM_DTO> getDSCTKM()
    {
        if( danhsach_ctkm == null){
            danhsach_ctkm = new ArrayList<ChiTietKM_DTO>();
        }
        try{
            ChiTietKM_DAO ctkm_dao = new ChiTietKM_DAO();
            danhsach_ctkm = ctkm_dao.docDSCTKM();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_ctkm;
    }
    
    public void Insert(ChiTietKM_DTO ctkm_dto) throws Exception 
    {
        ChiTietKM_DAO data=new ChiTietKM_DAO();
	data.Insert(ctkm_dto);
	danhsach_ctkm.add(ctkm_dto);
    }
    
    public void DeleteOneID(ChiTietKM_DTO ctkm_dto) throws Exception 
    {
        ChiTietKM_DAO data=new ChiTietKM_DAO();
        data.DeleteOneID(ctkm_dto);
        danhsach_ctkm.remove(ctkm_dto);
    }
    
    public void Update(ChiTietKM_DTO ctkm_dto) throws Exception
    {
        ChiTietKM_DAO data=new ChiTietKM_DAO();
        data.Update(ctkm_dto);
        int k = 0;
        for (int i = 0; i < danhsach_ctkm.size(); i++)
        {
            if ((danhsach_ctkm.get(i)).getIdKM()==(ctkm_dto.getIdKM())&& danhsach_ctkm.get(i).getIdSP()==(ctkm_dto.getIdSP()))
            {
                k = i;
                break;
            }
        }
        danhsach_ctkm.set(k, ctkm_dto);
    }
}
