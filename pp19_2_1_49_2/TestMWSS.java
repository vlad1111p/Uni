public class TestMWSS {

	public static void main(String[] args) throws InterruptedException {
		Zellraum zr = new Zellraum(9, 10);
		zr.setZellen(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } });

		Zellraum zv = new Zellraum(9, 10);
		zv.setZellen(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } });
		Zellraum zm = new Zellraum(9, 10);
		zm.setZellen(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } });
		Zellraum zl = new Zellraum(9, 10);
		zl.setZellen(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } });
		Zellraum zt = new Zellraum(9, 10);
		zt.setZellen(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } });
		Nachbarschaft nb = new Nachbarschaft();
		nb.setVonNeumann();
		Nachbarschaft nm = new Nachbarschaft();
		nm.setVonNeumann();
		Nachbarschaft nv = new Nachbarschaft();
		nv.setMoore();
		Nachbarschaft nl = new Nachbarschaft();
		nm.setVonNeumann();
		Nachbarschaft nt = new Nachbarschaft();
		nm.setVonNeumann();
		Automat at = new Automat(zr, nb);
		Automat ab = new Automat(zv, nv);
		Automat am = new Automat(zm, nm);
		Automat al = new Automat(zl, nl);
		Automat ac = new Automat(zt, nt);

		for (int i = 0; i < 10; i++) {

			at.naechsteGenerationBerechnen();
			ab.naechsteGenerationBerechnen();
			am.naechsteGenerationBerechnen();
			al.naechsteGenerationBerechnen();
			ac.naechsteGenerationBerechnen();

			for (int c = 0; c < zr.getZellen().length; c++) {
				// Moore
				for (int v = 0; v < zv.getZellen()[c].length; v++) {

					System.out.print(zv.getZellen()[c][v]);
				}
				System.out.print("  ");

				// VonNeumann
				for (int l = 0; l < zr.getZellen()[c].length; l++) {
					System.out.print(zr.getZellen()[c][l]);
				}

				System.out.print("  ");
				// VonNeumann
				for (int m = 0; m < zm.getZellen()[c].length; m++) {

					System.out.print(zm.getZellen()[c][m]);
				}

				System.out.print("  ");
				// VonNeumann
				for (int m = 0; m < zl.getZellen()[c].length; m++) {

					System.out.print(zl.getZellen()[c][m]);
				}

				System.out.print("  ");
				// VonNeumann
				for (int m = 0; m < zt.getZellen()[c].length; m++) {

					System.out.print(zt.getZellen()[c][m]);
				}
				System.out.println();

			}
			System.out.println();
			Thread.sleep(1000);
		}
		System.out.println(" 1.Moore   2.VonNeumann    3.VonNeumann 4.VonNeumann 5.VonNeumann  ");
	}
}