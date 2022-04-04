...К сожалению из-за ошибки консольный диалог из git bash до определенного места не сохранился...
Сделал fork проекта (https://github.com/Kotlin-Polytech/KotlinAsFirst2020) на свой github (https://github.com/Keshaqwertys)

Скопировал себе на компьютер:

$ git clone https://github.com/Keshaqwertys/KotlinAsFirst2020.git

Добавил upstream-my:

$ git remote add upstream-my https://github.com/Keshaqwertys/KotlinAsFirst2021.git

$ git fetch upstream-my

Нахожу хеш последнего комита: 
https://github.com/Kotlin-Polytech/KotlinAsFirst2021/commit/1137b420cc95fa6894edad69b31e2da1bb985d1d
Вот хеш: 1137b420cc95fa6894edad69b31e2da1bb985d1d

Сделал rebase upstream-my в ветку master

$ git rebase --onto master 1137b420cc95fa6894edad69b31e2da1bb985d1d upstream-my/master

Сделал ветку backport и загрузил в неё коммиты:

$ git branch backport
$ git checkout master
$ git merge backport

Добавил upstream-theirs товарища и сделал merge с веткой master:

$ git remote add upstream-theirs https://github.com/Flimill/KotlinAsFirst2021
$ git fetch upstream-theirs
$ git merge -s ours upstream-theirs/master


...Вот до этого места консольный диалог из git bash не сохранился...

Иннокентий@DESKTOP-CQB8U7R MINGW64 ~ (master)
$ git clone https://github.com/Keshaqwertys/KotlinAsFirst2020.git
Cloning into 'KotlinAsFirst2020'...
remote: Enumerating objects: 4851, done.
remote: Total 4851 (delta 0), reused 0 (delta 0), pack-reused 4851
Receiving objects: 100% (4851/4851), 962.22 KiB | 3.40 MiB/s, done.
Resolving deltas: 100% (2334/2334), done.

Иннокентий@DESKTOP-CQB8U7R MINGW64 ~ (master)
$ git status
warning: could not open directory 'Application Data/': Permission denied
warning: could not open directory 'Cookies/': Permission denied
warning: could not open directory 'Local Settings/': Permission denied
warning: could not open directory 'NetHood/': Permission denied
warning: could not open directory 'PrintHood/': Permission denied
warning: could not open directory 'Recent/': Permission denied
warning: could not open directory 'SendTo/': Permission denied
warning: could not open directory 'главное меню/': Permission denied
warning: could not open directory 'Мои документы/': Permission denied
warning: could not open directory 'Шаблоны/': Permission denied
On branch master

No commits yet

























Merge made by the 'ours' strategy.

Иннокентий@DESKTOP-CQB8U7R MINGW64 ~/KotlinAsFirst2020 (master)
$ git remote -v > remotes

Иннокентий@DESKTOP-CQB8U7R MINGW64 ~/KotlinAsFirst2020 (master)
$ git add remotes
warning: LF will be replaced by CRLF in remotes.
The file will have its original line endings in your working directory

Иннокентий@DESKTOP-CQB8U7R MINGW64 ~/KotlinAsFirst2020 (master)
$ git commit -m "Add remotes file"
[master dca3c2a] Add remotes file
 1 file changed, 6 insertions(+)
 create mode 100644 remotes

Иннокентий@DESKTOP-CQB8U7R MINGW64 ~/KotlinAsFirst2020 (master)
$ touch howto.md

$ git add howto.md

$ git commit -m "Add howto.md"