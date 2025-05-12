@echo off
setlocal enabledelayedexpansion

:: Clean old class files
if exist out (
    rmdir /s /q out
)
mkdir out

echo Compiling core files...
javac -d out ^
    demo\src\main\java\com\oop\assignment1\TicTacToeModel.java ^
    demo\src\main\java\com\oop\assignment1\TicTacToeView.java ^
    demo\src\main\java\com\oop\assignment1\TicTacToeConsole.java

if %errorlevel% neq 0 (
    echo Compile failed!
    pause
    exit /b
)

echo Creating JAR file...
jar cfe TicTacToe.jar com.oop.assignment1.TicTacToeConsole -C out .

echo.
echo Choose which version to run:
echo 1. Console version
echo 2. GUI version
set /p choice="Enter your choice (1 or 2): "

if "%choice%"=="1" (
    echo Running Console version...
    java -cp TicTacToe.jar com.oop.assignment1.TicTacToeConsole
) else if "%choice%"=="2" (
    echo Running GUI version...
    java -cp TicTacToe.jar com.oop.assignment1.TicTacToeView
) else (
    echo Invalid choice. Meow!
)

pause
