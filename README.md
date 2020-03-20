# octo_events

### About
This example is being used to receive an HTTP POST every time an issue is being created, edited or deleted in this repository. This method is called `Webhook`

More information about Webhooks:
* [Webhooks](https://developer.github.com/webhooks/)

### Database Setup
This example are using [PostgreSQL](https://www.postgresql.org/) database.

After installing PostgreSQL, you have to create a database and inside this create a table using the command below:
```sh
create table event(
	id serial primary key,
	action varchar(10) not null,
	number integer not null,
	title varchar(100) not null,
	created_at varchar(20) null,
	updated_at varchar(20) null,
	closed_at varchar(20) null
);
```

### Run project
After configuring database you can use your favorite IDE to import the project.

Inside the folder `sample-webhook-github\src\main\resources\` you have to open the file `application.properties` and edit those properties below:

`spring.datasource.url=[jdbc:postgresql://IP:PORT/DATABASE]`

`spring.datasource.username= [USER]`

`spring.datasource.password=[PASSWORD]`

After that just open the class `br.com.rodrigoluisfaria.samplewebhookgithub.RestServiceApplication` and execute as a Java Application.

### Run with Maven

With you want to run project outside any IDE, just go to a command line and run the command below:

`./mvnw spring-boot:run`

### APIs

#POST [http://localhost:80/](http://localhost:80/)

Content-Body:
```sh
{
  "action": "opened",
  "issue": {
    "number": 1,
    "title": "Another issue",
    "created_at": "2020-03-15T11:57:24Z",
    "updated_at": "2020-03-15T11:57:24Z",
    "closed_at": null,
  }
}
```

#GET [http://localhost:80/issues/{event_number}/events](http://localhost:80/issues/{event_number}/events)

{event_number} = you pass the number of the issue that you want to retrieve information.
