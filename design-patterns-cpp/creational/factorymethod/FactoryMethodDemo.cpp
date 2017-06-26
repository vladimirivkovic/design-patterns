//
// Created by ragnar on 26.6.17..
//

#include <iostream>
#include <string.h>

using namespace std;

// Abstract base class declared by Framework
class Document {
public:
    Document(char *fn) {
        strcpy(name, fn);
    }

    virtual void open() = 0;
    virtual void close() = 0;

    char* getName() {
        return name;
    }

private:
    char name[20];
};

// Concrete derive class defined by client
class MyDocument: public Document {
public:
    MyDocument(char *fn) : Document(fn) {}

    void open() {
        cout << "   MyDocument:open()" << endl;
    }

    void close() {
        cout << "   MyDocument:close()" << endl;
    }
};

// Framework declaration
class Application {
public:
    Application() : _index(0) {
        cout << "Application:ctor" << endl;
    }

    // The client will call this "entry point" of the framework
    void newDocument(char *name) {
        cout << "Application: NewDocument()" << endl;
        // Framework calls the "hole" reserved for client customization
        _docs[_index] = createDocument(name);
        _docs[_index++]->open();
    }

    void openDocument() {}
    void reportDocs();

    //Framework declared a "hole" for the client to customize
    virtual Document* createDocument(char*) = 0;

private:
    int _index;
    // Framework uses Document's base class
    Document *_docs[10];
};

void Application::reportDocs() {
    cout << "Application:reportDocs()" << endl;
    for (int i = 0; i < _index; i++)
        cout << "  " << _docs[i]->getName() << endl;
}

// Customization of framework define by client
class MyApplication : public Application {
public:
    MyApplication() {
        cout << "MyApplication:ctor" << endl;
    }

    // Client defines Framework's "hole"
    Document* createDocument(char *fn) {
        cout << "   MyApplication:createDocument()" << endl;
        return new MyDocument(fn);
    }
};

int main() {
    // Client's customization of the Framework
    MyApplication myApp;

    myApp.newDocument("foo");
    myApp.newDocument("bar");
    myApp.reportDocs();
}