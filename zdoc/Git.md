# Git

## 代码风格  
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

##   
```yaml
# 前置条件(若使用Windows)
- 提前安装Python3
- Git Bash中执行`git config --global core.autocrlf true`

# 1、项目根目录下执行以下命令
# macOS
brew install pre-commit
# Windows
pip install pre-commit

# 2、项目根目录执行
pre-commit install --install-hooks -t pre-push
```