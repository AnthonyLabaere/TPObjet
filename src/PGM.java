import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PGM {

	private final String CARACTERE_SEPARATION = "\t";
	private final Integer COULEUR_MAX = 256;

	private String fileName;

	private String name;

	private int largeur;
	private int hauteur;

	private List<String> pixelLines;

	public PGM() {
	}

	public void lire(String fileName) {
		this.fileName = fileName;

		try {
			InputStream ips = new FileInputStream(fileName);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			int numeroLine = 1;
			pixelLines = new ArrayList<String>();

			while ((ligne = br.readLine()) != null) {
				if (numeroLine == 1) {
					// lever une erreur si ce n'est pas P2
				} else if (numeroLine == 2) {
					this.name = ligne;
				} else if (numeroLine == 3) {
					String[] largeurEtHauteur = ligne
							.split(CARACTERE_SEPARATION);
					this.largeur = Integer.parseInt(largeurEtHauteur[0]);
					this.hauteur = Integer.parseInt(largeurEtHauteur[1]);
				} else if (numeroLine == 4) {
					// lever une erreur si ce n'est pas 255
				} else {
					// Lever une erreur si la liste de pixels n'a pas été
					// complétée sur la largeur pour cette ligne
					pixelLines.add(ligne);
				}

				numeroLine++;
			}

			// Lever une erreur si la liste de pixels n'a pas été complétée sur
			// la hauteur

			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void create() {

	}

	public void histogramme() {
		// On liste les pixels
		List<String> pixels = new ArrayList<String>();
		for (String pixelLine : pixelLines) {
			String[] pixelsTemp = pixelLine.split(CARACTERE_SEPARATION);
			for (String pixelTemp : pixelsTemp) {
				pixels.add(pixelTemp);
			}
		}

		// On compte les pixel
		int[] histogramme = new int[COULEUR_MAX + 1];

		// Mise à 0 des compteurs
		for (int i = 0; i < COULEUR_MAX + 1; i++) {
			histogramme[i] = 0;
		}

		// Mise à jour de l'histogramme
		for (String pixel : pixels) {
			histogramme[Integer.parseInt(pixel)]++;
		}

		for (int i = 0; i < COULEUR_MAX + 1; i++) {
			String ligne = "";
			for (int j = 0; j < histogramme[0]; j++) {
				ligne += "-";
			}
			System.out.println(ligne);
		}
	}

}
