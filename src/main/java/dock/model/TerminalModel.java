package dock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TerminalModel")
public class TerminalModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "logic")
    @JsonProperty(value = "logic", required = true)
    private Integer logic;

    @Column(name = "serial")
    @JsonProperty(value = "serial", required = true)
    private String serial;

    @Column(name = "model")
    @JsonProperty(value = "model", required = true)
    private String model;

    @Column(name = "sam")
    @JsonProperty("sam")

    private Integer sam;

    @Column(name = "ptid")
    @JsonProperty("ptid")
    private String ptid;

    @Column(name = "plat")
    @JsonProperty("plat")
    private Integer plat;

    @Column(name = "version")
    @JsonProperty(value = "version", required = true)
    private String version;

    @Column(name = "mxr")
    @JsonProperty("mxr")
    private Integer mxr;

    @Column(name = "mxf")
    @JsonProperty("mxf")
    private Integer mxf;

    @Column(name = "pverfm")
    @JsonProperty("PVERFM")
    private String pverfm;

    public TerminalModel() {
    }

    public TerminalModel(Integer logic,
                         String serial,
                         String model,
                         Integer sam,
                         String ptid,
                         Integer plat,
                         String version,
                         Integer mxr,
                         Integer mxf,
                         String pverfm) {
        this.logic = logic;
        this.serial = serial;
        this.model = model;
        this.sam = sam;
        this.ptid = ptid;
        this.plat = plat;
        this.version = version;
        this.mxr = mxr;
        this.mxf = mxf;
        this.pverfm = pverfm;
    }

    public Integer getLogic() {
        return logic;
    }

    public void setLogic(Integer logic) {
        this.logic = logic;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSam() {
        return sam;
    }

    public void setSam(Integer sam) {
        this.sam = sam;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public Integer getPlat() {
        return plat;
    }

    public void setPlat(Integer plat) {
        this.plat = plat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getMxr() {
        return mxr;
    }

    public void setMxr(Integer mxr) {
        this.mxr = mxr;
    }

    public Integer getMxf() {
        return mxf;
    }

    public void setMxf(Integer mxf) {
        this.mxf = mxf;
    }

    public String getPverfm() {
        return pverfm;
    }

    public void setPverfm(String pverfm) {
        this.pverfm = pverfm;
    }
}
