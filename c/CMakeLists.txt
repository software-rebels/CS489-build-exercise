# Set the minimum version of CMake that will be supported by this build file
cmake_minimum_required(VERSION 2.6)

# Give the project a name
project(cmakeExercise2)

include_directories(include)

# Add an executable that is made up of the three C source files
add_executable(program main.c job.c input.c include/config.h include/input.h include/job.h)