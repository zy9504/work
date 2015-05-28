package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;



import Model.Goods;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable jtable;
	private JButton button;
	private JComboBox  comboBox;
	/**
	 * Create the frame.
	 */
	public Search(JTable table) {
		setLocationRelativeTo(null);
        jtable = table;
		setTitle("选择查找条件");
		
		setBounds(100, 100, 331, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblid = new JLabel("\u7F16\u53F7");
		lblid.setFont(new Font("宋体", Font.PLAIN, 16));
		lblid.setBounds(38, 99, 82, 15);
		contentPane.add(lblid);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setBounds(145, 48, 129, 21);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int option = comboBox.getSelectedIndex();
				switch(option)
				{
				case 0:
					lblid.setText("编号");
					break;
				case 1:
					lblid.setText("商品名称");
					break;
				default:
					break;
						
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7F16\u53F7", "\u6309\u5546\u54C1\u540D\u79F0"}));
		contentPane.add(comboBox);

		
		textField = new JTextField();
		textField.setBounds(147, 96, 137, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u627E\u6761\u4EF6");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(38, 48, 65, 15);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = comboBox.getSelectedIndex();
				List list;
				switch(option)
				{
				case -1:
				case 0:
					if(textField.getText().equals(""))
					{
						JOptionPane.showConfirmDialog(null, "编号不能为空","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					int id = Integer.valueOf(textField.getText());
					Goods goods=Control.GoodsControl.getControl().findByGoodsID(id);
					if(goods==null)
					{
						JOptionPane.showConfirmDialog(null, "你所查找的商品信息不存在","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					list = new ArrayList();
					list.add(goods);
					showSearchResult(list,jtable);
					break;
				
				case 1:
					if(textField.getText().equals(""))
					{
						JOptionPane.showConfirmDialog(null, "商品名称不能为空","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					String name = textField.getText();
					list = Control.GoodsControl.getControl().findByName(name);
					if(list.size()==0)
					{
						JOptionPane.showConfirmDialog(null, "你所查找的商品信息不存在","提示:", JOptionPane.CLOSED_OPTION);
						return;
					}
					showSearchResult(list,jtable);
					break;
				     
				default:
					break;
						
				}
				dispose();
				
			}
			
		});
		btnNewButton.setBounds(51, 152, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(158, 152, 93, 23);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}
	
	public void showSearchResult(List list,JTable table)
	{
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    Goods goods=null;
	    String [] record = new  String[4];
	    for(int i=0;i<list.size();i++)
	    {
	    	goods = (Goods)list.get(i);
	    	record[0]=goods.getId().toString();
	    	record[1]=goods.getName();
	    	record[2]=goods.getCount().toString();
	    	record[3]=goods.getPrice().toString();
	    	tableModel.addRow(record);
	    	
	    }
	    table.invalidate();
	}
}
