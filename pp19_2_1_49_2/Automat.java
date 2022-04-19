public class Automat {
	private Zellraum a;
	private Nachbarschaft b;

	Automat(Zellraum a, Nachbarschaft b) {

		this.a = a;
		this.b = b;

	}

	synchronized void naechsteGenerationBerechnen() {
		{
			if (this.b.getb()) {
				int M = a.getzeilen();
				int N = a.getspalten();
				int[][] newzell = new int[M][N];

				for (int l = 0; l < M; l++) {
					for (int m = 0; m < N; m++) {

						int an = 0;
						for (int i = -1; i <= 1; i++) {
							for (int j = -1; j <= 1; j++) {
								int v = l;
								int z = m;
								if (m + j == N) {
									z = -1;
								}
								if (l + i == M) {
									v = -1;
								}
								if (l + i == -1) {
									v = M;
								}
								if (m + j == -1) {
									z = N;
								}

								an = a.getZellen()[v + i][z + j] + an;
							}
						}
						an -= a.getZellen()[l][m];

						if ((a.getZellen()[l][m] == 1) && (an < 2)) {
							newzell[l][m] = 0;
						}

						else if ((a.getZellen()[l][m] == 1) && (an > 3)) {
							newzell[l][m] = 0;
						}

						else if ((a.getZellen()[l][m] == 0) && (an == 3)) {
							newzell[l][m] = 1;
						}

						else {
							newzell[l][m] = a.getZellen()[l][m];
						}
					}
				}

				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						if (newzell[i][j] == 0)
							a.getZellen()[i][j] = 0;
						else
							a.getZellen()[i][j] = 1;
					}

				}
			} else {
				int M = a.getzeilen();
				int N = a.getspalten();
				int[][] newzell = new int[M][N];

				for (int l = 1; l < M; l++) {
					for (int m = 1; m < N; m++) {

						int an = 0;
						for (int i = -1; i <= 1; i++) {
							for (int j = -1; j <= 1; j++) {
								int v = l;
								int z = m;
								if (l + i == -1) {
									v = M;
								}
								if (m + j == -1) {
									z = N;
								}
								if (l + i == M) {
									v = -1;
								}
								if (m + j == N) {
									z = -1;
								}
								if (((((v + i) == (v - 1)) || ((v + i) == (v + 1))) && ((z + j) == (z - 1)))
										|| (((((v + i) == (v - 1)) || ((v + i) == (v + 1))) && ((z + j) == (z + 1))))) {
								} else {
									an = a.getZellen()[v + i][z + j] + an;
								}
							}
						}
						an -= a.getZellen()[l][m];

						if ((a.getZellen()[l][m] == 1) && (an < 2)) {
							newzell[l][m] = 0;
						}

						else if ((a.getZellen()[l][m] == 1) && (an > 3)) {
							newzell[l][m] = 0;
						}

						else if ((a.getZellen()[l][m] == 0) && (an == 3)) {
							newzell[l][m] = 1;
						}

						else {
							newzell[l][m] = a.getZellen()[l][m];
						}
					}
				}

				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						if (newzell[i][j] == 0)
							a.getZellen()[i][j] = 0;
						else
							a.getZellen()[i][j] = 1;
					}

				}
			}
		}
	}

}