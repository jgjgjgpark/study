# remove remote branch
```bash
git push ${remote} --delete ${branchname}
```

# commit change
```bash
git rebase -i HEAD~3
git push -f origin master
```

# commit change from https://www.youtube.com/watch?v=ElRzTuYln0M
## rewording
```bash
git rebase -i HEAD~2 # and then rewording
```
## deleting commit
```bash
git rebase -i HEAH~2 # and then delete
```
## reorder
```bash
git rebase -i HEAD~2 # and then reorder
```
## squash
```bash
TBD
```
## split
```bash
git rebase -i HEAD~3
edit
git reset HEAD^
git add some of the commit
git commit
git add another of the commit
git commit
git rebase —continue
```

## .gitignore 적용
### remove cached
```bash
git rm -r --cached .
```
### add and commit
```bash
git add .
git commit -m "new .gitignore applied"
```
