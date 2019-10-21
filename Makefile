build:
	javac ./src/*.java -d ./build/

exec:
	java -cp ./build/ LoginFrame

clean:
	rm -rf ./build/
