// DFS using c++

#include<iostream>
#include<list>
using namespace std;

class Graph {

	int v;
	list<int> *adj;
	void DFSShow(int v, bool visited[]);

public:
	void addEdge(int v, int w);
	void DFS(int v);

	Graph(int v){
		this->v = v;
		adj= new list<int>[v];
	}
};


void Graph::addEdge(int v, int w) 
{ 
    adj[v].push_back(w);  
} 
  
void Graph::DFSShow(int v, bool visited[]) 
{ 
    visited[v] = true;  // Mark the current node as visited and print it 
    cout << v << " "; 
  
    list<int>::iterator i;   // Recur for all the vertices adjacent to this vertex 
    for (i = adj[v].begin(); i != adj[v].end(); ++i) 
        if (!visited[*i]) 
            DFSShow(*i, visited); 
} 
  
// DFS traversal of the vertices reachable from v. It uses recursive DFSUtil() 
void Graph::DFS(int V) 
{ 
    // Marking all of the vertices as not visited 
    bool *visited = new bool[V]; 
    for (int i = 0; i < V; i++) 
        visited[i] = false; 
  
    DFSShow(V, visited);  
} 

int main() 
{ 
    Graph g(4); 
    g.addEdge(0, 3); 
    g.addEdge(0, 2); 
    g.addEdge(1, 3); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 1); 

  
    cout << "Following is Depth First Traversal"
            " (starting from vertex 2) \n"; 
    g.DFS(2); 
  
    return 0; 
} 