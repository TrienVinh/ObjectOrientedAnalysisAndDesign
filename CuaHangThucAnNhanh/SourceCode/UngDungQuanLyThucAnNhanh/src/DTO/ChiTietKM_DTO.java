package DTO;

public class ChiTietKM_DTO {
    private int idKM,idSP;
    private double noidungGG;
    
    public ChiTietKM_DTO ()
    {
        idKM=0;
        idSP=0;
        noidungGG=0;
    }
    public ChiTietKM_DTO (int idKM,int idSP, double dieukienGG)
    {
        this.idKM=idKM;
        this.idSP=idSP;
        this.noidungGG=dieukienGG;
    }

    public int getIdKM() {
        return idKM;
    }

    public void setIdKM(int idKM) {
        this.idKM = idKM;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public double getNoidungGG() {
        return noidungGG;
    }

    public void setNoidungGG(double noidungGG) {
        this.noidungGG = noidungGG;
    }
    
}
