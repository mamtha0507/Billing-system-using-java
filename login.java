
package billingsystem;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;

    login(){
        super("login page");
        setLayout(new BorderLayout());
        l1=new JLabel("User Name");
        l1.setBounds(40,20,120,50);
        add(l1);
        l2=new JLabel("Password");
        l2.setBounds(40,100,120,50);
        add(l2);
        t1=new JTextField();
        t1.setBounds(150,30,150,30);
        add(t1);
        t2=new JPasswordField();
        t2.setBounds(150,110,150,30);
        add(t2);
        b1=new JButton("Submit",new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/user.jpg.jpeg")));
        b1.setBounds(60,230,120,30);
        b1.addActionListener(this);
        add(b1);
       
        b2=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/submit.jpg.jpeg")));
        b2.setBounds(240,230,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("New User Sign Up",new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/cancel.jpg.jpeg")));
        b3.setBounds(120,300,190,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/user.jpg.jpeg"));
        Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3=new JLabel(i3); 
        l3.setBounds(380,50,190,190);
        add(l3);
        getContentPane().setBackground(Color.WHITE);
        
       
        setLayout(null);
        setBounds(500,200,600,390);
        setVisible(true);
     }
    public void actionPerformed(ActionEvent ae){ //override
        if(ae.getSource()==b1)
        {
         try {    
            conn c1=new conn();
            String u=t1.getText();
            String v=t2.getText();
            String q="select * from login where username='"+u+"' and password='"+v+"'";
            ResultSet rs=c1.s.executeQuery(q); // query execute
            if(rs.next()){
                new home().setVisible(true);
                setVisible(false);
            }// query execute
            
            else{
                JOptionPane.showMessageDialog(null, "Invalid Login");
                setVisible(false);
            }
         }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()==b2){
            System.exit(0);
        }
        else if(ae.getSource()==b3){
            new New_login().setVisible(true);
            this.setVisible(false);
        }
        }
    
    public static void main(String[] args){
        new login();
   }
}