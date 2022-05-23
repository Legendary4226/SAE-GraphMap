package com.risa.functionality.compare.filter;

import com.risa.graph.Graph;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class NodeFilters {

    public Set<String> filterCustomized(Set<String> sites, Graph graph, TypeLieu filter) {
        Set<String> filteredSites = new HashSet<>();
        for (String site : sites) {
            if (graph.getNoeud(site).getTypeLieu() == filter) {
                filteredSites.add(site);
            }
        }
        return filteredSites;
    }

    public ArrayList<Noeud> filterCustomized(Collection<Noeud> nodes, TypeLieu filter) {
        ArrayList<Noeud> filteredNodes = new ArrayList<>();
        for (Noeud node : nodes) {
            if (node.getTypeLieu() == filter) {
                filteredNodes.add(node);
            }
        }
        return filteredNodes;
    }
}
