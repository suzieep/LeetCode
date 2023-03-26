class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        visited=set()
        ranks=[1e9]*len(edges)
        return max(self.re(i,0,visited,edges,ranks) for i in range(len(edges)))
    def re(self,i,rank,visited,edges,ranks):
        if i in visited or edges[i]==-1: return -1
        if ranks[i]<rank: return rank-ranks[i]
        ranks[i]=rank 
        result = self.re(edges[i],rank+1,visited,edges,ranks)
        visited.add(i)
        return result

    