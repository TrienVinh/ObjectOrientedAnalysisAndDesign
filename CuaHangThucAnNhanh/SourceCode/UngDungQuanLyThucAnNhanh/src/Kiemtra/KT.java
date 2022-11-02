
package Kiemtra;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern; 
    public  class KT {
    private static String N = "[\\d]*";
    private String Z = "[\\d]*+|[-][\\d]*";
    private String R = "[\\d]*+|[-][\\d]*+|[\\d]*[.][\\d]*+|[-][\\d]*[.][\\d]*";
    private String R_ = "[\\d]*+|[\\d]*[.][\\d]*";
    private String N_ = "[1-9][\\d]*";
    private String birth = "([0-9]{1,2}/[0-9]{1,2}/[0-9]{4})|([0-9]{1,2}-[0-9]{1,2}-[0-9]{4})|([0-9]{1,2}+[\\.]+[0-9]{1,2}+[\\.]+[0-9]{4})";
    private String sex = "(Nam)|(nam)|(Nữ)|(nữ)|(NAM)|(NỮ)|(nu)|(NU)|(Nu)";
    private String name = "([a-zA-Z]|[\\s])*";
    private String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private String ID_NV = "^NV[\\d]{1,}";
    private String ID_KH = "^KH[\\d]{1,}";
    private String ID_NCC = "^NCC[\\d]{1,}";
    private String ID_HDN = "^HDN[\\d]{1,}";
    private String ID_HDX = "^HDX[\\d]{1,}";
    private String ID_QL = "^QL[\\d]{1,}";
    private String ID_SP = "^SP[\\d]{1,}";
    private String ID_ADMIN="^ADMIN[0-9]*";
    private String sdt ="^070[0-9]{7}|^079[0-9]{7}|^077{1}[0-9]{7}|^076[0-9]{7}|^078{1}[0-9]{7}|^090[0-9]{7}";
    private String DIACHI="^[0-9]{1,}[a-zA-Z]*[/0-9A-Za-z]*([a-zA-Z]|[\\s])*";
    public KT(){}
    
    public static boolean soN(String s){
        return Pattern.matches(N, s);
    }
    
    public boolean soZ(String s){
        if(Pattern.matches(Z, s)) return true;
        return false;
    }
    
    public boolean soR(String s){
        Pattern pa = Pattern.compile(R);
        if(Pattern.matches(R, s)) return true;
        return false;
    }
    
    public boolean soR_(String s){
        if(Pattern.matches(R_, s)) return true;
        return false;
    }
    
    public boolean soN_(String s){
        if(Pattern.matches(N_, s)) return true;
        return false;
    }
    
    public boolean soBirth(String s){
        if(Pattern.matches(birth, s)){
            String[] ss;
            if(s.indexOf('/') >= 0){
                ss = s.split("/");
            }
            else if(s.indexOf('-') >= 0){
                ss = s.split("-");
            }
            else{
                ss = s.split("\\.");
            }
            if(Integer.parseInt(ss[1])>12)
                return false;
            
            switch(Integer.parseInt(ss[1])){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:{
                    int day = Integer.parseInt(ss[0]);
                    if (day < 1 && day > 31) return false; 
                }
                case 4:
                case 6:
                case 9:
                case 11:{
                    int day = Integer.parseInt(ss[0]);
                    if (day < 0 && day > 30) return false;
                }
                case 2:{
                    int day = Integer.parseInt(ss[0]);
                    if(day <= 0 || day > 29) return false;
                    if(day <= 28) return true;
                    int year = Integer.parseInt(ss[2]);
                    if(year % 100 == 0 && year % 400 == 0 && day==29) return true;
                    if(year % 4 ==  0&& day==29) return true;
                    return false;
                }
            }
        }
        return false;
    }
//    public static String split(String s){
//        String chuoi =
//    }
    public static String chuanHoaDate(String s){
            String[] ss;
            if(s.indexOf('/') >= 0){
                ss = s.split("/");
            }
            else if(s.indexOf('-') >= 0){
                ss = s.split("-");
            }
            else{
                ss = s.split("\\.");
            }
            s=ss[0]+"/"+ss[1]+"/"+ss[2];
            
        return s;
    }
     
     public static boolean ngaytruocngay(String a, String b)
     {
         String[] aa,bb;
         if(a.indexOf('/') >= 0){
                aa = a.split("/");
            }
            else if(a.indexOf('-') >= 0){
                aa = a.split("-");
            }
            else{
                aa = a.split("\\.");
            }
         if(b.indexOf('/') >= 0){
                bb = b.split("/");
            }
            else if(b.indexOf('-') >= 0){
                bb = b.split("-");
            }
            else{
                bb = b.split("\\.");
            }
         int d1=Integer.parseInt(aa[0]);
         int m1=Integer.parseInt(aa[1]);
         int y1=Integer.parseInt(aa[2]);
         
         int d2=Integer.parseInt(bb[0]);
         int m2=Integer.parseInt(bb[1]);
         int y2=Integer.parseInt(bb[2]);
         if(y1<=y2)
             return true;
         else
             if(m1<=m2)
                 return true;
         else
                 if(d1<=d2)
                     return true;
         return false;
     }
    
    public int birthyear(String s){
        if(soBirth(s)){
            if(s.indexOf('/') > 0){
                String[] ss = s.split("/");
                return Integer.parseInt(ss[2].toString());
            }
            else if(s.indexOf("\\.") > 0){
                String[] ss = s.split("\\.");
                return Integer.parseInt(ss[2].toString());
            }
        }
        return 0;
    }
    
    public boolean ktsex(String s){
        return Pattern.matches(sex, s);
    }
    
    public boolean ktphone(String s){
        if(s.length() == 10 /*&& s.length() <= 11*/){
            if(s.charAt(0) == '0'){
                return Pattern.matches(sdt, s);
            }
        } 
        return false;
    }
        
    public static String ktname(String s){
        int i;
        for(i = 0; i < s.length(); i++) if(s.charAt(i) != ' ') break;
        s = s.substring(i);
        for(i = s.length()-1; i >= 0; --i) if(s.charAt(i) != ' ') break;
        s = s.substring(0, i+1);
        s = s.toUpperCase();
        return s;
    }
    
    public static boolean kt(String s)
    {
        String regex="^[a-zA-Z]*$";
        return s.matches(regex);
    }
    public static boolean ktemail(String s){
        String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return s.matches(email);
    }
    
    public String ktPass(String s){
        if(s.length() < 5) return "Mật khẩu phải hơn 5 kí tự!";
        int chuthuong = 0, so = 0, chuhoa = 0;
        int i = 0;
        for(i = 0; i < s.length(); i++){
            if((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57) so++;
            if((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 122) chuthuong++;
            if((int)s.charAt(i) >= 65 && (int)s.charAt(i) <= 90) chuhoa++;
        }
        if(so < 1) return "Mật khẩu phải chứa ít nhất 1 kí tự số!";
        if(chuhoa < 1 || chuthuong < 1) return "Mật khẩu phải chứa ít nhất 1 kí tự chữ hoa !";
        return s;
    }
    
    public boolean ktID_NV(String s){
        return Pattern.matches(ID_NV, s);
    }
    public boolean ktID_ADMIN(String s){
        return Pattern.matches(ID_ADMIN, s);
    }
    public boolean kt_name(String s){
        return Pattern.matches(name, s);
    }
    public boolean ktID_KH(String s){
        return Pattern.matches(ID_KH, s);
    }
    
    public boolean ktID_NCC(String s){
        return Pattern.matches(ID_NCC, s);
    }
    
    public boolean ktID_HDN(String s){
        return Pattern.matches(ID_HDN,s);
    }
    
    public boolean ktID_HDX(String s){
        return Pattern.matches(ID_HDX, s);
    }
    
    public boolean ktID_QL(String s){
        return Pattern.matches(ID_QL, s);
    }
    
    
    public boolean ktID_SP(String s){
        return Pattern.matches(ID_SP, s);
    }
    public boolean ktNGAY(String s){
        return Pattern.matches(birth, s);
    }
    
    public boolean ktDIACHI(String s){
        return Pattern.matches(DIACHI, s);
    }
    
    public static boolean kt_truocngayhientai(String s){
        String[] ss;
            if(s.indexOf('/') >= 0){
                ss = s.split("/");
            }
            else if(s.indexOf('-') >= 0){
                ss = s.split("-");
            }
            else{
                ss = s.split("\\.");
            }
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            month=month+1;
            int day = c.get(Calendar.DAY_OF_MONTH);
            int d=Integer.parseInt(ss[0]);
            int m=Integer.parseInt(ss[1]);
            int y=Integer.parseInt(ss[2]);
            if(y>year) return false;
            else if(y==year&&m>month)
                return false;
            else if(y==year&&m==month&&d>day)
                return false;
            return true;
    }
    

    public static void main(String[]agrs){
    Scanner inp=new Scanner(System.in);
        KT kt=new KT();
        String k;
        k=inp.nextLine();
        if(kt.kt_truocngayhientai(k))
        {
            System.out.println("true");
        }
        }
}