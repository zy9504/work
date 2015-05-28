package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Goods;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ModifyGoods extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_4;
	private Goods goodsinfo;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ModifyGoods(final Main main,Goods goods) {
		setTitle("\u4FE1\u606F\u66F4\u6539");
		goodsinfo=goods;
		setBounds(100, 100, 309, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 49, 119, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 168, 119, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		

		textField = new JTextField();
		textField.setBounds(150, 105, 119, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblVipid = new JLabel("\u7F16\u53F7");
		lblVipid.setFont(new Font("宋体", Font.PLAIN, 16));
		lblVipid.setBounds(57, 49, 54, 15);
		contentPane.add(lblVipid);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 232, 119, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("\u5355\u4EF7");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(57, 235, 79, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 111, 79, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\u6570\u91CF");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(57, 171, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(178, 286, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "姓名不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(textField_2.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "学号不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(textField_4.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "校园卡卡号不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				Goods goods=new Goods(Integer.valueOf(textField_1.getText()),textField.getText(),Integer.valueOf(textField_2.getText()),Double.valueOf(textField_4.getText()));
				Control.GoodsControl.getControl().update(goods);
				main.InitialTable();
				dispose();
			}
		});
		btnNewButton.setBounds(71, 286, 93, 23);
		contentPane.add(btnNewButton);
		textField_1.setText(goodsinfo.getId().toString());
		textField.setText(goodsinfo.getName());
		textField_2.setText(goodsinfo.getCount().toString());
		textField_4.setText(goodsinfo.getPrice().toString());
		setLocationRelativeTo(null);

	}

}
