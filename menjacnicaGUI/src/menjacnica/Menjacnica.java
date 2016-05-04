package menjacnica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Menjacnica implements MenjacnicaInterfejs {

	private LinkedList<Valuta> kursnaLista = new LinkedList<Valuta>();

	@Override
	public void dodajValutu(Valuta valuta) {
		if (valuta == null)
			throw new RuntimeException("Valuta ne sme biti null");

		if (kursnaLista.contains(valuta))
			throw new RuntimeException("Valuta je vec uneta u kursnu listu");

		kursnaLista.add(valuta);
	}

	@Override
	public void izbrisiValutu(Valuta valuta) {
		if (!kursnaLista.contains(valuta))
			throw new RuntimeException("Valuta ne postoji u kursnoj listi");

		kursnaLista.remove(valuta);

	}

	@Override
	public LinkedList<Valuta> vratiSveValute() {
		return kursnaLista;
	}

	@Override
	public void ucitajIzFajla(String putanja) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			LinkedList<Valuta> kursnaLista2 = (LinkedList<Valuta>) (in.readObject());
			kursnaLista.clear();
			kursnaLista.addAll(kursnaLista2);

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sacuvajUFajl(String putanja) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));

			out.writeObject(kursnaLista);

			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
