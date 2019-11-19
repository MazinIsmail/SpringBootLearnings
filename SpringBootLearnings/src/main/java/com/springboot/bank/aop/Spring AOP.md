
    
    
   Aspect :
    Aspect-oriented programming approaches provide explicit abstractions for the modular implementation of concerns in design, code, documentation, or other artifacts developed during the software life-cycle. 
    These modularized concerns are called aspects, and aspect-oriented approaches provide methods to compose them.
    In computing, aspect-oriented software development (AOSD) is a software development technology that seeks new modularizations of software systems in order to isolate secondary or supporting functions from the main program's business logic. 
    AOSD allows multiple concerns to be expressed separately and automatically unified into working systems.
    
    
   Concern :
    In computer science, a concern is a particular set of information that has an effect on the code of a computer program. 
    A concern can be as general as the details of database interaction or as specific as performing a primitive calculation, depending on the level of conversation between developers and the program being discussed. 
    IBM uses the term concern space to describe the sectioning of conceptual information.
    
    
   Cross-cutting concern :
    Cross-cutting concerns are parts of a program that rely on or must affect many other parts of the system. 
    They form the basis for the development of aspects.
    Such cross-cutting concerns do not fit cleanly into object-oriented programming or procedural programming.
    Cross-cutting concerns can be directly responsible for tangling, or system inter-dependencies, within a program. 
    Because procedural and functional language constructs consist entirely of procedure calling, there is no semantic through which two goals (the capability to be implemented and the related cross-cutting concern) can be addressed simultaneously.
    As a result, the code addressing the cross-cutting concern must be scattered, or duplicated, across the various related locations, resulting in a loss of modularity
    Aspect-oriented programming aims to encapsulate cross-cutting concerns into aspects to retain modularity.
    
    
   Joinpoint: 
    A joinpoint is a candidate point in the Program Execution of the application where an aspect can be plugged in. 
    This point could be a method being called, an exception being thrown, or even a field being modified. 
    These are the points where your aspect’s code can be inserted into the normal flow of your application to add new behavior.

   Advice: 
    This is an object which includes API invocations to the system wide concerns representing the action to perform at a joinpoint specified by a point.

   Pointcut: 
    A pointcut defines at what joinpoints, the associated Advice should be applied. 
    Advice can be applied at any joinpoint supported by the AOP framework. 
    Of course, you don’t want to apply all of your aspects at all of the possible joinpoints. 
    Pointcuts allow you to specify where you want your advice to be applied. 
    Often you specify these pointcuts using explicit class and method names or through regular expressions that define matching class and method name patterns. 
    Some AOP frameworks allow you to create dynamic pointcuts that determine whether to apply advice based on runtime decisions, such as the value of method parameters.
    
   JoinPoint: 
    Joinpoint are points in your program execution where flow of execution got changed like Exception catching, Calling other method. 
  
   PointCut: 
    PointCut are basically those Joinpoints where you can put your advice(or call aspect). ... 
    A point cut can be considered as a collection of multiple joint points.
    PointCut is a set of one or more JoinPoint where an advice should be executed. 
    You can specify PointCuts using expressions or patterns as we will see in our AOP examples. 
    In Spring, PointCut helps to use specific JoinPoints to apply the advice.
    
   A join point is a point in the control flow of a program where the control flow can arrive via two different paths(IMO : that's why call joint).

   Advice describes a class of functions which modify other functions

   A pointcut is a set of join points.


