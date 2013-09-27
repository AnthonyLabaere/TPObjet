public class Main {

	public static void main(String[] args) {
		String fileToRead = "src/lena.pgm";
		PGM pgm = new PGM();
		pgm.lire(fileToRead);
		
		pgm.histogramme();

		// String fileToCreate = "created.PGM";
		// PGM pgm2 = new PGM();
	}
}
