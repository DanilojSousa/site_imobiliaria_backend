package br.com.tecnologia.sistema.pessoa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rede_social", schema = "pessoa")
public class RedeSocialEntity implements Serializable {

    private Long rsoCodigo;
    private String rsoInstagram;
    private String rsoFacebook;
    private String rsoLinkedin;
    private String rsoX;
    private String rsoSite;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rso_codigo")
    public Long getRsoCodigo() {
        return rsoCodigo;
    }

    public void setRsoCodigo(Long rsoCodigo) {
        this.rsoCodigo = rsoCodigo;
    }

    @Column(name = "rso_instagram")
    public String getRsoInstagram() {
        return rsoInstagram;
    }

    public void setRsoInstagram(String rsoInstagram) {
        this.rsoInstagram = rsoInstagram;
    }
    @Column(name = "rso_facebook")
    public String getRsoFacebook() {
        return rsoFacebook;
    }

    public void setRsoFacebook(String rsoFacebook) {
        this.rsoFacebook = rsoFacebook;
    }
    @Column(name = "rso_linkedin")
    public String getRsoLinkedin() {
        return rsoLinkedin;
    }

    public void setRsoLinkedin(String rsoLinkedin) {
        this.rsoLinkedin = rsoLinkedin;
    }
    @Column(name = "rso_x")
    public String getRsoX() {
        return rsoX;
    }

    public void setRsoX(String rsoX) {
        this.rsoX = rsoX;
    }
    @Column(name = "rso_site")
    public String getRsoSite() {
        return rsoSite;
    }

    public void setRsoSite(String rsoSite) {
        this.rsoSite = rsoSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedeSocialEntity that = (RedeSocialEntity) o;
        return Objects.equals(rsoCodigo, that.rsoCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rsoCodigo);
    }
}
