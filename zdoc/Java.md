# 基础 Basic
- 如何理解面向对象思想  
  - 一切皆对象，对象有属性和方法，通过操纵对象的方法改变对象的属性来实现想要的结果  
- 抽象类和接口的区别
  - 设计层面
    - 抽象类是对类的抽象，是一种模板设计；接口是对行为的抽象，是一种行为规范
  - 语法层面
    - 抽象类可以有默认的方法实现，接口不存在方法实现(jdk1.8之前)
    - 抽象类使用extends关键字继承，如果子类不是抽象类需要提供全部实现；接口使用implements关键字实现，提供接口中所有声明方法的实现
    - 抽象类可以有构造器，接口不能有构造器
    - 抽象方法可以用public/protected/default修饰符，接口默认且仅能使用public修饰符
- 基础类型
  - 字符型
    - char 2byte
  - 整型
    - byte 1byte
    - short 2byte
    - int 4byte
    - long 8byte
  - 浮点型
    - float 4byte
    - double 8byte
  - 布尔型
    - boolean 1byte
- `equals()`与 `==`的区别  
  - 默认情况下，从Object继承的`equals()`与`==`是完全等价的，二者比较的都是对象的内存地址
  - 可以重写业务对象的`equals()`，使其按照需要的方式进行比较，这种时候`equals()`一般比较的就是对象的内容，而不是对象的内存地址了  
- String、StringBuilder、StringBuffer的异同
  - 都可以用来操作字符串
  - 操作少量字符串可以使用String
  - 单线程操作大量字符串使用StringBuilder
  - 多线程操作大量字符串使用StringBuffer
- 关键字作用
  - static
    - 修饰代码块表示静态代码块
    - 修饰成员变量表示全局静态成员变量
    - 修饰方法表示静态方法
  - final
    - 可以修饰类、方法、变量
    - 被final修饰的类不能被继承，即不能拥有子类
    - 被final修饰的方法不能被重写
    - 被final修饰的类属性、对象属性、形参、局部变量，都需要进行初始化操作
  - synchronized
    - 修饰方法表示同步方法
    - 修饰代码块表示同步语句块
  - volatile
    - 多线程之间的可见性
    - 禁止指令重排序
  - transient
    - 修饰的成员属性变量不被序列化
- String类为什么是final的
  - 实现字符串池 字符串池的实现可以在运行时节约很多堆空间，因为不同的字符串变量可以指向池中的同一个字符串
  - 线程安全 因为字符串不可变，所以是多线程安全的，同一个字符串实例可以被多个线程共享
  - HashCode不可变 因为字符串不可变，所以在创建它的时候HashCode就被缓存了，不需要重新计算，效率更高
- Reflection 反射
  - Class.forName与ClassLoader的区别
    - 都可以对类进行加载
    - Class.forName除了将类的.class文件加载到jvm中以外，还会对类进行解释，执行类中的static代码块
    - ClassLoader只会将.class文件加载到jvm中，不会执行static中的内容，在newInstance时才会执行static代码块

## 集合类 Collection
- List、Set、Queue继承自Collection(单个元素的集合)，Map(键值对的集合)继承自Object
- List主要特性是有序性和元素可控性，主要实现类有ArrayList/LinkedList
  - ArrayList 底层使用数组实现；查询快，增删慢；允许空值和重复元素
  - LinkedList 底层使用双向链表实现；查询慢，增删快；允许空值和重复值
  - Vector 底层使用数组实现，Synchronized保证线程安全
  - CopyOnWriteArrayList 底层使用数组实现，线程安全的ArrayList，Synchronized修饰方法，对读不加锁、对写加锁
- Set主要特性是唯一性，主要实现类有HashSet/LinkedHashSet/TreeSet
  - HashSet 为快速查找元素而设计，存入HashSet的元素必须定义HashCode方法；可以理解为HashMap的包装类
  - LinkedHashSet 具备HashSet的查找速度且通过链表保证了元素的插入顺序，迭代时是有序的，存入元素必须定义HashCode方法
  - TreeSet 底层使用红黑树实现，实质是TreeMap的包装类，元素不可为mull；存入TreeSet的元素必须是实现Comparable接口
