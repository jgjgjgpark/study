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
1. rewording
```bash
git rebase -i HEAD~2 # and then rewording
```
1. deleting commit
```bash
git rebase -i HEAH~2 # and then delete
```
1. reorder
```bash
git rebase -i HEAD~2 # and then reorder
```
1. squash
```bash
TBD
```
1. split
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
