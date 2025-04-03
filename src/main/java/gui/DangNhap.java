package gui;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.AccountDAO;
import org.bson.Document;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class DangNhap extends JFrame implements ActionListener {
    private JPanel jpmain;
	private JLabel jl1;
	private Box box;
	private Box box1;
	private JPanel jpc;
	private JLabel jlc;
	private JPanel jpcr;
	private Box boxdesc;
	private Box boxten;
	private JLabel jlten;
	private JTextField txtten;
	private Box boxmk;
	private JLabel jlmk;
	private Component jltmk;
	private JTextField txtmkk;
	private Component txtmk;
	private JPanel jpcl;
	private ButtonGroup btngr;
	private JRadioButton jbr1;
	private JRadioButton jbr2;
	private JPanel jpbutton;
	private JPanel jpcr1;
	private ButtonGroup grbtn;
	private JPanel jpbtn;
	private JButton jbdangnhap;
	private Box boxbtn;
	private Box boxbtn1;
	private Box boxbtn2;
	private JButton jb2;
    private AccountDAO dao;
    private MongoDatabase db;
	public DangNhap(MongoDatabase db) {
        this.db = db;
        dao = new AccountDAO(db.getCollection("accounts"));
        this.setTitle("Đăng Nhập");
        this.setSize(new Dimension(700, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // Đặt ảnh nền
        URL backgroundURL = getClass().getResource("/img/DangNhap.png");
        BackgroundPanel bgPanel;
        if (backgroundURL != null) {
            bgPanel = new BackgroundPanel(new ImageIcon(backgroundURL).getImage());
        } else {
            System.out.println("Không tìm thấy ảnh nền Background.png");
            bgPanel = new BackgroundPanel(null); 
        }
        bgPanel.setLayout(null); 

        // Thêm các thành phần giao diện
        jpmain = new JPanel();
        jpmain.setOpaque(false);
        jpmain.setBounds(70, 50, 550, 300);
        box = Box.createVerticalBox();
        jl1 = new JLabel("ĐĂNG NHẬP");
        jl1.setFont(new Font("Arial",Font.BOLD,24));
        jl1.setForeground(Color.white);
        jl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(jl1);
        

        jpc = new JPanel();
        jpc.setLayout(new BorderLayout());
        jpc.setPreferredSize(new Dimension(550,250));
        // jpcenter-left
        jpcl = new JPanel();
        ImageIcon imgc = new ImageIcon(getClass().getResource("/img/user.png"));
        Image img = imgc.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon imgc1 = new ImageIcon(img);
        
        jlc = new JLabel(imgc1);
        jlc.setBorder(BorderFactory.createEmptyBorder(30,30,0,0));
        //
        jpcl.add(jlc);
        jpc.add(jpcl,BorderLayout.WEST);
        box.add(jpc);
        //jpcenter-right
        jpcr = new JPanel();
        boxdesc = box.createVerticalBox(); // box toan bo component ben phai 
        boxdesc.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        boxten = box.createHorizontalBox();
        jlten =  new JLabel("Tên Đăng Nhập : ");
        txtten = new JTextField(10);
        boxten.add(jlten);
        
        boxten.add(txtten);
        boxdesc.add(boxten);
        
        boxmk = box.createHorizontalBox();
        boxmk.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        boxmk.add(jlmk = new JLabel("Mật Khẩu : "));
        boxmk.add(box.createHorizontalStrut(35));
        boxmk.add(txtmk = new JPasswordField());
        boxdesc.add(boxmk);
        jpcr.add(boxdesc);
        
        
        
        
        //radiobtn
        jpbtn = new JPanel();
        boxbtn = box.createVerticalBox();
        boxbtn1 = box.createHorizontalBox();
        boxbtn2 = box.createHorizontalBox();
        grbtn = new ButtonGroup();
        jbr1 = new JRadioButton("Nhớ Mật Khẩu?");
        jb2 = new JButton("Quên Mật Khẩu?");
        jb2.setBackground(Color.LIGHT_GRAY); 
        jb2.setForeground(Color.WHITE); 
        jb2.setFont(new Font("Arial", Font.BOLD, 14));
        jb2.setFocusPainted(false);
        jb2.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        grbtn.add(jbr1);
        grbtn.add(jbr2);
        boxbtn1.add(jbr1);
        boxbtn1.add(jb2);
        boxbtn.add(boxbtn1);
        boxbtn2.add(jbdangnhap = new JButton("Đăng Nhập"));
        boxbtn2.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        boxbtn.add(boxbtn2);
        
        jpbtn.add(boxbtn);
        jpcr.add(jpbtn,BorderLayout.SOUTH);
        jpc.add(jpcr,BorderLayout.CENTER);
        box.add(jpc);
        jpmain.add(box);
        bgPanel.add(jpmain);
        
        this.setContentPane(bgPanel);
        this.setVisible(true);
        jbdangnhap.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == jbdangnhap)
		{
			String username = txtten.getText();
			String pwd = new String(((JPasswordField)txtmk).getPassword());
			if(dao.checkLogIn(username, pwd))
			{
                setVisible(false);
                SwingUtilities.invokeLater((() -> new LoadScreen(this.db)));
			}
			else {
				JOptionPane.showMessageDialog(this,"Anh Nhắc Em!!");
			}
		}
	}
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    public BackgroundPanel(Image image) {
        this.backgroundImage = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

