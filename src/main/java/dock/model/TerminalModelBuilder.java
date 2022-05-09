package dock.model;

public class TerminalModelBuilder {

    private Integer logic;
    private String serial;
    private String model;
    private Integer sam;
    private String ptid;
    private Integer plat;
    private String version;
    private Integer mxr;
    private Integer mxf;
    private String pverfm;

    public static TerminalModelBuilder builder() {
        return new TerminalModelBuilder();
    }

    public TerminalModelBuilder addLogic(Integer logic) {
        this.logic = logic;
        return this;
    }

    public TerminalModelBuilder addSerial(String serial) {
        this.serial = serial;
        return this;
    }

    public TerminalModelBuilder addModel(String model) {
        this.model = model;
        return this;
    }

    public TerminalModelBuilder addSam(Integer sam) {
        this.sam = sam;
        return this;
    }

    public TerminalModelBuilder addPtid(String ptid) {
        this.ptid = ptid;
        return this;
    }

    public TerminalModelBuilder addPlat(Integer plat) {
        this.plat = plat;
        return this;
    }

    public TerminalModelBuilder addVersion(String version) {
        this.version = version;
        return this;
    }

    public TerminalModelBuilder addMxr(Integer mxr) {
        this.mxr = mxr;
        return this;
    }

    public TerminalModelBuilder addMxf(Integer mxf) {
        this.mxf = mxf;
        return this;
    }

    public TerminalModelBuilder addPverfm(String pverfm) {
        this.pverfm = pverfm;
        return this;
    }

    public TerminalModel build() {
        return new TerminalModel(this.logic,
                this.serial,
                this.model,
                this.sam,
                this.ptid,
                this.plat,
                this.version,
                this.mxr,
                this.mxf,
                this.pverfm);
    }
}
