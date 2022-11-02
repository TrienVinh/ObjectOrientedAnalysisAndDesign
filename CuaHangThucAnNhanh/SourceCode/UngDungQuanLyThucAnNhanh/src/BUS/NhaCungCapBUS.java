
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {

    public static ArrayList<NhaCungCapDTO> dsNCC;

    public NhaCungCapBUS() {
    }

    public ArrayList<NhaCungCapDTO> docDSNCC() {
        if(dsNCC == null){
            dsNCC = new ArrayList<NhaCungCapDTO>();
        }
        try {
            NhaCungCapDAO data = new NhaCungCapDAO();
            dsNCC = data.docDSNCC();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsNCC;
    }
    

    public void them(NhaCungCapDTO ncc) throws Exception {
        NhaCungCapDAO data = new NhaCungCapDAO();
        data.them(ncc);
        dsNCC.add(ncc);
    }

    public void sua(NhaCungCapDTO ncc) throws  Exception{
        NhaCungCapDAO data = new NhaCungCapDAO();
        data.sua(ncc);
        dsNCC.add(ncc);
    }

    public void xoa(NhaCungCapDTO ncc) throws Exception {
        NhaCungCapDAO data = new NhaCungCapDAO();
        data.xoa(ncc);
        dsNCC.add(ncc);
    }
    
    public NhaCungCapDTO timID(int id){
        for(NhaCungCapDTO ncc : dsNCC){
            if(ncc.id == id){
                return ncc;
            }
        }
        return null;
    }
    public ArrayList<NhaCungCapDTO> timTen(String ten){
        ArrayList<NhaCungCapDTO> kq = new ArrayList<NhaCungCapDTO>();
        for(NhaCungCapDTO ncc : dsNCC){
            if(ncc.ten.toLowerCase().indexOf(ten)>=0){
                kq.add(ncc);
            }
        }
        return kq;
    }
    public ArrayList<NhaCungCapDTO> timSDT(String sdt){
        ArrayList<NhaCungCapDTO> kq = new ArrayList<NhaCungCapDTO>();
        for(NhaCungCapDTO ncc : dsNCC){
            if(ncc.sdt.toLowerCase().indexOf(sdt)>=0){
                kq.add(ncc);
            }
        }
        return kq;
    }
    public ArrayList<NhaCungCapDTO> timMail(String mail){
        ArrayList<NhaCungCapDTO> kq = new ArrayList<NhaCungCapDTO>();
        for(NhaCungCapDTO ncc : dsNCC){
            if(ncc.mail.toLowerCase().indexOf(mail)>=0){
                kq.add(ncc);
            }
        }
        return kq;
    }
    
    public ArrayList<NhaCungCapDTO> timDiaChi(String diachi){
        ArrayList<NhaCungCapDTO> kq = new ArrayList<NhaCungCapDTO>();
        for(NhaCungCapDTO ncc : dsNCC){
            if(ncc.dc.toLowerCase().indexOf(diachi)>=0){
                kq.add(ncc);
            }
        }
        return kq;
    }
    
    public ArrayList<NhaCungCapDTO> timTinhTrang(int tinhtrang){
        ArrayList<NhaCungCapDTO> kq = new ArrayList<NhaCungCapDTO>();
        for(NhaCungCapDTO ncc : dsNCC){
            if(ncc.tinhtrang == tinhtrang){
                kq.add(ncc);
            }
        }
        return kq;
    }
}
