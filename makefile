build:
    rm -rf ./build/
	javac ./src/frames/*.java ./src/models/*.java ./src/utilities/*.java -d ./build/ -Xlint 

exec:
	java -cp ./build/ Main  

quick:
	rm -rf ./build/
    javac ./src/*.java
	java -cp ./src/ Main

junit:
    rm -rf ./test/ ./build/
	javac ./src/frames/*.java ./src/models/*.java ./src/utilities/*.java -d ./build/  
	javac ./src/test/*.java -d ./test/  
	java ./test/* ./build/ -jar junit-4.10.jar
serve:
    node ./src/backend/aplite.js

mocha:
	mocha ./src/test/apiTest.js


