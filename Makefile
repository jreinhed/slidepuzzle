JAVAC = javac
JAVA = java
JAR = jar

SRCS = $(wildcard *.java)
CLASSES = $(SRCS:.java=.class)

JARFILE = slidepuzzle.jar
MANIFEST = manifest.txt

all: $(JARFILE)

$(JARFILE): $(MANIFEST) $(CLASSES) 
	$(JAR) cvfm $@ $^

%.class: %.java
	$(JAVAC) $<

clean:
	rm -rf $(JARFILE) $(CLASSES)

.PHONY: all clean
