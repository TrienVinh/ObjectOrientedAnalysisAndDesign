/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author SonThai
 */
    
public class NhaCungCapDTO {
	public String id, ten, sdt, mail, dc;
	public NhaCungCapDTO() {
		this.id = "";
		this.ten = "";
		this.sdt = "";
		this.mail = "";
		this.dc = "";
	}
	public NhaCungCapDTO(String id, String ten, String sdt, String mail, String dc) {
		this.id = id;
		this.ten = ten;
		this.sdt = sdt;
		this.mail = mail;
		this.dc = dc;
	}
	
	public String getID() {
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
	
	public void setID(String id) {
		this.id=id;
	}
	public void setTen(String ten) {
		this.ten=ten;
	}
	public void setSDT(String sdt) {
		this.sdt=sdt;
	}
	public void setMail(String mail) {
		this.mail=mail;
	}
	public void setDiaChi(String dc) {
		this.dc=dc;
	}
	
}

