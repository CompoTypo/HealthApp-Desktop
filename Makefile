run:
	rm -rf ./build/  
	javac ./src/*.java -d ./build/  
	java -cp ./build/ LoginFrame  

test:
	rm -rf ./test/  
	javac ./src/test/*.java -d ./test/  
	java ./test/* -jar junit-4.10.jar

