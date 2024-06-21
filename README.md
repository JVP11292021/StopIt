# StopIt
App for helping peaople stop with smoking

## How to use it
> [!IMPORTANT]
> Make sure you have docker installed in order to run the application locally

Run the application locally by following these steps:

##### Step 1:
Clone the repository.
```bash
https://github.com/JVP11292021/StopIt.git
```

##### Step 2:
Navigate to the correct directory, replace the `PATH` secret with the place you cloned the repository.
```bash
cd ./PATH/StopIt/server-side
```

##### Step 3:
> [!NOTE]
> Make sure you have maven 3.x installed locally on your machine
Build the application by using a project builder, like maven.
```bash
mvn clean install -X
```

##### Step 4:
Now we can run the application using docker, by the following command:
```bash
docker compose up
```