- Queue主要特性就是队列，主要实现类为LinkedList/PriorityQueue
  - Dequeue是Queue的子接口，通用的双端队列，有明确的在头或尾进行查看、添加或删除的方法
  - 非阻塞队列
    - LinkedList 保证了按照元素的插入顺序进行操作
    - PriorityQueue 按照优先级进行插入读取操作，元素可以通过实现Comparable接口来保证优先顺序
    - ConcurrentLinkedQueue 底层使用链表实现，线程安全
    - ArrayDequeue 底层使用循环数组实现，效率更高些
  - 阻塞队列 线程阻塞时不是直接添加或删除元素，而是等到有空间或者元素时才进行操作
    - ArrayBlockingQueue 基于数组的有界队列
    - LinkedBlockingQueue 基于链表的无界队列
    - PriorityBlockingQueue 基于优先级的无界队列
    - DelayQueue 基于时间优先级的无界队列
    - SynchronousQueue 内部没有容器的队列，独有的线程-配对通信机制
- Map主要特性是维护键值对关联和查找特性，主要实现类有Hashtable/HashMap/LinkedHashMap/TreeMap
  - Hashtable 类似HashMap，键值均不允许为null，线程安全
  - HashMap 
    - 底层使用 数组+链表+红黑树(jdk1.8+) 实现；只能出现一个key为null，可以出现多个value为null；线程不安全
    - 为什么链表长度大于8会转为红黑树
      - 链表取数需要遍历，时间复杂度为O(n)；红黑树时间复杂度为O(logN)
      - 树节点的大小是链表节点大小的两倍，所以容器中包含足够的节点保证使用才用它
      - 为什么是8而不是9、10——基于统计的结果
    - 为什么是2倍扩容
      - 存储位置计算式`(n-1)&hash(key)`，位运算是可以充分散列，避免不必要的哈希冲突
      - 扩容后，元素要么在原位置，要么在原位置再移动2次幂的位置，且链表顺序不变
   - LinkedHashMap 类似HashMap，键值均可以为null；有序性为插入顺序或LRU次序(Last Recently Use, 最近最少使用)，
                   有序是因为每个元素还倍加入到了一个双向链表中
  - TreeMap 底层使用红黑树实现，查看键值对时会被排序，存入的元素必须实现Comparable接口，键不允许为null，值可以为null；
            如果键为枚举类型，可以使用专门的EnumMap


## 输入/输出 I/O

## 异常 Exception

## 类加载 ClassLoader

# 并发与多线程 Thread

# 虚拟机 JVM
- 性能调优监控工具
  - jps 查看所有的JVM进程，包括进程ID、进程启动路径
  - jstack 观察JVM中当前所有线程的运行情况和线程当前状态
  - jstat 利用JVM内建的指令对Java应用程序的资源和性能进行实时的命令行的监控，包括进程classloader/compiler/gc
  - jmap 观察进程运行中的JVM物理内存的占用情况，该进程内所有对象的情况
  - jinfo 观察进程运行环境参数，包括Java System属性和JVM命令行参数
  - hprof 观察CPU使用率，统计堆内存的使用情况


## 内存结构
- 易混淆概念
  - JVM内存结构，与Java虚拟机的运行时区域有关，方法区、堆、虚拟机栈、本地方法栈、程序计数器
  - Java内存模型，与Java的并发编程有关，多线程间的通信通过共享变量实现，每个线程在本地缓存一份共享变量的副本
  - Java对象模型，与Java对象在虚拟机中的表现形式有关

## 垃圾回收 GC  https://blog.csdn.net/justloveyou_/article/details/71216049
- Java中自动内存管理解决的问题
 - 给对象分配内存，回收分配给对象的内存；针对的内存区域是Java内存模型中的堆区
   - 哪些内存要回收
   - 什么时候回收
   - 如何回收
- 为什么要使用垃圾回收
  - 防止内存泄漏，保证内存的有效使用
- 如何确定对象是否可以被回收
  - 引用计数算法，任何引用计数为0的对象实例可以被当作垃圾收集——无法解决循环引用问题
  - 可达性分析算法，通过判断对象的引用链是否可达来决定对象是否可以被回收
    - 虚拟机栈(栈帧中的局部变量表)中引用的对象
    - 方法区中类静态属性引用的对象
    - 方法区中常量引用的对象
    - 本地方法栈中native方法引用的对象
- 标记-清除算法
  - 首先从根集合进行扫描，对存活的对象进行标记，标记完毕后，再扫描整个空间中未被标记的对象并进行回收
  - 标记和清除两个过程效率都不高
  - 不需要进行对象的移动，仅对不存活的对象进行处理，因此也会产生大量不连续的内存碎片
- 复制算法
  - 将可用内存按容量划分为大小相等的两块，每次只使用其中一块；当这一块的内存用完了，就将还存活着的对象复制到另一块上，然后再把已使用过的内存空间一次性清理掉
  - 适用于对象存活率低的场景，如 新生代
