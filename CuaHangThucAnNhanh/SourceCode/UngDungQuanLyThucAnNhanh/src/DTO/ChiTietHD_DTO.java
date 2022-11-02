package DTO;

public class ChiTietHD_DTO 
{
    private int idHD,idSP,soLuong;
    private double donGia,thanhTien,tienGG;
    public ChiTietHD_DTO()
    {
        idHD=-1;
        idSP=-1;
        soLuong=-1;
        donGia=-1;
        thanhTien=-1;
        tienGG=-1;
    }
    public ChiTietHD_DTO (int idhd,int idsp,int sl,double dongia,double thanhtien,double tiengg)
    {
        this.idHD=idhd;
        this.idSP=idsp;
        this.soLuong=sl;
        this.donGia=dongia;
        this.thanhTien=thanhtien;
        this.tienGG=tiengg;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSp) {
        this.idSP = idSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getTienGG() {
        return tienGG;
    }

    public void setTienGG(double tongTien) {
        this.tienGG = tongTien;
    }
    
    
}
