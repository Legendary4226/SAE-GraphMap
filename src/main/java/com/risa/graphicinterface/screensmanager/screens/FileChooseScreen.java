package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.filechoose.ActionSelectFile;

import javax.swing.*;
import java.awt.*;

public class FileChooseScreen extends JPanel {
    ScreensManager screensManager;
    JLabel loadState;
    JFileChooser fileChooser;
    JButton validation;
    ActionSelectFile actionSelectFile;

    public FileChooseScreen(ScreensManager screensManager) {
        super();

        this.screensManager = screensManager;
        this.loadState = ComponentsGenerator.jLabel("decharge", false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildScreen();
    }

    private void buildScreen() {
        add(ComponentsGenerator.jLabel("Choisir un fichier :", true));

        fileChooser = new JFileChooser(System.getProperty("user.dir") + "\\csv");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setControlButtonsAreShown(false);
        fileChooser.setMultiSelectionEnabled(false);


        actionSelectFile = new ActionSelectFile(this);

        add(fileChooser);
        add(ComponentsGenerator.jButton("Valider la selection et charger le graphe", true,
                actionSelectFile)
        );

        add(buildIsLoaded());
    }

    private JPanel buildIsLoaded() {
        JPanel jPanel = new JPanel();

        jPanel.add(ComponentsGenerator.jLabel("Etat de chargement du graphe : ", false));
        loadState.setForeground(Color.DARK_GRAY);
        jPanel.add(loadState);

        return jPanel;
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public JLabel getLoadState() {
        return loadState;
    }

    public JButton getValidation() {
        return validation;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }
}
