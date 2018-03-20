setx NLS_LANG "KOREAN_KOREA.UTF8" /M
chcp 65001
sqlplus scott/tiger @"%~dp0\MIX LOAD TEST DRIVER TABLE.sql"
