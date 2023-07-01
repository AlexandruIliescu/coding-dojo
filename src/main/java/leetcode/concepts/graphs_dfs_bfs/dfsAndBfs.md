BFS (Breadth-First Search) and DFS (Depth-First Search) are two common graph traversal algorithms used in programming to explore or search through graph-like data structures.

BFS 
- Uses a Stack
- Goes as far as possible on each branch, then backtrack and find another unvisited branch
- Last In First Out
- Find shortest path from vertex A to vertex B

DFS 
- Uses a Queue
- Explore nearby vertex first
- First In First Out


### BFS 
* BFS explores a graph by traversing all the vertices at the same level before moving on to the next level.
It uses a queue data structure to keep track of the vertices to visit.
The algorithm starts by visiting the initial vertex, enqueues its adjacent vertices, and then continues visiting the vertices in the order they were enqueued.
BFS is typically implemented using a while loop or a queue.
BFS guarantees that it visits all the vertices at the same level before moving to the next level.
It is commonly used for finding the shortest path, minimum spanning trees, or level-order traversals.
DFS (Depth-First Search):

### DFS

* DFS explores a graph by traversing as far as possible along each branch before backtracking.
It uses a stack data structure (or recursion) to keep track of the vertices to visit.
The algorithm starts by visiting the initial vertex, pushes its adjacent vertices onto the stack, and then continues visiting the vertices by recursively exploring each adjacent vertex.
DFS explores the deepest vertices first before backtracking to visit other vertices.
It is typically implemented using recursion or an explicit stack data structure.
DFS is useful for tasks such as searching for connected components, topological sorting, detecting cycles, or finding paths in a graph.


### In-order vs Pre-order traversal

* Tree traversal is a process of visiting (checking or updating) each node in a tree data structure, exactly once. It's a key task that can be performed on trees and has vast utility in numerous algorithms.

* There are three common ways to traverse a binary tree:

In-order

Pre-order

Post-order

### Pre-order Traversal: In a pre-order traversal, the node's value is accessed first, then its left and right children are accessed, in that order. The procedure is as follows:

Visit the root node.
Traverse the left subtree by recursively calling the pre-order function.
Traverse the right subtree by recursively calling the pre-order function.
In other words, in pre-order traversal, the root node is visited first, then the left subtree, and finally the right subtree.

### In-order Traversal: In an in-order traversal, the left subtree is accessed first, then the node's value, and then the right subtree. The procedure is as follows:

Traverse the left subtree by recursively calling the in-order function.
Visit the root node.
Traverse the right subtree by recursively calling the in-order function.
In other words, in in-order traversal, the left subtree is visited first, then the root node, and finally the right subtree.