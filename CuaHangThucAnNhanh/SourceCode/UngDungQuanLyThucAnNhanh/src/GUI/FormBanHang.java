package GUI;

import BUS.ChiTietHD_BUS;
import BUS.ChiTietKM_BUS;
import BUS.ChiTietPhieuNhapBUS;
import BUS.HangNhapBUS;
import BUS.HoaDonBUS;
import BUS.KhachhangBUS;
import BUS.KhuyenMaiBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanvienBUS;
import BUS.PhieuNhapBUS;
import BUS.SanphamBUS;
import DAO.HangNhapDAO;
import DAO.HoaDonDAO;
import DAO.KhachhangDAO;
import DAO.NhanvienDAO;
import DAO.SanphamDAO;
import DTO.ChiTietHD_DTO;
import DTO.ChiTietKM_DTO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.HoaDonDTO;
import DTO.KhachhangDTO;
import DTO.NhanvienDTO;
import DTO.PhieuNhapDTO;
import DTO.SanphamDTO;
import DTO.NhaCungCapDTO;
import DTO.HangnhapDTO;
import DTO.KhuyenMaiDTO;

import com.toedter.calendar.JDateChooser;
import Kiemtra.KT;
import UTIL.General;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.NORMAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Cell;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;

public class FormBanHang extends JFrame {

    private JPanel pE, pW, pS, pN, pCT, pLogin, pHome, pNCC, pPN, pNV, pKH, pSP, pHD, pCTGG, pTK;
    private JLabel lbHome, lbNCC, lbPN, lbNV, lbKH, lbSP, lbHD, lbCTGG, lbTK;
    public String saochep="", saochepgia="";
    
    //phan tu tren NCC
    public JLabel lbIDNCC, lbTenNCC, lbSDTNCC, lbMailNCC, lbDiaChiNCC, lbTimNCC, lbDSNCC;
    public JTextField txtIDNCC, txtTenNCC, txtSDTNCC, txtMailNCC, txtDiaChiNCC, txtTimNCC;
    public JButton btnThemNCC, btnXoaNCC, btnSuaNCC, btnTimNCC, btnImportNCC, btnExportNCC, btnRefreshNCC,
            btnCopyIDNCC;
    public JTable tblNCC;

    //phan tu tren Phiếu nhập
    public JLabel lbIDPN, lbIDNVinPN, lbIDNCCinPN, lbTinhTrangPN, lbTongTienPN, lbNgayNhapPN, lbDSPN, lbTimPN, lbChiTietPN;
    public JTextField txtIDPN, txtIDNVinPN, txtIDNCCinPN, txtTinhTrangPN, txtTongTienPN, txtTimPN;
    public JDateChooser dateNgayNhapPN;
    public JButton btnThemPN, btnXoaPN, btnSuaPN, btnTimPN, btnImportPN, btnExportPN, btnRefreshPN, btnChiTietPN, btnTimNCCinPN, btnTimNVinPN;
    public JTable tblPN, tblChiTietPN;

    //phần tử trên sản phẩm
    public JLabel lbIDSP, lbTenSP, lbSoLuongSP, lbDonGiaSP, lbLoaiSP, lbDSSP, lbTimSP;
    public JTextField txtIDSP, txtTenSP, txtSoLuongSP, txtDonGiaSP, txtLoaiSP, txtTimSP;
    public JButton btnThemSP, btnXoaSP, btnSuaSP, btnTimSP, btnImportSP, btnExportSP,
            btnDocDLSP, btnXemLoaiSP, btnCopyIDSP;
    public JTable tblSP;

    //phần tử trên hóa đơn
    public JLabel lbIDHD, lbIDKHinHD, lbIDNVinHD, lbIDGGinHD, lbNgayLapHD, lbTongTienHD, lbTienGiamGiaHD,
            lbDSHD, lbChiTietHD, lbTimHD;
    public JTextField txtIDHD, txtIDKHinHD, txtIDNVinHD, txtIDGGinHD, txtTongTienHD,
            txtTienGiamGiaHD, txtTimHD;
    public JDateChooser dateNgayLapHD;
    public JButton btnThemHD, btnXoaHD, btnSuaHD, btnTimHD, btnImportHD, btnExportHD,
            btnDocDLHD, btnChiTietHD,btnTimIDKHinHD,btnTimIDNVinHD,btnTimIDGGinHD;
    public JTable tblHD, tblChiTietHD;
    public DefaultTableModel modelHD,modelCTHD;

    //Phần tử trên Chương trình giảm giá
    public JLabel lbIDGGtheoHD, lbTenGGtheoHD, lbTGBDGGtheoHD, lbTGKTGGtheoHD,
            lbNoiDungGGtheoHD, lbDKGGtheoHD, lbTimGGtheoHD, lbDSGGtheoHD;
    public JTextField txtIDGGtheoHD, txtTenGGtheoHD, txtNoiDungGGtheoHD, txtDKGGtheoHD,
            txtTimGGtheoHD;
    public JDateChooser dateTGBDGGtheoHD, dateTGKTGGtheoHD;
    public JButton btnThemGGtheoHD, btnXoaGGtheoHD, btnSuaGGtheoHD, btnTimGGtheoHD,
             btnImportGGtheoHD, btnExportGGtheoHD,btnDocDLGGtheoHD;
    public JTable tblGGtheoHD; 
    public JButton btnGGtheoHD, btnGGtheoSP;
    public DefaultTableModel modelGGtheoHD;
        //
    public JLabel lbIDGGtheoSP, lbTenGGtheoSP, lbTGBDGGtheoSP, lbTGKTGGtheoSP,
            lbNoiDungGGtheoSP, lbDKGGtheoSP, lbTimGGtheoSP, lbDSGGtheoSP, lbChiTietGGthepSP;
    public JTextField txtIDGGtheoSP, txtTenGGtheoSP, txtNoiDungGGtheoSP, txtDKGGtheoSP,
            txtTimGGtheoSP;
    public JDateChooser dateTGBDGGtheoSP, dateTGKTGGtheoSP;
    public JButton btnThemGGtheoSP, btnXoaGGtheoSP, btnSuaGGtheoSP, btnTimGGtheoSP,
             btnImportGGtheoSP, btnExportGGtheoSP,btnDocDLGGtheoSP, btnChiTietGGtheoSP,btnCopyIDGGtheoSP;
    public JTable tblGGtheoSP, tblChiTietGGtheoSP;
    public DefaultTableModel modelGGtheoSP, modelCTGGtheoSP;


    //Phần tử trên nhân viên
    public JLabel lbIDNV, lbHoNV, lbTenNV, lbSDTNV, lbMailNV, lbGioiTinhNV, lbChucVuNV,
            lbTimNV, lbDSNV;
    public JTextField txtIDNV, txtHoNV, txtTenNV, txtSDTNV, txtMailNV, txtGioiTinhNV,
            txtChucVuNV, txtTimNV;
    public JButton btnThemNV, btnXoaNV, btnSuaNV, btnTimNV, btnImportNV, btnExportNV,
            btnDocDLNV, btnChiTietNV, btnCopyIDNV;
    public JTable tblNV;

    //Phần tử trên khách hàng
    public JLabel lbIDKH, lbHoKH, lbTenKH, lbSDTKH, lbMailKH, lbGioiTinhKH, lbTongChiTieuKH,
            lbTimKH, lbDSKH;
    public JTextField txtIDKH, txtHoKH, txtTenKH, txtSDTKH, txtMailKH, txtGioiTinhKH,
            txtTongChiTieuKH, txtTimKH;
    public JButton btnThemKH, btnXoaKH, btnSuaKH, btnTimKH, btnImportKH, btnExportKH, btnDocDLKH
            , btnCopyIDKH;
    public JTable tblKH;

    //Phần tử trên thống kê
    public JLabel lbDSTKtheoHD, lbTKtimebegin, lbTKtimeend, lbTKnhaploai, lbTKnhapid;
    public JTextField txtTKtong1, txtTKtong2, txtTKtong3, txtTKnhapid;
    public JTextField dateTKbegintheoHD, dateTKendtheoHD;
    public JButton btnTKHoaDon, btnTKTongChi, btnTKSanpham, btnTKLoiNhuan, btnTKngay, btnTKthang, btnTKnam, 
            btnTKsum1, btnTKsum2, btnTKsum3, btnRefreshTK1;
    public JTable tblTKtheoHD, tblTKtheoTC;
    //
    public JLabel lbDSTKtheoTC, lbTKtimebeginTC, lbTKtimeendTC, lbTKnhaploaiTC, lbTKnhapidTC;
    public JTextField txtTKtong1TC, txtTKtong2TC, txtTKtong3TC, txtTKnhapid2;
    public JDateChooser dateTKbegintheoTC, dateTKendtheoTC;
    public JButton btnTKngayTC, btnTKthangTC, btnTKnamTC, btnTKsum1TC, btnTKsum2TC, btnTKsum3TC, btnRefreshTK2;

    public FormBanHang() 
    {
        login();       
//        nhacungcap();
//        quanlyhangnhap();
//        quanlysanpham();
//        quanlyhoadon();
//        chuongtrinhgiamgia();
//        quanlynhanvien();
//        quanlykhachhang();
//        quanlythongke();
        close();
    }

    private void login() {    //================================================================================LOGIN
        setSize(1200, 700);
        setTitle("Quản lý bán hàng");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(0, 0, 0));
        
        //không hiển thị hướng đông
        pE = new JPanel();
        pE.setBackground(Color.WHITE);
        pE.setPreferredSize(new Dimension(0, 0));
        pE.setLayout(null);

        //hướng tây
        pW = new JPanel();
        //pW.setBackground(new java.awt.Color(27, 94, 32));
        pW.setBackground(new java.awt.Color(51, 105, 30));
        pW.setPreferredSize(new Dimension(200, 0));
        pW.setLayout(null);

        //không hiện hướng nam// hiện form đăng nhập xong tắt
        pS = new JPanel();
        pS.setBackground(new java.awt.Color(67, 160, 71));
        pS.setPreferredSize(new Dimension(0, 660));
        pS.setLayout(null);

        //hướng bắc
        pN = new JPanel();
        pN.setBackground(new java.awt.Color(51, 105, 30));
        pN.setPreferredSize(new Dimension(0, 40));
        pN.setLayout(null);

        //center
        pCT = new JPanel();
        pCT.setBackground(Color.DARK_GRAY);
        pCT.setPreferredSize(new Dimension(1000, 700));
        pCT.setLayout(null);

        //chỉnh sửa thanh tiêu đề trên pN(hướng bắc)
        JButton btnExit = new JButton("");
        btnExit.setBackground(new java.awt.Color(51, 105, 30));
        btnExit.setBounds(1160, 0, 40, 40);
        btnExit.setBorder(null);
        btnExit.setFocusPainted(false);
        try {
            BufferedImage imgExit = ImageIO.read(new File("src/img/exit.png"));
            ImageIcon iconExit = new ImageIcon(imgExit.getScaledInstance(35, 35, imgExit.SCALE_SMOOTH));
            btnExit.setIcon(iconExit);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(new java.awt.Color(174, 234, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(new java.awt.Color(51, 105, 30));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                btnExit.setBackground(new java.awt.Color(67, 160, 71));
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        pN.add(btnExit);

        JButton btnLogout = new JButton("");
        btnLogout.setBackground(new java.awt.Color(51, 105, 30));
        btnLogout.setBounds(1120, 0, 40, 40);
        btnLogout.setBorder(null);
        btnLogout.setFocusPainted(false);
        try {
            BufferedImage imgLogout = ImageIO.read(new File("src/img/down.png"));
            ImageIcon iconLogout = new ImageIcon(imgLogout.getScaledInstance(40, 40, imgLogout.SCALE_SMOOTH));
            btnLogout.setIcon(iconLogout);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogout.setBackground(new java.awt.Color(174, 234, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogout.setBackground(new java.awt.Color(51, 105, 30));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                btnLogout.setBackground(new java.awt.Color(67, 160, 71));
                pS.setVisible(true);
                pCT.setVisible(false);
                pW.setVisible(false);
                setVisible(false);
                FormBanHang newform = new FormBanHang();
            }
        });
        pN.add(btnLogout);

        JLabel lbLogo = new JLabel("QUẢN LÝ CỬA HÀNG THỨC ĂN NHANH");
        lbLogo.setBounds(10, 0, 400, 40);
        lbLogo.setForeground(new java.awt.Color(255, 255, 255));
        lbLogo.setFont(new Font("Arial", Font.BOLD, 15));
        pN.add(lbLogo);
        try {
            BufferedImage imgLogo = ImageIO.read(new File("src/img/hamburger.png"));
            ImageIcon iconLogo = new ImageIcon(imgLogo.getScaledInstance(35, 35, imgLogo.SCALE_SMOOTH));
            lbLogo.setIcon(iconLogo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //panel Log in start
        pLogin = new JPanel();
        pLogin.setLayout(null);
        pLogin.setBackground(new java.awt.Color(255, 255, 255));
        pLogin.setBounds(380, 280, 440, 200);
        pS.add(pLogin);
        pLogin.setVisible(true);

        JLabel lbLogoImg = new JLabel("", JLabel.CENTER);
        try {
            BufferedImage imgLogo = ImageIO.read(new File("src/img/logo.png"));
            ImageIcon iconLogo = new ImageIcon(imgLogo.getScaledInstance(400, 300, imgLogo.SCALE_SMOOTH));
            lbLogoImg.setIcon(iconLogo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        lbLogoImg.setBounds(0, 30, 1200, 200);
        pS.add(lbLogoImg);

        JLabel lbHeaderLogin = new JLabel("LOG IN", JLabel.CENTER);
        lbHeaderLogin.setForeground(new java.awt.Color(51, 105, 30));
        lbHeaderLogin.setFont(new Font("Arial", Font.BOLD, 24));
        lbHeaderLogin.setBounds(0, 10, 440, 40);
        lbHeaderLogin.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 105, 30)));

        JLabel lbUsernameLogin = new JLabel("Username", JLabel.LEFT);
        lbUsernameLogin.setBounds(60, 70, 80, 30);
        JLabel lbPasswordLogin = new JLabel("Password", JLabel.LEFT);
        lbPasswordLogin.setBounds(60, 110, 80, 30);

        JTextField txtUsernameLogin = new JTextField("", 20);
        txtUsernameLogin.setBounds(140, 70, 240, 30);
        txtUsernameLogin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        JPasswordField txtPasswordLogin = new JPasswordField("", 20);
        txtPasswordLogin.setBounds(140, 110, 240, 30);
        txtPasswordLogin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));

        JButton btnAccessLogin = new JButton("Login");
        btnAccessLogin.setBorder(null);
        btnAccessLogin.setBorderPainted(false);
        btnAccessLogin.setBounds(280, 150, 100, 30);
        btnAccessLogin.setBackground(new java.awt.Color(174, 234, 0));
        btnAccessLogin.addActionListener(new ActionListener() //Nút đăng nhập
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String username = txtUsernameLogin.getText();
                String password = txtPasswordLogin.getText();
                NhanvienBUS bus=new NhanvienBUS();
                try {
                    boolean isLoggedIn = bus.Login(username, password);
                    if(isLoggedIn){
                        pS.setVisible(false);
                        pCT.setVisible(true);
                        pW.setVisible(true);  
                        home();
                        nhacungcap();
                        quanlyhangnhap();
                        quanlysanpham();
                        quanlyhoadon();
                        chuongtrinhgiamgia();
                        quanlynhanvien();
                        quanlykhachhang();
                        quanlythongke();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Sai Email hoặc password !");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        btnAccessLogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAccessLogin.setBackground(new java.awt.Color(118, 255, 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAccessLogin.setBackground(new java.awt.Color(174, 234, 0));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                btnAccessLogin.setBackground(new java.awt.Color(67, 160, 71));
                pS.setVisible(false);
                pCT.setVisible(true);
                pW.setVisible(true);
            }
        });
        JButton btnCancelLogin = new JButton("Cancel");
        btnCancelLogin.setBorder(null);
        btnCancelLogin.setBorderPainted(false);
        btnCancelLogin.setBounds(170, 150, 100, 30);
        btnCancelLogin.setBackground(new java.awt.Color(239, 83, 80));

        pLogin.add(lbHeaderLogin);
        pLogin.add(lbUsernameLogin);
        pLogin.add(lbPasswordLogin);
        pLogin.add(txtUsernameLogin);
        pLogin.add(txtPasswordLogin);
        pLogin.add(btnAccessLogin);
        pLogin.add(btnCancelLogin);       
        //panel Log in end
    }

    private void home() {    //=================================================================================HOME
        //Home
        lbHome = new JLabel("   Người dùng hiện tại", JLabel.LEFT);
        lbHome.setOpaque(true);
        lbHome.setBounds(0, 0, 200, 50);
        lbHome.setBackground(new java.awt.Color(67, 160, 71));
        lbHome.setForeground(Color.WHITE);
        lbHome.setFont(new Font("Arial", NORMAL, 14));
        lbHome.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));

        try {
            BufferedImage imgHome = ImageIO.read(new File("src/img/home.png"));
            ImageIcon iconHome = new ImageIcon(imgHome.getScaledInstance(25, 25, imgHome.SCALE_SMOOTH));
            lbHome.setIcon(iconHome);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        lbHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbHome.setBackground(new java.awt.Color(129, 199, 132));
                lbHome.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbHome.setBackground(new java.awt.Color(67, 160, 71));
                lbHome.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(true);
                pNCC.setVisible(false);
                pPN.setVisible(false);
                pNV.setVisible(false);
                pKH.setVisible(false);
                pSP.setVisible(false);
                pHD.setVisible(false);
                pCTGG.setVisible(false);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbNCC.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        //panel Home Start
        pHome = new JPanel();
        pHome.setLayout(null);
        pHome.setBackground(Color.WHITE);
        pHome.setBounds(0, 0, 1000, 660);
        pCT.add(pHome);
        pHome.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pHome.setVisible(true);

        JLabel lbLogoInHome, lbHeaderHome, lbIDInHome, lbPasswordInHome, lbHoNVInHome, lbTenNVInHome,
                lbSDTNVInHome, lbMailNVInHome, lbGTNVInHome, lbChucVuNVInHome;
        JTextField txtIDInHome, txtHoNVInHome, txtTenNVInHome, txtSDTNVInHome,
                txtMailNVInHome, txtGTNVInHome, txtChucVuNVInHome, txtPasswordInHome;
        //JPasswordField txtPasswordInHome;
        JButton btnChangeInfo;

        lbLogoInHome = new JLabel("", JLabel.CENTER);
        lbLogoInHome.setBounds(0, 20, 1000, 150);
        try {
            BufferedImage imgLogoInHome = ImageIO.read(new File("src/img/logo2.png"));
            ImageIcon iconLogoInHome = new ImageIcon(imgLogoInHome.getScaledInstance(250, 150, imgLogoInHome.SCALE_SMOOTH));
            lbLogoInHome.setIcon(iconLogoInHome);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        pHome.add(lbLogoInHome);

        JPanel pInfoHome = new JPanel();
        pInfoHome.setBounds(100, 170, 800, 400);
        pInfoHome.setBackground(new java.awt.Color(51, 105, 30));
        pInfoHome.setLayout(null);

        lbHeaderHome = new JLabel("THÔNG TIN TÀI KHOẢN HIỆN TẠI", JLabel.CENTER);
        lbHeaderHome.setBounds(0, 10, 800, 50);
        lbHeaderHome.setFont(new Font("Arial", Font.BOLD, 20));
        lbHeaderHome.setForeground(Color.WHITE);
        lbHeaderHome.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        pInfoHome.add(lbHeaderHome);

        lbIDInHome = new JLabel("Username (ID)", JLabel.LEFT);
        lbIDInHome.setBounds(50, 90, 120, 25);
        lbIDInHome.setForeground(Color.WHITE);
        lbIDInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbIDInHome);

        lbPasswordInHome = new JLabel("Password", JLabel.LEFT);
        lbPasswordInHome.setBounds(50, 140, 120, 25);
        lbPasswordInHome.setForeground(Color.WHITE);
        lbPasswordInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbPasswordInHome);

