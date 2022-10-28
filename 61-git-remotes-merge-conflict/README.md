# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test

2. Ci si assicuri di avere localmente entrambi i branch remoti

git branch -la 

* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

git merge origin/feature master
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
     cat HelloWorld.java
───────┬───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
       │ File: HelloWorld.java
───────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
   1   │ public final class HelloWorld {
   2   │ 
   3   │     private static final String AUTHOR = "Danilo Pianini";
   4   │ 
   5   │     public static void main(final String[] args) {
   6   │         System.out.println("This program is running in a PC with " + procNumber() + " logic processors!");
   7   │     }
   8   │ 
   9   │     public static int procNumber() {
  10   │         System.out.println("This program has been realised by " + AUTHOR);
  11   │         return Runtime.getRuntime().availableProcessors();
  12   │     }
  13   │ 
  14   │ }
───────┴────────────────────────────────────────────────────────────────────────────────────────────────────────────────
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

git remote add fallback git@github.com:aleemont1/lab06_61-fallback.git

8. Si faccia push del branch `master` sul proprio repository

git push -u fallback master

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
git branch --set-upstream-to=fallback/master