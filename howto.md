
### Сделал fork проекта (https://github.com/Kotlin-Polytech/KotlinAsFirst2020) на свой github (https://github.com/Keshaqwertys)

### Скопировал себе на компьютер:

$ git clone https://github.com/Keshaqwertys/KotlinAsFirst2020.git

### Добавил upstream-my:

$ git remote add upstream-my https://github.com/Keshaqwertys/KotlinAsFirst2021.git

### Загрузил коммиты из удаленного репозитория
$ git fetch upstream-my

### Сделал rebase upstream-my в ветку master, загрузил все коммиты от этого момента:

Нахожу хеш последнего коммита:
https://github.com/Kotlin-Polytech/KotlinAsFirst2021/commit/1137b420cc95fa6894edad69b31e2da1bb985d1d
Вот хеш: 1137b420cc95fa6894edad69b31e2da1bb985d1d

$ git rebase --onto master 1137b420cc95fa6894edad69b31e2da1bb985d1d upstream-my/master

### Сделал ветку backport и загрузил в неё коммиты:

$ git branch backport

$ git checkout master

$ git merge backport

### Добавил upstream-theirs товарища и сделал merge с веткой master:

$ git remote add upstream-theirs https://github.com/Flimill/KotlinAsFirst2021

$ git fetch upstream-theirs

$ git merge -s ours upstream-theirs/master



### Создал файл remote и закомитил в git:
$ git remote -v > remotes

$ git add remotes

$ git commit -m "Add remotes file"


### Создал файл howto.md и закоммитил:
$ touch howto.md

$ git add howto.md

$ git commit -m "Add howto.md"

### Загрузил на gitHub

$ git push

$ git checkout backport

$ git push --set-upstream origin backport