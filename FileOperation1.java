import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOperation1 {

    public static void dummy() {
        System.out.println("Its dummy");
        JFrame f1 = new JFrame();
        f1.setSize(400, 200);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font font = new Font("Roboto", Font.BOLD, 25);
        
        // creating text field

        JTextField textField = new JTextField(10);
        textField.setFont(font);

        // creating button
        JButton button1 = new JButton();
        button1.setText("Choose File");
        button1.setFont(font);

        button1.addActionListener(e -> {
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });
        f1.setLayout(new FlowLayout());
        f1.add(textField);
        f1.add(button1);

        f1.setVisible(true);
      
    }

    public static void operate(int key) {
        System.out.println("In operate");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        // file FileInputStream
        try {

            FileInputStream fis = new FileInputStream(file);

            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("this is testing");

        JFrame f = new JFrame();
        f.setTitle("Cryptography");
        f.setSize(400, 150);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto", Font.BOLD, 25);
        // creating button
        JButton button1 = new JButton();
        button1.setText("ENCRYPT");
        button1.setFont(font);

        JButton button2 = new JButton();
        button2.setText("DECRYPT");
        button2.setFont(font);

        button1.addActionListener(e -> {
            dummy();
          
        });
        button2.addActionListener(e -> {
            dummy();
            
        });

        f.setLayout(new FlowLayout());

        f.add(button1);
        f.add(button2);

        f.setVisible(true);

    }
}
