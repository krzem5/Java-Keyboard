echo off
echo NUL>_.class&&del /s /f /q *.class
cls
javac -cp com/krzem/keyboard/modules/jnativehook-2.1.0.jar; com/krzem/keyboard/Main.java&&java -cp com/krzem/keyboard/modules/jnativehook-2.1.0.jar; com/krzem/keyboard/Main
start /min cmd /c "echo NUL>_.class&&del /s /f /q *.class"