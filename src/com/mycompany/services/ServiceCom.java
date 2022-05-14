/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entites.Commentaire;
import com.mycompany.entites.Post;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class ServiceCom {

    Boolean resultOK;
    public static ServiceCom instance = null;

    public static boolean resultOk = true;

    private ConnectionRequest req;

    public static ServiceCom getInstance() {
        if (instance == null) {
            instance = new ServiceCom();
        }
        return instance;

    }

    public ServiceCom() {
        req = new ConnectionRequest();
    }

    public void ajoutCom(Commentaire p) {

        String url = Statics.BASE_URL + "commentaire/ajoutercomMobile/new?desc_com=" + p.getDesc_com() + "&date_com=" + p.getDate_com() + "&id_post=53"  + "&id_user=39" ;// aa sorry n3adi getId lyheya mech ta3 user ta3 reclamation

        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

    }

    public ArrayList<Commentaire> AfficherCom() {

        ArrayList<Commentaire> result = new ArrayList<>();
        String url = Statics.BASE_URL + "commentaire/s/AfficherComMobile";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapCategorie = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> ListOfMaps = (List<Map<String, Object>>) mapCategorie.get("root");
                    for (Map<String, Object> obj : ListOfMaps) {
                        Commentaire c = new Commentaire();
                        float id = Float.parseFloat(obj.get("idCom").toString());

                        String desc_com = obj.get("descCom").toString();
                        String date_com = obj.get("dateCom").toString();
                        //float id_user = Float.parseFloat(obj.get("idUser").toString());

                       //float id_post = Float.parseFloat(obj.get("idPost").toString());

                        c.setId_com((int) id);
                        c.setDesc_com(desc_com);
                        c.setDate_com(date_com);

                        //c.setId_user(39);
                        //c.setId_post(73);

                        result.add(c);
                        System.out.println(c.getId_com() + " " + c.getDesc_com() + " " + c.getDate_com() + " " + c.getId_post() + " " + c.getId_user());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;

    }

}
