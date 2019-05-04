# ClassicModels

UI with some functionallity thats allows to access data from classicmodels database.

Requirements:
- You will need the latest NetBeans IDE
- And the latest JDK
- MySQL Server
- MySQL Workbench

1. Git Clone the repository into a folder.
Inside the folder you want to recreate the repository, right click and launch a new git bash Git bash (Git Bash here). Then type:
$ git clone https://github.com/osgarc/ClassicModelsUI.git

A new folder called ClassicModelUI will be created.

2. Re-Create de database with the data inside the script 'ClassicModelUI\DB_Classicmodels_tuned\db_classicmodel_tuned.sql'
Open the script in MySQL Workbench and Run it.
A new database called 'db_classicmodel_tuned' will be created. It is the same as the classicmodels database but with some modifications.

3. In NetBeans IDE, open the project and run it.
Go to File->Open Project and select the folder where ClassicModelUI is.

4. Run the application and test everything you can.

5. As you do actions in the application, go to MySQL Workbench and see the changes done to the tables of the database.
For instance, when buying something (check tables orders and orderdetails).
