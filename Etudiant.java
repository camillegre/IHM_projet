
/**
 * Write a description of class Etudiant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Etudiant
{
    // instance variables - replace the example below with your own
    private int Id_Etudiant;
    private String Nom;
    private String Prenom;
    private String Promotion;
    private String Parcours;
    /**
     * Constructor for objects of class Etudiant
     */
    public Etudiant(int Id, String Nom, String Prenom, String Promo, String parcours)
    {
        this.Id_Etudiant = Id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Promotion = Promo;
        this.Parcours = parcours;
    }

}
