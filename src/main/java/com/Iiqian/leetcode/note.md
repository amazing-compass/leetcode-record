# 刷题Tips

## 1. 数据类型溢出处理

在数据范围可能超过int的情况下，需要注意以下情况：

```java
long a = (1+num)*num/2;

// 虽然这里标注了a为long类型，但因为num是int类型
// 计算的过程不会自动将结果转换为long类型
// 需要我们显式地将某些操作数强制转换为long类型

long a = (1L+num)*num/2;

// 同样在后面默认int的情况下发生int类型溢出的时候，我们也需要显式转换为long类型
long result = (long)target*n+(long)n*(n-1)/2;
// 这里将target和n都显式转换为long类型，确保表达式的计算都是以long类型进行，而避免int溢出问题
```

## 2. 二叉搜索树

指一棵空树或者具有下列性质的二叉树：

1. 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值
2. 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值
3. 任意节点的左、右子树也分别为二叉查找树

## 3. Java String类的使用

```java
// String的分割
String[] words = title.split(" ");
// String转化为小写/大写
String.toLowerCase();
// 返回字符串的子串
String.substring(int beginIndex);
String.substring(int beginIndex,int endIndex);
// 返回指定字符在字符串中第一次出现的索引
String.indexOf(String str);
// 返回从fromIndex开始查找指定字符串中第一次出现的索引
String.indexOf(String str, int fromIndex);
```

## 4. 字符串比较

String中`==`比较引用地址是否相同，`equals()`比较字符串的内容是否相同。

## 5. 字符串空格处理

因为字符串两个单词中间可能有多个空格，如果只是简单使用`String.split(" ")`，连续出现的空格会导致生成的字符串存在空字符串元素。可以使用以下正则表达式：

```java
String[] ss = s.trim().split("\\s+");   
```

## 6. String常用操作

```java
// split() 方法用于将字符串分割成子字符串数组
String[] ss = s.trim().split("\\s+");   

// reverse - 使用StringBuffer来进行反转
String reverse = new StringBuffer(string).reverse().toString();

// 数组反转可以使用Collections
List<String> wordList = Arrays.asList(s.split("\\s+"));
Collections.reverse(wordList);

// join() - 将字符串数组连接起来
String s = String.join(", ", fruits);    // fruits是一个字符串数组
```

## 7. 大小写转换

```java
String.toUpperCase();
String.toLowerCase();
```

## 8. 矩阵遍历技巧

在矩阵中遍历格子周围的格子时，可以用如下方式处理边界：

```java
int[] neighbors = {0, 1, -1};

for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
            int r = (row + neighbors[i]);
            int c = (col + neighbors[j]);

            // 查看相邻的细胞是否是活细胞
            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                liveNeighbors += 1;
            }
        }
    }
}
```

## 9. HashMap使用提示

对于状态有限的情况（如26个字母），用数组存储效率更高。

## 10. 容斥原理

- 奇数个集合交集前面是加号
- 偶数个集合交集前面是减号

## 11. 动态数组转固定数组

```java
List<Integer> merged = new ArrayList<>();
// list.add() 操作...
merged.toArray(new int[merged.size()]);
```

## 12. 二维数组排序

```java
// 推荐使用Lambda表达式
Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

// 传统方式（不推荐）
Arrays.sort(intervals, new Comparator<int[]>() {
    public int compare(int[] interval1, int[] interval2) {
        return interval1[0] - interval2[0];
    }
});
```

## 13. 双端队列使用

```java
deque.addLast(E e);      // 添加元素到队尾
deque.removeLast();      // 取队尾元素并删除
deque.addFirst(E e);     // 添加元素到队首
deque.removeFirst();     // 取队首元素并删除
deque.getLast();         // 取队尾元素
deque.getFirst();        // 取队首元素
```

## 14. HashMap配对模式

```java
Map<Character, Character> pairs = new HashMap<Character, Character>() {{
    put(')', '(');
    put(']', '[');
    put('}', '{');
}};
```

## 15. 类型转换

```java
// String → int
Integer.parseInt(str);
// int → String
String.valueOf(int a);
// char → int
int num = c - '0';
```

## 16. 链表合并技巧

```java
// 合并后l1和l2最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表
prev.next = l1 == null ? l2 : l1;
```

## 17. 链表索引处理

- 对于需要具体index的情况，可以使用HashMap存储
- 对于和头尾结点有数字关系的结点（如倒数第k个），使用快慢指针更优

## 18. while循环优化

在Java中使用`&&`时要注意短路求值机制：

- 第一个条件为`false`时，不会计算第二个条件
- 只有第一个条件为`true`时，才会判断第二个条件

## 19. 二叉搜索树特性

二叉搜索树的中序遍历是递增序列，可以通过递归或栈实现。

## 20. 包装类使用技巧

```java
Integer a = null;  // 将a初始化为null，可与测试数据区分
```

## 21. 模运算处理

```java
if (i > limit) {
    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1] - dp[i - limit - 1][j][1];
} else {
    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
}
dp[i][j][0] = (dp[i][j][0] % mod + mod) % mod;
```

## 22. 整数二进制处理

```java
// 需要先将int[]转为Integer[]
Integer[] arr = new Integer[]{nums[0], nums[1], nums[2]};

// 二进制操作
Integer.numberOfLeadingZeros(a);   // 求整数a的二进制前导零数量
int lenA = 32 - Integer.numberOfLeadingZeros(a);   // 求整数a的二进制位数

// 二进制拼接
int ba = b << lenA | a;   // 二进制字符串拼接结果
```

## 23. Lambda表达式排序

```java
Arrays.sort(nums, (a,b) -> a-b);  // 升序排列
```

## 24. 邻接表构造图

```java
List<List<Integer>> graph = new ArrayList<>();
for(int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}

// 构建邻接表
for (int[] invocation : invocations) {
    graph.get(invocation[0]).add(invocation[1]);
}
```

## 25.对于二分查找的算法，要坚持的是区间的不变性，当然我可以先尝试所有的区间都是左闭右闭

以下讨论针对左闭右闭区间

```java
while(l <= r){
            mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
```

显然开头的 while( l <= r) 这里的l = r 在一个左闭右闭区间上是可以成立的，所以这里是l <= r 而不是l < r

至于后面为什么是l = mid + 1 和 r = mid -1, 也是因为左闭右闭的关系，mid 显然已经不是target 能取到的值，直接剔除即可。

之后写二分查找直接使用左闭右闭尝试即可，如果有问题再来修改此次笔记

## 26.条件判断中的&& 前面不符合要求，后面就不会计算  一定要注意哪个是前提条件

```java
while(pointer != nums.length - 1 && Math.abs(nums[pointer]) >= Math.abs(nums[pointer+1])){         //如代码所示，pointer != nums.length       优先级明显更高
            pointer++;
        }  
```
