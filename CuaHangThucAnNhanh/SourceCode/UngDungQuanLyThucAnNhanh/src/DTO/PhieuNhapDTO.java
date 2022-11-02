package DTO;

import java.io.Serializable;

public class PhieuNhapDTO implements  Serializable{
    
    private String id_pn;
    private String id_nv;
    private String id_ncc;
    private String ngaynhap_pn;
    private String tongtien_pn;
    public PhieuNhapDTO() {}
    
    public PhieuNhapDTO(String id_pn,String id_nv, String id_ncc, String ngaynhap_pn, String tongtien_pn) {
        this.id_pn = id_pn;
        this.id_nv = id_nv;
        this.id_ncc = id_ncc;
        this.ngaynhap_pn = ngaynhap_pn;
        this.tongtien_pn = tongtien_pn;
    }
    
    public String getId_pn() {
        return id_pn;
    }
    public void setId_pn(String id_pn) {
        this.id_pn = id_pn;
    }


    public String getId_nv() {
        return id_nv;
    }
    public void setId_nv(String id_nv) {
        this.id_nv = id_nv;
    }

    
    public String getId_ncc() {
        return id_ncc;
    }
    public void setId_ncc(String id_ncc) {
        this.id_ncc = id_ncc;
    }

    
    public String getNgaynhap_pn() {
        return ngaynhap_pn;
    }
    public void setNgaynhap_pn(String ngaynhap_pn) {
        this.ngaynhap_pn = ngaynhap_pn;
    }

    
    public String getTongtien_pn() {
        return tongtien_pn;
    }
    public void setTongtien_pn(String tongtien_pn) {
        this.tongtien_pn = tongtien_pn;
    }
}