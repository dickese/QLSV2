package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
class TranslucentRoundedPanel extends JPanel {
    private int cornerRadius;
    private float opacity;

    public TranslucentRoundedPanel(int radius, float opacity) {
        this.cornerRadius = radius;
        this.opacity = opacity;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Màu nền mờ (màu trắng với độ mờ)
        Color backgroundColor = new Color(255, 255, 255, (int)(opacity * 255));
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        
        // Viền mờ
        Color borderColor = new Color(200, 200, 200, 150);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(1f));
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
        
        g2.dispose();
    }
}

public class TaiKhoan extends JPanel {
    private JPanel jpn;
	private JLabel jl1;
	private Box box;
	private JLabel jl2;
	private JPanel jpcl;
	private JLabel iconLabel;
	private JPanel jpc;
	private Box box1;
	private JPanel jpcr;
	private JLabel jl3;
	private JLabel jltaikhoan;
	private JTextField txttaikhoan;
	
	private Box box3;
	private JLabel jlmatkhau;
	private JTextField txtmatkhau;
	private JLabel jlvaitro;
	private JTextField txtvaitro;
	private JLabel jptimkiem;
	private JTextField txtimkiem;
	private Box boxnorth;
	private JLabel jltimkiem;
	private JTextField txttimkiem;
	private JLabel jl4;
	private JPanel boxnorth1;
	private JPanel jpn1;
	private JLabel jln1;
	private JLabel jln2;
	private Box box2;
	private Box boxmainnorth;
	private JPanel jpcc;
	private Box boxjpcr;
	private JLabel jltaikhoan1;
	private JTextField txttaikhoan1;
	private JLabel jlmatkhau1;
	private JTextField txtmatkhau1;
	private JLabel jlvaitro1;
	private JTextField txtvaitro1;
	private Box boxmainjpcr;
	private JButton jbuttonthem;
//	private Box boxmainjpcr;
	private JButton jbuttonxoa;
	private JButton jbuttonsua;
	private JPanel jpbutton;
	private JPanel jps;
	private JLabel jls1;
	private DefaultTableModel tablemodel;
	private JTable table;
	private JPanel jps1;
	private JScrollPane scrollpane;
	private JLabel jls2;
	private Box boxsouth;
	private JPanel jpmaincr;
	private Box boxmaincr;
	private JPanel jpcode;
	private Box boxjpbutton;
	private JPanel jpll;
	private JPanel jplc;
	private Box boxjplc;
	private Box boxjplc1;
	private Box boxjplc2;

