package DTO;

import java.io.Serializable;

public class KhachhangDTO implements  Serializable{
    
    private String id_kh;
    private String ho_kh;
    private String ten_kh;
    private String sdt_kh;
    private String mail_kh;
    private String gioitinh_kh;
    private String tongchitieu_kh;
    
    public KhachhangDTO() {}

    public KhachhangDTO(String id_kh,String ho_kh, String ten_kh, String sdt_kh, String mail_kh, String gioitinh_kh, String tongchitieu_kh) {
        this.id_kh=id_kh;
        this.ho_kh = ho_kh;
        this.ten_kh = ten_kh;
        this.sdt_kh = sdt_kh;
        this.mail_kh = mail_kh;
        this.gioitinh_kh = gioitinh_kh;
        this.tongchitieu_kh = tongchitieu_kh;
    }
    
    public String getId() {
        return id_kh;
    }
    public void setId(String id_kh) {
        this.id_kh = id_kh;
    }


    public String getHo() {
        return ho_kh;
    }
    public void setHo(String ho_kh) {
        this.ho_kh = ho_kh;
    }

    
    public String getTen() {
        return ten_kh;
    }
    public void setTen(String ten_kh) {
        this.ten_kh = ten_kh;
    }

    
    public String getSdt() {
        return sdt_kh;
    }
    public void setSdt(String sdt_kh) {
        this.sdt_kh = sdt_kh;
    }

    
    public String getMail() {
        return mail_kh;
    }
    public void setMail(String mail_kh) {
        this.mail_kh = mail_kh;
    }

    
    public String getGioitinh() {
        return gioitinh_kh;
    }
    public void setGioitinh(String gioitinh_kh) {
        this.gioitinh_kh = gioitinh_kh;
    }
   
    
    public String getTongchi() {
        return tongchitieu_kh;
    }
    public void setTongchi(String tongchitieu_kh) {
        this.tongchitieu_kh = tongchitieu_kh;
    }
}