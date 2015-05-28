package UI;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.LoginControl;
import Model.Login;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class ModifyUserUI extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	final String [] temp = new String[3];
	public SettingUI localfather;
	/**
	 * Create the frame.
	 */
	public ModifyUserUI(SettingUI father) {
		setTitle("\u4FEE\u6539\u7528\u6237\u4FE1\u606F");
		localfather = father;
		setBounds(100, 100, 430, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(191, 68, 102, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 122, 102, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 173, 102, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(191, 223, 102, 21);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "管理员", "员工"}));
		
		int rowNum = localfather.getTable().getSelectedRow();
		textField.setText(localfather.getTable().getModel().getValueAt(rowNum, 0).toString());
		textField_1.setText(localfather.getTable().getModel().getValueAt(rowNum, 1).toString());
		if(localfather.getTable().getModel().getValueAt(rowNum, 2).toString().equals("管理员"))
		{
			comboBox.setSelectedIndex(1);
		}
		else
		{
			comboBox.setSelectedIndex(2);
		}
		
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(82, 71, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(82, 125, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setBounds(82, 176, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6743\u9650");
		lblNewLabel_3.setBounds(82, 226, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				temp[0] = textField.getText();
				temp[1]	= comboBox.getSelectedItem().toString();
				temp[2] = textField_1.getText();
				
				
				if(temp[2].equals(""))
				{
					JOptionPane.showConfirmDialog(null, "密码不能为空！","提示", JOptionPane.CLOSED_OPTION);
				}
				else if(!temp[2].equals(textField_2.getText()))
				{
					JOptionPane.showConfirmDialog(null, "密码必须相同！","提示", JOptionPane.CLOSED_OPTION);
				}
				else if((!temp[2].equals(""))&&(temp[1].equals("")))
				{
					JOptionPane.showConfirmDialog(null, "请选择登录权限！","提示", JOptionPane.CLOSED_OPTION);
				}
				
				else
				{
					String role;
					if(temp[1].equals("管理员"))
					{
						role = "0";
					}
					else
					{
						role = "1";
					}
					
					Login newLogin = new Login(temp[0],temp[2],role);
					LoginControl.getLoginControl().merge(newLogin);
					
					localfather.InitialTable();
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(82, 276, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(247, 276, 93, 23);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}

}
