
public class ZeichenToolRechteck extends ZeichenTool {

	@Override
	public String getName() {
		return "Rechteck";
	}
	
	private Rechteck rechteck;
	
	@Override
	public void start(Vec2 pos) {
		rechteck = new Rechteck(pos, pos);
		zeichenBlatt.addFigur(rechteck);
	}
	
	@Override
	public void ziehen(Vec2 pos) {
		rechteck.setEnde(pos);
	}

}
