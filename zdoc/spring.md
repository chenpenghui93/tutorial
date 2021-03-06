
### 事务
 - IOC & AOP  
 - Spring的七种事务传播行为  
   - Propagation.REQUIRED, 支持当前事务，如果没有事务会创建一个新的事务     
   - Propagation.SUPPORTS,  支持当前事务，如果没有事务的话以非事务方式执行  
   - Propagation.MANDATORY, 支持当前事务，如果没有事务抛出异常  
   - Propagation.REQUIRES_NEW, 创建一个新的事物并挂起当前事务  
   - Propagation.NOT_SUPPORTED, 以非事务执行，如果当前有事务，则将当前事务挂起    
   - Propagation.NEVER, 以非事务执行，如果存在事务，则抛出异常   
   - Propagation.NESTED, 如果当前存在事务，则嵌套事务内执行，如果当前没有事务，则进行REQUIRED  
 - 事务的四个特性 
   - 原子性(Atomicity), 事务是数据库逻辑工作单元，事务中包含的操作要么都执行成功，要么都执行失败  
   - 一致性(Consistency), 事务执行的结果必须是使数据库数据从一个一致性状态变到另外一种一致性状态。当事务执行成功后就说数据库处于一致性状态。如果在执行过程中发生错误，这些未完成事务对数据库所做的修改有一部分已写入物理数据库，这是数据库就处于不一致状态  
   - 隔离性(Isolation), 一个事务的执行过程中不能影响到其他事务的执行，即一个事务内部的操作及使用的数据对其他事务是隔离的，并发执行各个事务之间无不干扰  
   - 持续性(Durability), 即一个事务执一旦提交，它对数据库数据的改变是永久性的。之后的其它操作不应该对其执行结果有任何影响  