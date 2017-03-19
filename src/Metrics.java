public class Metrics {

    public static final Metrics INSTANCE = new Metrics();

    int functionCount = 0;
    int classCount = 0;
    int variablesCount = 0;
    int constantCount = 0;
    int loopsCount = 0;

    void clear() {
        this.functionCount = 0;
        this.classCount = 0;
        this.variablesCount = 0;
        this.constantCount = 0;
        this.loopsCount = 0;
    }
}
