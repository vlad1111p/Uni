public abstract class ZeichenTool {
    protected ZeichenBlatt zeichenBlatt;


    public void init(ZeichenBlatt zeichenBlatt) {
        this.zeichenBlatt = zeichenBlatt;
    }

    /**
     * Der Name des Zeichentools
     */
    public abstract String getName();

    /**
     * Wird aufgerufen, wenn der Benutzer auf die Zeichenfläche klickt. x und y geben die aktuellen Maus-Koordinaten an.
     */
    public abstract void start(Vec2 pos);

    /**
     * Wird aufgerufen, wenn der Benutzer seine Maus bei gedrückter Maustaste über die Zeichenfläche zieht. x und y geben die aktuellen Maus-Koordinaten an.
     */
    public abstract void ziehen(Vec2 pos);

    /**
     * Wird aufgerufen, wenn der Benutzer die Maustaste loslässt. x und y geben die aktuellen Maus-Koordinaten an.
     */
    public void ende(Vec2 pos) {
        ziehen(pos);
    }


}
