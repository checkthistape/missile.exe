import javax.swing.JFrame;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Missile {

    static BufferedImage image;

    static int missileImageWidth = 712;
    static int missileImageHeight = 400;

    static String memeSubtitle = "The missile knows";

    public static void main(String[] args)
    {
        JFrame window = new JFrame("The missile");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

       

        double windowWidth = 1280.0;
        double windowHeight = 720.0;

        
         

        BufferedImage mainFrame;
        try {

            image = ImageIO.read(new FileInputStream("missile.jpg"));

            AffineTransform at = new AffineTransform();

            mainFrame = new BufferedImage(missileImageWidth, missileImageHeight, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = mainFrame.createGraphics();

            g.drawImage(image, at, null);
            g.dispose();

            JLabel label = new JLabel();

            LayoutManager overlay = new OverlayLayout(label);
            label.setLayout(overlay);


            JLabel memeText = new JLabel(memeSubtitle);
            memeText.setFont(new Font("Impact", Font.BOLD, 50));
            memeText.setForeground(Color.white);
            memeText.setAlignmentX(0.5f);
            memeText.setAlignmentY(0.99f);

            // FontMetrics metrics = g.getFontMetrics(new Font("Impact", Font.BOLD, 50));
            // System.out.println("Metrics for text (height): " + metrics.getHeight());
            // System.out.println("Metrics for text (width): " + metrics.width

            Rectangle2D f = (new Font("Impact", Font.BOLD, 50)).getStringBounds("memeSubtitle", g.getFontRenderContext());
            System.out.println("F: " + f);

            label.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e){
                    // if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    //     System.out.println("yopyo");
                    // }
                    
                }
    
                @Override
                public void keyTyped(KeyEvent e){}
    
                @Override
                public void keyReleased(KeyEvent e){}

                public void action(String s){
                    memeText.setText("Yoy" + s);
                }
    
            });
            // JLabel memeText2 = new JLabel("The missile knows");
            // memeText2.setFont(new Font("Impact", Font.BOLD, 51));
            // memeText2.setForeground(Color.black);
            // memeText2.setAlignmentX(0.5f);
            // memeText2.setAlignmentY(0.99f);

            // JButton button = new JButton("Click!");
            // button.setAlignmentX(1f);
            // button.setAlignmentY(0.1f);  

            // button.addActionListener(new ActionListener() {
            //     @Override
            //     public void actionPerformed(ActionEvent e){
            //         memeSubtitle = "Lol!";
            //         memeText.setText(memeSubtitle);
                    
            //         // JOptionPane.showMessageDialog(null, "This is even shorter");             
            //     }
            // });
            
            label.add(memeText);

            

            label.setFocusable(true);

            // label.add(memeText2);
            // label.add(button);
            

            //window.add(memeText, BorderLayout.CENTER);
            window.add(label);
            

            
            label.setIcon(new ImageIcon(mainFrame));
            //label.add(memeText);
            //window.
            
            window.pack();
            window.setVisible(true);

            for(int i = 0; i<10; i++){
                memeSubtitle = String.valueOf(i);
                
                System.out.println("yopyo");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    
                    e1.printStackTrace();
                }
                memeText.setText(memeSubtitle);
            }
        }
        catch(Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        

        
        

    }
}