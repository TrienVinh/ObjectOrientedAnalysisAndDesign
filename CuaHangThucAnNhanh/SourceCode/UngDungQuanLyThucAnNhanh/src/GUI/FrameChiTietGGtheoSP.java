/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietKM_BUS;
import BUS.SanphamBUS;
import DTO.SanphamDTO;
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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author SonThai
 */
public class FrameChiTietGGtheoSP extends JFrame{
    private JPanel pE, pW, pN, pS, pCT;
    private JLabel lbIDGG, lbIDSP, lbNoiDung ,lbNameOfFrame;
    public JTextField txtIDGG, txtIDSP, txtNoiDung;
    public JButton btnSua, btnCapNhat, btnHoantac, btnThem, btnXoa;
    public JButton btnQuayLai;
    private JComboBox cbIDSPinCTGG;
    
    public FrameChiTietGGtheoSP(){
        initChiTietGGtheoSP();
    }
    
    public void initChiTietGGtheoSP(){
        setSize(550, 270);
        setTitle("Chi Tiết Hóa Đơn");
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
        pCT.setPreferredSize(new Dimension(550, 230));
        pCT.setLayout(null);
        pCT.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        lbNameOfFrame = new JLabel("CHỈNH SỬA CHI TIẾT GIẢM GIÁ THEO SẢN PHẨM", JLabel.CENTER);
        lbNameOfFrame.setBounds(0, 0, 550, 40);
        lbNameOfFrame.setForeground(Color.WHITE);
        lbNameOfFrame.setFont(new Font("Arial", Font.BOLD, 16));
        pN.add(lbNameOfFrame);
        
        lbIDGG = new JLabel("ID hóa đơn");
        lbIDGG.setForeground(Color.BLACK);
        lbIDSP = new JLabel("ID sản phẩm");
        lbIDSP.setForeground(Color.BLACK);
        lbNoiDung= new JLabel("Nội dung");
        lbNoiDung.setForeground(Color.BLACK);
        
        lbIDGG.setBounds(100, 20, 100, 30);
        lbIDSP.setBounds(100, 70, 100, 30);
        lbNoiDung.setBounds(100, 120, 100, 30);
        
        txtIDGG = new JTextField("", 20);
        txtIDGG.setEditable(false);
        txtIDGG.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        txtIDSP = new JTextField("", 20);
        txtIDSP.setEditable(false);
        txtIDSP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        txtNoiDung = new JTextField("", 20);
        txtNoiDung.setEditable(true);
        txtNoiDung.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        txtIDGG.setBounds(200, 25, 250, 25);
        txtIDSP.setBounds(200, 75, 250, 25);
        txtNoiDung.setBounds(200, 125, 250, 25);
        
        btnQuayLai = new JButton("");
        btnQuayLai.setBounds(510, 0, 40, 40);
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
        btnXoa.setBackground(new java.awt.Color(238, 238, 238));
        btnXoa.setBorder(null);
        try {
            BufferedImage imgXoaNCC = ImageIO.read(new File("src/img/delete.png"));
            ImageIcon iconXoaNCC = new ImageIcon(imgXoaNCC.getScaledInstance(20, 20, imgXoaNCC.SCALE_SMOOTH));
            btnXoa.setIcon(iconXoaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnXoa.setEnabled(false);
        
        btnSua = new JButton("Sửa");
        btnSua.setBorder(null);
        btnSua.setForeground(new java.awt.Color(0,0,0));
        btnSua.setBackground(new java.awt.Color(238, 238, 238));
        try {
            BufferedImage imgSuaNCC = ImageIO.read(new File("src/img/edit.png"));
            ImageIcon iconSuaNCC = new ImageIcon(imgSuaNCC.getScaledInstance(20, 20, imgSuaNCC.SCALE_SMOOTH));
            btnSua.setIcon(iconSuaNCC);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnSua.setEnabled(false);
        
        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setBorder(null);
        btnCapNhat.setForeground(new java.awt.Color(0,0,0));
        btnCapNhat.setBackground(new java.awt.Color(238, 238, 238));
        try {
            BufferedImage imgCapNhat = ImageIO.read(new File("src/img/update.png"));
            ImageIcon iconCapNhat = new ImageIcon(imgCapNhat.getScaledInstance(20, 20, imgCapNhat.SCALE_SMOOTH));
            btnCapNhat.setIcon(iconCapNhat);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnCapNhat.setEnabled(false);
        
        
        btnHoantac = new JButton("Hoàn tác");
        btnHoantac.setBorder(null);
        btnHoantac.setForeground(new java.awt.Color(0,0,0));
        btnHoantac.setBackground(new java.awt.Color(255, 82, 82));
        try {
            BufferedImage imgHoantac = ImageIO.read(new File("src/img/cancel.png"));
            ImageIcon iconHoantac = new ImageIcon(imgHoantac.getScaledInstance(20, 20, imgHoantac.SCALE_SMOOTH));
            btnHoantac.setIcon(iconHoantac);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        btnThem.setBounds(50, 180, 80, 30);
        btnSua.setBounds(130, 180, 80, 30);
        btnXoa.setBounds(210, 180, 80, 30);
        btnCapNhat.setBounds(340, 180, 80, 30);
        btnHoantac.setBounds(420, 180, 80, 30); 
        
        //lang nghe su kien
        btnHoantac.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                txtNoiDung.setText("");
            }
        });
        
        ArrayList<String> listSP=new ArrayList<String> ();
        ChiTietKM_BUS bus=new ChiTietKM_BUS();
        bus.getDSCTKM();
        for (SanphamDTO sp_dto : SanphamBUS.danhsach_sp)
        {
            listSP.add(sp_dto.getId());
        }
        String dataSP[]=new String[listSP.size()];
        for (int i=0;i<listSP.size();i++)
        {
            dataSP[i]=listSP.get(i);
        }
        cbIDSPinCTGG=new JComboBox(dataSP);
        cbIDSPinCTGG.setBounds(470, 75, 50, 25);
        cbIDSPinCTGG.setBorder(null);
        cbIDSPinCTGG.setForeground(Color.WHITE);
        cbIDSPinCTGG.setBackground(new java.awt.Color(128, 222, 234));
        
        cbIDSPinCTGG.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                txtIDSP.setText(cbIDSPinCTGG.getSelectedItem().toString());             
            }
        
        });
        
        pCT.add(lbIDGG);
        pCT.add(lbIDSP);
        pCT.add(lbNoiDung);
        pCT.add(txtIDGG);
        pCT.add(txtIDSP);
        pCT.add(txtNoiDung);
        pCT.add(btnThem);
        pCT.add(btnSua);
        pCT.add(btnXoa);
        pCT.add(btnCapNhat);
        pCT.add(btnHoantac);
        pCT.add(cbIDSPinCTGG);
        pN.add(btnQuayLai);
        
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
