# Student Record Keeper

- A Java-based Database Management System to manage student records.

## Coding Language

- Java 

## Topic covered
- Inheritance
- Runtime Polymorphism
- Abstraction
- Encapsulation
- Collection

## src/customException
  
  - This project has a custom exception to handle errors gracefully.

  - __InvalidChoiceException.java__ 

    - It extends RuntimeException with acts as unchecked exception, this exception get invoked whenever there invalid for the option.

  - __StudentNotFoundException.java__ 

    - It extends Exception with acts as checked exception, this exception get invoked whenever student with particular id is not found.

## src/customSorting
  - This package has the classes for customized sorting the student records based on.

  - __SortStudentByAge.java__ 
  
     - This is a class which implements comparator interface and overrides the compare method and has business logic to sort student by Age.
  
  - __SortStudentById.java__
  
    - This is a class which implements comparator interface and overrides the compare method and has business logic to sort student by Id.
  
  - __SortStudentByMarks.java__
  
    - This is a class which implements comparator interface and overrides the compare method and has business logic to sort student by Marks.
  
  - __SortStudentByName.java__ 
  
    - This is a class which implements comparator interface and overrides the compare method and has business logic to sort student by Name.

## src/sdbms
  
  - This package has the some classes for implementation part.

  - __SolutionStudent.java__
  
    - This is an object utilization layer where service are provided.
 
  - __Student.java__
 
    - This is a bean/POJO class which has attributes like id,age,name,marks to store student records and id is auto generated using constructor.
 
  - __StudentManagementSystem.java__
 
    - This is a interface which some abstract methods.
    
  - __StudentManagementSystemImpl.java__ 
  
    - This is combination of object creation and implementation layer where the actual logic is implemented for overriden methods of interface.
    - Used a Linked HashMap to store and manage student records.
    - Developed various functions to manage student records including adding or removing student details, displaying single or multiple student records with respect to id, updating student details based on id,counting the total number of students in likedhashmap.


