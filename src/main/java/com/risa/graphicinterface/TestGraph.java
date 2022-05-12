package com.risa.graphicinterface;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerPipe;


public class TestGraph {

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing"); // ULTRA SUPER DUPER IMPORTANT LINE

        /*
        Graph graph = new MultiGraph("Test");

        graph.setAutoCreate(true);
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("AB", "A", "B");

        graph.addNode("C");
        graph.addEdge("AC1", "A", "C");
        graph.addEdge("AC2", "A", "C");

        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        Viewer viewer = graph.display();
        viewer.getDefaultView().enableMouseOptions();
        viewer.

        View view = viewer.getDefaultView();
         */

        MainWindow mainWindow = new MainWindow();

    }
}
