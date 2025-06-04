#!/bin/bash

# Test script for Person Management System
# This script runs the complete test suite and generates reports

echo "=== Person Management System Test Runner ==="
echo "Running Maven clean test..."

# Run the tests
mvn clean test

# Check if tests passed
if [ $? -eq 0 ]; then
    echo "✅ All tests passed!"
    echo ""
    echo "📊 Test Reports Generated:"
    echo "  - XML Report: target/surefire-reports/TEST-PersonTest.xml"
    echo "  - Text Report: target/surefire-reports/PersonTest.txt"
    echo ""
    echo "📁 Test report files:"
    ls -la target/surefire-reports/
else
    echo "❌ Tests failed!"
    exit 1
fi
