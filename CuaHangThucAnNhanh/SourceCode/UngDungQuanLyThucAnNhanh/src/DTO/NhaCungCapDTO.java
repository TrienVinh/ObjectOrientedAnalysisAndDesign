
package DTO;


public class NhaCungCapDTO {

    public String ten, sdt, mail, dc;
    public int id, tinhtrang;

    public NhaCungCapDTO() {
        this.id = 0;
        this.ten = "";
        this.sdt = "";
        this.mail = "";
        this.dc = "";
        this.tinhtrang = 1;
    }

    public NhaCungCapDTO(int id, String ten, String sdt, String mail, String dc, int tinhtrang) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.mail = mail;
        this.dc = dc;
        this.tinhtrang = tinhtrang;
    }

    public int getID() {
        return this.id;
    }

    public String getTen() {
        return this.ten;
    }

    public String getSDT() {
        return this.sdt;
    }

    public String getMail() {
        return this.mail;
    }

    public String getDiaChi() {
        return this.dc;
    }
    
    public int getTinhTrang() {
        return this.tinhtrang;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDiaChi(String dc) {
        this.dc = dc;
    }
    
    public void setTinhTrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

}
