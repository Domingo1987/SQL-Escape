# Anexo: Diagramas UML

Este anexo conserva el código PlantUML de los diagramas del proyecto. Puede copiarse en un visor compatible para generar las imágenes.

## Diagrama de Casos de Uso

```plantuml
!theme plain
title Diagrama de Casos de Uso - SQL Escape
left to right direction
actor "Jugador/Estudiante" as Jugador
actor "Docente" as Docente
actor "Sistema de Evaluación" as Sistema
rectangle "SQL Escape Game" {
    usecase "Iniciar Partida" as UC01
    usecase "Resolver Desafío SQL" as UC02
    usecase "Validar Consulta SQL" as UC03
    usecase "Avanzar de Nivel" as UC04
    usecase "Guardar Progreso" as UC05
    usecase "Consultar Historial" as UC06
    usecase "Reiniciar Partida" as UC07
    usecase "Visualizar Resultados" as UC08
    usecase "Cargar Nivel" as UC09
    usecase "Evaluar Respuesta" as UC10
    usecase "Mostrar Narrativa" as UC11
    usecase "Registrar Intento" as UC12
}
Jugador --> UC01
Jugador --> UC06
Jugador --> UC07
Docente --> UC06
Sistema --> UC03
UC01 ..> UC09 : <<include>>
UC09 ..> UC02 : <<include>>
UC02 ..> UC03 : <<include>>
UC02 ..> UC08 : <<include>>
UC03 ..> UC10 : <<include>>
UC10 ..> UC04 : <<extend>>
UC04 ..> UC05 : <<include>>
UC04 ..> UC09 : <<include>>
UC02 ..> UC11 : <<include>>
UC03 ..> UC12 : <<include>>
```

## Diagrama de Clases

```plantuml
!theme plain
title Diagrama de Clases - SQL Escape
package "SQL Escape Game" {
    class SqlEscapeGame {
        - currentPlayer: Player
        - currentLevel: Level
        - gameState: GameState
        - database: GameDatabase
        - sqlEvaluator: SqlEvaluator
        + startGame(): void
        + loadGame(playerId: int): void
        + restartGame(): void
        + getCurrentLevel(): Level
        + processPlayerInput(query: String): QueryResult
        + saveProgress(): boolean
        + exitGame(): void
    }
    class Player {
        - playerId: int
        - playerName: String
        - currentLevel: int
        - totalScore: int
        - gameStartTime: Date
        - lastPlayTime: Date
        + Player(name: String)
        + getId(): int
        + getName(): String
        + getCurrentLevel(): int
        + setCurrentLevel(level: int): void
        + getScore(): int
        + addScore(points: int): void
        + updateLastPlayTime(): void
        + getPlayTime(): long
    }
    class PlayerProgress {
        - progressId: int
        - playerId: int
        - levelId: int
        - isCompleted: boolean
        - attempts: int
        - completionTime: Date
        - bestQuery: String
        + PlayerProgress(playerId: int, levelId: int)
        + markAsCompleted(): void
        + incrementAttempts(): void
        + setBestQuery(query: String): void
        + getAttempts(): int
        + isLevelCompleted(): boolean
    }
    class Level {
        - levelId: int
        - levelNumber: int
        - title: String
        - narrative: String
        - challenge: Challenge
        - isUnlocked: boolean
        - requiredLevel: int
        + Level(id: int, number: int, title: String)
        + getId(): int
        + getNumber(): int
        + getTitle(): String
        + getNarrative(): String
        + getChallenge(): Challenge
        + isAccessible(playerLevel: int): boolean
        + unlock(): void
    }
    class Challenge {
        - challengeId: int
        - description: String
        - expectedQuery: String
        - expectedResult: ResultSet
        - hints: List<String>
        - difficulty: DifficultyLevel
        - points: int
        + Challenge(id: int, description: String)
        + getDescription(): String
        + getExpectedResult(): ResultSet
        + addHint(hint: String): void
        + getHints(): List<String>
        + getPoints(): int
        + getDifficulty(): DifficultyLevel
    }
    class SqlEvaluator {
        - databaseConnection: Connection
        - syntaxValidator: SqlSyntaxValidator
        + SqlEvaluator(connection: Connection)
        + validateQuery(query: String): ValidationResult
        + executeQuery(query: String): QueryResult
        + compareResults(expected: ResultSet, actual: ResultSet): boolean
        + evaluateChallenge(query: String, challenge: Challenge): EvaluationResult
        + getSyntaxErrors(query: String): List<String>
    }
    class SqlSyntaxValidator {
        - allowedCommands: Set<String>
        + validateSyntax(query: String): ValidationResult
        + isSelectQuery(query: String): boolean
        + hasValidTables(query: String): boolean
        + hasValidColumns(query: String): boolean
        + checkForbiddenCommands(query: String): List<String>
    }
    class QueryResult {
        - resultSet: ResultSet
        - isSuccessful: boolean
        - errorMessage: String
        - executionTime: long
        - rowCount: int
        + QueryResult(resultSet: ResultSet)
        + QueryResult(errorMessage: String)
        + isSuccessful(): boolean
        + getResultSet(): ResultSet
        + getErrorMessage(): String
        + getRowCount(): int
        + getExecutionTime(): long
    }
    class ValidationResult {
        - isValid: boolean
        - errors: List<String>
        - warnings: List<String>
        + ValidationResult(isValid: boolean)
        + addError(error: String): void
        + addWarning(warning: String): void
        + getErrors(): List<String>
        + getWarnings(): List<String>
        + hasErrors(): boolean
    }
    class EvaluationResult {
        - isCorrect: boolean
        - score: int
        - feedback: String
        - queryResult: QueryResult
        - validationResult: ValidationResult
        + EvaluationResult(isCorrect: boolean, score: int)
        + getFeedback(): String
        + setFeedback(feedback: String): void
        + getScore(): int
        + isCorrect(): boolean
    }
    class GameDatabase {
        - connection: Connection
        - connectionUrl: String
        - username: String
        - password: String
        + GameDatabase(url: String, user: String, pass: String)
        + connect(): boolean
        + disconnect(): void
        + executeQuery(sql: String): ResultSet
        + executeUpdate(sql: String): int
        + getConnection(): Connection
        + isConnected(): boolean
    }
    class PlayerDAO {
        - database: GameDatabase
        + PlayerDAO(database: GameDatabase)
        + findById(id: int): Player
        + findByName(name: String): Player
        + save(player: Player): boolean
        + update(player: Player): boolean
        + delete(id: int): boolean
        + getAllPlayers(): List<Player>
    }
    class ProgressDAO {
        - database: GameDatabase
        + ProgressDAO(database: GameDatabase)
        + findByPlayer(playerId: int): List<PlayerProgress>
        + findByLevel(levelId: int): List<PlayerProgress>
        + save(progress: PlayerProgress): boolean
        + update(progress: PlayerProgress): boolean
    }
    class GameFacade {
        - game: SqlEscapeGame
        - playerDAO: PlayerDAO
        - progressDAO: ProgressDAO
        + startGame(): void
        + loadPlayer(id: int): void
        + processQuery(query: String): EvaluationResult
    }
    class GameController {
        - facade: GameFacade
        + handleQuery(query: String): void
        + showLevel(): void
    }
    class GameView {
        + displayMessage(msg: String): void
        + getUserQuery(): String
    }
    GameController --> GameFacade
    GameController --> GameView
    GameFacade --> SqlEscapeGame
    GameFacade --> PlayerDAO
    GameFacade --> ProgressDAO
}
```

