
package billingsystem;



import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
public class Add_client extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    JRadioButton r1,r2;
    
    Add_client(){
        super("Add Client");
        
        JLabel l1=new JLabel("ADD NEW CLIENT");
        l1.setFont(new Font("Tahoma",Font.BOLD,22));
        l1.setBounds(140,12,280,30);
        l1.setForeground(Color.RED);
        add(l1);
        
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(80,100,120,30);
        add(name);
        t1=new JTextField();
        t1.setBounds(230,100,150,30);
        add(t1);
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(80,170,120,30);        
        add(gender);
        
        r1=new JRadioButton("Male");
        r1.setBounds(230,170,80,30);
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(310,170,80,30);
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBackground(Color.WHITE);
        add(r2);               
       
        JLabel address=new JLabel("Address");
        address.setFont(new Font("Tahoma",Font.PLAIN,17));
        address.setBounds(80,240,120,30);
        add(address);
        t6=new JTextField();
        t6.setBounds(230,240,150,30);
        add(t6);
        
        JLabel email=new JLabel("Email");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email.setBounds(80,310,120,30);
        add(email);
        t7=new JTextField();
        t7.setBounds(230,310,150,30);
        add(t7);
        
        JLabel phone=new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(80,380,120,30);
        add(phone);
        t2=new JTextField();
        t2.setBounds(230,380,150,30);
        add(t2);
      
        b1 = new JButton("Add Client" ,new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/ok.jpeg")));
        b1.setBounds(40,480,190,40);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.BOLD,18));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel" ,new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/delete.jpeg")));
        b2.setBounds(280,480,190,40);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.BOLD,18));
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);                   
        setLayout(null);
        setBounds(460,80,520,620);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
                
                String name = t1.getText();
                String gender  = null;
                if(r1.isSelected()){
                    gender = "Male";
                }else if(r2.isSelected()){
                    gender = "Female";
                }
                //String name = t1.getText();
                String phone = t2.getText();
                String email = t7.getText();
                String address = t6.getText();
                
                conn c1=new conn();
                try{
                    String qry = "insert into client values('"+name+"','"+gender+"','"+phone+"','"+email+"','"+address+"')";          
                    c1.s.executeUpdate(qry);
                    JOptionPane.showMessageDialog(null,"New Client Added");
                    
                }
                catch(Exception ee){
                    System.out.println(ee);                
                }            
             }
                else if(ae.getSource()==b2){
                    this.setVisible(false);
                    //new project().setVisible(true);
        }
    }   
public static void main(String s[]){
   new Add_client();
  }

    
}
