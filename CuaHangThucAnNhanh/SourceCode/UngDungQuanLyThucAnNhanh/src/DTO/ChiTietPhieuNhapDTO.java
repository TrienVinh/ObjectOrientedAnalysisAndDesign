
package DTO;

public class ChiTietPhieuNhapDTO {
    public int idPN, idSP, soluongSP;
    public double gianhap;
    
    public ChiTietPhieuNhapDTO() {
        this.idPN = 0;
        this.idSP = 0;
        this.soluongSP = 0;
        this.gianhap = 0;
    }
    
    public ChiTietPhieuNhapDTO(int idPN, int idSP, int soluongSP, double gianhap) {
        this.idPN = idPN;
        this.idSP = idSP;
        this.soluongSP = soluongSP;
        this.gianhap = gianhap;
    }
    
    public int getIDPN() {
        return this.idPN;
    }
    public int getIDSP() {
        return this.idSP;
    }
    public int getSoLuongSP() {
        return this.soluongSP;
    }
    public double getGiaNhap() {
        return this.gianhap;
    }
    
    public void setIDPN(int idPN) {
        this.idPN = idPN;
    }
    public void setIDSP(int idSP) {
        this.idSP = idSP;
    }
    public void setSoLuongSP(int soluongSP) {
        this.soluongSP = soluongSP;
    }
    public void setGiaNhap(double gianhap) {
        this.gianhap = gianhap;
    }
    
}
