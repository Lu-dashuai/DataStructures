# 20200516 14:30 稀疏数组

- 写完稀疏数组后感觉还可以，用稀疏数组实现了五子棋的棋盘。
- [稀疏数组 笔记](https://lu-dashuai.github.io/posts/blogs/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95__%E7%A8%80%E7%96%8F%E6%95%B0%E7%BB%84/)
- [枚举 笔记](https://lu-dashuai.github.io/posts/blogs/java%E5%9F%BA%E7%A1%80__%E6%9E%9A%E4%B8%BE/)
---

# 20200518 1:10 数组实现队列
- [顺序队列 笔记](https://lu-dashuai.github.io/posts/blogs/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95__%E6%95%B0%E7%BB%84%E5%AE%9E%E7%8E%B0%E9%A1%BA%E5%BA%8F%E9%98%9F%E5%88%97/)
- 我是不是不太适合看数据结构，稍微动点逻辑的脑子就开始晕蛋，操！！！还是得坚持，数据结构和算法，今年8月前无论如何得看完老师的视频！！！！上班看下班看，写写！！！
自己没有一个大的方向，学别人买了一本算法第四版，发现自己根本静不下心来看书，真是操了，看视频也没有耐心，不知道为啥，现在是凌晨0：49
分心态突如其来的崩溃...今晚得把循环数组搞懂，写到凌晨两点都不算什么，奥里给....
忘了不是循环数组，自己由于眼高手低漏了一个数组循环队列，先搞这个把...
明天写笔记，凌晨了....明天还要爬起来上班...
---

# 20200528 15:04 数组实现环形队列
- [循环队列 笔记](https://lu-dashuai.github.io/posts/blogs/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95__%E6%95%B0%E7%BB%84%E5%AE%9E%E7%8E%B0%E7%8E%AF%E5%BD%A2%E9%98%9F%E5%88%97/)
- 给爷整笑了
- 几个重点
1. 判断队列空：food = head
2. 判断队列满：(food + 1) % size == head --> 给尾加一后对长度取模，就得到下一次的添加的位置...
3. 头和尾的添加删除的下一个坐标：(food + 1) % size 考虑取模
4. 队列的有效长度：(food - head + size) % size ---> 得到尾和头的差值 其实就是获得了长度，加长度考虑取模
5. 展示当前队列 中 i % size


# 20200529 凌晨1.49
- 完成单链表简单添加，顺序添加，遍历，不知道是不是因为写了一点数据结构，现在写起来这个感觉思路通畅了很多，嘿嘿，自我感动中...
- 明天白天完成 更改和删除 + blog 【√】
- 完成gradle 笔记一篇
- 看一些mybatis-plus视频