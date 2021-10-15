package umn.ac.id.myweek7b_chotiwut_34993;

import java.io.Serializable;

public class SumberVideo implements Serializable {
    private String judul;
    private String keterangan;
    private String videoURI;

    // Constructor
    public SumberVideo(String judul, String keterangan, String videoURI) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.videoURI = videoURI;
    }

    // Getter
    public String getJudul() { return this.judul; }
    public String getKeterangan() { return this.keterangan; }
    public String getVideoURI() { return this.videoURI; }

    // Setter
    public void setJudul(String judul) { this.judul = judul; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
    public void setVideoURI(String videoURI) { this.videoURI = videoURI; }

    // Custom
    public String toString() {
        return this.getJudul() + " => " + this.getKeterangan();
    }
}
