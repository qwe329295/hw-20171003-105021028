

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jpnc =new JPanel(new GridLayout(7,1,3,3));
    private JButton btn1 =new JButton("範例文");
    private JButton btn2 =new JButton("加密");
    private JButton btn3 =new JButton("清除");
    private JButton btn4 =new JButton("解密");
    private JButton btn5 =new JButton("EXIT");
    private JLabel lab  =new JLabel("Key");
    private JTextField jtf =new JTextField();
    private JTextArea jtaL =new JTextArea();
    private JTextArea jtaR =new JTextArea();
    private JScrollPane jspL =new JScrollPane(jtaL);
    private JScrollPane jspR =new JScrollPane(jtaR);

    public MainFrame(){
         init();
     }
    private void init(){
         this.setBounds(150,200,500,600);
         this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         cp=this.getContentPane();
         cp.setLayout(new BorderLayout(3,3));
         cp.add(jpnc,BorderLayout.CENTER);
         cp.add(jspL,BorderLayout.WEST);
         cp.add(jspR,BorderLayout.EAST);

         jpnc.add(btn1);
         jpnc.add(btn2);
         jpnc.add(lab);
         lab.setHorizontalAlignment(JLabel.CENTER);
         jpnc.add(jtf);
         jpnc.add(btn3);
         jpnc.add(btn4);
         jpnc.add(btn5);

         jtaL.setPreferredSize(new Dimension(200,400));
         jtaR.setPreferredSize(new Dimension(200,400));
         jtaL.setLineWrap(true);
         jtaR.setLineWrap(true);

         btn1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jtaL.setText("The Department of Computer Science and Information Engineering," +
                         " formerly the Department of Information Technology, was established in 2001. " +
                         "The department first offered a Master program only. In 2002, the undergraduate program was" +
                         " established. The Doctoral program was established in 2006. Each year the department admits" +
                         " about 80 undergraduates, 15 graduate students and 3 Ph.D. students.");
             }
         });

         btn2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 char data[]=jtaL.getText().toCharArray();
                 int len=data.length,i=0,k=0;
                 while(i<len){
                     if(k>jtf.getText().length()-1){
                         k=0;
                     }
                     data[i]=(char)((int)data[i]^(int)jtf.getText().charAt(k));
                     i++;
                     k++;
                 }
                 jtaR.setText(new String(data));
             }
         });

         btn3.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jtaL.setText(" ");
                
             }
         });

         btn4.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 char data[]=jtaL.getText().toCharArray();
                 int len=data.length,i=0,k=0;
                 while(i<len){
                     if(k>jtf.getText().length()-1){
                         k=0;
                     }
                     data[i]=(char)((int)data[i]^(int)jtf.getText().charAt(k));
                     i++;
                     k++;
                 }
                 jtaR.setText(new String(data));
             }

         });
         btn5.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
         });
     }
}
