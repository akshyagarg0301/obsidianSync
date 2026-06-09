- Transactions are atomic unit of work. Transactions are something which helps us build systems which are correct. 
- The relational databases are famous because of ACID properties.
- ACID properties are:- Atomicity, Consistency, Isolation, Durability
- Atomicity- A transaction is an atomic unit of work. It is either completed or not completed. It is not in between. All statements within
             a txn takes effect or none.
- Consistency - A transaction must leave the database in a consistent state. Data will never go incorrect no matter what constraints, cascades, triggers.
               example- foreign key checks do not allow you to delete parent if child exist
- Durability - A transaction must leave the database in a durable state. Once a transaction is completed, it cannot be undone.
- Isolation - A transaction must leave the database in an isolated state. When multiple txns are executing parallely the isolation level
              determines how much changes of one txn are visible to other. Mostly repeatable reads isolation is used in applications.
- We pick relational databases for relational and acid properties.

- Set up SQL database (PostgreSQL)
- Create a schema for a social network (users, posts, profile, photos, following) define relationships between them. add constraints.
- insert data in (user and profile in one transaction). Try killing database and see how it behaves

Installing PostgreSQL:-
1. brew install postgresql@15
2. brew services start postgresql@15
3. psql -d postgres
4. \l to show all databases 
5. \c mydb to use mydb
6. \dt to show all tables
7. \q exit
8. CREATE DATABASE SOCIAL_NETWORK; to create db
9. \c SOCIAL_NETWORK to use db
10. 