package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.zerodistance.*;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class OneDistanceScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel nodesSelector;
    private final NodesListModel displayNeighbours;
    private final EdgesListModel edgesSelector;
    private final  JLabel startNode;
    private final JLabel arrivalNode;

    public OneDistanceScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        displayNeighbours = new NodesListModel();
        nodesSelector = new NodesListModel();
        edgesSelector = new EdgesListModel();

        startNode = ComponentsGenerator.jLabel("", true);
        arrivalNode = ComponentsGenerator.jLabel("", true);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setAlignmentY(CENTER_ALIGNMENT);
        setAlignmentX(CENTER_ALIGNMENT);

        buildScreen();
    }

    private void buildScreen() {
        add(ComponentsGenerator.verticalGlue(50));

        add(ComponentsGenerator.jLabel("Selectonnez un noeud pour aficher ses voisins : ", true));

        add(ComponentsGenerator.verticalGlue(20));

        add(ComponentsGenerator.customNodesComboBox(true, nodesSelector));
        nodesSelector.fill(screensManager.getGraphSAE().getNoeuds().values());

        add(ComponentsGenerator.verticalGlue(5));

        add(ComponentsGenerator.jButton("Analyser", true, new ActionDisplayNodeInformations(this)));

        add(ComponentsGenerator.verticalGlue(15));
        add(ComponentsGenerator.jLabel("Filtres (re-analyser pour reinitialiser)", true));

        JPanel jPanel = new JPanel();
        jPanel.setMaximumSize(new Dimension(10000, 100));
        jPanel.add(ComponentsGenerator.jButton("Villes", false, new ActionFilterByCity(this)));
        jPanel.add(ComponentsGenerator.jButton("Restaurants", false, new ActionFilterByRestaurant(this)));
        jPanel.add(ComponentsGenerator.jButton("Centres de loisir", false, new ActionFilterByLeisureCenter(this)));
        add(jPanel);

        add(ComponentsGenerator.verticalGlue(20));

        JList<Noeud> jList = new JList<>(displayNeighbours);
        jList.setAlignmentX(CENTER_ALIGNMENT);
        add(jList);

        add(ComponentsGenerator.verticalGlue(100));

        add(ComponentsGenerator.jLabel("Selectionnez une arete pour voir les neouds qui relie :", true));

        add(ComponentsGenerator.verticalGlue(20));

        add(ComponentsGenerator.customEdgesComboBox(true, edgesSelector));
        edgesSelector.fill(screensManager.getGraphSAE().getAretes());

        add(ComponentsGenerator.verticalGlue(5));

        add(ComponentsGenerator.jButton("Analyser", true, new ActionDisplayEdgeInformations(this)));

        add(ComponentsGenerator.verticalGlue(20));

        add(ComponentsGenerator.jLabel("Noeud de depart :", true));

        add(ComponentsGenerator.verticalGlue(5));

        add(startNode);

        add(ComponentsGenerator.verticalGlue(10));

        add(ComponentsGenerator.jLabel("Noeud d'arrivee :", true));

        add(ComponentsGenerator.verticalGlue(5));

        add(arrivalNode);

        add(Box.createVerticalGlue());
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getDisplayNeighbours() {
        return displayNeighbours;
    }

    public NodesListModel getNodesSelector() {
        return nodesSelector;
    }

    public EdgesListModel getEdgesSelector() {
        return edgesSelector;
    }

    public JLabel getStartNode() {
        return startNode;
    }

    public JLabel getArrivalNode() {
        return arrivalNode;
    }
}
