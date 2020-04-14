


## Functional Requirements


| ID        | Description  |
| ------------- |:-------------:|
| FR1 | Insert/delete/update a gas station |
| FR2 | Report price change |
| FR3 | Compute the route to the station |
| FR4 | Research with filters (by price, type, distance) |
| FR5 | Login/out, register |
| FR6 | Plot the history of the prices |
| FR7 | Collect a gas station |
| FR8 | Manage the location of user and stations |

# Use case diagram and use cases
## Use case diagram
### Use case 1, UC1 – FR1 Insert a new gas station
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     |User U exists and has an account, station S doesn't exist |
|  Post condition     | S exists, S.price > 0 |
|  Nominal Scenario     | User inserts a new gas station and the related info about their fuels |
|  Variants     | Station already exists, issue warning |

##### Scenario 1.1
| Scenario 1.1 | |
| ------------- |:-------------:|
|  Precondition     | User has logged in his personal account |
|  Post condition     | A new gas station is added to the database |
| Step#        | Description  |
|  1     |  User selects the functionality to add a new station |
|  2     |  User inserts all the information about the gas station(name, fuels, prices )  |

### Use case 2, UC2 – FR1 Update a gas station
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     | User U exists and has an account, station S exists |
|  Post condition     | Station S changes its information |
|  Nominal Scenario     | User selects station S and update the gas station information |
|  Variants     |  |

##### Scenario 2.1
| Scenario 2.1 | |
| ------------- |:-------------:|
|  Precondition     | User has logged in his personal account |
|  Post condition     | An existing gas station has its information changed |
| Step#        | Description  |
|  1     |  User selects the gas station which he wants to update|
|  2     |  User inserts all the new information about the gas station  |


##### Scenario 2.2
| Scenario 2.2 | |
| ------------- |:-------------:|
|  Precondition     | User has logged in his personal account |
|  Post condition     | An existing gas station is notificated as a non more available |
| Step#        | Description  |
|  1     |  User selects the functionality to comunicate a gas station is not available |
|  2     |  User inserts the gas station  |


### Use case 3, UC3 – FR2 Report price change
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     | User U exists and has an account, Station S exists |
|  Post condition     | S.price > 0 |
|  Nominal Scenario     | User selects Station S, Price is inserted or changed  |
|  Variants     |  |

##### Scenario 3.1
| Scenario 3.1 | |
| ------------- |:-------------:|
|  Precondition     | User has logged in his personal account |
|  Post condition     | An existing gas station has its information changed |
| Step#        | Description  |
|  1     |  User selects the gas station which he wants to update|
|  2     |  User inserts all the new price about the gas station |

### Use case 4, UC4 – FR2 Compute the route to the station
| Actors Involved        | User, Map API |
| ------------- |:-------------:|
|  Precondition     | User U exists, Station S exists |
|  Post condition     | |
|  Nominal Scenario     | User U wants to know the stradal indications to go from his position to the gas station S  |
|  Variants     |  |

##### Scenario 4.1
| Scenario 4.1 | |
| ------------- |:-------------:|
|  Precondition     | User has logged in his personal account |
|  Post condition     | return the indications from user position to gas station position |
| Step#        | Description  |
|  1     |  User selects the gas station which he wants to go |
|  2     |  The system returns the route |

### Use case 5 UC5 – FR4 List of Gas Station with some information
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     | User exists |
|  Post condition     | |
|  Nominal Scenario     | User wants to know the list of gas stations with some features (ex. Price, type of fuel, distance,...) |
|  Variants     |  |

##### Scenario 5.1
| Scenario 5.1 | |
| ------------- |:-------------:|
|  Precondition     | User exists |
|  Post condition     | return the indications from user position to gas station position |
| Step#        | Description  |
|  1     |  User selects the information he needs about the gas stations  |
|  2     |  The system returns a list of gas station with the requested features |

### Use case 6 UC6 – FR5 Create an account
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     | User exists and he hasn’t an account |
|  Post condition     | User has an account |
|  Nominal Scenario     | User wants to access to user's privileges |
|  Variants     |  |

##### Scenario 6.1
| Scenario 6.1 | |
| ------------- |:-------------:|
|  Precondition     | User U exists |
|  Post condition     | User has a personal account |
| Step#        | Description  |
|  1     |  User selects the function to create a personal account  |
|  2     |  User inserts all his personal information |

### Use case 7 UC7 – FR5 Account access
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     | User exists and he has an account |
|  Post condition     |  |
|  Nominal Scenario     | User wants to access to his personal space on the platform |
|  Variants     |  |

##### Scenario 7.1
| Scenario 7.1 | |
| ------------- |:-------------:|
|  Precondition     | User U exists and has an account |
|  Post condition     | User accesses to his personal account |
| Step#        | Description  |
|  1     |  User selects the function to access to his personal account  |
|  2     |  User inserts his username and his password |

### Use case 8 UC8 – FR6 Plot the prices' history
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     | User exists |
|  Post condition     |  |
|  Nominal Scenario     | User wants to know how the prices of fuel changed |
|  Variants     |  |

##### Scenario 8.1
| Scenario 8.1 | |
| ------------- |:-------------:|
|  Precondition     | User U exists |
|  Post condition     |  |
| Step#        | Description  |
|  1     |  User selects the function to return the history related to a specific gas station  |
|  2     |  User selects the gas station |
|  3     |  The system returns a list that shows how the gas station's prices have changed  |

### Use case 9 UC9 – FR7 Track a gas station
| Actors Involved        | User |
| ------------- |:-------------:|
|  Precondition     | User exists and has an account |
|  Post condition     |  |
|  Nominal Scenario     | track a gas station and easly can be read by the user |
|  Variants     |  |

##### Scenario 9.1
| Scenario 9.1 | |
| ------------- |:-------------:|
|  Precondition     | User U exists |
|  Post condition     |  |
| Step#        | Description  |
|  1     |  User selects the function to track a specific gas station  |
|  2     |  User selects the gas station |

### Use case 10 UC10 – FR8 Manage the location of user and stations
| Actors Involved        | User, Map API |
| ------------- |:-------------:|
|  Precondition     | User exists, Station S exists |
|  Post condition     |  |
|  Nominal Scenario     | From a user or a gas station there can be able to calculate his position on the map |
|  Variants     |  |

##### Scenario 10.1
| Scenario 10.1 | |
| ------------- |:-------------:|
|  Precondition     | User U exists, Station S exists and has a location |
|  Post condition     |  |
| Step#        | Description  |
|  1     |  User selects the function to discover the position of a specific gas station  |
|  2     |  User selects the gas station |
|  3     |  The system returns the position  |
..
### Use case
