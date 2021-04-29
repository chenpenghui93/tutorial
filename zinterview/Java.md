### 基础 Basic
- 如何理解面向对象思想  
  - 一切皆对象，对象有属性和方法，通过操纵对象的方法改变对象的属性来实现想要的结果  
- `equals()`与 `==`的区别  
  - 默认情况下，从Object继承的`equals()`与`==`是完全等价的，二者比较的都是对象的内存地址
  - 可以重写业务对象的`equals()`，使其按照需要的方式进行比较，这种时候`equals()`一般比较的就是对象的内容，而不是对象的内存地址了  

### 集合类 Collection
- ArrayList 底层使用 定长数组 实现，允许空值和重复元素
- LinkedList 底层使用 双向链表 实现，允许空值和重复值
- Vector 数组 Synchronized保证线程安全
- CopyOnWriteArrayList 数组 线程安全的ArrayList Synchronized修饰方法 对读不加锁、对写加锁
- HashMap 底层使用 数组+链表+红黑树(jdk1.8+) 实现
- LinkedHashMap 


### 输入/输出 I/O

### 异常 Exception

### 类加载 ClassLoader

### 并发与多线程 Thread

### 虚拟机 JVM