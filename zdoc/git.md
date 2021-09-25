# Git
## 远程代码迁库
```shell script
New project → import project → Repo by URL  
```
## 本地代码迁库
```shell script
# 远程分支信息
git remote -v
# 移除关联
git remote remove origin
# 新增远程关联分支
git remote add origin http://gitlab.xxx.com/dept-name/project-group/project-name.git
# 强制推送
git push -f -u origin main
```
## git fork同步其它仓库最新代码(已有项目)  
```shell script
#添加远程资源
git remote add upstream http://xxx/xxx.git
#拉取分支信息
git fetch upstream
#更新分支信息
git merge upstream/dev develop
#推送代码
git push origin develop 
```
