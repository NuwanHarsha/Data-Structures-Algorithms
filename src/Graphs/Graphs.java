package Graphs;

import java.util.ArrayList;

public class Graphs {
    //Total number of Vertices
    int numberOfVertices;
    //Adjacency list
    ArrayList<Integer> adj[];
    //Indegree Array
    int indegreeVertex[];
    ArrayList<Edges> edgeList;

    boolean isUndirected;

    Graphs(int vertices) {
        numberOfVertices = vertices;
        indegreeVertex = new int[numberOfVertices];
        adj = new ArrayList[numberOfVertices];
        edgeList = new ArrayList<Edges>();
        for (int i = 0; i < numberOfVertices; i++)
            adj[i] = new ArrayList<Integer>();
        this.isUndirected = isUndirected;
    }

    //Constructor for Undirected Graphs
    Graphs(int vertices, boolean isUndirected) {
        numberOfVertices = vertices;
        indegreeVertex = new int[numberOfVertices];
        adj = new ArrayList[numberOfVertices];
        edgeList = new ArrayList<Edges>();
        for (int i = 0; i < numberOfVertices; i++)
            adj[i] = new ArrayList<Integer>();
        this.isUndirected = isUndirected;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        if (isUndirected) {
            adj[w].add(v);
        }
        Edges edges = new Edges(v, w);
        edgeList.add(edges);
        indegreeVertex[w]++;
    }

    void addEdge(int v, int w, int weight) {
        adj[v].add(w);
        if (isUndirected) {
            adj[w].add(v);
        }
        Edges edges = new Edges(v, w, weight);
        edgeList.add(edges);
        indegreeVertex[w]++;
    }

    int getNumberOfVertices() {
        return numberOfVertices;
    }

    int numberOfAdjacentVertices(int v) {
        return adj[v].size();
    }

    class Edges {
        int v1;
        int v2;
        int weight;

        Edges(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        Edges(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

    }
}