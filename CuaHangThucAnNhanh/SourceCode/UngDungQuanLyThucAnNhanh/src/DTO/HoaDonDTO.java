package DTO;

public class HoaDonDTO 
{
    private int idHD,idKH,idNV,idGG;
    private String ngayLapHD;
    private double tongTien,tienGG;
    
    public HoaDonDTO ()
    {
        idHD=0;
        idKH=0;
        idNV=0;
        idGG=0;
        ngayLapHD=null;
        tongTien=0;
        tienGG=-1;
    }
    public HoaDonDTO (int idhd,int idkh,int idnv,int idgg,String ngaylap,double tongtien,double tiengg)
    {
        this.idHD=idhd;
        this.idKH=idkh;
        this.idNV=idnv;
        this.idGG=idgg;
        this.ngayLapHD=ngaylap;
        this.tongTien=tongtien;
        this.tienGG=tiengg;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdGG() {
        return idGG;
    }

    public void setIdGG(int idGG) {
        this.idGG = idGG;
    }

    public String getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTienGG() {
        return tienGG;
    }

    public void setTienGG(double tienGG) {
        this.tienGG = tienGG;
    }
    
    
}
