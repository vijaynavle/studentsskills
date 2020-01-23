# People skills Maintenance REst service using Springboot.

Sample student skill REst + Jpa example

Spring configuration file location:
\src\main\resources\application.properties
Please update database username/password if default values are not used.

# Database observations:

## Delete operation : It will be a good  practise to not delete data rows for delete operations but instead implement soft delete by adding additional column of type boolean to flag if the row is marked for deletion on all the tables. This will also maintain contrains rule defined on the tables. Physical delete may cause data inconsistency and hence soft delete option will support ACID (Atomicity, Consistency, Isolation, Durability) properties easly. 

## Audit: Implementing Audit table and recording all the actions performed on table will assist in life-cycle of data change and for what.

# Service improvements and observations:

## Implementing minimum level of security is advisable by forcing REst client to provide the following as minimum:
  a) Security information to identify if the client is authorised to make service calls and is allowed to make CRUD request on service.
  b) Passing user or client  identifier to capture events and audit , specially for modify and delete operations.
  c) A unique request id ( or transcation-token), so that multiple requests are not made by same transcation ( possibly happens when front end does not impelement multiple submission of same request, which happens usually when multiple user clicks submission from front-end)
 
 ## Implement standard Error codes and better naming of REst service url
 eg:
 @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful operation"),
            @ApiResponse(code = 202, message = "Invalid operation. missing/invalid values"),
            
    })
 ## Implement searching on multiple data items.
 
 ## Implementing composite Json object instead of expecting client to make calls to reference data ( lookups) to get to the actual values.
 
 