        lbHoNVInHome = new JLabel("Họ", JLabel.LEFT);
        lbHoNVInHome.setBounds(50, 190, 120, 25);
        lbHoNVInHome.setForeground(Color.WHITE);
        lbHoNVInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbHoNVInHome);

        lbTenNVInHome = new JLabel("Tên", JLabel.LEFT);
        lbTenNVInHome.setBounds(480, 190, 80, 25);
        lbTenNVInHome.setForeground(Color.WHITE);
        lbTenNVInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbTenNVInHome);

        lbSDTNVInHome = new JLabel("Số điện thoại", JLabel.LEFT);
        lbSDTNVInHome.setBounds(50, 240, 120, 25);
        lbSDTNVInHome.setForeground(Color.WHITE);
        lbSDTNVInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbSDTNVInHome);

        lbMailNVInHome = new JLabel("Mail", JLabel.LEFT);
        lbMailNVInHome.setBounds(50, 290, 120, 25);
        lbMailNVInHome.setForeground(Color.WHITE);
        lbMailNVInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbMailNVInHome);

        lbGTNVInHome = new JLabel("Giới tính", JLabel.LEFT);
        lbGTNVInHome.setBounds(50, 340, 120, 25);
        lbGTNVInHome.setForeground(Color.WHITE);
        lbGTNVInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbGTNVInHome);

        lbChucVuNVInHome = new JLabel("Chức vụ", JLabel.LEFT);
        lbChucVuNVInHome.setBounds(480, 340, 80, 25);
        lbChucVuNVInHome.setForeground(Color.WHITE);
        lbChucVuNVInHome.setFont(new Font("Arial", NORMAL, 15));
        pInfoHome.add(lbChucVuNVInHome);

        txtIDInHome = new JTextField("", 20);
        txtIDInHome.setBounds(170, 90, 225, 25);
        txtIDInHome.setBorder(null);
        txtIDInHome.setEditable(false);
        pInfoHome.add(txtIDInHome);

        txtPasswordInHome = new JPasswordField("", 20);
        txtPasswordInHome.setBounds(170, 140, 225, 25);
        txtPasswordInHome.setBorder(null);
        pInfoHome.add(txtPasswordInHome);

        txtHoNVInHome = new JTextField("", 20);
        txtHoNVInHome.setBounds(170, 190, 225, 25);
        txtHoNVInHome.setBorder(null);
        pInfoHome.add(txtHoNVInHome);

        txtTenNVInHome = new JTextField("", 20);
        txtTenNVInHome.setBounds(550, 190, 200, 25);
        txtTenNVInHome.setBorder(null);
        pInfoHome.add(txtTenNVInHome);

        txtSDTNVInHome = new JTextField("", 20);
        txtSDTNVInHome.setBounds(170, 240, 225, 25);
        txtSDTNVInHome.setBorder(null);
        pInfoHome.add(txtSDTNVInHome);

        txtMailNVInHome = new JTextField("", 20);
        txtMailNVInHome.setBounds(170, 290, 225, 25);
        txtMailNVInHome.setBorder(null);
        pInfoHome.add(txtMailNVInHome);

        txtGTNVInHome = new JTextField("", 20);
        txtGTNVInHome.setBounds(170, 340, 225, 25);
        txtGTNVInHome.setBorder(null);
        pInfoHome.add(txtGTNVInHome);

        txtChucVuNVInHome = new JTextField("", 20);
        txtChucVuNVInHome.setBounds(550, 340, 200, 25);
        txtChucVuNVInHome.setBorder(null);
        pInfoHome.add(txtChucVuNVInHome);      
        
        //Đỗ dữ liệu của người đăng nhập lên============================================
        NhanvienDTO nv_dto = new NhanvienDTO();
        try {
            NhanvienBUS bus = new NhanvienBUS();
            nv_dto = bus.LayThongTinNVTheoMail(General.CURRENT_USER);
        } catch (Exception ex) {
            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtIDInHome.setText(nv_dto.getId());
        txtPasswordInHome.setText(nv_dto.getPassword());
        txtHoNVInHome.setText(nv_dto.getHo());
        txtTenNVInHome.setText(nv_dto.getTen());
        txtSDTNVInHome.setText(nv_dto.getSdt());
        txtMailNVInHome.setText(nv_dto.getMail());
        txtGTNVInHome.setText(nv_dto.getGioitinh());
        txtChucVuNVInHome.setText(nv_dto.getChucvu());
        
        btnChangeInfo = new JButton("Cập nhật");
        btnChangeInfo.setBounds(780, 600, 120, 30);
        btnChangeInfo.setBorder(null);
        btnChangeInfo.setBackground(new java.awt.Color(51, 105, 30));
        btnChangeInfo.setForeground(Color.WHITE);
        btnChangeInfo.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int i = tblNV.getSelectedRow();
                //===== Check xem có hợp lệ =====//
                    //Check họ
                    if (KT.soN(txtHoNVInHome.getText()) == true) {
                        JOptionPane.showMessageDialog(null, "Họ phải là chữ !");
                        return;
                    }
                    //Check tên
                    if (KT.soN(txtTenNVInHome.getText()) == true) {
                        JOptionPane.showMessageDialog(null, "Tên phải là chữ !");
                        return;
                    }
                    //Check số điện thoại
                    if (KT.soN(txtSDTNVInHome.getText()) == false || txtSDTNVInHome.getText().length() != 10) {
                        JOptionPane.showMessageDialog(null, "SĐT phải là số và bằng 10 số");
                        return;
                    }
                    //Check mail
                    if (KT.ktemail(txtMailNVInHome.getText()) == false) {
                        JOptionPane.showMessageDialog(null, "Mail không hợp lệ");
                        return;
                    }
                    //Check giới tính
                    if (KT.soN(txtGTNVInHome.getText()) == true || txtGTNVInHome.getText().length() > 4) {
                        JOptionPane.showMessageDialog(null, "Giới tính phải là chữ và ít hơn hoặc bằng 3 từ");
                        return;
                    }
                    //Check chức vụ
                    if (KT.soN(txtTenNVInHome.getText()) == true) {
                        JOptionPane.showMessageDialog(null, "Chức vụ phải là chữ !");
                        return;
                    }
                    NhanvienDTO nv_dto = new NhanvienDTO();
                    nv_dto.setId(txtIDInHome.getText());
                    nv_dto.setHo(txtHoNVInHome.getText());
                    nv_dto.setTen(txtTenNVInHome.getText());
                    nv_dto.setSdt(txtSDTNVInHome.getText());
                    nv_dto.setMail(txtMailNVInHome.getText());
                    nv_dto.setGioitinh(txtGTNVInHome.getText());
                    nv_dto.setChucvu(txtChucVuNVInHome.getText());
                    nv_dto.setPassword(txtPasswordInHome.getText());
                    NhanvienBUS bus = new NhanvienBUS();
                    try {
                        bus.Update2(nv_dto);
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công !");
                    } catch (Exception ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        });
        pHome.add(btnChangeInfo);

        pHome.add(pInfoHome);
        // add danh mục chức năng vào hướng tây      
        pW.add(lbHome);
    }

    private void nhacungcap() {   //=============================================================================NCC
        //các chức năng
        //1.nhà cung cấp
        lbNCC = new JLabel("   Nhà cung cấp", JLabel.LEFT);
        lbNCC.setOpaque(true);
        lbNCC.setBounds(0, 50, 200, 50);
        lbNCC.setBackground(new java.awt.Color(67, 160, 71));
        lbNCC.setForeground(Color.WHITE);
        lbNCC.setFont(new Font("Arial", NORMAL, 14));
        lbNCC.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));   
        try {
            BufferedImage imgNCC = ImageIO.read(new File("src/img/NCC.png"));
            ImageIcon iconNCC = new ImageIcon(imgNCC.getScaledInstance(25, 25, imgNCC.SCALE_SMOOTH));
            lbNCC.setIcon(iconNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        pW.add(lbNCC);
      
        lbNCC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbNCC.setBackground(new java.awt.Color(129, 199, 132));
                lbNCC.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbNCC.setBackground(new java.awt.Color(67, 160, 71));
                lbNCC.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(true);
                pPN.setVisible(false);
                pNV.setVisible(false);
                pKH.setVisible(false);
                pSP.setVisible(false);
                pHD.setVisible(false);
                pCTGG.setVisible(false);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbPN.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        //panel nhà cung cấp start
        pNCC = new JPanel();
        pNCC.setLayout(null);
        pNCC.setBackground(Color.WHITE);
        pNCC.setBounds(0, 0, 1000, 660);
        pCT.add(pNCC);
        pNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pNCC.setVisible(false);

//        JLabel lbIDNCC, lbTenNCC, lbSDTNCC, lbMailNCC, lbDiaChiNCC, lbTimNCC, lbDSNCC;
        lbIDNCC = new JLabel("ID nhà cung cấp");
        lbTenNCC = new JLabel("Tên nhà cung cấp");
        lbSDTNCC = new JLabel("SĐT nhà cung cấp");
        lbMailNCC = new JLabel("Mail nhà cung cấp");
        lbDiaChiNCC = new JLabel("ĐC nhà cung cấp");
        lbTimNCC = new JLabel("Tìm");
        lbDSNCC = new JLabel("DANH SÁCH NHÀ CUNG CẤP");

        lbIDNCC.setBounds(20, 20, 120, 30);
        lbTenNCC.setBounds(20, 70, 120, 30);
        lbSDTNCC.setBounds(20, 120, 120, 30);
        lbMailNCC.setBounds(20, 170, 120, 30);
        lbDiaChiNCC.setBounds(460, 20, 120, 30);
        lbTimNCC.setBounds(460, 70, 30, 30);
        lbDSNCC.setBounds(20, 220, 400, 30);
        lbDSNCC.setForeground(new java.awt.Color(51, 105, 30));
        lbDSNCC.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromNCC[] = {"ID", "Tên", "Mail", "SĐT", "Địa chỉ"};
        JComboBox cbNCC = new JComboBox(findfromNCC);
        cbNCC.setBounds(490, 70, 90, 30);
        cbNCC.setBorder(null);
        cbNCC.setBackground(new java.awt.Color(128, 222, 234));
        cbNCC.setForeground(Color.WHITE);
        pNCC.add(cbNCC);

//        JTextField txtIDNCC, txtTenNCC, txtSDTNCC, txtMailNCC, txtDiaChiNCC, txtTimNCC;
        txtIDNCC = new JTextField("", 20);
        txtIDNCC.setEditable(false); //khong cho chinh sua ID
        txtTenNCC = new JTextField("", 20);
        txtSDTNCC = new JTextField("", 20);
        txtMailNCC = new JTextField("", 20);
        txtDiaChiNCC = new JTextField("", 20);
        txtTimNCC = new JTextField("", 30);

        txtIDNCC.setBounds(150, 20, 220, 30);
        txtTenNCC.setBounds(150, 70, 220, 30);
        txtSDTNCC.setBounds(150, 120, 220, 30);
        txtMailNCC.setBounds(150, 170, 220, 30);
        txtDiaChiNCC.setBounds(590, 20, 220, 30);
        txtTimNCC.setBounds(590, 70, 220, 30);

//        JButton btnThemNCC, btnXoaNCC, btnSuaNCC, btnTimNCC, btnImportNCC, btnExportNCC, btnRefreshNCC;
        btnThemNCC = new JButton("Thêm");
        btnThemNCC.setBackground(new java.awt.Color(174, 234, 0));
        btnThemNCC.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemNCC.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnXoaNCC = new JButton("Xóa");
        btnXoaNCC.setBackground(new java.awt.Color(255, 82, 82));
        btnXoaNCC.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaNCC.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnSuaNCC = new JButton("Sửa");
        btnSuaNCC.setBackground(new java.awt.Color(238, 255, 65));
        btnSuaNCC.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaNCC.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnTimNCC = new JButton("Tìm");
        btnTimNCC.setBackground(new java.awt.Color(128, 222, 234));
        btnTimNCC.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimNCC.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnRefreshNCC = new JButton("Tải lại");
        btnRefreshNCC.setBackground(new java.awt.Color(178, 255, 89));
        btnRefreshNCC.setBorder(null);

        btnImportNCC = new JButton("Import");
        btnImportNCC.setBackground(new java.awt.Color(174, 234, 0));
        btnImportNCC.setBorder(null);

        btnExportNCC = new JButton("Export");
        btnExportNCC.setBackground(new java.awt.Color(178, 255, 89));
        btnExportNCC.setBorder(null);
        btnExportNCC.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                XSSFWorkbook workbook=new XSSFWorkbook();
                XSSFSheet sheet=workbook.createSheet("NhaCungCap");
                
                XSSFRow row=null;
                XSSFCell cell =null;
                
                row =sheet.createRow(0);
                
                cell=row.createCell(0);
                cell.setCellValue("id_ncc");                
                cell=row.createCell(1);
                cell.setCellValue("ten_ncc");               
                cell=row.createCell(2);
                cell.setCellValue("sdt_ncc");               
                cell=row.createCell(3);
                cell.setCellValue("mail_ncc");               
                cell=row.createCell(4);
                cell.setCellValue("diachi_ncc");
                
                if(NhaCungCapBUS.dsNCC != null)
                {
                    int x = NhaCungCapBUS.dsNCC.size();
                    for (int i = 0; i < x; i++) 
                    {
                        NhaCungCapDTO ncc_dto = NhaCungCapBUS.dsNCC.get(i);
                        
                        row = sheet.createRow(2 + i);
                        
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(ncc_dto.getID());                        
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(ncc_dto.getTen());                        
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(ncc_dto.getSDT());                        
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue(ncc_dto.getMail());
                        cell = row.createCell(4, CellType.STRING);
                        cell.setCellValue(ncc_dto.getDiaChi());
                    }
                    File f = new File("../DoAnJavaTommorrow/Nhacungcap.xlsx");
                    FileOutputStream fos = null;
                    try {
                         fos = new FileOutputStream(f);
                        workbook.write(fos);
                        JOptionPane.showMessageDialog(null, "In danh sách nhà cung cấp thành công !");
                        fos.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        btnCopyIDNCC = new JButton("Chép ID");
        btnCopyIDNCC.setBackground(new java.awt.Color(174, 234, 0));
        btnCopyIDNCC.setBorder(null);

        btnThemNCC.setBounds(880, 20, 100, 30);
        btnSuaNCC.setBounds(880, 120, 100, 30);
        btnXoaNCC.setBounds(880, 170, 100, 30);
        btnTimNCC.setBounds(880, 70, 100, 30);
        btnRefreshNCC.setBounds(680, 220, 100, 30);
        btnImportNCC.setBounds(780, 220, 100, 30);
        btnExportNCC.setBounds(880, 220, 100, 30);
        btnCopyIDNCC.setBounds(270, 220, 100, 30);

        String[] columnNCC
                = {"ID", "Tên", "Số điện thoại", "Mail", "Địa chỉ"};
        Object[][] dataNCC = {};

        ArrayList<NhaCungCapDTO> dsNCC = new ArrayList<NhaCungCapDTO>();
        DefaultTableModel modelNCC = new DefaultTableModel(dataNCC, columnNCC);

        tblNCC = new JTable(modelNCC) 
        {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        TableRowSorter<TableModel> rowSorterNCC = new TableRowSorter<TableModel>(modelNCC);
        tblNCC.setRowSorter(rowSorterNCC);
        tblNCC.setBackground(Color.WHITE);
        tblNCC.setForeground(Color.BLACK);
        tblNCC.setRowHeight(25);
        tblNCC.setFont(new Font("Arial", NORMAL, 12));
        tblNCC.setBorder(null);
        tblNCC.setShowVerticalLines(false);
        tblNCC.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblNCC.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollNCC = new JScrollPane(tblNCC);
        scrollNCC.setBounds(20, 260, 960, 385);
        pNCC.add(scrollNCC);

        tblNCC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblNCC.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblNCC.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblNCC.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblNCC.getColumnModel().getColumn(3).setPreferredWidth(250);
        tblNCC.getColumnModel().getColumn(4).setPreferredWidth(400);

        JTableHeader headerNCC = tblNCC.getTableHeader();
        headerNCC.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblNCC.getTableHeader().setForeground(Color.WHITE);
        tblNCC.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblNCC.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        //=>bỏ viền header table
        pNCC.add(lbIDNCC);
        pNCC.add(lbTenNCC);
        pNCC.add(lbSDTNCC);
        pNCC.add(lbMailNCC);
        pNCC.add(lbDiaChiNCC);
        pNCC.add(lbTimNCC);
        pNCC.add(lbDSNCC);

        pNCC.add(txtIDNCC);
        pNCC.add(txtTenNCC);
        pNCC.add(txtSDTNCC);
        pNCC.add(txtMailNCC);
        pNCC.add(txtDiaChiNCC);
        pNCC.add(txtTimNCC);

        pNCC.add(btnThemNCC);
        pNCC.add(btnSuaNCC);
        pNCC.add(btnXoaNCC);
        pNCC.add(btnTimNCC);
        pNCC.add(btnRefreshNCC);
        pNCC.add(btnImportNCC);
        pNCC.add(btnExportNCC);
        pNCC.add(btnCopyIDNCC);

        //bắt sự kiện
        tblNCC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int i = tblNCC.getSelectedRow();
                if (i >= 0) {
                    txtIDNCC.setText(tblNCC.getModel().getValueAt(i, 0).toString());
                    txtTenNCC.setText(tblNCC.getModel().getValueAt(i, 1).toString());
                    txtSDTNCC.setText(tblNCC.getModel().getValueAt(i, 2).toString());
                    txtMailNCC.setText(tblNCC.getModel().getValueAt(i, 3).toString());
                    txtDiaChiNCC.setText(tblNCC.getModel().getValueAt(i, 4).toString());
                }
            }
        });
        //tim kiem nang cao idncc
        tblNCC.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                btnCopyIDNCC.addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        int i = tblNCC.getSelectedRow();
                        if (i >= 0) {
                            txtIDNCCinPN.setText(tblNCC.getModel().getValueAt(i, 0).toString());
                            pNCC.setVisible(false);
                            pPN.setVisible(true);
                            lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                            lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                            lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbSP.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                            lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                        }
                    }
                });
            }
        });

        NhaCungCapBUS bus = new NhaCungCapBUS();
        bus.docDSNCC();
        for (NhaCungCapDTO ncc : NhaCungCapBUS.dsNCC) {
            Vector row = new Vector();
            //nếu tình trạng bằng 1 (active) thì sẽ đổ lên table
            //không đổ cột tình trạng lên table
            if (ncc.getTinhTrang() == 1) {
                row.add(ncc.getID());
                row.add(ncc.getTen());
                row.add(ncc.getSDT());
                row.add(ncc.getMail());
                row.add(ncc.getDiaChi());
                modelNCC.addRow(row);
            }
        }
        tblNCC.setModel(modelNCC);

        btnRefreshNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTenNCC.setText("");
                txtSDTNCC.setText("");
                txtMailNCC.setText("");
                txtDiaChiNCC.setText("");
                txtIDNCC.setText("");
                txtTimNCC.setText("");
                cbNCC.setSelectedIndex(0);
                modelNCC.setRowCount(0);

                NhaCungCapBUS bus = new NhaCungCapBUS();
                bus.docDSNCC();
                for (NhaCungCapDTO ncc : NhaCungCapBUS.dsNCC) {
                    Vector row = new Vector();
                    if (ncc.getTinhTrang() == 1) {
                        row.add(ncc.getID());
                        row.add(ncc.getTen());
                        row.add(ncc.getSDT());
                        row.add(ncc.getMail());
                        row.add(ncc.getDiaChi());
                        modelNCC.addRow(row);
                    }
                }
                tblNCC.setModel(modelNCC);
            }
        });

        btnThemNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                KT kiem = new KT();

                if (kiem.ktphone(txtSDTNCC.getText()) == false || kiem.soN(txtSDTNCC.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Số điện thoại phải bằng 10 số "
                            + "và bắt đầu bằng số 0");
                } else {
                    //cho id tự tăng trong bảng
                    int temp = 0;
                    for (NhaCungCapDTO ncc2 : NhaCungCapBUS.dsNCC) {
                        temp = ncc2.getID();
                    }
                    ncc.id = temp + 1;
                    ncc.ten = txtTenNCC.getText();
                    ncc.sdt = txtSDTNCC.getText();
                    ncc.mail = txtMailNCC.getText();
                    ncc.dc = txtDiaChiNCC.getText();
                    ncc.tinhtrang = 1;
                    NhaCungCapBUS bus = new NhaCungCapBUS();
                    try {
                        bus.them(ncc);
                    } catch (Exception ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Vector row = new Vector();
                    row.add(ncc.id);
                    row.add(ncc.ten);
                    row.add(ncc.sdt);
                    row.add(ncc.mail);
                    row.add(ncc.dc);
                    row.add(ncc.tinhtrang);

                    modelNCC.addRow(row);
                    tblNCC.setModel(modelNCC);
                    JOptionPane.showMessageDialog(null, "Thêm NCC thành công!!");
                }
            }

        }
        );
        btnSuaNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblNCC.getSelectedRow();
                if (i >= 0) {
                    NhaCungCapDTO ncc = new NhaCungCapDTO();
                    ncc.id = Integer.parseInt(txtIDNCC.getText());
                    ncc.ten = txtTenNCC.getText();
                    ncc.sdt = txtSDTNCC.getText();
                    ncc.mail = txtMailNCC.getText();
                    ncc.dc = txtDiaChiNCC.getText();

                    NhaCungCapBUS bus = new NhaCungCapBUS();
                    try {
                        bus.sua(ncc);
                    } catch (Exception ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    modelNCC.setValueAt(txtIDNCC.getText(), i, 0);
                    modelNCC.setValueAt(txtTenNCC.getText(), i, 1);
                    modelNCC.setValueAt(txtSDTNCC.getText(), i, 2);
                    modelNCC.setValueAt(txtMailNCC.getText(), i, 3);
                    modelNCC.setValueAt(txtDiaChiNCC.getText(), i, 4);

                    tblNCC.setModel(modelNCC);
                    JOptionPane.showMessageDialog(null, "Cập nhật NCC thành công!!");
                }
            }

        });
        btnXoaNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblNCC.getSelectedRow();
                if (i >= 0) {
                    NhaCungCapDTO ncc = new NhaCungCapDTO();
                    ncc.id = Integer.parseInt(txtIDNCC.getText());
                    ncc.tinhtrang = 0;
                    NhaCungCapBUS bus = new NhaCungCapBUS();
                    try {
                        bus.xoa(ncc);
                    } catch (Exception ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi!!");
                    }

                    //cập nhật lại bảng ngay sau khi xóa
                    modelNCC.setRowCount(0);
                    NhaCungCapBUS bus2 = new NhaCungCapBUS();
                    bus.docDSNCC();
                    for (NhaCungCapDTO ncc2 : NhaCungCapBUS.dsNCC) {
                        Vector row = new Vector();
                        if (ncc2.getTinhTrang() == 1) {
                            row.add(ncc2.getID());
                            row.add(ncc2.getTen());
                            row.add(ncc2.getSDT());
                            row.add(ncc2.getMail());
                            row.add(ncc2.getDiaChi());
                            modelNCC.addRow(row);
                        }
                    }
                    tblNCC.setModel(modelNCC);
                    JOptionPane.showMessageDialog(null, "Đã xóa NCC!!");
                }
            }
        });
        btnTimNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = cbNCC.getSelectedItem().toString();
                String text = txtTimNCC.getText();
                //nếu textfield tìm kiễm rỗng sẽ hiện tất cả
                if (text.trim().length() == 0) {
                    rowSorterNCC.setRowFilter(null);
                    modelNCC.setRowCount(0);
                    for (NhaCungCapDTO ncc : NhaCungCapBUS.dsNCC) {
                        Vector row = new Vector();
                        if (ncc.getTinhTrang() == 1) {
                            //chỉ hiện tình trạng =1
                            row.add(ncc.getID());
                            row.add(ncc.getTen());
                            row.add(ncc.getSDT());
                            row.add(ncc.getMail());
                            row.add(ncc.getDiaChi());
                            row.add(ncc.getTinhTrang());
                            modelNCC.addRow(row);
                        }
                    }
                    tblNCC.setModel(modelNCC);
                } else {
                    switch (option) {
                        case "ID":
                            try {
                            NhaCungCapDTO ncc = new NhaCungCapDTO();
                            NhaCungCapBUS bus = new NhaCungCapBUS();
                            try {
                                int temp = Integer.parseInt(txtTimNCC.getText());
                                int temp1 = 0; //temp1 là id lớn nhất của phiếu nhập
                                for (NhaCungCapDTO ncc2 : NhaCungCapBUS.dsNCC) {
                                    temp1 = ncc2.getID();
                                }
                                if (temp1 < temp || temp <= 0) {
                                    JOptionPane.showMessageDialog(null, "Không tồn tại NCC này!!");
                                    modelNCC.setRowCount(0);
                                } else {
                                    ncc = bus.timID(temp);
                                    modelNCC.setRowCount(0);
                                    Vector row = new Vector();
                                    if (ncc.getTinhTrang() == 1) {
                                        row.add(ncc.getID());
                                        row.add(ncc.getTen());
                                        row.add(ncc.getSDT());
                                        row.add(ncc.getMail());
                                        row.add(ncc.getDiaChi());
                                        row.add(ncc.getTinhTrang());
                                        modelNCC.addRow(row);
                                    }
                                    tblNCC.setModel(modelNCC);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "Tên":
                            try {
                            ArrayList<NhaCungCapDTO> kqncc = new ArrayList<NhaCungCapDTO>();
                            NhaCungCapBUS bus = new NhaCungCapBUS();
                            try {
                                kqncc = bus.timTen(txtTimNCC.getText().toLowerCase());
                                modelNCC.setRowCount(0);
                                for (NhaCungCapDTO ncc : kqncc) {
                                    Vector row = new Vector();
                                    if (ncc.getTinhTrang() == 1) {
                                        row.add(ncc.getID());
                                        row.add(ncc.getTen());
                                        row.add(ncc.getSDT());
                                        row.add(ncc.getMail());
                                        row.add(ncc.getDiaChi());
                                        row.add(ncc.getTinhTrang());
                                        modelNCC.addRow(row);
                                    }
                                    tblNCC.setModel(modelNCC);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "SĐT":
                            try {
                            ArrayList<NhaCungCapDTO> kqncc = new ArrayList<NhaCungCapDTO>();
                            NhaCungCapBUS bus = new NhaCungCapBUS();
                            try {
                                kqncc = bus.timSDT(txtTimNCC.getText().toLowerCase());
                                modelNCC.setRowCount(0);
                                for (NhaCungCapDTO ncc : kqncc) {
                                    Vector row = new Vector();
                                    if (ncc.getTinhTrang() == 1) {
                                        row.add(ncc.getID());
                                        row.add(ncc.getTen());
                                        row.add(ncc.getSDT());
                                        row.add(ncc.getMail());
                                        row.add(ncc.getDiaChi());
                                        row.add(ncc.getTinhTrang());
                                        modelNCC.addRow(row);
                                    }
                                    tblNCC.setModel(modelNCC);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "Mail":
                            try {
                            ArrayList<NhaCungCapDTO> kqncc = new ArrayList<NhaCungCapDTO>();
                            NhaCungCapBUS bus = new NhaCungCapBUS();
                            try {
                                kqncc = bus.timMail(txtTimNCC.getText().toLowerCase());
                                modelNCC.setRowCount(0);
                                for (NhaCungCapDTO ncc : kqncc) {
                                    Vector row = new Vector();
                                    if (ncc.getTinhTrang() == 1) {
                                        row.add(ncc.getID());
                                        row.add(ncc.getTen());
                                        row.add(ncc.getSDT());
                                        row.add(ncc.getMail());
                                        row.add(ncc.getDiaChi());
                                        row.add(ncc.getTinhTrang());
                                        modelNCC.addRow(row);
                                    }
                                    tblNCC.setModel(modelNCC);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "Địa chỉ":
                            try {
                            ArrayList<NhaCungCapDTO> kqncc = new ArrayList<NhaCungCapDTO>();
                            NhaCungCapBUS bus = new NhaCungCapBUS();
                            try {
                                kqncc = bus.timDiaChi(txtTimNCC.getText().toLowerCase());
                                modelNCC.setRowCount(0);
                                for (NhaCungCapDTO ncc : kqncc) {
                                    Vector row = new Vector();
                                    if (ncc.getTinhTrang() == 1) {
                                        row.add(ncc.getID());
                                        row.add(ncc.getTen());
                                        row.add(ncc.getSDT());
                                        row.add(ncc.getMail());
                                        row.add(ncc.getDiaChi());
                                        row.add(ncc.getTinhTrang());
                                        modelNCC.addRow(row);
                                    }
                                    tblNCC.setModel(modelNCC);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "Tình trạng":
                            try {
                            ArrayList<NhaCungCapDTO> kqncc = new ArrayList<NhaCungCapDTO>();
                            NhaCungCapBUS bus = new NhaCungCapBUS();
                            try {
                                int temp = Integer.parseInt(txtTimNCC.getText());
                                kqncc = bus.timTinhTrang(temp);
                                modelNCC.setRowCount(0);
                                for (NhaCungCapDTO ncc : kqncc) {
                                    Vector row = new Vector();
                                    row.add(ncc.getID());
                                    row.add(ncc.getTen());
                                    row.add(ncc.getSDT());
                                    row.add(ncc.getMail());
                                    row.add(ncc.getDiaChi());
                                    row.add(ncc.getTinhTrang());
                                    modelNCC.addRow(row);
                                    tblNCC.setModel(modelNCC);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                    }
                }
            }
        });
        
    }

    private void quanlyhangnhap() {  //====================================================================HANGNHAP
        //2.nhập hàng
        lbPN = new JLabel("   Quản lý hàng nhập", JLabel.LEFT);
        lbPN.setOpaque(true);
        lbPN.setBounds(0, 100, 200, 50);
        lbPN.setBackground(new java.awt.Color(67, 160, 71));
        lbPN.setForeground(Color.WHITE);
        lbPN.setFont(new Font("Arial", NORMAL, 14));
        lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        pW.add(lbPN);

        try {
            BufferedImage imgHN = ImageIO.read(new File("src/img/HN.png"));
            ImageIcon iconHN = new ImageIcon(imgHN.getScaledInstance(25, 25, imgHN.SCALE_SMOOTH));
            lbPN.setIcon(iconHN);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        lbPN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbPN.setBackground(new java.awt.Color(129, 199, 132));
                lbPN.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbPN.setBackground(new java.awt.Color(67, 160, 71));
                lbPN.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(false);
                pPN.setVisible(true);
                pNV.setVisible(false);
                pKH.setVisible(false);
                pSP.setVisible(false);
                pHD.setVisible(false);
                pCTGG.setVisible(false);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });

        //Panel Phiếu nhập hàng start
        pPN = new JPanel();
        pPN.setLayout(null);
        pPN.setBackground(Color.WHITE);
        pPN.setBounds(0, 0, 1000, 660);
        pCT.add(pPN);
        pPN.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pPN.setVisible(false);

        lbIDPN = new JLabel("ID phiếu nhập");
        lbIDNVinPN = new JLabel("ID nhân viên");
        lbIDNCCinPN = new JLabel("ID nhà cung cấp");
        lbTongTienPN = new JLabel("Tổng tiền phiếu nhập");
        lbNgayNhapPN = new JLabel("Ngày nhập");
        lbTimPN = new JLabel("Tìm");
        lbDSPN = new JLabel("DANH SÁCH PHIẾU NHẬP");
        lbChiTietPN = new JLabel("CHI TIẾT PHIẾU NHẬP");

        lbIDPN.setBounds(20, 20, 120, 30);
        lbIDNVinPN.setBounds(20, 70, 120, 30);
        lbIDNCCinPN.setBounds(20, 120, 120, 30);
        lbTongTienPN.setBounds(460, 20, 120, 30);
        lbNgayNhapPN.setBounds(460, 70, 120, 30);
        lbTimPN.setBounds(460, 120, 30, 30);
        lbDSPN.setBounds(20, 170, 400, 30);
        lbDSPN.setForeground(new java.awt.Color(51, 105, 30));
        lbDSPN.setFont(new Font("Arial", Font.BOLD, 16));
        lbChiTietPN.setBounds(520, 170, 400, 30);
        lbChiTietPN.setForeground(new java.awt.Color(51, 105, 30));
        lbChiTietPN.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromPN[] = {"ID PN", "ID NV", "ID NCC", "Tổng tiền", "Ngày nhập"};
        JComboBox cbPN = new JComboBox(findfromPN);
        cbPN.setBounds(490, 120, 90, 30);
        cbPN.setBorder(null);
        cbPN.setBackground(new java.awt.Color(128, 222, 234));
        cbPN.setForeground(Color.WHITE);
        pPN.add(cbPN);

        txtIDPN = new JTextField("", 20);
        txtIDNVinPN = new JTextField("", 20);
        txtIDNCCinPN = new JTextField("", 20);
        txtTongTienPN = new JTextField("", 20);
        dateNgayNhapPN = new JDateChooser("dd/MM/yyyy", false);
        txtTimPN = new JTextField("", 30);

        txtIDPN.setBounds(150, 20, 220, 30);
        txtIDNVinPN.setBounds(150, 70, 220, 30);
        txtIDNCCinPN.setBounds(150, 120, 220, 30);
        txtTongTienPN.setBounds(590, 20, 220, 30);
        dateNgayNhapPN.setBounds(590, 70, 220, 30);
        txtTimPN.setBounds(590, 120, 220, 30);

        txtIDPN.setEditable(false);
        txtIDNVinPN.setEditable(false);
        txtIDNCCinPN.setEditable(false);
        txtTongTienPN.setEditable(false);
        //Đỗ dữ liệu id của người đăng nhập lên=================================
        NhanvienDTO nv_dto = new NhanvienDTO();
        try {
            NhanvienBUS bus = new NhanvienBUS();
            nv_dto = bus.LayThongTinNVTheoMail(General.CURRENT_USER);
        } catch (Exception ex) {
            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtIDNVinPN.setText(nv_dto.getId());
        
        btnThemPN = new JButton("Thêm");
        btnThemPN.setBackground(new java.awt.Color(174, 234, 0));
        btnThemPN.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemPN.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnXoaPN = new JButton("Xóa");
        btnXoaPN.setBackground(new java.awt.Color(255, 82, 82));
        btnXoaPN.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaPN.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnSuaPN = new JButton("Sửa");
        btnSuaPN.setBackground(new java.awt.Color(238, 255, 65));
        btnSuaPN.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaPN.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnTimPN = new JButton("Tìm");
        btnTimPN.setBackground(new java.awt.Color(128, 222, 234));
        btnTimPN.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimPN.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnRefreshPN = new JButton("Tải lại");
        btnRefreshPN.setBackground(new java.awt.Color(178, 255, 89));
        btnRefreshPN.setBorder(null);

        btnImportPN = new JButton("Import");
        btnImportPN.setBackground(new java.awt.Color(174, 234, 0));
        btnImportPN.setBorder(null);

        btnExportPN = new JButton("Export");
        btnExportPN.setBackground(new java.awt.Color(178, 255, 89));
        btnExportPN.setBorder(null);
        btnExportPN.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                XSSFWorkbook workbook=new XSSFWorkbook();
                XSSFSheet sheet=workbook.createSheet("Khachhang");
                
                XSSFRow row=null;
                XSSFCell cell =null;
                
                row =sheet.createRow(0);
                
                cell=row.createCell(0);
                cell.setCellValue("id_pn");                
                cell=row.createCell(1);
                cell.setCellValue("ho_nv");               
                cell=row.createCell(2);
                cell.setCellValue("ten_ncc");               
                cell=row.createCell(3);
                cell.setCellValue("ngaynhap_pn");               
                cell=row.createCell(4);
                cell.setCellValue("tongtien_pn");                
                cell=row.createCell(5);
                
                if(PhieuNhapBUS.danhsach_pn != null)
                {
                    int x = PhieuNhapBUS.danhsach_pn.size();
                    for (int i = 0; i < x; i++) 
                    {
                        PhieuNhapDTO pn_dto = PhieuNhapBUS.danhsach_pn.get(i);
                        
                        row = sheet.createRow(2 + i);
                        
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(pn_dto.getId_pn());                        
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(pn_dto.getId_nv());                        
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(pn_dto.getId_ncc());                        
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue(pn_dto.getNgaynhap_pn());
                        cell = row.createCell(4, CellType.STRING);
                        cell.setCellValue(pn_dto.getTongtien_pn());
                    }
                    File f = new File("../DoAnJavaTommorrow/Phieunhap.xlsx");
                    FileOutputStream fos = null;
                    try {
                         fos = new FileOutputStream(f);
                        workbook.write(fos);
                        JOptionPane.showMessageDialog(null, "In danh sách phiếu nhập thành công !");
                        fos.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        btnChiTietPN = new JButton("Sửa Chi tiết PN");
        btnChiTietPN.setBackground(new java.awt.Color(174, 234, 0));
        btnChiTietPN.setBorder(null);

        btnTimNCCinPN = new JButton("Chọn"); //nút chọn nhà cung cấp 
        btnTimNCCinPN.setBackground(new java.awt.Color(174, 234, 0));
        btnTimNCCinPN.setBorder(null);

        btnTimNVinPN = new JButton("Chọn"); //nút chọn nhân viên 
        btnTimNVinPN.setBackground(new java.awt.Color(174, 234, 0));
        btnTimNVinPN.setBorder(null);

        btnThemPN.setBounds(880, 20, 100, 30);
        btnSuaPN.setBounds(880, 70, 100, 30);
        btnXoaPN.setBounds(880, 170, 100, 30);
        btnTimPN.setBounds(880, 120, 100, 30);
        btnRefreshPN.setBounds(260, 170, 80, 30);
        btnImportPN.setBounds(340, 170, 80, 30);
        btnExportPN.setBounds(420, 170, 80, 30);
        btnChiTietPN.setBounds(880, 170, 100, 30);
        btnTimNCCinPN.setBounds(370, 120, 40, 30);
        btnTimNVinPN.setBounds(370, 70, 40, 30);

        String[] columnPN
                = {"ID phiếu nhập", "ID nhân viên", "ID nhà cung cấp", "Tổng tiền", "Ngày nhập"};
        Object[][] dataPN = {};
        DefaultTableModel modelPN = new DefaultTableModel(dataPN, columnPN);
        tblPN = new JTable(modelPN) {
            //không cho edit khi double-click lên tableCell
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        TableRowSorter<TableModel> rowSorterPN = new TableRowSorter<TableModel>(modelPN);
        tblPN.setRowSorter(rowSorterPN);
        tblPN.setBackground(Color.WHITE);
        tblPN.setForeground(Color.BLACK);
        tblPN.setRowHeight(25);
        tblPN.setFont(new Font("Arial", NORMAL, 12));
        tblPN.setBorder(null);
        tblPN.setShowVerticalLines(false);
        tblPN.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblPN.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollPN = new JScrollPane(tblPN);
        scrollPN.setBounds(20, 220, 480, 425);
        pPN.add(scrollPN);

        tblPN.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPN.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblPN.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblPN.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblPN.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblPN.getColumnModel().getColumn(4).setPreferredWidth(150);

        JTableHeader headerPN = tblPN.getTableHeader();
        headerPN.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblPN.getTableHeader().setForeground(Color.WHITE);
        tblPN.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblPN.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        //=>bỏ viền header table

        //table chi tiết phiếu nhập
        String[] columnCTPN
                = {"ID phiếu nhập", "ID sản phẩm", "Số lượng", "Giá nhập"};
        Object[][] dataCTPN = {};

        DefaultTableModel modelCTPN = new DefaultTableModel(dataCTPN, columnCTPN);
        tblChiTietPN = new JTable(modelCTPN) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        TableRowSorter<TableModel> rowSorterCTPN = new TableRowSorter<TableModel>(modelCTPN);
        tblChiTietPN.setRowSorter(rowSorterCTPN);
        tblChiTietPN.setBackground(Color.WHITE);
        tblChiTietPN.setForeground(Color.BLACK);
        tblChiTietPN.setRowHeight(25);
        tblChiTietPN.setFont(new Font("Arial", NORMAL, 12));
        tblChiTietPN.setBorder(null);
        tblChiTietPN.setShowVerticalLines(false);
        tblChiTietPN.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblChiTietPN.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollCTPN = new JScrollPane(tblChiTietPN);
        scrollCTPN.setBounds(520, 220, 460, 425);
        pPN.add(scrollCTPN);

        tblChiTietPN.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblChiTietPN.getColumnModel().getColumn(0).setPreferredWidth(120);
        tblChiTietPN.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblChiTietPN.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblChiTietPN.getColumnModel().getColumn(3).setPreferredWidth(120);

        JTableHeader headerCTPN = tblChiTietPN.getTableHeader();
        headerCTPN.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblChiTietPN.getTableHeader().setForeground(Color.WHITE);
        tblChiTietPN.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblChiTietPN.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));

        pPN.add(lbIDPN);
        pPN.add(lbIDNVinPN);
        pPN.add(lbIDNCCinPN);
        pPN.add(lbTongTienPN);
        pPN.add(lbNgayNhapPN);
        pPN.add(lbTimPN);
        pPN.add(lbDSPN);
        pPN.add(lbChiTietPN);

        pPN.add(txtIDPN);
        pPN.add(txtIDNVinPN);
        pPN.add(txtIDNCCinPN);
        pPN.add(txtTongTienPN);
        pPN.add(dateNgayNhapPN);
        pPN.add(txtTimPN);

        pPN.add(btnThemPN);
        pPN.add(btnSuaPN);
        pPN.add(btnTimPN);
        pPN.add(btnRefreshPN);
        pPN.add(btnImportPN);
        pPN.add(btnExportPN);
        pPN.add(btnChiTietPN);
        pPN.add(btnTimNCCinPN);
//        pPN.add(btnTimNVinPN); wait

        final FrameChiTietPN frmChiTietPN = new FrameChiTietPN();
        frmChiTietPN.btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frmChiTietPN.setVisible(false);
            }
        });
        // lắng nghe sự kiện 
        tblPN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblPN.getSelectedRow();
                if (i >= 0) {
                    txtIDPN.setText(tblPN.getModel().getValueAt(i, 0).toString());
                    txtIDNVinPN.setText(tblPN.getModel().getValueAt(i, 1).toString());
                    txtIDNCCinPN.setText(tblPN.getModel().getValueAt(i, 2).toString());
                    txtTongTienPN.setText(tblPN.getModel().getValueAt(i, 3).toString());
                    String tempPN = tblPN.getModel().getValueAt(i, 4).toString();
                    SimpleDateFormat dateFormatPN = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        dateNgayNhapPN.setDate(dateFormatPN.parse(tempPN));
                    } catch (ParseException ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frmChiTietPN.txtIDPN.setText(tblPN.getModel().getValueAt(i, 0).toString());
                    frmChiTietPN.txtIDSP.setText("");
                    frmChiTietPN.txtSoLuong.setText("");
                    frmChiTietPN.txtGiaNhap.setText("");
                }
            }
        });

        btnTimNCCinPN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pPN.setVisible(false);
                pNCC.setVisible(true);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbPN.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });

        HangNhapBUS bus = new HangNhapBUS();
        bus.docDSHN();
        for (HangnhapDTO hn : HangNhapBUS.dsHN) {
            Vector row = new Vector();
            row.add(hn.getIDPN());
            row.add(hn.getIDNV());
            row.add(hn.getIDNCC());
            row.add(hn.getTongTien());
            row.add(hn.getNgayNhap());
            modelPN.addRow(row);
        }
        tblPN.setModel(modelPN);
        
        btnRefreshPN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIDPN.setText("");
                txtIDNVinPN.setText("");
                txtIDNCCinPN.setText("");
                txtTongTienPN.setText("");
                dateNgayNhapPN.setDate(new Date());
                cbPN.setSelectedIndex(0);
                modelPN.setRowCount(0);

                HangNhapBUS bus = new HangNhapBUS();
                bus.docDSHN();
                for (HangnhapDTO hn : HangNhapBUS.dsHN) {
                    Vector row = new Vector();
                    row.add(hn.getIDPN());
                    row.add(hn.getIDNV());
                    row.add(hn.getIDNCC());
                    row.add(hn.getTongTien());
                    row.add(hn.getNgayNhap());
                    modelPN.addRow(row);
                }
                tblPN.setModel(modelPN);
                
                modelCTPN.setRowCount(0);
            
      
                for(int j=0; j<1; j++){
                    int demTongTien=0;
                    ChiTietPhieuNhapBUS busTongTien = new ChiTietPhieuNhapBUS();
                    
                    for(HangnhapDTO hn : HangNhapBUS.dsHN){
                        double tongtien=0;
                        for (ChiTietPhieuNhapDTO ctpn : ChiTietPhieuNhapBUS.dsChiTietPN){
                            if(hn.getIDPN() == ctpn.getIDPN()){
                                tongtien = tongtien + (ctpn.getSoLuongSP() * ctpn.getGiaNhap());
                            }
                        }
                        modelPN.setValueAt(tongtien, demTongTien, 3);
                        demTongTien++;
                        tblPN.setModel(modelPN);
                    }
                }
        
                for(int i = 0; i<tblPN.getRowCount(); i++){
                    HangnhapDTO hn = new HangnhapDTO();
                    hn.idPN = Integer.parseInt(tblPN.getModel().getValueAt(i , 0).toString());
                    double temp = Double.parseDouble(tblPN.getModel().getValueAt(i , 3).toString());
                    hn.tongtien = temp;
                    HangNhapBUS b = new HangNhapBUS();
                    
                    try {
                        b.capnhatTongTien(hn);
                    } catch (Exception ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        btnThemPN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HangnhapDTO hn = new HangnhapDTO();
                int temp = 0;
                for (HangnhapDTO hn2 : HangNhapBUS.dsHN) {
                    temp = hn2.getIDPN();
                }
                hn.idPN = temp + 1;

                NhanvienDTO nv_dto = new NhanvienDTO();
                try {
                    NhanvienBUS bus = new NhanvienBUS();
                    nv_dto = bus.LayThongTinNVTheoMail(General.CURRENT_USER);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                txtIDNVinPN.setText(nv_dto.getId());
                hn.idNV = Integer.parseInt(txtIDNVinPN.getText());
                
                
                hn.idNCC = Integer.parseInt(txtIDNCCinPN.getText());
                hn.tongtien = 0;
                String tempPN = "dd/MM/yyyy";
                DateFormat dateFormatPN = new SimpleDateFormat(tempPN);
                hn.ngaynhap = dateFormatPN.format(dateNgayNhapPN.getDate());

                HangNhapBUS bus = new HangNhapBUS();
                try {
                    bus.them(hn);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }

                Vector row = new Vector();
                row.add(hn.idPN);
                row.add(hn.idNV);
                row.add(hn.idNCC);
                row.add(hn.tongtien);
                row.add(hn.ngaynhap);

                modelPN.addRow(row);
                tblPN.setModel(modelPN);
                
            }
        });
        
        btnSuaPN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblPN.getSelectedRow();
                if (i >= 0) {
                    HangnhapDTO hn = new HangnhapDTO();
                    hn.idPN = Integer.parseInt(txtIDPN.getText());
                    hn.idNV = Integer.parseInt(txtIDNVinPN.getText());
                    hn.idNCC = Integer.parseInt(txtIDNCCinPN.getText());
                    hn.tongtien = Double.parseDouble(txtTongTienPN.getText());

                    String temp = txtIDNVinPN.getText();

//                    date to string
                    String tempPN = "dd/MM/yyyy";
                    DateFormat dateFormatPN = new SimpleDateFormat(tempPN);
                    hn.ngaynhap = dateFormatPN.format(dateNgayNhapPN.getDate());

                    HangNhapBUS bus = new HangNhapBUS();
                    try {
                        bus.sua(hn);
                    } catch (Exception ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    modelPN.setValueAt(txtIDPN.getText(), i, 0);
                    modelPN.setValueAt(txtIDNVinPN.getText(), i, 1);
                    modelPN.setValueAt(txtIDNCCinPN.getText(), i, 2);
                    modelPN.setValueAt(txtTongTienPN.getText(), i, 3);
                    modelPN.setValueAt(dateNgayNhapPN.getDate(), i, 4);

                    tblPN.setModel(modelPN);
                }
            }

        });

        btnTimPN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = cbPN.getSelectedItem().toString();
                String text = txtTimPN.getText();
                //nếu textfield tìm kiễm rỗng sẽ hiện tất cả
                if (text.trim().length() == 0) {
                    rowSorterPN.setRowFilter(null);
                    modelPN.setRowCount(0);
                    for (HangnhapDTO hn : HangNhapBUS.dsHN) {
                        Vector row = new Vector();
                        row.add(hn.getIDPN());
                        row.add(hn.getIDNV());
                        row.add(hn.getIDNCC());
                        row.add(hn.getTongTien());
                        row.add(hn.getNgayNhap());
                        modelPN.addRow(row);
                    }
                    tblPN.setModel(modelPN);
                } else {
                    switch (option) {
                        case "ID PN":
                            try {
                            HangnhapDTO hn = new HangnhapDTO();
                            HangNhapBUS bus = new HangNhapBUS();
                            try {
                                int temp = Integer.parseInt(txtTimPN.getText());

                                int temp1 = 0; //temp1 là id lớn nhất của phiếu nhập
                                for (HangnhapDTO hn2 : HangNhapBUS.dsHN) {
                                    temp1 = hn2.getIDPN();
                                }
                                if (temp1 < temp || temp <= 0) {
                                    JOptionPane.showMessageDialog(null, "Không tồn tại phiếu nhập này!!");
                                    modelPN.setRowCount(0);
                                } else {
                                    hn = bus.timIDPN(temp);
                                    modelPN.setRowCount(0);
                                    Vector row = new Vector();
                                    row.add(hn.getIDPN());
                                    row.add(hn.getIDNV());
                                    row.add(hn.getIDNCC());
                                    row.add(hn.getTongTien());
                                    row.add(hn.getNgayNhap());
                                    modelPN.addRow(row);
                                    tblPN.setModel(modelPN);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "ID NV":
                            try {
                            ArrayList<HangnhapDTO> kqhn = new ArrayList<HangnhapDTO>();
                            HangNhapBUS bus = new HangNhapBUS();
                            try {
                                kqhn = bus.timIDNV(Integer.parseInt(txtTimPN.getText()));
                                modelPN.setRowCount(0);
                                for (HangnhapDTO hn : kqhn) {
                                    Vector row = new Vector();
                                    row.add(hn.getIDPN());
                                    row.add(hn.getIDNV());
                                    row.add(hn.getIDNCC());
                                    row.add(hn.getTongTien());
                                    row.add(hn.getNgayNhap());
                                    modelPN.addRow(row);
                                    tblPN.setModel(modelPN);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "ID NCC":
                            try {
                            ArrayList<HangnhapDTO> kqhn = new ArrayList<HangnhapDTO>();
                            HangNhapBUS bus = new HangNhapBUS();
                            try {
                                kqhn = bus.timIDNCC(Integer.parseInt(txtTimPN.getText()));
                                modelPN.setRowCount(0);
                                for (HangnhapDTO hn : kqhn) {
                                    Vector row = new Vector();
                                    row.add(hn.getIDPN());
                                    row.add(hn.getIDNV());
                                    row.add(hn.getIDNCC());
                                    row.add(hn.getTongTien());
                                    row.add(hn.getNgayNhap());
                                    modelPN.addRow(row);
                                    tblPN.setModel(modelPN);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "Tổng tiền":
                            try {
                            ArrayList<HangnhapDTO> kqhn = new ArrayList<HangnhapDTO>();
                            HangNhapBUS bus = new HangNhapBUS();
                            try {
                                kqhn = bus.timTongTien(Double.parseDouble(txtTimPN.getText()));
                                modelPN.setRowCount(0);
                                for (HangnhapDTO hn : kqhn) {
                                    Vector row = new Vector();
                                    row.add(hn.getIDPN());
                                    row.add(hn.getIDNV());
                                    row.add(hn.getIDNCC());
                                    row.add(hn.getTongTien());
                                    row.add(hn.getNgayNhap());
                                    modelPN.addRow(row);
                                    tblPN.setModel(modelPN);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                        case "Ngày nhập":
                            try {
                            ArrayList<HangnhapDTO> kqhn = new ArrayList<HangnhapDTO>();
                            HangNhapBUS bus = new HangNhapBUS();
                            try {
                                kqhn = bus.timNgayNhap(txtTimPN.getText());
                                modelPN.setRowCount(0);
                                for (HangnhapDTO hn : kqhn) {
                                    Vector row = new Vector();
                                    row.add(hn.getIDPN());
                                    row.add(hn.getIDNV());
                                    row.add(hn.getIDNCC());
                                    row.add(hn.getTongTien());
                                    row.add(hn.getNgayNhap());
                                    modelPN.addRow(row);
                                    tblPN.setModel(modelPN);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception e2) {
                        }
                        break;
                    }
                }
            }
        });

        //sự kiện trên chi tiết phiếu nhập
        tblChiTietPN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblChiTietPN.getSelectedRow();
                if (i >= 0) {
                    frmChiTietPN.txtIDPN.setText(tblChiTietPN.getModel().getValueAt(i, 0).toString());
                    frmChiTietPN.txtIDSP.setText(tblChiTietPN.getModel().getValueAt(i, 1).toString());
                    frmChiTietPN.txtSoLuong.setText(tblChiTietPN.getModel().getValueAt(i, 2).toString());
                    frmChiTietPN.txtGiaNhap.setText(tblChiTietPN.getModel().getValueAt(i, 3).toString());
                }
            }
        });
        
        //thêm 1 chi tiết phiếu nhập
        frmChiTietPN.btnThem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
                ctpn.idPN=Integer.parseInt(frmChiTietPN.txtIDPN.getText());
                ctpn.idSP=Integer.parseInt(frmChiTietPN.txtIDSP.getText());
                ctpn.soluongSP=Integer.parseInt(frmChiTietPN.txtSoLuong.getText());
                //mới thêm
//                if(Double.parseDouble(saochepgia) > Double.parseDouble(frmChiTietPN.txtGiaNhap.getText())){
//                    ctpn.gianhap=.parseDouble(frmChiTietPN.txtGiaNhap.getText());
//                ctpn.gianhap=Double.parseDouble(saochepgia)-(Double.parseDouble(saochepgia)*10/100);
                ctpn.gianhap=Double.parseDouble(frmChiTietPN.txtGiaNhap.getText());
                ChiTietPhieuNhapBUS bus = new ChiTietPhieuNhapBUS();
                try {
                    bus.them(ctpn);
                    JOptionPane.showMessageDialog(null, "Thêm chi tiết thành công!!");
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(FrameChiTietPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                Vector row = new Vector();
                row.add(ctpn.idPN);
                row.add(ctpn.idSP);
                row.add(ctpn.soluongSP);
                row.add(ctpn.gianhap);

                modelCTPN.addRow(row);
                tblChiTietPN.setModel(modelCTPN);
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Giá nhập phải nhỏ hơn giá bán");
//                }
            }
        });
        
        //sửa chi tiết phiếu nhập
        frmChiTietPN.btnSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblChiTietPN.getSelectedRow();
                if (i >= 0) {
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
                    ctpn.idPN=Integer.parseInt(frmChiTietPN.txtIDPN.getText());
                    ctpn.idSP=Integer.parseInt(frmChiTietPN.txtIDSP.getText());
                    ctpn.soluongSP=Integer.parseInt(frmChiTietPN.txtSoLuong.getText());
                    ctpn.gianhap=Double.parseDouble(frmChiTietPN.txtGiaNhap.getText());
                    ChiTietPhieuNhapBUS bus = new ChiTietPhieuNhapBUS();
                    try {
                        bus.sua(ctpn);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(FrameChiTietPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    modelCTPN.setValueAt(frmChiTietPN.txtIDPN.getText(), i, 0);
                    modelCTPN.setValueAt(frmChiTietPN.txtIDSP.getText(), i, 1);
                    modelCTPN.setValueAt(frmChiTietPN.txtSoLuong.getText(), i, 2);
                    modelCTPN.setValueAt(frmChiTietPN.txtGiaNhap.getText(), i, 3);

                    tblChiTietPN.setModel(modelCTPN);
                    JOptionPane.showMessageDialog(null, "Cập nhật chi tiết thành công!!");
                }
            }
        });
        
        //xóa 1 chi tiết phiếu nhập
        frmChiTietPN.btnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblChiTietPN.getSelectedRow();
                if (i >= 0) {
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
                    ctpn.idPN=Integer.parseInt(frmChiTietPN.txtIDPN.getText());
                    ctpn.idSP=Integer.parseInt(frmChiTietPN.txtIDSP.getText());
                    ctpn.soluongSP=Integer.parseInt(frmChiTietPN.txtSoLuong.getText());
                    ctpn.gianhap=Double.parseDouble(frmChiTietPN.txtGiaNhap.getText());
                    ChiTietPhieuNhapBUS bus = new ChiTietPhieuNhapBUS();
                    try {
                        bus.xoa(ctpn);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(FrameChiTietPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    //cập nhật danh sách chi tiết PN sau khi xóa
                    modelCTPN.setRowCount(0);
                    String temp2 = tblPN.getModel().getValueAt(i, 0).toString();
                    ChiTietPhieuNhapBUS bus2 = new ChiTietPhieuNhapBUS();
                    bus2.docDSChiTietPN();
                    for (ChiTietPhieuNhapDTO ctpn2 : ChiTietPhieuNhapBUS.dsChiTietPN) {
                        if(ctpn2.getIDPN() == Integer.parseInt(temp2)){
                            Vector row = new Vector();
                            row.add(ctpn2.getIDPN());
                            row.add(ctpn2.getIDSP());
                            row.add(ctpn2.getSoLuongSP());
                            row.add(ctpn2.getGiaNhap());
                            modelCTPN.addRow(row);
                        }
                    }
                    tblChiTietPN.setModel(modelCTPN);
                    JOptionPane.showMessageDialog(null, "Đã xóa 1 chi tiết phiếu nhập!!");
                }
            }
        });
        
        //tìm kiếm nâng cao, chọn idSP ở frame chi tiết phiếu nhập
        //khai báo thêm biến sao chép public phía đầu
        btnChiTietPN.addMouseListener(new MouseAdapter() {
            int flag=0; //bắt đầu với cờ bằng 0 khi click vào btn chi tiết pn
            @Override
            public void mouseClicked(MouseEvent e) {
                frmChiTietPN.btnTimIDSP.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        frmChiTietPN.setVisible(false); //nhảy qua panel sản phẩm để chọn idSP khi click nút chọn
                        pPN.setVisible(false);
                        pSP.setVisible(true);
                        flag=1; //bật cờ bằng 1
                        lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                        lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                        lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                        lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                        lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                        lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                        lbHD.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                        lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                    }
                });
                if(flag==1){
                    //nếu cờ bằng 1 (đã click vào nút chọn rồi) thì cho  txtIDSP = value biến "sapchep"
                    frmChiTietPN.txtIDSP.setText(saochep);
                    frmChiTietPN.txtGiaNhap.setText(String.valueOf(Double.parseDouble(saochepgia)-(Double.parseDouble(saochepgia)*10/100)));
                    saochep="";
                    saochepgia="";
                    flag=0;
                }
            }
        });
        
       
        //click 1 row bên phiếu nhập sẽ hiện chi tiết phiếu nhập bên table kia
        tblPN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modelCTPN.setRowCount(0);
                int i = tblPN.getSelectedRow();
                if (i >= 0) {
                    String temp2 = tblPN.getModel().getValueAt(i, 0).toString();
                    ChiTietPhieuNhapBUS bus = new ChiTietPhieuNhapBUS();
                    bus.docDSChiTietPN();
                    for (ChiTietPhieuNhapDTO ctpn : ChiTietPhieuNhapBUS.dsChiTietPN) {
                        if(ctpn.getIDPN() == Integer.parseInt(temp2)){
                            Vector row = new Vector();
                            row.add(ctpn.getIDPN());
                            row.add(ctpn.getIDSP());
                            row.add(ctpn.getSoLuongSP());
                            row.add(ctpn.getGiaNhap());
                            modelCTPN.addRow(row);
                        }
                    }
                    tblChiTietPN.setModel(modelCTPN);
                }
            }
        });
        
        //tính tổng tiền
        //tính tổng tiền rồi gán lên bảng
        for(int j=0;j<1;j++){
            int demTongTien=0;
            ChiTietPhieuNhapBUS busTongTien = new ChiTietPhieuNhapBUS();
            busTongTien.docDSChiTietPN();
            for(HangnhapDTO hn : HangNhapBUS.dsHN){
                double tongtien=0;
                for (ChiTietPhieuNhapDTO ctpn : ChiTietPhieuNhapBUS.dsChiTietPN){
                    if(hn.getIDPN() == ctpn.getIDPN()){
                        tongtien = tongtien + (ctpn.getSoLuongSP() * ctpn.getGiaNhap());
                    }
                }
                modelPN.setValueAt(tongtien, demTongTien, 3);
                demTongTien++;
                tblPN.setModel(modelPN);
            }
        }
        
        //cập nhật bảng xuống csdl
        for(int i =0; i<tblPN.getRowCount(); i++){
            HangnhapDTO hn = new HangnhapDTO();
            hn.idPN = Integer.parseInt(tblPN.getModel().getValueAt(i , 0).toString());
            double temp = Double.parseDouble(tblPN.getModel().getValueAt(i , 3).toString());
            hn.tongtien = temp;
            HangNhapBUS b = new HangNhapBUS();
            b.docDSHN();
            try {
                b.capnhatTongTien(hn);
            } catch (Exception ex) {
                Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //tính tổng tiền end
        
        
        //gọi frame chi tiết phiếu nhập
        btnChiTietPN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frmChiTietPN.setVisible(true);
            }
        });

        //Panel phiếu nhập hàng end
    }

    private void quanlysanpham() {   //=====================================================================SANPHAM

        lbSP = new JLabel("	   Quản lý sản phẩm", JLabel.LEFT);
        lbSP.setOpaque(true);
        lbSP.setBounds(0, 150, 200, 50);
        lbSP.setBackground(new java.awt.Color(67, 160, 71));
        lbSP.setForeground(Color.WHITE);
        lbSP.setFont(new Font("Arial", NORMAL, 14));
        lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        pW.add(lbSP);
        try {
            BufferedImage imgSP = ImageIO.read(new File("src/img/SP.png"));
            ImageIcon iconSP = new ImageIcon(imgSP.getScaledInstance(25, 25, imgSP.SCALE_SMOOTH));
            lbSP.setIcon(iconSP);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
               
        lbSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbSP.setBackground(new java.awt.Color(129, 199, 132));
                lbSP.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbSP.setBackground(new java.awt.Color(67, 160, 71));
                lbSP.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(false);
                pPN.setVisible(false);
                pNV.setVisible(false);
                pKH.setVisible(false);
                pSP.setVisible(true);
                pHD.setVisible(false);
                pCTGG.setVisible(false);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbHD.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        String[] columnSP = {"ID SP", "Tên SP", "Số lượng", "Đơn giá SP", "Loại SP"};
        DefaultTableModel modelSP = new DefaultTableModel(columnSP, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        //Panel sản phẩm start
        pSP = new JPanel();
        pSP.setLayout(null);
        pSP.setBackground(Color.WHITE);
        pSP.setBounds(0, 0, 1000, 660);
        pCT.add(pSP);
        pSP.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pSP.setVisible(false);

        lbIDSP = new JLabel("ID sản phẩm");
        lbTenSP = new JLabel("Tên sản phẩm");
        lbSoLuongSP = new JLabel("Số lượng sản phẩm");
        lbDonGiaSP = new JLabel("Đơn giá sản phẩm");
        lbLoaiSP = new JLabel("Loại sản phẩm");
        lbTimSP = new JLabel("Tìm");
        lbDSSP = new JLabel("DANH SÁCH SẢN PHẨM");

        lbIDSP.setBounds(20, 20, 120, 30);
        lbTenSP.setBounds(20, 70, 120, 30);
        lbSoLuongSP.setBounds(20, 120, 120, 30);
        lbDonGiaSP.setBounds(460, 20, 120, 30);
        lbLoaiSP.setBounds(460, 70, 120, 30);
        lbTimSP.setBounds(460, 120, 120, 30);
        lbDSSP.setBounds(20, 220, 400, 30);
        lbDSSP.setForeground(new java.awt.Color(51, 105, 30));
        lbDSSP.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromSP[] = {"ID SP", "Tên SP", "SL SP", "Đơn Giá SP", "Loại SP"};
        JComboBox cbSP = new JComboBox(findfromSP);
        cbSP.setBounds(490, 120, 90, 30);
        cbSP.setBorder(null);
        cbSP.setBackground(new java.awt.Color(128, 222, 234));
        cbSP.setForeground(Color.WHITE);
        pSP.add(cbSP);

        txtIDSP = new JTextField("", 20);
        txtTenSP = new JTextField("", 20);
        txtSoLuongSP = new JTextField("", 20);
        txtDonGiaSP = new JTextField("", 20);
        txtLoaiSP = new JTextField("", 20);
        txtTimSP = new JTextField("", 30);

        txtIDSP.setBounds(150, 20, 220, 30);
        txtTenSP.setBounds(150, 70, 220, 30);
        txtSoLuongSP.setBounds(150, 120, 220, 30);
        txtDonGiaSP.setBounds(590, 20, 220, 30);
        txtLoaiSP.setBounds(590, 70, 220, 30);
        txtTimSP.setBounds(590, 120, 220, 30);

        //Ko cho nhập id, số lượng
        txtIDSP.setEditable(false);
        //txtSoLuongSP.setEditable(false);

        btnThemSP = new JButton("Thêm");
        btnThemSP.setBackground(new java.awt.Color(174, 234, 0));
        btnThemSP.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemSP.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnThemSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SanphamBUS bus = new SanphamBUS();
                bus.getDSSanphamdaydu();
                int i = SanphamBUS.danhsachdaydu.size() - 1;
                SanphamDTO temp = SanphamBUS.danhsachdaydu.get(i);
                int temp2 = Integer.parseInt(temp.getId()) + 1;
                String k = String.valueOf(temp2);
                txtIDSP.setText(k);
                //===== Check xem có hợp lệ =====//
                //Check tên
                if (KT.soN(txtTenSP.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Tên phải là chữ !");
                    return;
                }
                //Check số lượng sản phẩm
                if (KT.soN(txtSoLuongSP.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Số lượng phải là số");
                    return;
                }
                //Check đơn giá sản phẩm
                if (KT.soN(txtDonGiaSP.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Đơn giá phải là số");
                    return;
                }
                //Check loại sản phẩm
                if (KT.soN(txtLoaiSP.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Giới tính phải là chữ và ít hơn hoặc bằng 3 từ");
                    return;
                }
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(txtIDSP.getText());
                sp_dto.setTen(txtTenSP.getText());
                sp_dto.setSoluong(txtSoLuongSP.getText());
                sp_dto.setDongia(txtDonGiaSP.getText());
                sp_dto.setLoai(txtLoaiSP.getText());
                try {
                    bus.Insert(sp_dto);
                    Vector row = new Vector();
                    row.add(sp_dto.getId());
                    row.add(sp_dto.getTen());
                    row.add(sp_dto.getSoluong());
                    row.add(sp_dto.getDongia());
                    row.add(sp_dto.getLoai());
                    modelSP.addRow(row);
                    tblNV.setModel(modelSP);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnXoaSP = new JButton("Xóa");
        btnXoaSP.setBackground(new java.awt.Color(255, 82, 82));
        btnXoaSP.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaSP.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnXoaSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tblSP.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại !");
                    return;
                }
                SanphamBUS bus = new SanphamBUS();
                try {
                    bus.Delete2(txtIDSP.getText(), tblSP.getSelectedRow());
                    modelSP.removeRow(tblSP.getSelectedRow());
                    tblSP.setModel(modelSP);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnSuaSP = new JButton("Sửa");
        btnSuaSP.setBackground(new java.awt.Color(238, 255, 65));
        btnSuaSP.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaSP.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnSuaSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblSP.getSelectedRow();
                //===== Check xem có hợp lệ =====//
                //Check tên
                if (KT.soN(txtTenSP.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Tên phải là chữ !");
                    return;
                }
                //Check số lượng sản phẩm
                if (KT.soN(txtSoLuongSP.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải là số");
                    return;
                }
                //Check đơn giá sản phẩm
                if (KT.soN(txtDonGiaSP.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Đơn giá phải là số");
                    return;
                }
                //Check loại sản phẩm
                if (KT.soN(txtLoaiSP.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Giới tính phải là chữ và ít hơn hoặc bằng 3 từ");
                    return;
                }
                SanphamDTO sp_dto = new SanphamDTO();
                sp_dto.setId(txtIDSP.getText());
                sp_dto.setTen(txtTenSP.getText());
                sp_dto.setSoluong(txtSoLuongSP.getText());
                sp_dto.setDongia(txtDonGiaSP.getText());
                sp_dto.setLoai(txtLoaiSP.getText());
                SanphamBUS bus = new SanphamBUS();
                try {
                    bus.Update(sp_dto);
                    modelSP.setValueAt(sp_dto.getTen(), i, 1);
                    modelSP.setValueAt(sp_dto.getSoluong(), i, 2);
                    modelSP.setValueAt(sp_dto.getDongia(), i, 3);
                    modelSP.setValueAt(sp_dto.getLoai(), i, 4);
                    tblSP.setModel(modelSP);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnTimSP = new JButton("Tìm");
        btnTimSP.setBackground(new java.awt.Color(128, 222, 234));
        btnTimSP.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimSP.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnTimSP.addActionListener(new ActionListener() //Tìm kiếm trong sản phẩm
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector header = new Vector();
                header.add("Id sp");
                header.add("Tên sp");
                header.add("Số lượng sp");
                header.add("Đơn giá sp");
                header.add("Loại sp");

                switch (cbSP.getSelectedIndex()) {
                    case 0: //Tìm theo id
                    {
                        //Làm cho table SP trống rỗng
                        for (int i = 0; i < SanphamBUS.danhsach_sp.size(); i++) {
                            modelSP.removeRow(0);
                        }
                        ArrayList<SanphamDTO> temp = null;
                        SanphamDAO sp_dao = new SanphamDAO();
                        try {
                            temp = sp_dao.SearchDSSP2(txtTimSP.getText());
                            SanphamBUS.danhsach_sp = sp_dao.SearchDSSP2(txtTimSP.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (SanphamDTO sp_dto : temp) {
                            Vector row = new Vector();
                            row.add(sp_dto.getId());
                            row.add(sp_dto.getTen());
                            row.add(sp_dto.getSoluong());
                            row.add(sp_dto.getDongia());
                            row.add(sp_dto.getLoai());
                            modelSP.addRow(row);
                        }
                        tblSP.setModel(modelSP);

                        tblSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblSP.getColumnModel().getColumn(0).setPreferredWidth(100);
                        tblSP.getColumnModel().getColumn(1).setPreferredWidth(300);
                        tblSP.getColumnModel().getColumn(2).setPreferredWidth(200);
                        tblSP.getColumnModel().getColumn(3).setPreferredWidth(180);
                        tblSP.getColumnModel().getColumn(4).setPreferredWidth(180);
                    }
                    break;
                    case 1: //Tìm theo tên
                    {
                        //Làm cho table SP trống rỗng
                        for (int i = 0; i < SanphamBUS.danhsach_sp.size(); i++) {
                            modelSP.removeRow(0);
                        }
                        ArrayList<SanphamDTO> temp = null;
                        SanphamDAO sp_dao = new SanphamDAO();
                        try {
                            temp = sp_dao.SearchDSSP3(txtTimSP.getText());
                            SanphamBUS.danhsach_sp = sp_dao.SearchDSSP3(txtTimSP.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (SanphamDTO sp_dto : temp) {
                            Vector row = new Vector();
                            row.add(sp_dto.getId());
                            row.add(sp_dto.getTen());
                            row.add(sp_dto.getSoluong());
                            row.add(sp_dto.getDongia());
                            row.add(sp_dto.getLoai());
                            modelSP.addRow(row);
                        }
                        tblSP.setModel(modelSP);

                        tblSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblSP.getColumnModel().getColumn(0).setPreferredWidth(100);
                        tblSP.getColumnModel().getColumn(1).setPreferredWidth(300);
                        tblSP.getColumnModel().getColumn(2).setPreferredWidth(200);
                        tblSP.getColumnModel().getColumn(3).setPreferredWidth(180);
                        tblSP.getColumnModel().getColumn(4).setPreferredWidth(180);
                    }
                    break;
                    case 2: //Tìm theo số lượng
                    {
                        //Làm cho table SP trống rỗng
                        for (int i = 0; i < SanphamBUS.danhsach_sp.size(); i++) {
                            modelSP.removeRow(0);
                        }
                        ArrayList<SanphamDTO> temp = null;
                        SanphamDAO sp_dao = new SanphamDAO();
                        try {
                            temp = sp_dao.SearchDSSP4(txtTimSP.getText());
                            SanphamBUS.danhsach_sp = sp_dao.SearchDSSP4(txtTimSP.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (SanphamDTO sp_dto : temp) {
                            Vector row = new Vector();
                            row.add(sp_dto.getId());
                            row.add(sp_dto.getTen());
                            row.add(sp_dto.getSoluong());
                            row.add(sp_dto.getDongia());
                            row.add(sp_dto.getLoai());
                            modelSP.addRow(row);
                        }
                        tblSP.setModel(modelSP);

                        tblSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblSP.getColumnModel().getColumn(0).setPreferredWidth(100);
                        tblSP.getColumnModel().getColumn(1).setPreferredWidth(300);
                        tblSP.getColumnModel().getColumn(2).setPreferredWidth(200);
                        tblSP.getColumnModel().getColumn(3).setPreferredWidth(180);
                        tblSP.getColumnModel().getColumn(4).setPreferredWidth(180);
                    }
                    break;
                    case 3: //Tìm theo đơn giá
                    {
                        //Làm cho table SP trống rỗng
                        for (int i = 0; i < SanphamBUS.danhsach_sp.size(); i++) {
                            modelSP.removeRow(0);
                        }
                        ArrayList<SanphamDTO> temp = null;
                        SanphamDAO sp_dao = new SanphamDAO();
                        try {
                            temp = sp_dao.SearchDSSP5(txtTimSP.getText());
                            SanphamBUS.danhsach_sp = sp_dao.SearchDSSP5(txtTimSP.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (SanphamDTO sp_dto : temp) {
                            Vector row = new Vector();
                            row.add(sp_dto.getId());
                            row.add(sp_dto.getTen());
                            row.add(sp_dto.getSoluong());
                            row.add(sp_dto.getDongia());
                            row.add(sp_dto.getLoai());
                            modelSP.addRow(row);
                        }
                        tblSP.setModel(modelSP);

                        tblSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblSP.getColumnModel().getColumn(0).setPreferredWidth(100);
                        tblSP.getColumnModel().getColumn(1).setPreferredWidth(300);
                        tblSP.getColumnModel().getColumn(2).setPreferredWidth(200);
                        tblSP.getColumnModel().getColumn(3).setPreferredWidth(180);
                        tblSP.getColumnModel().getColumn(4).setPreferredWidth(180);
                    }
                    break;
                    case 4: //Tìm theo loại
                    {
                        //Làm cho table SP trống rỗng
                        for (int i = 0; i < SanphamBUS.danhsach_sp.size(); i++) {
                            modelSP.removeRow(0);
                        }
                        ArrayList<SanphamDTO> temp = null;
                        SanphamDAO sp_dao = new SanphamDAO();
                        try {
                            temp = sp_dao.SearchDSSP6(txtTimSP.getText());
                            SanphamBUS.danhsach_sp = sp_dao.SearchDSSP6(txtTimSP.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (SanphamDTO sp_dto : temp) {
                            Vector row = new Vector();
                            row.add(sp_dto.getId());
                            row.add(sp_dto.getTen());
                            row.add(sp_dto.getSoluong());
                            row.add(sp_dto.getDongia());
                            row.add(sp_dto.getLoai());
                            modelSP.addRow(row);
                        }
                        tblSP.setModel(modelSP);

                        tblSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblSP.getColumnModel().getColumn(0).setPreferredWidth(100);
                        tblSP.getColumnModel().getColumn(1).setPreferredWidth(300);
                        tblSP.getColumnModel().getColumn(2).setPreferredWidth(200);
                        tblSP.getColumnModel().getColumn(3).setPreferredWidth(180);
                        tblSP.getColumnModel().getColumn(4).setPreferredWidth(180);
                    }
                    break;
                }
            }
        });
        btnDocDLSP = new JButton("Tải lại");
        btnDocDLSP.setBackground(new java.awt.Color(178, 255, 89));
        btnDocDLSP.setBorder(null);
        //Tải dữ liệu lên table
        SanphamBUS bus = new SanphamBUS();
        bus.getDSSanpham();
        Vector header = new Vector();
        header.add("Id sp");
        header.add("Tên sp");
        header.add("Số lượng sp");
        header.add("Đơn giá sp");
        header.add("Loại sp");
        for(int j=0; j<1; j++){
            int tempIDSP = 0;
            PhieuNhapBUS busTongSP10 = new PhieuNhapBUS();
            busTongSP10.getDSPhieunhap();
            int demdong = 1;
            
            for(HangnhapDTO hn : HangNhapBUS.dsHN){
                for (SanphamDTO sp_dto : bus.getDSSanpham()) {
                    tempIDSP++;
                    int tongsp = 0;
                    ChiTietPhieuNhapBUS busTongSP = new ChiTietPhieuNhapBUS();
                    busTongSP.docDSChiTietPN();
                    for(ChiTietPhieuNhapDTO ctpn : ChiTietPhieuNhapBUS.dsChiTietPN){
                        if(ctpn.getIDSP() == tempIDSP){
                            tongsp = tongsp + ctpn.getSoLuongSP();
                        }
                    }
                    System.out.println("GUI.FormBanHang.quanlysanpham():  " +tongsp);
                    Vector row = new Vector();
                    row.add(sp_dto.getId());
                    row.add(sp_dto.getTen()); 
                    row.add(tongsp);
                    row.add(sp_dto.getDongia());
                    row.add(sp_dto.getLoai());
                    modelSP.addRow(row);
                }
                break;
            }
        }
        btnDocDLSP.addActionListener(new ActionListener()//Nút tải db
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIDSP.setText("");
                txtIDSP.setEditable(false);
                txtTenSP.setText("");
                txtSoLuongSP.setText("");
                txtDonGiaSP.setText("");
                txtLoaiSP.setText("");
//                for (int i = 0; i < SanphamBUS.danhsach_sp.size(); i++) {
//                    modelSP.removeRow(0);
//                }
//                SanphamBUS bus = new SanphamBUS();
//                bus.getDSSanpham();
//                Vector header = new Vector();
//                header.add("Id sp");
//                header.add("Tên sp");
//                header.add("Số lượng sp");
//                header.add("Đơn giá sp");
//                header.add("Loại sp");
//                for (SanphamDTO sp_dto : SanphamBUS.danhsach_sp) {
//                    Vector row = new Vector();
//                    row.add(sp_dto.getId());
//                    row.add(sp_dto.getTen());
//                    row.add(sp_dto.getSoluong());
//                    row.add(sp_dto.getDongia());
//                    row.add(sp_dto.getLoai());
//                    modelSP.addRow(row);
//                }
                    for(int i=0; i<tblSP.getRowCount(); i++){
                        SanphamDTO sp_dto = new SanphamDTO();
                        sp_dto.id_sp = tblSP.getModel().getValueAt(i, 0).toString();
                        sp_dto.sl_sp = tblSP.getModel().getValueAt(i, 2).toString();    
                        SanphamBUS b = new SanphamBUS();
                        b.getDSSanpham();
                        try {
                            b.UpdateSLSP(sp_dto);
                        } catch (Exception ex) {
                        
                        }
                    }
            }
        });

        btnImportSP = new JButton("Import");
        btnImportSP.setBackground(new java.awt.Color(174, 234, 0));
        btnImportSP.setBorder(null);        
        
        btnExportSP = new JButton("Export");
        btnExportSP.setBackground(new java.awt.Color(178, 255, 89));
        btnExportSP.setBorder(null);
        btnExportSP.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                XSSFWorkbook workbook=new XSSFWorkbook();
                XSSFSheet sheet=workbook.createSheet("Sanpham");
                
                XSSFRow row=null;
                XSSFCell cell =null;
                
                row =sheet.createRow(0);
                
                cell=row.createCell(0);
                cell.setCellValue("id_sp");                
                cell=row.createCell(1);
                cell.setCellValue("ten_sp");               
                cell=row.createCell(2);
                cell.setCellValue("soluong_sp");               
                cell=row.createCell(3);
                cell.setCellValue("dongia_sp");               
                cell=row.createCell(4);
                cell.setCellValue("loai_sp");
                
                if(SanphamBUS.danhsach_sp != null)
                {
                    int x = SanphamBUS.danhsach_sp.size();
                    for (int i = 0; i < x; i++) 
                    {
                        SanphamDTO sp_dto = SanphamBUS.danhsach_sp.get(i);
                        
                        row = sheet.createRow(2 + i);
                        
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(sp_dto.getId());                        
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(sp_dto.getTen());                        
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(sp_dto.getSoluong());                        
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue(sp_dto.getDongia());
                        cell = row.createCell(4, CellType.STRING);
                        cell.setCellValue(sp_dto.getLoai());
                    }
                    File f = new File("../DoAnJavaTommorrow/Sanpham.xlsx");
                    FileOutputStream fos = null;
                    try {
                         fos = new FileOutputStream(f);
                        workbook.write(fos);
                        JOptionPane.showMessageDialog(null, "In danh sach sản phẩm thành công !");
                        fos.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        btnCopyIDSP = new JButton("Chép ID SP");
        btnCopyIDSP.setBackground(new java.awt.Color(178, 255, 89));
        btnCopyIDSP.setBorder(null);
        
        btnThemSP.setBounds(880, 20, 100, 30);
        btnSuaSP.setBounds(880, 70, 100, 30);
        btnXoaSP.setBounds(880, 170, 100, 30);
        btnTimSP.setBounds(880, 120, 100, 30);
        btnDocDLSP.setBounds(680, 220, 100, 30);
        btnImportSP.setBounds(780, 220, 100, 30);
        btnExportSP.setBounds(880, 220, 100, 30);
        btnCopyIDSP.setBounds(270, 220, 100, 30);
        
        tblSP = new JTable(modelSP);

        TableRowSorter<TableModel> rowSorterSP = new TableRowSorter<TableModel>(modelSP);
        tblSP.setRowSorter(rowSorterSP);

        tblSP.setBackground(Color.WHITE);
        tblSP.setForeground(Color.BLACK);
        tblSP.setRowHeight(25);
        tblSP.setFont(new Font("Arial", NORMAL, 12));
        tblSP.setBorder(null);
        tblSP.setShowVerticalLines(false);
        tblSP.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblSP.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollSP = new JScrollPane(tblSP);
        scrollSP.setBounds(20, 260, 960, 385);
        pSP.add(scrollSP);

        tblSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblSP.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblSP.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblSP.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblSP.getColumnModel().getColumn(3).setPreferredWidth(180);
        tblSP.getColumnModel().getColumn(4).setPreferredWidth(180);

        JTableHeader headerSP = tblSP.getTableHeader();
        headerSP.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblSP.getTableHeader().setForeground(Color.WHITE);
        tblSP.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblSP.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        //=>bỏ viền header table
        
        pSP.add(lbIDSP);
        pSP.add(lbTenSP);
        pSP.add(lbSoLuongSP);
        pSP.add(lbDonGiaSP);
        pSP.add(lbLoaiSP);
        pSP.add(lbTimSP);
        pSP.add(lbDSSP);

        pSP.add(txtIDSP);
        pSP.add(txtTenSP);
        pSP.add(txtSoLuongSP);
        pSP.add(txtDonGiaSP);
        pSP.add(txtLoaiSP);
        pSP.add(txtTimSP);

        pSP.add(btnThemSP);
        pSP.add(btnSuaSP);
        pSP.add(btnXoaSP);
        pSP.add(btnTimSP);
        pSP.add(btnDocDLSP);
        pSP.add(btnImportSP);
        pSP.add(btnExportSP);
        pSP.add(btnCopyIDSP);
        // lắng nghe sự kiện 
        tblSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblSP.getSelectedRow();
                if (i >= 0) {
                    txtIDSP.setText(tblSP.getModel().getValueAt(i, 0).toString());
                    txtTenSP.setText(tblSP.getModel().getValueAt(i, 1).toString());
                    txtSoLuongSP.setText(tblSP.getModel().getValueAt(i, 2).toString());
                    txtDonGiaSP.setText(tblSP.getModel().getValueAt(i, 3).toString());
                    txtLoaiSP.setText(tblSP.getModel().getValueAt(i, 4).toString());
                }

            }
        });
        //thêm sự kiện copy id
        //thêm btn copyidsp
        tblSP.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                btnCopyIDSP.addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        int i = tblSP.getSelectedRow();
                        if (i >= 0){
                            saochep = tblSP.getModel().getValueAt(i, 0).toString();
                            saochepgia = tblSP.getModel().getValueAt(i, 3).toString();
                            pSP.setVisible(false);
                            pPN.setVisible(true);
                            lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                            lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                            lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbSP.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                            lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                            lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                        }
                    }
                });
            }
        });        
        
    }

    private void quanlyhoadon() {    //=======================================================================HOADON

        lbHD = new JLabel("   Quản lý hóa đơn", JLabel.LEFT);
        lbHD.setOpaque(true);
        lbHD.setBounds(0, 200, 200, 50);
        lbHD.setBackground(new java.awt.Color(67, 160, 71));
        lbHD.setForeground(Color.WHITE);
        lbHD.setFont(new Font("Arial", NORMAL, 14));
        lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        try {
            BufferedImage imgHD = ImageIO.read(new File("src/img/HD.png"));
            ImageIcon iconHD = new ImageIcon(imgHD.getScaledInstance(25, 25, imgHD.SCALE_SMOOTH));
            lbHD.setIcon(iconHD);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        lbHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbHD.setBackground(new java.awt.Color(129, 199, 132));
                lbHD.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbHD.setBackground(new java.awt.Color(67, 160, 71));
                lbHD.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(false);
                pPN.setVisible(false);
                pNV.setVisible(false);
                pKH.setVisible(false);
                pSP.setVisible(false);
                pHD.setVisible(true);
                pCTGG.setVisible(false);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        //Panel hóa đơn start
        pHD = new JPanel();
        pHD.setLayout(null);
        pHD.setBackground(Color.WHITE);
        pHD.setBounds(0, 0, 1000, 660);
        pCT.add(pHD);
        pHD.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pHD.setVisible(false);

        lbIDHD = new JLabel("ID hóa đơn");
        lbIDKHinHD = new JLabel("ID khách hàng");
        lbIDNVinHD = new JLabel("ID nhân viên");
        lbIDGGinHD = new JLabel("ID giảm giá");
        lbNgayLapHD = new JLabel("Ngày lập hóa đơn");
        lbTongTienHD = new JLabel("Tổng tiền hóa đơn");
        lbTienGiamGiaHD = new JLabel("Tiền giảm giá");
        lbTimHD = new JLabel("Tìm");
        lbDSHD = new JLabel("DANH SÁCH HÓA ĐƠN");
        lbChiTietHD = new JLabel("CHI TIẾT HÓA ĐƠN");

        lbIDHD.setBounds(20, 20, 120, 30);
        lbIDKHinHD.setBounds(20, 70, 120, 30);
        lbIDNVinHD.setBounds(20, 120, 120, 30);
        lbIDGGinHD.setBounds(20, 170, 120, 30);
        lbNgayLapHD.setBounds(460, 20, 120, 30);
        lbTongTienHD.setBounds(460, 70, 120, 30);
        lbTienGiamGiaHD.setBounds(460, 120, 120, 30);
        lbTimHD.setBounds(460, 170, 30, 30);
        lbDSHD.setBounds(20, 220, 400, 30);
        lbDSHD.setForeground(new java.awt.Color(51, 105, 30));
        lbDSHD.setFont(new Font("Arial", Font.BOLD, 16));
        lbChiTietHD.setBounds(520, 220, 400, 30);
        lbChiTietHD.setForeground(new java.awt.Color(51, 105, 30));
        lbChiTietHD.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromHD[] = {"ID hóa đơn", "ID khách hàng", "ID nhân viên", "ID giảm giá", "Ngày lập", "Tổng tiền", "Tiền giảm giá"};
        final JComboBox cbHD = new JComboBox(findfromHD);
        cbHD.setBounds(490, 170, 90, 30);
        cbHD.setBorder(null);
        cbHD.setBackground(new java.awt.Color(128, 222, 234));
        cbHD.setForeground(Color.WHITE);
        pHD.add(cbHD);

        txtIDHD = new JTextField("", 20);
        txtIDKHinHD = new JTextField("", 20);
        txtIDNVinHD = new JTextField("", 20);
        txtIDGGinHD = new JTextField("", 20);
        dateNgayLapHD = new JDateChooser("dd/MM/yyyy", false);
        txtTongTienHD = new JTextField("", 20);
        txtTienGiamGiaHD = new JTextField("", 20);
        txtTimHD = new JTextField("", 30);

        txtIDHD.setBounds(150, 20, 220, 30);
        txtIDKHinHD.setBounds(150,70,220,30);
        txtIDNVinHD.setBounds(150,120,220,30);
        txtIDGGinHD.setBounds(150,170,220,30);
        //txtIDKHinHD.setBounds(150, 70, 220, 30);
        //txtIDNVinHD.setBounds(150, 120, 220, 30);
        //txtIDGGinHD.setBounds(150, 170, 220, 30);
        dateNgayLapHD.setBounds(590, 20, 220, 30);
        txtTongTienHD.setBounds(590,70,220,30);
        txtTienGiamGiaHD.setBounds(590,120,220,30);
        //txtTongTienHD.setBounds(590, 70, 220, 30);
        //txtTienGiamGiaHD.setBounds(590, 120, 220, 30);
        txtTimHD.setBounds(590, 170, 220, 30);
        
        txtIDHD.setEditable(false);
        txtIDKHinHD.setEditable(false);
        txtIDNVinHD.setEditable(false);
        txtIDGGinHD.setEditable(false);
        txtTongTienHD.setEditable(false);
        txtTienGiamGiaHD.setEditable(false);
    
    //lay du lieu nhan vien dang nhap
        NhanvienDTO nv_dto = new NhanvienDTO();
        try {
            NhanvienBUS bus = new NhanvienBUS();
            nv_dto = bus.LayThongTinNVTheoMail(General.CURRENT_USER);
        } catch (Exception ex) {
            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtIDNVinHD.setText(nv_dto.getId());

        btnThemHD = new JButton("Thêm");
        btnThemHD.setBackground(new java.awt.Color(174, 234, 0));
        btnThemHD.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemHD.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnXoaHD = new JButton("Xóa");
        btnXoaHD.setBackground(new java.awt.Color(238, 238, 238));
        btnXoaHD.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaHD.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnXoaHD.setEnabled(false);

        btnSuaHD = new JButton("Sửa");
        btnSuaHD.setBackground(new java.awt.Color(238, 238, 238));
        btnSuaHD.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaHD.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnSuaHD.setEnabled(false);

        btnTimHD = new JButton("Tìm");
        btnTimHD.setBackground(new java.awt.Color(128, 222, 234));
        btnTimHD.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimHD.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnDocDLHD = new JButton("Tải lại");
        btnDocDLHD.setBackground(new java.awt.Color(178, 255, 89));
        btnDocDLHD.setBorder(null);

        btnImportHD = new JButton("Import");
        btnImportHD.setBackground(new java.awt.Color(174, 234, 0));
        btnImportHD.setBorder(null);

        btnExportHD = new JButton("Export");
        btnExportHD.setBackground(new java.awt.Color(178, 255, 89));
        btnExportHD.setBorder(null);
        btnExportHD.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                XSSFWorkbook workbook=new XSSFWorkbook();
                XSSFSheet sheet=workbook.createSheet("HoaDon");
                
                XSSFRow row=null;
                XSSFCell cell =null;
                
                row =sheet.createRow(0);
                
                cell=row.createCell(0);
                cell.setCellValue("id_hd");                
                cell=row.createCell(1);
                cell.setCellValue("id_kh");               
                cell=row.createCell(2);
                cell.setCellValue("id_nv");               
                cell=row.createCell(3);
                cell.setCellValue("id_gg");               
                cell=row.createCell(4);
                cell.setCellValue("ngaylap_hd");                
                cell=row.createCell(5);
                cell.setCellValue("tongtien_hd");               
                cell=row.createCell(6);
                cell.setCellValue("tien_gg");
                
                if(HoaDonBUS.dsHD != null)
                {
                    int x = HoaDonBUS.dsHD.size();
                    for (int i = 0; i < x; i++) 
                    {
                        HoaDonDTO hd_dto = HoaDonBUS.dsHD.get(i);
                        
                        row = sheet.createRow(2 + i);
                        
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(hd_dto.getIdHD());                        
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(hd_dto.getIdKH());                        
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(hd_dto.getIdNV());                        
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue(hd_dto.getIdGG());
                        cell = row.createCell(4, CellType.STRING);
                        cell.setCellValue(hd_dto.getNgayLapHD());
                        cell = row.createCell(5, CellType.STRING);
                        cell.setCellValue(hd_dto.getTongTien());
                        cell = row.createCell(6, CellType.STRING);
                        cell.setCellValue(hd_dto.getTienGG());
                    }
                    File f = new File("../DoAnJavaTommorrow/Hoadon.xlsx");
                    FileOutputStream fos = null;
                    try {
                         fos = new FileOutputStream(f);
                        workbook.write(fos);
                        JOptionPane.showMessageDialog(null, "In danh sách hóa đơn thành công !");
                        fos.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        btnChiTietHD = new JButton("Chi tiết hóa đơn");
        btnChiTietHD.setBackground(new java.awt.Color(174, 234, 0));
        btnChiTietHD.setBorder(null);
        
        btnTimIDKHinHD=new JButton("Chọn");
        btnTimIDKHinHD.setBackground(new java.awt.Color(178,255,89));
        btnTimIDKHinHD.setBorder(null);
        
        btnTimIDNVinHD=new JButton("Chọn");
        btnTimIDNVinHD.setBackground(new java.awt.Color(174,234,0));
        btnTimIDNVinHD.setBorder(null);
        
        btnTimIDGGinHD=new JButton("Chọn");
        btnTimIDGGinHD.setBackground(new java.awt.Color(178,255,89));
        btnTimIDGGinHD.setBorder(null);

        btnThemHD.setBounds(880, 20, 100, 30);
        btnSuaHD.setBounds(880, 70, 100, 30);
        btnXoaHD.setBounds(880, 120, 100, 30);
        btnTimHD.setBounds(880, 170, 100, 30);
        btnDocDLHD.setBounds(260, 220, 80, 30);
        btnImportHD.setBounds(340, 220, 80, 30);
        btnExportHD.setBounds(420, 220, 80, 30);
        btnChiTietHD.setBounds(880, 220, 100, 30);
        btnTimIDKHinHD.setBounds(380, 70, 50, 30);
        btnTimIDNVinHD.setBounds(380, 120, 50, 30);
        btnTimIDGGinHD.setBounds(380, 170, 50, 30);
//table hoa don
        String[] columnHD
                = {"ID hóa đơn", "ID khách hàng", "ID nhân viên", "ID giảm giá", "Ngày lập HĐ", "Tổng tiền HĐ", "Tiền giảm giá"};
        Object[][] dataHD = null;
        modelHD = new DefaultTableModel(dataHD, columnHD);
//		ArrayList<HoaDonDTO> dsNV;
        tblHD = new JTable(modelHD) {
            //không cho edit khi double-click lên tableCell
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        final TableRowSorter<TableModel> rowSorterHD = new TableRowSorter<TableModel>(modelHD);
        tblHD.setRowSorter(rowSorterHD);
        tblHD.setBackground(Color.WHITE);
        tblHD.setForeground(Color.BLACK);
        tblHD.setRowHeight(25);
        tblHD.setFont(new Font("Arial", NORMAL, 12));
        tblHD.setBorder(null);
        tblHD.setShowVerticalLines(false);
        tblHD.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblHD.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollHD = new JScrollPane(tblHD);
        scrollHD.setBounds(20, 260, 480, 385);
        pHD.add(scrollHD);

        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);

        JTableHeader headerHD = tblHD.getTableHeader();
        headerHD.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblHD.getTableHeader().setForeground(Color.WHITE);
        tblHD.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblHD.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        //=>bỏ viền header table

        //table chi tiết hóa đơn
        String[] columnCTHD
                = {"ID hóa đơn", "ID sản phẩm", "Số lượng", "Đơn giá", "Thành tiền", "Tiền giảm giá"};
        Object[][] dataCTHD = null;

        modelCTHD = new DefaultTableModel(dataCTHD, columnCTHD);
        tblChiTietHD = new JTable(modelCTHD) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        TableRowSorter<TableModel> rowSorterCTHD = new TableRowSorter<TableModel>(modelCTHD);
        tblChiTietHD.setRowSorter(rowSorterCTHD);
        tblChiTietHD.setBackground(Color.WHITE);
        tblChiTietHD.setForeground(Color.BLACK);
        tblChiTietHD.setRowHeight(25);
        tblChiTietHD.setFont(new Font("Arial", NORMAL, 12));
        tblChiTietHD.setBorder(null);
        tblChiTietHD.setShowVerticalLines(false);
        tblChiTietHD.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblChiTietHD.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollCTHD = new JScrollPane(tblChiTietHD);
        scrollCTHD.setBounds(520, 260, 460, 385);
        pHD.add(scrollCTHD);

        tblChiTietHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblChiTietHD.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblChiTietHD.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblChiTietHD.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblChiTietHD.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblChiTietHD.getColumnModel().getColumn(4).setPreferredWidth(110);
        tblChiTietHD.getColumnModel().getColumn(5).setPreferredWidth(110);

        JTableHeader headerCTHD = tblChiTietHD.getTableHeader();
        headerCTHD.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblChiTietHD.getTableHeader().setForeground(Color.WHITE);
        tblChiTietHD.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblChiTietHD.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));

        pHD.add(lbIDHD);
        pHD.add(lbIDKHinHD);
        pHD.add(lbIDNVinHD);
        pHD.add(lbIDGGinHD);
        pHD.add(lbNgayLapHD);
        pHD.add(lbTongTienHD);
        pHD.add(lbTienGiamGiaHD);
        pHD.add(lbTimHD);
        pHD.add(lbDSHD);
        pHD.add(lbChiTietHD);

        pHD.add(txtIDHD);
        pHD.add(txtIDKHinHD);
        pHD.add(txtIDNVinHD);
        pHD.add(txtIDGGinHD);
        pHD.add(dateNgayLapHD);
        pHD.add(txtTongTienHD);
        pHD.add(txtTienGiamGiaHD);
        pHD.add(txtTimHD);

        pHD.add(btnThemHD);
        pHD.add(btnSuaHD);
        pHD.add(btnXoaHD);
        pHD.add(btnTimHD);
        pHD.add(btnDocDLHD);
        pHD.add(btnImportHD);
        pHD.add(btnExportHD);
        pHD.add(btnChiTietHD);
        pHD.add(btnTimIDKHinHD);
        //pHD.add(btnTimIDNVinHD);
        //pHD.add(btnTimIDGGinHD);
        //pHD.add(cbIDKH);
        //pHD.add(cbIDNV);
        //pHD.add(cbIDGG);
        
        final FrameChiTietHD frmChiTietHD = new FrameChiTietHD();
        frmChiTietHD.btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frmChiTietHD.setVisible(false);
            }
        });
        // lắng nghe sự kiện 
        tblHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int i = tblHD.getSelectedRow();
                if (i >= 0) {
                    txtIDHD.setText(tblHD.getModel().getValueAt(i, 0).toString());
                    txtIDKHinHD.setText(tblHD.getModel().getValueAt(i, 1).toString());
                    txtIDNVinHD.setText(tblHD.getModel().getValueAt(i, 2).toString());
                    txtIDGGinHD.setText(tblHD.getModel().getValueAt(i, 3).toString());
                    String tempHD = tblHD.getModel().getValueAt(i, 4).toString();
                    SimpleDateFormat dateFormatHD = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        dateNgayLapHD.setDate(dateFormatHD.parse(tempHD));
                    } catch (ParseException ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    txtTongTienHD.setText(tblHD.getModel().getValueAt(i, 5).toString());
                    txtTienGiamGiaHD.setText(tblHD.getModel().getValueAt(i, 6).toString());
                    frmChiTietHD.txtIDHD.setText(tblHD.getModel().getValueAt(i, 0).toString());
                    /*frmChiTietHD.txtIDSP.setText("");
                    frmChiTietHD.txtSoLuong.setText("");
                    frmChiTietHD.txtDonGia.setText("");
                    frmChiTietHD.txtThanhTien.setText("");
                    frmChiTietHD.txtTienGiamGia.setText("");
                            */
                    modelCTHD.setRowCount(0);
                    docCTHD(Integer.parseInt(txtIDHD.getText()));
                }
            }
        });
        
        tblChiTietHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int i = tblChiTietHD.getSelectedRow();
                if (i >= 0) {
                    frmChiTietHD.txtIDHD.setText(tblChiTietHD.getModel().getValueAt(i, 0).toString());
                    frmChiTietHD.txtIDSP.setText(tblChiTietHD.getModel().getValueAt(i, 1).toString());
                    frmChiTietHD.txtSoLuong.setText(tblChiTietHD.getModel().getValueAt(i, 2).toString());
                    frmChiTietHD.txtDonGia.setText(tblChiTietHD.getModel().getValueAt(i, 3).toString());
                    frmChiTietHD.txtThanhTien.setText(tblChiTietHD.getModel().getValueAt(i, 4).toString());
                    frmChiTietHD.txtTienGiamGia.setText(tblChiTietHD.getModel().getValueAt(i, 5).toString());
                }
            }
        });

        btnChiTietHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frmChiTietHD.setVisible(true);
            }
        });
        
        docHD ();
        btnDocDLHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                txtIDHD.setText("");
                txtIDKHinHD.setText("");
                txtIDNVinHD.setText("");
                txtIDGGinHD.setText("");
                txtTongTienHD.setText("");
                txtTienGiamGiaHD.setText("");
                for(int i=0;i<HoaDonBUS.dsHD.size();i++)
                {
                    modelHD.removeRow(0);
                }
                docHD ();
        //tinh tong tien        
                modelCTHD.setRowCount(0);
                for(int j=0; j<1; j++)
                {
                    int demTongTien=0;
                    ChiTietHD_BUS busTongTien = new ChiTietHD_BUS();
                    busTongTien.getDSCTHD();
                    for(HoaDonDTO hd_dto : HoaDonBUS.dsHD)
                    {
                        double tongtien=0;
                        for (ChiTietHD_DTO cthd_dto : ChiTietHD_BUS.dsCTHD)
                        {
                            if(hd_dto.getIdHD() == cthd_dto.getIdHD())
                            {
                                tongtien = tongtien + cthd_dto.getThanhTien();
                /*
                                KhuyenMaiDTO km_dto=new KhuyenMaiDTO();
                HoaDonBUS hd_bus=new HoaDonBUS();
                try {
                    km_dto=hd_bus.getKMofHD(dateNgayLapHD.getDateFormatString(),tongtien);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println (km_dto.getLoaiCT());
                */
                            }
                        }
                        modelHD.setValueAt(tongtien, demTongTien, 5);
                        demTongTien++;
                        tblHD.setModel(modelHD);
                    }
            
                }
        //cap nhat tong tien
                for(int i = 0; i<tblHD.getRowCount(); i++){
                    HoaDonDTO hd_dto = new HoaDonDTO();
                    hd_dto.setIdHD(Integer.parseInt(tblHD.getModel().getValueAt(i , 0).toString()));
                    hd_dto.setIdKH(Integer.parseInt(tblHD.getModel().getValueAt(i , 1).toString()));
                    hd_dto.setIdNV(Integer.parseInt(tblHD.getModel().getValueAt(i , 2).toString()));
                    hd_dto.setIdGG(Integer.parseInt(tblHD.getModel().getValueAt(i , 3).toString()));
                    String tempHD = tblHD.getModel().getValueAt(i, 4).toString();
                    SimpleDateFormat dateFormatHD = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        dateNgayLapHD.setDate(dateFormatHD.parse(tempHD));
                    } catch (Exception ex) {                       
                    }
                    hd_dto.setTongTien(Double.parseDouble(tblHD.getModel().getValueAt(i, 5).toString()));
                    hd_dto.setTienGG(Double.parseDouble(tblHD.getModel().getValueAt(i, 6).toString()));
                    HoaDonBUS hd_bus = new HoaDonBUS();
                    hd_bus.getDSHoaDon();
                    try {
                        hd_bus.capnhatTongTien(hd_dto);
                    } catch (Exception ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                KhuyenMaiDTO km_dto=new KhuyenMaiDTO();
                HoaDonBUS hd_bus=new HoaDonBUS();
                try {
                    //km_dto=hd_bus.getKMofHD(dateNgayLapHD.getDateFormatString(),tongtien);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println (km_dto.getLoaiCT());
            }
        });
        
        btnTimIDKHinHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                pHD.setVisible(false);
                pKH.setVisible(true);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(118, 255, 3)));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        
        btnTimIDNVinHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                pHD.setVisible(false);
                pNV.setVisible(true);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbKH.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        
        btnTimIDGGinHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                pHD.setVisible(false);
                pCTGG.setVisible(true);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        frmChiTietHD.btnThem.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                //frmChiTietHD.txtTienGiamGia.setText("0");
                ChiTietHD_DTO cthd_dto=new ChiTietHD_DTO();
                cthd_dto.setIdHD(Integer.parseInt(frmChiTietHD.txtIDHD.getText()));
                cthd_dto.setIdSP(Integer.parseInt(frmChiTietHD.txtIDSP.getText()));
                cthd_dto.setSoLuong(Integer.parseInt(frmChiTietHD.txtSoLuong.getText()));
                cthd_dto.setDonGia(Double.parseDouble(frmChiTietHD.txtDonGia.getText()));
                cthd_dto.setThanhTien(Double.parseDouble(frmChiTietHD.txtThanhTien.getText()));
                //tongTieninHD=tongTieninHD+cthd_dto.getThanhTien();
                //cthd_dto.setTienGG(Double.parseDouble(frmChiTietHD.txtTienGiamGia.getText()));
                //tienGGinHD=tienGGinHD+cthd_dto.getTienGG();
                ChiTietHD_BUS bus=new ChiTietHD_BUS();
                try 
                {
                    bus.Insert(cthd_dto);
                } catch (Exception ex) 
                {
                    Logger.getLogger(FrameChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
                Vector row=new Vector ();
                row.add(cthd_dto.getIdHD());
                row.add(cthd_dto.getIdSP());
                row.add(cthd_dto.getSoLuong());
                row.add(cthd_dto.getDonGia());
                row.add(cthd_dto.getThanhTien());
                row.add(cthd_dto.getTienGG());
                modelCTHD.addRow(row);
        /*        
                tongTieninHD=tongTieninHD+cthd_dto.getThanhTien();
                tienGGinHD=tienGGinHD+cthd_dto.getTienGG();
                HoaDonBUS hd_bus=new HoaDonBUS();
                try 
                {
                    hd_bus.Update(cthd_dto.getIdHD(), tongTieninHD, tienGGinHD);
                } catch (Exception ex) 
                {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
        */
            }
        });
        
        btnThemHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                HoaDonDTO hd_dto=new HoaDonDTO();
                int tempIDHD=0;
                for (HoaDonDTO hd_dto2 : HoaDonBUS.dsHD) 
                {
                    tempIDHD=hd_dto2.getIdHD();
                }
                hd_dto.setIdHD(tempIDHD+1);
                hd_dto.setIdKH(Integer.parseInt(txtIDKHinHD.getText()));
                hd_dto.setIdNV(Integer.parseInt(txtIDNVinHD.getText()));
        //luc dau mac dinh hoa don la 3 (binh thuong khong giam gia)
                hd_dto.setIdGG(Integer.parseInt("3"));
                String tempHD = "dd/MM/yyyy";
                DateFormat dateFormatPN = new SimpleDateFormat(tempHD);
                hd_dto.setNgayLapHD(dateFormatPN.format(dateNgayNhapPN.getDate()));
                //hd_dto.setTongTien(Double.parseDouble(txtTongTienHD.getText()));
                hd_dto.setTongTien(0);
                hd_dto.setTienGG(0);

                //hd_dto.setTienGG(Double.parseDouble(txtTienGiamGiaHD.getText()));
                HoaDonBUS bus=new HoaDonBUS();
                try 
                {
                    bus.Insert(hd_dto);
                } catch (Exception ex) 
                {
                    Logger.getLogger(FrameChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
                Vector row=new Vector ();
                row.add(hd_dto.getIdHD());
                row.add(hd_dto.getIdKH());
                row.add(hd_dto.getIdNV());
                row.add(hd_dto.getIdGG());
                row.add(hd_dto.getNgayLapHD());
                row.add(hd_dto.getTongTien());
                row.add(hd_dto.getTienGG());
                modelHD.addRow(row);
            }
        });
        
        btnTimHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {               
                Vector header = new Vector();
                header.add("Id hd");
                header.add("Id kh");
                header.add("Id nv");
                header.add("Id giảm giá");
                header.add("Ngày lập HĐ");
                header.add("Tổng tiền HĐ");
                header.add("Tiền giảm giá");
                switch (cbHD.getSelectedIndex()) 
                {
                    case 0: //Tìm theo id hd
                    {
                        //Làm cho table trống rỗng
                        for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                            modelHD.removeRow(0);
                        }
                        ArrayList<HoaDonDTO> temp = null;
                        HoaDonDAO hd_dao = new HoaDonDAO();
                        try {
                            temp = hd_dao.SearchDSHD2(txtTimHD.getText());
                            HoaDonBUS.dsHD = hd_dao.SearchDSHD2(txtTimHD.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (HoaDonDTO hd_dto : temp) {
                            Vector row = new Vector();
                            row.add(hd_dto.getIdHD());
                            row.add(hd_dto.getIdKH());
                            row.add(hd_dto.getIdNV());
                            row.add(hd_dto.getIdGG());
                            row.add(hd_dto.getNgayLapHD());
                            row.add(hd_dto.getTongTien());
                            row.add(hd_dto.getTienGG());
                            modelHD.addRow(row);
                        }
                        tblHD.setModel(modelHD);

                        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);
                    }
                    break;
                    case 1: //Tìm theo id hd
                    {
                        //Làm cho table trống rỗng
                        for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                            modelHD.removeRow(0);
                        }
                        ArrayList<HoaDonDTO> temp = null;
                        HoaDonDAO hd_dao = new HoaDonDAO();
                        try {
                            temp = hd_dao.SearchDSHD3(txtTimHD.getText());
                            HoaDonBUS.dsHD = hd_dao.SearchDSHD3(txtTimHD.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (HoaDonDTO hd_dto : temp) {
                            Vector row = new Vector();
                            row.add(hd_dto.getIdHD());
                            row.add(hd_dto.getIdKH());
                            row.add(hd_dto.getIdNV());
                            row.add(hd_dto.getIdGG());
                            row.add(hd_dto.getNgayLapHD());
                            row.add(hd_dto.getTongTien());
                            row.add(hd_dto.getTienGG());
                            modelHD.addRow(row);
                        }
                        tblHD.setModel(modelHD);

                        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);
                    }
                    break;
                    case 2: //Tìm theo id hd
                    {
                        //Làm cho table trống rỗng
                        for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                            modelHD.removeRow(0);
                        }
                        ArrayList<HoaDonDTO> temp = null;
                        HoaDonDAO hd_dao = new HoaDonDAO();
                        try {
                            temp = hd_dao.SearchDSHD4(txtTimHD.getText());
                            HoaDonBUS.dsHD = hd_dao.SearchDSHD4(txtTimHD.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (HoaDonDTO hd_dto : temp) {
                            Vector row = new Vector();
                            row.add(hd_dto.getIdHD());
                            row.add(hd_dto.getIdKH());
                            row.add(hd_dto.getIdNV());
                            row.add(hd_dto.getIdGG());
                            row.add(hd_dto.getNgayLapHD());
                            row.add(hd_dto.getTongTien());
                            row.add(hd_dto.getTienGG());
                            modelHD.addRow(row);
                        }
                        tblHD.setModel(modelHD);

                        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);
                    }
                    break;
                    case 3: //Tìm theo id hd
                    {
                        //Làm cho table trống rỗng
                        for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                            modelHD.removeRow(0);
                        }
                        ArrayList<HoaDonDTO> temp = null;
                        HoaDonDAO hd_dao = new HoaDonDAO();
                        try {
                            temp = hd_dao.SearchDSHD5(txtTimHD.getText());
                            HoaDonBUS.dsHD = hd_dao.SearchDSHD5(txtTimHD.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (HoaDonDTO hd_dto : temp) {
                            Vector row = new Vector();
                            row.add(hd_dto.getIdHD());
                            row.add(hd_dto.getIdKH());
                            row.add(hd_dto.getIdNV());
                            row.add(hd_dto.getIdGG());
                            row.add(hd_dto.getNgayLapHD());
                            row.add(hd_dto.getTongTien());
                            row.add(hd_dto.getTienGG());
                            modelHD.addRow(row);
                        }
                        tblHD.setModel(modelHD);

                        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);
                    }
                    break;
                    case 4: //Tìm theo id hd
                    {
                        //Làm cho table trống rỗng
                        for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                            modelHD.removeRow(0);
                        }
                        ArrayList<HoaDonDTO> temp = null;
                        HoaDonDAO hd_dao = new HoaDonDAO();
                        try {
                            temp = hd_dao.SearchDSHD6(txtTimHD.getText());
                            HoaDonBUS.dsHD = hd_dao.SearchDSHD6(txtTimHD.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (HoaDonDTO hd_dto : temp) {
                            Vector row = new Vector();
                            row.add(hd_dto.getIdHD());
                            row.add(hd_dto.getIdKH());
                            row.add(hd_dto.getIdNV());
                            row.add(hd_dto.getIdGG());
                            row.add(hd_dto.getNgayLapHD());
                            row.add(hd_dto.getTongTien());
                            row.add(hd_dto.getTienGG());
                            modelHD.addRow(row);
                        }
                        tblHD.setModel(modelHD);

                        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);
                    }
                    break;
                    case 5: //Tìm theo id hd
                    {
                        //Làm cho table trống rỗng
                        for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                            modelHD.removeRow(0);
                        }
                        ArrayList<HoaDonDTO> temp = null;
                        HoaDonDAO hd_dao = new HoaDonDAO();
                        try {
                            temp = hd_dao.SearchDSHD7(txtTimHD.getText());
                            HoaDonBUS.dsHD = hd_dao.SearchDSHD7(txtTimHD.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (HoaDonDTO hd_dto : temp) {
                            Vector row = new Vector();
                            row.add(hd_dto.getIdHD());
                            row.add(hd_dto.getIdKH());
                            row.add(hd_dto.getIdNV());
                            row.add(hd_dto.getIdGG());
                            row.add(hd_dto.getNgayLapHD());
                            row.add(hd_dto.getTongTien());
                            row.add(hd_dto.getTienGG());
                            modelHD.addRow(row);
                        }
                        tblHD.setModel(modelHD);

                        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);
                    }
                    break;
                    case 6: //Tìm theo id hd
                    {
                        //Làm cho table trống rỗng
                        for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                            modelHD.removeRow(0);
                        }
                        ArrayList<HoaDonDTO> temp = null;
                        HoaDonDAO hd_dao = new HoaDonDAO();
                        try {
                            temp = hd_dao.SearchDSHD8(txtTimHD.getText());
                            HoaDonBUS.dsHD = hd_dao.SearchDSHD8(txtTimHD.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (HoaDonDTO hd_dto : temp) {
                            Vector row = new Vector();
                            row.add(hd_dto.getIdHD());
                            row.add(hd_dto.getIdKH());
                            row.add(hd_dto.getIdNV());
                            row.add(hd_dto.getIdGG());
                            row.add(hd_dto.getNgayLapHD());
                            row.add(hd_dto.getTongTien());
                            row.add(hd_dto.getTienGG());
                            modelHD.addRow(row);
                        }
                        tblHD.setModel(modelHD);

                        tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblHD.getColumnModel().getColumn(0).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(1).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(2).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(3).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(4).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(5).setPreferredWidth(110);
                        tblHD.getColumnModel().getColumn(6).setPreferredWidth(110);
                    }
                    break;
                }
            }
        });
        // add danh mục chức năng vào hướng tây                
        pW.add(lbHD);
        
        //Panel hóa đơn end
    }
    private void docHD ()
    {
        HoaDonBUS bus=new HoaDonBUS ();
        bus.getDSHoaDon();
        for (HoaDonDTO hd_dto : HoaDonBUS.dsHD)
        {
            Vector row=new Vector ();
            row.add(hd_dto.getIdHD());
            row.add(hd_dto.getIdKH());
            row.add(hd_dto.getIdNV());
            row.add(hd_dto.getIdGG());
            row.add(hd_dto.getNgayLapHD());
            row.add(hd_dto.getTongTien());
            row.add(hd_dto.getTienGG());
            modelHD.addRow(row);
        }
    }
    public void docCTHD(int idhd)
    {
        ChiTietHD_BUS bus=new ChiTietHD_BUS ();
        bus.getDSCTHD(idhd);
        for (ChiTietHD_DTO cthd_dto : ChiTietHD_BUS.dsCTHD)
        {
            Vector row=new Vector ();
            row.add(cthd_dto.getIdHD());
            row.add(cthd_dto.getIdSP());
            row.add(cthd_dto.getSoLuong());
            row.add(cthd_dto.getDonGia());
            row.add(cthd_dto.getThanhTien());
            row.add(cthd_dto.getTienGG());
            modelCTHD.addRow(row);
        }
    }
    
    private void chuongtrinhgiamgia() {  //=======================================================CHUONGTRINHGIAMGIA
        lbCTGG = new JLabel("   Chương trình giảm giá", JLabel.LEFT);
        lbCTGG.setOpaque(true);
        lbCTGG.setBounds(0, 250, 200, 50);
        lbCTGG.setBackground(new java.awt.Color(67, 160, 71));
        lbCTGG.setForeground(Color.WHITE);
        lbCTGG.setFont(new Font("Arial", NORMAL, 14));
        lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        pW.add(lbCTGG);
        try {
            BufferedImage imgCTGG = ImageIO.read(new File("src/img/CTGG.png"));
            ImageIcon iconCTGG = new ImageIcon(imgCTGG.getScaledInstance(25, 25, imgCTGG.SCALE_SMOOTH));
            lbCTGG.setIcon(iconCTGG);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //Phân quyền
        if (General.CURRENT_ROLE == 2){
            lbCTGG.setEnabled(false);
            lbCTGG = new JLabel("   Chương trình giảm giá", JLabel.LEFT);
            lbCTGG.setBounds(0, 250, 200, 50);
            lbCTGG.setBackground(new java.awt.Color(67, 160, 71));
            lbCTGG.setForeground(Color.WHITE);
            lbCTGG.setFont(new Font("Arial", NORMAL, 14));
            lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
        
        lbCTGG.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbCTGG.setBackground(new java.awt.Color(129, 199, 132));
                lbCTGG.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbCTGG.setBackground(new java.awt.Color(67, 160, 71));
                lbCTGG.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(false);
                pPN.setVisible(false);
                pNV.setVisible(false);
                pKH.setVisible(false);
                pSP.setVisible(false);
                pHD.setVisible(false);
                pCTGG.setVisible(true);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });
        //Panel chương trình khuyễn mãi start
        pCTGG = new JPanel();
        pCTGG.setLayout(null);
        pCTGG.setBackground(Color.WHITE);
        pCTGG.setBounds(0, 0, 1000, 660);
        pCT.add(pCTGG);
        pCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pCTGG.setVisible(false);

        btnGGtheoHD = new JButton("THEO HÓA ĐƠN");
        btnGGtheoSP = new JButton("THEO SẢN PHẨM");
        
        btnGGtheoHD.setBackground(new java.awt.Color(51, 105, 30));
        btnGGtheoHD.setForeground(Color.WHITE);
        btnGGtheoHD.setBorder(null);
        btnGGtheoSP.setBackground(new java.awt.Color(51, 105, 30));
        btnGGtheoSP.setForeground(Color.WHITE);
        btnGGtheoSP.setBorder(null);
        
        btnGGtheoHD.setBounds(20, 10, 120, 40);
        btnGGtheoSP.setBounds(142, 10, 120, 40);
        
        pCTGG.add(btnGGtheoHD);
        pCTGG.add(btnGGtheoSP);
        
        //GG theo hóa đơn
        lbIDGGtheoHD = new JLabel("ID giảm giá");
        lbTenGGtheoHD = new JLabel("Tên CT giảm giá");
        lbNoiDungGGtheoHD= new JLabel("Nội dung giảm giá");
        lbTGBDGGtheoHD = new JLabel("Thời gian bắt đầu");
        lbTGKTGGtheoHD = new JLabel("Thời gian kết thúc");
        lbDKGGtheoHD = new JLabel("Điều kiện giảm giá");
        lbTimGGtheoHD = new JLabel("Tìm");
        lbDSGGtheoHD = new JLabel("DANH SÁCH CHƯƠNG TRÌNH GIẢM GIÁ THEO HÓA ĐƠN");

        lbIDGGtheoHD.setBounds(20, 70, 120, 30);
        lbTenGGtheoHD.setBounds(20, 120, 120, 30);
        lbTGBDGGtheoHD.setBounds(20, 170, 120, 30);
        lbTGKTGGtheoHD.setBounds(20, 220, 120, 30);
        lbNoiDungGGtheoHD.setBounds(460, 70, 120, 30);
        lbDKGGtheoHD.setBounds(460, 120, 120, 30);
        lbTimGGtheoHD.setBounds(460, 170, 120, 30);
        lbDSGGtheoHD.setBounds(20, 270, 500, 30);
        lbDSGGtheoHD.setForeground(new java.awt.Color(51, 105, 30));
        lbDSGGtheoHD.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromGGtheoHD[] = {"ID giảm giá", "Tên CTGG", "Nội dung CTGG", "TG bắt đầu", "TG kết thúc", "Điều kiện GG"};
        JComboBox cbGGtheoHD = new JComboBox(findfromGGtheoHD);
        cbGGtheoHD.setBounds(490, 170, 90, 30);
        cbGGtheoHD.setBorder(null);
        cbGGtheoHD.setBackground(new java.awt.Color(128, 222, 234));
        cbGGtheoHD.setForeground(Color.WHITE);
        pCTGG.add(cbGGtheoHD);
        
        txtIDGGtheoHD = new JTextField("", 20);
        txtTenGGtheoHD = new JTextField("", 20);
        dateTGBDGGtheoHD = new JDateChooser("dd/MM/yyyy", false);
        dateTGKTGGtheoHD = new JDateChooser("dd/MM/yyyy", false);
        txtNoiDungGGtheoHD = new JTextField("", 50);
        txtDKGGtheoHD = new JTextField("", 50);
        txtTimGGtheoHD = new JTextField("", 20);

        txtIDGGtheoHD.setBounds(150, 70, 220, 30);
        txtIDGGtheoHD.setEditable(false);
        txtTenGGtheoHD.setBounds(150, 120, 220, 30);
        dateTGBDGGtheoHD.setBounds(150, 170, 220, 30);
        dateTGKTGGtheoHD.setBounds(150, 220, 220, 30);
        txtNoiDungGGtheoHD.setBounds(590, 70, 220, 30);
        txtDKGGtheoHD.setBounds(590, 120, 220, 30);
        txtTimGGtheoHD.setBounds(590, 170, 220, 30);
        
        btnThemGGtheoHD = new JButton("Thêm");
        btnThemGGtheoHD.setBackground(new java.awt.Color(174, 234, 0));
        btnThemGGtheoHD.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemGGtheoHD.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnXoaGGtheoHD = new JButton("Xóa");
        btnXoaGGtheoHD.setBackground(new java.awt.Color(238, 238, 238));
        btnXoaGGtheoHD.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaGGtheoHD.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnXoaGGtheoHD.setEnabled(false);

        btnSuaGGtheoHD = new JButton("Sửa");
        btnSuaGGtheoHD.setBackground(new java.awt.Color(238, 238, 238));
        btnSuaGGtheoHD.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaGGtheoHD.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnSuaGGtheoHD.setEnabled(false);

        btnTimGGtheoHD = new JButton("Tìm");
        btnTimGGtheoHD.setBackground(new java.awt.Color(128, 222, 234));
        btnTimGGtheoHD.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimGGtheoHD.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnDocDLGGtheoHD = new JButton("Tải lại");
        btnDocDLGGtheoHD.setBackground(new java.awt.Color(178, 255, 89));
        btnDocDLGGtheoHD.setBorder(null);

        btnImportGGtheoHD = new JButton("Import");
        btnImportGGtheoHD.setBackground(new java.awt.Color(174, 234, 0));
        btnImportGGtheoHD.setBorder(null);

        btnExportGGtheoHD = new JButton("Export");
        btnExportGGtheoHD.setBackground(new java.awt.Color(178, 255, 89));
        btnExportGGtheoHD.setBorder(null);

        btnThemGGtheoHD.setBounds(880, 70, 100, 30);
        btnSuaGGtheoHD.setBounds(880, 120, 100, 30);
        btnXoaGGtheoHD.setBounds(880, 220, 100, 30);
        btnTimGGtheoHD.setBounds(880, 170, 100, 30);
        btnDocDLGGtheoHD.setBounds(680, 270, 100, 30);
        btnImportGGtheoHD.setBounds(780, 270, 100, 30);
        btnExportGGtheoHD.setBounds(880, 270, 100, 30);
    
        String[] columnGGtheoHD
                = {"ID giảm giá(hóa đơn)", "Tên CT giảm giá", "Thời gian bắt đầu", "Thời gian kết thúc", "Nội dung CTGG", "Điều kiện giảm giá"};
        Object[][] dataGGtheoHD =null;
        modelGGtheoHD = new DefaultTableModel(dataGGtheoHD, columnGGtheoHD);
//		ArrayList<GiamGiaTheoHDDTO> dsGGtheoHD;
        tblGGtheoHD = new JTable(modelGGtheoHD) {
            //không cho edit khi double-click lên tableCell
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        TableRowSorter<TableModel> rowSorterGGtheoHD = new TableRowSorter<TableModel>(modelGGtheoHD);
        tblGGtheoHD.setRowSorter(rowSorterGGtheoHD);
        tblGGtheoHD.setBackground(Color.WHITE);
        tblGGtheoHD.setForeground(Color.BLACK);
        tblGGtheoHD.setRowHeight(25);
        tblGGtheoHD.setFont(new Font("Arial", NORMAL, 12));
        tblGGtheoHD.setBorder(null);
        tblGGtheoHD.setShowVerticalLines(false);
        tblGGtheoHD.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblGGtheoHD.setSelectionForeground(new java.awt.Color(255, 255, 255));

        final JScrollPane scrollGGtheoHD = new JScrollPane(tblGGtheoHD);
        scrollGGtheoHD.setBounds(20, 310, 960, 340);
        pCTGG.add(scrollGGtheoHD);

        tblGGtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblGGtheoHD.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblGGtheoHD.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblGGtheoHD.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblGGtheoHD.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblGGtheoHD.getColumnModel().getColumn(4).setPreferredWidth(250);
        tblGGtheoHD.getColumnModel().getColumn(5).setPreferredWidth(250);

        JTableHeader headerGGtheoHD = tblGGtheoHD.getTableHeader();
        headerGGtheoHD.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblGGtheoHD.getTableHeader().setForeground(Color.WHITE);
        tblGGtheoHD.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblGGtheoHD.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
//        =>bỏ viền header table
        
        
        pCTGG.add(lbIDGGtheoHD);
        pCTGG.add(lbTenGGtheoHD);
        pCTGG.add(lbTGBDGGtheoHD);
        pCTGG.add(lbTGKTGGtheoHD);
        pCTGG.add(lbNoiDungGGtheoHD);
        pCTGG.add(lbDKGGtheoHD);
        pCTGG.add(lbTimGGtheoHD);
        pCTGG.add(lbDSGGtheoHD);
        
        pCTGG.add(txtIDGGtheoHD);
        pCTGG.add(txtTenGGtheoHD);
        pCTGG.add(dateTGBDGGtheoHD);
        pCTGG.add(dateTGKTGGtheoHD);
        pCTGG.add(txtNoiDungGGtheoHD);
        pCTGG.add(txtDKGGtheoHD);
        pCTGG.add(txtTimGGtheoHD);
        
        pCTGG.add(btnThemGGtheoHD);
        pCTGG.add(btnXoaGGtheoHD);
        pCTGG.add(btnSuaGGtheoHD);
        pCTGG.add(btnTimGGtheoHD);
        pCTGG.add(btnDocDLGGtheoHD);
        pCTGG.add(btnImportGGtheoHD);
        pCTGG.add(btnExportGGtheoHD);
        
        // lắng nghe sự kiện 
        docCTGGtheoHD ();
        tblGGtheoHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int i = tblGGtheoHD.getSelectedRow();
                if (i >= 0) {
                    txtIDGGtheoHD.setText(tblGGtheoHD.getModel().getValueAt(i, 0).toString());
                    txtTenGGtheoHD.setText(tblGGtheoHD.getModel().getValueAt(i, 1).toString());
                    
                    String tempGGtheoHD1 = tblGGtheoHD.getModel().getValueAt(i, 2).toString();
                    SimpleDateFormat dateFormatGGtheoHD = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        dateTGBDGGtheoHD.setDate(dateFormatGGtheoHD.parse(tempGGtheoHD1));
                    } catch (ParseException ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    String tempGGtheoHD2 = tblGGtheoHD.getModel().getValueAt(i, 3).toString();
                    SimpleDateFormat dateFormatGGtheoHD2 = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        dateTGKTGGtheoHD.setDate(dateFormatGGtheoHD2.parse(tempGGtheoHD2));
                    } catch (ParseException ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    txtNoiDungGGtheoHD.setText(tblGGtheoHD.getModel().getValueAt(i, 4).toString());
                    txtDKGGtheoHD.setText(tblGGtheoHD.getModel().getValueAt(i, 5).toString());
                   
                }
            }
        });
        
        
        //GG theo Sản phẩm
        lbIDGGtheoSP = new JLabel("ID giảm giá");
        lbTenGGtheoSP = new JLabel("Tên CT giảm giá");
        lbNoiDungGGtheoSP= new JLabel("Nội dung giảm giá");
        lbTGBDGGtheoSP = new JLabel("Thời gian bắt đầu");
        lbTGKTGGtheoSP = new JLabel("Thời gian kết thúc");
        lbDKGGtheoSP = new JLabel("Điều kiện giảm giá");
        lbTimGGtheoSP = new JLabel("Tìm");
        lbDSGGtheoSP = new JLabel("DANH SÁCH GG THEO SP");

        lbIDGGtheoSP.setBounds(20, 70, 120, 30);
        lbTenGGtheoSP.setBounds(20, 120, 120, 30);
        lbTGBDGGtheoSP.setBounds(20, 170, 120, 30);
        lbTGKTGGtheoSP.setBounds(20, 220, 120, 30);
        lbNoiDungGGtheoSP.setBounds(460, 70, 120, 30);
        lbDKGGtheoSP.setBounds(460, 120, 120, 30);
        lbTimGGtheoSP.setBounds(460, 170, 120, 30);
        lbDSGGtheoSP.setBounds(20, 270, 300, 30);
        lbDSGGtheoSP.setForeground(new java.awt.Color(51, 105, 30));
        lbDSGGtheoSP.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromGGtheoSP[] = {"ID giảm giá", "Tên CTGG", "Nội dung CTGG", "TG bắt đầu", "TG kết thúc", "Điều kiện GG"};
        JComboBox cbGGtheoSP = new JComboBox(findfromGGtheoSP);
        cbGGtheoSP.setBounds(490, 170, 90, 30);
        cbGGtheoSP.setBorder(null);
        cbGGtheoSP.setBackground(new java.awt.Color(128, 222, 234));
        cbGGtheoSP.setForeground(Color.WHITE);
        pCTGG.add(cbGGtheoSP);
        
        txtIDGGtheoSP = new JTextField("", 20);
        txtTenGGtheoSP = new JTextField("", 20);
        dateTGBDGGtheoSP = new JDateChooser("dd/MM/yyyy", false);
        dateTGKTGGtheoSP = new JDateChooser("dd/MM/yyyy", false);
        txtNoiDungGGtheoSP = new JTextField("", 50);
        txtDKGGtheoSP = new JTextField("", 50);
        txtTimGGtheoSP = new JTextField("", 20);

        txtIDGGtheoSP.setBounds(150, 70, 220, 30);
        txtIDGGtheoSP.setEditable(false);
        txtTenGGtheoSP.setBounds(150, 120, 220, 30);
        dateTGBDGGtheoSP.setBounds(150, 170, 220, 30);
        dateTGKTGGtheoSP.setBounds(150, 220, 220, 30);
        txtNoiDungGGtheoSP.setBounds(590, 70, 220, 30);
        txtDKGGtheoSP.setBounds(590, 120, 220, 30);
        txtTimGGtheoSP.setBounds(590, 170, 220, 30);
        
        btnThemGGtheoSP = new JButton("Thêm");
        btnThemGGtheoSP.setBackground(new java.awt.Color(174, 234, 0));
        btnThemGGtheoSP.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemGGtheoSP.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnXoaGGtheoSP = new JButton("Xóa");
        btnXoaGGtheoSP.setBackground(new java.awt.Color(238, 238, 238));
        btnXoaGGtheoSP.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaGGtheoSP.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnXoaGGtheoSP.setEnabled(false);

        btnSuaGGtheoSP = new JButton("Sửa");
        btnSuaGGtheoSP.setBackground(new java.awt.Color(238, 238, 238));
        btnSuaGGtheoSP.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaGGtheoSP.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnSuaGGtheoSP.setEnabled(false);

        btnTimGGtheoSP = new JButton("Tìm");
        btnTimGGtheoSP.setBackground(new java.awt.Color(128, 222, 234));
        btnTimGGtheoSP.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimGGtheoSP.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        btnDocDLGGtheoSP = new JButton("Tải lại");
        btnDocDLGGtheoSP.setBackground(new java.awt.Color(178, 255, 89));
        btnDocDLGGtheoSP.setBorder(null);

        btnImportGGtheoSP = new JButton("Import");
        btnImportGGtheoSP.setBackground(new java.awt.Color(174, 234, 0));
        btnImportGGtheoSP.setBorder(null);

        btnExportGGtheoSP = new JButton("Export");
        btnExportGGtheoSP.setBackground(new java.awt.Color(178, 255, 89));
        btnExportGGtheoSP.setBorder(null);

        btnChiTietGGtheoSP = new JButton("Sửa chi tiết GG");
        btnChiTietGGtheoSP.setBackground(new java.awt.Color(174, 234, 0));
        btnChiTietGGtheoSP.setBorder(null);
        
        btnCopyIDGGtheoSP=new JButton("Chuyển đi");
        btnCopyIDGGtheoSP.setBackground(new java.awt.Color(174, 234, 0));
        btnCopyIDGGtheoSP.setBorder(null);

        btnThemGGtheoSP.setBounds(880, 70, 100, 30);
        btnSuaGGtheoSP.setBounds(880, 120, 100, 30);
        btnXoaGGtheoSP.setBounds(880, 220, 100, 30);
        btnTimGGtheoSP.setBounds(880, 170, 100, 30);
        btnDocDLGGtheoSP.setBounds(260, 270, 80, 30);
        btnImportGGtheoSP.setBounds(340, 270, 80, 30);
        btnExportGGtheoSP.setBounds(420, 270, 80, 30);
        btnChiTietGGtheoSP.setBounds(880, 270, 100, 30);
        //btnCopyIDGGtheoSP.setBounds(500, 270, 100, 30);

        String[] columnGGtheoSP
                = {"ID giảm giá(sản phẩm)", "Tên CT giảm giá", "Thời gian bắt đầu", "Thời gian kết thúc", "Điều kiện CTGG"};
        Object[][] dataGGtheoSP =null;
        modelGGtheoSP = new DefaultTableModel(dataGGtheoSP, columnGGtheoSP);
