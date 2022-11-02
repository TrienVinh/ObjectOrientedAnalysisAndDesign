
package DTO;

public class HangnhapDTO {
    public int idPN, idNV, idNCC;
    public String ngaynhap;
    public double tongtien;
    
    public HangnhapDTO() {
        this.idPN = 0;
        this.idNV = 0;
        this.idNCC = 0;
        this.ngaynhap = "";
        this.tongtien = 0;
    }

    public HangnhapDTO(int idPN, int idNV, int idNCC, String ngaynhap, double tongtien) {
        this.idPN = idPN;
        this.idNV = idNV;
        this.idNCC = idNCC;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
    }
    
    public int getIDPN() {
        return this.idPN;
    }
    public int getIDNV() {
        return this.idNV;
    }
    public int getIDNCC() {
        return this.idNCC;
    }
    public String getNgayNhap() {
        return this.ngaynhap;
    }
    public double getTongTien() {
        return this.tongtien;
    }
    
    public void setIDPN(int idPN) {
        this.idPN = idPN;
    }
    public void setIDNV(int idNV) {
        this.idNV = idNV;
    }
    public void setIDNCC(int idNCC) {
        this.idNCC = idNCC;
    }
    public void setNgayNhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    public void setTongTien(double tongtien) {
        this.tongtien = tongtien;
    }
}
