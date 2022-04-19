public class Spreadsheet {

	int columns = 0;
	int rows = 0;
	int[][] s = new int[0][0];
	int [][] save = new int[0][6];
	
	Spreadsheet(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		s = new int[columns][rows];
	}
	
	void set(int column, int row, int value) {
		s[column][row]=value;
		
		for (int i=0; i<this.save.length; i++) {
			setSumCalculation2(this.save[i][0],this.save[i][1], this.save[i][2], this.save[i][3], this.save[i][4], this.save[i][5]);
		}
	}
	
	int get(int column, int row) {
		int ausgabe = 0;
		ausgabe = s[column][row];
		
	return ausgabe;	
	}
	
	void setSumCalculation(int resultColumn, int resultRow,
						   int startColumn, int startRow,
						   int endColumn, int endRow) {
		int save = 0;
		for(int i = startColumn; i <= endColumn; i++) {
			for(int j = startRow; j <= endRow; j++) {
				save = save + s[i][j];
			}
		}
		this.save=resize(this.save);
		this.save[this.save.length-1][0]=resultColumn;
		this.save[this.save.length-1][1]=resultRow;
		this.save[this.save.length-1][2]=startColumn;
		this.save[this.save.length-1][3]=startRow;
		this.save[this.save.length-1][4]=endColumn;
		this.save[this.save.length-1][5]=endRow;
		
		s[resultColumn][resultRow] = save;
		for (int i=0; i<this.save.length; i++) {
			setSumCalculation2(this.save[i][0],this.save[i][1], this.save[i][2], this.save[i][3], this.save[i][4], this.save[i][5]);
		}
	}
	
	void setSumCalculation2(int resultColumn, int resultRow,
			   int startColumn, int startRow,
			   int endColumn, int endRow) {
			int save = 0;
			for(int i = startColumn; i <= endColumn; i++) {
				for(int j = startRow; j <= endRow; j++) {
					save = save + s[i][j];
				}
			}
			s[resultColumn][resultRow] = save;
	}
	

	
	int[][] resize (int[][] save) {
		int temp[][]= new int[save.length][6];
		for (int i=0; i<save.length; i++) {
			for (int j=0; j<save[i].length; j++) {
				temp[i][j]=save[i][j];
			}
		}
		
		save = new int[temp.length+1][6];
		
		for (int i=0; i<temp.length;i++) {
			for (int j=0; j<temp[i].length; j++) {
				save[i][j]=temp[i][j];
			}
		}
		return save;
	}
		
}
