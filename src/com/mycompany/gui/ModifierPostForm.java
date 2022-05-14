/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entites.Post;
import com.mycompany.services.ServicePost;

/**
 *
 * @author HP
 */
public class ModifierPostForm extends BaseForm {

    Form current;

    public ModifierPostForm(Resources res, Post r) {
        super("Newsfeed", BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical

        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        TextField tfID = new TextField(String.valueOf(r.getId_post()), "ArtilceID");
        tfID.setVisible(false);
        TextField tilte = new TextField(r.getTitre(), "titre", 20, TextField.ANY);
        TextField author = new TextField(r.getAuteur(), "auteur", 20, TextField.ANY);
        TextField imapge = new TextField(r.getImg_post(), "image", 20, TextField.ANY);
        TextField date = new TextField(r.getDate_post(), "date", 20, TextField.ANY);

        TextField rete = new TextField(String.valueOf(r.getRate()), "rate", 20, TextField.ANY);

        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        tilte.setUIID("NewsTopLine");
        author.setUIID("NewsTopLine");
        imapge.setUIID("NewsTopLine");
        date.setUIID("NewsTopLine");
        rete.setUIID("NewsTopLine");

        tilte.setSingleLineTextArea(true);
        author.setSingleLineTextArea(true);
        imapge.setSingleLineTextArea(true);
        date.setSingleLineTextArea(true);
        rete.setSingleLineTextArea(true);

        Button btnModifier = new Button("Modifier");
        btnModifier.setUIID("Button");

        //Event onclick btnModifer
        btnModifier.addPointerPressedListener(l -> {

            r.setTitre(tilte.getText());
            r.setAuteur(author.getText());
            r.setImg_post(imapge.getText());
            r.setDate_post(date.getText());
            r.setRate(Integer.valueOf(rete.getText()));

            //appel fonction modfier reclamation men service
            if (ServicePost.getInstance().modifierPost(r)) { // if true
                new ListPostForm(res).show();
            }
        });
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e -> {
            new ListPostForm(res).show();
        });

        Label l2 = new Label("");

        Label l3 = new Label("");

        Label l4 = new Label("");

        Label l5 = new Label("");

        Label l1 = new Label();

        Container content = BoxLayout.encloseY(
                l1, l2,
                new FloatingHint(tilte),
                createLineSeparator(),
                new FloatingHint(author),
                createLineSeparator(),
                new FloatingHint(imapge),
                createLineSeparator(),
                new FloatingHint(date),
                createLineSeparator(),
                new FloatingHint(rete),
                createLineSeparator(),
                btnModifier,
                btnAnnuler
        );

        add(content);
        show();

    }
}
