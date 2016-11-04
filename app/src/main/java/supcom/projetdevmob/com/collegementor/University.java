package supcom.projetdevmob.com.collegementor;

import java.io.Serializable;

/**
 * Created by pc on 30/10/2016.
 */

public class University implements Serializable,Comparable<University> {

    private String Nom ;

    private int image;
    int rating ;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public University(int image,String nom, int rating) {

        Nom = nom;

        this.image = image;
        this.rating = rating;
    }

    public int getimage() {
        return image;
    }

    public University(int image, String nom) {
        this.image = image;
        Nom = nom;
    }

    public void setimage(int image) {
        this.image = image;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    @Override
    public int compareTo(University u) {
            int comparerating = ((University)u).getRating();
        return comparerating-this.rating;

    }



}
