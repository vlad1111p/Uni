
public class ZeichenToolKreis extends ZeichenTool {
	
	@Override
	public String getName() {
		return "Kreis";
	}
	
	private Kreis kreis;
	
	@Override
	public void start(Vec2 pos) {
		kreis = new Kreis(pos, pos);
		zeichenBlatt.addFigur(kreis);
	}
	
	@Override
	public void ziehen(Vec2 pos) {
		kreis.setEnde(pos);
	}
}
