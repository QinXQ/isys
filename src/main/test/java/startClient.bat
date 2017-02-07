if not exist D:\client md D:\client
copy Client.java D:\client\
copy ReadWorker.java D:\client\
copy WriteWorker.java D:\client\

javac D:\client\Client.java
javac D:\client\ReadWorker.java
javac D:\client\WriteWorker.java

cd /d d:\client

java Client

pause
