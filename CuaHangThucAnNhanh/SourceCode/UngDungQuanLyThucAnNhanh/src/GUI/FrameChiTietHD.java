/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietHD_BUS;
import BUS.ChiTietKM_BUS;
import BUS.HoaDonBUS;
import BUS.KhuyenMaiBUS;
import BUS.SanphamBUS;
import DTO.ChiTietHD_DTO;
import DTO.ChiTietKM_DTO;
import DTO.HoaDonDTO;
import DTO.KhuyenMaiDTO;
import DTO.SanphamDTO;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author SonThai
 */
public class FrameChiTietHD extends JFrame{
    private JPanel pE, pW, pN, pS, pCT;
    private JLabel lbIDHD, lbIDSP, lbSoLuong, lbDonGia, lbThanhTien, lbTienGiamGia,lbNameOfFrame;
    public JTextField txtIDHD, txtIDSP, txtSoLuong, txtDonGia, txtThanhTien, txtTienGiamGia;
    private JButton btnSua, btnCapNhat, btnHoantac, btnXoa;
    public JButton btnQuayLai,btnThem;
    private JTable tblChiTietHD;
    private JComboBox cbIDSPinCTHD;
    //private double tongTien=0,tongTienGG=0;
    
    public FrameChiTietHD(){
        initChiTietHD();
    }
    
    public void initChiTietHD(){
        setSize(750, 275);
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
        pCT.setPreferredSize(new Dimension(800, 310));
        pCT.setLayout(null);
        pCT.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        
        lbNameOfFrame = new JLabel("CHỈNH SỬA CHI TIẾT HÓA ĐƠN", JLabel.CENTER);
        lbNameOfFrame.setBounds(0, 0, 800, 40);
        lbNameOfFrame.setForeground(Color.WHITE);
        lbNameOfFrame.setFont(new Font("Arial", Font.BOLD, 16));
        pN.add(lbNameOfFrame);
        
        lbIDHD = new JLabel("ID hóa đơn");
        lbIDHD.setForeground(Color.BLACK);
        lbIDSP = new JLabel("ID sản phẩm");
        lbIDSP.setForeground(Color.BLACK);
        lbSoLuong = new JLabel("Số lượng");
        lbSoLuong.setForeground(Color.BLACK);
        lbDonGia = new JLabel("Đơn giá");
        lbDonGia.setForeground(Color.BLACK);
        lbThanhTien = new JLabel("Thành tiền");
        lbThanhTien.setForeground(Color.BLACK);
        lbTienGiamGia = new JLabel("Tiền giảm giá");
        lbTienGiamGia.setForeground(Color.BLACK);
        
        
        lbIDHD.setBounds(50, 20, 100, 30);
        lbIDSP.setBounds(50, 70, 100, 30);
        lbSoLuong.setBounds(50, 120, 100, 30);
        lbDonGia.setBounds(400, 20, 100, 30);
        lbThanhTien.setBounds(400, 70, 100, 30);
        lbTienGiamGia.setBounds(400, 120, 100, 30);
        
        txtIDHD = new JTextField("", 20);
        txtIDHD.setEditable(false);
        txtIDHD.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        txtIDSP = new JTextField("", 20);
        txtIDSP.setEditable(false);
        txtIDSP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        txtSoLuong = new JTextField("", 20);
        txtSoLuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        txtDonGia = new JTextField("", 20);
        txtDonGia.setEditable(false);
        txtDonGia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        txtThanhTien = new JTextField("", 20);
        txtThanhTien.setEditable(false);
        txtThanhTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
        txtTienGiamGia = new JTextField("", 30);
        txtTienGiamGia.setEditable(false);
        txtTienGiamGia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 105, 30)));
                
                
        txtIDHD.setBounds(150, 25, 200, 25);
        txtIDSP.setBounds(150, 75, 200, 25);
        txtSoLuong.setBounds(150, 125, 200, 25);
        txtDonGia.setBounds(500, 25, 200, 25);
        txtThanhTien.setBounds(500, 75, 200, 25);
        txtTienGiamGia.setBounds(500, 125, 200, 25);
        
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
        btnThem.setBounds(50, 180, 100, 30);
        btnSua.setBounds(150, 180, 100, 30);
        btnXoa.setBounds(250, 180, 100, 30);
        btnCapNhat.setBounds(500, 180, 100, 30);
        btnHoantac.setBounds(600, 180, 100, 30); 
        
        ArrayList<String> listSP=new ArrayList<String> ();
        SanphamBUS bus=new SanphamBUS();
        bus.getDSSanpham();
        for (SanphamDTO sp_dto : SanphamBUS.danhsach_sp)
        {
            listSP.add(sp_dto.getId());
        }
        String dataSP[]=new String[listSP.size()];
        for (int i=0;i<listSP.size();i++)
        {
            dataSP[i]=listSP.get(i);
        }
        cbIDSPinCTHD=new JComboBox(dataSP);
        cbIDSPinCTHD.setBounds(350, 75, 50, 25);
        cbIDSPinCTHD.setBorder(null);
        cbIDSPinCTHD.setForeground(Color.WHITE);
        cbIDSPinCTHD.setBackground(new java.awt.Color(128, 222, 234));
        
        pCT.add(lbIDHD);
        pCT.add(lbIDSP);
        pCT.add(lbSoLuong);
        pCT.add(lbDonGia);
        pCT.add(lbThanhTien);
        pCT.add(lbTienGiamGia);
        pCT.add(txtIDHD);
        pCT.add(txtIDSP);
        pCT.add(txtSoLuong);
        pCT.add(txtDonGia);
        pCT.add(txtThanhTien);
        pCT.add(txtTienGiamGia);
        pCT.add(btnThem);
        pCT.add(btnSua);
        pCT.add(btnXoa);
        pCT.add(btnCapNhat);
        pCT.add(btnHoantac);
        pCT.add(cbIDSPinCTHD);
        pN.add(btnQuayLai);
        
