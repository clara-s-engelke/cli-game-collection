# 🎮 JAVA TERMINAL GAME COLLECTION
A collection of small terminal-based games written in Java.
This project was created to practice core programming concepts such as object-oriented programming, basic file I/O and control flow

---
## ▶️ STATUS
✅ Finished

This learning project is finished, although I am aware of its limitations and imperfections.

---

## 💡 INCLUDED GAMES
Games that are currently included and their game-features:
- Number Guesser
  - different difficulties
  - hints on the number
- Tic Tac Toe
  - working tic tac toe field displaying the current state
  - option to play against another human or the computer (random placement)
- Hangman
  - chooseable categories (including a "surprise me!"-category)
  - displaying the current progress on the word, letters that have been used as well as ASCII-Art for the hangman

---

## ▶️ How to run

### Requirements
- **Java 21 (JDK)** installed (`java -version` should show 21.x)
- Any terminal (Windows Terminal / macOS Terminal / Linux shell)

### 1) Get the code
```bash
git clone https://github.com/clara-s-engelke/cli-game-collection.git
cd cli-game-collection
```

### 2) Compile
This project uses plain `javac` (no Maven/Gradle yet).

**macOS / Linux:**
```bash
mkdir -p bin
find src -name "*.java" | xargs javac -d bin
```

**Windows (PowerShell):**
```powershell
New-Item -ItemType Directory -Force bin | Out-Null
Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName } | javac -d bin @-
```

### 3) Run
```bash
java -cp bin gameMenu.Main
```

### Troubleshooting
- If you get `Could not find or load main class gameMenu.Main`, re-run the compile step and make sure you’re in the project root directory.
- If `java -version` shows an older version, install **JDK 21** and try again.

---

## 🔧 TOOLS
Following tools are/were used in this repo:
- Java (21 JDK)
- IntelliJ IDEA (2025)
- Git/GitHub

---

## 📌 NOTES
This project is part of me learning Java and the preparation for studying cs.
The code/architecture is most likely flawed and will change as I learn new concepts.
Any feedback or suggestions are more than welcome :)

---
