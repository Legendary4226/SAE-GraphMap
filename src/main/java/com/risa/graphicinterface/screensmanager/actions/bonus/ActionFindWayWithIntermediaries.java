package com.risa.graphicinterface.screensmanager.actions.bonus;

import com.risa.functionality.way.intermediary.FindWayWithIntermediaries;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.BonusScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ActionFindWayWithIntermediaries extends AbstractAction {
    private final BonusScreen bonusScreen;

    public ActionFindWayWithIntermediaries(BonusScreen bonusScreen) {
        this.bonusScreen = bonusScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean checkSelections = checkSelections();
        if (checkSelections) {
            FindWayWithIntermediaries finder = new FindWayWithIntermediaries();
            ArrayList<String> way = finder.findWayWithIntermediaries(
                    bonusScreen.getScreensManager().getWkMatrix(),
                    ((Noeud) bonusScreen.getSelectorOne().getSelectedItem()).getNom(),
                    ((Noeud) bonusScreen.getSelectorTwo().getSelectedItem()).getNom(),
                    getSelections()
            );

            System.out.println(way);

            bonusScreen.getAnswerWayWithIntermediaries().setText(
                    way.toString().replace("[", "<").replace("]", ">")
            );

            bonusScreen.getScreensManager().getGraphUI().asyncColorizeGivenWay(way);
        }

        if (! checkSelections) {
            JOptionPane.showMessageDialog(bonusScreen, "Veuillez selectionner un site dans tout les champs.");
        }
    }

    private boolean checkSelections() {
        boolean check = true;

        if (bonusScreen.getSelectorOne().getSelectedItem() == null
                || bonusScreen.getSelectorTwo().getSelectedItem() == null) {
            check = false;
        }

        for (JComboBox<Noeud> selector : bonusScreen.getIntermediarySites()) {
            if (selector.getSelectedItem() == null) {
                check = false;
            }
        }

        return check;
    }

    private ArrayList<String> getSelections() {
        ArrayList<String> selections = new ArrayList<>();

        for (JComboBox<Noeud> selector : bonusScreen.getIntermediarySites()) {
            selections.add(((Noeud) selector.getSelectedItem()).getNom());
        }

        return selections;
    }
}
