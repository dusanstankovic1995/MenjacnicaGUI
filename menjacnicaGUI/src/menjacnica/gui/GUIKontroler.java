package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.MenjacnicaInterfejs;
import menjacnica.Valuta;
import menjacnica.gui.model.MenjacnicaTableModel;

public class GUIKontroler {

	private static MenjacnicaGUI glavniProzor;
	private static MenjacnicaInterfejs menjacnica;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void exit() {
		int izbor = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(),
				"Da li zelite da izadjete iz programa?", "Izlaz", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (izbor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void about() {
		String poruka = "Author: Dusan Stankovic - Fon";
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(), poruka, "Podaci o autoru",
				JOptionPane.PLAIN_MESSAGE);
	}

	
	

}
