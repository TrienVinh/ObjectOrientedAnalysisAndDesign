package BUS;

import DAO.ChiTietHD_DAO;
import DTO.ChiTietHD_DTO;
import java.util.ArrayList;

public class ChiTietHD_BUS 
{
    public static ArrayList<ChiTietHD_DTO> dsCTHD;
    
    public ArrayList<ChiTietHD_DTO> getDSCTHD(int idhd)
    {
        if( dsCTHD == null){
            dsCTHD = new ArrayList<ChiTietHD_DTO>();
        }
        try{
            ChiTietHD_DAO cthd_dao = new ChiTietHD_DAO();
            dsCTHD = cthd_dao.docCTHD(idhd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsCTHD;
    }
    
    public ArrayList<ChiTietHD_DTO> getDSCTHD()
    {
        if( dsCTHD == null){
            dsCTHD = new ArrayList<ChiTietHD_DTO>();
        }
        try{
            ChiTietHD_DAO cthd_dao = new ChiTietHD_DAO();
            dsCTHD = cthd_dao.docCTHD();
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsCTHD;
    }
    
    public void Insert (ChiTietHD_DTO cthd_dto) throws Exception
    {
        ChiTietHD_DAO cthd_dao=new ChiTietHD_DAO();
        cthd_dao.Insert(cthd_dto);
        dsCTHD.add(cthd_dto);
    }
}
