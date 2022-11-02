
package BUS;

import DAO.HangNhapDAO;
import DTO.HangnhapDTO;
import java.util.ArrayList;

public class HangNhapBUS {
    public static ArrayList<HangnhapDTO> dsHN;

    public HangNhapBUS() {
    }

    public ArrayList<HangnhapDTO> docDSHN() {
        if(dsHN == null){
            dsHN = new ArrayList<HangnhapDTO>();
        }
        try {
            HangNhapDAO data = new HangNhapDAO();
            dsHN = data.docDSHN();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsHN;
    }
    
    public void them(HangnhapDTO hn) throws Exception {
        HangNhapDAO data = new HangNhapDAO();
        data.them(hn);
        dsHN.add(hn);
    }

    public void sua(HangnhapDTO hn) throws  Exception{
        HangNhapDAO data = new HangNhapDAO();
        data.sua(hn);
        dsHN.add(hn);
    }

    public void capnhatTongTien(HangnhapDTO hn) throws  Exception{
        HangNhapDAO data = new HangNhapDAO();
        data.capnhatTongTien(hn);
        dsHN.add(hn);
    }
    
    public HangnhapDTO timIDPN(int idPN){
        for(HangnhapDTO hn : dsHN){
            if(hn.idPN == idPN){
                return hn;
            }
        }
        return null;
    }
    
    public ArrayList<HangnhapDTO> timIDNV(int idNV){
        ArrayList<HangnhapDTO> kq = new ArrayList<HangnhapDTO>();
        for(HangnhapDTO hn : dsHN){
            if(hn.idNV == idNV){
                kq.add(hn);
            }
        }
        return kq;
    }
    
    public ArrayList<HangnhapDTO> timIDNCC(int idNCC){
        ArrayList<HangnhapDTO> kq = new ArrayList<HangnhapDTO>();
        for(HangnhapDTO hn : dsHN){
            if(hn.idNCC == idNCC){
                kq.add(hn);
            }
        }
        return kq;
    }
    
    
    public ArrayList<HangnhapDTO> timTongTien(double tongtien){
        ArrayList<HangnhapDTO> kq = new ArrayList<HangnhapDTO>();
        for(HangnhapDTO hn : dsHN){
            if(hn.tongtien == tongtien){
                kq.add(hn);
            }
        }
        return kq;
    }
    
    public ArrayList<HangnhapDTO> timNgayNhap(String ngaynhap){
        ArrayList<HangnhapDTO> kq = new ArrayList<HangnhapDTO>();
        for(HangnhapDTO hn : dsHN){
            if(hn.ngaynhap.toLowerCase().indexOf(ngaynhap)>=0){
                kq.add(hn);
            }
        }
        return kq;
    }
    
}
