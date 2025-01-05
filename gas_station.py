gas = [2, 3, 4, 5]
cost = [1, 4, 3, 2]

def check_route(gas, cost):
    n = len(gas)
    for i in range(n):
        ind = i
        tank = 0
        steps = 0
        while steps < n:
            tank += gas[ind]
            tank -= cost[ind]
            if tank < 0:
                break
            ind = (ind + 1) % n
            steps += 1
        if steps == n and tank >= 0:
            print(i)
            return
    print(-1)

check_route(gas, cost)
