
package billingsystem;



import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class view_clients extends JFrame implements ActionListener{
    JTable j1;
    JButton b1;
    String h[]={"Name","Gender","Address","Email id","Phone"};
    String d[][]=new String[20][8];  
    int i=0,j=0;
    
    view_clients(){
        super("View employees");
        setSize(1100,500);
        setLocation(100,130);
        try{
            String q="select * from client";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                // i = 0 j = 0
                d[i][j++]=rs.getString("name");
                d[i][j++]=rs.getString("gender");
                d[i][j++]=rs.getString("address");
                d[i][j++]=rs.getString("email");
                d[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            j1=new JTable(d,h); 
        }
        catch(Exception e){}
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
           j1.print();
        }catch(Exception e){}
    }     
    public static void main(String s[]){
        new view_clients().setVisible(true);
    }
}
