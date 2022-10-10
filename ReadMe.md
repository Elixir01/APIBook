# Demo Project Book API

why to use graphql?

designed to make APIs fast, flexible, and developer-friendly.
It lets developers construct requests that` pull data from multiple data sources in a single API call.`
GraphQL self documenting exist and rest are not.

In graph ql,
there are only `two types of operations you can perform: queries and mutations`.


queries are to fetch data.


mutations to modify server side data.

If queries are the graphQL equivalent to GET calls in the REST, then mutations represent the state changing methods in REST(like DELETE, PUT, PATCH)

One true difference between a query and a mutation, at least structurally, is the operation type.
We use the word query for queries and mutation for mutations.


BETTER UNDERSTANDING: https://www.apollographql.com/blog/graphql/basics/mutation-vs-query-when-to-use-graphql-mutation/

|                           | GraphQL    | REST  |
| ------- | --- | --- |
| Architecture              | client-driven | server-driven |
| Organized in terms of     | schema and type-system | endpoints |
| Operations                | query mutation subscription | create, read, update, delete |
| Data fetching             | specific data with single api call | fixed data with multiple API calls |
| Community                 | growing | large |
| Performance               | fast | multiple network calls take up more time |
| Development Speed         | rapid | slower |
| Learning curve            | difficult | moderate |
| Self-documenting          | yes  | no |
| File uploading            | no | yes |
| Web Caching               | (via libraries built on top) Apollo | yes |
| Stability                 | less error prone, automatic validation and type checking  | better choice for complex queries |
| use cases                 | multiple microservices, mobile apps | simple apps, resource-driven apps |

In short, GraphQL is a tool to achieve specific query oriented goals; however, it’s not a solution for all the API related challenges and certainly not a replacement for REST.


### Intro
Demo POC project for GraphQl + Spring Boot. 
The project uses graphql to create a simple book and author schema to demonstrate the use of GraphQl
Query, Mutation functionality.

### Requirements
- Java 11
- Basic Knowledge of GraphQl and Spring boot
- Intellij or IDE of your choice
- Postman for testing the API

### What is GraphQl?

GraphQl is a query language that can be used to develop APIs which uses a different approach than the trditional
REST APIs. Unlike traditional REST APIs GraphQl allows the client to specify which data required and thus allowing multiple 
queries in a single request. This helps to develop light weight manageable APIs. 

Official documentation: [GraphQL](https://graphql.org/)

### How to execute
To run the project and execute queries follow below steps:
 * maven clean build
 * 
``
mvn clean build
 ``
 * In terminal cd the Root folder of project where we have docker-compose.yml
 * 
``
docker-compose up -d
 ``
 * the endpoint exposed at : [localhost](http://localhost:8080/graphql)
 * postman or any Http client can be used to test the graphql queries

To stop all containers

``
docker-compose down
``

 
 ###  Example of some queries/mutations:
Note all queries and mutations in GraphQl are post Http requests.

#### Why only Post?
Well, there are few reasons:
* GraphQl itself is transport-agnostic, it's not specific to HTTP. A GraphQl service can execute documents outside the context of network requests.
* There is no body in a GET request, which means the query, variables and operation name all have to be set through query parameters which
  can easily cause server to return 414 status(URI too long)


##### Query example 
 get all books
 ```
  query {
  allBook{
    id
    name
    pageCount
  }
  }
```

get book with author
``` 
   query {
   allBook{
        id
       name
       pageCount
       author{
         id
         firstName
         lastName
  
       }
   }
   }
```
The output of this request is as follows:
![allBook](/img/allBook.png)

* Mutation example

create new book
```
  mutation {
  newBook(name:"Scrum Master", pageCount:"250"){
    id
    name
    pageCount
  }
  }
``` 

delete book
```
  mutation {
  deleteBook(id:3){
    id
    name
    pageCount
  }
  }
```
Response:
![deleteBook](/img/deleteBook.png)