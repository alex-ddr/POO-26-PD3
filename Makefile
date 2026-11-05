SOURCES = $(wildcard src/*.java)
BUILD_DIR = build
MAIN = src.CalcMVC

.PHONY: all compile run clean

all: compile

compile:
	mkdir -p $(BUILD_DIR)
	javac -d $(BUILD_DIR) $(SOURCES)

run: compile
	java -cp $(BUILD_DIR) $(MAIN)

clean:
	rm -rf $(BUILD_DIR)
