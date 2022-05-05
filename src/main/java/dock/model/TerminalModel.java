package dock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class TerminalModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "logic")
    private Integer logic;

    @Column(name = "serial")
    private String serial;

    @Column(name = "model")
    private String model;

    @Column(name = "sam")
    private Integer sam;

    @Column(name = "ptid")
    private String ptid;

    @Column(name = "plat")
    private Integer plat;

    @Column(name = "version")
    private String version;

    @Column(name = "mxr")
    private Integer mxr;

    @Column(name = "mxf")
    private Integer mxf;

    @Column(name = "PVERFM")
    private String PVERFM;

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

    public String getPVERFM() {
        return PVERFM;
    }

    public void setPVERFM(String PVERFM) {
        this.PVERFM = PVERFM;
    }
}