- 标记-整理算法
  - 标记-整理算法的标记过程类似标记-清除算法，但后续步骤不是直接对可回收对象直接进行清理，而是让所有存活的对象向一端移动，然后清理掉端边界以外的内存，类似于磁盘整理的过程
  - 适用于对象存活率高的场景，如 老年代
- 分代收集算法
  - 不同对象的生命周期(存活情况)是不一样的，而不同生命周期的对象位于堆中不同的区域，因此堆内存对不同的区域采用不同的策略进行回收以提高JVM的执行效率
  - 堆内存区域划分
    - 新生代
      - 新生代的目标就是尽可能快速地收集掉那些生命周期短的对象，一般情况下，所有新生成的对象都是存放在新生代中
      - Eden→Survivor0;
      - Eden+Survivor0→Survivor1,交换Survivor0/Survivor1
      - 新生代→老年代
      - FullGC，回收新生代、老年代
    - 老年代
      - 老年代中存放的都是生命周期较长的对象；内存比例老年代大约为新生代的两倍
    - 永久代
      - 主要用于存放静态文件，如Java类、方法等。永久代对垃圾回收没有显著影响，但使用反射、动态代理、CGLib等方式时，
        需要设置一个比较大的永久代内存空间来存放这些运行过程中新增的类
- 垃圾回收有两种类型
  - Minor GC,对新生代进行回收，不会影响老年代
  - Full GC(Major GC),对整个堆进行回收，包括新生代和老年代。导致发生Full GC的原因包括：老年代被写满、永久代被写满、System.gc()被显示调用等
  
- 垃圾收集器
  - Serial 
  - Serial Old
  - ParNew
  - Parallel Scavenge 
  - Parallel Old
  - Concurrent Mark Sweep,CMS
  - Garbage First,G1
  
- 内存分配与回收策略
  - 一般而言，对象主要分配在新生代的Eden区上，如果启动了本地线程分配缓存(TLAB)，将按线程优先在TLAB上分配。少数情况下也可能直接分配在老年代中。
    总的来说，内存分配规则并不是一层不变的，其细节取决于当前使用的是哪一种垃圾收集器组合，还有虚拟机中与内存相关的参数的设置
  - 1.对象优先在Eden分配，当Eden区没有足够空间进行分配时，虚拟机将发起一次MinorGC
  - 2.大对象直接进入老年代
  - 3.长期存活的对象将进入老年代
  - 4.动态对象年龄判定
  
- 内存泄漏的可能情况
  - 例如HashMap、Vector等集合类的静态使用
  - 各种资源连接包括数据库连接、网络连接、IO连接等没有显式调用close关闭，不被GC回收导致内存泄漏
  - 监听器的使用，在释放对象的时候没有对应删除监听器
  
- 引用类型 `示例 https://www.jianshu.com/p/e5364c05cc80`
  - 强引用 "Object obj = new Object()" 只要强引用还存在，垃圾收集器就永远不会回收掉被引用的对象
  - 软引用 有用但非必须的对象。通过SoftwareReference实现软引用
  - 弱引用 非必需对象，强度比软引用更弱一些。通过WeakReference实现弱引用
  - 虚引用 最弱的引用关系。通过PhantomReference实现虚引用
  
# 开发规范
## 避免潜在的空指针异常
- 比较判断时避免被比较的对象为空，可通过 使用常量执行equals方法、操作前先判空、使用Objects.equals()等方式来解决   
- 判空时使用工具类提供的判空工具，推荐使用Apache Commons提供的StringUtils、CollectionUtils、MapUtils(代码统一)  
- pojo中禁止使用基本数据类型，必须使用包装类  
  数据库的查询结果可能为null，因为自动拆箱，用基本数据类型接收有空指针风险  
- 使用集合的addAll()方法时，必须对传入的list进行判空  
  该方法实现时直接调用传入的List的toArray()方法，若传入的值为空，必然会导致空指针异常
## 尽量避免代码合并冲突
- pojo使用lombok
- 类新增方法时，新增的public方法加到public方法的最后、private方法前；新增的private方法放到整个类最后
## 防止功能失效
- 基于注解的声明式事务在本类调用时，不可直接调用  
- 基于注解的声明式事务，指定rollbackFor = Exception.class
## 数值精度问题
- 使用BigDecimal时，禁止使用double类型的构造方法，使用String类型的构造方法，或使用valueOf()方法  
- BigDecimal类型的值进行比较时，不可使用equals()方法，必须使用compareTo()方法  
- pojo中的数据类型要与数据库中一致
- 小心数值溢出  
  精确到毫秒的时间数值常量，大部分情况下都是和Long类型的时间戳作对比的，所以请直接定义为Long，不要定义为Integer;
  使用常量时，也应当小心这样潜在的坑，用之前先点进去看看到底是什么类型的常量，如果是Integer，就用Long类型的去乘它  
