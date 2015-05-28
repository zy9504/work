package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;





import Model.Goods;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Font;

public class AddGoods extends JFrame {

	private JPanel contentPane;
	private JTable jtable;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddGoods(JTable table,final Main main) {
		this.jtable = table;
		setTitle("\u589E\u52A0\u5546\u54C1");
		setLocationRelativeTo(null);
		setBounds(100, 100, 576, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 46, 81, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\u4EF7\u683C");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(312, 104, 81, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(312, 153, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "请输入商品名字!","提示", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(textField_1.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "请输入编号!","提示", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(Double.valueOf(textField_2.getText())<0)
				{
					JOptionPane.showConfirmDialog(null, "请输正确的商品数量!","提示", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(Double.valueOf(textField_3.getText())<0)
				{
					JOptionPane.showConfirmDialog(null, "请输入正确的单价!","提示", JOptionPane.CLOSED_OPTION);
					return;
				}
				Goods goods=new Goods(Integer.valueOf(Integer.valueOf(textField_1.getText())),textField.getText(),Integer.valueOf(textField_2.getText()),Double.valueOf(textField_3.getText()));
				Control.GoodsControl.getControl().save(goods);
				main.InitialTable();
				dispose();
			}
		});
		btnNewButton.setBounds(142, 153, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblVipid = new JLabel("\u7F16\u53F7");
		lblVipid.setFont(new Font("宋体", Font.PLAIN, 16));
		lblVipid.setBounds(59, 104, 54, 15);
		contentPane.add(lblVipid);
		
		textField = new JTextField();
		textField.setBounds(157, 43, 105, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 101, 105, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(408, 43, 105, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("\u6570\u91CF");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(312, 44, 72, 18);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setBounds(408, 100, 105, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		setLocationRelativeTo(null);
	}
}
