package gui;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.ScoreDAO;
import org.bson.Document;
import pojo.Score;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class KetQua extends JPanel{
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }

    private final JLabel lbl_studentID;
    private final JTextField txt_studentID;
    private final JLabel lbl_subjectID;
    private final JTextField txt_subjectID;
    private final JLabel lbl_midterm;
    private final JTextField txt_midterm;
    private final JLabel lbl_final;
    private final JTextField txt_final;
    private final JLabel lbl_total;
    private final JTextField txt_total;
    private final JPanel pRegu;
    private final JLabel lbl_regularPoint;
    private final JTextField txt_p1;
    private final JTextField txt_p2;
    private final JTextField txt_p3;
    private final JButton jbuttonloc;
    private final JButton jbuttonImport;
    private final JButton jbuttonExport;
    private final JPanel l1,l2,l3,l4,l5,l6;
    private final JLabel lbl_classID;
    private final JTextField txt_classID;
    private final JPanel filterPanel;
    private final JTextField txtStudentId;
    private final JComboBox<String> cmbClass;
    private final JComboBox<String> cmbSubject;
    private final JPanel pLine1;
    private final JLabel lblStudentId;
    private final JPanel pLine2;
    private final JLabel lblClass;
    private final JPanel pLine3;
    private final JPanel pLine4;
    private final JTextField txtMinMidScore;
    private final JTextField txtMaxMidScore;
    private final JPanel pLine5;
    private final JTextField txtMinFinalScore;
    private final JPanel pLine6;
    private final JTextField txtMaxFinalScore;
    private final JTextField txtMinTotalScore;
    private final JTextField txtMaxTotalScore;
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
    private ScoreDAO dao;

    public KetQua(MongoDatabase db) {
        dao = new ScoreDAO(db);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        jpn = new JPanel(new FlowLayout());
        jpn.setBackground(Color.LIGHT_GRAY);
        boxmainnorth = Box.createVerticalBox();
        boxnorth = Box.createVerticalBox();
        boxnorth1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jl1 = new JLabel("KẾT QUẢ HỌC TẬP", SwingConstants.CENTER);
        jl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jl1.setFont(new Font("Arial", Font.BOLD, 30));
        jl1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

//        jltimkiem = new JLabel("Tìm Kiếm");
//
//        jltimkiem.setBorder(BorderFactory.createEmptyBorder(0, 250, 0, 0));
//        txttimkiem = new JTextField(30);
//        txttimkiem.setPreferredSize(new Dimension(120, 25));
        boxnorth.add(jl1);
        boxnorth.add(Box.createVerticalStrut(10));
//        boxnorth1.add(jltimkiem);
//        boxnorth1.add(Box.createHorizontalStrut(5));
//        boxnorth1.add(txttimkiem);
        boxnorth1.setOpaque(false);
        boxnorth.add(boxnorth1);
        boxmainnorth.add(boxnorth);

        jpn1 = new JPanel(new BorderLayout());
        jpn1.setPreferredSize(new Dimension(900, 40));
        jpn1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jpn1.setBackground(Color.LIGHT_GRAY);


        jln1 = new JLabel("Thông tin");
        jln1.setFont(new Font("Arial", Font.BOLD, 14));
        jln2 = new JLabel("Chọn Chức Năng", SwingConstants.RIGHT);
        jln2.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
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
        jpc.setPreferredSize(new Dimension(800, 300));
        //jpanel-left

        jpcl = new TranslucentRoundedPanel(30, 0.50f);
        jpcl.setLayout(new BorderLayout());
        jpcl.setOpaque(false);
        jpcl.setPreferredSize(new Dimension(700, 200));
        jpcl.setBackground(Color.LIGHT_GRAY);
        jpcl.setBorder(BorderFactory.createCompoundBorder(jpcl.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        //jpanel-left-left
        jpll = new JPanel();
        jpll.setOpaque(false);
        jpll.setBackground(Color.LIGHT_GRAY);
        jpll.setBorder(BorderFactory.createEmptyBorder(25, 20, 0, 0));


        //jpanel-left-center
        jplc = new JPanel();
        jplc.setOpaque(false);
        jplc.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        boxjplc = box.createHorizontalBox();
        boxjplc1 = box.createVerticalBox();
        boxjplc2 = box.createVerticalBox();
        lbl_regularPoint = new JLabel("Điểm thường kỳ");
//        lbl_regularPoint.setFont(new Font("Arial", Font.BOLD, 14));
        lbl_studentID = new JLabel("Mã sinh viên");
        lbl_studentID.setPreferredSize(lbl_regularPoint.getPreferredSize());
//        lbl_studentID.setFont(new Font("Arial", Font.BOLD, 14));
        LineBorder lb = new LineBorder(Color.white, 3, true);
        txt_studentID = new JTextField(10);
        txt_studentID.setBorder(lb);

        lbl_subjectID = new JLabel("Mã học phần");
        lbl_subjectID.setPreferredSize(lbl_regularPoint.getPreferredSize());
//        lbl_subjectID.setFont(new Font("Arial", Font.BOLD, 14));
        txt_subjectID = new JTextField(10);
        txt_subjectID.setBorder(lb);

        lbl_classID = new JLabel("Lớp học phần");
//        lbl_classID.setFont(new Font("Arial", Font.BOLD, 14));
        lbl_classID.setPreferredSize(lbl_regularPoint.getPreferredSize());
        txt_classID = new JTextField(10);
        txt_classID.setBorder(lb);

        pRegu = new JPanel();
        txt_p1 = new JTextField(3);
        txt_p2 = new JTextField(3);
        txt_p3 = new JTextField(3);

        pRegu.add(txt_p1);
        pRegu.add(txt_p2);
        pRegu.add(txt_p3);

         lbl_midterm = new JLabel("Điểm giữa kỳ");
        lbl_midterm.setPreferredSize(lbl_regularPoint.getPreferredSize());
//        lbl_midterm.setFont(new Font("Arial", Font.BOLD, 14));
         txt_midterm = new JTextField(10);
        txt_midterm.setBorder(lb);

         lbl_final = new JLabel("Điểm cuối kỳ");
        lbl_final.setPreferredSize(lbl_regularPoint.getPreferredSize());
//        lbl_final.setFont(new Font("Arial", Font.BOLD, 14));
         txt_final = new JTextField(10);
        txt_final.setBorder(lb);

         lbl_total = new JLabel("Điểm tổng kết");
        lbl_total.setPreferredSize(lbl_regularPoint.getPreferredSize());
//        lbl_total.setFont(new Font("Arial", Font.BOLD, 14));
         txt_total = new JTextField(10);
        txt_total.setBorder(lb);
        txt_total.setEditable(false);
        //add


        l1 = new JPanel();
        l1.setLayout(new BoxLayout(l1, BoxLayout.X_AXIS));
        l1.add(lbl_studentID);
        l1.add(Box.createHorizontalStrut(10));
        l1.add(txt_studentID);

        l2 = new JPanel();
        l2.setLayout(new BoxLayout(l2, BoxLayout.X_AXIS));
        l2.add(lbl_classID);
        l2.add(Box.createHorizontalStrut(10));
        l2.add(txt_classID);

        l3 = new JPanel();
        l3.setLayout(new BoxLayout(l3, BoxLayout.X_AXIS));
        l3.add(lbl_subjectID);
        l3.add(Box.createHorizontalStrut(10));
        l3.add(txt_subjectID);

        l4 = new JPanel();
        l4.setLayout(new BoxLayout(l4, BoxLayout.X_AXIS));
        l4.add(lbl_regularPoint);
        l4.add(Box.createHorizontalStrut(10));
        l4.add(pRegu);

        l5 = new JPanel();
        l5.setLayout(new BoxLayout(l5, BoxLayout.X_AXIS));
        l5.add(lbl_final);
        l5.add(Box.createHorizontalStrut(10));
        l5.add(txt_final);

        l6 = new JPanel();
        l6.setLayout(new BoxLayout(l6, BoxLayout.X_AXIS));
        l6.add(lbl_total);
        l6.add(Box.createHorizontalStrut(10));
        l6.add(txt_total);


        boxjplc2.add(l1);
        boxjplc2.add(Box.createVerticalStrut(10));
        boxjplc2.add(l2);
        boxjplc2.add(Box.createVerticalStrut(10));
        boxjplc2.add(l3);
        boxjplc2.add(Box.createVerticalStrut(10));
        boxjplc2.add(l4);
        boxjplc2.add(Box.createVerticalStrut(10));
        boxjplc2.add(l5);
        boxjplc2.add(Box.createVerticalStrut(10));
        boxjplc2.add(l6);
        boxjplc2.add(Box.createVerticalStrut(10));


        filterPanel = new JPanel();
        filterPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Chức năng lọc dữ liệu",
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14), new Color(70, 130, 180)));

        pLine1 = new JPanel();
        pLine1.setLayout(new BoxLayout(pLine1, BoxLayout.X_AXIS));
        lblStudentId = new JLabel("Mã sinh viên:");
        lblStudentId.setPreferredSize(new Dimension(100, 0));
        txtStudentId = new JTextField(15);
        pLine1.add(lblStudentId);
        pLine1.add(txtStudentId);

        pLine2 = new JPanel();
        pLine2.setLayout(new BoxLayout(pLine2, BoxLayout.X_AXIS));
        lblClass = new JLabel("Lớp học phần:");
        lblClass.setPreferredSize(lblStudentId.getPreferredSize());
        String[] classes = {"Chọn lớp học phần", "CS101", "CS102", "CS201", "MA101", "PH101"};
        cmbClass = new JComboBox<>(classes);
        pLine2.add(lblClass);
        pLine2.add(cmbClass);


        pLine3 = new JPanel();
        pLine3.setLayout(new BoxLayout(pLine3, BoxLayout.X_AXIS));
        JLabel lblSubject = new JLabel("Môn học:");
        lblSubject.setPreferredSize(lblStudentId.getPreferredSize());
        String[] subjects = {"Chọn môn học", "Lập trình Java", "Cơ sở dữ liệu", "Mạng máy tính", "Toán rời rạc", "Vật lý đại cương"};
        cmbSubject = new JComboBox<>(subjects);
        pLine3.add(lblSubject);
        pLine3.add(cmbSubject);


        pLine4 = new JPanel();
        pLine4.setLayout(new BoxLayout(pLine4, BoxLayout.X_AXIS));
        JLabel lblScoreRange = new JLabel("Điểm giữa kì:");
        lblScoreRange.setPreferredSize(lblStudentId.getPreferredSize());

        txtMinMidScore = new JTextField(5);
        txtMaxMidScore = new JTextField(5);
        JLabel lblScoreTo = new JLabel("đến");
        pLine4.add(lblScoreRange);
        pLine4.add(txtMinMidScore);
        pLine4.add(lblScoreTo);
        pLine4.add(txtMaxMidScore);

        pLine5 = new JPanel();
        pLine5.setLayout(new BoxLayout(pLine5, BoxLayout.X_AXIS));
        JLabel lblScoreRange1 = new JLabel("Điểm cuối kì:");
        lblScoreRange1.setPreferredSize(lblStudentId.getPreferredSize());

        txtMinFinalScore = new JTextField(5);
        txtMaxFinalScore = new JTextField(5);
        JLabel lblScoreTo1 = new JLabel("đến");
        pLine5.add(lblScoreRange1);
        pLine5.add(txtMinFinalScore);
        pLine5.add(lblScoreTo1);
        pLine5.add(txtMaxFinalScore);

        pLine6 = new JPanel();
        pLine6.setLayout(new BoxLayout(pLine6, BoxLayout.X_AXIS));
        JLabel lblScoreRange2 = new JLabel("Điểm tổng kết:");
        lblScoreRange2.setPreferredSize(lblStudentId.getPreferredSize());

        txtMinTotalScore = new JTextField(5);
        txtMaxTotalScore = new JTextField(5);
        JLabel lblScoreTo2 = new JLabel("đến");
        pLine6.add(lblScoreRange2);
        pLine6.add(txtMinTotalScore);
        pLine6.add(lblScoreTo2);
        pLine6.add(txtMaxTotalScore);

        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.add(pLine1);
        filterPanel.add(box.createVerticalStrut(10));
        filterPanel.add(pLine2);
        filterPanel.add(box.createVerticalStrut(10));
        filterPanel.add(pLine3);
        filterPanel.add(box.createVerticalStrut(10));
        filterPanel.add(pLine4);
        filterPanel.add(box.createVerticalStrut(10));
        filterPanel.add(pLine5);
        filterPanel.add(box.createVerticalStrut(10));
        filterPanel.add(pLine6);



        boxjplc.add(boxjplc2);
        jplc.add(boxjplc);
        boxjplc.add(Box.createHorizontalStrut(20));
        jplc.add(filterPanel);
        jpcl.add(jplc, BorderLayout.CENTER);


        jpc.add(jpcl, BorderLayout.WEST);
        //jp center-right
        jpmaincr = new TranslucentRoundedPanel(30, 0.50f);
        jpmaincr.setBackground(Color.LIGHT_GRAY);
        jpmaincr.setBorder(BorderFactory.createCompoundBorder(
                jpmaincr.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        jpmaincr.setPreferredSize(new Dimension(150, 200));

        boxmaincr = Box.createVerticalBox();
        jpbutton = new JPanel();
        boxjpbutton = box.createVerticalBox();
        jpbutton.setBackground(Color.LIGHT_GRAY);
        jpbutton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jbuttonExport = new JButton("Export");
//        jbuttonExport.setPreferredSize(jbuttonExport.getPreferredSize());
        jbuttonExport.setBackground(Color.white);
        jbuttonthem = new JButton("Thêm");
        jbuttonthem.setBackground(Color.white);
        jbuttonxoa = new JButton("Xóa");
        jbuttonxoa.setPreferredSize(jbuttonExport.getPreferredSize());
        jbuttonxoa.setBackground(Color.white);
        jbuttonsua = new JButton("Sửa");
        jbuttonsua.setPreferredSize(jbuttonExport.getPreferredSize());
        jbuttonsua.setBackground(Color.white);
        jbuttonloc = new JButton("Lọc");
        jbuttonloc.setPreferredSize(jbuttonExport.getPreferredSize());
        jbuttonloc.setBackground(Color.white);
        jbuttonImport = new JButton("Import");
        jbuttonImport.setPreferredSize(jbuttonExport.getPreferredSize());
        jbuttonImport.setBackground(Color.white);

        jbuttonImport.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
            }
        });
        add(jbuttonImport);

        jbuttonthem.setFocusPainted(false);
        jbuttonxoa.setFocusPainted(false);
        jbuttonsua.setFocusPainted(false);
        jbuttonloc.setFocusPainted(false);
        jbuttonImport.setFocusPainted(false);
        jbuttonExport.setFocusPainted(false);


        boxjpbutton.add(box.createVerticalStrut(10));
        boxjpbutton.add(jbuttonthem);
        boxjpbutton.add(box.createVerticalStrut(10));
        boxjpbutton.add(jbuttonxoa);
        boxjpbutton.add(box.createVerticalStrut(10));
        boxjpbutton.add(jbuttonsua);
        boxjpbutton.add(box.createVerticalStrut(10));
        boxjpbutton.add(jbuttonloc);
        boxjpbutton.add(box.createVerticalStrut(10));
        boxjpbutton.add(jbuttonImport);
        boxjpbutton.add(box.createVerticalStrut(10));
        boxjpbutton.add(jbuttonExport);

        boxmaincr.add(boxjpbutton);
        jpmaincr.add(boxmaincr);

        jpc.add(jpmaincr, BorderLayout.EAST);
        this.add(jpc, BorderLayout.CENTER);

        ///jpanel south
        jps = new JPanel();
        jps.setBackground(Color.LIGHT_GRAY);
        boxsouth = box.createVerticalBox();
        jls1 = new JLabel("Danh Sách");
        jls1.setBorder(BorderFactory.createEmptyBorder(0, 350, 0, 20));
        jls1.setFont(new Font("Arial", Font.BOLD, 24));
        boxsouth.add(jls1);
        jps1 = new JPanel();
        jps1.setBackground(Color.LIGHT_GRAY);
        jps1.setSize(new Dimension(00, 300));
        String coll[] = {"StudentID", "SubjectID", "RegularPoint", "MidTerm", "Final", "Total"};
        tablemodel = new DefaultTableModel(coll, 0);
        table = new JTable(tablemodel);
        table.setPreferredScrollableViewportSize(new Dimension(850, 300));
        table.setFillsViewportHeight(true);
        jps1.add(scrollpane = new JScrollPane(table));

        boxsouth.add(jps1);
        jps.add(boxsouth);
        this.add(jps, BorderLayout.SOUTH);
    }

    public void filledTable(){
//        List<Score> sc =
    }
}
