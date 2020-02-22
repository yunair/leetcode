# 回朔

## 模版

路径： 记录已经做过的选择
选择列表： 当前可以作出的选择
``` python
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        # 做选择
        选择列表.remove(选择)
        路径.add(选择)

        backtrack(路径, 选择列表)

        # 撤销选择
        路径.remove(选择)
        选择列表.add(选择)

```