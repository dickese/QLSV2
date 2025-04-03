package gui;

import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.*;

public class LoadScreen extends JFrame {
    private JProgressBar progressBar;
	private JLabel label;

    public LoadScreen(MongoDatabase db) {
        setTitle("Loading Screen");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Tạo label
        this.setBackground(new Color(255,255,255));
    	ImageIcon originalicon = new ImageIcon(getClass().getResource("/img/login.gif"));
    	Image img = originalicon.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
    	ImageIcon reicon = new ImageIcon(img);
    	
    	label = new JLabel(reicon);
    	label.setBackground(Color.white);
    	label.setOpaque(true);
        add(label, BorderLayout.CENTER);

        // Tạo thanh tiến trình
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        add(progressBar, BorderLayout.SOUTH);

        setVisible(true);
        loadProgress(db);
    }

    private void loadProgress(MongoDatabase db) {
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(40);
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                progressBar.setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                dispose();
                SwingUtilities.invokeLater(()-> new Main(db));
            }
        };
        worker.execute();
    }
}
