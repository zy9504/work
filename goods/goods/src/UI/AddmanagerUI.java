package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import Control.LoginControl;
import Model.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class AddmanagerUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static SettingUI localfather;
	final String [] temp = new String[4];
	

	/**
	 * Create the frame.
	 */
	public AddmanagerUI(SettingUI father) {
		setTitle("\u6DFB\u52A0\u7528\u6237");
		localfather =father;
		setBounds(100, 100, 439, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(191, 68, 102, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(191, 122, 102, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setBounds(191, 173, 102, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setBounds(191, 223, 102, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "管理员", "员工"}));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(82, 71, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(82, 125, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(82, 176, 95, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6743\u9650");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(82, 226, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp[0] = textField.getText();
				temp[1]	= textField_1.getText();	
				temp[2]	= comboBox.getSelectedItem().toString();
				temp[3] = textField_2.getText();
				
				boolean nameUnique = true;
				for(int i = 0;i < localfather.list.size(); i++)
				{
					if(temp[0].equals(((Login)localfather.list.get(i)).getUserName().toString()))
					{
						nameUnique = false;
						break;
					}
				}
				
				if((temp[0].equals(""))||(temp[1].equals(""))||(temp[3].equals("")))
				{
					JOptionPane.showConfirmDialog(null, "用户名和密码不能为空！","提示", JOptionPane.CLOSED_OPTION);
				}
				else if((!temp[0].equals(""))&&(!temp[1].equals(""))
						&&(!temp[3].equals(""))&&(temp[2].equals("")))
				{
					JOptionPane.showConfirmDialog(null, "请选择登录权限！","提示", JOptionPane.CLOSED_OPTION);
				}
				else if(!temp[1].equals(temp[3]))
				{
					JOptionPane.showConfirmDialog(null, "密码不一致！","提示", JOptionPane.CLOSED_OPTION);
				}
				else if(!nameUnique)
				{
					JOptionPane.showConfirmDialog(null, "用户名已存在！","提示", JOptionPane.CLOSED_OPTION);
				}
				else
				{
					String role;
					if(temp[2].equals("管理员"))
					{
						role="0";
					}
					else
					{
						role = "1";
					}
				
					DefaultTableModel tableModel = (DefaultTableModel) localfather.getTable().getModel();
					tableModel.addRow(new Object[] {
							temp[0],temp[1],temp[2]});
					LoginControl.getLoginControl().saveLogin(temp[0], temp[1], role);
					
					localfather.InitialTable();
					dispose();
					}
				}
		});
		btnNewButton.setBounds(83, 272, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(258, 272, 93, 23);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}

}
