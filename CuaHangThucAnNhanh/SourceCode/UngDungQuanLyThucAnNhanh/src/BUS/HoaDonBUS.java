package BUS;

import DAO.HoaDonDAO;
import DAO.KhuyenMaiDAO;
import DTO.HoaDonDTO;
import DTO.KhuyenMaiDTO;
import Kiemtra.KT;
import java.util.ArrayList;

public class HoaDonBUS 
{
    public static ArrayList<HoaDonDTO> dsHD;
    
    public ArrayList<HoaDonDTO> getDSHoaDon()
    {
        if( dsHD == null){
            dsHD = new ArrayList<HoaDonDTO>();
        }
        try{
            HoaDonDAO hd_dao = new HoaDonDAO();
            dsHD = hd_dao.docHD();
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsHD;
    }
    
    public ArrayList<HoaDonDTO> getDSHoaDon_dkSo(String dieuKien, int giaTri)
    {
        if( dsHD == null){
            dsHD = new ArrayList<HoaDonDTO>();
        }
        try{
            HoaDonDAO hd_dao = new HoaDonDAO();
            dsHD = hd_dao.docHD_dkSo(dieuKien,giaTri);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsHD;
    }
    public void Update (int idhd, double tongTien, double tienGG) throws Exception
    {
        HoaDonDAO hd_dao=new HoaDonDAO();
        hd_dao.Update(idhd,tongTien,tienGG);
    }
        
    public void capnhatTongTien(HoaDonDTO hd) throws  Exception{
        HoaDonDAO hd_dao = new HoaDonDAO();
        hd_dao.capnhatTongTien(hd);
        dsHD.add(hd);
    }
    
    public void capnhatIDGG(HoaDonDTO hd) throws  Exception{
        HoaDonDAO hd_dao = new HoaDonDAO();
        hd_dao.capnhatIDGG(hd);
        dsHD.add(hd);
    }
    
    public void Insert (HoaDonDTO hd_dto) throws Exception
    {
        HoaDonDAO hd_dao=new HoaDonDAO();
        hd_dao.Insert(hd_dto);
        dsHD.add(hd_dto);
    }
    
    public HoaDonDTO timIDHD(int idHD)
    {
        for(HoaDonDTO hd : dsHD)
        {
            if(hd.getIdHD() ==idHD)
            {
                return hd;
            }
        }
        return null;
    }
    
    public ArrayList<HoaDonDTO> timIDKH(int idKH)
    {
        ArrayList<HoaDonDTO> kq = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO hd : dsHD)
        {
            if(hd.getIdKH() == idKH)
            {
                kq.add(hd);
            }
        }
        return kq;
    }
    
    public ArrayList<HoaDonDTO> timIDNV(int idNV)
    {
        ArrayList<HoaDonDTO> kq = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO hd : dsHD)
        {
            if(hd.getIdNV() == idNV)
            {
                kq.add(hd);
            }
        }
        return kq;
    }
    
    public ArrayList<HoaDonDTO> timIDGG(int idGG)
    {
        ArrayList<HoaDonDTO> kq = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO hd : dsHD)
        {
            if(hd.getIdGG() == idGG)
            {
                kq.add(hd);
            }
        }
        return kq;
    }
    
//    public ArrayList<HoaDonDTO> timNgayLap(String ngaynhap){
//        ArrayList<HoaDonDTO> kq = new ArrayList<HoaDonDTO>();
//        for(HoaDonDTO hd : dsHD){
//            if(hd.ngayLapHD.toLowerCase().contains(ngaynhap)){
//                kq.add(hd);
//            }
//        }
//        return kq;
//    }
//    
//    public ArrayList<HoaDonDTO> timTongTien(double tongtien){
//        ArrayList<HoaDonDTO> kq = new ArrayList<HoaDonDTO>();
//        for(HoaDonDTO hd : dsHD){
//            if(hd.tongTien == tongtien){
//                kq.add(hd);
//            }
//        }
//        return kq;
//    }
//    
//    public ArrayList<HoaDonDTO> timTienGG(double tienGG){
//        ArrayList<HoaDonDTO> kq = new ArrayList<HoaDonDTO>();
//        for(HoaDonDTO hd : dsHD){
//            if(hd.tienGG == tienGG){
//                kq.add(hd);
//            }
//        }
//        return kq;
//    }
    
//    public KhuyenMaiDTO getKMofHD(String ngay,double tongtien) throws Exception
//    {
//        int i;
//        KT kt=new KT();
//        ArrayList<KhuyenMaiDTO> temp=new ArrayList();
//        KhuyenMaiDAO data=new KhuyenMaiDAO();
//        temp=data.docDSKM();
//        for(i=0;i<temp.size();i++)
//        {
//            if(kt.ngaytruocngay(temp.get(i).getNgayBD(), ngay)&&kt.ngaytruocngay(ngay,temp.get(i).getNgayKT()))
//                if(tongtien<=temp.get(i).getDieukienGG())
//                    return temp.get(i);
//        }
//        return null;
//    }
}