	public TaiKhoan()  {
		this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        jpn = new JPanel(new FlowLayout());
        jpn.setBackground(Color.LIGHT_GRAY);
        boxmainnorth = Box.createVerticalBox();
        boxnorth = Box.createVerticalBox();
        boxnorth1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        jl1 = new JLabel("Danh Sách Tài Khoản", SwingConstants.CENTER);
        jl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jl1.setFont(new Font("Arial", Font.BOLD, 30));
        jl1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        jltimkiem = new JLabel("Tìm Kiếm");
        
        jltimkiem.setBorder(BorderFactory.createEmptyBorder(0,250,0,0));
        txttimkiem = new JTextField(30);
        txttimkiem.setPreferredSize(new Dimension(120, 25));
        boxnorth.add(jl1);
        boxnorth.add(Box.createVerticalStrut(10));
        boxnorth1.add(jltimkiem);
        boxnorth1.add(Box.createHorizontalStrut(5));
        boxnorth1.add(txttimkiem);
        boxnorth1.setOpaque(false);
        boxnorth.add(boxnorth1);
        boxmainnorth.add(boxnorth);

        jpn1 = new JPanel(new BorderLayout());
        jpn1.setPreferredSize(new Dimension(900,40));
        jpn1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jpn1.setBackground(Color.LIGHT_GRAY);
        

        jln1 = new JLabel("Thông tin Tài Khoản");
        jln1.setFont(new Font("Arial", Font.BOLD, 14));
        jln2 = new JLabel("Chọn Chức Năng",SwingConstants.RIGHT);
        jln2.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
        jln2.setFont(new Font("Arial", Font.BOLD, 14));

        jpn1.add(jln1, BorderLayout.WEST);
        jpn1.add(jln2, BorderLayout.CENTER);

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(jpn1, BorderLayout.CENTER);
        boxmainnorth.add(wrapperPanel);

        jpn.add(boxmainnorth, BorderLayout.NORTH);
        this.add(jpn, BorderLayout.NORTH);
    	
    	
    	//jp center
    	jpc = new JPanel();
    	jpc.setLayout(new BorderLayout());
    	jpc.setBackground(Color.LIGHT_GRAY);
    	jpc.setPreferredSize(new Dimension(800,300));
    	//jpanel-left
    	
    	jpcl = new TranslucentRoundedPanel(30, 0.50f);
    	jpcl.setLayout(new BorderLayout());
    	jpcl.setOpaque(false);
    	jpcl.setPreferredSize(new Dimension(700,200));
    	jpcl.setBackground(Color.LIGHT_GRAY);
    	jpcl.setBorder(BorderFactory.createCompoundBorder(jpcl.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    	
    	//jpanel-left-left
    	jpll = new JPanel();
    	jpll.setOpaque(false);
    	jpll.setBackground(Color.LIGHT_GRAY);
    	jpll.setBorder(BorderFactory.createEmptyBorder(25,20,0,0));
    	ImageIcon originalicon = new ImageIcon(getClass().getResource("/profile.png"));
    	Image img = originalicon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
    	ImageIcon reicon = new ImageIcon(img);
    	jl2 = new JLabel(reicon);
    	jl2.setBackground(Color.LIGHT_GRAY);
    	jpll.add(jl2);
    	jpcl.add(jpll,BorderLayout.WEST);
    	
    	
    	
    	//jaypanel-left-center
    	jplc = new JPanel();
    	jplc.setOpaque(false);
    	jplc.setBorder(BorderFactory.createEmptyBorder(25,0,0,20));
    	boxjplc = box.createHorizontalBox();
    	boxjplc1 = box.createVerticalBox();
    	boxjplc2 = box.createVerticalBox();
    	jltaikhoan = new JLabel("Tên Tài Khoản");
    	jltaikhoan.setFont(new Font("Arial",Font.BOLD,14));
    	LineBorder lb = new LineBorder(Color.white,3,true);
    	txttaikhoan = new JTextField(10);
    	txttaikhoan.setBorder(lb);
    	
    	jlmatkhau = new JLabel("Mật Khẩu");
    	jlmatkhau.setFont(new Font("Arial",Font.BOLD,14));
    	txtmatkhau = new JTextField(10);
    	txtmatkhau.setBorder(lb);
    	
    	jlvaitro = new JLabel("Vai Trò");
    	jlvaitro.setFont(new Font("Arial",Font.BOLD,14));
    	txtvaitro = new JTextField(10);
    	txtvaitro.setBorder(lb);
    	//add
    	boxjplc1.add(jltaikhoan);
    	boxjplc1.add(box.createVerticalStrut(9));
    	
    	boxjplc1.add(jlmatkhau);
    	boxjplc1.add(box.createVerticalStrut(8));
    	boxjplc1.add(jlvaitro);
    	
    	boxjplc2.add(txttaikhoan);
    	boxjplc2.add(box.createVerticalStrut(5));
    	boxjplc2.add(txtmatkhau);
    	boxjplc2.add(box.createVerticalStrut(5));
    	boxjplc2.add(txtvaitro);    	
    	boxjplc.add(boxjplc1);
    	boxjplc.add(box.createHorizontalStrut(10));
    	boxjplc.add(boxjplc2);
    	boxjplc.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
    	   	
    	jplc.add(boxjplc);
    	jpcl.add(jplc,BorderLayout.CENTER);
    	
    	
    	
    	jpc.add(jpcl,BorderLayout.WEST);
    	//jp center-right
    	jpmaincr = new TranslucentRoundedPanel(30, 0.50f); // Thêm góc bo tròn và độ trong suốt
    	jpmaincr.setBackground(Color.LIGHT_GRAY);
    	jpmaincr.setBorder(BorderFactory.createCompoundBorder(
    	    jpmaincr.getBorder(), 
    	    BorderFactory.createEmptyBorder(10, 10, 10, 10)
    	));
    	jpmaincr.setPreferredSize(new Dimension(150, 200)); // Kích thước tương đương jpcl

    	boxmaincr = Box.createVerticalBox();
    	// Nút bấm
    	jpbutton = new JPanel();
    	boxjpbutton = box.createVerticalBox();
    	jpbutton.setBackground(Color.LIGHT_GRAY);
    	jpbutton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    	jbuttonthem = new JButton("Thêm");
    	jbuttonthem.setBackground(Color.white);
    	jbuttonxoa = new JButton("  Xóa ");
    	jbuttonxoa.setBackground(Color.white);
    	jbuttonsua = new JButton("  Sửa ");
    	jbuttonsua.setBackground(Color.white);
    	
    	jbuttonthem.setFocusPainted(false);
    	jbuttonxoa.setFocusPainted(false);
    	jbuttonsua.setFocusPainted(false);
    	
    	
    	boxjpbutton.add(box.createVerticalStrut(10));
    	boxjpbutton.add(jbuttonthem);
    	boxjpbutton.add(box.createVerticalStrut(10));
    	boxjpbutton.add(jbuttonxoa);
    	boxjpbutton.add(box.createVerticalStrut(10));
    	boxjpbutton.add(jbuttonsua);
    	
    	boxmaincr.add(boxjpbutton);
    	jpmaincr.add(boxmaincr);

    	jpc.add(jpmaincr, BorderLayout.EAST);
    	this.add(jpc,BorderLayout.CENTER);
    	
    	///jpanel south
    	jps = new JPanel();
    	jps.setBackground(Color.LIGHT_GRAY);
    	boxsouth = box.createVerticalBox();
    	jls1 = new JLabel("Danh Sách");
    	jls1.setBorder(BorderFactory.createEmptyBorder(0,350,0,20));
    	jls1.setFont(new Font("Arial",Font.BOLD,24));
    	boxsouth.add(jls1);
    	jps1 = new JPanel();
    	jps1.setBackground(Color.LIGHT_GRAY);
    	jps1.setSize(new Dimension(00,300));
    	String coll[] = {"Tên Tài Khoản","Mật Khẩu","Vai Trò"};
    	
    	tablemodel = new DefaultTableModel(coll,0);
    	
    	table = new JTable(tablemodel);
    	table.setPreferredScrollableViewportSize(new Dimension(850, 300));
    	table.setFillsViewportHeight(true);
    	jps1.add(scrollpane = new JScrollPane(table));
 
    	boxsouth.add(jps1);
    	jps.add(boxsouth);
    	this.add(jps,BorderLayout.SOUTH);
    }
}