- 严格禁止用==比较Integer  
  如果最开始的时候比较的两个值在-128~127之内，但随着系统运行数值逐渐扩大，就会出现最开始运行的好好的，跑一段时间之后出现问题的情况
## 避免其他人使用时的潜在风险
- 枚举禁止写Setter，防止其他人误调用Setter方法导致不可预期的问题  
- 将泛型写出来，其他人无须看代码也可清晰的知道返回的究竟是什么值  
- Getter/Setter中禁止增加对请求值/返回值做修改的逻辑处理，避免其他人调用时不知道该Getter/Setter并不是单纯的设置/返回值  
  如确有必要在pojo中进行逻辑处理，请写一个单独的Getter/Setter，而不可覆盖现有的Getter/Setter方法
- 禁止返回Collections.emptyList()/Collections.EMPTY_LIST/Collections.singletonList()/Collections.emptyMap()/Collections.EMPTY_MAP
  返回的是不可变的List，调用方很可能不知道它是不可变的List，一旦进行增/删/改元素操作，便会导致UnsupportedOperationException  
- 禁止返回Arrays.asList()，避免调用方调用后增/删/改元素  
  Arrays.asList()返回的是不可变的List，调用方很可能不知道它是不可变的List，一旦进行增/删/改元素操作，便会导致UnsupportedOperationException
## 避免调用时新旧版本不兼容
- 提供RPC服务或HTTP接口时，入参必须为pojo  
- 若提供RPC服务或HTTP接口的入参不为pojo，增加入参时必须保留原入参的方法
## 性能
- 事务中不可执行网络请求  
  网络请求的响应时间不可预估，若该次网络请求耗时过长，将导致执行时间过长的大事务，严重影响数据库性能  
- 调用其他系统时进行同步数据等不关心结果的操作时，采取异步调用  
- 循环体中做字符串拼接时，禁止直接进行String的+操作，必须使用StringBuilder/StringBuffer  
  循环体的循环次数未知，若循环次数过大，则每次+操作都生成一个新的String，对内存消耗极大；如果是简单的拼接场景，例如2、3个固定字符串的拼接，
  直接用+操作也无妨——编译器会将可以确定值的字符串拼接自己优化为StringBuilder的 
- 使用StringBuilder/StringBuffer时，禁止使用其默认构造方法
  StringBuilder/StringBuffer的默认构造方法创建大小为16的char数组，这个大小很可能不满足实际情况，造成在第一次append时就出现扩容，平白浪费内存资；
  若在初始化时能知晓其第一个字符串，则使用String类型的构造方法，此时char数组的大小为构造方法中传入的String大小+16；
  若在初始化时无法知晓其第一个字符串，则使用int类型的构造方法，指定合理的初始char数组大小
- 遍历Map时，若要获取value，则使用entrySet()而非keySet()  
## 代码风格
- 禁止使用无意义的魔数，必须定义常量/枚举
  若数值发生修改，不定义常量/枚举，则很可能漏了修改一些位置  
- 强制类型转换时，必须instanceof，避免ClassCastException  
- 库存消耗等场景，数值判断不要使用==0来做判断，避免因为并发原因导致值小于0  
- 禁止吞异常，即catch住异常之后什么也不做  
- JSON序列化、反序列化使用FastJson
  如果项目中混用FastJson和Jackson（其实还有用Gson的），由于这些工具在一些特殊注解上存在差异，一旦交叉使用，自定义注解也必须使用两套
- if/else等语句即使只有一行也不能省略{}
  如果省略{}，一旦后续需要增加新的逻辑变为多行，就存在忘了再加上{}的可能，所以要在最开始就把{}加上，即使{}里只有一行  
- 不要使用HttpURLConnection
  HttpURLConnection采用流的方式读取远程数据，网络波动时存在读取不完整的可能。将费率表从oss中读取时出现过该问题，使用HttpURLConnection读取到的json文件不完整，导致系统启动失败
  建议使用第三方工具类，如Apache HttpClient，提供的功能比HttpURLConnection更多，用起来也更方便
## 日志
- 打印日志时，打印的对象需要存在有意义的toString()方法  
  若打印的对象未重写toString()方法，直接使用Object类的toString()方法打印内存地址，则该日志打印毫无意义
- 打印日志时，{}占位符数量要和参数数量匹配  
  推荐打印日志格式`log.info(LOG_NAME + "任务未完成，校验文件不存在, taskId:[{}], taskName:[{}]", id, taskName);`  