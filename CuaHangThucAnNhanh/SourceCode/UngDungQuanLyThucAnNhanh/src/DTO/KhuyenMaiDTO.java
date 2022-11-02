package DTO;

public class KhuyenMaiDTO 
{
    private int idKM,loaiCT;
    private String ngayBD,ngayKT,tenKM;
    private double noidungGG,dieukienGG;
    
    public KhuyenMaiDTO ()
    {
        idKM=-1;
        tenKM=null;
        loaiCT=-1;
        ngayBD=null;
        ngayKT=null;
        noidungGG=-1;
        dieukienGG=-1;
    }
    public KhuyenMaiDTO (int idKM, String tenCT, int loaiCT, String ngayBD, String ngayKT,  double noidungGG, double dieukienGG)
    {
        this.idKM=idKM;
        this.tenKM=tenCT;
        this.loaiCT=loaiCT;
        this.ngayBD=ngayBD;
        this.ngayKT=ngayKT;
        this.noidungGG=noidungGG;
        this.dieukienGG=dieukienGG;
    }

    public int getIdKM() {
        return idKM;
    }

    public void setIdKM(int idKM) {
        this.idKM = idKM;
    }
    public int getLoaiCT() {
        return loaiCT;
    }

    public void setLoaiCT(int loaiCT) {
        this.loaiCT = loaiCT;
    }
    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public double getNoidungGG() {
        return noidungGG;
    }

    public void setNoidungGG(double noidungGG) {
        this.noidungGG = noidungGG;
    }

    public double getDieukienGG() {
        return dieukienGG;
    }

    public void setDieukienGG(double dieukienGG) {
        this.dieukienGG = dieukienGG;
    }

    
}

