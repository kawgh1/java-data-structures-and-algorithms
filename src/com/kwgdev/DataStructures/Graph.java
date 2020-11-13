package com.kwgdev.DataStructures;

import java.util.ArrayList;

public class Graph {

    public static void main(String[] args) {

        Graph myGraph = new Graph(5, "directed");
        myGraph.addVertex("State");
        myGraph.addVertex("Avenel");
        myGraph.addVertex("Elm");
        myGraph.addVertex("Pocono");
        myGraph.addVertex("William");

        myGraph.addEdge("Avenel", "Pocono");
        myGraph.addEdge("State", "Elm");
        myGraph.addEdge("Elm", "Avenel");
        myGraph.addEdge("Elm", "William");
        myGraph.addEdge("William", "State");
        myGraph.addEdge("William", "Pocono");
        myGraph.addEdge("Pocono", "Elm");
        myGraph.addEdge("State", "Avenel");

        myGraph.print();

//		Object [] values = myGraph.adj(1);
//		for(Object val : values){
//			System.out.println(val);
//		}
    }

    // Basic Graph class
//    public class Graph {
//        private int vCount; // number of vertices
//        private int eCount; // Number of edges
//
//        private ArrayList[] adjacents; // array of integer lists
//
//        public Graph(int vCount) {
//            this.vCount = vCount;
//            this.eCount = 0;
//            adjacents = new ArrayList[vCount];
//
//            for (int i = 0; i < vCount; i++) {
//                adjacents[i] = new ArrayList();
//            }
//        }
//
//        public int getVertexCount() {
//            return vCount;
//        }
//
//        public int getEdgeCount() {
//            return eCount;
//        }
//
//        public void addEdge(int src, int dest) {
//            adjacents[src].add(dest);
//            eCount++;
//        }
//
//        public Object[] adj(int src) {
//            return adjacents[src].toArray();
//        }
//    }


            Vertex[] arrayOfLists;
            int indexCounter = 0;
            boolean undirected=true;

            class Node {
                public int vertexIdx;
                public Node next;
                public Node(int vertexIdx, Node node) {
                    this.vertexIdx = vertexIdx;
                    next = node;
                }
            }

            class Vertex {
                String name;
                Node adjList;
                Vertex(String name, Node aNode) {
                    this.name = name;
                    this.adjList = aNode;
                }
            }


        public Graph(int vCount, String graphType) {

            if (graphType.equals("directed")) {
                undirected=false;
            }

            arrayOfLists = new Vertex[vCount];
        }

        public void addVertex(String vertexName){
            arrayOfLists[indexCounter] = new Vertex(vertexName, null);
            indexCounter++;
        }

        public void addEdge(String srcVertexName, String destVertexName){
            int v1Idx = indexForName(srcVertexName);
            int v2Idx = indexForName(destVertexName);
            arrayOfLists[v1Idx].adjList = new Node(v2Idx, arrayOfLists[v1Idx].adjList);
            if(undirected){
                arrayOfLists[v2Idx].adjList = new Node(v1Idx, arrayOfLists[v2Idx].adjList);
            }
        }

        int indexForName(String name) {
            for (int v=0; v < arrayOfLists.length; v++) {
                if (arrayOfLists[v].name.equals(name)) {
                    return v;
                }
            }
            return -1;
        }

        public void print() {
            System.out.println();
            for (int v=0; v < arrayOfLists.length; v++) {
                System.out.print(arrayOfLists[v].name);
                for (Node aNode = arrayOfLists[v].adjList; aNode != null; aNode = aNode.next) {
                    System.out.print(" --> " + arrayOfLists[aNode.vertexIdx].name);
                }
                System.out.println("\n");
            }
        }

    }


