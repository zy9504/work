package UI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Model.Login;


public class LogonUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private int logonResult;
	
	private JTextField usrNameField;
	private JPasswordField passwordField;
	

	/**
	 * Create the dialog.
	 */
	public LogonUI() {
		
		  
		setTitle("\u767B\u9646");
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		logonResult=-1;
		
		setBounds(100, 100, 415, 351);
		contentPanel.setBounds(0, 0, 642, 398);
		{
			{
			}
		}
		{
			okButton = new JButton("\u767B\u9646");
			okButton.setBounds(99, 224, 219, 46);
			okButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				//logon 
					if(isUser(usrNameField.getText(),String.valueOf(passwordField.getPassword())))
					//if(usrName.equals(usrNameField.getText())&&password.equals(String.valueOf(passwordField.getPassword())))
					{
							logonResult=Integer.valueOf(Control.LoginControl.getLoginControl().getLoginByName(usrNameField.getText()).getRole());
							okButton.setActionCommand("OK");
							dispose(); 
					}
					else
					{
							logonResult=-1;
							JOptionPane.showMessageDialog(null, "ÓÃ»§Ãû/ÃÜÂë´íÎó£¡", "¾¯¸æ",JOptionPane.INFORMATION_MESSAGE);
							passwordField.setText(null);
					}
				}
			});
			getRootPane().setDefaultButton(okButton);
		}
		getContentPane().setLayout(null);
		
		usrNameField = new JTextField();
		usrNameField.setBounds(178, 79, 140, 24);
		usrNameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 15));
		lblNewLabel.setBounds(82, 79, 82, 18);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 15));
		lblNewLabel_1.setBounds(82, 157, 63, 18);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 156, 140, 24);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.add(lblNewLabel_1);
		contentPanel.add(lblNewLabel);
		contentPanel.add(okButton);
		contentPanel.add(passwordField);
		contentPanel.add(usrNameField);
		
		setLocationRelativeTo(null);
	}
	public int getLogonResult()
	{
		return logonResult;
	}
	private boolean isUser(String name,String password)
	{
		Login login=Control.LoginControl.getLoginControl().getLoginByName(name);
		if(login==null)
			return false;
		else if(login.getPassword().equals(password))
			return true;
		else
			return false;
	}
}
