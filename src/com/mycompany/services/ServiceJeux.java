/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.ConnectionRequest;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entites.Jeux;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author tarek
 */
public class ServiceJeux {
    
   public static ServiceJeux instance = null;
   
    public static boolean resultOk = true;

    private ConnectionRequest req;

    public static ServiceJeux getInstance()
    {
        if(instance == null)
            instance = new ServiceJeux();
        return instance;  

    }

    public ServiceJeux()
    {
        req = new ConnectionRequest();
    }



      public void AjouterCategorie(Jeux jeux)
    {
        String url = Statics.BASE_URL+"/jeux/s/AjouterCategorieMobile?nomjeux="+jeux.getNomjeux()+"&imagejeux="+jeux.getImagejeux();
        req.setUrl(url);
        req.addResponseListener ((e) -> {
             
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
  
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

    }

    
    
    
    
    
    
    public ArrayList<Jeux> AfficherJeux()
    {

        ArrayList<Jeux> result = new ArrayList<>();
        String url = Statics.BASE_URL+"jeux/s/AfficherJeuxMobile";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                JSONParser jsonp;
                jsonp = new JSONParser();
                
                try 
                {
                    Map<String,Object>mapCategorie = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String,Object>> ListOfMaps = (List<Map<String,Object>>) mapCategorie.get("root");
                    for(Map<String, Object> obj : ListOfMaps)
                    {
                        Jeux c = new Jeux();
                        float id = Float.parseFloat(obj.get("idjeux").toString());
                        String Namecateg = obj.get("nomjeux").toString();
                        String Descriptioncateg = obj.get("imagejeux").toString();

                        c.setIdjeux((int)id);
                        //c.setProduit(produit.getId());
                        //c.setQuantite((int)quantite);
                        c.setNomjeux(Namecateg);
                        c.setImagejeux(Descriptioncateg);
                        result.add(c);
                        System.out.println(c.getIdjeux()+" "+c.getNomjeux());
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    
    }    
}
