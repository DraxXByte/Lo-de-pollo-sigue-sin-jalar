package Modelo;

/**
 *
 * @author Invitado
 */
public class Usuario {
    String Nom;
        String User;
        String contra;
        String contra2;
        String edad;
        String carrer,puest;
        
      public Usuario(){
      Nom="";
      contra="";
      contra2="";
      edad="";
      carrer="";
      puest="";
            }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getContra2() {
        return contra2;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getPuest() {
        return puest;
    }

    public void setPuest(String puest) {
        this.puest = puest;
    }
      
}