//		ArrayList<GiamGiaTheoSPDTO> dsGGtheoSP;
        tblGGtheoSP = new JTable(modelGGtheoSP) {
            //không cho edit khi double-click lên tableCell
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        TableRowSorter<TableModel> rowSorterGGtheoSP = new TableRowSorter<TableModel>(modelGGtheoSP);
        tblGGtheoSP.setRowSorter(rowSorterGGtheoSP);
        tblGGtheoSP.setBackground(Color.WHITE);
        tblGGtheoSP.setForeground(Color.BLACK);
        tblGGtheoSP.setRowHeight(25);
        tblGGtheoSP.setFont(new Font("Arial", NORMAL, 12));
        tblGGtheoSP.setBorder(null);
        tblGGtheoSP.setShowVerticalLines(false);
        tblGGtheoSP.setSelectionBackground(new java.awt.Color(67, 160, 71));
        //tblGGtheoSP.setSelectionForeground(new java.awt.Color(255, 255, 255));

        final JScrollPane scrollGGtheoSP = new JScrollPane(tblGGtheoSP);
        scrollGGtheoSP.setBounds(20, 310, 480, 340);
        pCTGG.add(scrollGGtheoSP);

        tblGGtheoSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblGGtheoSP.getColumnModel().getColumn(0).setPreferredWidth(160);
        tblGGtheoSP.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblGGtheoSP.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblGGtheoSP.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblGGtheoSP.getColumnModel().getColumn(4).setPreferredWidth(250);
        //tblGGtheoSP.getColumnModel().getColumn(5).setPreferredWidth(250);

        JTableHeader headerGGtheoSP = tblGGtheoSP.getTableHeader();
        headerGGtheoSP.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblGGtheoSP.getTableHeader().setForeground(Color.WHITE);
        tblGGtheoSP.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblGGtheoSP.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
//        =>bỏ viền header table

        //table chi tiết hóa đơn
        String[] columnCTGGtheoSP
                = {"ID giảm giá", "ID sản phẩm", "Nội dung"};
        Object[][] dataCTGGtheoSP =null;
        modelCTGGtheoSP = new DefaultTableModel(dataCTGGtheoSP, columnCTGGtheoSP);
        tblChiTietGGtheoSP = new JTable(modelCTGGtheoSP) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        TableRowSorter<TableModel> rowSorterCTGGtheoSP = new TableRowSorter<TableModel>(modelCTGGtheoSP);
        tblChiTietGGtheoSP.setRowSorter(rowSorterCTGGtheoSP);
        tblChiTietGGtheoSP.setBackground(Color.WHITE);
        tblChiTietGGtheoSP.setForeground(Color.BLACK);
        tblChiTietGGtheoSP.setRowHeight(25);
        tblChiTietGGtheoSP.setFont(new Font("Arial", NORMAL, 12));
        tblChiTietGGtheoSP.setBorder(null);
        tblChiTietGGtheoSP.setShowVerticalLines(false);
        tblChiTietGGtheoSP.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblChiTietGGtheoSP.setSelectionForeground(new java.awt.Color(255, 255, 255));

        final JScrollPane scrollCTGGtheoSP = new JScrollPane(tblChiTietGGtheoSP);
        scrollCTGGtheoSP.setBounds(520, 310, 460, 340);
        pCTGG.add(scrollCTGGtheoSP);

        tblChiTietGGtheoSP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblChiTietGGtheoSP.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblChiTietGGtheoSP.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblChiTietGGtheoSP.getColumnModel().getColumn(2).setPreferredWidth(150);

        JTableHeader headerCTGGtheoSP = tblChiTietGGtheoSP.getTableHeader();
        headerCTGGtheoSP.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblChiTietGGtheoSP.getTableHeader().setForeground(Color.WHITE);
        tblChiTietGGtheoSP.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblChiTietGGtheoSP.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        
        
        pCTGG.add(lbIDGGtheoSP);
        pCTGG.add(lbTenGGtheoSP);
        pCTGG.add(lbTGBDGGtheoSP);
        pCTGG.add(lbTGKTGGtheoSP);
        pCTGG.add(lbNoiDungGGtheoSP);
        pCTGG.add(lbDKGGtheoSP);
        pCTGG.add(lbTimGGtheoSP);
        pCTGG.add(lbDSGGtheoSP);
        
        pCTGG.add(txtIDGGtheoSP);
        pCTGG.add(txtTenGGtheoSP);
        pCTGG.add(dateTGBDGGtheoSP);
        pCTGG.add(dateTGKTGGtheoSP);
        pCTGG.add(txtNoiDungGGtheoSP);
        pCTGG.add(txtDKGGtheoSP);
        pCTGG.add(txtTimGGtheoSP);
        
        pCTGG.add(btnThemGGtheoSP);
        pCTGG.add(btnXoaGGtheoSP);
        pCTGG.add(btnSuaGGtheoSP);
        pCTGG.add(btnTimGGtheoSP);
        pCTGG.add(btnDocDLGGtheoSP);
        pCTGG.add(btnImportGGtheoSP);
        pCTGG.add(btnExportGGtheoSP);
        pCTGG.add(btnChiTietGGtheoSP);
        pCTGG.add(btnCopyIDGGtheoSP);
        
        final FrameChiTietGGtheoSP frmChiTietGGtheoSP = new FrameChiTietGGtheoSP();
        frmChiTietGGtheoSP.btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frmChiTietGGtheoSP.setVisible(false);
            }
        });
        
        
        // lắng nghe sự kiện 
        docCTGGtheoSP();
        
        tblChiTietGGtheoSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int i = tblChiTietGGtheoSP.getSelectedRow();
                if (i >= 0) {
                    frmChiTietGGtheoSP.txtIDGG.setText(tblChiTietGGtheoSP.getModel().getValueAt(i, 0).toString());
                    frmChiTietGGtheoSP.txtIDSP.setText(tblChiTietGGtheoSP.getModel().getValueAt(i, 1).toString());
                    frmChiTietGGtheoSP.txtNoiDung.setText(tblChiTietGGtheoSP.getModel().getValueAt(i, 2).toString());
                }
            }
        });
        
        frmChiTietGGtheoSP.btnThem.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                ChiTietKM_DTO ctkm_dto=new ChiTietKM_DTO();
                ctkm_dto.setIdKM(Integer.parseInt(frmChiTietGGtheoSP.txtIDGG.getText()));
                ctkm_dto.setIdSP(Integer.parseInt(frmChiTietGGtheoSP.txtIDSP.getText()));
                ctkm_dto.setNoidungGG(Double.parseDouble(frmChiTietGGtheoSP.txtNoiDung.getText()));
                ChiTietKM_BUS bus=new ChiTietKM_BUS();
                try 
                {
                    bus.Insert(ctkm_dto);
                } catch (Exception ex) 
                {
                    Logger.getLogger(FrameChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
                Vector row=new Vector ();
                row.add(ctkm_dto.getIdKM());
                row.add(ctkm_dto.getIdSP());
                row.add(ctkm_dto.getNoidungGG());
                modelCTGGtheoSP.addRow(row);
            }
        });
        
        btnChiTietGGtheoSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frmChiTietGGtheoSP.setVisible(true);
            }
        });
        
        
        //CHỌN LOẠI GIẢM GIÁ
        lbIDGGtheoSP.setVisible(false);
        lbTenGGtheoSP.setVisible(false);
        lbTGBDGGtheoSP.setVisible(false);
        lbTGKTGGtheoSP.setVisible(false);
        lbNoiDungGGtheoSP.setVisible(false);
        lbDKGGtheoSP.setVisible(false);
        lbTimGGtheoSP.setVisible(false);
        lbDSGGtheoSP.setVisible(false);

        txtIDGGtheoSP.setVisible(false);
        txtTenGGtheoSP.setVisible(false);
        txtNoiDungGGtheoSP.setVisible(false);
        txtDKGGtheoSP.setVisible(false);
        txtTimGGtheoSP.setVisible(false);

        dateTGBDGGtheoSP.setVisible(false);
        dateTGKTGGtheoSP.setVisible(false);

        btnThemGGtheoSP.setVisible(false);
        btnXoaGGtheoSP.setVisible(false);
        btnTimGGtheoSP.setVisible(false);
        btnImportGGtheoSP.setVisible(false);
        btnExportGGtheoSP.setVisible(false);
        btnDocDLGGtheoSP.setVisible(false);
        btnChiTietGGtheoSP.setVisible(false);
                
        tblGGtheoSP.setVisible(false);
        scrollGGtheoSP.setVisible(false);
        scrollCTGGtheoSP.setVisible(false);
        
        btnGGtheoHD.setFocusPainted(false);
        btnGGtheoSP.setFocusPainted(false);
        btnGGtheoHD.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(118, 255, 3)));
        btnGGtheoHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnGGtheoHD.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(118, 255, 3)));
                btnGGtheoSP.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(118, 255, 3)));
                lbIDGGtheoHD.setVisible(true);
                lbTenGGtheoHD.setVisible(true);
                lbTGBDGGtheoHD.setVisible(true);
                lbTGKTGGtheoHD.setVisible(true);
                lbNoiDungGGtheoHD.setVisible(true);
                lbDKGGtheoHD.setVisible(true);
                lbTimGGtheoHD.setVisible(true);
                lbDSGGtheoHD.setVisible(true);
                
                txtIDGGtheoHD.setVisible(true);
                txtTenGGtheoHD.setVisible(true);
                txtNoiDungGGtheoHD.setVisible(true);
                txtDKGGtheoHD.setVisible(true);
                txtTimGGtheoHD.setVisible(true);
                
                dateTGBDGGtheoHD.setVisible(true);
                dateTGKTGGtheoHD.setVisible(true);
                
                btnThemGGtheoHD.setVisible(true);
                btnXoaGGtheoHD.setVisible(true);
                btnSuaGGtheoHD.setVisible(true);
                btnTimGGtheoHD.setVisible(true);
                btnImportGGtheoHD.setVisible(true);
                btnExportGGtheoHD.setVisible(true);
                btnDocDLGGtheoHD.setVisible(true);
                
                
                tblGGtheoHD.setVisible(true);
                scrollGGtheoHD.setVisible(true);
                //
                lbIDGGtheoSP.setVisible(false);
                lbTenGGtheoSP.setVisible(false);
                lbTGBDGGtheoSP.setVisible(false);
                lbTGKTGGtheoSP.setVisible(false);
                lbNoiDungGGtheoSP.setVisible(false);
                lbDKGGtheoSP.setVisible(false);
                lbTimGGtheoSP.setVisible(false);
                lbDSGGtheoSP.setVisible(false);
                
                txtIDGGtheoSP.setVisible(false);
                txtTenGGtheoSP.setVisible(false);
                txtNoiDungGGtheoSP.setVisible(false);
                txtDKGGtheoSP.setVisible(false);
                txtTimGGtheoSP.setVisible(false);
                
                dateTGBDGGtheoSP.setVisible(false);
                dateTGKTGGtheoSP.setVisible(false);
                
                btnThemGGtheoSP.setVisible(false);
                btnXoaGGtheoSP.setVisible(false);
                btnTimGGtheoSP.setVisible(false);
                btnImportGGtheoSP.setVisible(false);
                btnExportGGtheoSP.setVisible(false);
                btnDocDLGGtheoSP.setVisible(false);
                btnChiTietGGtheoSP.setVisible(false);
                
                tblGGtheoSP.setVisible(false);
                scrollGGtheoSP.setVisible(false);
                scrollCTGGtheoSP.setVisible(false);
            }
        });
        
        btnGGtheoSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                btnGGtheoSP.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(118, 255, 3)));
                btnGGtheoHD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(118, 255, 3)));
                
                lbIDGGtheoHD.setVisible(false);
                lbTenGGtheoHD.setVisible(false);
                lbTGBDGGtheoHD.setVisible(false);
                lbTGKTGGtheoHD.setVisible(false);
                lbNoiDungGGtheoHD.setVisible(false);
                lbDKGGtheoHD.setVisible(false);
                lbTimGGtheoHD.setVisible(false);
                lbDSGGtheoHD.setVisible(false);
                
                txtIDGGtheoHD.setVisible(false);
                txtTenGGtheoHD.setVisible(false);
                txtNoiDungGGtheoHD.setVisible(false);
                txtDKGGtheoHD.setVisible(false);
                txtTimGGtheoHD.setVisible(false);
                
                dateTGBDGGtheoHD.setVisible(false);
                dateTGKTGGtheoHD.setVisible(false);
                
                btnThemGGtheoHD.setVisible(false);
                btnXoaGGtheoHD.setVisible(false);
                btnSuaGGtheoHD.setVisible(false);
                btnTimGGtheoHD.setVisible(false);
                btnImportGGtheoHD.setVisible(false);
                btnExportGGtheoHD.setVisible(false);
                btnDocDLGGtheoHD.setVisible(false);
                
                tblGGtheoHD.setVisible(false);
                scrollGGtheoHD.setVisible(false);
                //
                lbIDGGtheoSP.setVisible(true);
                lbTenGGtheoSP.setVisible(true);
                lbTGBDGGtheoSP.setVisible(true);
                lbTGKTGGtheoSP.setVisible(true);
                lbNoiDungGGtheoSP.setVisible(true);
                lbDKGGtheoSP.setVisible(true);
                lbTimGGtheoSP.setVisible(true);
                lbDSGGtheoSP.setVisible(true);
                
                txtIDGGtheoSP.setVisible(true);
                txtTenGGtheoSP.setVisible(true);
                txtNoiDungGGtheoSP.setVisible(true);
                txtDKGGtheoSP.setVisible(true);
                txtTimGGtheoSP.setVisible(true);
                
                dateTGBDGGtheoSP.setVisible(true);
                dateTGKTGGtheoSP.setVisible(true);
                
                btnThemGGtheoSP.setVisible(true);
                btnXoaGGtheoSP.setVisible(true);
                btnTimGGtheoSP.setVisible(true);
                btnImportGGtheoSP.setVisible(true);
                btnExportGGtheoSP.setVisible(true);
                btnDocDLGGtheoSP.setVisible(true);
                btnChiTietGGtheoSP.setVisible(true);
                
                tblGGtheoSP.setVisible(true);
                scrollGGtheoSP.setVisible(true);
                scrollCTGGtheoSP.setVisible(true);
            }
        });
        
        tblGGtheoSP.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int i=tblGGtheoSP.getSelectedRow();
                if (i>=0)
                {
                    txtIDGGtheoSP.setText(tblGGtheoSP.getModel().getValueAt(i, 0).toString());
                    txtTenGGtheoSP.setText(tblGGtheoSP.getModel().getValueAt(i, 1).toString());
                    String tempGGtheoSP=tblGGtheoSP.getModel().getValueAt(i, 2).toString();
                    SimpleDateFormat dateFormatGGtheoSP=new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        dateTGBDGGtheoSP.setDate(dateFormatGGtheoSP.parse(tempGGtheoSP));
                    } catch (ParseException ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        dateTGKTGGtheoSP.setDate(dateFormatGGtheoSP.parse(tempGGtheoSP));
                    } catch (ParseException ex) {
                        Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    txtNoiDungGGtheoSP.setText("0.0");
                    txtDKGGtheoSP.setText(tblGGtheoSP.getModel().getValueAt(i, 4).toString());
                    frmChiTietGGtheoSP.txtIDGG.setText(tblGGtheoSP.getModel().getValueAt(i, 0).toString());
                    modelCTGGtheoSP.setRowCount(0);
                    docCTGG(Integer.parseInt(txtIDGGtheoSP.getText()));
                }
            }
        });
        
        btnDocDLGGtheoHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                txtIDGGtheoHD.setText("");
                txtTenGGtheoHD.setText("");
                txtNoiDungGGtheoHD.setText("");
                txtDKGGtheoHD.setText("");
                for (int i=0;i<KhuyenMaiBUS.danhsach_kmHD.size();i++)
                {
                    modelGGtheoHD.removeRow(0);
                }
                docCTGGtheoHD();
            }
        });
        
        btnDocDLGGtheoSP.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                txtIDGGtheoSP.setText("");
                txtTenGGtheoSP.setText("");
                txtNoiDungGGtheoSP.setText("");
                txtDKGGtheoSP.setText("");
                for (int i=0;i<KhuyenMaiBUS.danhsach_kmSP.size();i++)
                {
                    modelGGtheoSP.removeRow(0);
                }
                docCTGGtheoSP();
            }
        });
        
        btnThemGGtheoHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                KhuyenMaiDTO km_dto=new KhuyenMaiDTO();
                KhuyenMaiBUS km_bus=new KhuyenMaiBUS();
                km_bus.getDSKM();
                int tempIDKM=0;
                for (KhuyenMaiDTO km2 : KhuyenMaiBUS.danhsachdaydu)
                {
                    tempIDKM=km2.getIdKM();
                }
                km_dto.setIdKM(tempIDKM+1);
                km_dto.setTenKM(txtTenGGtheoHD.getText());
                km_dto.setNoidungGG(Double.parseDouble(txtNoiDungGGtheoHD.getText()));
                km_dto.setLoaiCT(1);
                km_dto.setDieukienGG(Double.parseDouble(txtDKGGtheoHD.getText()));
                String tempGG="dd/MM/yyyy";
                DateFormat dateFormat=new SimpleDateFormat(tempGG);
                km_dto.setNgayBD(dateFormat.format(dateTGBDGGtheoHD.getDate()));
                km_dto.setNgayKT(dateFormat.format(dateTGKTGGtheoHD.getDate()));
                //KhuyenMaiBUS km_bus=new KhuyenMaiBUS();
                try {
                    km_bus.Insert(km_dto);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i=0;i<KhuyenMaiBUS.danhsach_kmHD.size();i++)
                {
                    modelGGtheoHD.removeRow(0);
                }
                docCTGGtheoHD();
            }
        });
        
        btnThemGGtheoSP.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                KhuyenMaiDTO km_dto=new KhuyenMaiDTO();
                KhuyenMaiBUS km_bus=new KhuyenMaiBUS();
                km_bus.getDSKM();
                int tempIDKM=0;
                for (KhuyenMaiDTO km2 : KhuyenMaiBUS.danhsachdaydu)
                {
                    tempIDKM=km2.getIdKM();
                }
                km_dto.setIdKM(tempIDKM+1);
                km_dto.setTenKM(txtTenGGtheoSP.getText());
                km_dto.setNoidungGG(0);
                km_dto.setLoaiCT(2);
                km_dto.setDieukienGG(0);
                String tempGG="dd/MM/yyyy";
                DateFormat dateFormat=new SimpleDateFormat(tempGG);
                km_dto.setNgayBD(dateFormat.format(dateTGBDGGtheoHD.getDate()));
                km_dto.setNgayKT(dateFormat.format(dateTGKTGGtheoHD.getDate()));
                //KhuyenMaiBUS km_bus=new KhuyenMaiBUS();
                try {
                    km_bus.Insert(km_dto);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int j=0;j<KhuyenMaiBUS.danhsach_kmSP.size();j++)
                {
                    modelGGtheoSP.removeRow(0);
                }
                docCTGGtheoSP();
            }
        });
        // add danh mục chức năng vào hướng tây                
        
        //Panel chương trình khuyến mãi end        
    }
    private void docCTGGtheoSP ()
    {
        KhuyenMaiBUS bus=new KhuyenMaiBUS ();
        bus.getDSKMloai2();
        for (KhuyenMaiDTO ctgg_dto : KhuyenMaiBUS.danhsach_kmSP)
        {
            Vector row=new Vector ();
            row.add(ctgg_dto.getIdKM());
            row.add(ctgg_dto.getTenKM());
            //row.add(ctgg_dto.getLoaiCT());
            row.add(ctgg_dto.getNgayBD());
            row.add(ctgg_dto.getNgayKT());
            row.add(ctgg_dto.getDieukienGG());
            modelGGtheoSP.addRow(row);
        }
    }
    private void docCTGGtheoHD ()
    {
        KhuyenMaiBUS bus=new KhuyenMaiBUS ();
        bus.getDSKMloai1();
        for (KhuyenMaiDTO ctgg_dto : KhuyenMaiBUS.danhsach_kmHD)
        {
            Vector row=new Vector ();
            row.add(ctgg_dto.getIdKM());
            row.add(ctgg_dto.getTenKM());
            //row.add(ctgg_dto.getLoaiCT());
            row.add(ctgg_dto.getNgayBD());
            row.add(ctgg_dto.getNgayKT());
            row.add(ctgg_dto.getNoidungGG());
            row.add(ctgg_dto.getDieukienGG());
            modelGGtheoHD.addRow(row);
        }
    }
    private void docCTGG (int idGG)
    {
        ChiTietKM_BUS bus=new ChiTietKM_BUS();
        bus.getDSCTKM(idGG);
        for (ChiTietKM_DTO ct_dto : ChiTietKM_BUS.danhsach_ctkm)
        {
            Vector row=new Vector();
            row.add(ct_dto.getIdKM());
            row.add(ct_dto.getIdSP());
            row.add(ct_dto.getNoidungGG());
            modelCTGGtheoSP.addRow(row);
        }
    }
    
    private void quanlynhanvien() {  //=====================================================================NHANVIEN

        lbNV = new JLabel("   Quản lý nhân viên", JLabel.LEFT);
        lbNV.setOpaque(true);
        lbNV.setBounds(0, 300, 200, 50);
        lbNV.setBackground(new java.awt.Color(67, 160, 71));
        lbNV.setForeground(Color.WHITE);
        lbNV.setFont(new Font("Arial", NORMAL, 14));
        lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        pW.add(lbNV);
        try {
            BufferedImage imgNV = ImageIO.read(new File("src/img/NV.png"));
            ImageIcon iconNV = new ImageIcon(imgNV.getScaledInstance(25, 25, imgNV.SCALE_SMOOTH));
            lbNV.setIcon(iconNV);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        //Phân quyền
        if (General.CURRENT_ROLE == 2){
            lbNV.setEnabled(false);
            lbNV = new JLabel("   Quản lý nhân viên", JLabel.LEFT);
            lbNV.setBounds(0, 300, 200, 50);
            lbNV.setBackground(new java.awt.Color(67, 160, 71));
            lbNV.setForeground(Color.WHITE);
            lbNV.setFont(new Font("Arial", NORMAL, 14));
            lbNV.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 0, Color.WHITE));
        }
        
        lbNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbNV.setBackground(new java.awt.Color(129, 199, 132));
                lbNV.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbNV.setBackground(new java.awt.Color(67, 160, 71));
                lbNV.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(false);
                pPN.setVisible(false);
                pNV.setVisible(true);
                pKH.setVisible(false);
                pSP.setVisible(false);
                pHD.setVisible(false);
                pCTGG.setVisible(false);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbKH.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
            }
        });

        String[] columnNV = {"ID", "Họ", "Tên", "Số điện thoại", "Mail", "Giới tính", "Chức vụ"};

        DefaultTableModel modelNV = new DefaultTableModel(columnNV, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        pNV = new JPanel();
        pNV.setLayout(null);
        pNV.setBackground(Color.WHITE);
        pNV.setBounds(0, 0, 1000, 660);
        pCT.add(pNV);
        pNV.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pNV.setVisible(false);

        lbIDNV = new JLabel("ID nhân viên");
        lbHoNV = new JLabel("Họ nhân viên");
        lbTenNV = new JLabel("Tên nhân viên");
        lbSDTNV = new JLabel("SĐT nhân viên");
        lbMailNV = new JLabel("Mail nhân viên");
        lbGioiTinhNV = new JLabel("Giới tính nhân viên");
        lbChucVuNV = new JLabel("Chức vụ nhân viên");
        lbTimNV = new JLabel("Tìm");
        lbDSNV = new JLabel("DANH SÁCH NHÂN VIÊN");

        lbIDNV.setBounds(20, 20, 120, 30);
        lbHoNV.setBounds(20, 70, 120, 30);
        lbTenNV.setBounds(20, 120, 120, 30);
        lbSDTNV.setBounds(20, 170, 120, 30);
        lbMailNV.setBounds(460, 20, 120, 30);
        lbGioiTinhNV.setBounds(460, 70, 120, 30);
        lbChucVuNV.setBounds(460, 120, 120, 30);
        lbTimNV.setBounds(460, 170, 30, 30);
        lbDSNV.setBounds(20, 220, 400, 30);
        lbDSNV.setForeground(new java.awt.Color(51, 105, 30));
        lbDSNV.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromNV[] = {"ID", "Họ", "Tên", "SĐT", "Mail", "GT", "Chức vụ"};
        JComboBox cbNV = new JComboBox(findfromNV);
        cbNV.setBounds(490, 170, 90, 30);
        cbNV.setBorder(null);
        cbNV.setBackground(new java.awt.Color(128, 222, 234));
        cbNV.setForeground(Color.WHITE);
        pNV.add(cbNV);

        txtIDNV = new JTextField("", 20);
        txtHoNV = new JTextField("", 20);
        txtTenNV = new JTextField("", 20);
        txtSDTNV = new JTextField("", 20);
        txtMailNV = new JTextField("", 20);
        txtGioiTinhNV = new JTextField("", 20);
        txtChucVuNV = new JTextField("", 20);
        txtTimNV = new JTextField("", 30);

        txtIDNV.setBounds(150, 20, 220, 30);
        txtHoNV.setBounds(150, 70, 220, 30);
        txtTenNV.setBounds(150, 120, 220, 30);
        txtSDTNV.setBounds(150, 170, 220, 30);
        txtMailNV.setBounds(590, 20, 220, 30);
        txtGioiTinhNV.setBounds(590, 70, 220, 30);
        txtChucVuNV.setBounds(590, 120, 220, 30);
        txtTimNV.setBounds(590, 170, 220, 30);

        //Ko cho nhập id
        txtIDNV.setEditable(false);

        btnThemNV = new JButton("Thêm");
        btnThemNV.setBackground(new java.awt.Color(174, 234, 0));
        btnThemNV.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemNV.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnThemNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhanvienBUS bus = new NhanvienBUS();
                bus.getDSNhanviendaydu();
                int i = NhanvienBUS.danhsachdaydu.size() - 1;
                NhanvienDTO temp = NhanvienBUS.danhsachdaydu.get(i);
                int temp2 = Integer.parseInt(temp.getId()) + 1;
                String k = String.valueOf(temp2);
                txtIDNV.setText(k);

                //===== Check xem có hợp lệ =====//
                //Check họ
                if (KT.soN(txtHoNV.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Họ phải là chữ !");
                    return;
                }
                //Check tên
                if (KT.soN(txtTenNV.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Tên phải là chữ !");
                    return;
                }
                //Check số điện thoại
                if (KT.soN(txtSDTNV.getText()) == false || txtSDTNV.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "SĐT phải là số và bằng 10 số");
                    return;
                }
                //Check mail
                if (KT.ktemail(txtMailNV.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Mail không hợp lệ");
                    return;
                }
                //Check giới tính
                if (KT.soN(txtGioiTinhNV.getText()) == true || txtGioiTinhNV.getText().length() > 4) {
                    JOptionPane.showMessageDialog(null, "Giới tính phải là chữ và ít hơn hoặc bằng 3 từ");
                    return;
                }
                //Check chức vụ
                if (KT.soN(txtChucVuNV.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Chức vụ phải là chữ !");
                    return;
                }
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(txtIDNV.getText());
                nv_dto.setHo(txtHoNV.getText());
                nv_dto.setTen(txtTenNV.getText());
                nv_dto.setSdt(txtSDTNV.getText());
                nv_dto.setMail(txtMailNV.getText());
                nv_dto.setGioitinh(txtGioiTinhNV.getText());
                nv_dto.setChucvu(txtChucVuNV.getText());
                try {
                    bus.Insert(nv_dto);
                    Vector row = new Vector();
                    row.add(nv_dto.getId());
                    row.add(nv_dto.getHo());
                    row.add(nv_dto.getTen());
                    row.add(nv_dto.getSdt());
                    row.add(nv_dto.getMail());
                    row.add(nv_dto.getGioitinh());
                    row.add(nv_dto.getChucvu());
                    modelNV.addRow(row);
                    tblNV.setModel(modelNV);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnXoaNV = new JButton("Xóa");
        btnXoaNV.setBackground(new java.awt.Color(255, 82, 82));
        btnXoaNV.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaNV.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnXoaNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tblNV.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại !");
                    return;
                }
                NhanvienBUS bus = new NhanvienBUS();
                try {
                    bus.Delete2(txtIDNV.getText(), tblNV.getSelectedRow());
                    modelNV.removeRow(tblNV.getSelectedRow());
                    tblNV.setModel(modelNV);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnSuaNV = new JButton("Sửa");
        btnSuaNV.setBackground(new java.awt.Color(238, 255, 65));
        btnSuaNV.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaNV.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnSuaNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblNV.getSelectedRow();
                //===== Check xem có hợp lệ =====//
                //Check họ
                if (KT.soN(txtHoNV.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Họ phải là chữ !");
                    return;
                }
                //Check tên
                if (KT.soN(txtTenNV.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Tên phải là chữ !");
                    return;
                }
                //Check số điện thoại
                if (KT.soN(txtSDTNV.getText()) == false || txtSDTNV.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "SĐT phải là số và bằng 10 số");
                    return;
                }
                //Check mail
                if (KT.ktemail(txtMailNV.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Mail không hợp lệ");
                    return;
                }
                //Check giới tính
                if (KT.soN(txtGioiTinhNV.getText()) == true || txtGioiTinhNV.getText().length() > 4) {
                    JOptionPane.showMessageDialog(null, "Giới tính phải là chữ và ít hơn hoặc bằng 3 từ");
                    return;
                }
                //Check chức vụ
                if (KT.soN(txtChucVuNV.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Chức vụ phải là chữ !");
                    return;
                }
                NhanvienDTO nv_dto = new NhanvienDTO();
                nv_dto.setId(txtIDNV.getText());
                nv_dto.setHo(txtHoNV.getText());
                nv_dto.setTen(txtTenNV.getText());
                nv_dto.setSdt(txtSDTNV.getText());
                nv_dto.setMail(txtMailNV.getText());
                nv_dto.setGioitinh(txtGioiTinhNV.getText());
                nv_dto.setChucvu(txtChucVuNV.getText());
                NhanvienBUS bus = new NhanvienBUS();
                try {
                    bus.Update(nv_dto);
                    modelNV.setValueAt(nv_dto.getHo(), i, 1);
                    modelNV.setValueAt(nv_dto.getTen(), i, 2);
                    modelNV.setValueAt(nv_dto.getSdt(), i, 3);
                    modelNV.setValueAt(nv_dto.getMail(), i, 4);
                    modelNV.setValueAt(nv_dto.getGioitinh(), i, 5);
                    modelNV.setValueAt(nv_dto.getChucvu(), i, 6);
                    tblNV.setModel(modelNV);
                    JOptionPane.showMessageDialog(null, "Sửa thành công !");
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnTimNV = new JButton("Tìm");
        btnTimNV.setBackground(new java.awt.Color(128, 222, 234));
        btnTimNV.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimNV.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnTimNV.addActionListener(new ActionListener() //Tìm kiếm trong nhân viên
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Vector header = new Vector();
                header.add("Id nv");
                header.add("Họ nv");
                header.add("Tên nv");
                header.add("Sdt nv");
                header.add("Mail nv");
                header.add("Gioitinh nv");
                header.add("Chucvu nv");
                switch (cbNV.getSelectedIndex()) 
                {
                    case 0: //Tìm theo id
                    {
                        //Làm cho table NV trống rỗng
                        for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                            modelNV.removeRow(0);
                        }
                        ArrayList<NhanvienDTO> temp = null;
                        NhanvienDAO nv_dao = new NhanvienDAO();
                        try {
                            temp = nv_dao.SearchDSNV2(txtTimNV.getText());
                            NhanvienBUS.danhsach_nv = nv_dao.SearchDSNV2(txtTimNV.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (NhanvienDTO nv_dto : temp) {
                            Vector row = new Vector();
                            row.add(nv_dto.getId());
                            row.add(nv_dto.getHo());
                            row.add(nv_dto.getTen());
                            row.add(nv_dto.getSdt());
                            row.add(nv_dto.getMail());
                            row.add(nv_dto.getGioitinh());
                            row.add(nv_dto.getChucvu());
                            modelNV.addRow(row);
                        }
                        tblNV.setModel(modelNV);

                        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 1: //Tìm theo Họ
                    {
                        //Làm cho table NV trống rỗng
                        for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                            modelNV.removeRow(0);
                        }
                        ArrayList<NhanvienDTO> temp = null;
                        NhanvienDAO nv_dao = new NhanvienDAO();
                        try {
                            temp = nv_dao.SearchDSNV3(txtTimNV.getText());
                            NhanvienBUS.danhsach_nv = nv_dao.SearchDSNV3(txtTimNV.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (NhanvienDTO nv_dto : temp) {
                            Vector row = new Vector();
                            row.add(nv_dto.getId());
                            row.add(nv_dto.getHo());
                            row.add(nv_dto.getTen());
                            row.add(nv_dto.getSdt());
                            row.add(nv_dto.getMail());
                            row.add(nv_dto.getGioitinh());
                            row.add(nv_dto.getChucvu());
                            modelNV.addRow(row);
                        }
                        tblNV.setModel(modelNV);

                        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 2: //Tìm theo tên
                    {
                        //Làm cho table NV trống rỗng
                        for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                            modelNV.removeRow(0);
                        }
                        ArrayList<NhanvienDTO> temp = null;
                        NhanvienDAO nv_dao = new NhanvienDAO();
                        try {
                            temp = nv_dao.SearchDSNV4(txtTimNV.getText());
                            NhanvienBUS.danhsach_nv = nv_dao.SearchDSNV4(txtTimNV.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (NhanvienDTO nv_dto : temp) {
                            Vector row = new Vector();
                            row.add(nv_dto.getId());
                            row.add(nv_dto.getHo());
                            row.add(nv_dto.getTen());
                            row.add(nv_dto.getSdt());
                            row.add(nv_dto.getMail());
                            row.add(nv_dto.getGioitinh());
                            row.add(nv_dto.getChucvu());
                            modelNV.addRow(row);
                        }
                        tblNV.setModel(modelNV);

                        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 3: //Tìm theo Số điện thoại
                    {
                        //Làm cho table NV trống rỗng
                        for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                            modelNV.removeRow(0);
                        }
                        ArrayList<NhanvienDTO> temp = null;
                        NhanvienDAO nv_dao = new NhanvienDAO();
                        try {
                            temp = nv_dao.SearchDSNV5(txtTimNV.getText());
                            NhanvienBUS.danhsach_nv = nv_dao.SearchDSNV5(txtTimNV.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (NhanvienDTO nv_dto : temp) {
                            Vector row = new Vector();
                            row.add(nv_dto.getId());
                            row.add(nv_dto.getHo());
                            row.add(nv_dto.getTen());
                            row.add(nv_dto.getSdt());
                            row.add(nv_dto.getMail());
                            row.add(nv_dto.getGioitinh());
                            row.add(nv_dto.getChucvu());
                            modelNV.addRow(row);
                        }
                        tblNV.setModel(modelNV);

                        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 4: //Tìm theo Mail
                    {
                        //Làm cho table NV trống rỗng
                        for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                            modelNV.removeRow(0);
                        }
                        ArrayList<NhanvienDTO> temp = null;
                        NhanvienDAO nv_dao = new NhanvienDAO();
                        try {
                            temp = nv_dao.SearchDSNV6(txtTimNV.getText());
                            NhanvienBUS.danhsach_nv = nv_dao.SearchDSNV6(txtTimNV.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (NhanvienDTO nv_dto : temp) {
                            Vector row = new Vector();
                            row.add(nv_dto.getId());
                            row.add(nv_dto.getHo());
                            row.add(nv_dto.getTen());
                            row.add(nv_dto.getSdt());
                            row.add(nv_dto.getMail());
                            row.add(nv_dto.getGioitinh());
                            row.add(nv_dto.getChucvu());
                            modelNV.addRow(row);
                        }
                        tblNV.setModel(modelNV);

                        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 5: //Tìm theo giới tính
                    {
                        //Làm cho table NV trống rỗng
                        for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                            modelNV.removeRow(0);
                        }
                        ArrayList<NhanvienDTO> temp = null;
                        NhanvienDAO nv_dao = new NhanvienDAO();
                        try {
                            temp = nv_dao.SearchDSNV7(txtTimNV.getText());
                            NhanvienBUS.danhsach_nv = nv_dao.SearchDSNV7(txtTimNV.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (NhanvienDTO nv_dto : temp) {
                            Vector row = new Vector();
                            row.add(nv_dto.getId());
                            row.add(nv_dto.getHo());
                            row.add(nv_dto.getTen());
                            row.add(nv_dto.getSdt());
                            row.add(nv_dto.getMail());
                            row.add(nv_dto.getGioitinh());
                            row.add(nv_dto.getChucvu());
                            modelNV.addRow(row);
                        }
                        tblNV.setModel(modelNV);

                        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 6: //Tìm theo chức vụ
                    {
                        //Làm cho table NV trống rỗng
                        for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                            modelNV.removeRow(0);
                        }
                        ArrayList<NhanvienDTO> temp = null;
                        NhanvienDAO nv_dao = new NhanvienDAO();
                        try {
                            temp = nv_dao.SearchDSNV8(txtTimNV.getText());
                            NhanvienBUS.danhsach_nv = nv_dao.SearchDSNV8(txtTimNV.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (NhanvienDTO nv_dto : temp) {
                            Vector row = new Vector();
                            row.add(nv_dto.getId());
                            row.add(nv_dto.getHo());
                            row.add(nv_dto.getTen());
                            row.add(nv_dto.getSdt());
                            row.add(nv_dto.getMail());
                            row.add(nv_dto.getGioitinh());
                            row.add(nv_dto.getChucvu());
                            modelNV.addRow(row);
                        }
                        tblNV.setModel(modelNV);

                        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                }
            }
        });
        
        
        btnDocDLNV = new JButton("Tải lại");
        btnDocDLNV.setBackground(new java.awt.Color(178, 255, 89));
        btnDocDLNV.setBorder(null);
        //Tải dữ liệu lên table
        NhanvienBUS bus = new NhanvienBUS();
        bus.getDSNhanvien();
        Vector header = new Vector();
        header.add("Id nv");
        header.add("Họ nv");
        header.add("Tên nv");
        header.add("Sdt nv");
        header.add("Mail nv");
        header.add("Gioitinh nv");
        header.add("Chucvu nv");
        for (NhanvienDTO nv_dto : NhanvienBUS.danhsach_nv) {
            Vector row = new Vector();
            row.add(nv_dto.getId());
            row.add(nv_dto.getHo());
            row.add(nv_dto.getTen());
            row.add(nv_dto.getSdt());
            row.add(nv_dto.getMail());
            row.add(nv_dto.getGioitinh());
            row.add(nv_dto.getChucvu());
            modelNV.addRow(row);
        }

        btnDocDLNV.addActionListener(new ActionListener()//Nút tải db
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIDNV.setText("");
                txtIDNV.setEditable(false);
                txtHoNV.setText("");
                txtTenNV.setText("");
                txtSDTNV.setText("");
                txtMailNV.setText("");
                txtGioiTinhNV.setText("");
                txtChucVuNV.setText("");
                for (int i = 0; i < NhanvienBUS.danhsach_nv.size(); i++) {
                    modelNV.removeRow(0);
                }
                NhanvienBUS bus = new NhanvienBUS();
                bus.getDSNhanvien();
                Vector header = new Vector();
                header.add("Id nv");
                header.add("Họ nv");
                header.add("Tên nv");
                header.add("Sdt nv");
                header.add("Mail nv");
                header.add("Gioitinh nv");
                header.add("Chucvu nv");
                for (NhanvienDTO nv_dto : NhanvienBUS.danhsach_nv) {
                    Vector row = new Vector();
                    row.add(nv_dto.getId());
                    row.add(nv_dto.getHo());
                    row.add(nv_dto.getTen());
                    row.add(nv_dto.getSdt());
                    row.add(nv_dto.getMail());
                    row.add(nv_dto.getGioitinh());
                    row.add(nv_dto.getChucvu());
                    modelNV.addRow(row);
                }
            }
        });

        btnImportNV = new JButton("Import");
        btnImportNV.setBackground(new java.awt.Color(174, 234, 0));
        btnImportNV.setBorder(null);        
        
        btnExportNV = new JButton("Export");
        btnExportNV.setBackground(new java.awt.Color(178, 255, 89));
        btnExportNV.setBorder(null);
        btnExportNV.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                XSSFWorkbook workbook=new XSSFWorkbook();
                XSSFSheet sheet=workbook.createSheet("NhanVien");                
                XSSFRow row=null;
                XSSFCell cell =null;
                
                row =sheet.createRow(0);
                
                cell=row.createCell(0);
                cell.setCellValue("id_nv");                
                cell=row.createCell(1);
                cell.setCellValue("ho_nv");               
                cell=row.createCell(2);
                cell.setCellValue("ten_nv");               
                cell=row.createCell(3);
                cell.setCellValue("sdt_nv");               
                cell=row.createCell(4);
                cell.setCellValue("mail_nv");                
                cell=row.createCell(5);
                cell.setCellValue("gioitinh_nv");               
                cell=row.createCell(6);
                cell.setCellValue("chucvu_nv");
                
                if(NhanvienBUS.danhsach_nv != null)
                {
                    int x = NhanvienBUS.danhsach_nv.size();
                    for (int i = 0; i < x; i++) 
                    {
                        NhanvienDTO nv_dto = NhanvienBUS.danhsach_nv.get(i);                        
                        row = sheet.createRow(2 + i);                        
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(nv_dto.getId());                        
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(nv_dto.getHo());                        
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(nv_dto.getTen());                        
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue(nv_dto.getSdt());
                        cell = row.createCell(4, CellType.STRING);
                        cell.setCellValue(nv_dto.getMail());
                        cell = row.createCell(5, CellType.STRING);
                        cell.setCellValue(nv_dto.getGioitinh());
                        cell = row.createCell(6, CellType.STRING);
                        cell.setCellValue(nv_dto.getChucvu());
                    }
                    File f = new File("../DoAnJavaTommorrow/Nhanvien.xlsx");
                    FileOutputStream fos = null;
                    try {
                         fos = new FileOutputStream(f);
                        workbook.write(fos);
                        JOptionPane.showMessageDialog(null, "In danh sach nhân viên thành công !");
                        fos.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnThemNV.setBounds(880, 20, 100, 30);
        btnSuaNV.setBounds(880, 70, 100, 30);
        btnXoaNV.setBounds(880, 120, 100, 30);
        btnTimNV.setBounds(880, 170, 100, 30);
        btnDocDLNV.setBounds(680, 220, 100, 30);
        btnImportNV.setBounds(780, 220, 100, 30);
        btnExportNV.setBounds(880, 220, 100, 30);

        tblNV = new JTable(modelNV);

        TableRowSorter<TableModel> rowSorterNV = new TableRowSorter<TableModel>(modelNV);
        tblNV.setRowSorter(rowSorterNV);

        tblNV.setBackground(Color.WHITE);
        tblNV.setForeground(Color.BLACK);
        tblNV.setRowHeight(25);
        tblNV.setFont(new Font("Arial", NORMAL, 12));
        tblNV.setBorder(null);
        tblNV.setShowVerticalLines(false);
        tblNV.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblNV.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollNV = new JScrollPane(tblNV);
        scrollNV.setBounds(20, 260, 960, 385);
        pNV.add(scrollNV);

        tblNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblNV.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblNV.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblNV.getColumnModel().getColumn(2).setPreferredWidth(180);
        tblNV.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblNV.getColumnModel().getColumn(4).setPreferredWidth(160);
        tblNV.getColumnModel().getColumn(5).setPreferredWidth(138);
        tblNV.getColumnModel().getColumn(6).setPreferredWidth(150);

        JTableHeader headerNV = tblNV.getTableHeader();
        headerNV.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblNV.getTableHeader().setForeground(Color.WHITE);
        tblNV.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblNV.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        //=>bỏ viền header table

        pNV.add(lbIDNV);
        pNV.add(lbHoNV);
        pNV.add(lbTenNV);
        pNV.add(lbSDTNV);
        pNV.add(lbMailNV);
        pNV.add(lbGioiTinhNV);
        pNV.add(lbChucVuNV);
        pNV.add(lbTimNV);
        pNV.add(lbDSNV);

        pNV.add(txtIDNV);
        pNV.add(txtHoNV);
        pNV.add(txtTenNV);
        pNV.add(txtSDTNV);
        pNV.add(txtMailNV);
        pNV.add(txtGioiTinhNV);
        pNV.add(txtChucVuNV);
        pNV.add(txtTimNV);

        pNV.add(btnThemNV);
        pNV.add(btnSuaNV);
        pNV.add(btnXoaNV);
        pNV.add(btnTimNV);
        pNV.add(btnDocDLNV);
        pNV.add(btnImportNV);
        pNV.add(btnExportNV);

        // lắng nghe sự kiện 
        tblNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblNV.getSelectedRow();
                if (i >= 0) {
                    txtIDNV.setText(tblNV.getModel().getValueAt(i, 0).toString());
                    txtHoNV.setText(tblNV.getModel().getValueAt(i, 1).toString());
                    txtTenNV.setText(tblNV.getModel().getValueAt(i, 2).toString());
                    txtSDTNV.setText(tblNV.getModel().getValueAt(i, 3).toString());
                    txtMailNV.setText(tblNV.getModel().getValueAt(i, 4).toString());
                    txtGioiTinhNV.setText(tblNV.getModel().getValueAt(i, 5).toString());
                    txtChucVuNV.setText(tblNV.getModel().getValueAt(i, 6).toString());
                    txtIDNV.setEditable(false);
                }
            }
        });         
        
    }

    private void quanlykhachhang() { //==================================================================KHACHHANG
        
        lbKH = new JLabel("   Quản lý khách hàng", JLabel.LEFT);
        lbKH.setOpaque(true);
        lbKH.setBounds(0, 350, 200, 50);
        lbKH.setBackground(new java.awt.Color(67, 160, 71));
        lbKH.setForeground(Color.WHITE);
        lbKH.setFont(new Font("Arial", NORMAL, 14));
        lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        try {
            BufferedImage imgKH = ImageIO.read(new File("src/img/KH.png"));
            ImageIcon iconKH = new ImageIcon(imgKH.getScaledInstance(25, 25, imgKH.SCALE_SMOOTH));
            lbKH.setIcon(iconKH);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        lbKH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbKH.setBackground(new java.awt.Color(129, 199, 132));
                lbKH.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbKH.setBackground(new java.awt.Color(67, 160, 71));
                lbKH.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(false);
                pPN.setVisible(false);
                pNV.setVisible(false);
                pKH.setVisible(true);
                pSP.setVisible(false);
                pHD.setVisible(false);
                pCTGG.setVisible(false);
                pTK.setVisible(false);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
            }
        });

        String[] columnKH
                = {"ID", "Họ", "Tên", "Số điện thoại", "Mail", "Giới tính", "Tổng chi tiêu"};

        DefaultTableModel modelKH = new DefaultTableModel(columnKH, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        //Panel khách hàng start
        pKH = new JPanel();
        pKH.setLayout(null);
        pKH.setBackground(Color.WHITE);
        pKH.setBounds(0, 0, 1000, 660);
        pCT.add(pKH);
        pKH.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pKH.setVisible(false);

        lbIDKH = new JLabel("ID khách hàng");
        lbHoKH = new JLabel("Họ khách hàng");
        lbTenKH = new JLabel("Tên khách hàng");
        lbSDTKH = new JLabel("SĐT khách hàng");
        lbMailKH = new JLabel("Mail khách hàng");
        lbGioiTinhKH = new JLabel("Giới tính khách hàng");
        lbTongChiTieuKH = new JLabel("Tổng chi tiêu");
        lbTimKH = new JLabel("Tìm");
        lbDSKH = new JLabel("DANH SÁCH KHÁCH HÀNG");

        lbIDKH.setBounds(20, 20, 120, 30);
        lbHoKH.setBounds(20, 70, 120, 30);
        lbTenKH.setBounds(20, 120, 120, 30);
        lbSDTKH.setBounds(20, 170, 120, 30);
        lbMailKH.setBounds(460, 20, 120, 30);
        lbGioiTinhKH.setBounds(460, 70, 120, 30);
        lbTongChiTieuKH.setBounds(460, 120, 120, 30);
        lbTimKH.setBounds(460, 170, 30, 30);
        lbDSKH.setBounds(20, 220, 400, 30);
        lbDSKH.setForeground(new java.awt.Color(51, 105, 30));
        lbDSKH.setFont(new Font("Arial", Font.BOLD, 16));

        String findfromKH[] = {"ID", "Họ", "Tên", "SĐT", "Mail", "GT", "Tổng chi tiêu"};
        JComboBox cbKH = new JComboBox(findfromKH);
        cbKH.setBounds(490, 170, 90, 30);
        cbKH.setBorder(null);
        cbKH.setBackground(new java.awt.Color(128, 222, 234));
        cbKH.setForeground(Color.WHITE);
        pKH.add(cbKH);

        txtIDKH = new JTextField("", 20);
        txtHoKH = new JTextField("", 20);
        txtTenKH = new JTextField("", 20);
        txtSDTKH = new JTextField("", 20);
        txtMailKH = new JTextField("", 20);
        txtGioiTinhKH = new JTextField("", 20);
        txtTongChiTieuKH = new JTextField("", 20);
        txtTimKH = new JTextField("", 30);

        txtIDKH.setBounds(150, 20, 220, 30);
        txtHoKH.setBounds(150, 70, 220, 30);
        txtTenKH.setBounds(150, 120, 220, 30);
        txtSDTKH.setBounds(150, 170, 220, 30);
        txtMailKH.setBounds(590, 20, 220, 30);
        txtGioiTinhKH.setBounds(590, 70, 220, 30);
        txtTongChiTieuKH.setBounds(590, 120, 220, 30);
        txtTimKH.setBounds(590, 170, 220, 30);

        //Ko cho nhập id
        txtIDKH.setEditable(false);

        btnThemKH = new JButton("Thêm");
        btnThemKH.setBackground(new java.awt.Color(174, 234, 0));
        btnThemKH.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThemKH.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnThemKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = KhachhangBUS.danhsach_kh.size() - 1;
                KhachhangDTO temp = KhachhangBUS.danhsach_kh.get(i);
                int temp2 = Integer.parseInt(temp.getId()) + 1;
                String k = String.valueOf(temp2);
                txtIDKH.setText(k);
                //===== Check xem có hợp lệ =====//
                //Check họ
                if (KT.soN(txtHoKH.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Họ phải là chữ !");
                    return;
                }
                //Check tên
                if (KT.soN(txtTenKH.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Tên phải là chữ !");
                    return;
                }
                //Check số điện thoại
                if (KT.soN(txtSDTKH.getText()) == false || txtSDTKH.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "SĐT phải là số và bằng 10 số");
                    return;
                }
                //Check mail
                if (KT.ktemail(txtMailKH.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Mail không hợp lệ");
                    return;
                }
                //Check giới tính
                if (KT.soN(txtGioiTinhKH.getText()) == true || txtGioiTinhKH.getText().length() > 4) {
                    JOptionPane.showMessageDialog(null, "Giới tính phải là chữ và ít hơn hoặc bằng 3 từ");
                    return;
                }
                //Check tổng chi
                if (KT.soN(txtTongChiTieuKH.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Tổng chi tiêu phải là số !");
                    return;
                }
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(txtIDKH.getText());
                kh_dto.setHo(txtHoKH.getText());
                kh_dto.setTen(txtTenKH.getText());
                kh_dto.setSdt(txtSDTKH.getText());
                kh_dto.setMail(txtMailKH.getText());
                kh_dto.setGioitinh(txtGioiTinhKH.getText());
                kh_dto.setTongchi(txtTongChiTieuKH.getText());

                KhachhangBUS bus = new KhachhangBUS();
                try {
                    bus.Insert(kh_dto);
                    Vector row = new Vector();
                    row.add(kh_dto.getId());
                    row.add(kh_dto.getHo());
                    row.add(kh_dto.getTen());
                    row.add(kh_dto.getSdt());
                    row.add(kh_dto.getMail());
                    row.add(kh_dto.getGioitinh());
                    row.add(kh_dto.getTongchi());
                    modelKH.addRow(row);
                    tblKH.setModel(modelKH);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnXoaKH = new JButton("Xóa");
        btnXoaKH.setBackground(new java.awt.Color(255, 82, 82));
        btnXoaKH.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoaKH.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnXoaKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tblKH.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại !");
                    return;
                }
                KhachhangBUS bus = new KhachhangBUS();
                try {
                    bus.Delete2(txtIDKH.getText(), tblKH.getSelectedRow());
                    modelKH.removeRow(tblKH.getSelectedRow());
                    tblKH.setModel(modelKH);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnSuaKH = new JButton("Sửa");
        btnSuaKH.setBackground(new java.awt.Color(238, 255, 65));
        btnSuaKH.setBorder(null);
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSuaKH.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnSuaKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblKH.getSelectedRow();
                //===== Check xem có hợp lệ =====//
                //Check họ
                if (KT.soN(txtHoKH.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Họ phải là chữ !");
                    return;
                }
                //Check tên
                if (KT.soN(txtTenKH.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Tên phải là chữ !");
                    return;
                }
                //Check số điện thoại
                if (KT.soN(txtSDTKH.getText()) == false || txtSDTKH.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "SĐT phải là số và bằng 10 số");
                    return;
                }
                //Check mail
                if (KT.ktemail(txtMailKH.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Mail không hợp lệ");
                    return;
                }
                //Check giới tính
                if (KT.soN(txtGioiTinhKH.getText()) == true || txtGioiTinhKH.getText().length() > 4) {
                    JOptionPane.showMessageDialog(null, "Giới tính phải là chữ và ít hơn hoặc bằng 3 từ");
                    return;
                }
                //Check tổng chi
                if (KT.soN(txtTongChiTieuKH.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "Tổng chi tiêu phải là số !");
                    return;
                }
                KhachhangDTO kh_dto = new KhachhangDTO();
                kh_dto.setId(txtIDKH.getText());
                kh_dto.setHo(txtHoKH.getText());
                kh_dto.setTen(txtTenKH.getText());
                kh_dto.setSdt(txtSDTKH.getText());
                kh_dto.setMail(txtMailKH.getText());
                kh_dto.setGioitinh(txtGioiTinhKH.getText());
                kh_dto.setTongchi(txtTongChiTieuKH.getText());

                KhachhangBUS kh_bus = new KhachhangBUS();
                try {
                    kh_bus.Update(kh_dto);
                    modelKH.setValueAt(kh_dto.getHo(), i, 1);
                    modelKH.setValueAt(kh_dto.getTen(), i, 2);
                    modelKH.setValueAt(kh_dto.getSdt(), i, 3);
                    modelKH.setValueAt(kh_dto.getMail(), i, 4);
                    modelKH.setValueAt(kh_dto.getGioitinh(), i, 5);
                    modelKH.setValueAt(kh_dto.getTongchi(), i, 6);
                    tblKH.setModel(modelKH);
                } catch (Exception ex) {
                    Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        btnTimKH = new JButton("Tìm");
        btnTimKH.setBackground(new java.awt.Color(128, 222, 234));
        btnTimKH.setBorder(null);
        try {
            BufferedImage imgTimNCC = ImageIO.read(new File("src/img/search.png"));
            ImageIcon iconTimNCC = new ImageIcon(imgTimNCC.getScaledInstance(20, 20, imgTimNCC.SCALE_SMOOTH));
            btnTimKH.setIcon(iconTimNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnTimKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector header = new Vector();
                header.add("Id kh");
                header.add("Họ kh");
                header.add("Tên kh");
                header.add("Sdt kh");
                header.add("Mail kh");
                header.add("Gioitinh kh");
                header.add("Tổng Chi Tiêu kh");

                switch (cbKH.getSelectedIndex()) {
                    case 0: //Tìm theo id
                    {
                        //Làm cho table KH trống rỗng
                        for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                            modelKH.removeRow(0);
                        }
                        ArrayList<KhachhangDTO> temp = null;
                        KhachhangDAO kh_dao = new KhachhangDAO();
                        try {
                            temp = kh_dao.SearchDSKH2(txtTimKH.getText());
                            KhachhangBUS.danhsach_kh = kh_dao.SearchDSKH2(txtTimKH.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (KhachhangDTO kh_dto : temp) {
                            Vector row = new Vector();
                            row.add(kh_dto.getId());
                            row.add(kh_dto.getHo());
                            row.add(kh_dto.getTen());
                            row.add(kh_dto.getSdt());
                            row.add(kh_dto.getMail());
                            row.add(kh_dto.getGioitinh());
                            row.add(kh_dto.getTongchi());
                            modelKH.addRow(row);
                        }
                        tblKH.setModel(modelKH);

                        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 1: //Tìm theo Họ
                    {
                        //Làm cho table KH trống rỗng
                        for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                            modelKH.removeRow(0);
                        }
                        ArrayList<KhachhangDTO> temp = null;
                        KhachhangDAO kh_dao = new KhachhangDAO();
                        try {
                            temp = kh_dao.SearchDSKH3(txtTimKH.getText());
                            KhachhangBUS.danhsach_kh = kh_dao.SearchDSKH3(txtTimKH.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (KhachhangDTO kh_dto : temp) {
                            Vector row = new Vector();
                            row.add(kh_dto.getId());
                            row.add(kh_dto.getHo());
                            row.add(kh_dto.getTen());
                            row.add(kh_dto.getSdt());
                            row.add(kh_dto.getMail());
                            row.add(kh_dto.getGioitinh());
                            row.add(kh_dto.getTongchi());
                            modelKH.addRow(row);
                        }
                        tblKH.setModel(modelKH);

                        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 2: //Tìm theo tên
                    {
                        //Làm cho table KH trống rỗng
                        for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                            modelKH.removeRow(0);
                        }
                        ArrayList<KhachhangDTO> temp = null;
                        KhachhangDAO kh_dao = new KhachhangDAO();
                        try {
                            temp = kh_dao.SearchDSKH4(txtTimKH.getText());
                            KhachhangBUS.danhsach_kh = kh_dao.SearchDSKH4(txtTimKH.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (KhachhangDTO kh_dto : temp) {
                            Vector row = new Vector();
                            row.add(kh_dto.getId());
                            row.add(kh_dto.getHo());
                            row.add(kh_dto.getTen());
                            row.add(kh_dto.getSdt());
                            row.add(kh_dto.getMail());
                            row.add(kh_dto.getGioitinh());
                            row.add(kh_dto.getTongchi());
                            modelKH.addRow(row);
                        }
                        tblKH.setModel(modelKH);

                        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 3: //Tìm theo Số điện thoại
                    {
                        //Làm cho table KH trống rỗng
                        for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                            modelKH.removeRow(0);
                        }
                        ArrayList<KhachhangDTO> temp = null;
                        KhachhangDAO kh_dao = new KhachhangDAO();
                        try {
                            temp = kh_dao.SearchDSKH5(txtTimKH.getText());
                            KhachhangBUS.danhsach_kh = kh_dao.SearchDSKH5(txtTimKH.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (KhachhangDTO kh_dto : temp) {
                            Vector row = new Vector();
                            row.add(kh_dto.getId());
                            row.add(kh_dto.getHo());
                            row.add(kh_dto.getTen());
                            row.add(kh_dto.getSdt());
                            row.add(kh_dto.getMail());
                            row.add(kh_dto.getGioitinh());
                            row.add(kh_dto.getTongchi());
                            modelKH.addRow(row);
                        }
                        tblKH.setModel(modelKH);

                        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 4: //Tìm theo Mail
                    {
                        //Làm cho table KH trống rỗng
                        for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                            modelKH.removeRow(0);
                        }
                        ArrayList<KhachhangDTO> temp = null;
                        KhachhangDAO kh_dao = new KhachhangDAO();
                        try {
                            temp = kh_dao.SearchDSKH6(txtTimKH.getText());
                            KhachhangBUS.danhsach_kh = kh_dao.SearchDSKH6(txtTimKH.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (KhachhangDTO kh_dto : temp) {
                            Vector row = new Vector();
                            row.add(kh_dto.getId());
                            row.add(kh_dto.getHo());
                            row.add(kh_dto.getTen());
                            row.add(kh_dto.getSdt());
                            row.add(kh_dto.getMail());
                            row.add(kh_dto.getGioitinh());
                            row.add(kh_dto.getTongchi());
                            modelKH.addRow(row);
                        }
                        tblKH.setModel(modelKH);

                        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 5: //Tìm theo giới tính
                    {
                        //Làm cho table KH trống rỗng
                        for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                            modelKH.removeRow(0);
                        }
                        ArrayList<KhachhangDTO> temp = null;
                        KhachhangDAO kh_dao = new KhachhangDAO();
                        try {
                            temp = kh_dao.SearchDSKH7(txtTimKH.getText());
                            KhachhangBUS.danhsach_kh = kh_dao.SearchDSKH7(txtTimKH.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (KhachhangDTO kh_dto : temp) {
                            Vector row = new Vector();
                            row.add(kh_dto.getId());
                            row.add(kh_dto.getHo());
                            row.add(kh_dto.getTen());
                            row.add(kh_dto.getSdt());
                            row.add(kh_dto.getMail());
                            row.add(kh_dto.getGioitinh());
                            row.add(kh_dto.getTongchi());
                            modelKH.addRow(row);
                        }
                        tblKH.setModel(modelKH);

                        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                    case 6: //Tìm theo chức vụ
                    {
                        //Làm cho table KH trống rỗng
                        for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                            modelKH.removeRow(0);
                        }
                        ArrayList<KhachhangDTO> temp = null;
                        KhachhangDAO kh_dao = new KhachhangDAO();
                        try {
                            temp = kh_dao.SearchDSKH8(txtTimKH.getText());
                            KhachhangBUS.danhsach_kh = kh_dao.SearchDSKH8(txtTimKH.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (KhachhangDTO kh_dto : temp) {
                            Vector row = new Vector();
                            row.add(kh_dto.getId());
                            row.add(kh_dto.getHo());
                            row.add(kh_dto.getTen());
                            row.add(kh_dto.getSdt());
                            row.add(kh_dto.getMail());
                            row.add(kh_dto.getGioitinh());
                            row.add(kh_dto.getTongchi());
                            modelKH.addRow(row);
                        }
                        tblKH.setModel(modelKH);

                        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
                        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
                        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
                        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
                        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
                        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);
                    }
                    break;
                }
            }
        });
        btnCopyIDKH = new JButton("Chép ID KH");
        btnCopyIDKH.setBackground(new java.awt.Color(178, 255, 89));
        btnCopyIDKH.setBorder(null);
        btnCopyIDKH.setBounds(250, 220, 100, 30);
        //tim kiem nang cao idkh
        btnCopyIDKH.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tblKH.getSelectedRow();
                if (i >= 0) {
                    txtIDKHinHD.setText(tblKH.getModel().getValueAt(i, 0).toString());
                    pNV.setVisible(false);
                    pHD.setVisible(true);
                    lbHome.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                    lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                    lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));                          
                    lbSP.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                    lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
                    lbCTGG.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                    lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                    lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                    lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                }
            }
        });
        
        btnDocDLKH = new JButton("Tải lại");
        btnDocDLKH.setBackground(new java.awt.Color(178, 255, 89));
        btnDocDLKH.setBorder(null);
        //Tải dữ liệu lên table
        KhachhangBUS bus = new KhachhangBUS();
        bus.getDSKhachhang();
        Vector header = new Vector();
        header.add("Id kh");
        header.add("Họ kh");
        header.add("Tên kh");
        header.add("Sdt kh");
        header.add("Mail kh");
        header.add("Gioitinh kh");
        header.add("Chucvu kh");
        for (KhachhangDTO kh_dto : KhachhangBUS.danhsach_kh) {
            Vector row = new Vector();
            row.add(kh_dto.getId());
            row.add(kh_dto.getHo());
            row.add(kh_dto.getTen());
            row.add(kh_dto.getSdt());
            row.add(kh_dto.getMail());
            row.add(kh_dto.getGioitinh());
            row.add(kh_dto.getTongchi());
            modelKH.addRow(row);
        }
        btnDocDLKH.addActionListener(new ActionListener()//Nút tải db
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIDKH.setText("");
                txtIDKH.setEditable(false);
                txtHoKH.setText("");
                txtTenKH.setText("");
                txtSDTKH.setText("");
                txtMailKH.setText("");
                txtGioiTinhKH.setText("");
                txtTongChiTieuKH.setText("");
                for (int i = 0; i < KhachhangBUS.danhsach_kh.size(); i++) {
                    modelKH.removeRow(0);
                }
                KhachhangBUS bus = new KhachhangBUS();
                bus.getDSKhachhang();
                Vector header = new Vector();
                header.add("Id kh");
                header.add("Họ kh");
                header.add("Tên kh");
                header.add("Sdt kh");
                header.add("Mail kh");
                header.add("Gioitinh kh");
                header.add("Tổng Chi Tiêu kh");
                for (KhachhangDTO kh_dto : KhachhangBUS.danhsach_kh) {
                    Vector row = new Vector();
                    row.add(kh_dto.getId());
                    row.add(kh_dto.getHo());
                    row.add(kh_dto.getTen());
                    row.add(kh_dto.getSdt());
                    row.add(kh_dto.getMail());
                    row.add(kh_dto.getGioitinh());
                    row.add(kh_dto.getTongchi());
                    modelKH.addRow(row);
                }
            }
        });

        btnImportKH = new JButton("Import");
        btnImportKH.setBackground(new java.awt.Color(174, 234, 0));
        btnImportKH.setBorder(null);       

        btnExportKH = new JButton("Export");
        btnExportKH.setBackground(new java.awt.Color(178, 255, 89));
        btnExportKH.setBorder(null);
        btnExportKH.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                XSSFWorkbook workbook=new XSSFWorkbook();
                XSSFSheet sheet=workbook.createSheet("Khachhang");
                
                XSSFRow row=null;
                XSSFCell cell =null;
                
                row =sheet.createRow(0);
                
                cell=row.createCell(0);
                cell.setCellValue("id_kh");                
                cell=row.createCell(1);
                cell.setCellValue("ho_kh");               
                cell=row.createCell(2);
                cell.setCellValue("ten_kh");               
                cell=row.createCell(3);
                cell.setCellValue("sdt_kh");               
                cell=row.createCell(4);
                cell.setCellValue("mail_kh");                
                cell=row.createCell(5);
                cell.setCellValue("gioitinh_kh");               
                cell=row.createCell(6);
                cell.setCellValue("tongchi_kh");
                
                if(KhachhangBUS.danhsach_kh != null)
                {
                    int x = KhachhangBUS.danhsach_kh.size();
                    for (int i = 0; i < x; i++) 
                    {
                        KhachhangDTO kh_dto = KhachhangBUS.danhsach_kh.get(i);
                        
                        row = sheet.createRow(2 + i);
                        
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(kh_dto.getId());                        
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(kh_dto.getHo());                        
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(kh_dto.getTen());                        
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue(kh_dto.getSdt());
                        cell = row.createCell(4, CellType.STRING);
                        cell.setCellValue(kh_dto.getMail());
                        cell = row.createCell(5, CellType.STRING);
                        cell.setCellValue(kh_dto.getGioitinh());
                        cell = row.createCell(6, CellType.STRING);
                        cell.setCellValue(kh_dto.getTongchi());
                    }
                    File f = new File("../DoAnJavaTommorrow/Khachhang.xlsx");
                    FileOutputStream fos = null;
                    try {
                         fos = new FileOutputStream(f);
                        workbook.write(fos);
                        JOptionPane.showMessageDialog(null, "In danh sach khách hàng thành công !");
                        fos.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        btnThemKH.setBounds(880, 20, 100, 30);
        btnSuaKH.setBounds(880, 70, 100, 30);
        btnXoaKH.setBounds(880, 120, 100, 30);
        btnTimKH.setBounds(880, 170, 100, 30);
        btnDocDLKH.setBounds(680, 220, 100, 30);
        btnImportKH.setBounds(780, 220, 100, 30);
        btnExportKH.setBounds(880, 220, 100, 30);

        tblKH = new JTable(modelKH);
        TableRowSorter<TableModel> rowSorterKH = new TableRowSorter<TableModel>(modelKH);
        tblKH.setRowSorter(rowSorterKH);

        tblKH.setBackground(Color.WHITE);
        tblKH.setForeground(Color.BLACK);
        tblKH.setRowHeight(25);
        tblKH.setFont(new Font("Arial", NORMAL, 12));
        tblKH.setBorder(null);
        tblKH.setShowVerticalLines(false);
        tblKH.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblKH.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollKH = new JScrollPane(tblKH);
        scrollKH.setBounds(20, 260, 960, 385);
        pKH.add(scrollKH);

        tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblKH.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblKH.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblKH.getColumnModel().getColumn(2).setPreferredWidth(180);
        tblKH.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblKH.getColumnModel().getColumn(4).setPreferredWidth(160);
        tblKH.getColumnModel().getColumn(5).setPreferredWidth(138);
        tblKH.getColumnModel().getColumn(6).setPreferredWidth(150);

        JTableHeader headerKH = tblKH.getTableHeader();
        headerKH.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblKH.getTableHeader().setForeground(Color.WHITE);
        tblKH.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblKH.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        //=>bỏ viền header table

        pKH.add(lbIDKH);
        pKH.add(lbHoKH);
        pKH.add(lbTenKH);
        pKH.add(lbSDTKH);
        pKH.add(lbMailKH);
        pKH.add(lbGioiTinhKH);
        pKH.add(lbTongChiTieuKH);
        pKH.add(lbTimKH);
        pKH.add(lbDSKH);

        pKH.add(txtIDKH);
        pKH.add(txtHoKH);
        pKH.add(txtTenKH);
        pKH.add(txtSDTKH);
        pKH.add(txtMailKH);
        pKH.add(txtGioiTinhKH);
        pKH.add(txtTongChiTieuKH);
        pKH.add(txtTimKH);

        pKH.add(btnThemKH);
        pKH.add(btnSuaKH);
        pKH.add(btnXoaKH);
        pKH.add(btnTimKH);
        pKH.add(btnCopyIDKH);
        pKH.add(btnDocDLKH);
        pKH.add(btnImportKH);
        pKH.add(btnExportKH);

        //bắt sự kiện
        tblKH.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                int i = tblKH.getSelectedRow();
                if (i >= 0) 
                {
                    txtIDKH.setText(tblKH.getModel().getValueAt(i, 0).toString());
                    txtHoKH.setText(tblKH.getModel().getValueAt(i, 1).toString());
                    txtTenKH.setText(tblKH.getModel().getValueAt(i, 2).toString());
                    txtSDTKH.setText(tblKH.getModel().getValueAt(i, 3).toString());
                    txtMailKH.setText(tblKH.getModel().getValueAt(i, 4).toString());
                    txtGioiTinhKH.setText(tblKH.getModel().getValueAt(i, 5).toString());
                    txtTongChiTieuKH.setText(tblKH.getModel().getValueAt(i, 6).toString());
                }
            }
        });
        // add danh mục chức năng vào hướng tây                
        pW.add(lbKH);

        //Panel khách hàng end 
    }

    private void quanlythongke() {   //======================================================================THONGKE
        
        lbTK = new JLabel("   Quản lý thống kê", JLabel.LEFT);
        lbTK.setOpaque(true);
        lbTK.setBounds(0, 400, 200, 50);
        lbTK.setBackground(new java.awt.Color(67, 160, 71));
        lbTK.setForeground(Color.WHITE);
        lbTK.setFont(new Font("Arial", NORMAL, 14));
        lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        pW.add(lbTK);
        try {
            BufferedImage imgTK = ImageIO.read(new File("src/img/thongke.png"));
            ImageIcon iconTK = new ImageIcon(imgTK.getScaledInstance(25, 25, imgTK.SCALE_SMOOTH));
            lbTK.setIcon(iconTK);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //Phân quyền
        if (General.CURRENT_ROLE == 2){
            lbTK.setEnabled(false);
            lbTK = new JLabel("   Quản lý thống kê", JLabel.LEFT);
            lbTK.setBounds(0, 400, 200, 50);
            lbTK.setBackground(new java.awt.Color(67, 160, 71));
            lbTK.setForeground(Color.WHITE);
            lbTK.setFont(new Font("Arial", NORMAL, 14));
            lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
        
        lbTK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbTK.setBackground(new java.awt.Color(129, 199, 132));
                lbTK.setForeground(new java.awt.Color(238, 238, 238));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbTK.setBackground(new java.awt.Color(67, 160, 71));
                lbTK.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pHome.setVisible(false);
                pNCC.setVisible(false);
                pPN.setVisible(false);
                pNV.setVisible(false);
                pKH.setVisible(false);
                pSP.setVisible(false);
                pHD.setVisible(false);
                pCTGG.setVisible(false);
                pTK.setVisible(true);
                lbHome.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
                lbNCC.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbPN.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbKH.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbSP.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbHD.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbCTGG.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                lbTK.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 6, new java.awt.Color(118, 255, 3)));
            }
        });
        
        pTK = new JPanel();
        pTK.setLayout(null);
        pTK.setBackground(Color.WHITE);
        pTK.setBounds(0, 0, 1000, 660);
        pCT.add(pTK);
        pTK.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(51, 105, 30)));
        pTK.setVisible(false);
        
        btnTKHoaDon = new JButton("THEO HÓA ĐƠN");
        btnTKTongChi = new JButton("THEO TỔNG CHI");
        
        btnTKHoaDon.setBackground(new java.awt.Color(51, 105, 30));
        btnTKHoaDon.setForeground(Color.WHITE);
        btnTKHoaDon.setBorder(null);
        btnTKTongChi.setBackground(new java.awt.Color(51, 105, 30));
        btnTKTongChi.setForeground(Color.WHITE);
        btnTKTongChi.setBorder(null);
        
        btnTKHoaDon.setBounds(20, 10, 120, 40);
        btnTKTongChi.setBounds(142, 10, 120, 40);
        //Thống kê theo hóa đơn       
        lbTKnhaploai = new JLabel("Chọn loại");
        lbTKnhaploai.setBounds(10, 90, 120, 30);
        lbTKnhaploai.setForeground(new java.awt.Color(51, 105, 30));
        lbTKnhaploai.setFont(new Font("Arial", Font.BOLD, 14));

        String TKoption[] = {"Nhân viên", "Khách hàng", "Tất cả"};
        JComboBox cbTKtheoHD = new JComboBox(TKoption);
        cbTKtheoHD.setBounds(90, 90, 120, 30);
        cbTKtheoHD.setBorder(null);
        cbTKtheoHD.setBackground(Color.WHITE);
        cbTKtheoHD.setForeground(Color.BLACK);
        
        btnTKngay = new JButton("Theo ngày");
        btnTKngay.setBounds(390, 90, 100, 30);
        btnTKngay.setBackground(new java.awt.Color(255, 82, 82));
        btnTKngay.setForeground(Color.BLACK);
        btnTKngay.setBorder(null);
        btnTKngay.setFocusPainted(false);
        btnTKthang = new JButton("Theo tháng");
        btnTKthang.setBounds(390, 150, 100, 30);
        btnTKthang.setBackground(new java.awt.Color(238, 255, 65));
        btnTKthang.setForeground(Color.BLACK);
        btnTKthang.setBorder(null);
        btnTKthang.setFocusPainted(false);
        btnTKnam = new JButton("Theo năm");
        btnTKnam.setBounds(390, 210, 100, 30);
        btnTKnam.setBackground(new java.awt.Color(128, 222, 234));
        btnTKnam.setForeground(Color.BLACK);
        btnTKnam.setBorder(null);
        btnTKnam.setFocusPainted(false);

        lbTKtimebegin = new JLabel("Thời gian bắt đầu");
        lbTKtimebegin.setBounds(520, 60, 130, 30);
        lbTKtimebegin.setForeground(new java.awt.Color(51, 105, 30));
        lbTKtimebegin.setFont(new Font("Arial", Font.BOLD, 14));
        lbTKtimeend = new JLabel("Thời gian kết thúc");
        lbTKtimeend.setBounds(660, 60, 130, 30);
        lbTKtimeend.setForeground(new java.awt.Color(51, 105, 30));
        lbTKtimeend.setFont(new Font("Arial", Font.BOLD, 14));

        dateTKbegintheoHD = new JTextField("", 20);
        dateTKbegintheoHD.setBounds(520, 90, 120, 30);
        dateTKbegintheoHD.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
        dateTKendtheoHD = new JTextField("", 20);
        dateTKendtheoHD.setBounds(660, 90, 120, 30);
        dateTKendtheoHD.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));

        String TKoptionthang[] = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
            "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        String TKoptionnam[] = {"Năm 2015", "Năm 2016", "Năm 2017", "Năm 2018", "Năm 2019", "Năm 2020"};
        JComboBox cbTKtheoHDthangA = new JComboBox(TKoptionthang);
        cbTKtheoHDthangA.setBounds(520, 150, 120, 30);
        cbTKtheoHDthangA.setBorder(null);
        cbTKtheoHDthangA.setBackground(Color.WHITE);
        cbTKtheoHDthangA.setForeground(Color.BLACK);
        pTK.add(cbTKtheoHDthangA);

        JComboBox cbTKtheoHDnamA = new JComboBox(TKoptionnam);
        cbTKtheoHDnamA.setBounds(520, 210, 120, 30);
        cbTKtheoHDnamA.setBorder(null);
        cbTKtheoHDnamA.setBackground(Color.WHITE);
        cbTKtheoHDnamA.setForeground(Color.BLACK);
        pTK.add(cbTKtheoHDnamA);

        btnTKsum1 = new JButton("Tống");
        btnTKsum1.setBounds(800, 90, 70, 30);
        btnTKsum1.setBackground(new java.awt.Color(174, 234, 0));
        btnTKsum1.setForeground(Color.BLACK);
        btnTKsum1.setBorder(null);
        btnTKsum1.setFocusPainted(false);
        btnTKsum2 = new JButton("Tống");
        btnTKsum2.setBounds(800, 150, 70, 30);
        btnTKsum2.setBackground(new java.awt.Color(174, 234, 0));
        btnTKsum2.setForeground(Color.BLACK);
        btnTKsum2.setBorder(null);
        btnTKsum2.setFocusPainted(false);
        btnTKsum3 = new JButton("Tống");
        btnTKsum3.setBounds(800, 210, 70, 30);
        btnTKsum3.setBackground(new java.awt.Color(174, 234, 0));
        btnTKsum3.setForeground(Color.BLACK);
        btnTKsum3.setBorder(null);
        btnTKsum3.setFocusPainted(false);
/*Nút tải lại*/ btnRefreshTK1 = new JButton("Tải lại");
                btnRefreshTK1.setBounds(390, 260, 100, 30);
                btnRefreshTK1.setBackground(new java.awt.Color(174, 234, 0));
                btnRefreshTK1.setForeground(Color.BLACK);
                btnRefreshTK1.setBorder(null);
                btnRefreshTK1.setFocusPainted(false);
        
        txtTKnhapid = new JTextField("", 20);
        txtTKtong1 = new JTextField("", 20);
        txtTKtong2 = new JTextField("", 20);
        txtTKtong3 = new JTextField("", 20);
        txtTKnhapid.setBounds(230, 90, 80, 30);
        txtTKnhapid.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
        txtTKtong1.setBounds(880, 90, 80, 30);
        txtTKtong1.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
        txtTKtong2.setBounds(880, 150, 80, 30);
        txtTKtong2.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
        txtTKtong3.setBounds(880, 210, 80, 30);
        txtTKtong3.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));

        pTK.add(lbTKnhaploai);
        pTK.add(cbTKtheoHD);
        pTK.add(txtTKnhapid);
        pTK.add(txtTKtong1);
        pTK.add(txtTKtong2);
        pTK.add(txtTKtong3);
        pTK.add(dateTKbegintheoHD);
        pTK.add(dateTKendtheoHD);

        pTK.add(btnTKsum1);
        pTK.add(btnTKsum2);
        pTK.add(btnTKsum3);
        pTK.add(lbTKtimebegin);
        pTK.add(lbTKtimeend);
        pTK.add(btnTKngay);
        pTK.add(btnTKthang);
        pTK.add(btnTKnam);
        pTK.add(btnRefreshTK1);
        pTK.add(btnTKHoaDon);
        pTK.add(btnTKTongChi);

        lbDSTKtheoHD = new JLabel("DANH SÁCH THỐNG KÊ TỔNG THU HÓA ĐƠN");
        lbDSTKtheoHD.setBounds(20, 270, 550, 30);
        lbDSTKtheoHD.setForeground(new java.awt.Color(51, 105, 30));
        lbDSTKtheoHD.setFont(new Font("Arial", Font.BOLD, 16));

        String[] columnTKtheoHD
                = {"ID hóa đơn", "ID khách hàng", "ID nhân viên", "ID giảm giá", "Ngày lập hóa đơn", "Tổng tiền hóa đơn", "Tiền giảm giá"};
        
        DefaultTableModel modelTKtheoHD = new DefaultTableModel(columnTKtheoHD, 0);        
        tblTKtheoHD = new JTable(modelTKtheoHD) 
        {           
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };        
        //Tải dữ liệu lên table
        HoaDonBUS bus = new HoaDonBUS();
        bus.getDSHoaDon();
        Vector header = new Vector();
        header.add("Id HD");
        header.add("Id KH");
        header.add("Id NV");
        header.add("Id Giảm giá");
        header.add("Ngày lập");
        header.add("Tổng tiền HD");
        header.add("Tiền giảm giá");
        for (HoaDonDTO hd_dto : HoaDonBUS.dsHD) 
        {
            Vector row = new Vector();
            row.add(hd_dto.getIdHD());
            row.add(hd_dto.getIdKH());
            row.add(hd_dto.getIdNV());
            row.add(hd_dto.getIdGG());
            row.add(hd_dto.getNgayLapHD());
            row.add(hd_dto.getTongTien());
            row.add(hd_dto.getTienGG());
            modelTKtheoHD.addRow(row);
        }
        
        TableRowSorter<TableModel> rowSorterTKtheoHD = new TableRowSorter<TableModel>(modelTKtheoHD);
        tblTKtheoHD.setRowSorter(rowSorterTKtheoHD);
        tblTKtheoHD.setBackground(Color.WHITE);
        tblTKtheoHD.setForeground(Color.BLACK);
        tblTKtheoHD.setRowHeight(25);
        tblTKtheoHD.setFont(new Font("Arial", NORMAL, 12));
        tblTKtheoHD.setBorder(null);
        tblTKtheoHD.setShowVerticalLines(false);
        tblTKtheoHD.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblTKtheoHD.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollTKtheoHD = new JScrollPane(tblTKtheoHD);
        scrollTKtheoHD.setBounds(20, 300, 960, 340);
        pTK.add(scrollTKtheoHD);

        tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
        tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
        tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
        tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);

        JTableHeader headerTKtheoHD = tblTKtheoHD.getTableHeader();
        headerTKtheoHD.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblTKtheoHD.getTableHeader().setForeground(Color.WHITE);
        tblTKtheoHD.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblTKtheoHD.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));
        
        btnRefreshTK1.addActionListener(new ActionListener() // Nút tải lại
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                txtTKnhapid.setText("");
                txtTKtong1.setText("");
                txtTKtong2.setText("");
                txtTKtong3.setText("");
                for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                    modelTKtheoHD.removeRow(0);
                }
                HoaDonBUS bus = new HoaDonBUS();
                bus.getDSHoaDon();
                Vector header = new Vector();
                header.add("Id HD");
                header.add("Id KH");
                header.add("Id NV");
                header.add("Id Giảm giá");
                header.add("Ngày lập");
                header.add("Tổng tiền HD");
                header.add("Tiền giảm giá");
                for (HoaDonDTO hd_dto : HoaDonBUS.dsHD) 
                {
                    Vector row = new Vector();
                    row.add(hd_dto.getIdHD());
                    row.add(hd_dto.getIdKH());
                    row.add(hd_dto.getIdNV());
                    row.add(hd_dto.getIdGG());
                    row.add(hd_dto.getNgayLapHD());
                    row.add(hd_dto.getTongTien());
                    row.add(hd_dto.getTienGG());
                    modelTKtheoHD.addRow(row);
                }
            }
        });
        btnTKsum1.addActionListener(new ActionListener() // Nút thống kế theo ngày !!!!
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Vector header = new Vector();
                header.add("Id HD");
                header.add("Id KH");
                header.add("Id NV");
                header.add("Id Giảm giá");
                header.add("Ngày lập");
                header.add("Tổng tiền HD");
                header.add("Tiền giảm giá");
                switch (cbTKtheoHD.getSelectedIndex())
                {
                    case 0:     //Thống kê theo hóa đơn theo ngày theo nhân viên
                    {                                            
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDnv(txtTKnhapid.getText());                            
                            HoaDonBUS.dsHD = hd_dao.TKHDnv(txtTKnhapid.getText());                     
                            for (HoaDonDTO hd_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }                            
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                                txtTKtong1.setText(String.valueOf(sum));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;                       
                    case 1:  //Thống kê theo hóa đơn theo ngày theo khách hàng
                    {                        
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDnv(txtTKnhapid.getText());
                            
                            HoaDonBUS.dsHD = hd_dao.TKHDkh(txtTKnhapid.getText());
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong1.setText(String.valueOf(sum));                           
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Nhập id cần thống kê !");
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;                       
                    case 2:   //Thống kê theo hóa đơn theo ngày theo tất cả
                    {                        
                        try {                            
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDall();
                            
                            HoaDonBUS.dsHD = hd_dao.TKHDall();
                            for (HoaDonDTO hd_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong1.setText(String.valueOf(sum));
                            
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Nhập id cần thống kê !");
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;
                }
            }
        });
        btnTKsum2.addActionListener(new ActionListener() // Nút thống kế theo tháng !!!!
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Vector header = new Vector();
                header.add("Id HD");
                header.add("Id KH");
                header.add("Id NV");
                header.add("Id Giảm giá");
                header.add("Ngày lập");
                header.add("Tổng tiền HD");
                header.add("Tiền giảm giá");
                switch (cbTKtheoHD.getSelectedIndex())
                {
                    case 0:     //Thống kê theo hóa đơn theo tháng theo nhân viên
                    {                       
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDnv(txtTKnhapid.getText());                            
                            HoaDonBUS.dsHD = hd_dao.TKHDnv(txtTKnhapid.getText());
                            for (HoaDonDTO hd_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong2.setText(String.valueOf(sum));
                            
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;                       
                    case 1:  //Thống kê theo hóa đơn theo tháng theo khách hàng
                    {                       
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDkh(txtTKnhapid.getText());
                            HoaDonBUS.dsHD = hd_dao.TKHDkh(txtTKnhapid.getText());
                            
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong2.setText(String.valueOf(sum));
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Nhập id cần thống kê !");
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;                       
                    case 2:   //Thống kê theo hóa đơn theo tháng theo tất cả
                    {                        
                        try {                            
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDall();                           
                            HoaDonBUS.dsHD = hd_dao.TKHDall();
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong2.setText(String.valueOf(sum));
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Nhập id cần thống kê !");
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;
                }
            }           
        });
        btnTKsum3.addActionListener(new ActionListener() // Nút thống kế theo năm !!!!
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Vector header = new Vector();
                header.add("Id HD");
                header.add("Id KH");
                header.add("Id NV");
                header.add("Id Giảm giá");
                header.add("Ngày lập");
                header.add("Tổng tiền HD");
                header.add("Tiền giảm giá");
                switch (cbTKtheoHD.getSelectedIndex())
                {
                    case 0:     //Thống kê theo hóa đơn theo năm theo nhân viên
                    {                       
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDnv(txtTKnhapid.getText());
                            
                            HoaDonBUS.dsHD = hd_dao.TKHDnv(txtTKnhapid.getText());
                            for (HoaDonDTO hd_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong3.setText(String.valueOf(sum));
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;                       
                    case 1:  //Thống kê theo hóa đơn theo năm theo khách hàng
                    {                       
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDkh(txtTKnhapid.getText());
                            
                            HoaDonBUS.dsHD = hd_dao.TKHDkh(txtTKnhapid.getText());
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong3.setText(String.valueOf(sum));
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Nhập id cần thống kê !");
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;                       
                    case 2:   //Thống kê theo hóa đơn theo năm theo tất cả
                    {                        
                        try {
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HoaDonBUS.dsHD.size(); i++) {
                                modelTKtheoHD.removeRow(0);
                            }
                            ArrayList<HoaDonDTO> temp = null;
                            HoaDonDAO hd_dao = new HoaDonDAO();
                            temp = hd_dao.TKHDall();                           
                            HoaDonBUS.dsHD = hd_dao.TKHDall();
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                Vector row = new Vector();
                                row.add(hd_dto.getIdHD());
                                row.add(hd_dto.getIdKH());
                                row.add(hd_dto.getIdNV());
                                row.add(hd_dto.getIdGG());
                                row.add(hd_dto.getNgayLapHD());
                                row.add(hd_dto.getTongTien());
                                row.add(hd_dto.getTienGG());
                                modelTKtheoHD.addRow(row);
                            }
                            int sum = 0;
                            for (HoaDonDTO hd_dto : temp) 
                            {
                                sum += hd_dto.getTongTien();
                            }
                            txtTKtong3.setText(String.valueOf(sum));
                            tblTKtheoHD.setModel(modelTKtheoHD);
                            tblTKtheoHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoHD.getColumnModel().getColumn(0).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(1).setPreferredWidth(130);
                            tblTKtheoHD.getColumnModel().getColumn(2).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(3).setPreferredWidth(100);
                            tblTKtheoHD.getColumnModel().getColumn(4).setPreferredWidth(180);
                            tblTKtheoHD.getColumnModel().getColumn(5).setPreferredWidth(160);
                            tblTKtheoHD.getColumnModel().getColumn(6).setPreferredWidth(190);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Nhập id cần thống kê !");
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;
                }
            }           
        });       
        pTK.add(lbDSTKtheoHD);
        
        ////////////============ Thống kê theo tổng chi ============////////////     
        lbTKnhaploaiTC = new JLabel("Chọn loại");
        lbTKnhaploaiTC.setBounds(10, 90, 120, 30);
        lbTKnhaploaiTC.setForeground(new java.awt.Color(51, 105, 30));
        lbTKnhaploaiTC.setFont(new Font("Arial", Font.BOLD, 14));

        String TKoption2[] = {"Nhân viên", "Nhà cung cấp", "Tất cả"};
        JComboBox cbTKtheoTC = new JComboBox(TKoption2);
        cbTKtheoTC.setBounds(90, 90, 120, 30);
        cbTKtheoTC.setBorder(null);
        cbTKtheoTC.setBackground(Color.WHITE);
        cbTKtheoTC.setForeground(Color.BLACK);

        btnTKngayTC = new JButton("Theo ngày");
        btnTKngayTC.setBounds(390, 90, 100, 30);
        btnTKngayTC.setBackground(new java.awt.Color(255, 82, 82));
        btnTKngayTC.setForeground(Color.BLACK);
        btnTKngayTC.setBorder(null);
        btnTKngayTC.setFocusPainted(false);
        btnTKthangTC = new JButton("Theo tháng");
        btnTKthangTC.setBounds(390, 150, 100, 30);
        btnTKthangTC.setBackground(new java.awt.Color(238, 255, 65));
        btnTKthangTC.setForeground(Color.BLACK);
        btnTKthangTC.setBorder(null);
        btnTKthangTC.setFocusPainted(false);
        btnTKnamTC = new JButton("Theo năm");
        btnTKnamTC.setBounds(390, 210, 100, 30);
        btnTKnamTC.setBackground(new java.awt.Color(128, 222, 234));
        btnTKnamTC.setForeground(Color.BLACK);
        btnTKnamTC.setBorder(null);
        btnTKnamTC.setFocusPainted(false);
/*Nút tải lại*/ btnRefreshTK2 = new JButton("Tải lại");
                btnRefreshTK2.setBounds(390, 260, 100, 30);
                btnRefreshTK2.setBackground(new java.awt.Color(174, 234, 0));
                btnRefreshTK2.setForeground(Color.BLACK);
                btnRefreshTK2.setBorder(null);
                btnRefreshTK2.setFocusPainted(false);
        lbTKtimebeginTC = new JLabel("Thời gian bắt đầu");
        lbTKtimebeginTC.setBounds(520, 60, 130, 30);
        lbTKtimebeginTC.setForeground(new java.awt.Color(51, 105, 30));
        lbTKtimebeginTC.setFont(new Font("Arial", Font.BOLD, 14));
        lbTKtimeendTC = new JLabel("Thời gian kết thúc");
        lbTKtimeendTC.setBounds(660, 60, 130, 30);
        lbTKtimeendTC.setForeground(new java.awt.Color(51, 105, 30));
        lbTKtimeendTC.setFont(new Font("Arial", Font.BOLD, 14));

        dateTKbegintheoTC = new JDateChooser("dd/MM/yyyy", false);
        dateTKbegintheoTC.setBounds(520, 90, 120, 30);
        dateTKendtheoTC = new JDateChooser("dd/MM/yyyy", false);
        dateTKendtheoTC.setBounds(660, 90, 120, 30);

        JComboBox cbTKtheoTCthangA = new JComboBox(TKoptionthang);
        cbTKtheoTCthangA.setBounds(520, 150, 120, 30);
        cbTKtheoTCthangA.setBorder(null);
        cbTKtheoTCthangA.setBackground(Color.WHITE);
        cbTKtheoTCthangA.setForeground(Color.BLACK);
        pTK.add(cbTKtheoTCthangA);

        JComboBox cbTKtheoTCnamA = new JComboBox(TKoptionnam);
        cbTKtheoTCnamA.setBounds(520, 210, 120, 30);
        cbTKtheoTCnamA.setBorder(null);
        cbTKtheoTCnamA.setBackground(Color.WHITE);
        cbTKtheoTCnamA.setForeground(Color.BLACK);
        pTK.add(cbTKtheoTCnamA);

        btnTKsum1TC = new JButton("Tống");
        btnTKsum1TC.setBounds(800, 90, 70, 30);
        btnTKsum1TC.setBackground(new java.awt.Color(174, 234, 0));
        btnTKsum1TC.setForeground(Color.BLACK);
        btnTKsum1TC.setBorder(null);
        btnTKsum1TC.setFocusPainted(false);
        btnTKsum2TC = new JButton("Tống");
        btnTKsum2TC.setBounds(800, 150, 70, 30);
        btnTKsum2TC.setBackground(new java.awt.Color(174, 234, 0));
        btnTKsum2TC.setForeground(Color.BLACK);
        btnTKsum2TC.setBorder(null);
        btnTKsum2TC.setFocusPainted(false);
        btnTKsum3TC = new JButton("Tống");
        btnTKsum3TC.setBounds(800, 210, 70, 30);
        btnTKsum3TC.setBackground(new java.awt.Color(174, 234, 0));
        btnTKsum3TC.setForeground(Color.BLACK);
        btnTKsum3TC.setBorder(null);
        btnTKsum3TC.setFocusPainted(false);
        
        txtTKnhapid2 = new JTextField("", 20);
        txtTKtong1TC = new JTextField("", 20);
        txtTKtong2TC = new JTextField("", 20);
        txtTKtong3TC = new JTextField("", 20);
        txtTKnhapid2.setBounds(230, 90, 80, 30);
        txtTKnhapid2.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
        txtTKtong1TC.setBounds(880, 90, 80, 30);
        txtTKtong1TC.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
        txtTKtong2TC.setBounds(880, 150, 80, 30);
        txtTKtong2TC.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));
        txtTKtong3TC.setBounds(880, 210, 80, 30);
        txtTKtong3TC.setFont(new Font("Arial", Font.TRUETYPE_FONT, 14));

        pTK.add(lbTKnhaploaiTC);
        pTK.add(cbTKtheoTC);
        pTK.add(txtTKnhapid2);
        pTK.add(txtTKtong1TC);
        pTK.add(txtTKtong2TC);
        pTK.add(txtTKtong3TC);
        pTK.add(dateTKbegintheoTC);
        pTK.add(dateTKendtheoTC);

        pTK.add(btnTKsum1TC);
        pTK.add(btnTKsum2TC);
        pTK.add(btnTKsum3TC);
        pTK.add(lbTKtimebeginTC);
        pTK.add(lbTKtimeendTC);
        pTK.add(btnTKngayTC);
        pTK.add(btnTKthangTC);
        pTK.add(btnTKnamTC);
        pTK.add(btnRefreshTK2);
        pTK.add(btnTKHoaDon);
        pTK.add(btnTKTongChi);
//        pTK.add(btnTKSanpham);
        lbDSTKtheoTC = new JLabel("DANH SÁCH THỐNG KÊ TỔNG CHI TIÊU");
        lbDSTKtheoTC.setBounds(20, 270, 550, 30);
        lbDSTKtheoTC.setForeground(new java.awt.Color(51, 105, 30));
        lbDSTKtheoTC.setFont(new Font("Arial", Font.BOLD, 16));

        String[] columnTKtheoTC
                = {"ID phiếu nhập", "ID nhân viên", "ID nhà cung cấp", "Ngày nhập", "Tổng tiền"};
        
        DefaultTableModel modelTKtheoTC = new DefaultTableModel(columnTKtheoTC, 0);        
        tblTKtheoTC = new JTable(modelTKtheoTC) 
        {           
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };        
        //Tải dữ liệu lên table
        HangNhapBUS pn_bus = new HangNhapBUS();
        pn_bus.docDSHN();
        Vector header2 = new Vector();
        header2.add("ID phiếu nhập");
        header2.add("Id nhân viên");
        header2.add("Id nhà cung cấp");        
        header2.add("Ngày nhập");
        header2.add("Tổng tiền");
        for (HangnhapDTO pn_dto : HangNhapBUS.dsHN) 
        {
            Vector row = new Vector();
            row.add(pn_dto.getIDPN());
            row.add(pn_dto.getIDNV());
            row.add(pn_dto.getIDNCC());
            row.add(pn_dto.getNgayNhap());
            row.add(pn_dto.getTongTien());
            modelTKtheoTC.addRow(row);
        }
        TableRowSorter<TableModel> rowSorterTKtheoTC = new TableRowSorter<TableModel>(modelTKtheoTC);
        tblTKtheoTC.setRowSorter(rowSorterTKtheoTC);
        tblTKtheoTC.setBackground(Color.WHITE);
        tblTKtheoTC.setForeground(Color.BLACK);
        tblTKtheoTC.setRowHeight(25);
        tblTKtheoTC.setFont(new Font("Arial", NORMAL, 12));
        tblTKtheoTC.setBorder(null);
        tblTKtheoTC.setShowVerticalLines(false);
        tblTKtheoTC.setSelectionBackground(new java.awt.Color(67, 160, 71));
        tblTKtheoTC.setSelectionForeground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollTKtheoTC = new JScrollPane(tblTKtheoTC);
        scrollTKtheoTC.setBounds(20, 300, 960, 340);
        pTK.add(scrollTKtheoTC);

        tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
        tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
        tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
        tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);

        JTableHeader headerTKtheoTC = tblTKtheoTC.getTableHeader();
        headerTKtheoTC.setFont(new Font("Arial", Font.BOLD, 14)); //Font.BOLD
        tblTKtheoTC.getTableHeader().setForeground(Color.WHITE);
        tblTKtheoTC.getTableHeader().setBackground(new java.awt.Color(51, 105, 30));
        tblTKtheoTC.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 105, 30)));

        btnRefreshTK2.addActionListener(new ActionListener() // Nút tải lại
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                txtTKnhapid2.setText("");
                txtTKtong1TC.setText("");
                txtTKtong2TC.setText("");
                txtTKtong3TC.setText("");
                for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                    modelTKtheoTC.removeRow(0);
                }
                HangNhapBUS pn_bus = new HangNhapBUS();
                pn_bus.docDSHN();
                Vector header2 = new Vector();
                header2.add("ID phiếu nhập");
                header2.add("Id nhân viên");
                header2.add("Id nhà cung cấp");
                header2.add("Ngày nhập");
                header2.add("Tổng tiền");
                for (HangnhapDTO pn_dto : HangNhapBUS.dsHN) 
                {
                    Vector row = new Vector();
                    row.add(pn_dto.getIDPN());
                    row.add(pn_dto.getIDNV());
                    row.add(pn_dto.getIDNCC());
                    row.add(pn_dto.getNgayNhap());
                    row.add(pn_dto.getTongTien());
                    modelTKtheoTC.addRow(row);
                }
            }
        });
        btnTKsum1TC.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Vector header2 = new Vector();
                header2.add("ID phiếu nhập");
                header2.add("Id nhân viên");
                header2.add("Id nhà cung cấp");
                header2.add("Ngày nhập");
                header2.add("Tổng tiền");
                switch (cbTKtheoTC.getSelectedIndex())
                {
                    case 0:
                    {                                            
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNnv(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNnv(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong1TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;
                    case 1:
                    {
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNncc(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNncc(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong1TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    case 2:
                    {
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNall(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNall(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong1TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                }
            }
        });
        btnTKsum2TC.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Vector header2 = new Vector();
                header2.add("ID phiếu nhập");
                header2.add("Id nhân viên");
                header2.add("Id nhà cung cấp");
                header2.add("Ngày nhập");
                header2.add("Tổng tiền");
                switch (cbTKtheoTC.getSelectedIndex())
                {
                    case 0:
                    {                                            
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNnv(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNnv(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong2TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;
                    case 1:
                    {
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNncc(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNncc(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong1TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    case 2:
                    {
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNall(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNall(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong1TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                }
            }
        });      
        btnTKsum3TC.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Vector header2 = new Vector();
                header2.add("ID phiếu nhập");
                header2.add("Id nhân viên");
                header2.add("Id nhà cung cấp");
                header2.add("Ngày nhập");
                header2.add("Tổng tiền");
                switch (cbTKtheoTC.getSelectedIndex())
                {
                    case 0:
                    {                                            
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNnv(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNnv(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong3TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                    }
                    break;
                    case 1:
                    {
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNncc(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNncc(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong1TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    case 2:
                    {
                        try {
                            //Check xem ô textfield
                            if (txtTKnhapid2.getText().toString().isEmpty()) 
                            {                         
                                JOptionPane.showMessageDialog(null, "Chưa nhập id thống kê");
                                return;
                            }
                            //Làm cho table trống rỗng
                            for (int i = 0; i < HangNhapBUS.dsHN.size(); i++) {
                                modelTKtheoTC.removeRow(0);
                            }
                            ArrayList<HangnhapDTO> temp = null;
                            HangNhapDAO hn_dao = new HangNhapDAO();
                            temp = hn_dao.TKPNall(txtTKnhapid2.getText());
                            HangNhapBUS.dsHN = hn_dao.TKPNall(txtTKnhapid2.getText());                     
                            for (HangnhapDTO hn_dto : temp)
                            {
                                Vector row = new Vector();
                                row.add(hn_dto.getIDPN());
                                row.add(hn_dto.getIDNV());
                                row.add(hn_dto.getIDNCC());
                                row.add(hn_dto.getNgayNhap());
                                row.add(hn_dto.getTongTien());
                                modelTKtheoTC.addRow(row);
                            }                            
                            int sum2 = 0;
                            for (HangnhapDTO hn_dto : temp) 
                            {
                                sum2 += hn_dto.getTongTien();
                            }
                            txtTKtong1TC.setText(String.valueOf(sum2));
                            
                            //temp = hd_dao.TKHDnvTheongay(txtTKnhapid.getText(), dateTKbegintheoHD.getDateFormatString(), dateTKendtheoHD.getDateFormatString());
                            tblTKtheoTC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            tblTKtheoTC.getColumnModel().getColumn(0).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(1).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(2).setPreferredWidth(180);
                            tblTKtheoTC.getColumnModel().getColumn(3).setPreferredWidth(210);
                            tblTKtheoTC.getColumnModel().getColumn(4).setPreferredWidth(210);
                        } catch (Exception ex) {
                            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                }
            }
        });
        
        pTK.add(lbDSTKtheoTC);

        //CHỌN LOẠI THỐNG KÊ   
        btnTKHoaDon.setFocusPainted(false);
        btnTKTongChi.setFocusPainted(false);
        lbTKnhaploaiTC.setVisible(false);
        cbTKtheoTC.setVisible(false);
        txtTKnhapid2.setVisible(false);
        txtTKtong1TC.setVisible(false);
        txtTKtong2TC.setVisible(false);
        txtTKtong3TC.setVisible(false);
        dateTKbegintheoTC.setVisible(false);
        dateTKendtheoTC.setVisible(false);
        cbTKtheoTCthangA.setVisible(false);
        cbTKtheoTCnamA.setVisible(false);
        btnTKsum1TC.setVisible(false);
        btnTKsum2TC.setVisible(false);
        btnTKsum3TC.setVisible(false);
        btnRefreshTK2.setVisible(false);
        lbTKtimebeginTC.setVisible(false);
        lbTKtimeendTC.setVisible(false);
        btnTKngayTC.setVisible(false);
        btnTKthangTC.setVisible(false);
        btnTKnamTC.setVisible(false);
        lbDSTKtheoTC.setVisible(false);
        tblTKtheoTC.setVisible(false);
        scrollTKtheoTC.setVisible(false);

        btnTKHoaDon.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(118, 255, 3)));
        btnTKHoaDon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnTKHoaDon.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(118, 255, 3)));
                btnTKTongChi.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(118, 255, 3)));
                lbTKnhaploai.setVisible(true);
                cbTKtheoHD.setVisible(true);
                txtTKnhapid.setVisible(true);
                txtTKtong1.setVisible(true);
                txtTKtong2.setVisible(true);
                txtTKtong3.setVisible(true);
                dateTKbegintheoHD.setVisible(true);
                dateTKendtheoHD.setVisible(true);
                cbTKtheoHDthangA.setVisible(true);
                cbTKtheoHDnamA.setVisible(true);
                btnTKsum1.setVisible(true);
                btnTKsum2.setVisible(true);
                btnTKsum3.setVisible(true);
                btnRefreshTK1.setVisible(true);
                lbTKtimebegin.setVisible(true);
                lbTKtimeend.setVisible(true);
                btnTKngay.setVisible(true);
                btnTKthang.setVisible(true);
                btnTKnam.setVisible(true);
                lbDSTKtheoHD.setVisible(true);
                btnTKHoaDon.setVisible(true);
                btnTKTongChi.setVisible(true);
                tblTKtheoHD.setVisible(true);
                scrollTKtheoHD.setVisible(true);
                //             
                lbTKnhaploaiTC.setVisible(false);
                cbTKtheoTC.setVisible(false);
                txtTKnhapid2.setVisible(false);
                txtTKtong1TC.setVisible(false);
                txtTKtong2TC.setVisible(false);
                txtTKtong3TC.setVisible(false);
                dateTKbegintheoTC.setVisible(false);
                dateTKendtheoTC.setVisible(false);
                cbTKtheoTCthangA.setVisible(false);
                cbTKtheoTCnamA.setVisible(false);
                btnTKsum1TC.setVisible(false);
                btnTKsum2TC.setVisible(false);
                btnTKsum3TC.setVisible(false);
                btnRefreshTK2.setVisible(false);
                lbTKtimebeginTC.setVisible(false);
                lbTKtimeendTC.setVisible(false);
                btnTKngayTC.setVisible(false);
                btnTKthangTC.setVisible(false);
                btnTKnamTC.setVisible(false);
                lbDSTKtheoTC.setVisible(false);
                btnTKHoaDon.setVisible(true);
                btnTKTongChi.setVisible(true);
                tblTKtheoTC.setVisible(false);
                scrollTKtheoTC.setVisible(false);
            }
        });
        btnTKTongChi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnTKHoaDon.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(118, 255, 3)));
                btnTKTongChi.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(118, 255, 3)));
                lbTKnhaploaiTC.setVisible(true);
                cbTKtheoTC.setVisible(true);
                txtTKnhapid2.setVisible(true);
                txtTKtong1TC.setVisible(true);
                txtTKtong2TC.setVisible(true);
                txtTKtong3TC.setVisible(true);
                dateTKbegintheoTC.setVisible(true);
                dateTKendtheoTC.setVisible(true);
                cbTKtheoTCthangA.setVisible(true);
                cbTKtheoTCnamA.setVisible(true);
                btnTKsum1TC.setVisible(true);
                btnTKsum2TC.setVisible(true);
                btnTKsum3TC.setVisible(true);
                btnRefreshTK2.setVisible(true);
                lbTKtimebeginTC.setVisible(true);
                lbTKtimeendTC.setVisible(true);
                btnTKngayTC.setVisible(true);
                btnTKthangTC.setVisible(true);
                btnTKnamTC.setVisible(true);
                lbDSTKtheoTC.setVisible(true);
                tblTKtheoTC.setVisible(true);
                scrollTKtheoTC.setVisible(true);
                //
                lbTKnhaploai.setVisible(false);
                cbTKtheoHD.setVisible(false);
                txtTKnhapid.setVisible(false);
                txtTKtong1.setVisible(false);
                txtTKtong2.setVisible(false);
                txtTKtong3.setVisible(false);
                dateTKbegintheoHD.setVisible(false);
                dateTKendtheoHD.setVisible(false);
                cbTKtheoHDthangA.setVisible(false);
                cbTKtheoHDnamA.setVisible(false);
                btnTKsum1.setVisible(false);
                btnTKsum2.setVisible(false);
                btnTKsum3.setVisible(false);
                btnRefreshTK1.setVisible(false);
                lbTKtimebegin.setVisible(false);
                lbTKtimeend.setVisible(false);
                btnTKngay.setVisible(false);
                btnTKthang.setVisible(false);
                btnTKnam.setVisible(false);
                lbDSTKtheoHD.setVisible(false);
                btnTKHoaDon.setVisible(true);
                btnTKTongChi.setVisible(true);
                tblTKtheoHD.setVisible(false);
                scrollTKtheoHD.setVisible(false);

            }
        });
             
    }

    private void close() {   //=================================================================================CLOSE
        // panel logo add vào hướng bắc
        //add đông tây nam bắc center lên jframe
        this.add(pE, BorderLayout.EAST);
        this.add(pW, BorderLayout.WEST);
        this.add(pS, BorderLayout.SOUTH);
        this.add(pN, BorderLayout.NORTH);
        this.add(pCT, BorderLayout.CENTER);

        pE.setVisible(false);
        pW.setVisible(false);
        pS.setVisible(true);
        pN.setVisible(true);
        pCT.setVisible(false);

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(rootPane.NONE);
        //=> bỏ thanh tiêu đề phía trên

        this.setResizable(false); //không cho phóng to thu nhỏ frame
        this.setVisible(true);
    }
    
}
