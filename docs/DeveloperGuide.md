# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Tracking Exercise Feature
- Create a CSV which stores data regarding how many calories are burnt per hour for each exercise type (eg. swimming, running, cycling).
- Implement a 'track exercise' function which will be parsed with the format:
  track exercise t/{type of exercise} d/{duration of exercise}
- Parse the command
- Using a hashmap, access the data regarding the amount of calories burnt per hour for the given exercise and calculate the total calories burnt for the given duration.
- Store the total calories burnt through exercise in the User class


## Product scope
### Target user profile
- Have a need to manage their dietary intake and exercise routines effectively.
- Prefer desktop applications over other types of platforms.
- Can type quickly and prefer typing over mouse interactions.
- Are reasonably comfortable using command-line interface (CLI) applications.

### Value proposition

The fitness app aims to help users manage their dietary habits and exercise routines more efficiently compared to traditional GUI-driven apps. 
By offering a streamlined interface optimized for keyboard input and CLI interactions, users can track their meals, drinks, and exercises swiftly, allowing them to focus more on their fitness goals and less on navigating through complex user interfaces.

## User Stories

| Priority | As a ... | I want to ...          | So that I can ...                                      |
|----------|----------|------------------------|--------------------------------------------------------|
| ***      |new user| see usage instructions | refer to them when I forget how to use the application |
| ***      |user| add a meal | track my daily calorie intake                          |

## Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java 11 or above installed.
2. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

## Glossary

* *meal* - Any food consumed.
* *drink* - Any beverage consumed.
* *exercise* - Any physical activity performed.
* *calories* - Measure of energy derived from food.
* *carbohydrates* - Macronutrient providing energy.
* *proteins* - Macronutrient essential for growth and repair.
* *fat* - Macronutrient important for energy storage and insulation.
* *sugar* - Simple carbohydrate often added to food for sweetness.
* *fiber* - Indigestible plant material aiding digestion.
* *water* - Essential liquid for hydration and bodily functions.


## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
