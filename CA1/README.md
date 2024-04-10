# Technical Report for Class Assignment 1 - Version  Control  with  Git

## Introduction

This technical report documents the completion of the Class Assignment 1 for the DevOps class. The assignment focuses
on  `'Version control with Git'`, aiming to provide a practical experience in using Git for managing software
development projects. Undertaken by Lucia Marco, student number 1231839, this report serves as a comprehensive
documentation of the steps followed, commands executed, and challenges encountered during the completion of the
assignment. Through detailed explanations and insights gained from hands-on exercises, this report aims to provide a
thorough understanding of version control concepts and practices using Git.

The project explores the fundamentals of version control in software development, focusing primarily on Git as a
distributed version control system. With the objective of enhancing understanding and practical application, the project
unfolds through a series of chapters, each addressing key aspects of version control and project management. From basic
Git concepts to practical workflows for feature development and bug fixing, this project offers a comprehensive overview
of version control practices in modern software development. Additionally, an alternative technological solution is
considered, providing insights into different approaches to version control. Through theoretical tutorials and hands-on
exercises, this report aims to share valuable knowledge and skills essential for effective collaboration and code
management in software projects.

# Table of Contents

1. [Initialization of Git Repository](#1-initialization-of-git-repository)  
   1.1. [Procedure](#11-procedure)  
   1.2. [Checking Repository Status](#12-checking-repository-status)  
   1.3. [Cloning the Application](#13-cloning-the-application)
2. [Managing Gitignore](#2-managing-gitignore)
3. [Understanding the Basics](#3-understanding-the-basics)  
   3.1. [Tracking Files](#31-tracking-files)  
   3.2. [Viewing Commit History with git log](#32-viewing-commit-history-with-git-log)  
   3.3. [Staging Modified Files](#33-staging-modified-files)  
   3.4. [Tagging](#34-tagging)
4. [Copying Tutorial Application Code (Use Case - Part 1)](#4-copying-tutorial-application-code-use-case---part-1)
5. [Version Tagging (Use Case - Part 1)](#5-version-tagging-use-case---part-1)
6. [New Feature Development (Use Case - Part 1)](#6-new-feature-development-use-case---part-1)  
   6.1. [Adding a New Feature Using Only Main Branch](#61-adding-a-new-feature-using-only-main-branch)  
   6.2. [New Feature Completion](#62-new-feature-completion)
7. [Understanding Branches](#7-understanding-branches)  
   7.1. [Creating a New Branch](#71-creating-a-new-branch)  
   7.2. [Switching Back to the Master Branch](#72-switching-back-to-the-master-branch)  
   7.3. [Merging Changes into Master Branch](#73-merging-changes-into-master-branch)  
   7.4. [Merging Changes into Master Branch after Master has been Modified](#74-merging-changes-into-master-branch-after-master-has-been-modified)
   7.5. [Continuing Work on a Branch After Merging](#75-continuing-work-on-a-branch-after-merging)  
   7.6. [Deleting a Branch](#76-deleting-a-branch)  
   7.7. [Basic Merge Conflicts](#77-basic-merge-conflicts)
8. [Git Workflow with Branches (Use Case - Part 2)](#8-git-workflow-with-branches-use-case---part-2)  
   8.1. [Create a new branch named "email-field"](#81-create-a-new-branch-named-email-field)  
   8.2. [Implement the feature, add unit tests, and debug as necessary](#82-implement-the-feature-add-unit-tests-and-debug-as-necessary)

   8.3. [Commit the changes and push them to the repository](#83-commit-the-changes-and-push-them-to-the-repository)    
   8.4. [Merge the code with the master branch](#84-merge-the-code-with-the-master-branch)  
   8.5. [Delete the unnecessary branch](#85-delete-the-unnecessary-branch)  
   8.6. [Create a new tag for the updated version](#86-create-a-new-tag-for-the-updated-version)  
   8.7. [Push the changes and tag to the server](#87-push-the-changes-and-tag-to-the-server)
9. [Bug Fixing Workflow using Branches And Issues (Use Case - Part
   2)](#9-bug-fixing-workflow-using-branches-and-issues-use-case---part-2)

    9.1. [Create a New Issue on GitHub](#91-create-a-new-issue-on-github)  
    9.2. [Assign the Issue](#92-assign-the-issue)  
    9.3. [Create a New Branch Locally](#93-create-a-new-branch-locally)  
    9.4. [Implement the Fix and Debug](#94-implement-the-fix-and-debug)  
    9.5. [Commit and Push Changes](#95-commit-and-push-changes)  
    9.6. [Merge the Branch](#96-merge-the-branch)  
    9.7. [Close the issue](#97-close-the-issue)

10. [Alternative Technological Solution](#10-alternative-technological-solution)  
    10.1. [Comparison with Git](#101-comparison-with-git)  
    10.2. [Implementation of Alternative Solution](#102-implementation-of-alternative-solution)  
    10.3. [Comparison Analysis](#103-comparison-analysis)
11. [Conclusion](#11-conclusion)

## 1. Initialization of Git Repository

The first task of the exercise was to create and set up a Git repository for the project. This involved initializing a
local repository, creating a README file, and pushing the initial commit to a remote repository on GitHub.

### 1.1. Procedure

To begin version controlling your project with Git, follow these steps:

- **Initialize a Git Repository:** If your project directory is not already under version control, you can start by
  initializing a Git repository. Navigate to your project directory in the terminal or command prompt and run the
  following command:

    ```bash
    cd /workspaces/devops/git-tutorial/my_project
    git init
    ```    

This command creates a new subdirectory named `.git` that contains all necessary repository files, forming the Git
repository skeleton. Do not edit or update this folder. At this point, none of your project files are tracked yet.

- **Start Version Controlling Existing Files:** If you want to start version-controlling existing files in your project,
  you need to add them to the repository and make an initial commit. Execute the following commands:

    ```bash
    echo "# repository-name" >> README.md
    git add README.md
    git commit -m "first commit"
    ```  

These commands add the `README.md` file to the repository and commit it with the message "First commit." Now, your
project has a Git repository with tracked files and an initial commit.

- **Link Local Repository to Remote Repository**: To link your local repository to a remote repository on GitHub, use
  the following commands:

    ```bash
    git remote add origin git@github.com:username/repository-name.git
    git push -u origin main
    ```  

These commands add the remote repository as the origin and push your initial commit to the `main` branch on GitHub.

- **Create Empty Repository on GitHub:** Log in to GitHub and create an empty repository where you want to store your
  project, with the following naming convention:


        `devops-23-24-<teacher>-<your number>`

Replace `<teacher>` with your teacher's ID (e.g., JPE or PSM) and `<your number>` with your enrollment number. For
example:

        `devops-23-24-JPE-PSM-1231839`

Grant admin or write rights to your teacher by providing their email address (e.g., jpe@isep.ipp.pt or psm@isep.ipp.pt).

- **Clone Repository to Local Computer:** Using a terminal or console on your local computer, clone the repository you
  created on GitHub. Choose a folder path without spaces or accented letters. For example:

    ```bash
    $ git clone https://github.com/yourusername/devops-23-24-JPE-PSM-1231839 c:/devops/devops-23-24-JPE-PSM-1231839
    ```

This command clones the GitHub repository into a folder named `devops-23-24-JPE-PSM-1231839` inside `c:/devops`. Inside this
folder, create sub-folders for each exercise as instructed.

### 1.2. Checking Repository Status

After initializing or cloning a repository, use the `git status` command to check the repository status. This command
provides information about tracked and untracked files, branch status, and more.

```bash
$ git status

On branch master
Your branch is up to date with 'origin/main'. 
nothing to commit, working tree clean 
```

This command displays the current branch, any changes to be committed, and any untracked files.

### 1.3. Cloning the Application

In this section, you will learn how to clone the application repository from GitHub to your local computer and set it up
for execution.

#### Steps:

- **Clone the Repository**: Open a terminal or command prompt and execute the following command to clone the application
  repository:

    ```bash    
    $ cd /workspaces/devops/devops-23-24-JPE-PSM-1231839
    $ git clone https://github.com/spring-guides/tut-react-and-spring-data-rest
    ```

This command will download the entire repository to your local machine.

- **Navigate to the Basic Folder**: Move into the `basic` folder of the cloned repository by executing the following
  command:

    ```bash    
    $ cd tut-react-and-spring-data-rest/basic
    ```

This command changes the current directory to the `basic` folder within the cloned repository.

- **Run the Application**: Execute the following command in the terminal to start the application:

    ```bash    
    $ ./mvnw spring-boot:run
    ```

On Windows, use the command `mvnw spring-boot:run` instead. This command will compile and run the application.

- **Access the Application**: Open your web browser and enter the following URL:

- `http://localhost:8080/`

  This URL will allow you to access the locally running instance of the application.

- **Debugging the Application**: Debug the application using developer tools available in your web browser and IDE. Use
  Chrome's developer tools with the "React Developer Tools" extension installed for client-side debugging, and use your
  preferred IDE (such as Eclipse or IntelliJ) for server-side debugging.

## 2. Managing Gitignore

To avoid including unnecessary files in the repository, a `.gitignore` file needed to be created. This file specifies
which files and directories to exclude from version control.

### Procedure

1. Create a `.gitignore` file using the following command:

   ```bash
   touch .gitignore
   git add .
   git commit -m "created gitignore"
   ```

2. Open the `.gitignore` file using a text editor such as nano:

    ```bash
    nano .gitignore
    git add .
    git commit -m "updated gitignore and added tutorial"   
    ```

## 3. Understanding the Basics

The basic Git workflow goes something like this:

1. You modify files in your working directory
2. You stage the files, adding snapshots of them to your staging area (Initially a file is untracked. We need to command
   git to add the file to the repository).
3. You do a commit, which takes the files as they are in the staging area and stores that snapshot permanently to your
   Git directory. Every commit generates a new version in the "repository".

### 3.1. Tracking Files

In Git, tracking files involves keeping a record of changes made to them over time. This allows you to manage the
evolution of your project's codebase effectively.

#### 3.1.1. Tracking New Files with `git add`

When you have a new file that you want to start tracking in your Git repository, you can use the `git add` command. This
command allows you to add the file to the list of tracked files and stage it for the next commit.

Here's how you can track a new file:

- Run the `git add` command followed by the name of the file you want to track. For example, let's say you have a new
   file named `SETUP`:

   ```bash
   $ git add SETUP
   ```

- After adding the file, run the `git status` command to check the status of your repository:

    ```bash
    $ git status
    ```

   You'll see the newly added file listed under the "Changes to be committed" section, indicating that it's staged and
   ready to be included in the next commit.


- Once the file is staged, you can proceed to commit the changes using the `git commit` command.

   By using `git add`, you can effectively start tracking new files in your Git repository, ensuring that they are
   included in your project's version history.

#### 3.1.2. Staging Modified Files with `git add`

When you modify a file that is already tracked in your Git repository, you need to stage those changes before committing
them. This process involves using the `git add` command to stage the modified files.

Let's say you have modified a file named `README.adoc` and you want to stage these changes for the next commit. Follow
these steps:

- Run the `git status` command to check the status of your repository:

    ```bash
    $ git status
    ```

You'll see the modified file listed under the "Changes not staged for commit" section.

- To stage the changes to `README.adoc`, use the `git add` command:

    ```bash
    $ git add README.adoc
    ```

- Run `git status` again to confirm that the file is staged:

    ```bash
    $ git status
    ```

Now, you'll see the modified file listed under the "Changes to be committed" section, indicating that it's staged and
ready to be included in the next commit.

By staging modified files with `git add`, you ensure that the changes are included in your next commit, allowing you to
effectively manage your project's version history.

The `git add` command takes a path name for either a file or a directory. If it's a directory, the command adds all the
files in that directory recursively. This means that if you have multiple new files or files in subdirectories that you
want to add, you can simply specify the directory name instead of listing each file individually.

### 3.2. Viewing Commit History with `git log`

After creating multiple commits or cloning a repository with an existing commit history, you'll likely want to review
the history of commits. The primary tool for this task is the `git log` command.

**Basic Usage:** Simply running `git log` in your terminal will display a list of commits in reverse chronological
order, starting from the most recent. Each commit is accompanied by details such as the commit hash, author, date, and
commit message.

   ```bash
   $ git log
   ```

### 3.3. Staging Modified Files

In Git, when you modify a file that is already being tracked, you need to stage those changes before committing them to
your repository. This process ensures that you have control over which modifications are included in the next commit.
Let's walk through the steps to stage modified files:

- **Checking the Status**: Start by running the `git status` command to check the status of your repository. This
   command provides a summary of the changes made to tracked files and the current staging status.

    ```bash
    $ git status
    ```

    This command will display a list of changes, including files that have been modified but not yet staged.

- **Staging Modified Files**: To stage the modifications to a tracked file, you use the `git add` command followed by
  the name of the file. For example, if you have modified a file named `README.adoc`, you would run:

    ```bash
    $ git add README.adoc` 
    ```
    
    After adding the file, running `git status` again will show that the modified file is now staged and ready to be
    included in the next commit.

    ```bash
    $ git status
    ```
    
    You'll see the modified file listed under the "Changes to be committed" section, indicating that it's staged and ready
    to be included in the next commit.

    By following these steps, you can effectively stage modified files in your Git repository, ensuring that only the
    desired changes are included in your commits. This helps maintain a clean and organized version history for your
    project.

### 3.4. Tagging

Tagging in Git allows you to mark specific points in a repository's history as significant. People commonly use tags to
denote release points (e.g., v1.0, v2.0). Let's explore how to work with tags.

#### 3.4.1. Adding Tags to the Project

Before you can list or create tags, you need to add tags to your project. You can add tags to your project using
the `git tag` command. For example, to add a tag named `v1.0`, you would run:

```bash
$ git tag v1.0
```

This command adds a lightweight tag named `v1.0` to the current commit.

#### 3.4.2. Listing Existing Tags

After adding tags to your project, you can list them using the `git tag` command:

```bash
$ git tag 
v1.0
v2.0
```

This command lists all the tags present in the repository, such as `v1.0` and `v2.0`.

#### 3.4.3. Creating an Annotated Tag

Creating annotated tags in Git is essential for marking specific points in your project's history. To create an
annotated tag, use the `-a` option with the `git tag` command. Specify the tag name and provide a message using the `-m`
flag:

```bash
$ git tag -a v1.4 -m "my version 1.4"
```

This command creates an annotated tag named `v1.4` with the message "my version 1.4".

#### 3.4.4. Viewing Tag Information

After creating the tag, you can use the `git show` command to view the tag information, including the associated commit:

```bash
$ git show v1.4
```

This command displays details about the tag, including the tagger's information and the commit it points to.

#### 3.4.5. Pushing Tags to Remote Repository

By default, Git doesn't push tags to remote repositories. To share your tags, you need to explicitly push them:

```bash
$ git push origin v1.4
```

Replace `v1.4` with the name of the tag you want to push. This command pushes the specified tag to the remote repository
named `origin`.

#### 3.4.6. Summary

Annotated tags provide valuable metadata about specific points in your project's history, making them useful for
versioning and collaboration.

By following these steps, you can effectively work with tags in your Git repository, marking significant points in your
project's history and sharing them with others.

Add the necessary patterns to exclude specific files or directories, such as `.idea/`, to avoid including
   IDE-specific files, some build files, and any other files deemed necessary. You can use  https://www.gitignore.io to
   help you create `.gitignore` files.

## 4. Copying Tutorial Application Code (Use Case - Part 1)

In this section, we will copy the code of the Tutorial React.js and Spring Data REST Application into a new folder named
CA1.

### Procedure

- Copy the code of the Tutorial React.js and Spring Data REST Application and the "pom.xml" file into a new folder
   named CA1.

    ```bash
    mkdir CA1
    cp -r tut-react-and-spring-data-rest/basic CA1
    cp tut-react-and-spring-data-rest/pom.xml CA1 
    ```

- Commit the changes and push them to the repository.

    ```bash
    cd CA1
    git init
    git add CA1
    git commit -m "added package CA1"
    git push origin main
    ```

## 5. Version Tagging (Use Case - Part 1)

To mark the versions of the application, we will use tags with a pattern like major.minor.revision (e.g., 1.1.0). We
will tag the initial version as v1.1.0 and push it to the server.

### Procedure

- Tag the initial version as v1.1.0.

    ```bash
    git tag v1.1.0
    ```

- Push the tag to the server.

    ```bash
    git push origin v1.1.0 
    ```

## 6. New Feature Development (Use Case - Part 1)

In this section, we will develop a new feature to add a new field to the application. Specifically, we will add a new
field to record the years of the employee in the company (e.g., jobYears).

### 6.1. Adding a New Feature Using Only Main Branch

### Tasks

1. Add support for the new field.
2. Add unit tests for testing the creation of Employees and the validation of their attributes. Ensure no null/empty
   values are accepted, and only integer values are allowed for the new field.
3. Debug the server and client parts of the solution.
4. Once the new feature is completed and tested, commit and push the code.
5. Create a new tag for the updated version (e.g., v1.2.0).

### Procedure

- Implement the feature, add unit tests, and debug as necessary.

- Commit the changes and push them to the repository.

    ```bash
    git add .
    git commit -m "added field jobYears"
    git push origin main
    ```

- Create a new tag for the updated version.

    ```bash
    git tag v1.2.0
    ```

- Push the tag to the server.

    ```bash
    git push origin v1.2.0
    ```

### 6.2. New Feature Completion

At the end of this part of the assignment, mark your repository with the tag ca1-part1.

### Procedure

- Tag the repository as ca1-part1.

    ```bash
    git tag ca1-part1
    ```

- Push the tag to the server.

    ```bash
    git push origin ca1-part1
    ```

## 7. Understanding Branches

Branches in Git are essential for managing the development of a project. They allow multiple lines of development to
coexist independently within the same repository. Each branch represents a distinct snapshot of the project's codebase,
making it possible to work on new features, bug fixes, or experiments without affecting the main codebase.

The main branch in Git is typically called `master` or `main`, and it serves as the default branch where the primary
line of development occurs. However, Git allows you to create new branches from this main branch or from any other
existing branch. These branches can diverge from the main codebase to implement new features or experiment with changes,
and they can later be merged back into the main branch when ready.

Branches provide isolation for changes, allowing developers to work independently on different features or fixes without
interfering with each other's work. They also facilitate collaboration by enabling parallel development and easy
integration of changes from multiple contributors.

### 7.1. Creating a New Branch

To create a new branch in Git, you use the `git branch` command followed by the name of the new branch. For example, to
create a branch named `testing`, you would run:

```bash
$ git branch testing
```

However, creating a new branch does not automatically switch to that branch. Git keeps a special pointer called `HEAD`
to track the current branch you're on. To switch to the new branch, you use the `git checkout` command:

```bash
$ git checkout testing
```

Once you're on the new branch, you can make changes to the code as needed. Git will track these changes within the
context of the current branch.

### 7.2. Switching Back to the Master Branch

To switch back to the `main` branch (or any other existing branch), you use the `git checkout` command again:

```bash
$ git checkout main
```

Git will move the `HEAD` pointer back to point to the `main` branch, reverting the files in your working directory
back to the snapshot that `main` points to.

### 7.3. Merging Changes into Master Branch

In this tutorial chapter, you will learn how to merge changes from another branch, specifically the `testing` branch, into the `main` branch. This process assumes that the `main` branch has not been modified since the creation of the `testing` branch.

#### Steps:

1.  **Checkout the Target Branch**: Begin by switching to the branch you want to merge changes into. In this case, it's the `main` branch:

    ```bash
    $ git checkout main
    ```

-   **Merge the Other Branch**: Once you are on the `main` branch, merge the changes from the `testing` branch using the `git merge` command with the `--no-ff` option:

    ```bash 
    $ git merge --no-ff testing
    ```    

This command will merge the changes from the `testing` branch into the `main` branch, creating a merge commit even if the fast-forward merge is possible.

By using the `--no-ff` option with the `git merge` command, you ensure that Git creates a merge commit, preserving the branch history and making it visible in the commit history graph. This can be particularly useful for maintaining a clear and informative history of changes, especially in cases where multiple developers are collaborating on a project and working on separate branches.

- **Commit the Merge**: After resolving any conflicts, commit the merge to finalize the process:

    ```bash   
    $ git commit -m "Merge changes from testing branch into master"
    ``` 

- **Verify the Merge**: Verify that the merge was successful by checking the status of your repository and reviewing the
  commit history.

By following these steps, you can merge changes from the `testing` branch into the `main` branch without any
conflicts.

### 7.4. Merging Changes into Master Branch after Master has been Modified

In this tutorial chapter, you will learn how to merge changes from another branch, the `testing` branch, into
the `main` branch when the `main` branch has been modified since the creation of the `testing` branch.

#### Steps:

- **Checkout the Target Branch**: Start by switching to the branch you want to merge changes into. In this case, it's
  the `main` branch:

    ```bash
    $ git checkout main
    ```

- **Merge the Other Branch**: Once you are on the `main` branch, merge the changes from the `testing` branch using
  the `git merge` command:

    ```bash   
    $ git merge testing
    ```

This command will attempt to merge the changes from the `testing` branch into the `main` branch.

- **Resolve Conflicts (if any)**: If there are any conflicts during the merge process, Git will prompt you to resolve
  them manually. Open the conflicted files in your text editor, resolve the conflicts, and save the changes.

- **Commit the Merge**: After resolving conflicts, stage the changes and commit the merge:

    ```bash 
    $ git add .
    $ git commit -m "Merge changes from testing branch into main"
    ``` 

Provide an appropriate commit message to describe the merge.

- **Verify the Merge**: Verify that the merge was successful by checking the status of your repository and reviewing the
  commit history.

By following these steps, you can merge changes from the `testing` branch into the `main` branch, even if the `main`
branch has been modified since the creation of the `testing` branch.

### 7.5. Continuing Work on a Branch After Merging

Sometimes, after merging a branch into the main line of development, you may need to continue working on that branch to
implement additional changes or fixes. This tutorial will guide you through the process of switching back to a branch
after merging and continuing your work.

#### Steps:

1. **Check Current Branch**: Start by checking which branch you are currently on using the `git branch` command:

    ```bash
    $ git branch
          main
        * hotfix
    ```

In this example, we are currently on the `hotfix` branch.

- **Switch to the Merged Branch**: If you want to continue working on a branch that has been merged, switch to that
  branch using the `git checkout` command:

    ```bash    
    $ git checkout testing
    ```

- **Verify Changes**: After switching to the branch, verify that you are now on the correct branch by checking the
  branch list again:

    ```bash
    $ git branch
        * testing
          main
    ```

  Now, you should see an asterisk (*) next to the branch you just switched to.

- **Continue Working**: You can now continue making changes, committing them, and pushing them to the remote repository
   as needed. Remember to follow your project's workflow and guidelines for branch management.

- **Commit and Merge Changes**: Once you've completed your work on the branch, follow the standard procedure to commit
   your changes and merge them back into the main line of development.

By following these steps, you can easily switch back to a branch after merging and continue your work seamlessly.

### 7.6. Deleting a Branch

Once you've completed work on a branch and no longer need it, you can delete the branch using the `git branch -d`
command followed by the name of the branch:

   ```bash
   $ git branch -d testing
   ```

This will delete the `testing` branch, assuming it has been fully merged with the main branch. If there are unmerged
changes, Git will prevent you from deleting the branch to avoid losing work.

### 7.7. Basic Merge Conflicts

Merge conflicts happen when Git cannot automatically merge changes from different branches due to conflicting
modifications made to the same part of a file.

#### Steps:

- **Identifying Merge Conflicts**: When Git encounters conflicting changes during a merge, it pauses the process and
   indicates which files have conflicts. To check for unmerged files, use the following command:

    ```bash
    $ git status
    ```

This command will display a list of files with merge conflicts, marked as unmerged.

- **Resolving Merge Conflicts**: Open the conflicted files in your text editor. Git adds standard conflict-resolution
  markers to the conflicted sections of the file. The markers indicate the conflicting changes from different branches.

  Your file contains a section that looks something like this:

    ```bash    
        <<<<<<< HEAD:index.html
        <div id="footer">contact : email.support@github.com</div>
        =======
        <div id="footer">
        please contact us at support@github.com
        </div>
        >>>>>>> iss53:index.html
    ```

To resolve the conflict, manually edit the file to choose the version of the changes you want to keep. Remove the
conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`) and any unwanted lines.

- **Marking Conflicts as Resolved**: After resolving the conflicts in the file, stage the file to mark it as resolved
  using the `git add` command:

    ```bash    
    $ git add <file>
    ```

Replace `<file>` with the name of the conflicted file.

- **Finalizing the Merge**: Once all conflicted files have been resolved and staged, you can finalize the merge commit
  by running:

    ```bash    
    $ git commit
    ```

This command will create a merge commit with the resolved changes.

## 8. Git Workflow with Branches (Use Case - Part 2)

In this section, we will implement a simple scenario illustrating a basic git workflow for managing stable versions,
developing new features, and fixing bugs. The exercise should be developed using branches.

- **Use the master branch to "publish" stable versions of the Tutorial React.js and Spring Data REST Application.
- **Develop new features in branches named after the feature.

### Tasks

1. Create a branch named "email-field".
2. Add support for the email field.
3. Add unit tests for testing the creation of Employees and the validation of their attributes.
4. Debug the server and client parts of the solution.
5. Once the new feature is completed and tested, merge the code with the master branch and create a new tag (e.g.,
   v1.3.0).

### Procedure

### 8.1. Create a new branch named "email-field".

```bash
git checkout -b email-field
```

### 8.2. Implement the feature, add unit tests, and debug as necessary.

### 8.3. Commit the changes and push them to the repository.

```bash
git add .
git commit -m "added field email and support for the new field"
git push origin email-field
git add .
git commit -m "added tests for field email"
git push origin email-field
```

### 8.4. Merge the code with the master branch.

```bash
git checkout main
git merge --no-ff email-field
git add .
git commit -m "Merge branch 'email-field'"
git push origin main
```

### 8.5. Delete the unnecessary branch.

```bash
git branch -d email-field
```

### 8.6. Create a new tag for the updated version.

```bash
git tag v1.3.0
```

### 8.7. Push the changes and tag to the server.

```bash
git push origin main
git push origin v1.3.0
```

## 9. Bug Fixing Workflow using Branches And Issues (Use Case - Part 2)

- **Create branches for fixing bugs (e.g., "fix-invalid-email").

When working on fixing bugs in your project, it's essential to keep track of the issues you encounter and resolve.
GitHub provides a powerful issue tracking system that allows you to create, assign, and close issues associated with
your repository.

### Tasks

1. Create a branch called "fix-invalid-email". The server should only accept Employees with a valid email (e.g., an
   email must have the "@" sign).
2. Debug the server and client parts of the solution.
3. Once the fix is completed and tested, merge the code into the master branch and create a new tag (with a change in
   the minor number, e.g., v1.3.0 -> v1.3.1).

### Procedure

### 9.1. Create a New Issue on GitHub

Before starting work on fixing the bug, it's good practice to create a new issue on GitHub to track the problem and its
resolution. 

Navigate to your repository on GitHub and click on the "Issues" tab. Then, click on the "New issue" button
and provide a descriptive title and description for the issue. For example, "Fix invalid email validation in server."

### 9.2. Assign the Issue

Once the issue is created, you can assign it to yourself or another team member responsible for fixing the bug. You can
also add labels to categorize the issue (e.g., bug, enhancement, etc.) and milestones to track progress.

### 9.3. Create a New Branch Locally

After creating the issue on GitHub, switch to your local development environment and create a new branch named "
fix-invalid-email" to work on the bug fix.

```bash
git checkout -b fix-invalid-email
```

### 9.4. Implement the Fix and Debug

Proceed to implement the necessary changes to fix the invalid email validation issue in both the server and client parts
of the solution. Debug the code as necessary to ensure the fix works correctly.

### 9.5. Commit and Push Changes

Once the fix is implemented and tested locally, stage and commit your changes, and push them to the repository along
with the new branch.

```bash
git add .
git commit -m "Add the new field to the render methods in the app.js closes #1"
git push origin fix-invalid-email
```

### 9.6. Merge the Branch

After pushing the changes to the repository, create a pull request on GitHub to merge the "fix-invalid-email" branch
into the master branch. Review the changes, ensure they meet the project's coding standards, and merge the branch.

### 9.7. Close the issue

If you haven't done so yet, close the issue related to fixing the invalid email validation. You can do this by adding a message in the commit related to the issue. For example:

```bash
git commit -m "Fixed invalid email validation. Closes #<issue-number>"
```

Replace `<issue-number>` with the number of the issue you're closing. This ensures that the issue related to fixing the
invalid email validation is closed along with the merging of the code into the master branch.

### 9.8. Create a New Tag

After merging the code into the master branch, create a new tag to mark the updated version of the project. Increment
the minor version number to reflect the bug fix.

```bash
git checkout main
git merge fix-invalid-email
git tag v1.3.1
```

### 9.9. Push Changes and Tag

Finally, push the merged changes and the new tag to the remote repository on GitHub.

```bash
git push origin main
git push origin v1.3.1
```

## 10. Alternative Technological Solution

In this section, we will explore an alternative technological solution for version control, comparing it to Git and
describing its potential implementation to achieve the same goals as presented for this assignment.

### 10.1. Comparison with Git

The alternative tool for version control that we will consider is Mercurial. Let's compare it with Git regarding version
control features:

- **Branching and Merging:** Both Mercurial and Git support branching and merging of code changes.
- **Distributed Version Control:** Both tools follow a distributed version control model, allowing developers to work
  independently and merge changes later.
- **Tagging:** Both tools support tagging to mark specific versions of the code.
- **Workflow Support:** Git and Mercurial offer support for various workflows, including feature branching and release
  management.

### 10.2. Implementation of Alternative Solution

To implement the alternative solution using Mercurial, we would follow a similar approach to the one outlined for Git:

| Task                                  | Git                                                                                                                                                                                                                                      | Mercurial                                                                                                                                                                                                                                                                          |
|---------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Initialization**                    | `git init`                                                                                                                                                                                                                               | `hg init`                                                                                                                                                                                                                                                                          |
| **Copying Tutorial Application Code** | `cp -r /path/to/tutorial-application CA1`                                                                                                                                                                                                | `cp -r /path/to/tutorial-application CA1`                                                                                                                                                                                                                                          |
| **Version Tagging**                   | `git tag v1.1.0`                                                                                                                                                                                                                         | `hg tag v1.1.0`                                                                                                                                                                                                                                                                    |
| **Feature Development**               | - Create a branch: `git checkout -b email-field` <br> - Develop feature <br> - Commit changes: `git commit -m "Implemented new feature: added email field"` <br> - Merge with master: `git checkout master` <br> `git merge email-field` | - Create a branch: `hg branch email-field` <br> - Develop feature <br> - Commit changes: `hg commit -m "Implemented new feature: added email field"` <br> - Merge with default: `hg update default` <br> `hg merge email-field` <br> `hg commit -m "Merge email-field branch"`     |
| **Bug Fixing**                        | - Create a branch: `git checkout -b fix-invalid-email` <br> - Implement fix <br> - Commit changes: `git commit -m "Fixed invalid email validation"` <br> - Merge with master: `git checkout master` <br> `git merge fix-invalid-email`   | - Create a branch: `hg branch fix-invalid-email` <br> - Implement fix <br> - Commit changes: `hg commit -m "Fixed invalid email validation"` <br> - Merge with default: `hg update default` <br> `hg merge fix-invalid-email` <br> `hg commit -m "Merge fix-invalid-email branch"` |

### 10.3. Comparison Analysis

Both Git and Mercurial offer similar version control features, including branching, merging, tagging, and distributed
version control. However, there are some differences in syntax and workflow:

- **Branching and Merging:** Git uses the `checkout` and `merge` commands for branching and merging, while Mercurial
  uses `branch` and `update` for branching and `merge` for merging.
- **Tagging:** Both tools support tagging, but the commands to create tags are slightly different (`git tag` for Git
  and `hg tag` for Mercurial).
- **Workflow:** While the overall workflow is similar between Git and Mercurial, there are differences in terminology
  and specific commands used for common tasks.

In terms of usability and popularity, Git has a larger user base and more extensive documentation, making it a popular
choice for version control. Mercurial, on the other hand, is known for its simplicity and ease of use, making it a
viable alternative for smaller teams or projects.

Overall, the choice between Git and Mercurial depends on factors such as project requirements, team familiarity, and
personal preferences. Both tools have their strengths and weaknesses, and either can be effectively used for version
control in software development projects.

## 11. Conclusion

The completion of Class Assignment 1 for the DevOps course has provided valuable insights and practical experience in
utilizing Git for version control. Through the exploration of various Git commands, workflows, and best practices
detailed in this report, a solid foundation has been established in managing software development projects effectively.
From understanding the basics of Git workflow to implementing new features, fixing bugs, utilizing branches and
assigning issues to various tasks, this assignment was very effective in providing essential skills for collaborating on
projects efficiently.

The documentation provided in this report serves as a valuable resource for future projects in version control and
software development. Reflecting on the challenges encountered and lessons learned throughout the assignment, it is
evident that continuous practice and exploration are essential for mastering Git and fully leveraging its capabilities
in practical applications and real-world scenarios.

Overall, Class Assignment 1 has been an enriching learning experience, providing the opportunity to delve deeper into
the intricacies of version control and Git. As the journey in DevOps continues, the knowledge gained from this
assignment will undoubtedly contribute to future projects and endeavors in the field of software development and DevOps
practices.

