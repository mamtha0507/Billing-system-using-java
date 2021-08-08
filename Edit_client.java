
package billingsystem;



import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Edit_client extends JFrame implements ActionListener,ItemListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,emp,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2,b3;
    Choice c1,c2;
    
    Edit_client(){
        
    super("Update Client");
        JLabel l8=new JLabel("UPDATE  CLIENT  DETAILS");
        l8.setFont(new Font("Tahoma",Font.BOLD,22));
        l8.setBounds(80,20,350,30);
        l8.setForeground(Color.RED);
        add(l8);
        
    c2 = new Choice();
    c2.setFont(new Font("Tahoma",Font.PLAIN,17));
    c2.setBounds(230,100,150,30);
       
    try{
        conn c = new conn();
        ResultSet rs = c.s.executeQuery("select * from client");
      
        while(rs.next()){
        c2.add(rs.getString("phone"));    
    }
    }catch(Exception e){ }
       
    emp= new JLabel("Select Phone No");
    emp.setFont(new Font("Tahoma",Font.PLAIN,17));
    emp.setBounds(80,100,120,30);
    add(emp);
    add(c2);
        
    l1 = new JLabel("Name : ");
    l1.setFont(new Font("Tahoma",Font.PLAIN,17));
        l1.setBounds(80,180,120,30);
    t1 = new JTextField(15);
    t1.setFont(new Font("Tahoma",Font.PLAIN,15));
    t1.setBounds(230,180,150,30);
   
    add(l1);
    add(t1);
       
    t2 = new JTextField(15);
    t2.setFont(new Font("Tahoma",Font.PLAIN,17));
    t2.setBounds(230,260,150,30); 
    l2 = new JLabel("Gender : ");
    l2.setFont(new Font("Tahoma",Font.PLAIN,15));
    l2.setBounds(80,260,120,30);
    
    add(l2);
    add(t2);
        
    l3 = new JLabel("Address : ");
    l3.setFont(new Font("Tahoma",Font.PLAIN,17));
    l3.setBounds(80,340,120,30);
    t3 = new JTextField(15);
    t3.setFont(new Font("Tahoma",Font.PLAIN,15));
    t3.setBounds(230,340,150,30);
    
    add(l3);
    add(t3);
    
        
    l6 = new JLabel("Email : ");
    l6.setFont(new Font("Tahoma",Font.PLAIN,17));
    l6.setBounds(80,420,120,30);
    t6 = new JTextField(15);
    t6.setFont(new Font("Tahoma",Font.PLAIN,15));
    t6.setBounds(230,420,150,30);
    
    add(l6);
    add(t6);
        
    
        
        b1 = new JButton("Update Client" ,new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/ok.jpeg")));
        b1.setBounds(30,510,210,40);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.BOLD,17));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Delete Client" ,new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/delete.jpeg")));
        b2.setBounds(300,510,200,40);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.BOLD,17));
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Load Client",new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/login.jpeg")));
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        b3.setBounds(170,580,190,40);
        b3.setFont(new Font("Tahoma",Font.BOLD,17));
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(Color.WHITE);                   
        setLayout(null);
        setBounds(460,20,550,680);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1){
    String name = t1.getText();
    String gender = t2.getText();
    String address = t3.getText();
    String email = t6.getText();
    String phone = c2.getSelectedItem();
    String qry = "update client set name='"+name+"',gender='"+gender+"',phone='"+phone+"',email='"+email+"',address='"+address+"'   where phone="+c2.getSelectedItem();

        try{
        conn c1 = new conn();
        c1.s.executeUpdate(qry);
        JOptionPane.showMessageDialog(null,"Client Updated");
        }
        catch(Exception ee){
        ee.printStackTrace();
        }
        }
        
        if(ae.getSource()==b2){
            try{
            conn c1 = new conn();
            c1.s.executeUpdate("delete from client where phone="+c2.getSelectedItem());
            JOptionPane.showMessageDialog(null,"Client Deleted");
            this.setVisible(false);
            }catch(Exception ee){
            ee.printStackTrace();
            }
            }
        else if(ae.getSource() == b3){          
             try{
                String n =null;
                String g =null;
                String a =null;
                String s =null;
                String c =null;
                String e =null;
                String p =null;
                conn c3=new conn();
                String id = c2.getSelectedItem();
                String str="select * from client where phone=" +c2.getSelectedItem();
                ResultSet rs=c3.s.executeQuery(str);
                
                
                while(rs.next()){
                    t1.setText(rs.getString("name"));
                    t2.setText(rs.getString("gender"));
                    t3.setText(rs.getString("address"));
                    t6.setText(rs.getString("email"));
                                                           
                }
         }                
             catch(Exception ee){
                 System.out.println(ee);
             }    
            }
    }
    
    public void itemStateChanged(ItemEvent ie){
        try{
        conn c1 = new conn();
        ResultSet rs = c1.s.executeQuery("select * from client where id="+c2.getSelectedItem());

            if(rs.next()){
            t1.setText(rs.getString("name"));
            t3.setText(rs.getString("address"));
            t6.setText(rs.getString("email"));
            t7.setText(rs.getString("phone"));
            }
        }

        catch(Exception ee){
        ee.printStackTrace();
        }
    }
    
public static void main(String[] args){
    new Edit_client();
}  
    
}
