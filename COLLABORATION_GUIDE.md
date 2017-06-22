# Orderys Collaboration Guide
> Guidelines for version control, testing, and deployment.

### Adding a new feature to the project
1. Open your local repository (which is also your eclipse workspace for the project) in git bash. You should see the .git directory listed when you enter
`ls -al`
2. Make sure your local repo is up-to-date.
`git pull --all`
3. Create a new feature branch off of the dev branch.
`git checkout -b descriptive_branch_name -t `