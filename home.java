
package billingsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class home extends JFrame implements ActionListener {
    home() {
        super("MINI MART");
        setBounds(0,0,1370,1250);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource ("billingsystem/Icon/mart.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1370,1100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu m1 = new JMenu("BILL");
        m1.setForeground(Color.blue);
        m1.setFont(new Font("Tahoma",Font.PLAIN,15));
        mb.add(m1);
        
        
        JMenuItem t4 = new JMenuItem("BILL");       
        t4.setForeground(Color.blue);
        t4.setFont(new Font("Tahoma",Font.PLAIN,13));
        t4.setMnemonic('B');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("billingsystem/icon/bill.jpeg")));
        t4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));              
        m1.add(t4);
        t4.addActionListener(this);
        
        JMenu edit = new JMenu("ADD CLIENT");
        edit.setForeground(Color.RED);
        edit.setFont(new Font("Tahoma",Font.PLAIN,15));
        mb.add(edit);
        
        JMenuItem t5 = new JMenuItem("ADD CLIENT");       
        t5.setForeground(Color.blue);
        t5.setFont(new Font("Tahoma",Font.PLAIN,13));
        t5.setMnemonic('A');
        t5.setIcon(new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/add.jpeg")));
        t5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));              
        edit.add(t5);
        t5.addActionListener(this);
        
       
        JMenu rep = new JMenu("EDIT CLIENTS");
        rep.setForeground(Color.blue);
        rep.setFont(new Font("Tahoma",Font.PLAIN,15));
        mb.add(rep);
        
        JMenuItem t6= new JMenuItem("EDIT CLIENTS");       
        t6.setForeground(Color.blue);
        t6.setFont(new Font("Tahoma",Font.PLAIN,13));
        t6.setMnemonic('E');
        t6.setIcon(new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/edit.jpeg")));
        t6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));              
        rep.add(t6);
        t6.addActionListener(this);
        
         
        JMenu util = new JMenu("VIEW CLIENTS");
        util.setForeground(Color.red);
        util.setFont(new Font("Tahoma",Font.PLAIN,15));
        mb.add(util);
        
        JMenuItem t7 = new JMenuItem("VIEW CLIENTS");       
        t7.setForeground(Color.blue);
        t7.setFont(new Font("Tahoma",Font.PLAIN,13));
        t7.setMnemonic('V');
        t7.setIcon(new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/view.jpeg")));
        t7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));              
        util.add(t7);
        t7.addActionListener(this);
        
        
        JMenu u1 = new JMenu("NOTEPAD");
        
        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/notepad.jpeg")));
        u1.setForeground(Color.blue);
        u1.setFont(new Font("Tahoma",Font.PLAIN,15));
        mb.add(u1);

        
        JMenuItem u3 = new JMenuItem("NOTEPAD");
        u3.setForeground(Color.blue);
        u3.setFont(new Font("Tahoma",Font.PLAIN,13));
        u3.setMnemonic('N');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        u1.add(u3);
         u3.addActionListener(this);
        
        JMenu u2 = new JMenu("CALCULATOR");       
        u2.setForeground(Color.red);
        u2.setFont(new Font("Tahoma",Font.PLAIN,15));

        mb.add(u2);                        

         JMenuItem u4 = new JMenuItem("CALCULATOR");
        u4.setIcon(new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/calci.jpeg")));     
        u4.setForeground(Color.blue);
        u4.setFont(new Font("Tahoma",Font.PLAIN,13));
        u4.setMnemonic('C');
        u4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        u2.add(u4);    
        u4.addActionListener(this);
      
        JMenu m8 = new JMenu("LOGOUT");
        m8.setForeground(Color.blue);
        m8.setFont(new Font("Tahoma",Font.PLAIN,15));
        mb.add(m8);              
 
        
        JMenuItem m8i1 = new JMenuItem("LOGOUT");
        m8.add(m8i1);
        m8i1.setForeground(Color.blue);
        m8i1.setFont(new Font("Tahoma",Font.PLAIN,13));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("billingsystem/Icon/exit.jpeg")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        m8i1.addActionListener(this);
       
        mb.setBounds(10,5,1950,30);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        
        if(msg.equals("BILL"))
            new bill().setVisible(true);
        else if(msg.equals("ADD CLIENT"))
            new Add_client().setVisible(true);
        else if(msg.equals("EDIT CLIENTS"))
            new Edit_client().setVisible(true);
        else if(msg.equals("VIEW CLIENTS"))
            new view_clients().setVisible(true);
        else if(msg.equals("NOTEPAD")){
             try{
                Runtime.getRuntime().exec("notepad.exe");
                 } catch(Exception e) {}
        }
        
        else if(msg.equals("CALCULATOR")){
        try{
            Runtime.getRuntime().exec("calc.exe");
                 } catch(Exception e) {}  
        }
       
       
        
        else if(msg.equals("LOGOUT"))
            dispose();
        
    }
    public static void main(String[] args){
        new home().setVisible(true);
    }    
}