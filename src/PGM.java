import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class PGM {

	private String name;
	private int hauteur;
	private int largeur;

	private List<Integer> pixel;

	public PGM(String fileName) {
		try {
			InputStream ips = new FileInputStream(fileName);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			int numeroLine = 0;
			
			while ((ligne = br.readLine()) != null) {
				numeroLine++;
			}
			
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
	}

	public void lire() {

	}

}
