
public class ZeichenToolLinie extends ZeichenTool {

    @Override
    public String getName() {
        return "Linie";
    }

    private Linie linie;

    @Override
    public void start(Vec2 pos) {
        linie = new Linie(pos, pos);
        zeichenBlatt.addFigur(linie);
    }

    @Override
    public void ziehen(Vec2 pos) {
        linie.setEnde(pos);
    }

}
