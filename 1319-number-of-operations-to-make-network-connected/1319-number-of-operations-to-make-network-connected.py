class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if(len(connections) < n-1 ):
            return -1 
        need = 0
        visited = [False]*(n)
        graph = {i:[] for i in range(n)}
        for a,b in connections:
            graph[a].append(b)
            graph[b].append(a)
        for i in range(0,n):
            if not visited[i]:
                need += 1
                self.dfs(graph,i,visited)
        return need-1

    def dfs(self,graph,i,visited):
        visited[i] = True
        for j in graph[i]:
            if not visited[j]:
                self.dfs(graph,j,visited);
        return;
