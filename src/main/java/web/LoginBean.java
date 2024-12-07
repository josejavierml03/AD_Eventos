package web;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SuppressWarnings("serial")
@ManagedBean
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {


    private String rol;
    private String usuario;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String redirigir() {
        try {
            if ("propietario".equals(rol)) {
                FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("espacios.xhtml?propietario="+usuario);
            } else if ("organizador".equals(rol)) {
            	FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("crearEvento.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
}
