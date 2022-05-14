/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

/**
 *
 * @author tarek
 */
public class Jeux {
      private int idjeux;
    private String nomjeux;
    private String imagejeux;



     public Jeux(int idjeux, String nomjeux, String imagejeux) {
        this.idjeux = idjeux;
        this.nomjeux = nomjeux;
        this.imagejeux = imagejeux;
    }

    public Jeux() {
    }

    public Jeux(String nomjeux, String imagejeux) {
        this.nomjeux = nomjeux;
        this.imagejeux = imagejeux;
    }

    public int getIdjeux() {
        return idjeux;
    }

    public void setIdjeux(int idjeux) {
        this.idjeux = idjeux;
    }

    public String getNomjeux() {
        return nomjeux;
    }

    public void setNomjeux(String nomjeux) {
        this.nomjeux = nomjeux;
    }

    public String getImagejeux() {
        return imagejeux;
    }

    public void setImagejeux(String imagejeux) {
        this.imagejeux = imagejeux;
    }

    @Override
    public String toString() {
        return "Jeux{" + "Jeux_id=" + idjeux + ", NomJeux=" + nomjeux + ", ImageJeux=" + imagejeux + '}';
    }

}
