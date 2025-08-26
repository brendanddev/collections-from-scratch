# Collections From Scratch

This project explores **Data Structures and Collections in Java** by implementing them from scratch, without using the Java Collections Framework (JCF).

---

## Overview

This repository contains implementations of common data structures such as lists, sets, maps, stacks, queues, heaps, and trees.  
Each data structure is built from first principles, including custom iterators and benchmarking utilities to compare performance.

---

## Features

- Core abstractions (`CustomCollection`, `CustomIterator`)  
- Array-based and linked implementations (`CustomArrayList`, `CustomLinkedList`)
- Hash-based Collections (`CustomHashSet`, `CustomHashMap`)
- Stack, Queue, and Deque implementations (`CustomStack`, `CustomQueue`, `CustomDeque`)
- Tree structures (`CustomBinaryTree`)
- Heap implementations (`CustomHeapList`)
- Benchmarking utilities (`Benchmark.java`)  

---

## Project Structure

```
src/main/java/com/brendanddev/collections
│
├── core/ # Shared interfaces & iterators
│ ├── CustomCollection.java
│ └── CustomIterator.java
│
├── list/ # Linear data structures
│ ├── CustomArrayList.java
│ └── CustomLinkedList.java
│
├── set/ # Unique element collections
│ └── CustomHashSet.java
│
├── map/ # Key-Value structures
│ └── CustomHashMap.java
│
├── queue/ # FIFO & Priority queues
│ ├── CustomQueue.java
│ ├── CustomDeque.java
│ └── CustomLinkedPriorityQueue.java
│
├── stack/ # LIFO structure
│ └── CustomStack.java
│
├── heap/ # Binary heap implementations
│ ├── CustomHeap.java
│ └── CustomHeapList.java
│
├── tree/ # Hierarchical structures
│ └── CustomBinaryTree.java
│
├── performance/ # Benchmarking utilities
│ └── Benchmark.java
│
└── Main.java # Entry point for demos/benchmarks
```
