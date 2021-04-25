-----------------create database begin-------------------------------
-- 查询表空间路径
select tablespace_name, file_id, bytes / 1024 / 1024, file_name from dba_data_files order by file_id;
-- 创建表空间(注意修改datafile路径及名称)
create tablespace [namespace] datafile '/u01/oradata/PGDEVDB/uaadev01.dbf' size 5120 M;
-- 创建用户并默认表空间
create user [username] identified by [password] default tablespace [namespace];
-- 给用户权限
grant connect to [username];
grant resource to [username];
grant select_catalog_role to [username];
grant create any sequence to [username];
grant create any table to [username];
grant create any view to [username];
grant create table to [username];
grant create tablespace to [username];
grant create view to [username];
grant delete any table to [username];
grant execute any procedure to [username];
grant insert any table to [username];
grant select any dictionary to [username];
grant select any table to [username];
grant unlimited tablespace to [username];
grant update any table to [username];
grant debug connect session to [username];
-----------------create database end-------------------------------


-----------------unlock table begin-------------------------------
-- 查看被锁表
select b.owner, b.object_name, a.session_id, a.locked_mode
from v$locked_object a, dba_objects b where b.object_id = a.object_id;
-- 查看被锁表的‘sid、serial’
select b.username, b.sid, b.serial#, logon_time
from v$locked_object a, v$session b
where a.session_id = b.sid order by b.logon_time;
-- 参数‘sid,serial’
alter system kill session '547,36734';
-----------------unlock table end---------------------------------


-----------------rollback data begin------------------------------
-- 查询sql执行历史，确定回滚时间点
select sql_text,last_load_time from v$sql where sql_text like '%update%' order by last_load_time desc;
-- 将数据回滚至指定时间点
alter table tableName enable row movement;
flashback table tableName to timestamp to_timestamp('2021-03-02 09:30:00', 'yyyy-mm-dd hh24:mi:ss');
-- 恢复误删的表
flashback table tableName to before;
-----------------rollback data end--------------------------------


-----------------hierarchy query begin----------------------------
-- 查询当前级别所有父级(指定子级，父级=子级)
select t.MENU_CODE,t.PARENT_CODE from SYS_MENU t
start with t.MENU_CODE = 'release' connect by prior t.PARENT_CODE = t.MENU_CODE;
-- 查询所有子级(指定父级，子级=父级)
select t.MENU_CODE,t.PARENT_CODE from SYS_MENU t
start with t.MENU_CODE = 'gateway' connect by prior t.MENU_CODE = t.PARENT_CODE;
-----------------hierarchy query end--------------------------------


-----------------oracle loop example start---------------------------------
declare
    balance_Id   varchar2(100); -- 声明变量
    balance_Name varchar2(100); -- 声明变量
    conNum       number; -- 声明变量
begin
    -- 循环查询结果集
    for item in (select A.BALANCE_ID, A.BALANCE_NAME from VIEW_GZ_YIMIAO A group by A.BALANCE_ID, A.BALANCE_NAME)
        loop
            -- 将结果数据赋值给变量
            balance_Id := item.balance_id;
            balance_Name := item.balance_name;
            -- 查询结果集赋值
            select COUNT(*) into conNum from Dxc_Consignor where NAME = balance_Name;
            -- 执行判断逻辑
            if conNum = 1 then
                dbms_output.put_line('存在');
                -- 执行业务逻辑
                update Dxc_Consignor set TMSCODE=balance_Id where NAME = balance_Name;
            elsif conNum > 1 then
                dbms_output.put_line('存在多条');
            else
                dbms_output.put_line('不存在');
                -- 执行业务逻辑
            end if;
        end loop;
end;
-----------------oracle loop example end---------------------------------


-----------------indices start---------------------------------
-- 默认B树索引，适用于基数较大时
create index idx_su_login_name on sys_user('login_name');
-- 位图索引，适用于基数较少时
create bitmap index idx_sys_user_list1 on sys_user('login_name');
drop index index_sys_user_list;
-- 查询索引生效状态
select status from user_indexes where index_name = 'idx_su_login_name'
-----------------indices end---------------------------------


-----------------built-in function start---------------------------------
-- 数字函数
-- 字符函数
-- 日期函数
-- 复杂单行函数

-- instr：返回t.ROUTER中从索引1处开始第2次出现'/'的位置，例 /tableListApp/tabledata → tabledata
select substr(t.ROUTER,instr(t.ROUTER, '/', 1, 2)+1), t.ROUTER from SYS_MENU t;

-- 分析聚合函数


-----------------built-in function end---------------------------------