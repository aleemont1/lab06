package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> graph = new LinkedHashMap<>();

    public GraphImpl(N n, Set<N> set) {
        graph.put(n, set);
    }  
    
    public GraphImpl() {
    }

    @Override
    public void addNode(N node) {
        graph.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(N source, N target) {
        if (graphHasNode(source, target)) {
            graph.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return graph.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return graph.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        final List<N> path = new ArrayList<>();
        if(graphHasNode(source, target)) {
            path.add(source);
            for(final N n : graph.get(source)) {
                if(n.equals(target)) {
                    path.add(target);
                    return path;
                } else {
                    path.addAll(getPath(n, target));
                }
            }
        }
        return path;
    }
    
    @SafeVarargs
    private boolean graphHasNode(final N... nodes ) {
        for (final N node : nodes) {
            if (!graph.containsKey(node)) {
                throw new IllegalArgumentException("Node " + node + " isn't in the graph");
            }
        }
        return true;
    }
}
