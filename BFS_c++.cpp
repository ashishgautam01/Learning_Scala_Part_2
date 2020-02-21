// DFS using c++

#include<iostream>
#include<list>
using namespace std;

class Graph {

	int v;
	list<int> *adj;
	void BFSShow(int v, bool visited[]);

public:
	void addEdge(int v, int w);
	void BFS(int v);

	Graph(int v){
		this->v = v;
		adj= new list<int>[v];
	}
};


void Graph::addEdge(int v, int w) 
{ 
    adj[v].push_back(w);  
} 

void Graph::BFS(int V) 
{ 
    bool *visited = new bool[V]; 
    for (int i = 0; i < V; i++) 
        visited[i] = false; 
  
    list<int> q;
    visited[v] = true;
    q.push_back(V);


    list<int>::iterator i;
    while(!q.empty()){
        V=q.front();
        cout<<V<<" ";
        //poo.append(V); Check for the cycle  solution here
        q.pop_front();

        for(i = adj[V].begin(); i!=adj[V].end();i++){
            if(!visited[*i]){
                visited[*i] = true;
                q.push_back(*i);
            }
        }
    }
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
    g.addEdge(3, 0); 

  
    cout << "Following is Breath First Traversal"
            " (starting from vertex 2) \n"; 
    g.BFS(2); 
  
    return 0; 
} 