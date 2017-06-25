package designpattern.creational.builder.example2;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TableBuilderDemoBefore {
	public static void main(String[] args) {
		(new TableBuilderDemoBefore()).demo(args);
	}
	
	public void demo(String[] args) {
		String class_name = args.length > 0 ? args[0] : "JTable_Builder";
		
		String file_name = getClass().getResource("BuilderDemo.dat").getFile();
		String[][] matrix = read_data_file(file_name);
		
		Component comp;
		if (class_name.equals("GridLayout_Table")) {
			comp = new GridLayout_Table(matrix).get_table();
		} else if (class_name.equals("GridBagLayout_Table")) {
			comp = new GridBagLayout_Table(matrix).get_table();
		} else {
			comp = new JTable_Table(matrix).get_table();
		}
		
		JFrame frame = new JFrame("BuilderDemo - " + class_name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(comp);
		frame.pack();
		frame.setVisible(true);
	}
	
	class JTable_Table {
		private JTable m_table;
		
		public JTable_Table(String[][] matrix) {
			m_table = new JTable(matrix[0].length, matrix.length);
			
			TableModel model = m_table.getModel();
			for (int i=0; i<matrix.length; i++)
				for (int j=0; j<matrix[i].length; j++)
					model.setValueAt(matrix[i][j], j, i);
		}
		
		public Component get_table() {
			return m_table;
		}
	}
	
	class GridBagLayout_Table {
		private JPanel m_table = new JPanel();
		
		public GridBagLayout_Table(String[][] matrix) {
			GridBagConstraints c = new GridBagConstraints();
			
			m_table.setLayout(new GridBagLayout());
			m_table.setBackground(Color.white);
			
			for (int i=0; i<matrix.length; i++)
				for (int j=0; j<matrix[i].length; j++) {
					c.gridx = i;
					c.gridy = j;
					m_table.add(new Label(matrix[i][j]), c);
				}
		}
		
		public Component get_table() {
			return m_table;
		}
	}
	
	class GridLayout_Table {
		private JPanel m_table;
		
		public GridLayout_Table(String[][] matrix) {
			m_table = new JPanel();
			m_table.setLayout(new GridLayout(matrix[0].length, matrix.length));
			m_table.setBackground(Color.white);
			
			for (int i=0; i<matrix[0].length; i++)
				for (int j=0; j<matrix.length; j++)
					m_table.add(new Label(matrix[j][i]));
		}
		
		public Component get_table() {
			return m_table;
		}
	}

	private String[][] read_data_file(String file_name) {
		String[][] matrix = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			String line;
			String[] cells;
			
			if ((line = br.readLine()) != null) {
				cells = line.split("\\t");
				int width = Integer.parseInt(cells[0]);
				int height = Integer.parseInt(cells[1]);
				matrix = new String[width][height];
			}
			
			int row = 0;
			while ((line = br.readLine()) != null) {
				cells = line.split("\\t");
				for (int i=0; i<cells.length; i++)
					matrix[i][row] = cells[i];
				row++;
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return matrix;
	}
	

}
