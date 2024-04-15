# Claribel Ho Jia Huan's Project Portfolio Page
## FitNUS
FitNUS is a CLI application that aims to help combat diabetes and the overconsumption of calories, sugar, and
carbohydrates. Our vision is to promote healthy lifestyle amongst NUS students.

## Summary of Contributions
Given below are my contributions to the project   
### Code Contribution   
* [Individual Reposense](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=w14&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=claribelho&tabRepo=AY2324S2-CS2113-W14-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Features implemented
1. **User** Class: [#10](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/10)
   1. Create methods to handle view and clear inputs.
   2. Additionally, due to reorganisation of methods in v2.1, the following methods originally created in the User Class were moved:  
      * _MealList Class_ - adding, editing and deleting a meal and viewing of the meal list. 
      * _DrinkList Class_ - editing and deleting a drink.
      * _Meal, Drink and Exercise Class_ - view all pre-defined meals, drinks and exercises.


2. **Date** Class: [#48](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/48/files#diff-e9bbd74038a5477b04128de17dc3a668137bf26b605b96c981c1bc8d24963e3a)
   1. Uses java.sql.Date to obtain the user's local machine date and time. 
   2. This is used 
     for storage organisation of user's past and present inputs.  
  

3. **DateValidation** and **IntegerValidation** Classes: [#137](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/137)
   [#51](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/51)
   1. These classes are responsible for verifying the 
     validity of dates and integers, else the methods will throw an exception to the user.

### Enhancements implemented
* Extensive Code Defense through testing to find bugs. Made use of exceptions and assertions to catch errors. 
[#51](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/51)
[#80](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/80)
[#153](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/153)
* Improve checks when Parsing user input to detect for user misuse.
* Improve checks when loading saved data in Storage to detect for user manipulation.

### Contributions to User Guide
- [View our User Guide](https://ay2324s2-cs2113-w14-1.github.io/tp/UserGuide.html)
- Created User Guide in v1.0, including the description, format, sample input and expected output for each command. 
[#35](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/35)
- Add documentation for `allmeals`, `allDrinks` and `allExercises`. [#76](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/76)
- Finalisation of descriptions and formatting in final v2.1 submission, with heavy emphasis on including notes for 
  the user to take note on. 
[#153](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/153)

### Contributions to Developer Guide
- [View our Developer Guide](https://ay2324s2-cs2113-w14-1.github.io/tp/DeveloperGuide.html)
- [User Component](https://ay2324s2-cs2113-w14-1.github.io/tp/DeveloperGuide.html#user-component): Add Class Diagram, 
  Descriptions and Sequence Diagram.
- [Ui Component](https://ay2324s2-cs2113-w14-1.github.io/tp/DeveloperGuide.html#ui-component): Add descriptions and 
  Sequence Diagrams.
- [Storage Component](https://ay2324s2-cs2113-w14-1.github.io/tp/DeveloperGuide.html#sequence-diagram-1): Add 
  Sequence Diagram.
- [Appendix](https://ay2324s2-cs2113-w14-1.github.io/tp/DeveloperGuide.html#missingcorrupted-data-files): Manual 
  Testing with corrupted files.


### Contributions to team-based tasks
- Constantly improving the defensiveness of the code by finding bugs.
- Create User Guide and ensure it is formatted and up-to-date. 
- Documentation of Methods.
- Update of README to provide a summary of UG.
- Ensure that the website deployments of README, User Guide and Developer Guide is accurately displayed.

### Contributions beyond the project team
- Bugs Review for other teams: [CS2113-T15-1](https://github.com/nus-cs2113-AY2324S2/tp/pull/44)
