class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        graph = defaultdict(list)
        q = deque([1])
        visited = set([1])
        result = 1e9
        for a, b, d in roads:
            graph[a].append((b, d))
            graph[b].append((a, d))
        while q:
            node = q.popleft()
            for nn, d in graph[node]:
                result = min(result, d)
                if nn not in visited:
                    q.append(nn)
                    visited.add(nn)    
        return result