
package GUI;

import DTO.ChiTietPhieuNhapDTO;
import BUS.ChiTietPhieuNhapBUS;
import static BUS.ChiTietPhieuNhapBUS.dsChiTietPN;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SonThai
 */
public class FrameChiTietPN extends  JFrame{
    private JPanel pE, pW, pN, pS, pCT;
    private JLabel lbIDPN, lbIDSP, lbSoLuong, lbGiaNhap ,lbNameOfFrame;
    public JTextField txtIDPN, txtIDSP, txtSoLuong, txtGiaNhap;
    public JButton btnSua, btnCapNhat, btnHoantac, btnQuayLai, btnThem, btnXoa, btnTimIDSP;
    public FrameChiTietPN(){
        initChiTietPN();
    }
    
    public void initChiTietPN(){
        setSize(750, 220);
        setTitle("Chi Tiết Phiếu Nhập");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(0, 0, 0));
        
        pE = new JPanel();
        pE.setBackground(Color.WHITE);
        pE.setPreferredSize(new Dimension(0, 0));
        
        pW = new JPanel();
        pW.setBackground(Color.WHITE);
        pW.setPreferredSize(new Dimension(0, 0));
        
        pS = new JPanel();
        pS.setBackground(Color.WHITE);
        pS.setPreferredSize(new Dimension(0, 0));
        
        pN = new JPanel();
        pN.setBackground(new java.awt.Color(51, 105, 30));
        pN.setPreferredSize(new Dimension(0, 40));
        pN.setLayout(null);
        
        pCT = new JPanel();
        pCT.setBackground(new java.awt.Color(245,245,245));
        pCT.setPreferredSize(new Dimension(750, 180));
        pCT.setLayout(null);
        pCT.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        lbNameOfFrame = new JLabel("CHỈNH SỬA CHI TIẾT PHIẾU NHẬP", JLabel.CENTER);
        lbNameOfFrame.setBounds(0, 0, 750, 40);
        lbNameOfFrame.setForeground(Color.WHITE);
        lbNameOfFrame.setFont(new Font("Arial", Font.BOLD, 16));
        pN.add(lbNameOfFrame);
        
        lbIDPN = new JLabel("ID phiếu nhập");
        lbIDPN.setForeground(Color.BLACK);
        lbIDSP = new JLabel("ID sản phẩm");
        lbIDSP.setForeground(Color.BLACK);
        lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setForeground(Color.BLACK);
        lbGiaNhap = new JLabel("Giá Nhập");
        lbGiaNhap.setForeground(Color.BLACK);
        
        lbIDPN.setBounds(50, 20, 100, 30);
        lbIDSP.setBounds(50, 70, 100, 30);
        lbSoLuong.setBounds(420, 20, 100, 30);
        lbGiaNhap.setBounds(420, 70, 100, 30);
        
        txtIDPN = new JTextField("", 20);
        txtIDPN.setEditable(false);
        txtIDPN.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        txtIDSP = new JTextField("", 20);
        txtIDSP.setEditable(false);
        txtIDSP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        txtSoLuong = new JTextField("", 20);
        txtSoLuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        txtGiaNhap = new JTextField("", 20);
        txtGiaNhap.setEditable(false);
        txtGiaNhap.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        txtIDPN.setBounds(150, 25, 200, 25);
        txtIDSP.setBounds(150, 75, 200, 25);
        txtSoLuong.setBounds(500, 25, 200, 25);
        txtGiaNhap.setBounds(500, 75, 200, 25);
        
        
        btnQuayLai = new JButton("");
        btnQuayLai.setBounds(710, 0, 40, 40);
        btnQuayLai.setBorder(null);
        btnQuayLai.setFocusPainted(false);
        btnQuayLai.setBackground(new java.awt.Color(51, 105, 30));
        try {
            BufferedImage imgBack = ImageIO.read(new File("src/img/back.png"));
            ImageIcon iconBack = new ImageIcon(imgBack.getScaledInstance(35, 35, imgBack.SCALE_SMOOTH));
            btnQuayLai.setIcon(iconBack);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        btnQuayLai.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnQuayLai.setBackground(new java.awt.Color(174, 234, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnQuayLai.setBackground(new java.awt.Color(51, 105, 30));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                btnQuayLai.setBackground(new java.awt.Color(174, 234, 0));
            }
        });

        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {    
                //xử lý tắt bên frameBanHang
            }
        });
        
        btnSua = new JButton("Sửa");
        btnSua.setBorder(null);
        btnSua.setForeground(new java.awt.Color(0,0,0));
        btnSua.setBackground(new java.awt.Color(238, 255, 65));
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSua.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
      
        btnHoantac = new JButton("Nhập lại");
        btnHoantac.setBorder(null);
        btnHoantac.setForeground(new java.awt.Color(0,0,0));
        btnHoantac.setBackground(new java.awt.Color(178, 255, 89));
        try {
            BufferedImage imgHoantac = ImageIO.read(new File("src/img/cancel.png"));
            ImageIcon iconHoantac = new ImageIcon(imgHoantac.getScaledInstance(20, 20, imgHoantac.SCALE_SMOOTH));
            btnHoantac.setIcon(iconHoantac);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        btnThem = new JButton("Thêm");
        btnThem.setBackground(new java.awt.Color(174, 234, 0));
        btnThem.setBorder(null);
        try {
            BufferedImage imgThemNCC = ImageIO.read(new File("src/img/plus.png"));
            ImageIcon iconThemNCC = new ImageIcon(imgThemNCC.getScaledInstance(20, 20, imgThemNCC.SCALE_SMOOTH));
            btnThem.setIcon(iconThemNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        btnXoa = new JButton("Xóa");
        btnXoa.setBackground(new java.awt.Color(255, 82, 82));
        btnXoa.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoa.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        btnTimIDSP = new JButton("Chọn");
        btnTimIDSP.setBackground(new java.awt.Color(178, 255, 89));
        btnTimIDSP.setBorder(null);
        
        btnThem.setBounds(400, 130, 100, 30);
        btnSua.setBounds(500, 130, 100, 30);
        btnXoa.setBounds(600, 130, 100, 30);
        btnHoantac.setBounds(50, 130, 100, 30);
        btnTimIDSP.setBounds(350, 75, 40, 25);
        
        
        pCT.add(lbIDPN);
        pCT.add(lbIDSP);
        pCT.add(lbSoLuong);
        pCT.add(lbGiaNhap);
        pCT.add(txtIDPN);
        pCT.add(txtIDSP);
        pCT.add(txtSoLuong);
        pCT.add(txtGiaNhap);
        pCT.add(btnThem);
        pCT.add(btnSua);
        pCT.add(btnXoa);
        pCT.add(btnHoantac);
        pCT.add(btnTimIDSP);
        pN.add(btnQuayLai);
 
        btnHoantac.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtIDSP.setText("");
                txtSoLuong.setText("");
                txtGiaNhap.setText("");
            }
        });
        
                
        this.add(pE, BorderLayout.EAST);
        this.add(pW, BorderLayout.WEST);
        this.add(pS, BorderLayout.SOUTH);
        this.add(pN, BorderLayout.NORTH);
        this.add(pCT, BorderLayout.CENTER);
        
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(rootPane.NONE);
        this.setResizable(false); //không cho phóng to thu nhỏ frame
        this.setVisible(false);
    }
}
