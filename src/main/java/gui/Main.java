package gui;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Main extends JFrame  implements ActionListener{
    private JPanel jpl;
    private JLabel jl1;
    private JLabel jl2;
    private Box box1, box2;
    private JPanel jp2;
	private JPanel jp21;
	private JPanel jp3;
	private JButton jb1;
	private JPanel jp4;
	private JPanel jp5;
	private JButton jb2;
	private JPanel jp6;
	private JPanel jp7;
	private JButton jb3;
	private JPanel jp8;
	private JComponent jp9;
//	private JButton jb4;
	private JPanel jp10;
	private JPanel jp11;
	private JButton jb5;
	private JPanel jp12;
	private JPanel jp13;
	private JButton jb6;
	private JPanel jp14;
	private JPanel jp15;
	private JButton jb7;
	private JPanel jp16;
	private JPanel jp17;
	private JButton jb8;
	private JPanel jp18;
	private JButton jb9;
	private JPanel jp19;
	private JPanel contentPanel;

    private MongoDatabase db;
//    private static final String url = "mongodb://localhost:27017";
//    private  static final String dbName = "23704871";
//
//    public Main() {
//
//    }


    public Main(MongoDatabase db)  {
        this.db = db;
        this.setTitle("^-^");
        setLocationRelativeTo(null);
        // Sidebar panel
        jpl = new JPanel();
        jpl.setBackground(new Color(204, 204, 255));
        jpl.setLayout(new BorderLayout()); // Giữ layout để quản lý tốt hơn

        // 
        box1 = Box.createVerticalBox();
        box2 = Box.createVerticalBox();

        // Labels
        jl1 = new JLabel("Xin chào");
        jl2 = new JLabel("Nguyen Tien Dat - Admin");
        jl1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jl2.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        box2.add(jl1);
        box2.add(Box.createVerticalStrut(10));
        box2.add(jl2);
        
        box1.add(box2);

        // Content sidebar1 tai khoan
        jp2 = new JPanel();
        jp2.setBackground(new Color(204, 204, 255));
        jp2.setPreferredSize(new Dimension(jpl.getWidth(), 80));
        jp3 = new JPanel();
        jp3.setBackground(new Color(204, 204, 255));
		jp3.add(jb1 = new JButton("Tài Khoản"));
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/profile.png"));
		Image img = originalIcon.getImage();
		Image newImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		jb1.setIconTextGap(35);
		jb1.setIcon(new ImageIcon(newImg));
		jb1.setHorizontalTextPosition(JButton.RIGHT);
		
		jb1.setPreferredSize(new Dimension(200,40));
		jb1.setBackground(Color.white);
		jp2.add(jp3);
        box1.add(Box.createVerticalStrut(10));
        
        box1.add(jp2);
        //content sidebar2 mon hoc
        jp4 = new JPanel();
        jp4.setBackground(new Color(204, 204, 255));
        jp4.setPreferredSize(new Dimension(jpl.getWidth(), 80));
        jp5 = new JPanel();
        jp5.setBackground(new Color(204, 204, 255));
		jp5.add(jb2 = new JButton("Môn Học"));
		ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/img/book-stack.png"));
		Image img1 = originalIcon1.getImage();
		Image newImg1 = img1.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		jb2.setIconTextGap(35);
		jb2.setIcon(new ImageIcon(newImg1));
		jb2.setPreferredSize(new Dimension(200,40));
		jb2.setBackground(Color.white);
		jp4.add(jp5);
        
        box1.add(jp4);
        
        
      //content sidebar3 hoc ky
        jp6 = new JPanel();
        jp6.setBackground(new Color(204, 204, 255));
        jp6.setPreferredSize(new Dimension(jpl.getWidth(), 80));
        jp7 = new JPanel();
        jp7.setBackground(new Color(204, 204, 255));
		jp7.add(jb3 = new JButton("Học Kỳ"));
		ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/img/school.png"));
		Image img2 = originalIcon2.getImage();
		Image newImg2 = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		jb3.setIconTextGap(35);
		jb3.setIcon(new ImageIcon(newImg2));
		jb3.setPreferredSize(new Dimension(200,40));
		jb3.setBackground(Color.white);
		jp6.add(jp7);
        
        box1.add(jp6);
        
        
        
        //content sidebar5 lop hoc
        jp10 = new JPanel();
        jp10.setBackground(new Color(204, 204, 255));
        jp10.setPreferredSize(new Dimension(jpl.getWidth(), 80));
        jp11 = new JPanel();
        jp11.setBackground(new Color(204, 204, 255));
		jp11.add(jb5 = new JButton("Lớp Học"));
		ImageIcon originalIcon4 = new ImageIcon(getClass().getResource("/img/group-chat.png"));
		Image img4= originalIcon4.getImage();
		Image newImg4 = img4.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		jb5.setIconTextGap(35);
		jb5.setIcon(new ImageIcon(newImg4));
		jb5.setPreferredSize(new Dimension(200,40));
		jb5.setBackground(Color.white);
		jp10.add(jp11);
        
        box1.add(jp10);
        
     // content sidebar6 - Học phần
        jp12 = new JPanel();
        jp12.setBackground(new Color(204, 204, 255));
        jp12.setPreferredSize(new Dimension(jpl.getWidth(), 80));

        jp13 = new JPanel();
        jp13.setBackground(new Color(204, 204, 255));
        jp13.add(jb6 = new JButton("Học phần"));
        ImageIcon originalIcon5 = new ImageIcon(getClass().getResource("/img/Enroll.png"));
		Image img5= originalIcon5.getImage();
		Image newImg5 = img5.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		jb6.setIconTextGap(35);
		jb6.setIcon(new ImageIcon(newImg5));
        jb6.setPreferredSize(new Dimension(200, 40));
        jb6.setBackground(Color.white);

        jp12.add(jp13);
        box1.add(jp12);
        
     // content sidebar7 - Kết quả
        jp14 = new JPanel();
        jp14.setBackground(new Color(204, 204, 255));
        jp14.setPreferredSize(new Dimension(jpl.getWidth(), 80));

        jp15 = new JPanel();
        jp15.setBackground(new Color(204, 204, 255));
        jp15.add(jb7 = new JButton("Kết quả"));
        ImageIcon originalIcon6 = new ImageIcon(getClass().getResource("/img/research.png"));
		Image img6= originalIcon6.getImage();
		Image newImg6 = img6.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		jb7.setIconTextGap(35);
		jb7.setIcon(new ImageIcon(newImg6));
        jb7.setPreferredSize(new Dimension(200, 40));
        jb7.setBackground(Color.white);

        jp14.add(jp15);
        box1.add(jp14);
        
     // content sidebar8 - Giáo viên
        jp16 = new JPanel();
        jp16.setBackground(new Color(204, 204, 255));
        jp16.setPreferredSize(new Dimension(jpl.getWidth(), 80));

        jp17 = new JPanel();
        jp17.setBackground(new Color(204, 204, 255));
        jp17.add(jb8 = new JButton("Giáo viên"));
        ImageIcon originalIcon7 = new ImageIcon(getClass().getResource("/img/teacher.png"));
		Image img7= originalIcon7.getImage();
		Image newImg7 = img7.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		jb8.setIconTextGap(35);
		jb8.setIcon(new ImageIcon(newImg7));
        jb8.setPreferredSize(new Dimension(200, 40));
        jb8.setBackground(Color.white);

        jp16.add(jp17);
        box1.add(jp16);
        
        jpl.add(box1, BorderLayout.NORTH); 
   
        // content sidebar8 - footer - Account-information
        jp18 = new JPanel();
        jp18.setBackground(new Color(204, 204, 255));
        jp18.setPreferredSize(new Dimension(jpl.getWidth(), 80));

        jp19 = new JPanel();
        jp19.setBackground(new Color(204, 204, 255));
        jp19.add(jb9 = new JButton("Thông Tin Tài Khoản"));
        ImageIcon originalIcon8 = new ImageIcon(getClass().getResource("/img/social-media.png"));
		Image img8= originalIcon8.getImage();
		Image newImg8 = img8.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
		jb9.setIconTextGap(10);
		jb9.setIcon(new ImageIcon(newImg8));
        jb9.setPreferredSize(new Dimension(200,40));
        jb9.setBackground(Color.white);

        jp18.add(jp19);
        
        jpl.add(jp18,BorderLayout.SOUTH);
        
        
        this.add(jpl, BorderLayout.WEST);  
        
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.setPreferredSize(new Dimension((int) (this.getWidth() * 0.8), this.getHeight()));
        this.add(contentPanel, BorderLayout.CENTER);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1200, 800));
        this.setVisible(true);

        // Theo dõi thay đổi kích thước cửa sổ
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updatePanelSize();
            }
        });
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);
        jb9.addActionListener(this);
        
        

    }

    private void updatePanelSize() {
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();
        int panelWidth = (int) (frameWidth * 0.2); 
        int panelHeight = jpl.getHeight() / 10;
        jp2.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jp4.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jp6.setPreferredSize(new Dimension(panelWidth, panelHeight));
        
        jp10.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jp12.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jp14.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jp16.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jp18.setPreferredSize(new Dimension(panelWidth, panelHeight));
        
        jpl.setPreferredSize(new Dimension(panelWidth, frameHeight));
        jpl.revalidate();
        jpl.repaint();
    }

    public static void main(String[] args) {
        String url = "mongodb://localhost:27017";
        String dbName = "23704871";
        MongoClient client = MongoClients.create(url);
        MongoDatabase db  = client.getDatabase(dbName);
        new Main(db);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        contentPanel.removeAll();

        if (source == jb1) {
           contentPanel.add(new TaiKhoan(db.getCollection("accounts")), BorderLayout.CENTER);
        }
        else if(source == jb7){
            contentPanel.add(new KetQua(db), BorderLayout.CENTER);
        }


        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
