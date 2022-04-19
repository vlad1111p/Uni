
public class ZeichenToolVerschieben extends ZeichenTool {

    @Override
    public String getName() {
        return "Verschieben";
    }

    private Figur auswahl;
    private Vec2 startPunkt;

    @Override
    public void start(Vec2 pos) {
        startPunkt = pos;
        auswahl = zeichenBlatt.figurBeiPunkt(startPunkt);
    }

    @Override
    public void ziehen(Vec2 pos) {
        if (auswahl != null) {
            auswahl.verschiebenUm(pos.minus(startPunkt));
            startPunkt = pos;
        }
    }

}
