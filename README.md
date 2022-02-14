# **Movie Database creation using SQLite and JDBC driver.**

### **Steps to run repository in vs code :**
1. Download this current repository
2. Add [jdbc driver](http://www.java2s.com/Code/Jar/s/Downloadsqlitejdbc372jar.htm) (jar file) to current directory \
3. In cmd prompt or vs code terminal, change path to current folder 
4. compile Main.java file using \
     &nbsp;&nbsp; &nbsp;&nbsp;
     **cmd** : *javac Main.java* \
5.Then, run jdbc sqlite driver using \
      &nbsp;&nbsp; &nbsp;&nbsp; 
      **cmd** : *java -classpath ".;sqlite-jdbc-3.36.0.3.jar" Main*
      
      
 
### Output:
##### (Note :After running the file...... "movie.db" file gets created.)
#### File structure after compiling and connecting to SQLite DB using JDBC driver :
![image](https://user-images.githubusercontent.com/85562020/153927123-ecce9658-4442-4b6f-a77e-f8f5bc404c2e.png)

### Case 1: Querying for all parameters
![image](https://user-images.githubusercontent.com/85562020/153927355-21a4de2e-08c4-4684-9083-47068e23bfd2.png)

### Case 2: Querying only specific parameters
![image](https://user-images.githubusercontent.com/85562020/153927982-50a7fb43-ad2c-414c-a6b6-4ac9901e513b.png)
