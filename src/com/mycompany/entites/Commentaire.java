/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

import java.util.LinkedHashMap;

/**
 *
 * @author HP
 */
public class Commentaire {
    int id_com;
  int id_user;
   String desc_com;
   String date_com;
   int id_post;
  LinkedHashMap<String,Object> hm;

    public Commentaire() {
    }


   
    public LinkedHashMap<String, Object> getHm() {
        return hm;
    }

    public void setHm(LinkedHashMap<String, Object> hm) {
        this.hm = hm;
    }

    public Commentaire(int id_com, int id_user, String desc_com, String date_com, int id_post, LinkedHashMap<String, Object> hm) {
        this.id_com = id_com;
        this.id_user = id_user;
        this.desc_com = desc_com;
        this.date_com = date_com;
        this.id_post = id_post;
        this.hm = hm;
      
    }
    public Commentaire( int id_user, String desc_com, String date_com, int id_post, LinkedHashMap<String, Object> hm) {
      
        this.id_user = id_user;
        this.desc_com = desc_com;
        this.date_com = date_com;
        this.id_post = id_post;
        this.hm = hm;
    
    }

   

   

    
    

   
    public int getId_com() {
        return id_com;
    }

    

    public String getDesc_com() {
        return desc_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDate_com() {
        return date_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

  

    public void setDesc_com(String desc_com) {
        this.desc_com = desc_com;
    }
  


  
    @Override
    public String toString() {
        return "post{" + "id_com=" + id_com + ", id_user=" + id_user + ", desc_com=" + desc_com +  ", date_com=" + date_com +  ", id_post=" + id_post + '}';
       
    }

    
 

}
