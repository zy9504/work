package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Goods;

import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	Main gui = this;
	public static List list;
	private Main main;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		            LogonUI logon=new LogonUI();
		            logon.setModal(true);
		            logon.setVisible(true);
		            if(logon.getLogonResult()==-1)
		            	System.exit(0);
		            Main main=new Main();
		            main.setVisible(true);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
		});
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public Main() {
		main=this;
		setTitle("\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddGoods addGoods=new AddGoods(table,main);
					addGoods.setVisible(true);

		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(42, 46, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u66F4\u6539\u4FE1\u606F");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "请选择要修改的记录!","提示", JOptionPane.CLOSED_OPTION);
				}
				else
				{
					List<Goods>list1=Control.GoodsControl.getControl().findAll();
					for(int i = getTable().getSelectedRow();i < (getTable().getSelectedRow() +
							getTable().getSelectedRowCount());i++)
					try {
						ModifyGoods modifyGoods=new ModifyGoods(main,(Goods)list.get(i));
						modifyGoods.setVisible(true);

			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
				}
			}
		});
		btnNewButton_1.setBounds(42, 99, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "请选择要删除的记录!","提示", JOptionPane.CLOSED_OPTION);
				}
				else if(getTable().getSelectedRowCount() > 0)
				{
					int choice = JOptionPane.showConfirmDialog(null, "选中的记录将被删除!","是否删除:", JOptionPane.OK_CANCEL_OPTION);
					
					if(choice == 0)
					{
						List<Goods>list1=Control.GoodsControl.getControl().findAll();
						for(int i = getTable().getSelectedRow();i < (getTable().getSelectedRow() +
								getTable().getSelectedRowCount());i++)
						{	
							tableModel.removeRow(i);
							Control.GoodsControl.getControl().delete((Goods)list.get(i));
						}
						
							
						
						InitialTable();
					
					}
						
				}
				
			}
		});
		btnNewButton_2.setBounds(42, 168, 111, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 41, 536, 273);
		contentPane.add(scrollPane);
		
		table = new JTable(){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setFont(new Font("宋体", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "商品名字", "数量","价格"
			}
		));
		int selMode = table.getSelectionModel().getSelectionMode();
		 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u6761\u4EF6\u67E5\u627E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Search search=new Search(table);
					search.setVisible(true);

		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(42, 229, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u663E\u793A\u5168\u90E8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitialTable();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(42, 287, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u767B\u9646\u7BA1\u7406");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SettingUI setting=new SettingUI();
					setting.setVisible(true);

		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 16));
		button_2.setBounds(612, 8, 113, 27);
		contentPane.add(button_2);
		
		InitialTable();
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
		
	}
	
	public void InitialTable()
	{
		DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();
		if(tableModel.getRowCount() != 0)
		{
			tableModel.setRowCount(0);
		}
		list = Control.GoodsControl.getControl().findAll();
			
		for(int i = 0;i < list.size();i++)
		{
			Goods goods = (Goods)list.get(i);
			tableModel.addRow(new Object[] {
					goods.getId().toString(),goods.getName(),
					goods.getCount().toString(),goods.getPrice().toString()});
		}
		setLocationRelativeTo(null);
	}
}
