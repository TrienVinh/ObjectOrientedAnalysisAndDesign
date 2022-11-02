package DTO;

import java.io.Serializable;

public class SanphamDTO implements  Serializable{
    
    public String id_sp;
    public String ten_sp;
    public String sl_sp;
    public String dongia_sp;
    public String loai_sp;
    private int tinhtrang_sp;
    
    public SanphamDTO() {}
    
    public SanphamDTO(String id_sp,String ten_sp, String sl_sp, String dongia_sp, String loai_sp, int tinhtrang_sp) {
        this.id_sp=id_sp;
        this.ten_sp = ten_sp;
        this.sl_sp = sl_sp;
        this.dongia_sp = dongia_sp;
        this.loai_sp = loai_sp;
        this.tinhtrang_sp = tinhtrang_sp;
    }
    
    public String getId() {
        return id_sp;
    }
    public void setId(String id_sp) {
        this.id_sp = id_sp;
    }
    
    public String getTen() {
        return ten_sp;
    }
    public void setTen(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    
    public String getSoluong() {
        return sl_sp;
    }
    public void setSoluong(String sl_sp) {
        this.sl_sp = sl_sp;
    }

    
    public String getDongia() {
        return dongia_sp;
    }
    public void setDongia(String dongia_sp) {
        this.dongia_sp = dongia_sp;
    }

    
    public String getLoai() {
        return loai_sp;
    }
    public void setLoai(String loai_sp) {
        this.loai_sp = loai_sp;
    }
   
    
    public int getTinhtrang() {
        return tinhtrang_sp;
    }
    public void setTinhtrang(int tinhtrang_sp) {
        this.tinhtrang_sp = tinhtrang_sp;
    }
    
}