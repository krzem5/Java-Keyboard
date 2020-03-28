echo off
cls
mkdir build
javac -cp com/krzem/keyboard/modules/jnativehook-2.1.0.jar; -d build/ com/krzem/keyboard/Main.java
cd build
jar cmf manifest.mf Keyboard.jar com/krzem/keyboard/*.class ../com/krzem/keyboard/modules/ org/*
cd ../