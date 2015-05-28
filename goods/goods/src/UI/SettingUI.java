package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Control.LoginControl;
import Model.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Toolkit;

public class SettingUI extends JFrame {

	private JPanel contentPane;
	SettingUI gui = this;
	public static List list;
	private String [] itemsOperator = {"���Ӳ���Ա","ɾ������Ա","�޸Ĳ���Ա"};
	private JTable table;
	/**
	 * Create the frame.
	 */
	public SettingUI() {
		setTitle("\u7528\u6237\u7BA1\u7406");
		setBounds(100, 100, 548, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("����û�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddmanagerUI add = new AddmanagerUI(gui);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setVisible(true);		
			}
		});
		btnNewButton.setBounds(416, 64, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�޸��û�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "��ѡ��Ҫ�޸ĵļ�¼!","��ʾ", JOptionPane.CLOSED_OPTION);
				}
				else
				{
					ModifyUserUI modify = new ModifyUserUI(gui);
					modify.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					modify.setVisible(true);
				}							
			}
		});
		btnNewButton_1.setBounds(416, 115, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ɾ���û�");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "��ѡ��Ҫɾ���ļ�¼!","��ʾ", JOptionPane.CLOSED_OPTION);
				}
				else if(getTable().getSelectedRowCount() > 0)
				{
					int choice = JOptionPane.showConfirmDialog(null, "ѡ�еļ�¼����ɾ��!","�Ƿ�ɾ��:", JOptionPane.OK_CANCEL_OPTION);
					if(choice == 0)
					{
						for(int i = getTable().getSelectedRow();i < (getTable().getSelectedRow() +
								getTable().getSelectedRowCount());i++)
						{	
							tableModel.removeRow(i);
							LoginControl.getLoginControl().delete((Login)list.get(i));
						}
					}
					InitialTable();
				}
				
			}
		});
		btnNewButton_2.setBounds(416, 166, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 64, 371, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"�û���", "�û�����", "Ȩ��"
			}
		));
		int selMode = table.getSelectionModel().getSelectionMode();
		 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
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
		list = LoginControl.getLoginControl().getLoginALL();	
		String role;
		for(int i = 0;i < list.size();i++)
		{
			Login login = (Login)list.get(i);
			if(Integer.parseInt(login.getRole().toString()) == 0);
			{
				role = "����Ա";
			}
			if(Integer.parseInt(login.getRole().toString()) == 1)
			{
				role ="Ա��";
			}
			
			tableModel.addRow(new Object[] {
				login.getUserName().toString(),login.getPassword().toString(),
				role});
		}
		setLocationRelativeTo(null);
	}
}
