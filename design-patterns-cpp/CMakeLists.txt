cmake_minimum_required(VERSION 3.7)
project(design_patterns_cpp)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES creational/abstractfactory/example1/shapes.cpp creational/abstractfactory/example2/beforeAF.cpp creational/abstractfactory/example2/afterAF.cpp creational/builder/builder.cpp creational/factorymethod/FactoryMethodDemo.cpp)
add_executable(design_patterns_cpp ${SOURCE_FILES})