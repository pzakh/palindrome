@echo off
call clean.bat
call compile.bat

mkdir build
cd build
mkdir lib
cd ..

cp target/*.jar build/lib/
cp start.bat build/	