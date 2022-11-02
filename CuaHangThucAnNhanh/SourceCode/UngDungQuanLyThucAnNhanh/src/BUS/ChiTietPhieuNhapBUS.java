
package BUS;

import static BUS.ChiTietPhieuNhapBUS.dsChiTietPN;
import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

public class ChiTietPhieuNhapBUS {
    public static ArrayList<ChiTietPhieuNhapDTO> dsChiTietPN;

    public ChiTietPhieuNhapBUS() {
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> docDSChiTietPN() {
        if(dsChiTietPN == null){
            dsChiTietPN = new ArrayList<ChiTietPhieuNhapDTO>();
        }
        try {
            ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
            dsChiTietPN = data.docDSChiTietPN();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsChiTietPN;
    }
    
    public void them(ChiTietPhieuNhapDTO ctpn) throws Exception {
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        data.them(ctpn);
        dsChiTietPN.add(ctpn);
    }

    public void sua(ChiTietPhieuNhapDTO ctpn) throws  Exception{
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        data.sua(ctpn);
        dsChiTietPN.add(ctpn);
    }

    public void xoa(ChiTietPhieuNhapDTO ctpn) throws Exception {
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        data.xoa(ctpn);
        dsChiTietPN.add(ctpn);
    }
}
