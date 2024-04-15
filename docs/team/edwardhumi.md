# Edward Humianto's Project Portfolio Page

## Project: FitNUS

### Overview
FitNUS is a CLI application that aims to help combat diabetes and the overconsumption of calories, sugar, and
carbohydrates. Our vision is to promote healthy lifestyle amongst NUS students.

### Summary of Contributions

#### Code contributed: [RepoSense Link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=edwardhumi&tabRepo=AY2324S2-CS2113-W14-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

#### Features implemented
- Storage Class
  - Data storage system to save and load user's meal, drinks, and exercises list in `txt` format
  - Storage to keep track the nutrients and calories details of known meals, drinks, and exercises in `csv` format
- User Class
  - Added `listMealsAll`, `listDrinksAll`, `listExercisesAll`, `listEverythingAll` command which allows user to view the 
  meal/drink/exercise list for all dates
  - Added `listMeals d/dd-MM-yyyy`, `listDrinks d/dd-MM-yyyy`, `listExercises d/dd-MM-yyyy`, `listEverything d/dd-MM-yyyy` 
  command which allows user to view the list for certain date
- Parser Class
  - Created parser for parsing commands and storage files

#### Enhancements implemented
- Add exception and its handler to check whether a date is valid before displaying the list of meals/drinks/exercises for certain date
[#61](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/61/files)

#### Project Management
- Added issues for `v1.0`, `v2.0` and `v2.1`

#### Contributions to User Guide
- Added documentation for features `listMeals d/[DATE]`, `listDrinks d/[DATE]`, `listExercises d/[DATE]`, `listEverything d/[DATE]`. 
Complete with command description, format, sample input and expected output. [#69](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/69/files#diff-b50feaf9240709b6b02fb9584696b012c2a69feeba89e409952cc2f401f373fb)

#### Contributions to Developer Guide
- Added description, implementation, and class diagram for `Storage`. 
[#147](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/147/files) [#150](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/150/files)

#### Contributions to team-based tasks
- Created GitHub issues
- Assigned issues to team members
- Linked PR and Issues to Milestones

#### Review or Mentoring Contributions
- [PR Reviews](https://github.com/AY2324S2-CS2113-W14-1/tp/pulls?q=is%3Apr+commenter%3Aedwardhumi)