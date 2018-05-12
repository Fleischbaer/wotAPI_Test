package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fachklassen.Spieler;

public class TableModelSpieler implements TableModel {
	private List<Spieler> spieler;
	
	private List<Spieler> getSpieler(){
		if(spieler==null) {
			spieler = new ArrayList<Spieler>();
		}
		return spieler;
	}
	public void addSpieler(Spieler s) {
		final List<Spieler> sp = getSpieler();
		if(!sp.contains(s)) {
			sp.add(s);
		}
	}
	public void removeSpieler(Spieler s) {
		getSpieler().remove(s);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:{
			return "nickname";
		}
		case 1:{
			return "account_id";
		}
		}
		return null;
	}

	@Override
	public int getRowCount() {
		return Math.max(10, getSpieler().size());
//		return getSpieler().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

}