//Bắt sự kiện
        btnHoantac.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                txtIDSP.setText("");
                txtSoLuong.setText("");
                txtDonGia.setText("");
                txtThanhTien.setText("");
                txtTienGiamGia.setText("");
            }
        });
        
        cbIDSPinCTHD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                txtIDSP.setText(cbIDSPinCTHD.getSelectedItem().toString());
                SanphamBUS sp_bus=new SanphamBUS ();
                //bus.getDSSanpham(Integer.parseInt(txtIDSP.getText()));
                //SanphamDTO sp_dto=new SanphamDTO();
        //lay don gia cua idsp tuong ung
                for (SanphamDTO sp_dto : sp_bus.getDSSanPham(Integer.parseInt(txtIDSP.getText())))
                {
                    txtDonGia.setText(String.valueOf(sp_dto.getDongia()));
                    if (Integer.parseInt(txtSoLuong.getText()) > Integer.parseInt(sp_dto.getSoluong()))
                    {
                        JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không đủ");
                    }
                    else
                    {
                        int soLuongAfter=Integer.parseInt(sp_dto.getSoluong())-Integer.parseInt(txtSoLuong.getText());
                        sp_dto.setSoluong(String.valueOf(soLuongAfter));
                        try {
        //cap nhat so luong
                            sp_bus.Update(sp_dto);
                        } catch (Exception ex) {
                            Logger.getLogger(FrameChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                txtTienGiamGia.setText(String.valueOf(1.0));
                txtThanhTien.setText(String.valueOf(Integer.parseInt(txtSoLuong.getText())*Integer.parseInt(txtDonGia.getText())*Double.parseDouble(txtTienGiamGia.getText())));
                //tongTien=tongTien+Double.parseDouble(txtThanhTien.getText());
                //tongTienGG=tongTienGG+Double.parseDouble(txtTienGiamGia.getText());
                HoaDonBUS hd_bus=new HoaDonBUS();
                try {
                    //hd_bus.Update(Integer.parseInt(txtIDHD.getText()), tongTien, tongTienGG);
                    hd_bus.Update(Integer.parseInt(txtIDHD.getText()), Double.parseDouble(txtThanhTien.getText()), Double.parseDouble(txtTienGiamGia.getText()));
                } catch (Exception ex) {
                    Logger.getLogger(FrameChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
        
        });
        /*
        btnThem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                txtTienGiamGia.setText("0");
                ChiTietHD_DTO cthd_dto=new ChiTietHD_DTO();
                cthd_dto.setIdHD(Integer.parseInt(txtIDHD.getText()));
                cthd_dto.setIdSP(Integer.parseInt(txtIDSP.getText()));
                cthd_dto.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                cthd_dto.setDonGia(Double.parseDouble(txtDonGia.getText()));
                cthd_dto.setThanhTien(Double.parseDouble(txtThanhTien.getText()));
                cthd_dto.setTienGG(Double.parseDouble(txtTienGiamGia.getText()));
                ChiTietHD_BUS bus=new ChiTietHD_BUS();
                try 
                {
                    bus.Insert(cthd_dto);
                } catch (Exception ex) 
                {
                    Logger.getLogger(FrameChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        */
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
