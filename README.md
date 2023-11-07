# Game of Tennis Refactoring Kata

# Time Limit

1 hour (60 mins)

# Situation

The Wimbledon Tennis Company employed a software developer to create a tennis scoring application.

Unfortunately, the developer has taken a new job before the application could be declared finished.

You have been hired by the company to evaluate the codebase of this application and make any necessary changes to it.

The desired outcome of this should be that the application functions and performs to the specified business requirements.

# Business Rules 

The application uses the standard scoring rules for Tennis. 

| Points | Description |
|--------|-------------|
| 0      | Love        |
| 1      | Fifteen     |
| 2      | Thirty      |
| 3      | Forty       |
| 4      | Win         |

For a tennis player to win a game, they must win with at least a two point lead.

If the score is tied at 40 to 40 (what is called as a Deuce), a player must earn two consecutive points (an Advantage point and Point) to win the game. 

If the player who has an Advantage point loses the next point, then it reverts back to Deuce once again.

For the sake of simplicity, we are only implementing the scoring of **one** game.

### Example 1 - "Alice wins"

| Action       | Bob | Alice | Output         |
|--------------|-----|-------|----------------|
| Game starts  | 0   | 0     | Love-All       |
| Alice scores | 0   | 15    | Love-Fifteen   |
| Bob scores   | 15  | 15    | Fifteen-All    |
| Alice scores | 15  | 30    | Fifteen-Thirty |
| Alice scores | 15  | 40    | Fifteen-Forty  |
| Alice scores | 15  | Win   | Win for Alice  |

### Example 2 - "Deuce"

| Action       | Bob | Alice | Output         |
|--------------|-----|-------|----------------|
| Game starts  | 0   | 0     | Love-All       |
| Bob scores   | 15  | 0     | Fifteen-Love   |
| Bob scores   | 30  | 0     | Thirty-Love    |
| Alice scores | 30  | 15    | Thirty-Fifteen |
| Alice scores | 30  | 30    | Thirty-All     |
| Alice scores | 30  | 40    | Thirty-Forty   |
| Bob scores   | 40  | 40    | Deuce          |

### Example 3 - "Advantage"

Advantage occurs when both players are at Deuce and one player scores, resulting in them having an advantage.

If they score again, they win.

| Action       | Bob | Alice | Output              |
|--------------|-----|-------|---------------------|
|              | 40  | 40    | Deuce               |
| Alice scores | 40  | Adv   | Advantage for Alice |
| Alice scores | 40  | Win   | Win for Alice       |


# Application Overview

The application is built with **Spring Boot** and provides a single RESTful endpoint to score and report back the score for a given Game of Tennis.

The application also sends the score of the game to be displayed on a scoreboard seen by the audience.

There is no Database or other persistence being used by the application.


