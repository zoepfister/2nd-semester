# Console Output

    Some other Exception: java.lang.IllegalArgumentException
    Ex1 or Ex4
    Ex2 or Ex5
    Ex1 or Ex4
    Ex2 or Ex5
    Exception in thread "main" java.lang.IllegalArgumentException: ExceptionChaining$Ex6
            at ExceptionChaining.main(ExceptionChaining.java:26)
            at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
            at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
            at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
            at java.lang.reflect.Method.invoke(Method.java:497)
            at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
    Caused by: ExceptionChaining$Ex6
            at ExceptionChaining.throwSomething(ExceptionChaining.java:15)
            at ExceptionChaining.main(ExceptionChaining.java:24)
            ... 5 more
    
    Process finished with exit code 1

