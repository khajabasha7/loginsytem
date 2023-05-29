import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class loginpage implements ActionListener{

    //buttons
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
    
    //text field
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();

    //text label
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
   
    

    //imported from IDandpassword file
	HashMap<String,String> logininfo = new HashMap<String,String>();
	loginpage(HashMap<String,String> loginInfoOriginal){
    logininfo = loginInfoOriginal;
        
        userIDLabel.setBounds(50,100,75,25);
	    userPasswordLabel.setBounds(50,150,75,25);
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
        
        //login button
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);

        //resetbutton 
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

        //added frames
		frame.add(userIDLabel);
		frame.add(userPasswordLabel); 
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
        //using reset button
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource()==loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());

            //username and paswords contains in IDandpasswords file
			if(logininfo.containsKey(userID)) {
                
                //checking username and password is crt or not 
				if(logininfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("login successful");

                    //if login is successfully  directed to this page
                    try {
                        Desktop.getDesktop().browse(new URI("https://zoro.to/"));
                        
                        Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/"));

    
                    } catch (Exception ex) 
                    {
                        JOptionPane.showInputDialog(this, "Error opening URL: " + ex.getMessage());
                    } 
                }  
                //if wrong password  print messg
				else {

					messageLabel.setForeground(Color.red);

					messageLabel.setText("Wrong password");

				}
			}
            //checking if userid is avaliable are not 
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("username not found!");
			}
		}
	}	
}

/* 
public class loginpage implements ActionListener {
    JFrame frame=new JFrame();
    JButton loginbuButton=new JButton("Login");
    JButton ResetbuButton=new JButton("Reset");
    JTextField userIDField=new JTextField();
    JPasswordField userPasswordField=new JPasswordField();
    JLabel userIDLabel =new JLabel("userId:");
    JLabel userpasswoLabel =new JLabel("Pasword:");
    JLabel messLabel =new JLabel(); 
//msg label

    HashMap<String,String>logininfo=new HashMap<String,String>();
    /**
     * @param logininfoorginal
     */
   /* loginpage(HashMap<String,String> logininfoorginal){
        logininfo=logininfoorginal;
        userIDLabel.setBounds(50, 100,75 , 25);
        userpasswoLabel.setBounds(50,150 , 75, 25);
        
        messLabel.setBounds(125, 250, 250, 35);
        messLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
    
        userPasswordField.setBounds(125, 100, 200, 25);
        
        loginbuButton.setBounds(125, 200, 100, 25);
        loginbuButton.setFocusable(false);
        loginbuButton.addActionListener(this);

        ResetbuButton.setBounds(225, 200, 100, 25);
        loginbuButton.setFocusable(false);
        ResetbuButton.addActionListener(this);
        

        frame.add(userIDLabel);
        frame.add(userpasswoLabel);
        frame.add(messLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginbuButton);
        frame.add(ResetbuButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ResetbuButton)
        {
            userIDField.setText(null);
            userPasswordField.setText(null);
        }
        if(e.getSource()==loginbuButton)
        {
            String userid=userIDField.getText();
            String password=String.valueOf(userPasswordField.getPassword());
            if(logininfo.containsKey(userid))
            {
                if(logininfo.get(userid).equals(password)){
                messLabel.setForeground(Color.green);
                messLabel.setText("login successful");
                try {
                    Desktop.getDesktop().browse(new URI("https://zoro.to/"));

                } catch (Exception ex) 
                {
                    JOptionPane.showInputDialog(this, "Error opening URL: " + ex.getMessage());
                } 
            }          
                
            else
            {
                messLabel.setForeground(Color.red);
                messLabel.setText("Wrong password");
            }
        }
        else{
            messLabel.setForeground(Color.red);
            messLabel.setText("userk name not found");
        }
    }
}
}*/