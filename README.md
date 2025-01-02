# Binary Search Trees - Project 4

## Description

This project implements a **binary search tree (BST)** using a dataset containing information about 145 countries. The information includes country names, GDP per capita, population, and more. The program performs various operations on the binary search tree including insertion, deletion, searching, and different tree traversal methods. It is designed to allow the user to interact with the tree through a command-line interface.

### Data Source

The dataset, `Countries4.csv`, contains data about the following:

- **Country Names**
- **Capitol Cities**
- **Population (2020)**
- **GDP (2020) in USD**
- **COVID-19 Cases and Deaths as of August 30, 2022**
- **Area in km²**

The program uses this data to populate a binary search tree where the country names act as the key.

---

## Features

- **Binary Search Tree (BST) Implementation**: Uses the country name as the key for the BST.
- **Inorder, Preorder, and Postorder Traversals**: Supports all three common tree traversal methods to print the countries.
- **Insert and Delete Operations**: Allows for insertion and deletion of nodes (countries) from the BST.
- **Find Operation**: Searches for a country by name and prints its data along with the path to the node.
- **Top and Bottom GDP countries**: Finds and prints the top and bottom `c` countries by GDP per capita.

