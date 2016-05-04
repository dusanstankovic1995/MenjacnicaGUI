package menjacnica.gui.model;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import menjacnica.Valuta;

public class MenjacnicaTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni",
			"Naziv" };
	private List<Valuta> valute = new LinkedList<Valuta>();

	@Override
	public int getColumnCount() {

		return kolone.length;
	}

	@Override
	public int getRowCount() {

		return valute.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Valuta v = valute.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return v.getSifra();
		case 1:
			return v.getSkraceniNaziv();
		case 2:
			return v.getProdajni();
		case 3:
			return v.getSrednji();
		case 4:
			return v.getKupovni();
		case 5:
			return v.getNaziv();
		default:
			return "xxxxx";
		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void ucitajSveValute(List<Valuta> valute) {
		this.valute = valute;
		fireTableDataChanged();
	}

	public Valuta vratiValutu(int index) {
		return valute.get(index);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;

	}
}