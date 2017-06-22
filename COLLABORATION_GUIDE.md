# Orderys Collaboration Guide
> Guidelines for version control, testing, and deployment.

### Adding a new feature to the project
1. Open your local repository (which is also your eclipse workspace for the project) in git bash. You should see the .git directory listed when you enter
`ls -al`
2. Make sure your local repo is up-to-date.
`git pull --all`
3. Create a new feature branch by branching from the dev branch. (The actual rules for branch names can be found https://www.kernel.org/pub/software/scm/git/docs/git-check-ref-format.html. Personally, I prefer to stick to 'kebab case' for my branch names, which is just lowercase letters, numbers, and dashes to separate words.)
`git checkout -b your-descriptive-branch-name -t origin/dev`
4. Do some work, then commit your changes. Make sure the changes you include in a single commit are all related, and make sure you describe the work with a good commit message. Check the status of your local repo if you aren't sure what you have changed or staged.
`git status`
`git add ./some/files/that ./you/changed`
`git commit -m "DESCRIPTIVE COMMIT MESSAGE HERE"`
5. Before you try to push any of your own work, make sure you update the branch you are working on locally with any changes in the dev branch of the main repository.
`git pull`
or
`git pull origin dev`
6. Once your local feature branch is up-to-date with the dev branch, push your work to a new branch in the main repository.
`git push origin your-descriptive-branch-name`
7. To get your work onto the dev branch in the main repository, open GitHub in your web browser and go to the page for the branch you just pushed. On that page, click the button next to the "Branch" dropdown menu that says "New pull request". When you come to a page that says "Open a pull request" make sure that you have selected "base: dev" and "compare: your-descriptive-branch-name", and that the branches are "Able to merge", and if that is the case, click the "Create pull request" button.
8. After you've opened the pull request, leave the rest for someone else to handle. DON'T approve or merge your own pull requests.
9. Lather, rinse, and repeat until the project deadline.