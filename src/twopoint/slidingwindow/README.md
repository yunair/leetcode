## 滑动窗口
## 模版

~~~ java
// 在 s 中寻找 t 的「最小覆盖子串」
int left = 0, right = 0;
string res = s;

while(right < s.size()) {
    window.add(s[right]);
    right++;
    // 如果符合要求，移动 left 缩小窗口
    while (window 符合要求) {
        // 如果这个窗口的子串更短，则更新 res
        res = minLen(res, window);
        window.remove(s[left]);
        left++;
    }
}
return res;
~~

### 基本套路

~~~ java
val needs = mutableMapOf<Char, Int>()
for (c in s1) {
    needs[c] = needs.getOrDefault(c, 0) + 1
}
val window = mutableMapOf<Char, Int>()
var left = 0
var right = 0
var match = 0
while (right < s2.length) {
    val c1 = s2[right]
    right++
    if (!needs.containsKey(c1)) {
        continue
    }
    window[c1] = window.getOrDefault(c1, 0) + 1
    if (window[c1] == needs[c1]) {
        match++
    }
    while (match == needs.size) {
        // 处理条件

        val c2 = s2[left]
        if (needs.containsKey(c2)) {
            window[c2] = window.getOrDefault(c2, 0) - 1
            if (window[c2]!! < needs[c2]!!) {
                match--
            }
        }
        left++
    }

}
~~~