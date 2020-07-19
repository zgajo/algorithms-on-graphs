class Graph {
  constructor(vertices_total) {
    this.adj = Array.from(Array(vertices_total), () => new Array());
    this.visited_vertices = new Map();
  }

  checkReachability(u, v) {
    this.visited_vertices = new Map();
    return this.DFS(u, v);
  }

  addEdge(u, v) {
    this.adj[u - 1].push(v);
    this.adj[v - 1].push(u);
  }

  DFS(u, v) {
    if (this.adj[u - 1].includes(v)) {
      return 1;
    }

    if (this.visited_vertices.get(u)) {
      return 0;
    }

    this.visited_vertices.set(u, true);

    for (let i = 0; i < this.adj[u - 1].length; i++) {
      return this.DFS(this.adj[u - 1][i], v);
    }
  }
}

const graph1 = new Graph(4);

graph1.addEdge(1, 2);
graph1.addEdge(3, 2);
graph1.addEdge(4, 3);
graph1.addEdge(1, 4);

console.log(graph1.checkReachability(1, 4));

const graph2 = new Graph(4);

graph2.addEdge(1, 2);
graph2.addEdge(3, 2);

console.log(graph2.checkReachability(1, 4));
