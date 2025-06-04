@echo off
REM Test script for Person Management System
REM This script runs the complete test suite and generates reports

echo === Person Management System Test Runner ===
echo Running Maven clean test...

REM Run the tests
call mvn clean test

REM Check if tests passed
if %ERRORLEVEL% == 0 (
    echo ✅ All tests passed!
    echo.
    echo 📊 Test Reports Generated:
    echo   - XML Report: target/surefire-reports/TEST-PersonTest.xml
    echo   - Text Report: target/surefire-reports/PersonTest.txt
    echo.
    echo 📁 Test report files:
    dir target\surefire-reports\
) else (
    echo ❌ Tests failed!
    exit /b 1
)
