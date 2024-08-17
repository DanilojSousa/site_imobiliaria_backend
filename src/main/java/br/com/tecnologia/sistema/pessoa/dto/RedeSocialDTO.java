package br.com.tecnologia.sistema.pessoa.dto;

import br.com.tecnologia.sistema.pessoa.model.RedeSocialEntity;
import lombok.Data;

@Data
public class RedeSocialDTO {

    private Long rsoCodigo;
    private String rsoInstagram;
    private String rsoFacebook;
    private String rsoLinkedin;
    private String rsoX;
    private String rsoSite;

    public RedeSocialDTO(RedeSocialEntity redeSocial) {
        this.rsoCodigo = redeSocial.getRsoCodigo();
        this.rsoInstagram = redeSocial.getRsoInstagram();
        this.rsoFacebook = redeSocial.getRsoFacebook();
        this.rsoLinkedin = redeSocial.getRsoLinkedin();
        this.rsoX = redeSocial.getRsoX();
        this.rsoSite = redeSocial.getRsoSite();
    }
}
