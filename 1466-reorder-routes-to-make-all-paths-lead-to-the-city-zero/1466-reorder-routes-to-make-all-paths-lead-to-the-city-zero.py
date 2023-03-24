class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        graph={i:[] for i in range(n)}
        for a,b in connections:
            graph[a].append((b,False))
            graph[b].append((a,True))
        return self.bfs(graph,n)
    def bfs(self,graph,n):
        result = 0
        is_visited =[False]*n
        q = deque([0])
        while q:
            node = q.pop()
            for x,is_forward in graph[node]:
                if not is_visited[x]:
                    if is_forward:
                        q.append(x)
                    else:
                        result+=1
                        q.append(x)
            is_visited[node] = True
        return result