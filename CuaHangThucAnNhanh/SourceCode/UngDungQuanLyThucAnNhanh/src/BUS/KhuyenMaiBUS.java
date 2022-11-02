/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class KhuyenMaiBUS 
{
    
    public static ArrayList<KhuyenMaiDTO> danhsach_kmHD;
    public static ArrayList<KhuyenMaiDTO> danhsach_kmSP;
    public static ArrayList<KhuyenMaiDTO> danhsachdaydu;
        
    public KhuyenMaiBUS(){}
    
    public ArrayList<KhuyenMaiDTO> getDSKMloai1()//lấy chương trình khuyến mãi theo hóa đơn
    {
        if( danhsach_kmHD == null){
            danhsach_kmHD = new ArrayList<KhuyenMaiDTO>();
        }
        try{
            KhuyenMaiDAO km_dao = new KhuyenMaiDAO();
            danhsach_kmHD = km_dao.docDSKMloai1();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_kmHD;
    }
    
    public ArrayList<KhuyenMaiDTO> getDSKMloai2()//lấy chương trình khuyến mãi theo sản phẩm
    {
        if( danhsach_kmSP == null){
            danhsach_kmSP = new ArrayList<KhuyenMaiDTO>();
        }
        try{
            KhuyenMaiDAO km_dao = new KhuyenMaiDAO();
            danhsach_kmSP = km_dao.docDSKMloai2();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsach_kmSP;
    }
    
    public ArrayList<KhuyenMaiDTO> getDSKM()//lấy chương trình khuyến mãi
    {
        if( danhsachdaydu == null){
            danhsachdaydu = new ArrayList<KhuyenMaiDTO>();
        }
        try{
            KhuyenMaiDAO km_dao = new KhuyenMaiDAO();
            danhsachdaydu = km_dao.docDSKM();
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhsachdaydu;
    }
    public void Insert(KhuyenMaiDTO km_dto) throws Exception 
    {
        KhuyenMaiDAO data=new KhuyenMaiDAO();
	data.Insert(km_dto);
	danhsachdaydu.add(km_dto);
    }
    
    public void DeleteLoai1(KhuyenMaiDTO km_dto) throws Exception 
    {
        KhuyenMaiDAO data=new KhuyenMaiDAO();
        data.DeleteLoai1(km_dto);
        danhsach_kmHD.remove(km_dto);
    }
    
    public void Update(KhuyenMaiDTO km_dto) throws Exception
    {
        KhuyenMaiDAO data=new KhuyenMaiDAO();
        data.Update(km_dto);
        int k = 0;
        for (int i = 0; i < danhsachdaydu.size(); i++)
        {
            if ((danhsachdaydu.get(i)).getIdKM()==(km_dto.getIdKM()))
            {
                k = i;
                break;
            }
        }
        danhsachdaydu.set(k, km_dto);
    }
    
}


