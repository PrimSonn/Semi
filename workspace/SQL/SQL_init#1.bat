--cmd.exe /k chcp 65001
setx NLS_LANG "KOREAN_KOREA.UTF8" /M
chcp 65001
pause
--"%~dp0\SQL_init#2.bat"
--sqlplus scott/tiger @"%~dp0\MIX LOAD TEST DRIVER TABLE.sql"