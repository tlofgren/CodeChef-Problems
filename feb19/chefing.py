from collections import defaultdict

answers = []
t = int(input())
while t > 0:
    chars = defaultdict(int)
    n = int(input())
    for i in range(n):
        s = input()
        s_set = set(s)
        for c in s_set:
            chars[c] += 1
    answer = 0
    for k, v in chars.items():
        if v >= n:
            answer += 1
    answers.append(answer)
    t -= 1
for a in answers:
    print(a)

