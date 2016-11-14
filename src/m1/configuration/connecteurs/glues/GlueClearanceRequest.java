package m1.configuration.connecteurs.glues;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Glue de ClearanceRequest
 *
 */
public class GlueClearanceRequest extends Glue {

	/**
	 * 
	 * @param pass le password a hash
	 * @return le password hashe
	 */
	public String hashPassword(String pass) {
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// Add password bytes to digest
			md.update(pass.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			LOGGER.warning(e.getLocalizedMessage());
			e.printStackTrace();
			return null;
		}
	}


	/* (non-Javadoc)
	 * @see m2.configuration.connecteur.Glue#traduit(m2.configuration.interfaces.PointConnexion)
	 */
	@Override
	public String traduit(PointConnexion p) {
		LOGGER.info("GlueClearanceRequest : traduction par la glue");
		switch (p.getNom()) {// traitement peut etre different en fonction de la glue

		case "CallerConnec":
			return hashPassword(p.getVal());

		case "CallerSecu":
			return p.getVal();

		default:
			return null;
		}
	}
}
