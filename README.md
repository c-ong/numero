Numero
======

Given any number, convert to plain english:  
1 = one  
33 = thirty three  
635 = six hundred and thirty five  
76876586 = seventy six million eight hundred and seventy six thousand five hundred and eighty six  

Aims
----
* Create concise, simple solution  
* Test driven development

Approach
--------
* Represent units, teens and tens as an array  
* Break integer down into chunks ie. millions, thousands, hundreds etc  
* Map blocks onto array ie.  112 = units[1] hunderd and units[(12-10)] 
* Worry about the placement of "and's"  
* Refactor refactor refactor  


    private String [] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };  
    private String [] teens = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };  
    private String [] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };  
    


To build and run the test suite:  
mvn clean install

java -cp target/numero-1.0.jar NumFormatter <number>
