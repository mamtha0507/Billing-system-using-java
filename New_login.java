
package billingsystem;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class New_login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2,t3;
    JButton b1,b2; 
    New_login(){
        super("Sign Up Page");
        setLayout(new BorderLayout());
        l1=new JLabel("New User Name");
        l1.setBounds(40,20,120,50);
        add(l1);
        l2=new JLabel("Password");
        l2.setBounds(40,100,120,50);
        add(l2);
        l3=new JLabel("Confirm Password");
        l3.setBounds(40,180,120,50);
        add(l3);
        t1=new JTextField();
        t1.setBounds(180,30,150,30);
        add(t1);
        t2=new JPasswordField();
        t2.setBounds(180,110,150,30);
        add(t2);
        t3=new JPasswordField();
        t3.setBounds(180,190,150,30);
        add(t3);
        
        b1=new JButton("Sign Up",new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/user.jpg.jpeg")));
        b1.setBounds(60,280,120,30);
        b1.addActionListener(this);
        add(b1);
       
        b2=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/cancel.jpg.jpeg")));
        b2.setBounds(240,280,120,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/user.jpg.jpeg"));
        Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3=new JLabel(i3); 
        l3.setBounds(380,50,190,190);
        add(l3);
        getContentPane().setBackground(Color.WHITE);
        
       
        setLayout(null);
        setBounds(500,250,600,390);
        setVisible(true);
}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1)
    {
        String u=t1.getText();
        String v=t2.getText();
        String w=t3.getText();
        if(v.equals(w))
        {
            System.out.println("Password matches");
            String str="insert into login values('"+u+"','"+v+"')";
            try{
                conn c=new conn();
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New User Created");
                new login().setVisible(true);
                this.setVisible(false);
                }
            catch(Exception e){
            e.printStackTrace();
        }
    }
        else{
            JOptionPane.showMessageDialog(null, "wrong password");
            setVisible(false);
            }
    }
    else if(ae.getSource()==b2){
            System.exit(0);
        }
    }

public static void main(String[] args){
        new New_login();
   }
}