package DTO;

import java.io.Serializable;

public class NhanvienDTO implements  Serializable{
    
    private String id_nv;
    private String ho_nv;
    private String ten_nv;
    private String sdt_nv;
    private String mail_nv;
    private String gioitinh_nv;
    private String chucvu_nv;
    private String password_nv;
    private int id_phanquyen;
    private int tinhtrang;
    
    public NhanvienDTO() {}
    
    public NhanvienDTO(String id_nv,String ho_nv, String ten_nv, String sdt_nv, String mail_nv, String gioitinh_nv, String chucvu_nv, String password_nv, int id_phanquyen, int tinhtrang) {
        this.id_nv=id_nv;
        this.ho_nv = ho_nv;
        this.ten_nv = ten_nv;
        this.sdt_nv = sdt_nv;
        this.mail_nv = mail_nv;
        this.gioitinh_nv = gioitinh_nv;
        this.chucvu_nv = chucvu_nv;
        this.password_nv = password_nv;
        this.id_phanquyen = id_phanquyen;
        this.tinhtrang = tinhtrang;       
    }
    
    public String getId() {
        return id_nv;
    }
    public void setId(String id_nv) {
        this.id_nv = id_nv;
    }


    public String getHo() {
        return ho_nv;
    }
    public void setHo(String ho_nv) {
        this.ho_nv = ho_nv;
    }

    
    public String getTen() {
        return ten_nv;
    }
    public void setTen(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    
    public String getSdt() {
        return sdt_nv;
    }
    public void setSdt(String sdt_nv) {
        this.sdt_nv = sdt_nv;
    }

    
    public String getMail() {
        return mail_nv;
    }
    public void setMail(String mail_nv) {
        this.mail_nv = mail_nv;
    }

    
    public String getGioitinh() {
        return gioitinh_nv;
    }
    public void setGioitinh(String gioitinh_nv) {
        this.gioitinh_nv = gioitinh_nv;
    }
   
    
    public String getChucvu() {
        return chucvu_nv;
    }
    public void setChucvu(String chucvu_nv) {
        this.chucvu_nv = chucvu_nv;
    }
    
    public int getTinhtrang() {
        return tinhtrang;
    }
    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    
    public String getPassword() {
        return password_nv;
    }
    public void setPassword(String password_nv) {
        this.password_nv = password_nv;
    }
    
    public int getId_phanquyen() {
        return id_phanquyen;
    }

    public void setId_phanquyen(int id_phanquyen) {
        this.id_phanquyen = id_phanquyen;
    }
}