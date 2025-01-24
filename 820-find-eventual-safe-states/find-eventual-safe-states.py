class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:

        already_checked = {}

        def is_cycle(i, visited):
            # print(i, visited)
            if i in already_checked:
                return already_checked[i]
            
            if i in visited:
                already_checked[i] = True
                return True
            else:
                visited.add(i)

            # where can i go
            for child in graph[i]:
                res = is_cycle(child, visited)
                if res:
                    return True
                
            already_checked[i] = False
            return False
        res = []
        for i in range(len(graph)):
            if not is_cycle(i, set()):
                res.append(i)
        return res
        
        