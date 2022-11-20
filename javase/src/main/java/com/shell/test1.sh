#!/bin/bash
file="C:/helloworld.sh"
if[-r $file];then
    echo "文件可读"
else
    echo "文件不可读"